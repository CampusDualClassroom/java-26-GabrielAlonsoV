package com.campusdual.classroom;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    private Map<String, Contact> contacts;

    public Phonebook() {
        contacts = new HashMap<>();
    }

    // Añadir un contacto a la lista
    public void addContact(Contact contact) {
        contacts.put(contact.getCode(), contact);
        System.out.println("Contact added with code: " + contact.getCode());
    }

    // Mostrar todos los contactos en la lista
    public void showPhonebook() {
        if (contacts.isEmpty()) {
            System.out.println("Phonebook is empty.");
        } else {
            for (Contact contact : contacts.values()) {
                contact.showContactDetails();
                System.out.println(); // Añadir línea en blanco para separación
            }
        }
    }

    // Eliminar un contacto por su código
    public void deleteContact(String code) {
        if (contacts.remove(code) != null) {
            System.out.println("Contact with code " + code + " deleted.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    // Obtener los contactos
    public Map<String, Contact> getData() {
        return contacts;
    }
}