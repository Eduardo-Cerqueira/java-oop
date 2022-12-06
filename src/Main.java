import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void showList(String[] list) {
        int i = 0;
        while (i < list.length){
            System.out.println(list[i]);
            i += 1;
        }
    }

    public static void createfile(String name_file){
        try {
        File contacts = new File(name_file + ".txt"); 
        contacts.createNewFile();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void addContact(String name_file, String nom ,String numero, String date_naissance){
        try {
            File contacts = new File(name_file + ".txt"); 
            if (contacts.createNewFile()){

            }
            else {
                FileWriter texte = new FileWriter(name_file + ".txt");
                texte.write(nom + " " + numero + " " + date_naissance);
                texte.close();
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void showContacts(String name_file){
        createfile(name_file);
        String file = name_file + ".txt";
        try{
 
           //Create object of FileReader
           FileReader inputFile = new FileReader(file);
 
           //Instantiate the BufferedReader Class
           BufferedReader bufferReader = new BufferedReader(inputFile);
 
           //Variable to hold the one line data
           String line;
 
           // Read file line by line and print on the console
           while ((line = bufferReader.readLine()) != null)   {
             System.out.println(line);
           }
           //Close the buffer reader
           bufferReader.close();
        } catch(Exception e){
           System.out.println("Error while reading file line by line:" + e.getMessage());                      
        }
 
    }

    public static void main(String[] args) {
        String[] menu = {
            "\n1) List all contacts",
            "2) Add contact",
            "3) Update contact",
            "4) Delete contact"
        };
        showList(menu);
    
        Scanner scannerinput = new Scanner(System.in);
        System.out.println("\nChoix :\n");
        String inputuser = scannerinput.nextLine();
        while (!inputuser.equals("q")){
            if (inputuser.equals("1")){
                showContacts("contacts");
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
}