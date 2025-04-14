package com.hiideals.main

import grails.plugin.springsecurity.SpringSecurityUtils


import grails.plugin.springsecurity.annotation.Secured


import com.springapp.Address
import com.springapp.Admin
import com.springapp.Images
import com.springapp.SecRole
import com.springapp.SecUser
import com.springapp.SecUserSecRole



@Secured(["ROLE_SUPERADMIN","ROLE_ADMIN","ROLE_USER","ROLE_VCADMIN","ROLE_DUSER"])
class SuperadminController {
	

	def userService
	
	
	def index() {
		
				def  usersInstanceList = Admin.list()
				[usersInstanceList:usersInstanceList]
			}


	def createadmin(){
		render(template:'adminFORM')
	}
	
	def currenuuserProfile (){
		def userimageIstance = Admin.findAll(userService.getCurrentAdmin())
		println("userimageIstance"+userimageIstance)
		model:[userimageIstance:userimageIstance]
	}
	def viewPimg(){
		def documentInstance
		if(SpringSecurityUtils.ifAllGranted("ROLE_ADMIN")){	
		 documentInstance = Admin.findAll(userService.getCurrentAdmin())
		}
		if(SpringSecurityUtils.ifAllGranted("ROLE_USER")){
			println("userService.getCurrentUser()  = "+userService.getCurrentusr())
			 documentInstance = Usercreation.findAll(userService.getCurrentUser())	
			 println(documentInstance)	
		}			
		def imgid = documentInstance.profilePic.id
		
		
		Images images = Images.get(imgid.getAt(0));

		if ( images == null) {
			flash.message = "image not found."
			redirect (action:'index')
		} else {
			def file = new File(images?.imgpath)
			def fileInputStream = new FileInputStream(file)
			def outputStream = response.getOutputStream()
			byte[] buffer = new byte[4096];
			int len;
			while ((len = fileInputStream.read(buffer)) > 0) {
				outputStream.write(buffer, 0, len);
			}
			outputStream.flush()
			outputStream.close()
			fileInputStream.close()
		}
}

	def viewimg(){
		
		Admin documentInstance = Admin.get(params.int('id'));
		if ( documentInstance == null) {
			flash.message = "image not found."
			redirect (action:'index')
		} else {
			def file = new File(documentInstance.profilePic.imgpath)
			def fileInputStream = new FileInputStream(file)
			def outputStream = response.getOutputStream()
			byte[] buffer = new byte[4096];
			int len;
			while ((len = fileInputStream.read(buffer)) > 0) {
				outputStream.write(buffer, 0, len);
			}
			outputStream.flush()
			outputStream.close()
			fileInputStream.close()
		}
	}

	def SaveAdmin(){
		def userexist=SecUser.findByUsername(params?.username)
		if(userexist){
			flash.message="This username Already Exist Please use different username"
			redirect(action:'index')
		}else{

			def userInstance= new SecUser()
			def adminRole = SecRole.findByAuthority('ROLE_ADMIN')
			userInstance.properties=params
			def admin=new Admin(params)
			
			
			def stPath = grailsApplication.config.juserPhotos?.toString()  // Convert to String
           userService.createImagePath(stPath)

			
				def file = request.getFile('file_1')
				if(file.getOriginalFilename()){   
					
				println("stPathstPath"+stPath)
				String s = stPath + file.getOriginalFilename()
				try{
					file.transferTo(new File(s))
				}catch(Exception e){}
				Images image = new Images(name:file.getOriginalFilename(),imgpath:s).save(flush:true)
				userInstance.setProfilePic(image)
				admin.setProfilePic(image)
			}
			
			admin.properties=params
			Address address=new Address(params)
			admin.setAddress(address.save(flush:true))
			
			
			
			userInstance.setAdminId(admin.save(flush:true))
			userInstance.save(flush:true,failOnError:true)
			admin.setUserId(userInstance)
			if(!userInstance.authorities.contains(adminRole)){
				new SecUserSecRole(userInstance, adminRole).save(flush:true,failOnError:true)
			}
			flash.message="Admin Created Successfully."
			redirect(action:'index')
		}
	}
	def adminEdit(){
		def usersInstance=Admin.findById(params?.userListid)
		render(template:'adminFORM',model:[usersInstance:usersInstance])
	}

	def updateAdmin(){
				
		def admin=Admin.findById(params?.userListid)
		def userInstance=SecUser.findById(admin.userId?.id)
		//println("userInstance ="+userInstance)
		
		
		
		
		admin.properties=params
		def address=Address.findById(admin.address?.id)
		address.properties=params
		def stPath = grailsApplication.config.userPhotos
		userService.createImagePath(stPath)
		
			def file = request.getFile('file_1')
			if(file.getOriginalFilename()){
			String s = stPath + file.getOriginalFilename()
			try{
				file.transferTo(new File(s))
			}catch(Exception e){}
			Images image = new Images(name:file.getOriginalFilename(),imgpath:s).save(flush:true)
			//userInstance.setProfilePic(image)
			admin.setProfilePic(image)
		}
			address.save(flush:true)
			userInstance.username=params.username
			userInstance.password=params.password
			userInstance.setAdminId(admin.save(flush:true))
			userInstance.save(flush:true,failOnError:true)
		
		//admin.save(flush:true)
		flash.message="Admin Updated Successfully."
		redirect(action:'index')
	}
	
	def createce(){}
}
