/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qfx;

import com.qfx.cinema.Booking;
import java.util.Scanner;

/**
 *
 * @author sapu
 */
public class Cinemas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("*****************************************************");
        System.out.println("\tWelcome TO My Cinemas");
        System.out.println("*****************************************************");
        String[] movies = {"Bahubali 2", "Guardians of Galaxy 2", "Meri Pyari Bindu"};
        Scanner input = new Scanner(System.in);
        Booking book = new Booking(movies, input);
        book.adddetails();
        while (true) {
            System.out.println("Choose your menu");
            book.menu();
            switch (input.nextInt()) {
                case 1:
                    book.showmovies();
                    break;
                case 2:
                    book.booking();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Inpput \r\n choose from [1-5]");

            }

        }

    }

}
