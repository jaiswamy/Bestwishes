package com.springapp



class Admin {

	String username
	String password
	String email
	String phoneNo
	String smsSenderId
	String smsUsername
	Images profilePic	
	String smsPassword
	//boolean smsMode
	SecUser userId
	Address address
	Date dateCreated
	Date lastUpdated
	
    static constraints = {
    
		password nullable:true
		email nullable:true
		username nullable:true
		phoneNo nullable:true
		userId nullable:true
		dateCreated nullable:true
		profilePic	nullable:true	
		lastUpdated nullable:true
		smsSenderId  nullable:true
		smsUsername nullable:true
		address nullable:true
		smsPassword nullable:true
	
		
		}
}
