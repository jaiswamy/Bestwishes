package com.hiideals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class SendSMS {

public static void sendSMS(String number,String message) throws IOException{
		
		//Prepare Url
		URLConnection myURLConnection=null;
		URL myURL=null;
		BufferedReader reader=null;

		//encoding message 
		//String encoded_message=URLEncoder.encode(message);

		//Send SMS API
		String mainUrl="http://sms.hiideals.com/api/mt/SendSMS?";
		
		String postData=null;
		String MobileNo = number;
		String Messagenew = message;
		String Username ="bidar";
		String Password = "123456";
		String SenderID = "SHAKTI";
		String apikey = "aSADN816zEi5EW75IcEHCw";
		String TRANS = "Trans";
		String DCS = "0";
		String flashsms = "0";
		String route = "0";

		//postData += "APIKey="+apikey+"&senderid=" + SenderID + "&channel=" + TRANS + "&DCS=" +DCS+ "&flashsms="+ flashsms +"&number=" + MobileNo +"&message=" + Message+"&route="+ route;

		//final string
		
		String url="http://sms.hiideals.com/api/mt/SendSMS?APIKey="+apikey+"&username="+Username+"&password="+Password+"&senderid="+SenderID+"&channel="+TRANS+"&DCS="+DCS+"&flashsms="+flashsms+"&number="+MobileNo+"&text="+Messagenew+"&route="+route+"";
		String newUrlString = url.replaceAll(" ", "%20");
		
		
		mainUrl = (newUrlString).toString();
		try
		{
			//prepare connection
			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			reader= new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
			//reading response 
			String response;
			while ((response = reader.readLine()) != null) 
				//print response 
				System.out.println(response);

			//finally close connection
			reader.close();
		} 
		catch (IOException e) 
		{ 
			e.printStackTrace();
		} 

	}
}