package helpers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class manageContacts {
    private static Scanner scan = new Scanner(System.in);

    public static void addContact() {
        contact c = new contact();
        System.out.println("Saisir le nom :");
        c.setName(scan.nextLine());
        System.out.println("Saisir le prénom :");
        c.setSurname(scan.nextLine());

        do {
            try {
                System.out.println("Saisir le numéro de téléphone :");
                c.setPhone_num(scan.nextLine());
                break;
            } catch (ParseException error) {
                System.out.println(error.getMessage());
            }
        } while (true);

        do {
            try {
                System.out.println("Saisir l'email :");
                c.setEmail(scan.nextLine());
                break;
            } catch (ParseException error) {
                System.out.println(error.getMessage());
            }
        } while (true);

        do {
            try {
                System.out.println("Saisir la date de naissance:");
                c.setBirth_date(scan.nextLine());
                break;
            } catch (ParseException error) {
                System.out.println("Error, try again!");
            }
        } while (true);

        try {
            c.save();
            System.out.println("Contact saved !");
        } catch (IOException error) {
            System.out.println("Error during saving ...");
        }

    }

    public static ArrayList<contact> allContacts() throws IOException {
        String spliter = ";";
        ArrayList<contact> list = new ArrayList<>();
        BufferedReader buffer = new BufferedReader(new FileReader("contacts.csv"));
        try {
            String ligne = buffer.readLine();
            while (ligne != null) {
                String[] tab = ligne.split(spliter);
                contact c = new contact();
                c.setName(tab[0]);
                c.setSurname(tab[1]);
                c.setEmail(tab[2]);
                c.setPhone_num(tab[3]);
                c.setBirth_date(tab[4]);
                list.add(c);
                ligne = buffer.readLine();
            }
        } catch (ParseException error) {
            System.out.println(error.getMessage());
        } catch (IOException error) {
            System.out.println("Error : can't read the file, check it exists");
        } finally {
            buffer.close();
        }
        return list;
    }

    public static void showAllContacts() {
        try {
            ArrayList<contact> liste = allContacts();

            for (contact contact : liste) {
                System.out.println(contact.getSurname() + " " + contact.getName());
            }
        } catch (IOException e) {
            System.out.println("File error ...");
        }

    }
    
    public static void modifyContact() {
        try {
            allContacts();
            List<contact> list = allContacts();;
            System.out.println("Mail du contact a modifié ?");
            String email = scan.nextLine();
            contact contactToUpdate = null;
            for (contact c : list) {
                if (c.getEmail().equals(email)) {
                    contactToUpdate = c;
                }
            }
            if (contactToUpdate != null) {
                System.out.println("Saisir le nom:");
                contactToUpdate.setName(scan.nextLine());
                System.out.println("Saisir le prénom:");
                contactToUpdate.setSurname(scan.nextLine());

                do {
                    try {
                        System.out.println("Saisir le téléphone:");
                        contactToUpdate.setPhone_num(scan.nextLine());
                        break;
                    } catch (ParseException error) {
                        System.out.println(error.getMessage());
                    }
                } while (true);

                do {
                    try {
                        System.out.println("Saisir le mail:");
                        contactToUpdate.setEmail(scan.nextLine());
                        break;
                    } catch (ParseException error) {
                        System.out.println(error.getMessage());
                    }
                } while (true);

                do {
                    try {
                        System.out.println("Saisir la date de naissance:");
                        contactToUpdate.setBirth_date(scan.nextLine());
                        break;
                    } catch (ParseException error) {
                        System.out.println("Error, try again!");
                    }
                } while (true);
                contact.saveAll(list);
                System.out.println("Contact modifié");
            } else {
                System.out.println("Pas de contact a modifier");
            }
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    public static void deleteContact() {
        try {
            showAllContacts();
            List<contact> list = allContacts();
            System.out.println("Mail du contact a supprimer ?");
            String email = scan.nextLine();
            contact contactToDelete = null;
            for (contact c : list) {
                if (c.getEmail().equals(email)) {
                    contactToDelete = c;
                }
            }
            if (contactToDelete != null) {
                list.remove(contactToDelete);
                contact.saveAll(list);
                System.out.println("Contact deleted ");
            } else {
                System.out.println("Contact given to delete not found ...");
            }
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
    
    //More info : https://www.geeksforgeeks.org/collections-sort-java-examples/
    public static void sortContacts() {
        try {
            ArrayList<contact> list = allContacts();
            Collections.sort(list, null);
            for (contact c : list) {
                System.out.println(c.toString());
            }
            /* 
            Collections.sort(list, null);

            Arrays.sort(strarray, Collections.sort(null);));
            Arrays.toString(strarray)
            for (contact c : list) {
                System.out.println(c.toString());
            }*/
        } catch (IOException error) {
            error.printStackTrace();
        } 
    }

    // More info : https://www.geeksforgeeks.org/java-program-to-sort-objects-in-arraylist-by-date/
    public static void sortByDate() {
        ArrayList<contact> listDate;
        try {
            listDate = allContacts();
            Collections.sort(listDate, new sortDate());
        
            for (contact c : listDate) {
                System.out.println(c.toString());
                }
            } catch (IOException error) {
            error.printStackTrace();
        }
    }
}
