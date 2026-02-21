package in.cg.main;

import in.cg.services.*;
import in.cg.entities.Address;

import java.util.*;

public class App {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        CustomerService customerService = new CustomerService();
        LeadService leadService = new LeadService();
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();
        TicketService ticketService = new TicketService();
        ReportService reportService = new ReportService();

        while (true) {

            printMenu();

            int choice = getIntInput("Enter your choice: ");

            switch (choice) {

                case 1:
                    registerCustomer(customerService);
                    break;

                case 2:
                    addAddress(customerService);
                    break;

                case 3:
                    createLead(leadService);
                    break;

                case 4:
                    assignLead(leadService);
                    break;

                case 5:
                    convertLead(leadService);
                    break;

                case 6:
                    addProduct(productService);
                    break;

                case 7:
                    placeOrder(orderService);
                    break;

                case 8:
                    raiseTicket(ticketService);
                    break;

                case 9:
                    employeePerformance(reportService);
                    break;

                case 10:
                    System.out.println("Exiting CRM System...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // ================= MENU =================

    private static void printMenu() {
        System.out.println("\n===== CRM MENU =====");
        System.out.println("1. Register Customer");
        System.out.println("2. Add Address");
        System.out.println("3. Create Lead");
        System.out.println("4. Assign Lead");
        System.out.println("5. Convert Lead");
        System.out.println("6. Add Product");
        System.out.println("7. Place Order");
        System.out.println("8. Raise Ticket");
        System.out.println("9. Employee Performance");
        System.out.println("10. Exit");
    }

    // ================= INPUT HELPERS =================

    private static int getIntInput(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number! Try again.");
            }
        }
    }

    private static Long getLongInput(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Long.parseLong(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID! Try again.");
            }
        }
    }

    // ================= OPERATIONS =================

    private static void registerCustomer(CustomerService service) {

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();

        service.registerCustomer(name, email, phone);
    }

    private static void addAddress(CustomerService service) {

        Long customerId = getLongInput("Enter Customer ID: ");

        Address address = new Address();

        System.out.print("Enter Street: ");
        address.setStreet(sc.nextLine());

        System.out.print("Enter City: ");
        address.setCity(sc.nextLine());

        System.out.print("Enter State: ");
        address.setState(sc.nextLine());

        System.out.print("Enter Zip Code: ");
        address.setZipCode(sc.nextLine());

        service.addAddressToCustomer(customerId, address);
    }

    private static void createLead(LeadService service) {

        System.out.print("Enter Lead Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Source: ");
        String source = sc.nextLine();

        System.out.print("Enter Contact Info: ");
        String contact = sc.nextLine();

        service.createLead(name, source, contact);
    }

    private static void assignLead(LeadService service) {

        Long leadId = getLongInput("Enter Lead ID: ");
        Long employeeId = getLongInput("Enter Employee ID: ");

        service.assignLeadToEmployee(leadId, employeeId);
    }

    private static void convertLead(LeadService service) {

        Long leadId = getLongInput("Enter Lead ID to Convert: ");
        service.convertLeadToCustomer(leadId);
    }

    private static void addProduct(ProductService service) {

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        int price = getIntInput("Enter Product Price: ");

        service.addProduct(name, price);
    }

    private static void placeOrder(OrderService service) {

        Long customerId = getLongInput("Enter Customer ID: ");

        System.out.print("Enter Product IDs (comma separated): ");
        String input = sc.nextLine();

        List<Long> productIds = new ArrayList<>();

        for (String id : input.split(",")) {
            productIds.add(Long.parseLong(id.trim()));
        }

        service.placeOrder(customerId, productIds);
    }

    private static void raiseTicket(TicketService service) {

        Long orderId = getLongInput("Enter Order ID: ");

        System.out.print("Enter Issue Description: ");
        String issue = sc.nextLine();

        service.raiseTicket(orderId, issue);
    }

    private static void employeePerformance(ReportService service) {

        Long empId = getLongInput("Enter Employee ID: ");
        service.getEmployeePerformance(empId);
    }
}