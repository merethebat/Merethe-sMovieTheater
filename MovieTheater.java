// Author: Merethe Batino
// Date: 2026-09-27

import java.util.Scanner;

public class MovieTheater {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // O = available seats
        // X = taken seats
        char[][] seats = {
                {'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O'},
        };

        int choice;

        System.out.println("Welcome to Merethe'ss Movie Theater!");

        while (true) {
            System.out.println("\nMenu");
            System.out.println("1. View seating chart");
            System.out.println("2. Reserve a seat");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1 -> displaySeats(seats);

                case 2 -> {
                    displaySeats(seats);

                    System.out.print("Enter row number (1-4): ");
                    int reserveRow = input.nextInt() - 1;

                    System.out.print("Enter seat number (1-5): ");
                    int reserveCol = input.nextInt() - 1;

                    if (reserveRow >= 0 && reserveRow < seats.length
                            && reserveCol >= 0 && reserveCol < seats[0].length) {

                        if (seats[reserveRow][reserveCol] == 'O') {
                            seats[reserveRow][reserveCol] = 'X';
                            System.out.println("Seat reserved successfully.");
                        } else {
                            System.out.println("That seat is already taken.");

                            boolean found = false;

                            for (int i = 0; i < seats.length; i++) {
                                for (int j = 0; j < seats[i].length; j++) {
                                    if (seats[i][j] == 'O') {
                                        System.out.println("Suggested available seat: Row "
                                                + (i + 1) + " Seat " + (j + 1));
                                        found = true;
                                        break;
                                    }
                                }
                                if (found) {
                                    break;
                                }
                            }

                            if (!found) {
                                System.out.println("No available seats left.");
                            }
                        }
                    } else {
                        System.out.println("Invalid seat selection.");
                    }

                    displaySeats(seats);
                }

                case 3 -> {
                    displaySeats(seats);

                    System.out.print("Enter row number (1-4) to cancel: ");
                    int cancelRow = input.nextInt() - 1;

                    System.out.print("Enter seat number (1-5) to cancel: ");
                    int cancelCol = input.nextInt() - 1;

                    if (cancelRow >= 0 && cancelRow < seats.length
                            && cancelCol >= 0 && cancelCol < seats[0].length) {

                        if (seats[cancelRow][cancelCol] == 'X') {
                            seats[cancelRow][cancelCol] = 'O';
                            System.out.println("Reservation cancelled successfully.");
                        } else {
                            System.out.println("That seat is not currently reserved.");
                        }
                    } else {
                        System.out.println("Invalid seat selection.");
                    }

                    displaySeats(seats);
                }

                case 4 -> {
                    System.out.println("Thank you for using the Movie Theater reservation system. Goodbye!");
                    input.close();
                    return;
                }

                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to use to display the seating chart
    public static void displaySeats(char[][] seats) {
        System.out.println("O = available, X = taken:");
        for (char[] row : seats) {
            for (char seat : row) {
                System.out.print(seat + " ");
            }
            System.out.println();
        }
    }
}
