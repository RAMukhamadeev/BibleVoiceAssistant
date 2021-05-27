import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class JacksonSerializer {
    private static final String RESOURCES_FOLDER = "src/main/resources/JSONSettings/";
    private static final String NUMBER_DICTIONARY_FILE_NAME = "numberDictionary.txt";

    public static void serializeToJSON(String fileName, Object object) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setVisibility(mapper.getSerializationConfig().getDefaultVisibilityChecker()
                    .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                    .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                    .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                    .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));
            String json = mapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(object);
            Files.write(Paths.get(RESOURCES_FOLDER + fileName), json.getBytes());
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    private static String getFileAsString(String path) {
        String res = null;
        try {
            res = new String(Files.readAllBytes(Paths.get(path)));
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return res;
    }

    public static ArrayList<StringNumber> getNumberDictionary() {
        ArrayList<StringNumber> numbers = new ArrayList<>();
        try {
            String path = RESOURCES_FOLDER + NUMBER_DICTIONARY_FILE_NAME;
            String json = getFileAsString(path);
            TypeReference<ArrayList<StringNumber>> typeRef = new TypeReference<ArrayList<StringNumber>>() {};
            ObjectMapper mapper = new ObjectMapper();
            numbers = mapper.readValue(json, typeRef);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return numbers;
    }
}
