package com.hiideals.wishes

class UserService {

    def createImagePath(String path) {
        def folder = new File(path)
        if (!folder.exists()) {
            if (folder.mkdirs()) {
                println "Created directory: ${path}"
            } else {
                println "Failed to create directory: ${path}"
                throw new RuntimeException("Failed to create directory: ${path}")
            }
        } else {
            println "Directory already exists: ${path}"
        }
    }
}