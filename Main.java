import java.util.ArrayList;
import java.util.Scanner;
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
                    manageContacts.addContact();
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
}