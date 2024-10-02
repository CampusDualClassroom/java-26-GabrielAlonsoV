package com.campusdual.classroom;

import java.util.Scanner;

public class Exercise26 {  // Clase principal
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("=== Phonebook Menu ===");
            System.out.println("1. Add Contact");
            System.out.println("2. Show Contacts");
            System.out.println("3. Select Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Limpiar el carácter de nueva línea

            switch (choice) {
                case 1:
                    // Agregar Contacto
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter surnames: ");
                    String surnames = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();

                    Contact newContact = new Contact(name, surnames, phone);
                    phonebook.addContact(newContact);
                    break;

                case 2:
                    // Mostrar Contactos
                    phonebook.showPhonebook();
                    break;

                case 3:
                    // Seleccionar Contacto
                    System.out.print("Enter contact code to select: ");
                    String code = scanner.nextLine();
                    Contact selectedContact = phonebook.getData().get(code);

                    if (selectedContact != null) {
                        boolean contactRunning = true;
                        while (contactRunning) {
                            System.out.println("=== Actions for " + selectedContact.getName() + " ===");
                            System.out.println("1. Call My Number");
                            System.out.println("2. Call Other Number");
                            System.out.println("3. Show Details");
                            System.out.println("4. Back to Main Menu");
                            System.out.print("Choose an action: ");
                            int actionChoice = scanner.nextInt();
                            scanner.nextLine();  // Limpiar el carácter de nueva línea

                            switch (actionChoice) {
                                case 1:
                                    selectedContact.callMyNumber();
                                    break;
                                case 2:
                                    System.out.print("Enter the number to call: ");
                                    String otherNumber = scanner.nextLine();
                                    selectedContact.callOtherNumber(otherNumber);
                                    break;
                                case 3:
                                    selectedContact.showContactDetails();
                                    break;
                                case 4:
                                    contactRunning = false; // Volver al menú principal
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please try again.");
                                    break;
                            }
                        }
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 4:
                    // Eliminar Contacto
                    System.out.print("Enter contact code to delete: ");
                    String deleteCode = scanner.nextLine();
                    phonebook.deleteContact(deleteCode);
                    break;

                case 5:
                    // Salir
                    running = false;
                    System.out.println("Exiting the phonebook. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close(); // Cerrar el escáner
    }
}