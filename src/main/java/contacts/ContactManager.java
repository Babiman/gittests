package contacts;

import java.util.ArrayList;

public class ContactManager {
    ArrayList<Contact> contacts = new ArrayList<>();

    public ContactManager() {
        this.contacts = new ArrayList<>();
    }

    public Contact getContact(int index) {
        return this.contacts.get(index);
    }

    public void setContact(int index, Contact contact) {
        this.contacts.set(index, new Contact(contact));

    }

    public void addContact(Contact contact) {
        this.contacts.add(new Contact(contact));
    }

    public void removeContact(String contactName) {
        if (this.contacts.isEmpty()){
            throw new IllegalArgumentException("the array is empty");
        }
        for (int i = 0; i < contacts.size(); i++) {
            if (this.contacts.get(i).getName().equals(contactName)) {
                this.contacts.remove(i);
            }

        }
    }

    @Override
    public String toString() {
        String temp = "";

        for (int i = 0; i < this.contacts.size(); i++) {
            temp += contacts.get(i).toString()+"\n\n";

        }
        return temp;
    }
}
