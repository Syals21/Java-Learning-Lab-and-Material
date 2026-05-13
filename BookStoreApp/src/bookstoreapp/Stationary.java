/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoreapp;

/**
 *
 * @author User
 */
public class Stationary extends Item {
    private String sType;
    
    public Stationary(String itemName,String itemID,double price,int itemQuantity,String sType){
        super(itemName,itemID,price,itemQuantity);
        this.sType=sType;    
    }
    
    public String getSType(){
        return this.sType;
    }
    
    @Override
    public double getDiscountRate(double amountPurchase){
        if(amountPurchase>80 && amountPurchase<=200){
            return 0.4;
        }else if(amountPurchase>200){
            return 0.10;
        }else {
            return 0.10;
        }
    }
    
    @Override
    public String toString(){
        return super.toString() + String.format("\nBook Name        : %s",this.sType);
    }
}
