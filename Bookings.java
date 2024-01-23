package com.task1;


import java.util.Random;
import java.util.Scanner;

public  class Bookings {
    Scanner sc=new Scanner(System.in);
    public int getPnrNumber(){
        Random ran=new Random();
        int pnr=ran.nextInt(5001)+1;
        return pnr;
  }
  public String getUsername(){
      System.out.println("Enter your name:");
        String userName=sc.nextLine();
        return userName;
  }
    public String getPassword(){
        System.out.println("Enter your password:");
        String pass=sc.nextLine();
        return pass;
    }
    public String getJourneyDate(){
        System.out.println("Enter your date of journey:");
        String date=sc.nextLine();
        return date;
    }
    public String getCoachType(){
        System.out.println("Enter your coach type:");
        String coach=sc.nextLine();
        return coach;
    }
    public String getOrigin(){
        System.out.println("Enter your boarding station:");
        String origin=sc.nextLine();
        return origin;
    }
    public String getDestination(){
        System.out.println("Enter your destination station:");
        String dest=sc.nextLine();
        return dest;
    }

}