package com.hiideals;
import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.net.URL;

public class birthdaySms {

    // StaticKing SMS API Base URL
    private static final String SMS_API_URL = "https://sms.staticking.com/index.php/smsapi/httpapi/";

    // API Credentials
    private static final String SECRET_CODE = "t5FQfoKtvUCUj58a4SVb"; // Your API Secret Code
    private static final String SENDER_ID = "IDEATR"; // Your Sender ID
    private static final String ROUTE = "TA";  // Transactional Route
    private static final String MESSAGE_TYPE = "1"; // Text Message Type
    private static final String TEMPLATE_ID = "1707171041040051137"; // Template ID

    /**
     * Method to send an SMS using StaticKing API.
     *
     * @param phoneNumber  The recipient's mobile number.
     * @param rewardPoints The reward points to be credited.
     * @param totalBalance The total balance after credit.
     * @return API Response as String
     */
    public static String sendSms(String phoneNumber, String message) {
        try {
            // Encode the message
            String encodedMessage = URLEncoder.encode(message, "UTF-8");

            // Construct the complete API URL
            String apiUrl = SMS_API_URL + "?secret=" + SECRET_CODE + 
                            "&sender=" + SENDER_ID + 
                            "&tempid=" + TEMPLATE_ID + 
                            "&receiver=" + phoneNumber + 
                            "&route=" + ROUTE + 
                            "&msgtype=" + MESSAGE_TYPE + 
                            "&sms=" + encodedMessage;

            // Log the request URL
            System.out.println("Sending SMS to: " + phoneNumber);
            System.out.println("API URL: " + apiUrl);

            // Open connection
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);

            // Read response from API
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String response;
            StringBuilder responseContent = new StringBuilder();

            while ((response = in.readLine()) != null) {
                responseContent.append(response);
            }
            in.close();

            System.out.println("SMS API Response: " + responseContent.toString());

            return responseContent.toString(); // Return API response

        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to send SMS: " + e.getMessage();
        }
    }
}