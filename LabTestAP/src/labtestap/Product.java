/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labtestap;

/**
 *
 * @author User
 */
public class Product {
    String productId;
    String productName;
    int stock;

    public Product(String productId, String productName, int stock)throws NegativeStockException  {
        if(stock<0){
            throw new NegativeStockException("Stock can't be negative");
        }
        this.productId = productId;
        this.productName = productName;
        this.stock = stock;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getStock() {
        return stock;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public int IncreaseProduct(int amount){
        return this.stock += amount;
    }
    
    public int DecreaseProduct(int amount) throws NegativeStockException{
        int dec = this.stock - amount;
        if(dec<0){
            throw new NegativeStockException ("Stock is Reduced to a Negative Value");
        }else
            return dec;
        
    }
    
    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", productName=" + productName + ", stock=" + stock + '}';
    }
    
    public int compareTo(Product other) {
        return this.productId.compareTo(other.productId);
    }
    
    @Override
    public boolean equals (Object obj){
        if(this==obj){
            return true;
        }
        if (obj==null || getClass() != obj.getClass()){
            return false;
        }
        Product other = (Product)obj;
        return this.productId.equalsIgnoreCase(other.productId);
    }
    
    
}
