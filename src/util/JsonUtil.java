package util;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class JsonUtil {
    private static final ObjectMapper mapper = new ObjectMapper();

    // Objeto Java → JSON
    public static String toJson(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter objeto para JSON", e);
        }
    }

    // JSON → objeto Java
    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter JSON para objeto", e);
        }
    }

    // JSON → lista de objetos Java
    public static <T> List<T> fromJsonList(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, new TypeReference<List<T>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter JSON para lista", e);
        }
    }
}
