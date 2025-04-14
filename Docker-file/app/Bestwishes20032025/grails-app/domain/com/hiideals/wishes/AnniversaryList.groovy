package com.hiideals.wishes

import com.hiideals.io.Membercreation

import com.hiideals.wishes.ImageUpload  // Import the ShortTermLoan class
import com.hiideals.wishes.BirthdayList   // Import the LongTermLoan class

class AnniversaryList {
	
	Membercreation memberDetail   // Reference to member
	         
	
	
	static belongsTo = [memberDetail: Membercreation]
	
	static constraints = {
		memberDetail nullable: false, blank: false
		
		
	}
}
