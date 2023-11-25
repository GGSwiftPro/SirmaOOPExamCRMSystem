package Managers;

import ReaderWrites.CustomReader;
import ReaderWrites.CustomWriter;
import ReaderWrites.JSONReader;
import ReaderWrites.JSONWriter;
import Services.Service;
import com.SirmaAcademy.OOPRetake.Clients.Client;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ClientManager implements Manager {
    private Service service;
    CustomReader r = new JSONReader();
    CustomWriter wr = new JSONWriter();

    List<Client> clientsFromFile ;
    public ClientManager(Service service) {
        this.service = service;
    }

    @Override
    public void performAction(int command) {
        switch (command) {
            case 1 -> {
                Scanner scanner = new Scanner(System.in);
                String name, industry, contactPerson;
                double revenue;

                // Validations for name, industry, contact person, and revenue
                do {
                    System.out.println("Name: ");
                    name = scanner.nextLine().trim();

                    if (name.isEmpty())
                        System.out.println("Name cannot be empty. Please enter a valid name.");
                } while (name.isEmpty());

                do {
                    System.out.println("Industry: ");
                    industry = scanner.nextLine().trim();

                    // Check if the industry is not empty and does not contain any numbers
                    if (industry.isEmpty() || containsNumbers(industry))
                        System.out.println("Industry cannot be empty or have any numbers. Please enter a valid industry.");
                } while (industry.isEmpty() || containsNumbers(industry));

                do {
                    System.out.println("Contact Person: ");
                    contactPerson = scanner.nextLine().trim();

                    // Check if the contact person's name is not empty and does not contain any numbers
                    if (contactPerson.isEmpty() || containsNumbers(contactPerson))
                        System.out.println("Contact Person's name cannot be empty or have any numbers. Please enter a valid name.");
                } while (contactPerson.isEmpty() || containsNumbers(contactPerson));

                do {
                    System.out.println("Revenue: ");
                    try {
                        String StringRevenue = scanner.nextLine();
                        revenue = Double.parseDouble(StringRevenue);

                        // Check if negative
                        if (revenue < 0)
                            System.out.println("Revenue must be a non-negative number. Please enter a valid value.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input for revenue. Please enter a valid number.");
                        scanner.nextLine(); // Consume the newline character
                        revenue = -1;
                    }
                } while (revenue < 0 || !containsOnlyDigits(revenue));

                Client newClient = new Client(name, industry, contactPerson, revenue);

                service.addClient(newClient);
            }
            case 2 -> {
                clientsFromFile = r.read("Clients.json");
                Scanner scanner = new Scanner(System.in);
                String name, industry, contactPerson;
                double revenue;
                 int id;
                 boolean found = false;
                 System.out.println("ID: ");
                 id=scanner.nextInt();
                 scanner.nextLine();
                 for (var curr : clientsFromFile){
                     if(id == curr.getId())found = true;
                 }
                 if(found){
                do {
                    System.out.println("Name: ");
                    name = scanner.nextLine().trim();
                    if (name.isEmpty())
                        System.out.println("Name cannot be empty. Please enter a valid name.");

                } while (name.isEmpty());

                do {
                    System.out.println("Industry: ");
                    industry = scanner.nextLine().trim();

                    // Check if the industry is not empty and does not contain any numbers
                    if (industry.isEmpty() || containsNumbers(industry))
                        System.out.println("Industry cannot be empty or have any numbers. Please enter a valid industry.");
                } while (industry.isEmpty() || containsNumbers(industry));

                do {
                    System.out.println("Contact Person: ");
                    contactPerson = scanner.nextLine().trim();

                    // Check if the contact person's name is not empty and does not contain any numbers
                    if (contactPerson.isEmpty() || containsNumbers(contactPerson))
                        System.out.println("Contact Person's name cannot be empty or have any numbers. Please enter a valid name.");
                } while (contactPerson.isEmpty() || containsNumbers(contactPerson));

                do {
                    System.out.println("Revenue: ");
                    try {
                        String StringRevenue = scanner.nextLine();
                        revenue = Double.parseDouble(StringRevenue);

                        // Check if negative
                        if (revenue < 0)
                            System.out.println("Revenue must be a non-negative number. Please enter a valid value.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input for revenue. Please enter a valid number.");
                        scanner.nextLine(); // Consume the newline character
                        revenue = -1;
                    }
                } while (revenue < 0 || !containsOnlyDigits(revenue));

                Client updateClient = new Client(name, industry, contactPerson, revenue);
                service.updateClient(id,updateClient);
                 }
                 else System.out.println("There was no client with such id!");
            }
            case 3 -> {
                Scanner scanner = new Scanner(System.in);
                int id;
                clientsFromFile = r.read("Clients.json");
                if(clientsFromFile.isEmpty()) System.out.println("There are no clients to remove. Please add some!");
                else {
                do {
                    System.out.println("Enter ID: ");
                    try {
                        id = scanner.nextInt();
                        if (id < 0)
                            System.out.println("ID must be a positive integer. Please enter a valid ID.");

                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid integer for ID.");
                        scanner.nextLine();
                        id = -1;
                    } finally {
                        scanner.nextLine();
                    }
                } while (id < 0);

                service.removeClient(id);}
            }
            case 4 -> {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter name: ");
                String name;
                do {
                    System.out.println("Name: ");
                    name = scanner.nextLine().trim();

                    if (name.isEmpty())
                        System.out.println("Names cannot be empty. Please enter a valid name.");
                } while (name.isEmpty());
                service.SearchClientName(name);
            }
            case 5 -> {
                Scanner scanner = new Scanner(System.in);

                int id;
                do {
                    System.out.println("Enter ID: ");
                    try {
                        id = scanner.nextInt();

                        if (id < 0) {
                            System.out.println("ID must be a positive integer. Please enter a valid ID.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid integer for ID.");
                        scanner.nextLine(); // Consume the invalid input
                        id = -1;
                    } finally {
                        scanner.nextLine(); // Consume the newline character
                    }
                } while (id < 0);

                service.SearchClientId(id);
            }
            case 6 -> {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter industry:");
                String industry ;
                do {
                    System.out.println("Name: ");
                    industry = scanner.nextLine().trim();

                    if (industry.isEmpty() || containsNumbers(industry))
                        System.out.println("Industry cannot be empty or have any numbers. Please enter a valid industry.");
                } while (industry.isEmpty() || containsNumbers(industry));
                service.SearchClientIndustry(industry);
            }
            case 7 -> {
                service.viewClients();
            }
            case 8 -> {
                service.saveAndExit();
                System.out.println("Exiting CRM System. Goodbye!");
            }
            default -> System.out.println("Invalid command. Please enter a valid option.");
        }
    }
    private static boolean containsNumbers(String input) {
        return input.matches(".*\\d.*");
    }
    private static boolean containsOnlyDigits(Double input) {
        if (input == null) return false;
        String inputString = Double.toString(input);
        return inputString.matches("\\d+(\\.\\d+)?");
    }
}
