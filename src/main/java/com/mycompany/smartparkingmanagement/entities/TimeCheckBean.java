package com.mycompany.smartparkingmanagement.entities;

public class TimeCheckBean {
    String db_open_time;
    String db_close_time;
    
    public TimeCheckBean() {
    } 
    
    public TimeCheckBean(String db_open_time, String db_close_time) {
        this.db_open_time = db_open_time;
        this.db_close_time = db_close_time;
    }

    public String getDb_open_time() {
        return db_open_time;
    }

    public void setDb_open_time(String db_open_time) {
        this.db_open_time = db_open_time;
    }

    public String getDb_close_time() {
        return db_close_time;
    }

    public void setDb_close_time(String db_close_time) {
        this.db_close_time = db_close_time;
    }

    @Override
    public String toString() {
        return "TimeCheckBean{" + "db_open_time=" + db_open_time + ", db_close_time=" + db_close_time + '}';
    }

    
    
    
}
