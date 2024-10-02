package com.campusdual.classroom;

import java.text.Normalizer;

public class Contact implements ICallActions {
    private String name;
    private String surnames;
    private String phone;
    private String code;

    public Contact(String name, String surnames, String phone) {
        this.name = name;
        this.surnames = surnames;
        this.phone = phone;
        this.code = generateContactCode();
    }

    private String generateContactCode() {
        // Eliminar signos diacríticos y espacios extraños
        String normalizedSurnames = Normalizer.normalize(surnames, Normalizer.Form.NFD);
        normalizedSurnames = normalizedSurnames.replaceAll("[^\\p{ASCII}]", ""); // Remover acentos

        StringBuilder codeBuilder = new StringBuilder();
        // Obtener la primera letra del nombre en minúscula
        codeBuilder.append(name.toLowerCase().charAt(0));

        // Dividir apellidos por espacios
        String[] surnameParts = normalizedSurnames.split(" ");

        if (surnameParts.length == 1) {
            // Si solo tiene un apellido
            codeBuilder.append(surnameParts[0].toLowerCase());
        } else {
            // Si tiene más de un apellido, agregar primera letra del primero y el resto del segundo
            codeBuilder.append(surnameParts[0].toLowerCase().charAt(0));

            // Concatenar el resto de los apellidos (sin espacios)
            for (int i = 1; i < surnameParts.length; i++) {
                codeBuilder.append(surnameParts[i].toLowerCase());
            }
        }

        return codeBuilder.toString();
    }

    @Override
    public void callMyNumber() {
        // Imprimir el mensaje que indica que se está llamando a sí mismo
        System.out.println("Calling myself, " + name + " " + surnames + ", at " + phone);
    }

    @Override
    public void callOtherNumber(String number) {
        // Imprimir el mensaje que indica que está llamando a otro número
        System.out.println("Calling " + name + " " + surnames + " at " + number);
    }

    @Override
    public void showContactDetails() {
        // Mostrar detalles del contacto
        System.out.println("Name: " + name);
        System.out.println("Surnames: " + surnames);
        System.out.println("Phone: " + phone);
        System.out.println("Code: " + code);
    }

    public String getName() {
        return name;
    }

    public String getSurnames() {
        return surnames;
    }

    public String getPhone() {
        return phone;
    }

    public String getCode() {
        return code;
    }
}