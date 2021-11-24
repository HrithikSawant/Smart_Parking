/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.smartparkingmanagement.entities;

public class Slot {
    private int slot_id;
    private String block_id;
    private String status;
    private String buffer;

    public Slot(int slot_id, String block_id) {
        this.slot_id = slot_id;
        this.block_id = block_id;
    }

    public Slot(int slot_id, String block_id, String status, String buffer) {
        this.slot_id = slot_id;
        this.block_id = block_id;
        this.status = status;
        this.buffer = buffer;
    }
    
    

    public int getSlot_id() {
        return slot_id;
    }

    public void setSlot_id(int slot_id) {
        this.slot_id = slot_id;
    }

    public String getBlock_id() {
        return block_id;
    }

    public void setBlock_id(String block_id) {
        this.block_id = block_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBuffer() {
        return buffer;
    }

    public void setBuffer(String buffer) {
        this.buffer = buffer;
    }
    
    
}
