   package com.hiideals.io

import com.springapp.Address
import com.springapp.Admin
import com.springapp.Images
import com.springapp.SecUser

class Membercreation {
    String membershipNo
    String contactName
    String contactNo
    String username
    String password
	String maritalStatus
    Date dateOfBirth
    Date dateOfAnniversary
    String address  
    Admin adminId
    SecUser userId
    Date dateCreated
    Date lastUpdated
    Images profilePic
	Images couplePhoto
	String birthdaypdfLink  // Stores PDF file name
	String anniversarypdfLink
	byte[] pdfData  // Stores binary PDF content


    static constraints = {
        membershipNo nullable: false, unique: true
        contactName nullable: false
        contactNo nullable: false
        username nullable: true
        password nullable: true
		maritalStatus nullable: true
        dateOfBirth nullable: true
        dateOfAnniversary nullable: true
        address nullable: true    
        userId nullable: true
        dateCreated nullable: true
        lastUpdated nullable: true
        profilePic nullable: true
		couplePhoto nullable: true
		pdfData nullable: true, maxSize: 10485760  // 10 MB limit
		birthdaypdfLink nullable: true
		anniversarypdfLink nullable: true
    }

    def beforeInsert() {
        // Generate membership number in the format MB001, MB002, etc.
        membershipNo = generateMembershipNo()
    }

    private String generateMembershipNo() {
        // Retrieve the latest (maximum) membershipNo in the "MB001" format
        def lastMemberNo = Membercreation.createCriteria().get {
            projections {
                max("membershipNo")
            }
        } as String

        if (lastMemberNo) {
            // Extract numeric part and increment it
            int lastNumber = lastMemberNo[2..-1].toInteger()
            String newNumber = String.format("%03d", lastNumber + 1)
            return "MB" + newNumber
        } else {
            // Start with "MB001" if no membership numbers exist
            return "MB001"
        }
    }
}
