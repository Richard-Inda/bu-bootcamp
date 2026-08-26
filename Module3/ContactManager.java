import java.util.*;

public class ContactManager {

    public static void main(String[] args) {

        HashMap<String, Contact> contacts = new HashMap<>();

        contacts.put("Ada Lovelace",
                new Contact("Ada Lovelace", "+1 617 555 0101"));
        contacts.put("John Smith",
                new Contact("John Smith", "+1 305 555 0102"));
        contacts.put("Maria Garcia",
                new Contact("Maria Garcia", "+1 786 555 0103"));
        contacts.put("David Johnson",
                new Contact("David Johnson", "+1 954 555 0104"));
        contacts.put("Emily Brown",
                new Contact("Emily Brown", "+1 561 555 0105"));
        Contact foundContact = contacts.get("Ada Lovelace");

        if (foundContact == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println("Contact found:");
            System.out.println(foundContact);
        }
        Contact missingContact = contacts.get("Bob Williams");

        if (missingContact == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(missingContact);
        }

        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());

        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));

        System.out.println();
        System.out.println("=== All Contacts ===");

        for (Contact contact : sorted) {
            System.out.println(contact);
        }
    }
}