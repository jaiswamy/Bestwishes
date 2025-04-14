package com.hiideals;

import java.net.HttpURLConnection;

import java.net.URL;

public class SendWhatsAppImage {

    // Method to send WhatsApp message with an image
    public static void sendMessage(String imageUrl, String membershipNo, String phoneNumber) {
        try {
            // Webbx API URL
            String apiUrl = "https://sent.wbbox.in/pinwa/pinwav1.php"; // Webbx API Endpoint
            String apiKey = "9c61e7b7-36cb-11ef-ad4f-92672d2d0c2d"; // API Key
            String fromPhoneNumber = "918788389212"; // Sender phone number
            String templateId = "725799"; // Template ID

            // Construct Query Parameters
            String jsonPayload = "apikey=" + apiKey 
                    + "&from=" + fromPhoneNumber 
                    + "&to=" +phoneNumber
                    + "&type=template"
                    + "&templateid=" + templateId
                   // + "&placeholders=" +applicationNo
                    + "&url=" + "https://whatsappdata.s3.ap-south-1.amazonaws.com/userMedia/4c07fe24771249c343e70c32289c1192/birthday_new.jpeg";

            // Create Connection
            URL url = new URL(apiUrl + "?" + jsonPayload);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");  // Using GET since parameters are in the URL
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setDoOutput(true);

            
    
            // Read Response
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("WhatsApp message sent successfully!");
            } else {
                System.out.println("Failed to send message. Response Code: " + responseCode);
            }

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

  /*  public static void main(String[] args) {
        // Example values
        String imageUrl = "https://whatsappdata.s3.ap-south-1.amazonaws.com/userMedia/4c07fe24771249c343e70c32289c1192/convocation.PNG"; // New Image URL
        String phoneNumber = "918073492977"; // Recipient phone number
        String applicationNo = "CERT123456"; // Certificate number

        // Send WhatsApp Message with Image
        sendMessage(imageUrl, phoneNumber);
    }*/
}
