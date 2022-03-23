package contacts;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.text.ParseException;
import contacts.Contact;
import contacts.ContactManager;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        try {
            ContactManager contactManager = new ContactManager();
            contactManager.addContact(new Contact("Ryan", "6135012424", "11/11/1992"));
            contactManager.addContact(new Contact("Gio", "6477092344", "11/11/1993"));
            contactManager.addContact(new Contact("Thomas", "8192256979", "11/11/1994"));
            System.out.println(contactManager);
            contactManager.removeContact("Gio");
            System.out.println(contactManager);
        } catch (ParseException var2) {
            var2.printStackTrace();
        }

        System.out.println("Process Complete");
    }
}
