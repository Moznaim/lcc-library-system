/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libmngmsys.librarysystem;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *  Server=localhost\SQLEXPRESS;Database=master;Trusted_Connection=True;
 * @author Admin
 */ 
public class Mssql_connection {
    
    //connects to the database
public Connection establishConnection() {
        Connection conn = null;

        try {
            //change parameter if needed
            String dbURL = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=LibraryDB;";
            String muser = "erwin";
            String pass = "feb092003";
            conn = DriverManager.getConnection(dbURL, muser, pass);
            if (conn != null) {
                System.out.println("Connected to SQL Server!");
                printDatabaseInfo(conn);    
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to SQL Server: " + e.getMessage());
        }
        return conn;
    }
    //prints the info for the database
    private void printDatabaseInfo(Connection conn) throws SQLException {
        DatabaseMetaData metaData = conn.getMetaData();
        System.out.println("Driver name: " + metaData.getDriverName());
        System.out.println("Driver Version: " + metaData.getDriverVersion());
        System.out.println("Product name: " + metaData.getDatabaseProductName());
        System.out.println("Product version: " + metaData.getDatabaseProductVersion());
    }
    
    public static void main(String[] args) {
        Mssql_connection connectionManager = new Mssql_connection();
        Connection conn = connectionManager.establishConnection();

        // Perform database operations using the 'conn' object
        // Example: Execute SQL queries, perform CRUD operations, etc.

        // Close the connection when done (if necessary)
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }
}
