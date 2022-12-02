package task4;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class DataHandler {
    private Catalog catalog;
    private final String configPath;
    private String dataPath;
    private final ArrayList<String> filterStrings = new ArrayList<>();

    public DataHandler(String configPath) throws IOException {
        this.configPath = configPath;
        readFromConfigFile(configPath);
        catalog = new Catalog();
        readFromDataFile();
    }

    // Бросает исключение, если не найден файл или ошибка во время чтения
    public void readFromConfigFile(String configPath) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(configPath))) {
            dataPath = in.readLine();
            String regex;
            while ((regex = in.readLine()) != null) {
                filterStrings.add(regex);
            }
        }
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public String getConfigPath() {
        return configPath;
    }

    public String getDataPath() {
        return dataPath;
    }

    public ArrayList<String> getFilterStrings() {
        return filterStrings;
    }

    public void readFromDataFile() throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(dataPath))) {
            ObjectMapper objectMapper = new ObjectMapper();

            String json = in.lines().collect(Collectors.joining(System.lineSeparator()));
            if (json.length() > 0)
                catalog = objectMapper.readValue(json, Catalog.class);
        }
    }

    public void saveToDataFile() {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(dataPath))) {
            ObjectMapper objectMapper = new ObjectMapper();

            String json = objectMapper.writeValueAsString(catalog);
            out.write(json);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(Product newProduct) {
        if (!catalog.find(newProduct.getName()).isPresent())
            catalog.add(newProduct);
    }

    public void remove(String name) {
        catalog.remove(name);
    }

    public boolean canAddProduct(String name) {
        // Если имя не удовлетворяет никакому фильтру, тогда можем добавить
        return filterStrings.stream().noneMatch(name::matches);
    }
}
