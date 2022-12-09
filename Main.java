import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    // Scanner init
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        afficherMenu("menu.txt");

        /*while (true) {
            String choix = scan.nextLine();
            switch (choix) {
                case "1":
                    ajouterContact();
                    break;
                case "2":
                    listerContact();
                    break;
                case "3":
                    modifierContact();
                    break;
                case "4":
                    supprimerContact();
                    break;
                case "5":
                    trierContact();
                    break;
                case "6":
                    trierContactParDate();
                    break;
                case "7":
                    rechercherContact();
                    break;
                case "q":
                    scan.close();
                    return;
                default:
                    System.out.println("Boulet!!!!");
                    break;
            }
            afficherMenu("menu.txt");
        }*/
    }
    // Name
    private String name;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    // Surname (Family name)
    private String surname;

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

     // Phone Number
    private String phone_num;
    
    public String getPhone_num() {
        return phone_num;
    }
    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    // Email
    private String email;

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // Birth date
    private Date birth_date;

    public Date getBirth_date() {
        return birth_date;
    }
    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    /*
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
        menus.add("|          Press q to leave          |");
        menus.add("[------------------------------------]");
        for (String s : menus) {
            System.out.println(s);
        }
    }
}