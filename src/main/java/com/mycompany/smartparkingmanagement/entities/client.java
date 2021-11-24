package com.mycompany.smartparkingmanagement.entities;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import java.math.BigDecimal;
import org.apache.commons.lang3.StringUtils;


public class client {
   RazorpayClient createRazorpayClient() throws Exception{ 
       String keyId = "";
       String keySecret = "";
       if(StringUtils.isBlank(keyId) || StringUtils.isBlank(keySecret)) {
           throw new Exception("Please specify API and Secret Key in configuration file");
       }
       RazorpayClient razorpayClient = null;
       try {
           razorpayClient = new RazorpayClient(keyId, keySecret);
       } catch (RazorpayException e) {
           throw new Exception("razorpayClient Create exception" ,e);
       }
       if (razorpayClient == null) {
           throw new Exception("razor pay error");
       }
       return razorpayClient;
   }
   
   public BigDecimal createOrder(BigDecimal amount){
       
       return amount;
   }
}
