/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventorysystem;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;

/**
 *
 * @author User
 */
public class InventoryManager {

    private Connection conn;

    public InventoryManager(Connection conn) {
        this.conn = conn;
    }
    
    // method to add item in database
    public void addSupplyItem(List<SupplyItem> items) throws SQLException,InventoryException {
        PreparedStatement ps = null;

        try {
            String sql = "INSERT INTO supplies(ID, ItemName, Category, Quantity, Price) VALUES (?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            
            for (SupplyItem item : items) {
                // use of custom InventoryException
                if (item.getQuantity() < 0) {
                    throw new InventoryException("Quantity cannot be negative");
                }
                if (item.getName() == null || item.getName().trim().isEmpty()) {
                    throw new InventoryException("Item name cannot be empty");
                }
                if (item.getPrice() < 0) {
                    throw new InventoryException("Price cannot be negative");
                }

                ps.setInt(1, item.getId());
                ps.setString(2, item.getName());
                ps.setString(3, item.getCategory());
                ps.setInt(4, item.getQuantity());
                ps.setDouble(5, item.getPrice());
                ps.addBatch();
            }
            ps.executeBatch();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    //method to get item by id
    public SupplyItem getSupplyItem(int id) throws SQLException, InventoryException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM supplies WHERE ID = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new SupplyItem(
                        rs.getInt("ID"),
                        rs.getString("ItemName"),
                        rs.getString("Category"),
                        rs.getInt("Quantity"),
                        rs.getDouble("Price"));
            }
            return null;
            
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        }

    }
    
    //method for update stock in Database
    public void updateStock(List<SupplyItem> items) throws SQLException {
        PreparedStatement ps = null;
        try {
            String sql = "UPDATE supplies SET Quantity = ?, Price = ? WHERE ID = ?";
            ps = conn.prepareStatement(sql);

            for (SupplyItem item : items) {
                ps.setInt(1, item.getQuantity());
                ps.setDouble(2, item.getPrice());
                ps.setInt(3, item.getId());
                ps.addBatch();
            }
            ps.executeBatch();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    //method to delete any item in db
    public void deleteSupplyItem(int id) throws SQLException {
        PreparedStatement ps = null;
        try {
            String sql = "DELETE FROM supplies WHERE ID = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    //method to get all item in db
    public List<SupplyItem> getAllSupplies() throws SQLException, InventoryException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            List<SupplyItem> supplies = new ArrayList<>();
            String sql = "SELECT * FROM supplies";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                supplies.add(new SupplyItem(
                        rs.getInt("ID"),
                        rs.getString("ItemName"),
                        rs.getString("Category"),
                        rs.getInt("Quantity"),
                        rs.getDouble("Price")
                ));
            }
            return supplies;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
    }

    //================LambdaExspression Method======================
    //Comparator Lambda - to sort by price in (descending)
    public void sortByPrice(List<SupplyItem> items) {
        Collections.sort(items, (item1, item2) -> Double.compare(item2.getPrice(), item1.getPrice()));
    }

    //Predicate Lambda - to filter items based on condition
    public List<SupplyItem> filterItems(List<SupplyItem> items, Predicate<SupplyItem> condition) {
        List<SupplyItem> result = new ArrayList<>();
        for (SupplyItem item : items) {
            if (condition.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    //======================Calculation methods========================
    //method to calculate total value (price*quantity)
    public double calculateTotalValue(List<SupplyItem> items) {
        double total = 0;
        for (SupplyItem item : items) {
            total += (item.getQuantity() * item.getPrice());
        }
        return total;
    }
    
    //method to get stock below 5
    public int getLowStockCount(List<SupplyItem> items) {
        int count = 0;
        for (SupplyItem item : items) {
            if (item.getQuantity() < 5) {
                count++;
            }
        }
        return count;
    }
}
