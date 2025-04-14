package com.hiideals;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class WhatsAppService {

    // Method to send WhatsApp message with a birthday wish and a surprise link
    public static void sendMessage(String name, String surpriseLink, String phoneNumber) {
        try {
            // Webbx API URL
            String apiUrl = "https://sent.wbbox.in/pinwa/pinwav1.php"; // Webbx API Endpoint
            String apiKey = "9c61e7b7-36cb-11ef-ad4f-92672d2d0c2d"; // API Key
            String fromPhoneNumber = "918788389212"; // Sender phone number
            String templateId = "725799"; // Template ID

            // Encode parameters to ensure proper URL formatting
            String encodedName = URLEncoder.encode(name, StandardCharsets.UTF_8.toString());
            String encodedLink = URLEncoder.encode(surpriseLink, StandardCharsets.UTF_8.toString());

            // Construct Query Parameters with placeholders
            String jsonPayload = "apikey=" + apiKey 
                    + "&from=" + fromPhoneNumber 
                    + "&to=" + phoneNumber
                    + "&type=template"
                    + "&templateid=" + templateId
                    + "&placeholders=" + encodedName + "|" + encodedLink; // {{1}} = name, {{2}} = surprise link

            // Create Connection
            URL url = new URL(apiUrl + "?" + jsonPayload);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");  // Using GET since parameters are in the URL
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setDoOutput(true);

            // Read Response
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("WhatsApp message sent successfully to: " + phoneNumber);
            } else {
                System.out.println("Failed to send message. Response Code: " + responseCode);
            }

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
