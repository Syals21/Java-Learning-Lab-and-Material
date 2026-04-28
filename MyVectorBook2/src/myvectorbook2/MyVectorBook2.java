/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package myvectorbook2;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

/**
 *
 * @author User
 */
public class MyVectorBook2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Vector<Book> bookList = new Vector<>();
        bookList.add(new Book("java", "an", 45));
        bookList.add(new Book("python", "af", 55));
        bookList.add(new Book("web", "ar", 48.5));
        bookList.add(new Book("data Stucture", "ah", 60));
        bookList.add(new Book("database", "ak", 50));

        for (Book s : bookList) {
            System.out.println(s);
        }
        bookList.add(2, new Book("Software", "aq", 45));
        System.out.println(" ");
        for (Book s : bookList) {
            System.out.println(s);
        }
        System.out.println(" ");
        bookList.remove(1);
        for (Book s : bookList) {
            System.out.println(s);
        }
        System.out.println(" ");
        System.out.println("Book 3: " + bookList.get(2));

        Collections.sort(bookList);
        System.out.println("");
        System.out.println("After Sort Comparable: ");
        for (Book s : bookList) {
            System.out.println(s);
        }

        Collections.sort(bookList, new Comparator<Book>() {
            public int compare(Book a, Book b) {
                return b.getTitle().compareTo(a.getTitle());
            }
        });
        System.out.println("");
        System.out.println("Compare() title:");
        for(Book s : bookList){
            System.out.println(s);
        }
    }

}
