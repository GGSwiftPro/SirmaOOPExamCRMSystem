package ReaderWrites;

import com.SirmaAcademy.OOPRetake.Clients.Client;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public  class JSONReader implements CustomReader {

    @Override
    public List<Client> read(String path) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(path), new TypeReference<List<Client>>() {});
        }
        catch (IOException e){e.printStackTrace(); return null;}
    }
}
