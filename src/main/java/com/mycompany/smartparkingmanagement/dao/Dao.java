package com.mycompany.smartparkingmanagement.dao;

import api.Generator;
import api.GmailAPI;
import com.mycompany.smartparkingmanagement.entities.Admin;
import com.mycompany.smartparkingmanagement.entities.Customer;
import com.mycompany.smartparkingmanagement.entities.ForgotPasswordBean;
import com.mycompany.smartparkingmanagement.entities.LoginBean;
import com.mycompany.smartparkingmanagement.entities.Staff;
import com.mycompany.smartparkingmanagement.helper.ConnectionProvider;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.mail.MessagingException;

public class Dao {

    public static boolean checkAdmin(Admin ad) {
        boolean f = false;
        try {
            Connection con = ConnectionProvider.getConnection();
            PreparedStatement pstmt_check = con.prepareStatement(" SELECT * FROM admin WHERE first_name = ? AND contact_no = ? AND aadhaar_card_no = ? ");
            pstmt_check.setString(1, ad.getFirstName());
            pstmt_check.setLong(2, ad.getPhoneNo());
            pstmt_check.setLong(3, ad.getAadhaarNo());
            ResultSet rs = pstmt_check.executeQuery();
            if (rs.next()) {
                System.out.println("tum ho tumko pata nahi");
            } else {
                f = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return f;
    }

    public static boolean checkStaff(Staff st) {
        boolean f = false;
        try {
            Connection con = ConnectionProvider.getConnection();
            PreparedStatement pstmt_check = con.prepareStatement(" SELECT * FROM staff WHERE first_name = ? AND contact_no = ? AND aadhaar_card_no = ? ");
            pstmt_check.setString(1, st.getFirstName());
            pstmt_check.setLong(2, st.getPhoneNo());
            pstmt_check.setLong(3, st.getAadhaarNo());
            ResultSet rs = pstmt_check.executeQuery();
            if (rs.next()) {
                System.out.println("tum ho tumko pata nahi");
            } else {
                f = true;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return f;
    }

    public static boolean checkCustomer(Customer cust) {
        boolean f = false;
        try {
            Connection con = ConnectionProvider.getConnection();
            PreparedStatement pstmt_check = con.prepareStatement(" SELECT * FROM customer WHERE first_name = ? AND contact_no = ? AND license_no = ? ");
            pstmt_check.setString(1, cust.getFirstName());
            pstmt_check.setLong(2, cust.getPhoneNo());
            pstmt_check.setString(3, cust.getLicenseNo());
            ResultSet rs = pstmt_check.executeQuery();
            if (rs.next()) {
                System.out.println("tum ho tumko pata nahi");
            } else {
                f = true;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return f;
    }

    public static boolean InsertAdminToDB(Admin ad) {
        boolean f = false;
        try {
            Connection con = ConnectionProvider.getConnection();
            try (PreparedStatement pstmt = con.prepareStatement("INSERT INTO login(username,password,role)VALUES(?,MD5(?),?)")) {
                pstmt.setString(1, ad.getUsername());
                pstmt.setString(2, ad.getPassword());
                pstmt.setString(3, ad.getRole());
                pstmt.executeUpdate();
            }
            try (PreparedStatement pstmt = con.prepareStatement("INSERT INTO admin(first_name,"
                    + " middle_name, last_name, DOB, email, alternate_email,"
                    + " contact_no, alternate_contact_no, gender, country, state, city,"
                    + " aadhaar_card_no, pancard_no, username)"
                    + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)")) {
                pstmt.setString(1, ad.getFirstName());
                pstmt.setString(2, ad.getMiddleName());
                pstmt.setString(3, ad.getLastName());
                pstmt.setString(4, ad.getDob());
                pstmt.setString(5, ad.getEmailId());
                pstmt.setString(6, ad.getAlternate_emailId());
                pstmt.setLong(7, ad.getPhoneNo());
                pstmt.setLong(8, ad.getAlternate_phoneNo());
                pstmt.setString(9, ad.getGender());
                pstmt.setString(10, ad.getCountry());
                pstmt.setString(11, ad.getState());
                pstmt.setString(12, ad.getCity());
                pstmt.setLong(13, ad.getAadhaarNo());
                pstmt.setString(14, ad.getPancardNo());
                pstmt.setString(15, ad.getUsername());
                pstmt.executeUpdate();
            }
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public static boolean InsertStaffToDB(Staff st) {
        boolean s = false;
        try {
            Connection con = ConnectionProvider.getConnection();
            try (PreparedStatement pstmt = con.prepareStatement("INSERT INTO login(username,password,role)VALUES(?,?,?)")) {
                pstmt.setString(1, st.getUsername());
                pstmt.setString(2, st.getPassword());
                pstmt.setString(3, st.getRole());
                pstmt.executeUpdate();
            }
            try (PreparedStatement pstmt = con.prepareStatement("INSERT INTO staff(first_name,"
                    + " middle_name, last_name, DOB, email, alternate_email,"
                    + " contact_no, alternate_contact_no, gender, country, state, city,"
                    + " aadhaar_card_no, pancard_no, username)"
                    + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)")) {
                pstmt.setString(1, st.getFirstName());
                pstmt.setString(2, st.getMiddleName());
                pstmt.setString(3, st.getLastName());
                pstmt.setString(4, st.getDob());
                pstmt.setString(5, st.getEmailId());
                pstmt.setString(6, st.getAlternate_emailId());
                pstmt.setLong(7, st.getPhoneNo());
                pstmt.setLong(8, st.getAlternate_phoneNo());
                pstmt.setString(9, st.getGender());
                pstmt.setString(10, st.getCountry());
                pstmt.setString(11, st.getState());
                pstmt.setString(12, st.getCity());
                pstmt.setLong(13, st.getAadhaarNo());
                pstmt.setString(14, st.getPancardNo());
                pstmt.setString(15, st.getUsername());
                pstmt.executeUpdate();
            }
            s = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public static boolean InsertCustomerToDB(Customer cust) {
        boolean f = false;
        try {
            Connection con = ConnectionProvider.getConnection();
            try (PreparedStatement pstmt = con.prepareStatement("INSERT INTO login(username,password,role)VALUES(?,MD5(?),?)")) {
                pstmt.setString(1, cust.getUsername());
                pstmt.setString(2, cust.getPassword());
                pstmt.setString(3, cust.getRole());
                pstmt.executeUpdate();
            }
            try (PreparedStatement pstmt = con.prepareStatement("INSERT INTO customer(first_name, middle_name, last_name,"
                    + " DOB, email, alternalte_email, contact_no, alternate_contact_no, gender, country, state, city,"
                    + " License_No, username) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)")) {
                pstmt.setString(1, cust.getFirstName());
                pstmt.setString(2, cust.getMiddleName());
                pstmt.setString(3, cust.getLastName());
                pstmt.setString(4, cust.getDob());
                pstmt.setString(5, cust.getEmailId());
                pstmt.setString(6, cust.getAlternate_emailId());
                pstmt.setLong(7, cust.getPhoneNo());
                pstmt.setLong(8, cust.getAlternate_phoneNo());
                pstmt.setString(9, cust.getGender());
                pstmt.setString(10, cust.getCountry());
                pstmt.setString(11, cust.getState());
                pstmt.setString(12, cust.getCity());
                pstmt.setString(13, cust.getLicenseNo());
                pstmt.setString(14, cust.getUsername());
                pstmt.executeUpdate();
            }
            f = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return f;
    }

    public boolean StoreToken(String emailid, int token) {
        boolean f = false;
        Connection con = ConnectionProvider.getConnection();
        try {

            String query1 = "INSERT INTO token(email_id, token_no) VALUES (?,?) ON DUPLICATE KEY UPDATE token_no = (?)";
            PreparedStatement pstmt = con.prepareStatement(query1);
            pstmt.setString(1, emailid);
            pstmt.setInt(2, token);
            pstmt.setInt(3, token);
            System.out.println(token);
            System.out.println(emailid);
            pstmt.executeUpdate();
            //gmail api to send email
            String url = "http://localhost:8080/SmartParkingManagement/VerifyOTP.jsp";
            f = GmailAPI.sendEmail(emailid, "Your OTP is " + token + "\n" + url);
        } catch (IOException | GeneralSecurityException | SQLException | MessagingException x) {
            x.printStackTrace();
        }
        return f;
    }

    public boolean CheckEmailIdofUser(String email_id) {
        //Get email id from user
        boolean f = false;
        try {
            Connection con = ConnectionProvider.getConnection();
            String query = "SELECT  email FROM customer WHERE email = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, email_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                //call OTP api
                Generator g = new Generator();
                f = StoreToken(rs.getString("email"), g.OTP());
                //f = true;
            } else {
                f = CheckEmailIdofAdmin(email_id);
                System.out.println("NotFound");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public boolean CheckEmailIdofAdmin(String email_id) {
        //Get email id from user
        boolean f = false;
        try {
            Connection con = ConnectionProvider.getConnection();
            String query = "SELECT email FROM admin WHERE email = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, email_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println(true);
                System.out.println(rs);
                //call OTP api
                Generator g = new Generator();
                f = StoreToken(rs.getString("email"), g.OTP());
            } else {
                System.out.println(false);
                f = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public Admin getAdminDetailsByUsername(String username) {
        Connection con = ConnectionProvider.getConnection();
        Admin admin = null;
        try {
            String query = "SELECT * FROM admin WHERE username=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                admin = new Admin();
                //data from db
                String first_name = rs.getString("first_name");
                //set to Admin object
                admin.setFirstName(first_name);
                admin.setUsername(username);
                admin.setProfile(rs.getString("profile"));
                admin.setMiddleName(rs.getString("middle_name"));
                admin.setLastName(rs.getString("last_name"));
                admin.setGender(rs.getString("gender"));
                admin.setEmailId(rs.getString("email"));
                admin.setAlternate_emailId(rs.getString("alternate_email"));
                admin.setPhoneNo(rs.getInt("contact_no"));

            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return admin;
    }

    public Customer getCustomerDetailsByUsername(String username) {
        Connection con = ConnectionProvider.getConnection();
        Customer cust = null;
        try {
            String query = "SELECT * FROM customer WHERE username=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                cust = new Customer();
                //data from db
                String first_name = rs.getString("first_name");
                //set to staff object
                cust.setFirstName(first_name);
                cust.setUsername(username);    
                cust.setProfile(rs.getString("profile"));
                cust.setMiddleName(rs.getString("middle_name"));
                cust.setLastName(rs.getString("last_name"));
                cust.setGender(rs.getString("gender"));
                cust.setEmailId(rs.getString("email"));
                cust.setAlternate_emailId(rs.getString("alternate_email"));
                cust.setPhoneNo(rs.getInt("contact_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cust;
    }

    public Staff getStaffDetailsByUsername(String username) {
        Connection con = ConnectionProvider.getConnection();
        Staff staff = null;
        try {
            String query = "SELECT * FROM staff WHERE username=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                staff = new Staff();
                //data from db
                String first_name = rs.getString("first_name");
                //set to staff object
                staff.setFirstName(first_name);
                staff.setUsername(username);
                staff.setProfile(rs.getString("profile"));
                staff.setMiddleName(rs.getString("middle_name"));
                staff.setLastName(rs.getString("last_name"));
                staff.setGender(rs.getString("gender"));
                staff.setEmailId(rs.getString("email"));
                staff.setAlternate_emailId(rs.getString("alternate_email"));
                staff.setPhoneNo(rs.getInt("contact_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return staff;
    }

    //
    public String authenticateUser(LoginBean loginBean) throws SQLException {
        String userName = loginBean.getUserName();
        String password = loginBean.getPassword();
//        Admin admin = null;
//        Staff staff = null;
        try {
            Connection con = ConnectionProvider.getConnection();
            String query = "SELECT role FROM login WHERE username=? and password=?";;
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, userName);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
//                System.out.println(rs.getString(2));
                if (rs.getString(1).equals("Admin")) {
                    System.out.println("Welcome Admin!!!");
                    // getAdminDetailsByUsername(rs.getString());
                    return "Admin";
                } else if (rs.getString(1).equals("Staff")) {
                    System.out.println("Welcome Staff!!!");
                    return "Staff";
                }
                //Customer
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Invalid user credentials";
    }

    public ForgotPasswordBean CheckUsername(String username) {
        Boolean f = false;
        ForgotPasswordBean forgot = null;
        Connection con = ConnectionProvider.getConnection();
        try {
            String query = "SELECT * From login WHERE username=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            forgot = new ForgotPasswordBean();
            if (rs.next()) {
                forgot.setUsername(rs.getString("username"));
                forgot.setRole(rs.getString("role"));
                forgot.setStatus(true);
                f = true;
            } else {
                forgot.setStatus(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return forgot;
    }

    public LoginBean getUserByUsernameAndPassword(String username, String password) {
        Connection con = ConnectionProvider.getConnection();
        LoginBean Loguser = null;
        try {
            String query = "SELECT * From login WHERE username=? and password= MD5(?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String block = rs.getString("block");
                Loguser = new LoginBean();
                if (block.equals("no")) {
                    Loguser.setUserName(rs.getString("username"));
                    Loguser.setRole(rs.getString("role"));
                    Loguser.setBlock(false);
                } else {
                    Loguser.setBlock(true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Loguser;
    }

    public boolean updateUserDetails(LoginBean lg) {
        boolean f = false;
        try {
            Connection con = ConnectionProvider.getConnection();
            String sql = "";
            if (lg.getRole().equals("Admin")) {
                sql = "update admin set first_name=?,email=? WHERE username =?";
            } else if (lg.getRole().equals("Staff")) {
                sql = "update staff set first_name=?,email=? WHERE username =?";
            } else if (lg.getRole().equals("Customer")) {
                sql = "update customer set first_name=?,email=? WHERE username =?";
            }
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, lg.getFirstName());
                pstmt.setString(2, lg.getEmailid());
                pstmt.setString(3, lg.getUserName());
                pstmt.executeUpdate();
            }
            try (PreparedStatement pstmt = con.prepareStatement("update login set password =MD5(?) WHERE username =?")) {
                pstmt.setString(1, lg.getPassword());
                pstmt.setString(2, lg.getUserName());
                pstmt.executeUpdate();
            }
            f = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return f;
    }

    public boolean updateUserProfile(LoginBean lg) {
        boolean f = false;
        try {
            Connection con = ConnectionProvider.getConnection();
            String sql = "";
            if (lg.getRole().equals("Admin")) {
                sql = "update admin set profile=? WHERE username =?";
            } else if (lg.getRole().equals("Staff")) {
                sql = "update staff set profile=? WHERE username =?";
            } else if (lg.getRole().equals("Customer")) {
                sql = "update customer set profile=? WHERE username =?";
            }
            
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, lg.getProfile());
            pstmt.setString(2, lg.getUserName());

            pstmt.executeUpdate();
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public boolean VerfyOTP(String email, int OTP) {
        boolean f = false;
        try {
            Connection con = ConnectionProvider.getConnection();
            String query = "SELECT token_no FROM token WHERE email_id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String tk = rs.getString("token_no");
                System.out.println("token found");
                String check = String.valueOf(OTP);
                if (check.equals(tk)) {
                    System.out.println("tk" + tk);
                    System.out.println("token matched");
                    f = true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Verify OTP NOT EXECUTED");
            e.printStackTrace();
        }
        return f;
    }

    public boolean UserPassword(String pass, String username) {
        System.out.println(pass);
        System.out.println(username);
        boolean passupdated = false;
        try {
            Connection con = ConnectionProvider.getConnection();
            String query = "UPDATE login SET password = MD5(?) WHERE username = ?;";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, pass);
            pstmt.setString(2, username);
            int rs = pstmt.executeUpdate();
            if (rs > 0) {
                passupdated = true;
            }
            pstmt.close();
        } catch (SQLException e) {
            System.out.println("Error Updating Password");
            e.printStackTrace();
            passupdated = false;
        }
        return passupdated;
    }
}
