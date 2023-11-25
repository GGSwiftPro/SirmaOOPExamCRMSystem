package Services;

import ReaderWrites.CustomReader;
import ReaderWrites.CustomWriter;
import com.SirmaAcademy.OOPRetake.Clients.Client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClientService implements Service{
    CustomReader r;
    CustomWriter wr;
    List<Client> temp = new ArrayList<>();
    List<Client> clientsFromFile;

    public ClientService(CustomReader fileReader, CustomWriter fileWriter) {
        this.r = fileReader;
        this.wr = fileWriter;
    }

    @Override
    public void addClient(Client client) {
        temp.add(client);
        wr.write( temp, "Clients.json");
    }

    @Override
    public void updateClient(int id, Client client) {
        clientsFromFile = r.read("Clients.json");
        boolean updated = false;
        for (var curr : clientsFromFile)
            if (id == curr.getId()) {
                Client e = new Client(curr.getName(),curr.getIndustry(),curr.getContactPerson(),curr.getRevenue());
                clientsFromFile.remove(curr.getId());
                e.setId(curr.getId());
                e.setName(client.getName());
                e.setIndustry(client.getIndustry());
                e.setContactPerson(client.getContactPerson());
                e.setRevenue(client.getRevenue());
                clientsFromFile.add(e);
                wr.write(clientsFromFile,"Clients.json");
            }
    }

    @Override
    public void removeClient(int id) {

        clientsFromFile = r.read("Clients.json");
        Iterator<Client> iterator = clientsFromFile.iterator();
        boolean deleted = false;
        if(clientsFromFile.isEmpty()) System.out.println("There are no clients to remove. Please add some!");
        while (iterator.hasNext()) {
            Client curr = iterator.next();
            if (id == curr.getId()) {iterator.remove(); deleted = true;}
        }
        if (!deleted) System.out.println("Didn't find client with that id!");
        wr.write(clientsFromFile, "Clients.json");

    }

    @Override
    public void viewClients() {
        clientsFromFile =  r.read("Clients.json");
        if (clientsFromFile != null && !clientsFromFile.isEmpty()) {
            System.out.println("List of Clients:");
            for (var clients : clientsFromFile) {
                System.out.println(clients.Information());
            }
        } else {
            System.out.println("No clients found.");
        }
    }

    @Override
    public void SearchClientName(String clientName) {
        boolean found = false;
        clientsFromFile = r.read("Clients.json");
        for (var curr : clientsFromFile)
            if (clientName.equalsIgnoreCase(curr.getName()))
            {
                found= true;
                System.out.println(curr.Information());
            }

        if(!found)System.out.println("Couldn't find client with that name!");
    }

    @Override
    public void SearchClientId(int clientId) {
        clientsFromFile = r.read("Clients.json");
        boolean found = false;
        for (var curr : clientsFromFile)
            if (clientId == curr.getId()){
                System.out.println(curr.Information());
                found=true;
            }

        if(!found) System.out.println("Couldn't find client with that id!");
    }

    @Override
    public void SearchClientIndustry(String clientIndustry) {
        clientsFromFile = r.read("Clients.json");
        boolean found = false;
        for (var curr : clientsFromFile)
            if (clientIndustry.equalsIgnoreCase(curr.getIndustry())) {
                System.out.println(curr.Information());
                found = true;
            }
        if (!found) System.out.println("Couldn't find client with that industry!");
    }

    @Override
    public void saveAndExit() {
        wr.write(clientsFromFile , "employee.json");
    }
}
