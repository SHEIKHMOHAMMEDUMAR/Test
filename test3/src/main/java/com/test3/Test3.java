package com.test3;

import java.sql.*;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "password");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("First SQL Query.");
        PreparedStatement ps1 = con.prepareStatement("select Upper(concat(First_Name,' ',Last_Name)) as Full_Name from Worker_Table1");
        ResultSet rs1 = ps1.executeQuery();
        while(rs1.next()){
            System.out.println(rs1.getString(1));
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Second SQL Query.");
        PreparedStatement ps2 = con.prepareStatement("select distinct Department from Worker_Table1");
        ResultSet rs2 = ps2.executeQuery();
        while(rs2.next()){
            System.out.println(rs2.getString(1));
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Third SQL Query.");
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the character whose position you want to find: ");
        String cha = s.next();
        PreparedStatement ps3 = con.prepareStatement("select First_Name,position(? in First_Name) as Match_Position from Worker_Table1");
        ps3.setString(1,cha);
        ResultSet rs3 = ps3.executeQuery();
        while(rs3.next()){
            System.out.printf("%10s %10d \n",rs3.getString(1),rs3.getInt(2));
        }
        con.close();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}