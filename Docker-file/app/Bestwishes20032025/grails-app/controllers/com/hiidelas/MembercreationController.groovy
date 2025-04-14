package com.hiidelas

import grails.plugin.springsecurity.annotation.Secured

import javax.validation.ValidationException


import com.hiideals.MembercreationService

import com.hiideals.io.Membercreation
import com.lowagie.text.*
import com.lowagie.text.pdf.*
import com.lowagie.text.Image
import java.io.ByteArrayOutputStream
import java.io.FileInputStream
import java.awt.Color
import java.nio.file.Files
import java.nio.file.Paths
import java.text.SimpleDateFormat

import java.io.File
import org.springframework.web.multipart.MultipartHttpServletRequest
import com.springapp.Address
import com.springapp.Admin
import com.springapp.Images
import com.springapp.SecRole
import com.springapp.SecUser
import com.springapp.SecUserSecRole

class MembercreationController {
	MembercreationService membercreationService
	def userService

	
	
@Secured(["ROLE_SUPERADMIN","ROLE_ADMIN","ROLE_USER","ROLE_VCADMIN","ROLE_DUSER"])
def index() {
	
		def usersInstanceList = Membercreation.findAllByAdminId(userService.getCurrentAdmin());
		model:[usersInstanceList: usersInstanceList]
	}



@Secured(["ROLE_SUPERADMIN","ROLE_ADMIN","ROLE_USER","ROLE_VCADMIN","ROLE_DUSER"])
def createUser(){
		render(template:'userFORM')
	}

@Secured(["ROLE_SUPERADMIN", "ROLE_ADMIN", "ROLE_USER", "ROLE_VCADMIN", "ROLE_DUSER"])
def saveUser() {
	println("Saving Member...")

	def membercreation = new Membercreation()
	membercreation.contactName = params.contactName
	membercreation.contactNo = params.contactNo
	membercreation.username = params.username
	membercreation.password = params.password
	membercreation.address = params.address
	membercreation.maritalStatus = params.maritalStatus
	def df = new SimpleDateFormat("dd/MM/yyyy") // Define the date format
	
	// If marital status is 'Unmarried', clear couplePhoto and dateOfAnniversary
	if (params.maritalStatus?.toLowerCase() == 'unmarried') {
		membercreation.dateOfAnniversary = null
		membercreation.couplePhoto = null
	} else {
		// Set dateOfAnniversary only if it's present
		if (params?.dateOfAnniversary) {
			membercreation.dateOfAnniversary = params.dateOfAnniversary
		}
	
		// couplePhoto should be handled if you're uploading (e.g., MultipartFile)
		if (request instanceof MultipartHttpServletRequest) {
			def couplePhotoFile = request.getFile('couplePhoto')
			if (couplePhotoFile && !couplePhotoFile.empty) {
				// Save photo or set it to a byte[], File, or path
				membercreation.couplePhoto = couplePhotoFile.bytes
			}
		}
	}
	
	// Set dateOfBirth if available
	if (params?.dateOfBirth) {
		membercreation.dateOfBirth = params.dateOfBirth
	}
	

	// Autogenerate membership number
	membercreation.membershipNo = membercreationService.generateMembershipNo()
	params.membershipNo = membercreation.membershipNo

	def userexist = SecUser.findByUsername(params?.username)
	if (userexist) {
		flash.message = "This username already exists. Please use a different username."
		redirect(action: 'index')
		return
	}

	def userInstance = new SecUser()
	def userRole = SecRole.findByAuthority('ROLE_VCADMIN')
	userInstance.properties = params

	// Image upload
	def stPath = grailsApplication.config.juserPhotos?.toString()
	userService.createImagePath(stPath)

	def file1 = request.getFile('file_1')
	if (file1 && file1.originalFilename) {
		def filePath1 = "${stPath}${System.currentTimeMillis()}_${file1.originalFilename}"
		try {
			file1.transferTo(new File(filePath1))
			def image1 = new Images(name: file1.originalFilename, imgpath: filePath1).save(flush: true)
			userInstance.setProfilePic(image1)
			membercreation.profilePic = image1
		} catch (Exception e) {
			log.error("Error uploading profile picture: ${e.message}", e)
		}
	}

	// Couple photo (optional)
	def file2 = request.getFile('file_2')
	if (file2 && file2.originalFilename) {
		def filePath2 = "${stPath}${System.currentTimeMillis()}_${file2.originalFilename}"
		try {
			file2.transferTo(new File(filePath2))
			def image2 = new Images(name: file2.originalFilename, imgpath: filePath2).save(flush: true)
			userInstance.setCouplePhoto(image2)
			membercreation.couplePhoto = image2
		} catch (Exception e) {
			log.error("Error uploading couple photo: ${e.message}", e)
		}
	}

	membercreation.setAdminId(userService.getCurrentAdmin())
	userInstance.setAdminId(userService.getCurrentAdmin())
	userInstance.save(flush: true, failOnError: true)
	membercreation.setUserId(userInstance)
	userInstance.setVuserId(membercreation)
	membercreation.save(flush: true, failOnError: true)

	if (!userInstance.authorities.contains(userRole)) {
		new SecUserSecRole(userInstance, userRole).save(flush: true, failOnError: true)
	}

	flash.message = "Member Created Successfully with Membership No: ${membercreation.membershipNo}."
	redirect(action: 'index')
}



@Secured(["ROLE_SUPERADMIN", "ROLE_ADMIN", "ROLE_USER", "ROLE_VCADMIN", "ROLE_DUSER"])
def downloadCertificate() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream()

    try {
        String imagePath = servletContext.getRealPath("/images/birthday.png")
        Image background = Image.getInstance(imagePath)

        Document document = new Document(new Rectangle(background.getWidth(), background.getHeight()))
        PdfWriter writer = PdfWriter.getInstance(document, outputStream)
        document.open()

        background.setAbsolutePosition(0, 0)
        document.add(background)

        def member = Membercreation.get(params.id)
        if (!member) throw new Exception("Member not found")

        PdfContentByte canvas = writer.getDirectContent()

        // Profile Picture (Slightly Higher)
        if (member?.profilePic?.imgpath) {
            String profilePicPath = member.profilePic.imgpath
            File profilePicFile = new File(profilePicPath)

            if (profilePicFile.exists()) {
                Image profilePic = Image.getInstance(profilePicPath)
                float profileSize = background.getWidth() * 0.22
                profilePic.scaleToFit(profileSize, profileSize)

                float centerX = (background.getWidth() - profileSize) / 2
                float centerY = (background.getHeight() / 2) + 60 

                profilePic.setAbsolutePosition(centerX, centerY)
                document.add(profilePic)
            }
        }

        // Name (Moved Further Down)
        Font nameFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 50, Color.DARK_GRAY)
        float textX = background.getWidth() / 2
        float textY = (background.getHeight() / 2) - 270 

        ColumnText.showTextAligned(
            canvas,
            Element.ALIGN_CENTER,
            new Phrase("${member.contactName}", nameFont),
            textX, textY, 0
        )

        document.close()

        byte[] pdfBytes = outputStream.toByteArray()
        member.pdfData = pdfBytes

        String pdfFileName = "${member.membershipNo}.pdf"
        String savePath = "/opt/greeting/birthdayPhotos/${pdfFileName}"

        File saveDir = new File("/opt/greeting/birthdayPhotos/")
        if (!saveDir.exists()) saveDir.mkdirs()

        Files.write(Paths.get(savePath), pdfBytes)
        member.birthdaypdfLink = "https://greetings.hiideals.com/greeting/membercreation/viewCertificate?fileName=${pdfFileName}"
        member.save(flush: true)

        response.contentType = "application/pdf"
        response.setHeader("Content-Disposition", "attachment; filename=${pdfFileName}")
        response.outputStream << pdfBytes
    } catch (Exception e) {
        response.status = 500
        render "Error generating PDF: ${e.message}"
    }
}


@Secured(["ROLE_SUPERADMIN", "ROLE_ADMIN", "ROLE_USER", "ROLE_VCADMIN", "ROLE_DUSER"])
def downloadCertificate2() {
	ByteArrayOutputStream outputStream = new ByteArrayOutputStream()

	try {
		String imagePath = servletContext.getRealPath("/images/anniversary.png")
		Image background = Image.getInstance(imagePath)

		Document document = new Document(new Rectangle(background.getWidth(), background.getHeight()))
		PdfWriter writer = PdfWriter.getInstance(document, outputStream)
		document.open()

		background.setAbsolutePosition(0, 0)
		document.add(background)

		def member = Membercreation.get(params.id)
		if (!member) throw new Exception("Member not found")

		PdfContentByte canvas = writer.getDirectContent()

		// Profile Picture (Slightly Higher)
		if (member?.couplePhoto?.imgpath) {
			String couplePhotoPath = member.couplePhoto.imgpath
			File couplePhotoFile = new File(couplePhotoPath)

			if (couplePhotoFile.exists()) {
				Image couplePhoto= Image.getInstance(couplePhotoPath)
				float profileSize = background.getWidth() * 0.22
				couplePhoto.scaleToFit(profileSize, profileSize)

				float centerX = (background.getWidth() - profileSize) / 2
				float centerY = (background.getHeight() / 2) + 60

				couplePhoto.setAbsolutePosition(centerX, centerY)
				document.add(couplePhoto)
			}
		}

		// Name (Moved Further Down)
		Font nameFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 50, Color.DARK_GRAY)
		float textX = background.getWidth() / 2
		float textY = (background.getHeight() / 2) - 270

		ColumnText.showTextAligned(
			canvas,
			Element.ALIGN_CENTER,
			new Phrase("${member.contactName}", nameFont),
			textX, textY, 0
		)

		document.close()

		byte[] pdfBytes = outputStream.toByteArray()
		member.pdfData = pdfBytes

		String pdfFileName = "${member.membershipNo}.pdf"
		String savePath = "/opt/greeting/anniversaryPhotos/${pdfFileName}"

		File saveDir = new File("/opt/greeting/anniversaryPhotos/")
		if (!saveDir.exists()) saveDir.mkdirs()

		Files.write(Paths.get(savePath), pdfBytes)
		member.anniversarypdfLink = "https://greetings.hiideals.com/greeting/membercreation/viewCertificate2?fileName=${pdfFileName}"
		member.save(flush: true)

		response.contentType = "application/pdf"
		response.setHeader("Content-Disposition", "attachment; filename=${pdfFileName}")
		response.outputStream << pdfBytes
	} catch (Exception e) {
		response.status = 500
		render "Error generating PDF: ${e.message}"
	}
}

	@Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
def viewCertificate() {
    String fileName = params.fileName
    String filePath = "/opt/greeting/birthdayPhotos/${fileName}"
    File file = new File(filePath)

    if (file.exists()) {
        response.contentType = "application/pdf"
        response.setHeader("Content-Disposition", "inline; filename=${fileName}")
        response.outputStream << file.bytes
    } else {
        response.status = 404
        render "Certificate not found"
    }
}


	@Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
def viewCertificate2() {
    String fileName = params.fileName
    String filePath = "/opt/greeting/anniversaryPhotos/${fileName}"
    File file = new File(filePath)

    if (file.exists()) {
        response.contentType = "application/pdf"
        response.setHeader("Content-Disposition", "inline; filename=${fileName}")
        response.outputStream << file.bytes
    } else {
        response.status = 404
        render "Certificate not found"
    }
}

	
	
@Secured(["ROLE_SUPERADMIN", "ROLE_ADMIN", "ROLE_USER", "ROLE_VCADMIN", "ROLE_DUSER"])
def userEdit() {
	def usersInstance = Membercreation.findById(params?.userListid);
	render(template: 'userFORM', model: [usersInstance: usersInstance]);
	
	
/*	// Handle Profile Picture Upload (file_1)
	def profilePic = request.getFile('file_1')
	if (profilePic && !profilePic.empty) {
		def profilePicPath = "E:/Workspace09092022/pragatirotary/uploadprofile/${usersInstance.id}_profile.jpg"
		profilePic.transferTo(new File(profilePicPath))
		usersInstance.profilePic = profilePicPath
	}

	// Handle Anniversary Image Upload (file_2)
	def couplePhoto = request.getFile('file_2')
	if (couplePhoto && !couplePhoto.empty) {
		def couplePhotoPicPath = "E:/Workspace09092022/pragatirotary/uploadanniversary/${usersInstance.id}_anniversary.jpg"
		couplePhoto.transferTo(new File(couplePhotoPath))
		usersInstance.couplePhoto = couplePhotoPath
	}
*/
}

@Secured(["ROLE_SUPERADMIN","ROLE_ADMIN","ROLE_USER","ROLE_VCADMIN","ROLE_DUSER"])
def viewimg() {
Membercreation documentInstance = Membercreation.get(params.int('id'))
if (documentInstance == null) {
	flash.message = "Image not found."
	redirect(action: 'index')
	return
}


def filePath = documentInstance.userId?.profilePic?.imgpath
if (!filePath) {
	flash.message = "Image path not set."
	redirect(action: 'index')
	return
}

def file = new File(filePath)
if (!file.exists()) {
	flash.message = "Image file does not exist."
	redirect(action: 'index')
	return
}

response.contentType = "image/jpeg" // Or use the actual MIME type if known
def fileInputStream = new FileInputStream(file)
def outputStream = response.getOutputStream()

try {
	byte[] buffer = new byte[4096]
	int len
	while ((len = fileInputStream.read(buffer)) > 0) {
		outputStream.write(buffer, 0, len)
	}
} catch (Exception e) {
	log.error("Error while streaming the image: ${e.message}", e)
} finally {
	fileInputStream.close()
	outputStream.flush()
	outputStream.close()
}
}


@Secured(["ROLE_SUPERADMIN","ROLE_ADMIN","ROLE_USER","ROLE_VCADMIN","ROLE_DUSER"])
def viewimg1() {
Membercreation documentInstance = Membercreation.get(params.int('id'))
if (documentInstance == null) {
	flash.message = "Image not found."
	redirect(action: 'index')
	return
}


def filePath = documentInstance.userId?.couplePhoto?.imgpath
if (!filePath) {
	flash.message = "Image path not set."
	redirect(action: 'index')
	return
}

def file = new File(filePath)
if (!file.exists()) {
	flash.message = "Image file does not exist."
	redirect(action: 'index')
	return
}

response.contentType = "image/jpeg" // Or use the actual MIME type if known
def fileInputStream = new FileInputStream(file)
def outputStream = response.getOutputStream()

try {
	byte[] buffer = new byte[4096]
	int len
	while ((len = fileInputStream.read(buffer)) > 0) {
		outputStream.write(buffer, 0, len)
	}
} catch (Exception e) {
	log.error("Error while streaming the image: ${e.message}", e)
} finally {
	fileInputStream.close()
	outputStream.flush()
	outputStream.close()
}
}

@Secured(["ROLE_SUPERADMIN", "ROLE_ADMIN", "ROLE_USER", "ROLE_VCADMIN", "ROLE_DUSER"])
def updateUser() {
	println("Updating Member...")

	def membercreation = Membercreation.get(params?.userListid)
	def userInstance = membercreation?.userId

	if (!membercreation || !userInstance) {
		flash.message = "User not found."
		redirect(action: 'index')
		return
	}

	// Assign updated values
	if (params.contactName) membercreation.contactName = params.contactName
	if (params.contactNo) membercreation.contactNo = params.contactNo
	if (params.username) userInstance.username = params.username
	if (params.password) userInstance.password = params.password
	if (params.address) membercreation.address = params.address
	if (params.maritalStatus) membercreation.maritalStatus = params.maritalStatus

	// Handle dateOfBirth (assumed to be Date type)
	if (params?.dateOfBirth) {
		membercreation.dateOfBirth = params.dateOfBirth
	}

	// Marital status logic
	if (params?.maritalStatus?.toLowerCase() == 'unmarried') {
		membercreation.dateOfAnniversary = null
		membercreation.couplePhoto = null
	} else {
		if (params?.dateOfAnniversary) {
			membercreation.dateOfAnniversary = params.dateOfAnniversary
		}
	}

	// Update profile image if uploaded
	def stPath = grailsApplication.config.juserPhotos?.toString()
	def file1 = request.getFile('file_1')
	if (file1 && file1.originalFilename) {
		def filePath1 = "${stPath}${System.currentTimeMillis()}_${file1.originalFilename}"
		try {
			file1.transferTo(new File(filePath1))
			def image1 = new Images(name: file1.originalFilename, imgpath: filePath1).save(flush: true)
			userInstance.setProfilePic(image1)
			membercreation.profilePic = image1
		} catch (Exception e) {
			log.error("Error uploading profile picture: ${e.message}", e)
		}
	}

	// Update couple image only if married and file is uploaded
	def file2 = request.getFile('file_2')
	if (params?.maritalStatus?.toLowerCase() != 'unmarried' && file2 && file2.originalFilename) {
		def filePath2 = "${stPath}${System.currentTimeMillis()}_${file2.originalFilename}"
		try {
			file2.transferTo(new File(filePath2))
			def image2 = new Images(name: file2.originalFilename, imgpath: filePath2).save(flush: true)
			userInstance.setCouplePhoto(image2)
			membercreation.couplePhoto = image2
		} catch (Exception e) {
			log.error("Error uploading couple photo: ${e.message}", e)
		}
	}

	// Save both objects
	userInstance.save(flush: true, failOnError: true)
	membercreation.save(flush: true, failOnError: true)

	flash.message = "Member updated successfully."
	redirect(action: 'index')
}

	def createce(){}
}


