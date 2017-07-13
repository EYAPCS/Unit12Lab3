/**
 * Created by emma on 7/12/17.
 */

import java.io.*;
import java.util.*;

public class ContactList {

    public static void main(String[] args) {

        String filePath;
        boolean running = true;
        Scanner input = new Scanner(System.in);

        TreeMap<String, ArrayList<String>> contactList = new TreeMap<String, ArrayList<String>>();

//        System.out.println("File Path:");
//        filePath = input.next();
//
//        BufferedReader reader = null;
//
//        try {
//
//            try {
//                reader = new BufferedReader(new FileReader(filePath));
//            } catch(java.io.FileNotFoundException e) {
//                System.out.println(e);
//            }
//
//            //read a line
//            String inputStr = reader.readLine();
//
//            //while it is not the end of file
//            while(inputStr != null) {
//
//                String[] words = inputStr.split("\\s+");
//
//                for (int i = 0; i < words.length; i++) {
//                    // You may want to check for a non-word character
//                    words[i] = words[i].replaceAll("[^\\w]", "");
//                }
//
//                inputStr = reader.readLine();
//
//            }
//
//        } catch(java.io.IOException e) {
//            System.out.println(e);
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch(java.io.IOException e){
//
//                }
//            }
//        }

//        Contact class + TreeMap tests
        Contact temp = new Contact("Adrian", "Adam", "23456789", "asdf@asdf.com");

        String name = temp.getLastName() + ", " + temp.getFirstName();

        ArrayList<String> info = new ArrayList<String>();
        info.add(temp.getPhoneNumber());
        info.add(temp.getEmailAddress());

        contactList.put(name, info);

        Contact temp2 = new Contact("Zoe", "Adam", "23456789", "asdf@asdf.com");

        String name2 = temp2.getLastName() + ", " + temp2.getFirstName();

        ArrayList<String> info2 = new ArrayList<String>();
        info2.add(temp.getPhoneNumber());
        info2.add(temp.getEmailAddress());

        contactList.put(name2, info2);

        Contact temp3 = new Contact("Adrian", "Adam", "23456789", "asdf@asdf.com");

        String name3 = temp.getLastName() + ", " + temp.getFirstName();

        ArrayList<String> info3 = new ArrayList<String>();
        info3.add(temp.getPhoneNumber());
        info3.add(temp.getEmailAddress());

        contactList.put(name3, info3);

        for (int i = 0; i < contactList.size(); i++) {

            System.out.println(contactList.keySet().toArray()[i] + " : " + contactList.entrySet().toArray()[i]);

        }

//        filePath = "/Users/emma/Documents/contacts";
//
//        Scanner input = new Scanner(System.in);
//        BufferedReader reader = null;
//
//        try {
//            reader = new BufferedReader(new FileReader(filePath));
//        } catch(java.io.FileNotFoundException e) {
//            System.out.println("File Not Found");
//        }
//
//        String line = null;
//
//        try {
//            line = reader.readLine();
//        } catch(java.io.IOException e) {
//            System.out.println("IO Exception");
//        }
//
//        if(line != null) {
//
//            String[] words = line.split(" ");
//
//            Contact temp = new Contact();
//            String first = words[0];
//            temp.setFirstName(first);
//
//            String last = words[1];
//            temp.setLastName(last);
//
//            String number = words[2];
//            temp.setPhoneNumber(number);
//
//            String email = words[3];
//            temp.setEmailAddress(email);
//
//            String key = temp.getFirstName() + ", " + temp.getLastName();
//            String[] value = {temp.getPhoneNumber(), temp.getEmailAddress()};
//
//            contactList.put(key, value);
//
//
//
//        }
//
//
//        while(running) {
//
//
//            System.out.print("1 to add new contact\t 2 to delete contact\t 3 to display contact list\t 4 to quit and save");
//            int decision = input.nextInt();
//
//            switch(decision) {
//
//                case 1:
//                    Contact temp = new Contact();
//                    System.out.print("First name: ");
//                    String first = input.next();
//                    temp.setFirstName(first);
//
//                    System.out.print("Last name: ");
//                    String last = input.next();
//                    temp.setLastName(last);
//
//                    System.out.print("Phone number: ");
//                    String number = input.next();
//                    temp.setPhoneNumber(number);
//
//                    System.out.print("Email address: ");
//                    String email = input.next();
//                    temp.setEmailAddress(email);
//
//                    String key = temp.getFirstName() + ", " + temp.getLastName();
//                    String[] value = {temp.getPhoneNumber(), temp.getEmailAddress()};
//
//                    contactList.put(key, value);
//                    break;
//                case 2:
//                    ArrayList<String> names = null;
//
//                    for (Object name : contactList.keySet().toArray()) {
//                        names.add(name.toString());
//                    }
//
//                    System.out.print("Name of contact to delete: ");
//                    String deleteName = input.next();
//
//                    for (String name : names) {
//                        if (deleteName.equals(name)) {
//                            contactList.remove(name);
//                        }
//                    }
//                    break;
//                case 3:
//                    for (int i = 0; i < contactList.size(); i++) {
//
//                        System.out.print(contactList.keySet().toArray()[i] + "\t");
//                        System.out.println(contactList.entrySet().toArray()[i] + "\t");
//
//                    }
//
//            }
//
//        }
//
//    }
//
////        BufferedReader reader = null;
////
////        try {
////
////            reader = new BufferedReader(new FileReader(filePath));
////
////            try {
////                System.out.println(reader.readLine());
////                System.out.println(reader.readLine());
////            } catch(java.io.IOException e) {
////                System.out.println("IO Exception");
////            }
////
////        } catch(java.io.FileNotFoundException e) {
////            System.out.println("file not found");
////        } finally {
//////            if (reader != null) {
//////                reader.close();
//////            }
////        }
//
//
//
//}
    }
}