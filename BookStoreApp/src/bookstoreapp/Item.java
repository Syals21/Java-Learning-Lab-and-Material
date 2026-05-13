/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoreapp;

/**
 *
 * @author User
 */
public abstract class Item {

    private String itemName;
    private String itemID;
    private double price;
    private int itemQuantity;

    public Item(String itemName, String itemID, double price, int itemQuantity) {
        this.itemName = itemName;
        this.itemID = itemID;
        this.price = price;
        this.itemQuantity = itemQuantity;
    }

    public String getItemName() {
        return this.itemName;
    }

    public String getItemID() {
        return this.itemID;
    }

    public double getPrice() {
        return this.price;
    }

    public int getItemQuantity() {
        return this.itemQuantity;
    }

    public abstract double getDiscountRate(double amountPurchase);

    @Override
    public String toString() {
        return String.format("Item Name        : %s\nItem ID          : %s\nPrice per unit   : RM%.2f\nQuantity         : %d",
                itemName, itemID, price, itemQuantity);
    }
}
