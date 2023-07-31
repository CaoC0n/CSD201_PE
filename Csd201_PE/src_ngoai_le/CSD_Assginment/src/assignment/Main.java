/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Main {

    private static ProductList productList = new ProductList();
    private static CustomerList customerList = new CustomerList();
    private static OrderList orderList = new OrderList();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    productMenu(scanner);
                    break;
                case 2:
                    customerMenu(scanner);
                    break;
                case 3:
                    orderMenu(scanner);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Product list");
        System.out.println("2. Customer list");
        System.out.println("3. Order list");
        System.out.println("0. Exit");
    }

    private static void productMenu(Scanner scanner) {
        int choice;
        do {
            displayProductMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    loadDataFromFile(scanner, "product");
                    break;
                case 2:
                    addProduct(scanner);
                    break;
                case 3:
                    productList.display();
                    break;
                case 4:
                    saveDataToFile(scanner, productList);
                    break;
                case 5:
                    searchProduct(scanner);
                    break;
                case 6:
                    deleteProduct(scanner);
                    break;
                case 7:
                    productList.sort();
                    break;
                case 8:
                    addProductAfterPosition(scanner);
                    break;
                case 9:
                    deleteNodeAfterProduct(scanner);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);
    }

    private static void displayProductMenu() {
        System.out.println("Product list:");
        System.out.println("1. Load data from file");
        System.out.println("2. Input & add to the end");
        System.out.println("3. Display data");
        System.out.println("4. Save product list to file");
        System.out.println("5. Search by pcode");
        System.out.println("6. Delete by pcode");
        System.out.println("7. Sort by pcode");
        System.out.println("8. Add after position k");
        System.out.println("9. Delete the node after the node having code = xCode");
        System.out.println("0. Return to main menu");
    }

    private static void addProduct(Scanner scanner) {
        System.out.print("Enter product code: ");
        String pcode = scanner.nextLine();
        System.out.print("Enter product name: ");
        String proName = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter number of products sold: ");
        int saled = scanner.nextInt();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Product product = new Product(pcode, proName, quantity, saled, price);
        productList.add(product);
        System.out.println("Product added successfully.");
    }

    private static void searchProduct(Scanner scanner) {
        System.out.print("Enter product code to search: ");
        String pcode = scanner.nextLine();
        ProductList.Node result = productList.search(pcode);
        if (result != null) {
            System.out.println("Product found: " + result.data);
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void deleteProduct(Scanner scanner) {
        System.out.print("Enter product code to delete: ");
        String pcode = scanner.nextLine();
        productList.delete(pcode);
        System.out.println("Product deleted successfully.");
    }

    private static void addProductAfterPosition(Scanner scanner) {
        System.out.print("Enter the position to add after: ");
        int k = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter product code: ");
        String pcode = scanner.nextLine();
        System.out.print("Enter product name: ");
        String proName = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter number of products sold: ");
        int saled = scanner.nextInt();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Product product = new Product(pcode, proName, quantity, saled, price);
        productList.addAfterPosition(k, product);
        System.out.println("Product added successfully.");
    }

    private static void deleteNodeAfterProduct(Scanner scanner) {
        System.out.print("Enter product code to delete the node after: ");
        String pcode = scanner.nextLine();
        productList.deleteNodeAfter(pcode);
        System.out.println("Node deleted successfully.");
    }

    private static void customerMenu(Scanner scanner) {
        int choice;
        do {
            displayCustomerMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    loadDataFromFile(scanner, "customer");
                    break;
                case 2:
                    addCustomer(scanner);
                    break;
                case 3:
                    customerList.display();
                    break;
                case 4:
                    saveDataToFile(scanner, customerList);
                    break;
                case 5:
                    searchCustomer(scanner);
                    break;
                case 6:
                    deleteCustomer(scanner);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);
    }

    private static void displayCustomerMenu() {
        System.out.println("Customer list:");
        System.out.println("1. Load data from file");
        System.out.println("2. Input & add to the end");
        System.out.println("3. Display data");
        System.out.println("4. Save customer list to file");
        System.out.println("5. Search by ccode");
        System.out.println("6. Delete by ccode");
        System.out.println("0. Return to main menu");
    }

    private static void addCustomer(Scanner scanner) {
        System.out.print("Enter customer code: ");
        String ccode = scanner.nextLine();
        System.out.print("Enter customer name: ");
        String cusName = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();

        Customer customer = new Customer(ccode, cusName, phone);
        customerList.add(customer);
        System.out.println("Customer added successfully.");
    }

    private static void searchCustomer(Scanner scanner) {
        System.out.print("Enter customer code to search: ");
        String ccode = scanner.nextLine();
        CustomerList.Node result = customerList.search(ccode);
        if (result != null) {
            System.out.println("Customer found: " + result.data);
        } else {
            System.out.println("Customer not found.");
        }
    }

    private static void deleteCustomer(Scanner scanner) {
        System.out.print("Enter customer code to delete: ");
        String ccode = scanner.nextLine();
        customerList.delete(ccode);
        System.out.println("Customer deleted successfully.");
    }

    private static void orderMenu(Scanner scanner) {
        int choice;
        do {
            displayOrderMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    loadDataFromFile(scanner, "order");
                    break;
                case 2:
                    addOrder(scanner);
                    break;
                case 3:
                    orderList.displayWithTotalValue(productList);
                    break;
                case 4:
                    saveDataToFile(scanner, orderList);
                    break;
                case 5:
                    orderList.sort();
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);
    }

    private static void displayOrderMenu() {
        System.out.println("Order list:");
        System.out.println("1. Load data from file");
        System.out.println("2. Input & add to the end");
        System.out.println("3. Display data with total value");
        System.out.println("4. Save order list to file");
        System.out.println("5. Sort by pcode and ccode");
        System.out.println("0. Return to main menu");
    }

    private static void addOrder(Scanner scanner) {
        System.out.print("Enter product code: ");
        String pcode = scanner.nextLine();
        System.out.print("Enter customer code: ");
        String ccode = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        Order order = new Order(pcode, ccode, quantity);
        orderList.add(order);
        System.out.println("Order added successfully.");
    }

    private static void loadDataFromFile(Scanner scanner, String dataType) {
        System.out.print("Enter file name to load data: ");
        String fileName = scanner.nextLine();

        try {
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);
            switch (dataType) {
                case "product":
                    loadProductData(fileScanner);
                    break;
                case "customer":
                    loadCustomerData(fileScanner);
                    break;
                case "order":
                    loadOrderData(fileScanner);
                    break;
            }
            fileScanner.close();
            System.out.println("Data loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    private static void loadProductData(Scanner scanner) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data = line.split(",");
            if (data.length == 5) {
                String pcode = data[0].trim();
                String proName = data[1].trim();
                int quantity = Integer.parseInt(data[2].trim());
                int saled = Integer.parseInt(data[3].trim());
                double price = Double.parseDouble(data[4].trim());
                Product product = new Product(pcode, proName, quantity, saled, price);
                productList.add(product);
            }
        }
    }

    private static void loadCustomerData(Scanner scanner) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data = line.split(",");
            if (data.length == 3) {
                String ccode = data[0].trim();
                String cusName = data[1].trim();
                String phone = data[2].trim();
                Customer customer = new Customer(ccode, cusName, phone);
                customerList.add(customer);
            }
        }
    }

    private static void loadOrderData(Scanner scanner) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data = line.split(",");
            if (data.length == 3) {
                String pcode = data[0].trim();
                String ccode = data[1].trim();
                int quantity = Integer.parseInt(data[2].trim());
                Order order = new Order(pcode, ccode, quantity);
                orderList.add(order);
            }
        }
    }

    private static void saveDataToFile(Scanner scanner, Object data) {
        System.out.print("Enter file name to save data: ");
        String fileName = scanner.nextLine();

        try {
            File file = new File(fileName);
            FileWriter writer = new FileWriter(file);
            if (data instanceof ProductList) {
                saveProductData(writer, (ProductList) data);
            } else if (data instanceof CustomerList) {
                saveCustomerData(writer, (CustomerList) data);
            } else if (data instanceof OrderList) {
                saveOrderData(writer, (OrderList) data);
            }
            writer.close();
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while saving data.");
        }
    }

    private static void saveProductData(FileWriter writer, ProductList productList) throws IOException {
        ProductList.Node current = productList.head;
        while (current != null) {
            writer.write(current.data.pcode + ", " + current.data.proName + ", "
                    + current.data.quantity + ", " + current.data.saled + ", "
                    + current.data.price + "\n");
            current = current.next;
        }
    }

    private static void saveCustomerData(FileWriter writer, CustomerList customerList) throws IOException {
        CustomerList.Node current = customerList.head;
        while (current != null) {
            writer.write(current.data.ccode + ", " + current.data.cusName + ", "
                    + current.data.phone + "\n");
            current = current.next;
        }
    }

    private static void saveOrderData(FileWriter writer, OrderList orderList) throws IOException {
        OrderList.Node current = orderList.head;
        while (current != null) {
            writer.write(current.data.pcode + ", " + current.data.ccode + ", "
                    + current.data.quantity + "\n");
            current = current.next;
        }
    }
}
