import com.springapp.SecRole
import com.springapp.SecUser
import com.springapp.SecUserSecRole

class BootStrap {

    def init = { servletContext ->
		
		def superadminRole = SecRole.findByAuthority('ROLE_SUPERADMIN') ?: new SecRole(authority: 'ROLE_SUPERADMIN').save(flush: true)
		def adminRole = SecRole.findByAuthority('ROLE_ADMIN') ?: new SecRole(authority: 'ROLE_ADMIN').save(flush: true)
		def userRole = SecRole.findByAuthority('ROLE_USER') ?: new SecRole(authority: 'ROLE_USER').save(flush: true)
		def vcadminRole = SecRole.findByAuthority('ROLE_VCADMIN') ?: new SecRole(authority: 'ROLE_VCADMIN').save(flush: true)
		def downloaduserRole = SecRole.findByAuthority('ROLE_DUSER') ?: new SecRole(authority: 'ROLE_DUSER').save(flush: true)
		
		def superadmin = SecUser.findByUsername("superadmin") ?: new SecUser(username: 'superadmin', password: 'EnD0MeT@!T!S').save(flush: true)
	    def admin = SecUser.findByUsername("admin") ?: new SecUser(username: 'admin', password: '@dminENd0MEtRIT!S ').save(flush: true)
	    def user = SecUser.findByUsername("user")?: new SecUser(username: 'user', password: 'UserENDOMETRITIS ').save(flush: true)
		def vcadmin = SecUser.findByUsername("vcadmin") ?: new SecUser(username: 'vcadmin', password: '@dminENd0MEtRIT!S ').save(flush: true)
		def downloaduser = SecUser.findByUsername("downloaduser")?: new SecUser(username: 'downloaduser', password: 'UserENDOMETRITIS ').save(flush: true)
			 
			 if(!admin.authorities.contains(adminRole)){
				 SecUserSecRole.create(admin,adminRole)
			 }
			 if(!user.authorities.contains(userRole)){
				 SecUserSecRole.create(user,userRole)
			 }
			 if(!superadmin.authorities.contains(superadminRole)){
				 SecUserSecRole.create(superadmin,superadminRole)
			 }
			 if(!vcadmin.authorities.contains(vcadminRole)){
				 SecUserSecRole.create(vcadmin,vcadminRole)
			 }
			 if(!downloaduser.authorities.contains(downloaduserRole)){
				 SecUserSecRole.create(downloaduser,downloaduserRole)
			 }

    }
    def destroy = {
    }
}
