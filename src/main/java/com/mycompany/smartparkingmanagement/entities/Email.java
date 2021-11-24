/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.smartparkingmanagement.entities;

public class Email {

    private String to;
    private String from ;
    private String content;
    private String subject;
    private String username;

    public Email() {
    }

    public Email(String from, String username) {
        this.from = from;
        this.username = username;
    }

    
    public Email(String to, String from, String content, String subject) {
        this.to = to;
        this.from = from;
        this.content = content;
        this.subject = subject;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Email{" + "to=" + to + ", from=" + from + ", content=" + content + ", subject=" + subject + ", username=" + username + '}';
    }
    
    
    
    

}
