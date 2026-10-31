package railway;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ReservationSystem system = new ReservationSystem();

    public static void main(String[] args) {
        boolean running = true;
        System.out.println("====================================");
        System.out.println("   RAILWAY TICKET RESERVATION SYSTEM");
        System.out.println("====================================");

        while (running) {
            showMenu();
            int choice = readInt("Enter your choice: ");

            try {
                switch (choice) {
                    case 1:
                        viewTrains();
                        break;
                    case 2:
                        searchTrains();
                        break;
                    case 3:
                        bookTicket();
                        break;
                    case 4:
                        checkTicket();
                        break;
                    case 5:
                        cancelTicket();
                        break;
                    case 6:
                        viewAllBookings();
                        break;
                    case 0:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("Unable to complete operation: " + e.getMessage());
            }

            System.out.println();
        }

        System.out.println("Thank you for using the Railway Reservation System.");
        scanner.close();
    }

    private static void showMenu() {
        System.out.println("""

                ------------ MAIN MENU ------------
                1. View all trains
                2. Search trains
                3. Book ticket
                4. Check ticket using PNR
                5. Cancel ticket
                6. View all bookings
                0. Exit
                -----------------------------------
                """);
    }

    private static void viewTrains() {
        List<Train> trains = system.getAllTrains();
        System.out.println("TRAIN NO | TRAIN NAME | ROUTE | SEATS");
        for (Train train : trains) {
            System.out.println(train);
        }
    }

    private static void searchTrains() {
        String source = readLine("Enter source station: ");
        String destination = readLine("Enter destination station: ");
        List<Train> results = system.searchTrains(source, destination);

        if (results.isEmpty()) {
            System.out.println("No trains found for this route.");
        } else {
            System.out.println("Available trains:");
            for (Train train : results) {
                System.out.println(train);
            }
        }
    }

    private static void bookTicket() {
        viewTrains();
        int trainNumber = readInt("Enter train number: ");
        String name = readLine("Enter passenger name: ");
        int age = readInt("Enter passenger age: ");

        Booking booking = system.bookTicket(trainNumber, name, age);
        System.out.println("\nTicket booked successfully!");
        System.out.println(booking);
    }

    private static void checkTicket() {
        String pnr = readLine("Enter PNR: ");
        Booking booking = system.getBookingByPnr(pnr);

        if (booking == null) {
            System.out.println("No booking found for this PNR.");
        } else {
            System.out.println(booking);
        }
    }

    private static void cancelTicket() {
        String pnr = readLine("Enter PNR to cancel: ");
        system.cancelTicket(pnr);
        System.out.println("Ticket cancelled successfully. Seat released.");
    }

    private static void viewAllBookings() {
        List<Booking> bookings = system.getAllBookings();
        if (bookings.isEmpty()) {
            System.out.println("No bookings available.");
            return;
        }
        for (Booking booking : bookings) {
            System.out.println("-----------------------------");
            System.out.println(booking);
        }
    }

    private static String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static int readInt(String prompt) {
        while (true) {
            try {
                return Integer.parseInt(readLine(prompt));
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
