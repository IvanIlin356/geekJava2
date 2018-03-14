package com.alien.java2.lesson3;

import java.util.ArrayList;
import java.util.Iterator;

public class PhoneBook {

    public class PhoneBookItem{
        String name;
        int number;

        public PhoneBookItem(String name, int number){
            this.name = name;
            this.number = number;
        }
    }


private static ArrayList<PhoneBookItem> contacts = new ArrayList<PhoneBookItem>();

//    public PhoneBook(){
//
//    }

    public void addContact(String name, int number){
        contacts.add(new PhoneBookItem(name, number));
    }

    public void getContact(String name){
        Iterator<PhoneBookItem> iterator = contacts.iterator();
        PhoneBookItem item;
        while (iterator.hasNext()){
            item = iterator.next();
            if (item.name.equals(name))
                System.out.println("Имя " + item.name + ", телефон: " + item.number);
        }
    }
}
