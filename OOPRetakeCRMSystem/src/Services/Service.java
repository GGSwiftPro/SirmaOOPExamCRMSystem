package Services;

import com.SirmaAcademy.OOPRetake.Clients.Client;

public interface Service {
    void addClient(Client client);

    void updateClient(int id, Client client);
    void removeClient(int id);

    void  viewClients();
    void SearchClientName(String clientName);
    void SearchClientId(int clientId);
    void SearchClientIndustry(String clientIndustry);

    void saveAndExit();

}
