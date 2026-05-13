/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package healthtrackingsystem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class TrackingList {
    private List<User> users;
    private List<HealthRecord> healthRecords;
    
    public TrackingList(){
        this.users = new ArrayList<>();
        this.healthRecords = new ArrayList<>();
        
    }
    public void addUser(User user){
        users.add(user);
        
    }
    
    public List<User> getAllUsers(){
        return new ArrayList<>(users);
    }
    
    public User findUser(int userId){
        for (User user :  users){
            if (user.getUserId() == userId){
                return user;
            }
        }
        return null;
    }
    
    public void addHealthRecord(HealthRecord record){
        healthRecords.add(record);
    }
    
    public List <HealthRecord> getAllHealthRecord(){
        return new ArrayList<>(healthRecords);
    }
    
    public HealthRecord findRecord (int recordId){
        for (HealthRecord record : healthRecords){
            if(record.getRecordID() == recordId){
                return record;
            }
        }
        return null;
    }
    
    public boolean isRecordIdExist (int recordId){
        for(HealthRecord hr : healthRecords){
            if(hr.getRecordID() == recordId){
                return true;
            }
        }
        return false;
    }
    
    public double calculateTotalDailyCalories(int userId, String date) {
        double total = 0.0;
        for (HealthRecord r : getAllHealthRecord()) {
            if (r instanceof NutritionRecord && r.getUserID() == userId && r.getDate().equals(date)) {
                NutritionRecord nr = (NutritionRecord) r;
                total += nr.getCalories();
            }
        }
        return total;
    }
    
}
