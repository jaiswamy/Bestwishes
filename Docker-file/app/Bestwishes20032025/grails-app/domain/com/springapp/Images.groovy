package com.springapp

	
	import java.util.Date;
	
	class Images {
	
		//String name
		String imgpath
		Date dateCreated
		Date lastUpdated
		String name = "Uploaded Image"  // Default value
		byte[] dobImage
		byte[] doaImage
		String dobImageType
		String doaImageType
		String dobImageName
		String doaImageName
		String uploadSource
		
		static constraints = {
			name nullable:true
			imgpath nullable:true
			dateCreated nullable:true
			lastUpdated nullable:true
			dobImage nullable: true, maxSize: 10485760  // 10MB
			doaImage nullable: true, maxSize: 10485760  // 10MB
			dobImageType nullable: true
			doaImageType nullable: true
			dobImageName nullable: true
			doaImageName nullable: true
			uploadSource nullable: true
		}
	}
	
    
