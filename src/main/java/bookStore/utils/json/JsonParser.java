package bookStore.utils.json;

import bookStore.book.PaperBook;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class JsonParser {

    private final static Logger LOGGER = Logger.getLogger(JsonParser.class);

    public String convertJavaToJsonStr(Object object){

        String jsonStr = " ";

        try {
            jsonStr = new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            LOGGER.error("JSON error: " + e.getMessage());
        }

        return jsonStr;
    }

    public void convertJavaToJsonFile (Object object, String pathToFile){

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(Paths.get(pathToFile).toFile(), object);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            LOGGER.error("JSON error: " + e.getMessage());
        } catch (IOException e) {
            LOGGER.error("JSON error: " + e.getMessage());
        }
    }

    public void convertJsonFileToJava(String pathToFile){

        try {
            byte[] jsonData = Files.readAllBytes(Paths.get(pathToFile));
            ObjectMapper objectMapper = new ObjectMapper();
            PaperBook paperBook = objectMapper.readValue(jsonData, PaperBook.class);
            System.out.println("Paper book from JSON: Book name: " + paperBook.getName() +
                    ", Author: " + paperBook.getAuthor() +
                    ", Price: " + paperBook.getPrice() +
                    ", Genre: " + paperBook.getGenre() +
                    ", Cover type: " + paperBook.getCover() +
                    ", Size: " + paperBook.getSize() + ".");
        } catch (IOException e){
            LOGGER.error("File error: " + e.getMessage());
        }
    }

    public void convertJsonFileToList(String pathToFile){
        try {
            byte[] list = Files.readAllBytes(Paths.get(pathToFile));
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            List<Map<String, Object>> myObjects = objectMapper.readValue(list , new TypeReference<List<Map<String, Object>>>(){});
            System.out.println("List of books from .json: " + myObjects);
        } catch (IOException e){
            LOGGER.error("Error: " + e.getMessage());
        }
    }

    public PaperBook convertJsonStrToPaperBookPOJO(String jsonStr){

        PaperBook paperBook = null;

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            paperBook = objectMapper.readValue(jsonStr, PaperBook.class);
        } catch (JsonProcessingException e) {
            LOGGER.error("JSON error: " + e.getMessage());
        } catch (NullPointerException e){
            LOGGER.error("Null element: " + e.getMessage());
        }

        return paperBook;
    }

}
