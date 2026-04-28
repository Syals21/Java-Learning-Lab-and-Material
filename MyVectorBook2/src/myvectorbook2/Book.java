/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myvectorbook2;

/**
 *
 * @author User
 */
public class Book implements Comparable<Book> {
    String title,author;
    double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" + "title=" + title + ", author=" + author + ", price=" + price + '}';
    }
    
    @Override
    public int compareTo(Book Other){
        return this.title.compareTo(Other.title);
    }
    
    @Override
    public boolean equals(Object obj){
       if(this==obj){
           return true;
       }
       
       if(obj==null || getClass() != obj.getClass()){
           return false;
       }
       
       Book other = (Book) obj;
       return this.author.equals(other.author)&&this.title.equals(other.title)&&this.price==other.price;
    }
    
}
