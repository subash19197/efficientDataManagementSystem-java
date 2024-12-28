/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.javacoln.mongodb;




import org.bson.Document;

import java.util.Scanner;

public class JavacolnMongodb {
    public static void main(String[] args) {
        dataservice dataService = new dataservice();
        mongoservice mongoDBService = new mongoservice();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Record");
            System.out.println("2. View Records");
            System.out.println("3. Save Records to MongoDB");
            System.out.println("4. View MongoDB Records");
            System.out.println("5. Update Record");
            System.out.println("6. Delete Record");
            System.out.println("7. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter key: ");
                    String key = scanner.nextLine();
                    System.out.print("Enter value: ");
                    String value = scanner.nextLine();

                    Record record = new Record(key, value);
                    dataService.addRecord(record);
                    break;

                case 2:
                    dataService.displayRecords();
                    break;

                case 3:
                    for (Record rec : dataService.getRecords()) {
                        Document doc = new Document("key", rec.getKey())
                                .append("value", rec.getValue());
                        mongoDBService.saveRecord(doc);
                    }
                    System.out.println("Records saved to MongoDB.");
                    break;

                case 4:
                    mongoDBService.listRecords();
                    break;
                case 5:
                    System.out.print("Enter key of the record to update: ");
                    String updateKey = scanner.nextLine();
                    System.out.print("Enter new value: ");
                    String newValue = scanner.nextLine();

                    
                    dataService.updateRecord(updateKey, newValue);

                    
                    mongoDBService.updateRecord(updateKey, newValue);

                    System.out.println("Record updated successfully.");
                    break;

                case 6:
                    System.out.print("Enter key of the record to delete: ");
                    String deleteKey = scanner.nextLine();

                    
                    dataService.deleteRecord(deleteKey);

                    
                    mongoDBService.deleteRecord(deleteKey);

                    System.out.println("Record deleted successfully.");
                    break;


                case 7:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

