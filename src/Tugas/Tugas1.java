package Tugas;

import java.util.Scanner;

public class Tugas1 {
    private static class BrowserHistory {

        private static final int MAX_HISTORY_SIZE = 10;
        private String[] history;
        private int currentIndex;

        public BrowserHistory() {
            history = new String[MAX_HISTORY_SIZE];
            currentIndex = 1;
        }

        public void visitURL(String url) {
            if (currentIndex < MAX_HISTORY_SIZE - 1) {
                currentIndex++;
                history[currentIndex] = url;
                System.out.println("Visited URL: " + url);
            } else {
                System.out.println("History full. Cannot add more URLs.");
            }
        }

        public void back() {
            if (currentIndex > 0) {
                currentIndex--;
                System.out.println("Back to: " + history[currentIndex]);
            } else {
                System.out.println("No previous URL in history.");
            }
        }

        public void forward() {
            if (currentIndex < MAX_HISTORY_SIZE - 1 && history[currentIndex + 1] != null) {
                currentIndex++;
                System.out.println("Forward to: " + history[currentIndex]);
            } else {
                System.out.println("No forward URL in history.");
            }
        }

        public void getCurrentURL() {
            if (currentIndex >= 0) {
                System.out.println("Current URL: " + history[currentIndex]);
            } else {
                System.out.println("No URL visited yet.");
            }
        }
    }

    public static void main(String[] args) {
        BrowserHistory browser = new BrowserHistory();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Visit URL");
            System.out.println("2. Back");
            System.out.println("3. Forward");
            System.out.println("4. Current URL");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter URL: ");
                        String url = scanner.nextLine();
                        browser.visitURL(url);
                        break;
                    case 2:
                        browser.back();
                        break;
                    case 3:
                        browser.forward();
                        break;
                    case 4:
                        browser.getCurrentURL();
                        break;
                    case 0:
                        System.out.println("Exiting program...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (choice != 0);

        scanner.close();
    }
}
