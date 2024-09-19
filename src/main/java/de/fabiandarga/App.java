package de.fabiandarga;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class App 
{
    public static void main( String[] args )
    {
        String url = "jdbc:postgresql://localhost:5432/bookstore";
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASS");

        Connection conn = null;
        PreparedStatement updateStockStmt = null;
        PreparedStatement insertSaleStmt = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);  // Start transaction by turning off auto-commit


	    // HERE COMES YOUR CODE


            // Commit the transaction if everything is successful
            conn.commit();
            System.out.println("Transaction committed successfully!");

        } catch (SQLException ex) {
            // Rollback the transaction if any error occurs
            if (conn != null) {
                try {
                    conn.rollback();
                    System.out.println("Transaction rolled back due to error: " + ex.getMessage());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            // Close the resources
            try {
                if (updateStockStmt != null) updateStockStmt.close();
                if (insertSaleStmt != null) insertSaleStmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
