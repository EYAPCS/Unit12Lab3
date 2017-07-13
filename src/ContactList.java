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

        TreeMap<String, Contact> contactList = new TreeMap<String, Contact>();

//        Contact temp = new Contact("Danny", "Brown", "23456789", "adry@asdf.com");
//
//        Contact temp2 = new Contact("Abby", "Yang", "34576", "aby@asdf.com");
//
//        Contact temp3 = new Contact("Jon", "Snow", "23456789", "js@asdf.com");
//
//        Contact temp4 = new Contact("Daenerys", "Targaryen", "23456789", "js@asdf.com");
//
//        contactList.put(temp.reverseName(), temp);
//        contactList.put(temp2.reverseName(), temp2);
//        contactList.put(temp3.reverseName(), temp3);
//        contactList.put(temp4.reverseName(), temp4);

//        for(Map.Entry<String, Contact> entry : contactList.entrySet()) {
//
//            String key = entry.getKey();
//            Contact value = entry.getValue();
//
//            value.printDetails();
//
//        }


//        String fileName = "/Users/emma/Documents/contacts/";
//
//        try {
//            // Assume default encoding.
//            FileWriter fileWriter =
//                    new FileWriter(fileName);
//
//            // Always wrap FileWriter in BufferedWriter.
//            BufferedWriter bufferedWriter =
//                    new BufferedWriter(fileWriter);
//
//            // Note that write() does not automatically
//            // append a newline character.
//            for(Map.Entry<String, Contact> entry : contactList.entrySet()) {
//                Contact value = entry.getValue();
//
//                bufferedWriter.write(value.detailsToString());
//                bufferedWriter.newLine();
//
//            }
//
//            // Always close files.
//            bufferedWriter.close();
//        }
//        catch(IOException ex) {
//            System.out.println(
//                    "Error writing to file '"
//                            + fileName + "'");
//            // Or we could just do this:
//            // ex.printStackTrace();
//        }

        System.out.println("Enter the file path of the contacts file: ");
        filePath = input.next();

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(filePath);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
//                System.out.println(line);

                String[] words = line.split("\t");
                String firstName = words[0];
                String lastName = words[1];
                String phoneNumber = words[2];
                String emailAddress = words[3];

                Contact newPerson = new Contact(firstName, lastName, phoneNumber, emailAddress);
                contactList.put(newPerson.reverseName(), newPerson);

            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            filePath + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + filePath + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }


        for(Map.Entry<String, Contact> entry : contactList.entrySet()) {
            Contact value = entry.getValue();

            value.printDetails();
            System.out.println();

        }

        while(running) {

            System.out.println("Enter: 1 to add a contact, 2 to delete a contact, 3 to display the entire list, 4 to save & quit");
            int decision = input.nextInt();

            switch(decision) {

                case 1:
                    System.out.print("First Name: ");
                    String firstName = input.next();

                    System.out.print("Last Name: ");
                    String lastName = input.next();

                    System.out.print("Phone Number: ");
                    String phoneNumber = input.next();

                    System.out.print("Email Address: ");
                    String emailAddress = input.next();

                    Contact newPerson = new Contact(firstName, lastName, phoneNumber, emailAddress);
                    contactList.put(newPerson.reverseName(), newPerson);
                    break;

                case 2:
                    System.out.print("Enter the name of the person you would like to delete: ");
                    String name = input.next()
                    boolean found = false;

                        for(Map.Entry<String, Contact> entry : contactList.entrySet()) {
                            Contact value = entry.getValue();

                            if(value.fullName().equals(name)) {
                                contactList.remove(value.reverseName());
                                found = true;
                            }

                        }

                        if(found == false) {
                            System.out.println(name + " not found in contacts");
                        }

                    break;

                case 3:
                    for(Map.Entry<String, Contact> entry : contactList.entrySet()) {
                        Contact value = entry.getValue();

                        value.printDetails();

                    }
                    break;

                case 4:
                    try {
                        // Assume default encoding.
                        FileWriter fileWriter =
                                new FileWriter(filePath);

                        // Always wrap FileWriter in BufferedWriter.
                        BufferedWriter bufferedWriter =
                                new BufferedWriter(fileWriter);

                        // Note that write() does not automatically
                        // append a newline character.
                        for(Map.Entry<String, Contact> entry : contactList.entrySet()) {
                            Contact value = entry.getValue();

                            bufferedWriter.write(value.detailsToString());
                            bufferedWriter.newLine();

                        }

                        // Always close files.
                        bufferedWriter.close();
                    }
                    catch(IOException ex) {
                        System.out.println(
                                "Error writing to file '"
                                        + filePath + "'");
                        // Or we could just do this:
                        // ex.printStackTrace();
                    }
                    running = false;


            }

        }





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
//        Contact temp = new Contact("Adrian", "Adam", "23456789", "asdf@asdf.com");
//
//        String name = temp.getLastName() + ", " + temp.getFirstName();
//
//        ArrayList<String> info = new ArrayList<String>();
//        info.add(temp.getPhoneNumber());
//        info.add(temp.getEmailAddress());
//
//        contactList.put(name, info);
//
//        Contact temp2 = new Contact("Zoe", "Adam", "23456789", "asdf@asdf.com");
//
//        String name2 = temp2.getLastName() + ", " + temp2.getFirstName();
//
//        ArrayList<String> info2 = new ArrayList<String>();
//        info2.add(temp.getPhoneNumber());
//        info2.add(temp.getEmailAddress());
//
//        contactList.put(name2, info2);
//
//        Contact temp3 = new Contact("Adrian", "Adam", "23456789", "asdf@asdf.com");
//
//        String name3 = temp.getLastName() + ", " + temp.getFirstName();
//
//        ArrayList<String> info3 = new ArrayList<String>();
//        info3.add(temp.getPhoneNumber());
//        info3.add(temp.getEmailAddress());
//
//        contactList.put(name3, info3);
//
//        for (int i = 0; i < contactList.size(); i++) {
//
//            System.out.println(contactList.keySet().toArray()[i] + " : " + contactList.entrySet().toArray()[i]);
//
//        }

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