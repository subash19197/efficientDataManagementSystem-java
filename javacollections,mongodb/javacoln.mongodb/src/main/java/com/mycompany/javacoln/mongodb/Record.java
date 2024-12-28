/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javacoln.mongodb;


public class Record {
    private String key;
    private String value;
    public Record(String key,String value){
        this.key= key;
        this.value= value;
        
    }
    public String getKey(){
        return key;
    }
    public void setKey(String key){
        this.key= key;
    }
    public String getValue(){
        return value;
    }
    public void setValue(String value){
        this.value= value;
    }
    @Override
  public String toString(){
      return "Record{"+"key="+key+'\''+
              ",value='"+value+'\''+'}';
  }
    
}
