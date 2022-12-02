package task4;

import java.util.*;

public class Catalog {
    private ArrayList<Product> products = new ArrayList<>();

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public Catalog() {}

    public Catalog(ArrayList<Product> products) {
        this.products = products;
    }

    public Boolean add(Product newProduct) {
        // Добавление товара только с уникальным названием
        if (!find(newProduct.getName()).isPresent())
            return products.add(newProduct);
        else
            return false;
    }

    public void remove(Product product) {
        products.remove(product);
    }

    public void remove(String name) {
        products.stream()
                .filter(product -> Objects.equals(product.getName(), name))
                .findFirst()
                .ifPresent(product -> products.remove(product));
    }

    public Optional<Product> find(String name) {
        return products.stream().filter(product -> Objects.equals(product.getName(), name)).findFirst();
    }
}
