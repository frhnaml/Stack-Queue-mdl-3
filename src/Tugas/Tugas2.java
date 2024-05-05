package Tugas;

import java.util.Scanner;

public class Tugas2 {
    private static class Ticket {
        private int uid;
        private int ticketNumber;
        private String name;
        private int quantity;
        private Ticket next;

        public Ticket(int uid, int ticketNumber, String name, int quantity) {
            this.uid = uid;
            this.ticketNumber = ticketNumber;
            this.name = name;
            this.quantity = quantity;
            this.next = null;
        }

        public int getUid() {
            return uid;
        }

        public int getTicketNumber() {
            return ticketNumber;
        }

        public String getName() {
            return name;
        }

        public int getQuantity() {
            return quantity;
        }
    }

    public static void main(String[] args) {
        TicketSystem ticketSystem = new TicketSystem();
        ticketSystem.run();
    }

    private static class TicketSystem {
        private Ticket front = null;
        private Ticket rear = null;
        private int ticketNumber = 1;
        private int uidCounter = 1;

        private void enqueue(String name, int quantity) {
            if (quantity <= 0) {
                throw new IllegalArgumentException("Quantity must be greater than 0.");
            }

            Ticket newTicket = new Ticket(uidCounter++, ticketNumber++, name, quantity);
            if (rear == null) {
                front = rear = newTicket;
            } else {
                rear.next = newTicket;
                rear = newTicket;
            }
            System.out.println("Ticket booked successfully. Ticket UID: " + (uidCounter - 1));
        }

        private void dequeue(int uid) {
            Ticket current = front;
            Ticket prev = null;

            while (current != null && current.getUid() != uid) {
                prev = current;
                current = current.next;
            }

            if (current == null) {
                System.out.println("Ticket with UID " + uid + " not found.");
            } else {
                if (prev == null) {
                    front = front.next;
                } else {
                    prev.next = current.next;
                }

                if (current == rear) {
                    rear = prev;
                }

                System.out.println(
                        "Removed Ticket: Ticket UID " + current.getUid() + ": Ticket " + current.getTicketNumber()
                                + ": " + current.getName() + " - Quantity: " + current.getQuantity());
            }
        }

        private void displayTickets() {
            if (front == null) {
                System.out.println("No tickets booked yet.");
            } else {
                Ticket current = front;
                System.out.println("Ticket Bookings:");
                while (current != null) {
                    System.out.println("Ticket UID " + current.getUid() + ": Ticket " + current.getTicketNumber() + ": "
                            + current.getName() + " - Quantity: " + current.getQuantity());
                    current = current.next;
                }
            }
        }

        public void run() {
            Scanner scanner = new Scanner(System.in);

            int choice;
            do {
                System.out.println("\n1. Add Ticket Booking");
                System.out.println("2. View Ticket Bookings");
                System.out.println("3. Remove Ticket Booking");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline character

                try {
                    switch (choice) {
                        case 1:
                            System.out.print("Enter your name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter quantity of tickets: ");
                            int quantity = scanner.nextInt();
                            scanner.nextLine(); // consume newline character
                            enqueue(name, quantity);
                            break;
                        case 2:
                            displayTickets();
                            break;
                        case 3:
                            System.out.print("Enter ticket UID to remove: ");
                            int uidToRemove = scanner.nextInt();
                            scanner.nextLine(); // consume newline character
                            dequeue(uidToRemove);
                            break;
                        case 0:
                            System.out.println("Exiting program...");
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } while (choice != 0);

            scanner.close();
        }
    }
}
