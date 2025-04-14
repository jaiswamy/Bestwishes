package com.hiideals;

import java.net.HttpURLConnection;

import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WhatsappLink {

    public static void sendMessageWithDocument(String contactName, String certificateLink, String phoneNumber) {
        try {
            // WhatsApp API Endpoint
            String apiUrl = "https://sent.wbbox.in/pinwa/pinwav1.php";

            // API Credentials
            String apiKey = "9c61e7b7-36cb-11ef-ad4f-92672d2d0c2d".trim();
            String fromPhoneNumber = "918788389212";
            String templateId = "776247";
            String fileName = "certificate.pdf"; // Change as needed
            String placeholders = contactName + "|~|" + certificateLink; // API expects placeholders separated by "|~|"

            // Construct the full URL with parameters
            String requestUrl = apiUrl + "?apikey=" + apiKey
                    + "&from=" + fromPhoneNumber
                    + "&to=" + phoneNumber
                    + "&type=template"
                    + "&templateid=" + templateId
                    + "&placeholders=" + placeholders
                    + "&url=" + certificateLink
                    + "&filename=" + fileName;

            // Create HTTP Connection
            URL url = new URL(requestUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET"); // ✅ Use GET as per API docs

            // Read API Response
            int responseCode = conn.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Print API Response
            System.out.println("API Response: " + response.toString());

            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("✅ WhatsApp document message sent successfully!");
            } else {
                System.out.println("❌ Failed to send document. Response Code: " + responseCode);
            }

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


  /*  public static void main(String[] args) {
        // Test Parameters
        String contactName = "Bhagyashree";
        String certificateLink = "https://greetings.hiideals.com/greeting/membercreation/viewCertificate?fileName=certificate_MB004.pdf";
        String phoneNumber = "918073492977";

        sendMessageWithDocument(contactName, certificateLink, phoneNumber);
    }*/
}
