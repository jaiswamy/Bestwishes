class UrlMappings {
	
	   
			static mappings = {
				"/$controller/$action?/$id?(.$format)?" {
					constraints {
						// apply constraints here
					}
				}
		
			// Main Page
			"/"(controller: "mainPage")
	
			// Error pages
			"500"(view: '/error')
	
			// Custom mappings
			"/Super@dm!n"(controller: 'superadmin', action: 'index')
			"/Dashboard"(controller: 'superadmin', action: 'indexx')
			"/register"(controller: 'register', action: 'index')
	
			// User creation mappings
			"/Usercreates"(controller: 'usercreate', action: 'index')
			"/ViewerUsercreates"(controller: 'viewerUsercreate', action: 'viewerIndex')
			"/image/view/$id/$type"(controller: "imageUpload", action: "viewimg")
			
			// Admin creation mappings
			"/memberCreates"(controller: 'membercreation', action: 'index')
	
		   
			// Specific user and viewer lists
			"/Specificuserlist"(controller: 'inwardform', action: 'userlist')
			"/SpecificViewerlist"(controller: 'inwardform', action: 'viewerList')
	
			// Reports
			"/ApprovedList"(controller: 'report', action: 'approved')
			"/PendingList"(controller: 'report', action: 'pending')
			"/ClosedList"(controller: 'report', action: 'closed')
	
			// ShortTermLoan mappings
			"/BirtdayWishes/SaveImageUpload"(controller: "imageUpload", action: "save")
			"/imageUpload"(controller: 'imageUpload', action: 'index')
			"/imageUploadForm"(controller: 'imageUpload', action: 'create')
			"/SaveimageUpload"(controller: 'imageUpload', action: 'save')
			"/imageUpload/edit/$id"(controller: 'imageUpload', action: 'edit')
		
			// birthday mappings
			"/Birthday/fetchTodayBirthdays"(controller: "birthdayList", action: "fetchTodayBirthdays")
			"/birthdayCertificate/$fileName"(controller: "birthdayCertificate", action: "show")
			"/anniversaryCertificate/$fileName"(controller: "anniversaryCertificate", action: "show")
	
			
		   // Mapping for fetching birthdays
			"/Birthday"(controller: 'birthdayList', action: 'index')
			"/BirthdayForm"(controller: 'birthdayList', action: 'create')
			"/SaveBirthday"(controller: 'birthdayList', action: 'save')
			"/Birthday/edit/$id"(controller: 'birthdayList', action: 'edit')
			"/Birthday/delete/$id?"(controller: "birthdayList", action: "delete")
			
			//monthlyCollection
			"/anniversary"(controller: 'anniversaryList', action: 'index')
			"/anniversaryForm"(controller: 'anniversaryList', action: 'create')
			"/anniversarySave"(controller: 'anniversaryList', action: 'save')
			"/birthday/downloadCertificate"(controller: "membercreation", action: "downloadCertificate")
			"/anniversary/downloadCertificate"(controller: "membercreation", action: "downloadCertificate2")
			"/membercreation/generateAndSavePdf"(controller: "membercreation", action: "generateAndSavePdf")
			
		   "/viewCertificate/$fileName"(controller: "membercreation", action: "viewCertificate")
			"/viewCertificate2/$fileName"(controller: "membercreation", action: "viewCertificate2")
			
			
	
			
	
			}
	}
	