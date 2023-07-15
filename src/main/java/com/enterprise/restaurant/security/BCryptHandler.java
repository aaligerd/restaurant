package com.enterprise.restaurant.security;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.enterprise.restaurant.service.EmpService;

public class BCryptHandler {

    private static final int costOfenc=10;
    private static final String salt="";

    //create a new password on the bassis of incoming @param password
    public static final String createHash(String password){
        /*using BCrypt.java to hash the password
         * step 1: create a BCrypt.Hasher object with default
         * step 2: then call tha hash method of Hasher and pass the cost and password in byte format
         * step 3: convert it into String and store in database*/
        BCrypt.Hasher hasher =BCrypt.withDefaults();
        byte[] hash =hasher.hash(BCryptHandler.costOfenc,password.getBytes());
        String hashedpass=new String(hash);
        return hashedpass;
    }


    public static final BCrypt.Result verificationResult(byte[] nPass,byte[] hPass){
        /*Verify th passoword with incoming log in credentials
         * step 1: create a Verifyer of BCrypt.Verifyer
         * step 2: verify it by passing the Stirng password and hashed password
         * step 3: strord it in a bcrypt.result and verify it*/
        BCrypt.Verifyer verifyer=BCrypt.verifyer();
        BCrypt.Result result= verifyer.verify(nPass,hPass);
        return result;
    }


}
