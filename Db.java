package com.task1;
import java.sql.*;

public class Db {
   static Connection con;
    public static Connection concreate(){
         try{
             String url="jdbc:mysql://localhost:3306/reserv_system";
             String userName="root";
             String password="admin";
             con= DriverManager.getConnection(url,userName,password);
         }
         catch (Exception e){
             e.printStackTrace();
         }
         return con;
    }
    public static void insert(String userN,String pass){

        try {
            concreate();
            String query = "insert into users (u_name,u_pass) values(?,?)";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1,userN);
            pstm.setString(2,pass);
            pstm.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public static boolean check(String userN,String pass){

        try {
            concreate();
            String checkQuery = "select * from users where u_name=? and u_pass=?";
            PreparedStatement pstm = con.prepareStatement(checkQuery);
            pstm.setString(1,userN);
            pstm.setString(2,pass);
            ResultSet rs=pstm.executeQuery();
            if(rs.next()){
                return false;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return true;

    }

    public static void insert(int pnr,String userN,String type,String date,String origin,String dest){

        try {
            concreate();
            String query2 = "insert into passengers(pnr,u_name,u_coach,date,station,destination) values(?,?,?,?,?,?)";
            PreparedStatement pstm2 = con.prepareStatement(query2);
            pstm2.setInt(1,pnr);
            pstm2.setString(2,userN);
            pstm2.setString(3,type);
            pstm2.setString(4,date);
            pstm2.setString(5,origin);
            pstm2.setString(6,dest);
            pstm2.execute();

        }
        catch (Exception e){
            System.out.println(e);
        }

    }
    public static void delete(int pnr){
        try {
            concreate();
            String query = "delete from passengers where pnr=?";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1,pnr);
            pstm.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
    public static boolean check(int pnr){
        try {
            concreate();
            String checkQuery2 = "select * from passengers where pnr=?";
            PreparedStatement pstm = con.prepareStatement(checkQuery2);
            pstm.setInt(1,pnr);
            ResultSet rs=pstm.executeQuery();
            if(rs.next()){
                return true;
            }
        }
        catch (Exception e){
            System.out.println("This pnr number already exists enter another pnr number");
            System.out.println(e);
        }
        return false;
    }
    public static void passengersDetails(){
        try {
            concreate();
            String showQuery="select * from passengers";
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery(showQuery);
            while(rs.next()){
               int pnr=rs.getInt(1);
               String name=rs.getString(2);
               String coach=rs.getString(3);
               String date=rs.getString(4);
               String origin=rs.getString(5);
               String dest=rs.getString(6);

                System.out.println("PNR:-"+pnr);
                System.out.println("Name:-"+name);
                System.out.println("Coach Type:-"+coach);
                System.out.println("Date of Journey:-"+date);
                System.out.println("Origin Station:-"+origin);
                System.out.println("Destination Station:-"+dest);
                System.out.println("++++++++++++++++++++++++++++");
            }
        }
        catch (Exception e){
           e.printStackTrace();
        }
    }
    public static void userDetails(){
        try {
            concreate();
            String showQuery2="select * from users";
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery(showQuery2);
            while(rs.next()){
                int id=rs.getInt(1);
                String name=rs.getString(2);
                String password=rs.getString(3);

                System.out.println("ID:-"+id);
                System.out.println("Name:-"+name);
                System.out.println("Password:-"+password);
                System.out.println("++++++++++++++++++++++++++++");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
