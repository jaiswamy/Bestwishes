package com.hiideals.wishes

import com.hiideals.io.Membercreation


import com.springapp.Admin;
import com.springapp.SecUser;

class BirthdayList {
    Membercreation memberDetail
            
	Admin adminId
	SecUser userId
	
    // Constraints to validate the inputs
    static constraints = {
		memberDetail nullable: false, blank: false      
		userId nullable: true
		
    }
}
