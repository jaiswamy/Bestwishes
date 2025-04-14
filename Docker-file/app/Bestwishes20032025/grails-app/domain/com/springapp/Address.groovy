package com.springapp

class Address {
	
	String pinCode
	String hsno
	String street
	String city
	String state
	String country

    static constraints = {
    pinCode nullable:true
		 hsno nullable:true
		 street nullable:true
		 city nullable:true
		 state nullable:true
		 country nullable:true
			
    }
}
