package com.hiideals.main

import grails.plugin.springsecurity.SpringSecurityUtils
import grails.plugin.springsecurity.annotation.Secured

@Secured(["ROLE_ADMIN","ROLE_SUPERADMIN","ROLE_USER","ROLE_VCADMIN","ROLE_DUSER"])
class MainPageController {
	def SpringSecurityService
	
    def index() {
		if(SpringSecurityUtils.ifAnyGranted("ROLE_ADMIN")){
			redirect(controller:'membercreation',action:'index')
		}
		
		else if(SpringSecurityUtils.ifAnyGranted("ROLE_SUPERADMIN")){
		redirect(controller:'superadmin',action:'index')
		}
		
		else if(SpringSecurityUtils.ifAnyGranted("ROLE_USER")){
			redirect(controller:'superadmin',action:'indexx')
			}
		else if(SpringSecurityUtils.ifAnyGranted("ROLE_VCADMIN")){
			redirect(controller:'superadmin',action:'indexx')
			}
		else if(SpringSecurityUtils.ifAnyGranted("ROLE_DUSER")){
			redirect(controller:'superadmin',action:'indexx')
			}

		else{
		redirect(controller:'login',action:'auth')
		}
	}
}
