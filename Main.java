import java.util.Date;
import java.util.Scanner;

public class Main {
    // Scanner init
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

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
}