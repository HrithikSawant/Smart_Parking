/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.smartparkingmanagement.entities;


public class OrderBean {
    double amount;
    private double amount_paid;
    private String created_at; //
    private double amount_due;
    private String currency;
    String receipt;
    String id; //
    String order_id;
    String signature; //
    private String entity; //
    private int offer_id;
    private String status;
    private int attempts;

    public OrderBean() {
    }
    
    public OrderBean(double amount_paid, double amount_due, String id, String order_id, String signature, String status) {
        this.amount_paid = amount_paid;
        this.amount_due = amount_due;
        this.id = id;
        this.order_id = order_id;
        this.signature = signature;
        this.status = status;
    }
    
    
    public OrderBean(double amount, double amount_paid, double amount_due, String currency, String receipt, String order_id, int offer_id, String status, int attempts) {
        this.amount = amount;
        this.amount_paid = amount_paid;
        this.amount_due = amount_due;
        this.currency = currency;
        this.receipt = receipt;
        this.order_id = order_id;
        this.offer_id = offer_id;
        this.status = status;
        this.attempts = attempts;
    }

    
    
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount_paid() {
        return amount_paid;
    }

    public void setAmount_paid(double amount_paid) {
        this.amount_paid = amount_paid;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public double getAmount_due() {
        return amount_due;
    }

    public void setAmount_due(int amount_due) {
        this.amount_due = amount_due;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
    
    
    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public int getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(int offer_id) {
        this.offer_id = offer_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    @Override
    public String toString() {
        return "OrderBean{" + "amount=" + amount + ", amount_paid=" + amount_paid + ", created_at=" + created_at + ", amount_due=" + amount_due + ", currency=" + currency + ", receipt=" + receipt + ", id=" + id + ", order_id=" + order_id + ", signature=" + signature + ", entity=" + entity + ", offer_id=" + offer_id + ", status=" + status + ", attempts=" + attempts + '}';
    }
    
    
}
