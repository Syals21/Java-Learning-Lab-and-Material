/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package healthtrackingsystem;

/**
 *
 * @author User
 */
public class SleepRecord extends HealthRecord {

    private int hourSleep;

    public SleepRecord(User user, int userID, int recordID, String date, int hourSleep) {
        super(user, userID, recordID, date);
        this.hourSleep = hourSleep;
    }

    public int getHourSleep() {
        return hourSleep;
    }

    public String sleepCategory() {
        if (hourSleep >= 7 && hourSleep <= 9) {
            return "Ideal sleep";
        } else if (hourSleep > 9) {
            return "Oversleep";
        } else {
            return "Not enough Sleep";
        }
    }

    @Override
    public String displayRecord() {
        return String.format(
                "SLEEP RECORD\n"
                + "------------------------\n"
                + "%-15s : %s\n"
                + "%-15s : %s\n"
                + "%-15s : %s\n"
                + "%-15s : %d hours\n"
                + "%-15s : %s\n"
                ,"Record ID", super.getRecordID(), "User ID", super.getUserID(), "Date", super.getDate(), "Hours Slept", hourSleep, "Sleep", sleepCategory());
    }

}
