package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program_reservation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.print("Check-in date (dd/mm/yyyy): ");
            LocalDate checkIn = LocalDate.from(formatter.parse(sc.next()));
            System.out.print("Check-out date (dd/mm/yyyy): ");
            LocalDate checkOut = LocalDate.from(formatter.parse(sc.next()));

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println("\nEnter data to update the reservation:");
            System.out.print("Check-in date (dd/mm/yyyy): ");
            checkIn = LocalDate.from(formatter.parse(sc.next()));
            System.out.print("Check-out date (dd/mm/yyyy): ");
            checkOut = LocalDate.from(formatter.parse(sc.next()));

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        }
        catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Unexpected error");
            // ira capturar qualquer exceção que surgir
        }

        sc.close();
    }
}

