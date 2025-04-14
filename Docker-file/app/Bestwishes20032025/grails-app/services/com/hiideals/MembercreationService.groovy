package com.hiideals

import com.hiideals.io.Membercreation

class MembercreationService {
	
		String generateMembershipNo() {
			def lastMember = Membercreation.find("from Membercreation order by membershipNo desc")
			if (lastMember?.membershipNo) {
				// Extract the last 3 digits, increment by 1
				String lastSequence = lastMember.membershipNo[-3..-1]
				Integer newSequence = (lastSequence as Integer) + 1
				return String.format("MB%03d", newSequence)
			} else {
				// Start from MB001 if no records exist
				return "MB001"
			}
		}
		def getTodayBirthdays(adminId, today) {
			log.debug("Fetching birthdays for Admin ID: ${adminId}, Date: ${today}")
			return Membercreation.createCriteria().list {
				eq('adminId', adminId)
				sqlRestriction("DAY(date_of_birth) = DAY(?) AND MONTH(date_of_birth) = MONTH(?)", [today, today])
			}
		}
	
		def saveMembercreation(Membercreation membercreation) {
			membercreation.membershipNo = generateMembershipNo()
			membercreation.save(flush: true)
		}
	}
	
