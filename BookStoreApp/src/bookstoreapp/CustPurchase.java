/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoreapp;

/**
 *
 * @author User
 */
public class CustPurchase {
    private Customer customer;
    private Item item;
    private int purchaseID;
    private double amountPurchase;
    private double afterDiscount;
    
    public CustPurchase(Customer customer,Item item,int purchaseID){
        this.customer=customer;
        this.item=item;
        this.purchaseID=purchaseID;
        this.amountPurchase=0;
        this.afterDiscount=0;
    }
    
    public int getPurchaseID(){
        return this.purchaseID;
    }
    
    public void calculateDiscount(Item item){
        this.amountPurchase=item.getPrice()*item.getItemQuantity();
        this.afterDiscount=this.amountPurchase-(this.amountPurchase*item.getDiscountRate(this.amountPurchase));
        
    }
    public double getAmountPurchase(){
        return this.amountPurchase;
    }
    
    public double getAfterDiscount(){
        return this.afterDiscount;
    }
    
    @Override
    public String toString(){
        return String.format(
        "Purchase ID      : %d\n\nCustomer Information:\n%s\n\nItem Details:\n%s\n\nAmount Purchase  : RM%.2f\nAfter Discount   : RM%.2f",
        purchaseID,
        customer.toString(),
        item.toString(),
        amountPurchase,
        afterDiscount
        );
    }
}
