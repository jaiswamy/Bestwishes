package com.hiideals.wishes

import grails.converters.JSON


import java.nio.file.Paths

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException

import java.nio.file.Path

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.multipart.MultipartFile

import com.hiideals.MembercreationService
import com.hiideals.io.Membercreation
import com.hiideals.wishes.ImageUpload;
import com.springapp.Admin
import com.springapp.Images
import com.springapp.SecUser
import com.sun.java.swing.plaf.windows.TMSchema.Part

@Secured(["ROLE_SUPERADMIN", "ROLE_ADMIN", "ROLE_USER", "ROLE_VCADMIN", "ROLE_DUSER"])
class ImageUploadController {
    MembercreationService membercreationService
    def userService
	def imageUploadService
	
    private static final Logger log = LoggerFactory.getLogger(ImageUploadController)

   


    def imageUploadFORM() {
        def memberList = Membercreation.findAllByAdminId(userService.getCurrentAdmin())
        log.debug("Member list: ${memberList}")
        [memberList: memberList]
    }
	def uploadImage() {
    def uploadedFile = request.getFile('image') // Get the uploaded file
    if (uploadedFile && !uploadedFile.empty) {
        String uploadDir = grailsApplication.config.imageUploadDir // Directory to save the image
        File dir = new File(uploadDir)
        if (!dir.exists()) {
            dir.mkdirs()
        }
        String filePath = "${uploadDir}/${uploadedFile.originalFilename}"
        uploadedFile.transferTo(new File(filePath)) // Save the file

        // Update the database with the file path
        def instance = new ImageUpload(dobImage: filePath) // or doaImage
        instance.save(flush: true, failOnError: true)
    } else {
        flash.message = "No file uploaded or file is empty"
    }
}

    def edit(Long id) {
       log.debug("Edit action triggered with id: ${id}")

       if (!id) {
           render(status: 400, text: "Loan ID is missing!")
           return
       }

       def imageUploadInstance = ImageUpload.get(id)
       if (!imageUploadInstance) {
           render(status: 404, text: "Short Term Loan not found with ID: ${id}")
           return
       }

       render(template: 'editForm', model: [imageUploadInstance: imageUploadInstance])
   }

    def delete() {
    def imageInstance = Images.get(params.id)
    if (imageInstance) {
        imageInstance.delete(flush: true)
        flash.message = "Image deleted successfully."
    } else {
        flash.message = "Image not found."
    }
    redirect(action: "index")
}


     def update() {
       def imageUploadInstance = ImageUpload.get(params.id)
       if (!imageUploadInstance) {
           render(contentType: 'application/json') {
               success = false
               message = "Short-term loan not found."
           }
           return
       }

       imageUploadInstance.properties = params

       if (imageUploadInstance.save(flush: true)) {
           render(contentType: 'application/json') {
               success = true
               message = "Loan details updated successfully!"
               loan = [
                   id: imageUploadInstance.id,
                membershipNo: imageUploadInstance.memberDetail?.membershipNo,
               
               ]
           }
       } else {
           render(contentType: 'application/json') {
               success = false
               message = "Failed to update loan details."
               errors = imageUploadInstance.errors.allErrors.collect { g.message(error: it) }
           }
       }
    }


	def show() {
    def filePath = params.path
    File file = new File(filePath)
    if (file.exists()) {
        response.contentType = "image/jpeg" // or the appropriate content type
        response.outputStream << file.bytes
        response.outputStream.flush()
    } else {
        log.warn("File not found: ${filePath}")
        render(status: 404, text: "File not found")
    }
}

	
    def getUserDetails() {
        log.debug("getUserDetails called with params: ${params}")

        def memberId = params.long('value')
        def memberDetails = Membercreation.createCriteria().get {
            eq('id', memberId)
            eq('adminId', userService.getCurrentAdmin())
        }

        if (!memberDetails) {
            log.warn("No member details found for id: ${memberId}")
            render(status: 404, text: "Member not found")
            return
        }

        render(template: 'userDetails', model: [userdet: memberDetails])
    } 

	
	
	
	/*def stPaths = grailsApplication.config.imagesFolder
	
	// Upload PDC Certificate
	def pdcCertificateFile = request.getFile("pdcCertificate")
	if (pdcCertificateFile.getOriginalFilename()) {
		String pdcCertificatePath = stPaths + imageUploadInstance.apllicationNo + "_(PDC Certificate)_" + pdcCertificateFile.getOriginalFilename()
		try {
			pdcCertificateFile.transferTo(new File(pdcCertificatePath))
			Images pdcCertificate = new Images(name: pdcCertificateFile.getOriginalFilename(), imgpath: pdcCertificatePath).save(flush: true)
			formDetailInstance.pdcCertificate = pdcCertificate
		} catch (Exception e) {
			println("Error uploading PDC Certificate: ${e.message}")
		}
	}
	// new single image
	def dobImage = request.getFile("dobImage")
	if (dobImage.getOriginalFilename()){

		String s = stPaths + imageUploadInstance +"(dobImage)_" + dobImage.getOriginalFilename()
		try{
			dobImage.transferTo(new File(s))
		}catch(Exception e){}
		Images image = new Images(name:dobImage.getOriginalFilename(),imgpath:s).save(flush:true)
		imageUploadInstance.setdobImage(image)
	}
*/
	
	
	
	def save() {
    log.debug("Save method called with params: ${params}")

    if (!request.contentType?.contains("multipart/form-data")) {
        flash.message = "Invalid request. Please upload files."
        render(view: "index")
        return
    }

    try {
        def dobFile = request.getFile('dobFile')  // Retrieve DOB file
        def doaFile = request.getFile('doaFile')  // Retrieve DOA file
        String uploadSource = params.uploadSource ?: "form_upload"

        if (!dobFile?.empty && !doaFile?.empty) {
            byte[] dobImageBytes = dobFile.bytes
            byte[] doaImageBytes = doaFile.bytes
            String dobImageType = dobFile.contentType
            String doaImageType = doaFile.contentType
            String dobImageName = dobFile.originalFilename
            String doaImageName = doaFile.originalFilename

            def imagesInstance = new Images(
                name: params.name ?: "Uploaded Image",  // Default value if name is missing
                dobImage: dobImageBytes,
                doaImage: doaImageBytes,
                dobImageType: dobImageType,
                doaImageType: doaImageType,
                dobImageName: dobImageName,
                doaImageName: doaImageName,
                uploadSource: uploadSource
            )

            if (imagesInstance.save(flush: true)) {
                log.debug("Images saved successfully: ${imagesInstance.id}")
                flash.message = "Images uploaded successfully"
                redirect(action: "index")
                return
            } else {
                log.error("Failed to save images: ${imagesInstance.errors}")
                render(view: "index", model: [imageUploadInstance: imagesInstance])
            }
        } else {
            flash.message = "Please upload both DOB and DOA images."
        }
    } catch (Exception e) {
        log.error("Error during file upload: ${e.message}", e)
        flash.message = "Error during file upload: ${e.message}"
        render(view: "index")
    }
}
 



   def index() {
    def imageList = Images.findAllByUploadSource("form_upload") // Fetch only form-uploaded images
    log.debug("Fetched ${imageList.size()} images from the database uploaded via the form.")

    if (imageList.isEmpty()) {
        flash.message = "No images found from this form."
    }

    [imageList: imageList]
}



	

    def viewimg() {
    log.debug("Fetching image with ID: ${params.int('id')}, Type: ${params.type}")

    def imageInstance = Images.get(params.int('id'))
    if (!imageInstance) {
        flash.message = "Image not found."
        redirect(action: 'index')
        return
    }

    byte[] imageBytes
    String contentType

    if (params.type == 'dob') {
        imageBytes = imageInstance.dobImage
        contentType = imageInstance.dobImageType
    } else if (params.type == 'doa') {
        imageBytes = imageInstance.doaImage
        contentType = imageInstance.doaImageType
    } else {
        flash.message = "Invalid image type."
        redirect(action: 'index')
        return
    }

    if (imageBytes) {
        response.contentType = contentType
        response.outputStream << imageBytes
        response.outputStream.flush()
    } else {
        flash.message = "Image data not found."
        redirect(action: 'index')
    }
}





}

