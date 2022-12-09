import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import helpers.contact;
import helpers.manageContacts;

public class Main {
    // Scanner init
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        //afficherMenuTxt("menu.txt");
        afficherMenu();
        
        while (true) {
            String choise = scan.nextLine();
            switch (choise) {
                case "1":
                    addContact();
                    break;
                case "2":
                    manageContacts.showAllContacts();
                    break;
                case "3":
                    manageContacts.modifyContact();
                    break;
                case "4":
                    manageContacts.deleteContact();
                case "a":
                    scan.close();
                    return;
                default:
                    System.out.println("Are you sure your answer is correct ?");
                    break;
            }
            //afficherMenuTxt("menu.txt");
            afficherMenu();
        }
    }

    /*
    // Custom text version
    public static void afficherMenuTxt(String menufile) {
        try { 
            File file = new File(menufile);
            scan = new Scanner(file);

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                System.out.println(line);
            }
            scan.close();
        } 
        catch (Exception error) {
            System.out.println(error);
        }
    }
    */

    // Standard array version
    public static void afficherMenu() {
        ArrayList<String> menus = new ArrayList<>();
        menus.add("[--------------- MENU ---------------]");
        menus.add("|                                    |");
        menus.add("| 1: Ajouter un contact              |");
        menus.add("| 2: Lister les contacts             |");
        menus.add("| 3: Modifier contact                |");
        menus.add("| 4: Supprimer contact               |");
        menus.add("| 5: Trier les contacts              |");
        menus.add("| 6: Trier les contacts par date     |");
        menus.add("| 7: Rechercher les contacts sur nom |");
        menus.add("|                                    |");
        menus.add("|          Press a to leave          |");
        menus.add("[------------------------------------]");
        for (String s : menus) {
            System.out.println(s);
        }
    }

    private static void addContact() {
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
}