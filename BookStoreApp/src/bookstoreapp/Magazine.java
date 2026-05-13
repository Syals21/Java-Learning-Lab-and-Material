/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoreapp;

/**
 *
 * @author User
 */
public class Magazine extends Item {
    private String magazineName;
    private String magazineType;
    
    public Magazine(String itemName,String itemID,double price,int itemQuantity,String magazineName,String magazineType){
        super(itemName,itemID,price,itemQuantity);
        this.magazineName=magazineName;
        this.magazineType=magazineType;    
    }
    public String getMagazineName(){
        return this.magazineName;
    }
    public String getMagazineType(){
        return this.magazineType;
    }
    
    @Override
    public double getDiscountRate(double amountPurchase){
        if(amountPurchase>80 && amountPurchase<=200){
            return 0.5;
        }else if(amountPurchase>200){
            return 0.15;
        }else {
            return 0.0;
        }
    }
    @Override
    public String toString(){
        return super.toString() + String.format("\nMagazine Name    : %s\nMagazine Type      : %s",this.magazineName,this.magazineType );
    }
}
