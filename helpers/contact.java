package helpers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class contact {
    // Name
    private String name;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name.toUpperCase();
    }
    
    // Surname (Family name)
    private String surname;

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname.substring(0,1).toUpperCase() + surname.substring(1);
    }

     // Phone Number
    private String phone_num;
    
    public String getPhone_num() {
        return phone_num;
    }
    public void setPhone_num(String phone_num) throws ParseException {
            Pattern pat = Pattern.compile("^(?:(?:\\+|00)33|0)\\s*[1-9](?:[\\s.-]*\\d{2}){4}$");
            Matcher phone_standard = pat.matcher(phone_num);
            if (phone_standard.matches()) {
                this.phone_num = phone_num;
            } else {
                throw new ParseException("\nYou typed : " + phone_num + " | Incorrect phone number !\n", 0);
            }
        }

    // Email
    private String email;

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) throws ParseException {
        Pattern pat = Pattern.compile("^[a-zA-Z0-9_.-]+@{1}[a-zA-Z0-9_.-]{2,}\\.[a-zA-Z.]{2,10}$");
        Matcher email_standard = pat.matcher(email);
        if (email_standard.matches()) {
            this.email = email;
        } else {
            throw new ParseException("You typed : " + email + " | Incorrect email format !", 0);
        }
    }

    // Birth date
    private Date birth_date;

    public Date getBirth_date()  {
        return birth_date;
    }
    public void setBirth_date(String birth_date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.birth_date = dateFormat.parse(birth_date);
    }

    public static final String spliter = ";";

    public String toString() {
        StringBuilder construct = new StringBuilder();
        construct.append(getName());
        construct.append(spliter);
        construct.append(getSurname());
        construct.append(spliter);
        construct.append(getEmail());
        construct.append(spliter);
        construct.append(getPhone_num());
        construct.append(spliter);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        construct.append(dateFormat.format(getBirth_date()));
        return construct.toString();
    }

    public void save() throws IOException {
        try {
            FileWriter writer = new FileWriter("contacts.csv", true);
            writer.write(this.toString());
            writer.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    public static void saveAll(List<contact> contacts) throws IOException {

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("contacts.csv", false)));
        try {
            for (contact contact : contacts) {
                pw.println(contact.toString());
            }
        } finally {
            pw.close();
        }
    }
}
