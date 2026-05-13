/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mylinkedlistplaylist;

import java.util.LinkedList;

/**
 *
 * @author User
 */
public class MyLinkedListPlaylist {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList <String> song = new LinkedList<>();
        song.add("A");
        song.add("b");
        song.add("c");
        song.add("d");
        song.add("e");
        
        LinkedList <String> artist = new LinkedList<>();
        artist.add("q");
        artist.add("w");
        artist.add("e");
        artist.add("r");
        artist.add("t");
        
        LinkedList <Song> playlist = new LinkedList();
        for(int i=0;i<5;i++){
            playlist.add(new Song(song.get(i),artist.get(i)));
        }
        
        System.out.println("Song: "+song);
        System.out.println("artist: "+artist);
        for( Song e:playlist){
            System.out.println(e);
        }
    }
    
}
