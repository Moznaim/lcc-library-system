/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libmngmsys.librarysystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Users {
    
    Mssql_connection connectionManager = new Mssql_connection();
    Connection conn = connectionManager.establishConnection();
    
    private int id;
    private int studid;
    private String username;
    private String usertype;
    
    public Users() {};
    
    public Users(int _id, int _studid, String _username, String _usertype) {
        this.id = _id;
        this.studid = _studid;
        this.username = _username;
        this.usertype = _usertype;
    }
    
    public int getid() {
        return id;
    }
    
    public void setid() {
        this.id = id;
    }
    
    public int getStudid() {
        return studid;
    }

    public void setStudid(int studid) {
        this.studid = studid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
    //functions
    
    
    public boolean studIDcheck(int studid){
        boolean exists = false;  
        String query = "SELECT 1 FROM Users WHERE studid = ?";
        try{ 
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1,studid);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                exists= true;
            }
        }
        catch(SQLException ex) {
            System.out.println("Error" + ex);
        }
        return exists;
    }
    //add user
    public boolean addUser(int _studid, String _username, String _usertype ) {
        String insertQuery = "INSERT INTO Users (studid, username, usertype) VALUES(?,?,?)";
        if(!studIDcheck(_studid)) {
            try{
                PreparedStatement ps = conn.prepareStatement(insertQuery);
                
                ps.setInt(1,_studid);
                ps.setString(2, _username);
                ps.setString(3, _usertype);
                
                if(ps.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null, "User Added","Add User", 1);
                } else {
                    JOptionPane.showMessageDialog(null, "User not Added", "Add User", 2);
                }
            }
            catch(SQLException ex) {

            }
        } else {
            JOptionPane.showMessageDialog(null, "ID Already Exists", "Add User", 2);
        }
        return false;
    }
}
