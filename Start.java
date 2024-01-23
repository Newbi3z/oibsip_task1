package com.task1;
import java.util.Scanner;

public class Start {
    static Scanner sc=new Scanner(System.in);
    static Bookings bok=new Bookings();
    public static void main(String[] args) {
        System.out.println("Welcome to reservation system");
        while(true) {
            System.out.println("1.Press 1 to register");
            System.out.println("2.Press 2 for user login");
            System.out.println("3.Press 3 for admin login");
            System.out.println("4.Press 4 to exit");
            System.out.println("Enter your choice:");
            int userInput=0;
            try {
                userInput = sc.nextInt();
            }
            catch (Exception e){
                System.out.println("Please enter valid choice");
            }

            sc.nextLine();
            if (userInput == 1) {
                String name = bok.getUsername();
                String pass = bok.getPassword();
                boolean b = Db.check(name,pass);
                if (!b) {
                    System.out.println("User already exists please try to login");
                } else {
                    Db.insert(name, pass);
                    System.out.println("Registration successful");
                }
            } else if (userInput == 2) {
                String name2 = bok.getUsername();
                String pass2 = bok.getPassword();
                boolean b = Db.check(name2,pass2);
                if (!b) {
                    int input2=0;
                    System.out.println("Login successful");
                    System.out.println("1.Press 1 to book a new ticket");
                    System.out.println("2.Press 2 to delete existing ticket");
                    try{
                        input2=sc.nextInt();
                    }
                    catch (Exception e){
                        System.out.println("Invalid input try again");
                    }
                    if(input2==1) {
                        int pnr = bok.getPnrNumber();
                        String coach = bok.getCoachType();
                        String date = bok.getJourneyDate();
                        String origin = bok.getOrigin();
                        String dest = bok.getDestination();
                        System.out.println();
                        boolean b2 = Db.check(pnr);
                        if (!b2) {
                            Db.insert(pnr, name2, coach, date, origin, dest);
                            System.out.println("Your ticket has been reserved");
                            System.out.println("Your pnr number is:" + pnr);
                        } else {
                            System.out.println("Something went wrong try again");
                        }
                    }
                    else if(input2==2){
                        System.out.println("Enter your pnr number:");
                        int pnrNum=sc.nextInt();
                        boolean b3=Db.check(pnrNum);
                        if(b3){
                            Db.delete(pnrNum);
                            System.out.println("You ticket has been cancelled");
                        }
                        else{
                            System.out.println("You have entered wrong pnr number");
                        }
                    }
                } else {
                    System.out.println("Invalid username or password");
                }
            }
            else if(userInput==3){
               boolean valid=checkAdmin();
               if(valid){
                   System.out.println("1.Press 1 to see passenger details");
                   System.out.println("2.Press 2 to see user details");
                   int input=sc.nextInt();
                   if(input==1){
                       Db.passengersDetails();
                   }
                   else if(input==2){
                       Db.userDetails();
                   }
               }
               else{
                   System.out.println("Wrong username or password");
               }
            }
            else if (userInput == 4) {
                System.out.println("Thank you for using reservation services");
                break;
            }
            else{
                System.out.println("Wrong input.Try again");
            }
        }
    }
    public static boolean checkAdmin(){
        String admName="theadmin";
        String admPass="owner123";
        System.out.println("Enter username:");
        String name=sc.nextLine();
        System.out.println("Enter password:");
        String pass=sc.nextLine();
        if(admPass.equals(pass) && admName.equals(name)){
             return true;
        }
        return false;
    }
}