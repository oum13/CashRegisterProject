import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.time.*;
import java.time.format.*;

public class CashRegister {

    static Scanner scan = new Scanner(System.in);
    static ArrayList<String> products = new ArrayList<>();
    static ArrayList<Double> prices = new ArrayList<>();
    static ArrayList<Integer> quantities = new ArrayList<>();
    static ArrayList<String> menu = new ArrayList<>();
    static ArrayList<String> user = new ArrayList<>();
    static ArrayList<String> pass = new ArrayList<>();
    static String username;

    public static void home() {

        int choice;

        while (true) {
            System.out.println("\n======================================");
            System.out.println("= 1. Register                        =");
            System.out.println("= 2. Login                           =");
            System.out.println("= 3. Exit                            =");
            System.out.println("======================================");

            System.out.print("Enter choice: ");
            
            try {
                choice = scan.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number (1-3).");
                scan.nextLine(); 
                continue; 
            }

            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again!");
            }
        }
    }

    public static void register() {
        scan.nextLine();

        while (true) {
            try {
                System.out.print("Enter username: ");
                String u = scan.nextLine().trim();

                Pattern l = Pattern.compile("^(?=.*\\w)(?=.*\\d)[\\w\\d]{5,15}$");
                Matcher m = l.matcher(u);

                if (m.matches()) {
                    if (user.contains(u)) {
                        System.out.println("The username is already taken.");
                    } else {
                        user.add(u);
                        break;
                    }
                } else {
                    System.out.println("Username must be alphanumeric and 5-15 characters long (with at least one letter and one digit).");
                }
            } catch (Exception e) {
                System.out.println("An error occurred while processing your input. Please try again.");
                continue;
            }
        }

        while (true) {
            try {
                System.out.print("Enter password: ");
                String pw = scan.nextLine().trim();

                Pattern p1 = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,20}$");
                Matcher m1 = p1.matcher(pw);

                if (m1.matches()) {
                    pass.add(pw);
                    break;
                } else {
                    System.out.println("Password must contain at least one uppercase letter, one number, and be 8-20 characters long.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred while processing your input. Please try again.");
                continue;
            }
        }
        home();
    }

    public static void login() {
        String u1;
        char choice;
        scan.nextLine();

        if (user.isEmpty()) {
            System.out.println("\nNo registered account. Please register.");
            return;
        }

        while (true) {
            try {
                System.out.print("Username: ");
                u1 = scan.nextLine().trim();

                if (user.contains(u1)) {
                    break;
                } else {
                    while (true) {
                        System.out.print("Invalid username. Try again? (y/n): ");
                        String input = scan.nextLine().trim().toLowerCase();

                        if (input.isEmpty() || (input.charAt(0) != 'y' && input.charAt(0) != 'n')) {
                            System.out.println("Invalid choice. Try again.");
                        } else {
                            choice = input.charAt(0);
                            break;
                        }
                    }

                    if (choice == 'n') {
                        return;
                    }
                }
            } catch (Exception e) {
                System.out.println("An error occurred while processing username input. Please try again.");
                continue;
            }
        }

        while (true) {
            try {
                System.out.print("Password: ");
                String p = scan.nextLine().trim();

                if (p.equals(pass.get(user.indexOf(u1)))) {
                    username = u1;
                    welcome();
                    break; 
                } else {
                    while (true) {
                        System.out.print("Invalid or wrong password. Try again? (y/n): ");
                        String input = scan.nextLine().trim().toLowerCase();

                        if (input.isEmpty() || (input.charAt(0) != 'y' && input.charAt(0) != 'n')) {
                            System.out.println("Invalid choice. Try again.");
                        } else {
                            choice = input.charAt(0);
                            break;
                        }
                    }

                    if (choice == 'n') {
                        return;
                    }
                }
            } catch (Exception e) {
                System.out.println("An error occurred while processing password input. Please try again.");
                continue;
            }
        }
    }

    public static void welcome() {

        while (true) {
            System.out.println("\n===== Cash Register System =====");
            System.out.println("1. Print Menu");
            System.out.println("2. Add Product");
            System.out.println("3. Display Products");
            System.out.println("4. Remove Product");
            System.out.println("5. Edit Product");
            System.out.println("6. Checkout");
            System.out.println("7. Logout");
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    printMenu();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    displayProducts();
                    break;
                case 4:
                    removeProduct();
                    break;
                case 5:
                    editProduct();
                    break;
                case 6:
                    checkout();
                    break;
                case 7:
                    System.out.println("Logging Out");
                    home();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }
    }

    public static void menuAdd() {
        menu.add("a1");
        menu.add("a2");
        menu.add("a3");
        menu.add("a4");
        menu.add("b1");
        menu.add("b2");
        menu.add("b3");
        menu.add("b4");
        menu.add("c1");
        menu.add("c2");
        menu.add("c3");
        menu.add("c4");
        menu.add("d1");
        menu.add("d2");
        menu.add("d3");
    }

    public static void printMenu() {

        System.out.println("\n====== Main Grill Selections ======");
        System.out.println("a1 - Classic Cheeseburgers - 100.00");
        System.out.println("a2 - BBQ Chicken Thighs - 100.00");
        System.out.println("a3 - Grilled Bratwurst - 110.00");
        System.out.println("a4 - Veggie Skewers - 90.00");

        System.out.println("\n ====== Sides & Salads ======");
        System.out.println("b1 - Corn on the Cob - 50.00");
        System.out.println("b2 - Watermelon Feta Salad - 80.00");
        System.out.println("b3 - Classic Coleslaw - 60.00");
        System.out.println("b4 - Loaded Baked Potato Salad - 85.00");

        System.out.println("\n ====== Refreshing Drinks ======");
        System.out.println("c1 - Homemade Lemonade - 40.00");
        System.out.println("c2 - Iced Sweet Tea - 35.00");
        System.out.println("c3 - Watermelon Mojitos - 90.00");
        System.out.println("c4 - Craft Beer Selection - 120.00");

        System.out.println("\n ====== Desserts ======");
        System.out.println("d1 - Grilled Peaches & Ice Cream - 70.00");
        System.out.println("d2 - S'mores Bar - 50.00");
        System.out.println("d3 - Berry Parfaits - 75.00\n");

        System.out.print("Press Enter to return to the Cash Register System...");
        scan.nextLine();
    }

    public static void addProduct() {

        while (true) {
            String code;
            char choice;

            while (true) {
                try {
                    System.out.print("\nEnter the product code: ");
                    code = scan.nextLine().trim().toLowerCase();

                    if (code.isEmpty()) {
                        System.out.println("Input cannot be empty. Please enter a product code.");
                        continue;
                    }

                    if (menu.contains(code)) {
                        break;
                    } else {
                        System.out.println("Invalid input! Please try again!");
                        System.out.println("Product code example: a1, b2, c3...");
                    }
                } catch (Exception e) {
                    System.out.println("An unexpected error occurred. Please try again.");
                    continue;
                }
            }

            System.out.print("Enter quantity: ");
            int qty = scan.nextInt();

            switch (code) {
                case "a1":
                    products.add("Classic Cheeseburgers");
                    prices.add(100.00);
                    quantities.add(qty);
                    break;
                case "a2":
                    products.add("BBQ Chicken Thighs");
                    prices.add(100.00);
                    quantities.add(qty);
                    break;
                case "a3":
                    products.add("Grilled Bratwurst");
                    prices.add(110.00);
                    quantities.add(qty);
                    break;
                case "a4":
                    products.add("Veggie Skewers");
                    prices.add(90.00);
                    quantities.add(qty);
                    break;
                case "b1":
                    products.add("Corn on the Cob");
                    prices.add(50.00);
                    quantities.add(qty);
                    break;
                case "b2":
                    products.add("Watermelon Feta Salad");
                    prices.add(80.00);
                    quantities.add(qty);
                    break;
                case "b3":
                    products.add("Classic Coleslaw");
                    prices.add(60.00);
                    quantities.add(qty);
                    break;
                case "b4":
                    products.add("Loaded Baked Potato Salad");
                    prices.add(85.00);
                    quantities.add(qty);
                    break;
                case "c1":
                    products.add("Homemade Lemonade");
                    prices.add(40.00);
                    quantities.add(qty);
                    break;
                case "c2":
                    products.add("Iced Sweet Tea");
                    prices.add(35.00);
                    quantities.add(qty);
                    break;
                case "c3":
                    products.add("Watermelon Mojitos");
                    prices.add(90.00);
                    quantities.add(qty);
                    break;
                case "c4":
                    products.add("Craft Beer Selection");
                    prices.add(120.00);
                    quantities.add(qty);
                    break;
                case "d1":
                    products.add("Grilled Peaches & Ice Cream");
                    prices.add(70.00);
                    quantities.add(qty);
                    break;
                case "d2":
                    products.add("S'mores Bar");
                    prices.add(50.00);
                    quantities.add(qty);
                    break;
                case "d3":
                    products.add("Berry Parfaits");
                    prices.add(75.00);
                    quantities.add(qty);
                    break;
                default:
                    System.exit(0);
            }

            System.out.println("Product added successfully!\n");

            while (true) {
                try {
                    System.out.print("Do you want to add another product? (y/n): ");
                    String input = scan.next().trim().toLowerCase();

                    if (input.isEmpty()) {
                        System.out.println("Input cannot be empty. Try again.");
                        continue;
                    }

                    choice = input.charAt(0);

                    if (choice != 'y' && choice != 'n') {
                        System.out.println("Invalid choice. Please enter 'y' or 'n'.");
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("An error occurred. Please try again."); 
                }
            }

            if (choice == 'n') {
                break;
            }
            scan.nextLine();
        }
    }

    public static void removeProduct() {
        char choice;

        if (products.isEmpty()) {
            System.out.println("\nNo products available to remove.\n");
            return;
        }

        displayProducts();

       while (true) {
            try {

                System.out.print("\nEnter the product number to remove: ");
                int productNum = scan.nextInt();
                scan.nextLine(); 

                if (productNum < 1 || productNum > products.size()) {
                    System.out.println("Invalid product number!\n");
                    continue; 
                }

                products.remove(productNum - 1);
                System.out.println("Product has been successfully removed.");

                while (true) {
                    System.out.print("Do you want to remove another product? (y/n): ");
                    String input = scan.nextLine().trim().toLowerCase();

                    if (input.isEmpty()) {
                        System.out.println("Input cannot be empty. Try again.");
                        continue;
                    }

                    choice = input.charAt(0);

                    if (choice != 'y' && choice != 'n') {
                        System.out.println("Invalid choice. Try again.");
                    } else {
                        break;
                    }
                }

                if (choice == 'n') {
                    break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scan.nextLine(); 
            } catch (Exception e) {
                System.out.println("An unexpected error occurred. Please try again.");
                scan.nextLine(); 
            }
        }
    }

    public static void editProduct() {
        char choice;

        if (products.isEmpty()) {
            System.out.println("\nNo products available to edit quantity.\n");
            return;
        }

        displayProducts();

       while (true) {
            try {
                System.out.print("Enter product number to edit quantity from: ");
                int productNum = scan.nextInt();
                scan.nextLine(); 

                if (productNum < 1 || productNum > products.size()) {
                    System.out.println("Invalid product number!\n");
                    continue;
                }

                System.out.print("Enter the new quantity: ");
                int newQty = scan.nextInt();
                scan.nextLine(); 
                quantities.set(productNum - 1, newQty);
                System.out.println("Quantity of product has been changed.");

                while (true) {
                    System.out.print("Do you want to change the quantity of another product? (y/n): ");
                    String input = scan.nextLine().trim().toLowerCase();

                    if (input.isEmpty() || (input.charAt(0) != 'y' && input.charAt(0) != 'n')) {
                        System.out.println("Invalid choice. Try again.");
                    } else {
                        choice = input.charAt(0);
                        break;
                    }
                }

                if (choice == 'n') {
                    break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter numbers only.");
                scan.nextLine(); 
            } catch (Exception e) {
                System.out.println("An unexpected error occurred. Please try again.");
                scan.nextLine(); 
            }
        }
    }

    public static void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.\n");
            return;
        }

        System.out.println("\nProduct List:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i) + " - PHP" + prices.get(i) + " - Quantity: " + quantities.get(i));
        }
        System.out.println();
    }

    public static void checkout() {
        char choice;

        LocalDateTime dt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        String dtFormatted = dt.format(dtf);

        if (products.isEmpty()) {
            System.out.println("No products in the cart.\n");
            return;
        }

        double totalPrice = 0;

        System.out.print("\n======================Transaction Details======================\n");
        System.out.print("Date & Time: " + dtFormatted);
        System.out.print("\nUser: " + username);
        System.out.print("\n===============================================================\n");

        for (int i = 0; i < products.size(); i++) {
            double itemTotal = prices.get(i) * quantities.get(i);
            totalPrice += itemTotal;

            System.out.println(products.get(i) + " - " + quantities.get(i) + " x PHP" + prices.get(i) + " = PHP" + itemTotal);
        }
        System.out.print("===============================================================\n");
        System.out.print("Total Price: PHP" + totalPrice);
        System.out.print("\n===============================================================\n");

       double payment = 0;

        while (true) {
            try {
                System.out.print("Enter payment amount: ");
                payment = scan.nextDouble();
                scan.nextLine(); 
                if (payment < totalPrice) {
                    System.out.println("Insufficient payment. Transaction canceled.\n");
                    return;
                }

                break; 

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scan.nextLine();
            } catch (Exception e) {
                System.out.println("An unexpected error occurred. Please try again.");
                scan.nextLine(); 
            }
        }

        double change = payment - totalPrice;
        System.out.println("Payment accepted. Change: PHP" + change + "\n");
        System.out.println("Transaction completed!\n");

        deets();

        while (true) {
            try {
                System.out.print("Do you want to do another transaction? (y/n): ");
                String input = scan.next().trim().toLowerCase();
                scan.nextLine(); 

                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty. Try again.");
                    continue;
                }

                choice = input.charAt(0);

                if (choice != 'y' && choice != 'n') {
                    System.out.println("Invalid choice. Please enter 'y' or 'n'.");
                } else {
                    products.clear();
                    prices.clear();
                    quantities.clear();
                    break;
                }

            } catch (Exception e) {
                System.out.println("An unexpected error occurred. Please try again.");
                scan.nextLine(); 
            }
        }

        if (choice == 'n') {
            System.exit(0);
        }
    }

    public static void deets() {
        LocalDateTime dt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        String dtFormatted = dt.format(dtf);

        File transaction = new File("transactions.txt");

        double totalPrice = 0;
        try {
            FileWriter writer = new FileWriter(transaction, true);

            writer.write("\n======================Transaction Details======================\n");
            writer.write("Date & Time: " + dtFormatted);
            writer.write("\nUser: " + username);
            writer.write("\n===============================================================\n");

            for (int i = 0; i < products.size(); i++) {
                double itemTotal = prices.get(i) * quantities.get(i);
                totalPrice += itemTotal;

                writer.write((i + 1) + ". " + products.get(i) + " - Quantity: " + quantities.get(i) + " - Price each: PHP" + prices.get(i) + "\n");
            }

            writer.write("===============================================================\n");
            writer.write("Total: PHP" + totalPrice);
            writer.write("\n========================Thank You !!===========================\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        menuAdd();
        home();
    }
}
