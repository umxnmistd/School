import java.util.Scanner;

public class Movie {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String movie = "";
        String form = "";
        String dics = "";
        double format = 0;
        double price = 0;

        System.out.println("=== CINEMA TICKETING SYSTEM ===");
        System.out.println("1. Avengers: Endgame");
        System.out.println("2. Frozen II");
        System.out.println("3. Spider-Man: No Way Home");
        System.out.println("4. The Batman");
        System.out.println("5. Inside Out 2");

        System.out.print("\nSelect Movie (1-5): ");
        char select = scan.next().charAt(0);

        if (select >= '1' && select <= '5') {
            switch (select) {
                case '1' -> movie = "Avengers: Endgame";
                case '2' -> movie = "Frozen II";
                case '3' -> movie = "Spider-Man: No Way Home";
                case '4' -> movie = "The Batman";
                case '5' -> movie = "Inside Out 2";
            }

            System.out.println("\nSelect Show Format:");
            System.out.println("1. 2D (No extra cost)");
            System.out.println("2. 3D (+Php 50)");
            System.out.println("3. IMAX (+Php 100)");
            System.out.print("Enter choice (1-3): ");
            char choice = scan.next().charAt(0);

            if (choice >= '1' && choice <= '3') {
                switch (choice) {
                    case '1' -> { form = "2D (No extra cost)"; format = 0; }
                    case '2' -> { form = "3D (+Php 50)"; format = 50; }
                    case '3' -> { form = "IMAX (+Php 100)"; format = 100; }
                }

                System.out.println("\nTicket Categories:");
                System.out.println("1. Regular Fee - Php 200");
                System.out.println("2. Student Fee - Php 150");
                System.out.println("3. Senior Fee - Php 100");
                System.out.print("Enter Category (1-3): ");
                char category = scan.next().charAt(0);

                if (category >= '1' && category <= '3') {
                    switch (category) {
                        case '1' -> { dics = "Regular Fee - Php 200"; price = 200; }
                        case '2' -> { dics = "Student Fee - Php 150"; price = 150; }
                        case '3' -> { dics = "Senior Fee - Php 100"; price = 100; }
                    }

                    System.out.print("\nEnter Number of Tickets: ");
                    int tickets = scan.nextInt();

                    // Apply bulk discount if buying 5 or more tickets
                    double discountRate = 0;
                    if (tickets >= 5) {
                        discountRate = 0.10; // 10% discount
                    }

                    double totalPerTicket = price + format;
                    double subtotal = totalPerTicket * tickets;
                    double discount = subtotal * discountRate;
                    double finalTotal = subtotal - discount;

                    System.out.println("\n==== BILL SUMMARY ====");
                    System.out.println("Selected Movie     : " + movie);
                    System.out.println("Show Format        : " + form);
                    System.out.println("Ticket Category    : " + dics);
                    System.out.println("Price Per Ticket   : Php " + totalPerTicket);
                    System.out.println("Quantity           : " + tickets);
                    System.out.println("------------------------------");
                    System.out.println("Subtotal           : Php " + subtotal);
                    System.out.println("Discount (10%)     : Php " + discount);
                    System.out.println("Final Total        : Php " + finalTotal);

                    System.out.print("\nEnter Payment Amount: Php ");
                    double amount = scan.nextDouble();

                    if (amount > finalTotal) {
                        System.out.println("Change: Php " + (amount - finalTotal));
                    } else if (amount == finalTotal) {
                        System.out.println("Exact Payment. Thank you!");
                    } else {
                        System.out.println("Insufficient Payment. You still owe Php " + (finalTotal - amount));
                    }

                    System.out.println("\nTransaction Successful.");
                } else {
                    System.out.println("Invalid Category Input.");
                }
            } else {
                System.out.println("Invalid Format Input.");
            }
        } else {
            System.out.println("Invalid Movie Selection.");
        }

        scan.close();
    }
}
