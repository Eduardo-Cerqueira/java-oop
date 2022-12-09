package helpers;

import java.util.Comparator;

// More info : https://www.geeksforgeeks.org/java-program-to-sort-objects-in-arraylist-by-date/
public class sortDate implements Comparator<contact> {
    public int compare(contact a, contact b)
    {
        return a.getBirth_date().compareTo(b.getBirth_date());
    }
}
