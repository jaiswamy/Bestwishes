
package com.hiideals.wishes

import com.hiideals.MembercreationService

import com.hiideals.SSLHelper
import com.hiideals.SendWhatsAppImage
import com.hiideals.WhatsappLink


import com.hiideals.SendWhatsAppImage

import grails.plugin.springsecurity.annotation.Secured

import com.hiideals.io.Membercreation
import com.hiideals.wishes.AnniversaryList;

import grails.validation.ValidationException
import grails.converters.JSON
import grails.transaction.Transactional

@Secured(["ROLE_SUPERADMIN","ROLE_ADMIN","ROLE_USER","ROLE_VCADMIN","ROLE_DUSER"])
class AnniversaryListController {
    MembercreationService membercreationService
    def userService
     def birthdaySms
    def index() {
        def monthlyCollectionInstanceList = AnniversaryList.list(sort: 'id', order: 'desc')
        [monthlyCollectionInstanceList: monthlyCollectionInstanceList]
    }
/*	def fetchTodayAnniversaries() {
    def today = new Date().clearTime()
    def adminId = userService.getCurrentAdmin()

    // Fetch members whose anniversary matches today (ignoring year)
    def anniversaryMembers = Membercreation.createCriteria().list {
        eq('adminId', adminId)
        sqlRestriction("DAY(date_of_anniversary) = DAY(?) AND MONTH(date_of_anniversary) = MONTH(?)", [today, today])
    }

    log.debug("Today's Anniversaries: ${anniversaryMembers}")

    render(template: '/anniversaryList/anniversariesTable', model: [anniversaryMembers: anniversaryMembers])
}
*/
	
	def fetchTodayAnniversaries() {
		def today = new Date().clearTime() // Get today's date with time cleared
		def adminId = userService.getCurrentAdmin() // Get the current admin's ID
	
		// Log today and adminId for debugging
		log.debug("Admin ID: ${adminId}")
		log.debug("Today's Date: ${today}")
	
		// Fetch members whose anniversary matches today (ignoring year)
		def anniversaryMembers = Membercreation.createCriteria().list {
			eq('adminId', adminId)
			sqlRestriction("DAY(date_of_anniversary) = DAY(?) AND MONTH(date_of_anniversary) = MONTH(?)", [today, today])
		}
	
		log.debug("Today's Anniversaries: ${anniversaryMembers}")
	
		// Check if any members were found
		if (!anniversaryMembers) {
			log.error("No anniversary members found.")
			render "Failed to fetch anniversaries. Please try again."
			return
		}
	
		// WhatsApp message details
		String imageUrl = "https://whatsappdata.s3.ap-south-1.amazonaws.com/userMedia/4c07fe24771249c343e70c32289c1192/birthday_new.jpeg"
	
		// Send WhatsApp messages to each member
		anniversaryMembers.each { member ->
			if (member?.contactNo && member?.membershipNo) {
				String phoneNumber = "91" + member.contactNo // Format the phone number
				String membershipNo = member.membershipNo.toString() // Ensure it's a string
				String certificateLink = member.anniversarypdfLink?.toString() ?: "N/A"
				String contactName = member.contactName

				try {
					SSLHelper.disableSSLVerification()  // Uncomment if needed
					  WhatsappLink.sendMessageWithDocument(contactName, certificateLink, phoneNumber)
					//SendWhatsAppImage.sendMessage(imageUrl, membershipNo, phoneNumber)
					log.debug("WhatsApp message sent to: ${phoneNumber}, Membership No: ${membershipNo}")
				} catch (Exception e) {
					log.error("Failed to send WhatsApp message to ${phoneNumber}: ${e.message}", e)
				}
			} else {
				log.warn("Skipping WhatsApp message. No contact number or membership number for: ${member?.name}")
			}
		}
	
		// Render the anniversaries table
		render(template: '/anniversaryList/anniversariesTable', model: [anniversaryMembers: anniversaryMembers])
	}
	
	
	
	

    def showImage(Long id) {
        def monthlyCollectionInstance = AnniversaryList.get(id)
        if (monthlyCollectionInstance && monthlyCollectionInstance.image) {
            response.contentType = "image/jpeg"
            response.outputStream << monthlyCollectionInstance.image
            response.outputStream.flush()
        } else {
            render(status: 404, text: 'Image not found')
        }
    }
}

