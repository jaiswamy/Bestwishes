package com.sequro.register
import com.springapp.SecRole
import com.springapp.SecUser
import com.springapp.SecUserSecRole
import grails.plugin.springsecurity.annotation.Secured


@Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
class RegisterController {

	def simpleCaptchaService
	def springSecurityService
	def userService
	
	def index(){
		}
		def createUser(SecUser secUserInstance){
			    def userRole = null
				SecUser newUser = new SecUser()
				newUser.setUsername(params.username)
				newUser.setPassword(params.password)
				newUser.setEmail(params.email)
				newUser.setCity(params.City)
				newUser.setState(params.State)
				newUser.setPhoneno(params.Phonenumber)
				newUser.setEnabled(true)
				def user = SecUser.findByUsername(params.username);
				if(user!=null){
					print('user already exists')
					println ""+params
					flash.email = "User already exist"
						chain(controller:'register',action:'index',model:[secUserInstance:secUserInstance])
						return
				}
				newUser.save(flush: true)
				userRole = SecRole.findByAuthority('ROLE_USER') ?: new SecRole(authority: 'ROLE_USER').save(flush: true)
				
				if(!newUser.authorities.contains(userRole)){
					SecUserSecRole.create(newUser,userRole, true) ;
				}
	                     flash.emailverify=" Thanks for signing up"
	                   	redirect(controller:"register", action:"index");
	}

	/*def forgotPassword(){

		if (!request.post) {
			// show the form
			return
		}

		String username = params.username
		if (!username) {
			flash.message = "Please enter the username"
			redirect action: 'forgotPassword'
			return
		}

		def user = SecUser.findByUsername(username);


		if (!user) {
			flash.message = "Sorry! The user name does not exists in our records!"
			redirect action: 'forgotPassword'
			return
		}

		def registrationCode = new RegistrationCode(username: user.username)
		registrationCode.save(flush: true)

	//	String url = generateLink('resetPassword', [t: registrationCode.token])

		def emails = SecUser.findByUsername(params.username)


	//	flash.msg = "Password sent to your registered email address!"
		//TODO - SEND EMAIL NOTIFICATION.
	//	print '---'+ url;
		//[emailSent: true]
		
		try {
			//emailService.sendForgotPasswordMessageEmail(params.username, emails.email, "Forgot Password Link e-trucktax", url)
			//new EmailService().sendForgotPasswordMessageEmail(params.username, AppUtill.SUPPORT_EMAIL, emails.email, 'Forgot Password Link e-trucktax', url)
		} catch (Exception e) {
			e.printStackTrace()
		}

	}*/

	/*def resetPassword(ResetPasswordCommand command) {


		def token = params.t
		print token
		def registrationCode = token ? RegistrationCode.findByToken(token) : null
		//TODO -- display link expired page.
		if (!registrationCode) {
			flash.error = "Link Expired"
			//redirect( controller:"home", action:"index")
			return
		}

		if (!request.post) {
			return [token: token, command: new ResetPasswordCommand()]
		}

		command.username = registrationCode.username
		command.validate()

		if (command.hasErrors()) {

			if (command.errors!=null ) {
				def String errorMessage = '';
				for (def error: command.errors){

					if(error.toString().contains('missmatch')){
						println 'Passwords must match!'
						errorMessage =  errorMessage + ' Passwords must match!'

					}

					if(error.toString().contains('username')){
						println 'Password cannot be username!'
						errorMessage =  errorMessage + ' Password cannot be username!'

					}

					if(error.toString().contains('Insufficient')){
						println 'Password must be atleast 8 chars and should contain one capital and one special chararacter'
						errorMessage = 'Password must be atleast 8 chars and should contain one capital and one special chararacter!'
					}
					flash.message = errorMessage

					print error;
				}

			}
			//flash.message = "password missmatch!"
			return [token: token, command: command]
		}

		//String salt = saltSource instanceof NullSaltSource ? null : registrationCode.username
		RegistrationCode.withTransaction { status ->
			def user = SecUser.findByUsername(registrationCode.username);

			if (!user) {
				flash.error = "User not found"
				//redirect action: 'forgotPassword'
				return
			}
			user.password = command.password;
			user.save()
			registrationCode.delete()
			
		}
		
		springSecurityService.reauthenticate registrationCode.username

		flash.message = "Reset success";
		def user = SecUser.findByUsername(registrationCode.username);
		def emails=SecUser.findByUsername(user)
		
		try {
		//	emailService.sendPasswordSetSuccessEmail(user.username,emails.email, "password set successfully","/testmail/successfulsetpassword")
			//new EmailService().sendPasswordSetSuccessEmail('support@e-trucktax.com',user.username ,emails.email, "password set successfully")
		} catch (Exception e) {
			e.printStackTrace()
		}


		redirect action: 'resetPasswordSuccess'
	}*/

	


	
	static final passwordValidator = { String password, command ->
		if (command.username && command.username.equals(password)) {
			return 'Password cannot be username'
		}

		if (!checkPasswordMinLength(password, command) ||
		!checkPasswordMaxLength(password, command) ||
		!checkPasswordRegex(password, command)) {
			return 'Insufficient password strength'
		}
	}

	static boolean checkPasswordMinLength(String password, command) {

		int minLength = 8

		password && password.length() >= minLength
	}

	static boolean checkPasswordMaxLength(String password, command) {

		int maxLength =  64

		password && password.length() <= maxLength
	}

	static boolean checkPasswordRegex(String password, command) {

		String passValidationRegex = '^.*(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&]).*$'

		password && password.matches(passValidationRegex)
	}

	static final password2Validator = { value, command ->
		if (command.password != command.password2) {
			return 'Password is missmatch'
		}
	}


	/*def taxpreparer(SecUser taxpreparer){
		[params:params]
		//model:[tax:taxpreparer]

		println("------Tax Preparer Registration-------");

		//def taxpreparer = new SecUser();
		(username: username, password: password, email:email, selfemploy:selfemploy,
		 companyname:companyname,ein:ein,address1:address1, address2:address2,
		 city:city, state:state, zipcode:zipcode,
		 pname:pname, title:title,ptin:ptin, phoneno:phoneno).save(flush: true)
		//taxpreparer.username = params.username






		//redirect action:'createUser'//, params:params
		def preparer = new SecUser(username: username, password: password, email:email, selfemploy:selfemploy,
		 companyname:companyname,ein:ein,address1:address1, address2:address2,
		 city:city, state:state, zipcode:zipcode,
		 pname:pname, title:title,ptin:ptin, phoneno:phoneno).save(flush: true)

		println("------Tax Preparer------username,password")
	}
	
	
		def emailverify(){
		def user=SecUser.findByUsername(params?.id)
		user.enabled=true
		println"Email Send Start"
		//new EmailService().sendSuccessEmailverifyEmail('support@e-trucktax.com', user.username, user.email, 'Success! Email verification')
		println"Email Send End"
		user.save(flush:true,failOnError:true)
		springSecurityService.reauthenticate(user.username);
		flash.Emailmsg="Your email is successfully verified please login."
		redirect(controller:'login',action:'auth')
	}*/
	
	/*def invidateaccount(){
		  SecurityContextHolder.clearContext();
		  redirect(controller:'login',action:'auth')
	}*/
	
}



