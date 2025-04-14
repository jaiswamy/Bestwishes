package com.hiideals.wishes

import grails.plugin.springsecurity.annotation.Secured

import com.hiideals.SSLHelper
import com.hiideals.SendWhatsAppImage
import com.hiideals.WhatsappLink
import com.hiideals.MembercreationService
import com.hiideals.birthdaySms
import com.hiideals.io.Membercreation

import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Secured(["ROLE_SUPERADMIN", "ROLE_ADMIN", "ROLE_USER", "ROLE_VCADMIN", "ROLE_DUSER"])
class BirthdayListController {
    
    MembercreationService membercreationService  // Injected Service
    def userService  // Ensure it's properly defined in resources.groovy

    private static final Logger log = LoggerFactory.getLogger(BirthdayListController)

    def index() {
        def birthdayListInstanceList = BirthdayList.findAllByAdminId(userService.getCurrentAdmin())
        [birthdayListInstanceList: birthdayListInstanceList]
    }

    def fetchTodayBirthdays() {
        def adminId = userService.getCurrentAdmin()
        def today = new Date().clearTime()

        log.debug("Admin ID: ${adminId}")
        log.debug("Today's Date: ${today}")

        // Fetch birthdays using the service
        def birthdayMembers = membercreationService.getTodayBirthdays(adminId, today)

        if (!birthdayMembers) {
            log.warn("No birthday members found for Admin ID: ${adminId}")
            render "No birthdays today."
            return
        }

        // WhatsApp message details
        String imageUrl = "https://whatsappdata.s3.ap-south-1.amazonaws.com/userMedia/4c07fe24771249c343e70c32289c1192/birthday_new.jpeg"
		
        // Send WhatsApp messages to each member
        birthdayMembers.each { member ->
            if (member?.contactNo && member?.membershipNo) {
               String phoneNumber = "91" + member.contactNo
                String membershipNo = member.membershipNo.toString()
                String certificateLink = member.birthdaypdfLink?.toString() ?: "N/A"
				 String contactName = member.contactName
				
                try {
                     SSLHelper.disableSSLVerification()  // Uncomment if needed
					// String messageVar = "Hello ${contactName}  Thank you for contacting Ideals Technology Pvt Ltd ${certificateLink}"
			// String testResponse = WhatsappLink.sendMessage("https://greetings.hiideals.com/greeting/membercreation/viewCertificate?fileName=certificate_MB004.pdf", "918073492977");
					
					
					  WhatsappLink.sendMessageWithDocument(contactName, certificateLink, phoneNumber)
                     //WhatsappLink.sendMessage(messageVar, phoneNumber)
                     //SendWhatsAppImage.sendMessage(imageUrl, membershipNo, phoneNumber)
                    log.debug("WhatsApp message sent to: ${phoneNumber}, Membership No: ${membershipNo}")
               
					// Send SMS
					def birthdaySms = new birthdaySms()
					def message = "Dear Customer, Your Reward points ${phoneNumber} are credited to your account. Total Balance: ${certificateLink} - IDEA TRADERS."

					//String response = birthdaySms.sendSms(phoneNumber, message)
					log.debug("SMS API Response: ${response}")
					
					 } catch (Exception e) {
                    log.error("Failed to send WhatsApp message to ${phoneNumber}: ${e.message}", e)
                }
            } else {
                log.warn("Skipping WhatsApp message. No contact number or membership number for: ${member?.name}")
            }
        }

        render(template: '/birthdayList/birthdaysTable', model: [birthdayMembers: birthdayMembers])
    }
}
