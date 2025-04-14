package com.hiideals.wishes

import com.springapp.Images
import org.springframework.web.multipart.MultipartFile

class ImageUploadService {

    def grailsApplication
    def userService

    def saveImages(MultipartFile dobFile, MultipartFile doaFile) {
    // Validate file size and format
    if (!validateFile(dobFile) || !validateFile(doaFile)) {
        return null
    }

    // Define the image storage path
    def stPaths = grailsApplication.config.jimagesFolder.toString() // Convert to String
    userService.createImagePath(stPaths)

    // Save DOB image
    def dobImageDetails = saveImage(dobFile, stPaths, "DOB")
    if (!dobImageDetails) {
        return null
    }

    // Save DOA image
    def doaImageDetails = saveImage(doaFile, stPaths, "DOA")
    if (!doaImageDetails) {
        return null
    }

    // Create a new Images instance and save it
    def imagesInstance = new Images(
        dobImageName: dobImageDetails.name,
        dobImagePath: dobImageDetails.path,
        doaImageName: doaImageDetails.name,
        doaImagePath: doaImageDetails.path
    )

    if (!imagesInstance.save(flush: true)) {
        // Log validation errors if the save fails
        imagesInstance.errors.allErrors.each { error ->
            println "Images Save Error: ${error}"
        }
        return null
    }

    return imagesInstance
}
    private Images saveImage(MultipartFile file, String stPaths, String imageType) {
        if (file && !file.empty) {
            // Generate a unique file name
            String fileName = "${System.currentTimeMillis()}_${imageType}_${file.originalFilename}"
            String filePath = stPaths + fileName

            try {
                // Save the file to the specified path
                file.transferTo(new File(filePath))
                println "File saved to: ${filePath}" // Debugging: Confirm file save

                // Create a new Images instance and save it
                Images image = new Images(name: file.originalFilename, imgpath: filePath)
                if (!image.save(flush: true)) {
                    // Log validation errors if the save fails
                    image.errors.allErrors.each { error ->
                        println "Image Save Error: ${error}"
                    }
                    return null
                }
                return image
            } catch (Exception e) {
                println "Error saving file: ${e.message}" // Debugging: Log any exceptions
                return null
            }
        } else {
            println "No file uploaded or file is empty." // Debugging: Confirm no file was uploaded
            return null
        }
    }

    private boolean validateFile(MultipartFile file) {
        // Check if the file is empty
        if (file.empty) {
            println "File is empty: ${file.originalFilename}"
            return false
        }

        // Check file size (10MB limit)
        if (file.size > 10 * 1024 * 1024) { // 10MB
            println "File size exceeds limit: ${file.originalFilename}"
            return false
        }

        // Check file format (JPEG or PNG)
        def allowedFormats = ['image/jpeg', 'image/png']
        if (!file.contentType || !allowedFormats.contains(file.contentType)) {
            println "Invalid file format or content type is null: ${file.originalFilename}"
            return false
        }

        return true
    }
}