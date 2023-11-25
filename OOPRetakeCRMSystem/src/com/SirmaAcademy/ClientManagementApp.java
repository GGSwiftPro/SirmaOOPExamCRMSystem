package Starter;
import Managers.ClientManager;
import Managers.Manager;
import ReaderWrites.CustomReader;
import ReaderWrites.CustomWriter;
import ReaderWrites.JSONReader;
import ReaderWrites.JSONWriter;
import Services.ClientService;
import Services.Service;

import java.util.Scanner;

public class ClientManagementApp {
    public static void main(String[] args) {
        // Implement file operations for XML/SQLite
        Scanner scanner = new Scanner(System.in);
        CustomReader fileReader = new JSONReader();
        CustomWriter fileWriter = new JSONWriter();
        Service service = new ClientService(fileReader, fileWriter);
        Manager manager = new ClientManager(service);
        int command;
        System.out.println("Welcome to the CRM System");
        displayOptions();
        boolean active = true;
        while (active) {
            command = Integer.parseInt(scanner.next());
            manager.performAction(command);
            if (command == 8)
                active = false;
            else
                displayOptions();

            //TODO
            // Add Validations on Adding client -- Done
            // Add Validation on updating client -- Done
            // Add validation fore id when removing -- Done
            // Add validation when searching by name - Done
            // Add validation when searching by id -- Done
            // Add validation when searching by industry -- Done
            // Validation if list is empty on remove -- Done
            // When search name and nothing found to print nothing found
            // When search  id and nothing found to print nothing found
            // When search  industry and nothing found to print nothing found
            // When updating non existing id -- DONE


            // Add Client -- Done
            // Update Client -- Done
            // Remove Client 1 -- Done
            // Search Name Oceanic -- Done
            // Search Industry Tech -- Done
            // Search ID 1 - Done
            // View Clients -- Done
            // Save & Exit -- Done
        }
    }
    private static void displayOptions() {
        System.out.println("1. Add Client");
        System.out.println("2. Update Client");
        System.out.println("3. Remove Client");
        System.out.println("4. Search Client Name");
        System.out.println("5. Search Client Id");
        System.out.println("6. Search Client industry");
        System.out.println("7. View Clients");
        System.out.println("8. Exit");

    }
}
