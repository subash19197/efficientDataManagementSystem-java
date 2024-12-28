/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javacoln.mongodb;



import java.util.ArrayList;
import java.util.List;

public class dataservice {
    private List<Record> records;

    public dataservice() {
        records = new ArrayList<>();
    }

    public void addRecord(Record record) {
        records.add(record);
    }

    public void displayRecords() {
        for (Record record : records) {
            System.out.println(record);
        }
    }

    public List<Record> getRecords() {
        return records;
    }
     public void updateRecord(String key, String newValue) {
        for (Record record : records) {
            if (record.getKey().equals(key)) {
                record.setValue(newValue);
                break;
            }
        }
    }

    
    public void deleteRecord(String key) {
        records.removeIf(record -> record.getKey().equals(key));
    }
}
    

