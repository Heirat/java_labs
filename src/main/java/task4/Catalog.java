package task4;

import java.sql.*;
import java.util.*;

public class Catalog {
    Connection connection;

    public Catalog() {
        try {
            Class.forName(Driver.class.getName());
            String url = "jdbc:postgresql://localhost:5432/product_catalog";
            String login = "sysdba";
            String password = "masterkey";
            this.connection = DriverManager.getConnection(url, login, password);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Product> getProducts() {
        ArrayList<Product> productsList = new ArrayList<>();
        try {
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM catalog_table");

            while (rs.next()) {
                Product product = new Product();
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setWeight(rs.getDouble("weight"));
                productsList.add(product);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return productsList;
    }

    public Boolean add(Product newProduct) {
        // Добавление товара только с уникальным названием
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO  catalog_table (name, price, weight) VALUES (?, ?, ?)");
            stmt.setString(1, newProduct.getName());
            stmt.setDouble(2, newProduct.getPrice());
            stmt.setDouble(3, newProduct.getWeight());

            return stmt.executeUpdate() > 0;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean remove(String name) {
        try {
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM catalog_table WHERE name=?");
            stmt.setString(1, name);

            return stmt.executeUpdate() > 0;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Optional<Product> find(String name) {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM catalog_table WHERE name=?");
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Product product = new Product();
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setWeight(rs.getDouble("weight"));
                return Optional.of(product);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
