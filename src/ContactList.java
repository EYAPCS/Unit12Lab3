/**
 * Created by emma on 7/12/17.
 */

/**
 * Reads file from a given file path, then adds, deletes and displays contacts. When the user quits, the contact
 * list is saved back to the file.
 */

import java.io.*;
import java.util.*;

public class ContactList {

    public static void main(String[] args) {

        String filePath;
        boolean running = true;
        Scanner input = new Scanner(System.in);

        TreeMap<String, Contact> contactList = new TreeMap<String, Contact>();

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
                    System.out.print("Enter the FIRST name of the person you would like to delete: ");
                    String first = input.next();
                    System.out.print("Enter the LAST name of the person you would like to delete: ");
                    String last = input.next();
                    String name = first + " " + last;
                    boolean found = false;

                    for(Map.Entry<String, Contact> entry : contactList.entrySet()) {
                        Contact value = entry.getValue();

                        if(value.fullName().equals(name)) {
                            contactList.remove(value.reverseName());
                            found = true;
                            break;
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
                        FileWriter fileWriter =
                                new FileWriter(filePath);

                        BufferedWriter bufferedWriter =
                                new BufferedWriter(fileWriter);

                        for(Map.Entry<String, Contact> entry : contactList.entrySet()) {
                            Contact value = entry.getValue();

                            bufferedWriter.write(value.detailsToString());
                            bufferedWriter.newLine();

                        }

                        bufferedWriter.close();
                    }
                    catch(IOException ex) {
                        System.out.println(
                                "Error writing to file '"
                                        + filePath + "'");
                    }
                    running = false;


            }

        }

    }
}