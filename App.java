import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import helpers.Contact;

public class App {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        afficherMenu();
        while (true) {
            String choix = scan.nextLine();
            switch (choix) {
                case "1":
                    ajouterContact();
                    break;
                case "2":
                    break;
                case "3":
                    afficherContact();
                    break;
                case "q":
                    scan.close();
                    return;
                default:
                    System.out.println("Boulet!!!!");
                    break;
            }
            afficherMenu();
        }
    }

    private static void ajouterContact() {

        Contact c = new Contact();
        System.out.println("Saisir le nom:");
        c.setNom(scan.nextLine());
        System.out.println("Saisir le prénom:");
        c.setPrenom(scan.nextLine());

        do {
            try {
                System.out.println("Saisir le téléphone:");
                c.setNumero(scan.nextLine());
                break;
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        do {
            try {
                System.out.println("Saisir le mail:");
                c.setMail(scan.nextLine());
                break;
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        do {
            try {
                System.out.println("Saisir la date de naissance:");
                c.setDateNaissance(scan.nextLine());
                break;
            } catch (ParseException e) {
                System.out.println("Error, try again!");
            }
        } while (true);

        c.enregistrer();

    }

    private static void afficherContact() {
        Scanner sc;
        try {
            sc = new Scanner(new File("contacts.csv"));
            sc.useDelimiter(";");   //sets the delimiter pattern  
            while (sc.hasNext())  //returns a boolean value  
            {
                System.out.print(sc.next()); //find and returns the next complete token from this scanner  
            }
        sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public static void afficherMenu() {
        // 1
        /*
         * System.out.println("-- MENU --");
         * System.out.println("1- Ajouter un contact");
         * System.out.println("2- Lister les contacts");
         * System.out.println("q- Quitter");
         */
        // 2
        ArrayList<String> menus = new ArrayList<>();
        menus.add("\n[-- MENU --]");
        menus.add("1- Ajouter un contact");
        menus.add("2- Modifier un contact");
        menus.add("3- Lister les contacts");
        menus.add("q- Quitter\n");
        for (String s : menus) {
            System.out.println(s);
        }
    }
}
