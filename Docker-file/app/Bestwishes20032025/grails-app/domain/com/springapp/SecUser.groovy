package com.springapp




import com.hiideals.io.Membercreation






class SecUser implements Serializable {

	private static final long serialVersionUID = 1

	transient springSecurityService

	String username
	String password
	Images profilePic
	Images couplePhoto
	Admin adminId
	
	Membercreation vuserId

	String city
	String state
	String email
	String phoneno
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	SecUser(String username, String password) {
		this()
		this.username = username
		this.password = password
	}

	@Override
	int hashCode() {
		username?.hashCode() ?: 0
	}

	@Override
	boolean equals(other) {
		is(other) || (other instanceof SecUser && other.username == username)
	}

	@Override
	String toString() {
		username
	}

	Set<SecRole> getAuthorities() {
		SecUserSecRole.findAllBySecUser(this)*.secRole
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}

	static transients = ['springSecurityService']

	static constraints = {
		username blank: true, unique: true
		password blank: true
		couplePhoto nullable:true
		profilePic nullable:true
		profilePic nullable:true
		adminId nullable:true
		city nullable:true
		state nullable:true
		phoneno nullable:true
		email nullable:true
		
		vuserId nullable:true
		
	}

	static mapping = {
		password column: '`password`'
	}
}
