package in.cg.main;

import in.cg.services.*;
import in.cg.entities.Address;

import java.util.*;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CustomerService customerService = new CustomerService();
        LeadService leadService = new LeadService();
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();
        TicketService ticketService = new TicketService();
        ReportService reportService = new ReportService();

        while (true) {

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

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    customerService.registerCustomer("Abhinav", "abhi@gmail.com", "9999999999");
                    break;

                case 2:
                    Address address = new Address();
                    address.setStreet("Street 1");
                    address.setCity("Delhi");
                    address.setState("Delhi");
                    address.setZipCode("110001");
                    customerService.addAddressToCustomer(1L, address);
                    break;

                case 3:
                    leadService.createLead("Rahul", "Website", "rahul@gmail.com");
                    break;

                case 4:
                    leadService.assignLeadToEmployee(1L, 1L);
                    break;

                case 5:
                    leadService.convertLeadToCustomer(1L);
                    break;

                case 6:
                    productService.addProduct("Laptop", 60000);
                    break;

                case 7:
                    orderService.placeOrder(1L, Arrays.asList(1L));
                    break;

                case 8:
                    ticketService.raiseTicket(1L, "Product Not Working");
                    break;

                case 9:
                    reportService.getEmployeePerformance(1L);
                    break;

                case 10:
                    System.exit(0);
            }
        }
    }
}