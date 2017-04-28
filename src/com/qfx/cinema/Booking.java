/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qfx.cinema;

import java.util.Scanner;

/**
 *
 * @author sapu
 */
public class Booking {

    public Scanner input;
    public String[] movies;
    public double[] price, seats;

    public Booking(String[] movies, Scanner input) {
        this.input = input;
        this.movies = movies;
        seats=new double[movies.length];
        price = new double[movies.length];

    }

    public void adddetails() {
        System.out.println("Enter the Movies details");
        for (int i = 0; i < movies.length; i++) {
            System.out.println("Enter the Rate of the Movie" + movies[i]);
            price[i] = input.nextDouble();
            System.out.println("Enter the number of seats available:");
            seats[i] = input.nextDouble();

        }

    }

    public void menu() {
        System.out.println("Menu");
        System.out.println("1.Now Showing");
        System.out.println("2.Book Movies");
        System.out.println("3.Exit");
        System.out.println("Choose from [1-3]");

    }
    
    

    public void showmovies() {
        String format="%-4s %-30s %-15s %-15s %n";
        System.out.println("Now Showing");
        System.out.printf(format,"S.N","Movie Name","Rate","Seats");
        for (int i = 0; i < movies.length; i++) {
            System.out.printf(format,(i+1),movies[i],price[i],seats[i]);
        }

    }
    public boolean nextBooking() {
        boolean isNext = false;
        System.out.println("Next booking?? (Y/N)");
        String reply = input.next();
        if (reply.equalsIgnoreCase("y")) {
            isNext = true;
        }
        return isNext;
    }
    

    public void booking() {
        int choice = 0, qty = 0, gtotal = 0;
        double total;
        do {
            total = 0;
            showmovies();
            System.out.println("Enter the choice of movie");
            choice = input.nextInt();
            for (int i = 0; i < movies.length; i++) {
                if (choice == (i + 1)) {
                    System.out.println("Enter the seats available");
                    qty = input.nextInt();

                    if (qty > seats[i]) {
                        System.out.println("Sorry we dont have enough tickets ");
                    } else {
                        seats[i] -= qty;
                        total = qty * price[i];
                        gtotal += total;
                        System.out.println("*********************************");
                        //System.out.println(toString());
                        System.out.println("*\tMovie:" + movies[i]);
                        System.out.println("*\tTickets:" + qty);
                        System.out.println("*\tTotal price: " + total);
                        System.out.println("*********************************");
                    }
                }
            }
        } while (nextBooking());
        System.out.println("**********************************");
        System.out.println("Your grand total is: " + gtotal);
        System.out.println("Thankyou!");
        System.out.println("**********************************");

    }

}
