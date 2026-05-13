/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package healthtrackingsystem;

/**
 *
 * @author User
 */
public abstract class HealthRecord {
    protected User user;
    private int userID;
    private int recordID;
    private String date;

    public HealthRecord(User user, int userID,int recordID, String date){
        this.user=user;
        this.userID= userID;
        this.recordID = recordID;
        this.date = date;
    }

    public int getUserID() {
        return userID;
    }

    public int getRecordID() {
        return recordID;
    }

    public String getDate() {
        return date;
    }
    
    public abstract String displayRecord();
    
}
