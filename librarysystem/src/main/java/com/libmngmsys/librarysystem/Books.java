/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libmngmsys.librarysystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Admin
 */
public class Books {
    
    Mssql_connection connectionManager = new Mssql_connection();
    Connection conn = connectionManager.establishConnection();
    private int id;
    private String bookname;
    private String mainclass;
    private String subclass;
    private String location;
    private String filename;
            
    //constructor
    public Books() {};
    
    public Books(int _id, String _bookname, String _mainclass, String _subclass, String _location, String _filename) {
        this.id = _id;
        this.bookname = _bookname;
        this.mainclass = _mainclass;
        this.subclass = _subclass;
        this.location = _location;
        this.filename = _filename;
        
    

    }
    
    public Books(int _id, String _bookname, String _mainclass, String _subclass, String _location) {
        this.id = _id;
        this.bookname = _bookname;
        this.mainclass = _mainclass;
        this.subclass = _subclass;
        this.location = _location;   
    }
    
    //getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getMainclass() {
        return mainclass;
    }

    public void setMainclass(String mainclass) {
        this.mainclass = mainclass;
    }

    public String getSubclass() {
        return subclass;
    }

    public void setSubclass(String subclass) {
        this.subclass = subclass;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    //functions

    //insert or add new book
    public boolean addBook(String _bookname, String _mainclass, String _subclass, String _location, String _filename) {
        String insertQuery = "INSERT INTO Books (bookname, mainclass, subclass, location, filename) VALUES (?,?,?,?,?)";
                
        try {
            PreparedStatement ps = conn.prepareStatement(insertQuery);
            
            ps.setString(1, _bookname);
            ps.setString(2, _mainclass);
            ps.setString(3, _subclass);
            ps.setString(4, _location);
            ps.setString(5, _filename);
            
            if(ps.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Book Added", "add Book",1);
            } else  {
                JOptionPane.showMessageDialog(null, "Book not Added", "Add Book",2);
            }
        }
        
        catch(SQLException ex){
           Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //edit a book
    public void editBook(int _id, String _bookname, String _mainclass, String _subclass, String _location, String _filename) {
        String editQuery = "UPDATE Books SET bookname = ?, mainclass = ?, subclass = ?, location = ?, filename = ? WHERE id = ?";
                try {
            PreparedStatement ps = conn.prepareStatement(editQuery);
            
            ps.setString(1, _bookname);
            ps.setString(2, _mainclass);
            ps.setString(3, _subclass);
            ps.setString(4, _location);
            ps.setString(5, _filename);
            ps.setInt(6, _id);
            
            if(ps.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Book Edited", "Edit Book",1);
            } else  {
                JOptionPane.showMessageDialog(null, "Book not Edited", "Edited Book",2);
            }
        }
        
        catch(SQLException ex){
           Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //delete a book
    public void removeBook(int _id) {
        String removeQuery = "DELETE FROM Books WHERE ID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(removeQuery);
            
            ps.setInt(1, _id);
            
            if(ps.executeUpdate() !=0) {
                JOptionPane.showMessageDialog(null, "Book Removed","Remove", 1);
                
            } else {
                JOptionPane.showMessageDialog(null, "Book not removed", "Remove", 2);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public ArrayList<Books> bookList() {
        
        ArrayList<Books> bList = new ArrayList<>();
        
        String selectQuery = "SELECT * FROM Books";
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            ps = conn.prepareStatement(selectQuery);
            rs = ps.executeQuery();
            
            Books books;
            
            while(rs.next()) {
                books = new Books(rs.getInt("ID"), rs.getString("bookname"), rs.getString("mainclass"), rs.getString("subclass"), rs.getString("location"), rs.getString("filename"));
                bList.add(books);
            }
        }
        catch(SQLException ex) {
            Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bList;
    }
    
    
    public ArrayList<Books> bookListuser() {
        ArrayList<Books> bList = new ArrayList<>();
        
        String selectQuery = "SELECT id, bookname, mainclass, subclass, location, filename FROM Books";
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            ps = conn.prepareStatement(selectQuery);
            rs = ps.executeQuery();
            
            Books books;
            
            while(rs.next()) {
                books = new Books(rs.getInt("ID"), rs.getString("bookname"), rs.getString("mainclass"), rs.getString("subclass"), rs.getString("location"), rs.getString("filename"));
                bList.add(books);
            }
        }
        catch(SQLException ex) {
            Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bList;      
    }
    
    public Books bookbinarysearch(ArrayList<Books> sortedList, String category, String target) {
        int left = 0;
        int right = sortedList.size() - 1;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            String midCategory = getCategoryValue(sortedList.get(mid), category);
            
            
            //check if target matches the mid value for selected category
            int comparison = midCategory.compareTo(target);
            if (comparison == 0) {
                return sortedList.get(mid); //match found return index
            } else if (comparison < 0) {
                left = mid + 1; //target is greater, ignore left half
            } else {
                right = mid - 1; //target is smaller, ignore right half
            }
        }
        return null; //not found
    }
    
    private String getCategoryValue(Books book, String category) {
        switch (category) {
            case "ID":
                return Integer.toString(book.getId());
            case "Main Class":
                return book.getMainclass();
            case "Book Name":
                return book.getBookname();
            default:
                return ""; //empty string
        }
    }
}
