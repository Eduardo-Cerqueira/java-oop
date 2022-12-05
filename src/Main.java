import java.util.Scanner;
import java.util.function.Function;
import java.util.*;

public class Main {
    public static void showMenu(String[] menu) {
        int i = 0;
        while (i < menu.length){
            System.out.println(menu[i]);
            i += 1;
        }
        Scanner scannerinput = new Scanner(System.in);
        System.out.println("Choix :");
        String inputuser = scannerinput.nextLine();
        while (!inputuser.equals("q")){
            if (inputuser.equals("1")){
                break;    
            }
            else if (inputuser.equals("2")){
                break;
            }
            else if (inputuser.equals("3")){
                break;  
            }
            else {
                break;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Contact App Opened");
        String[] menu = {
            "1) List all contacts",
            "2) Add contact",
            "3) Update contact",
            "4) Delete contact"
        };
        showMenu(menu);
    }
}