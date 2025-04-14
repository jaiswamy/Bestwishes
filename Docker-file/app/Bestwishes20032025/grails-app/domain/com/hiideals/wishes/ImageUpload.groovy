package com.hiideals.wishes

import com.hiideals.io.Membercreation
import com.springapp.Admin;
import com.springapp.Images
import com.springapp.SecUser;

class ImageUpload {
    Membercreation memberDetail
    Admin adminId
    SecUser userId

    Images dobImage  
   Images doaImage  
    
    static constraints = {
        memberDetail nullable: false
        adminId nullable: true
        userId nullable: true
        dobImage nullable: true
        doaImage nullable: true
        
    }
}
