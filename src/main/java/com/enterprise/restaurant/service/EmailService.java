package com.enterprise.restaurant.service;

import com.enterprise.restaurant.model.EmailDetails;

public interface EmailService {

    // Method
    // To send a simple email
    String sendSimpleMail(EmailDetails details);

    // Method
    // To send an email with attachment

}
