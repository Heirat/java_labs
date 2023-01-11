package task4;


import java.io.*;
import java.util.ArrayList;


public class DataHandler {
    private final Catalog catalog;
    private final ArrayList<String> filterStrings = new ArrayList<>();

    public DataHandler(String configPath) throws IOException {
        readFromConfigFile(configPath);
        catalog = new Catalog();
    }

    // Бросает исключение, если не найден файл или ошибка во время чтения
    public void readFromConfigFile(String configPath) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(configPath))) {
            String filterLine;
            while ((filterLine = in.readLine()) != null) {
                filterStrings.add(filterLine);
            }
        }
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void add(Product newProduct) {
        catalog.add(newProduct);
    }

    public boolean remove(String name) {
        return catalog.remove(name);
    }

    public boolean canAddProduct(String name) {
        // Если имя не удовлетворяет никакому фильтру, тогда можем добавить
        return filterStrings.stream().noneMatch(name::matches);
    }
}
