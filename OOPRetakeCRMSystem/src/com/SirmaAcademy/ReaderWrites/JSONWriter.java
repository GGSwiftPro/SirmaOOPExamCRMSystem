package ReaderWrites;
import com.SirmaAcademy.OOPRetake.Clients.Client;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSONWriter implements CustomWriter {
    @Override
    public void write(List<Client> employees, String path) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
        try {
            objectMapper.writeValue(new File(path),employees);
        }catch (IOException e){e.printStackTrace();}
    }
}
