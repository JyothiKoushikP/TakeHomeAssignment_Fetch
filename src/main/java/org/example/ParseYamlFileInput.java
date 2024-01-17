package org.example;
import org.yaml.snakeyaml.Yaml;
import java.util.logging.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

/* This class primarily deals with all the server configurations, fetching YAML Data, converting into HttpRequests Object, */
public class ParseYamlFileInput {
    private static final Logger logger = Logger.getLogger(ParseYamlFileInput.class.getName());

    /* Method to handle YamlFile Input using SnakeYaml */
    public static List<Map<String,Object>> loadYAMLConfig(String filePath) {
        Yaml yaml = new Yaml();
        try {
            Path path = Path.of(filePath);
            List<Map<String, Object>> requestsData;
            try (var input = Files.newInputStream(path)) {
                requestsData = yaml.load(input);
            }
            return requestsData;
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error loading YAML configuration from file: " + filePath, e);
            e.printStackTrace();
            return null;
        }
    }

    /* Converting YAML elements to schema specific HttpRequest Objects */
    public static HttpRequests convertToHttpRequests(Map<String, Object> requestData) {
        Map<String, String> headers = (Map<String, String>) requestData.get("headers");
        String method = (String) requestData.get("method");
        String name = (String) requestData.get("name");
        String url = (String) requestData.get("url");
        String body = (String) requestData.get("body");
        validateNameAndUrl(name,url);
        return new HttpRequests(headers, method, name, url, body);
    }

    /* Validating Name and URL for a HttpRequests Object */
    private static void validateNameAndUrl(String name, String url) {
        if (name == null || name.trim().isEmpty() || url == null || url.trim().isEmpty()) {
            throw new MissingMetadataException("Name and URL are compulsory fields and cannot be null or empty.");
        }
    }

}
