package com.JHGH.x00091813;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Item> PersonalItems = new ArrayList<>();
        ArrayList<Item> CommonItems = new ArrayList<>();
        int choice, listChoice;
        do {
            choice = mainMenu();
            switch (choice) {
                case 1:
                    PersonalItems.add(addItem());
                    break;
                case 2:
                    if (!PersonalItems.isEmpty())
                        CommonItems.add(shareItem(PersonalItems));
                    else
                        JOptionPane.showMessageDialog(null, "No items in storage.");
                    break;
                case 3:
                    listChoice = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "(1) Personal items    OR    (2) Common items"));
                    if (listChoice == 1 && !PersonalItems.isEmpty())
                        searchById(PersonalItems);
                    else if (listChoice == 2 && !CommonItems.isEmpty())
                        searchById(CommonItems);
                    else
                        JOptionPane.showMessageDialog(null, "Error");
                    break;
                case 4:
                    listChoice = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "(1) Personal items    OR    (2) Common items"));
                    if (listChoice == 1 && !PersonalItems.isEmpty())
                        searchByType(PersonalItems);
                    else if (listChoice == 2 && !CommonItems.isEmpty())
                        searchByType(CommonItems);
                    else
                        JOptionPane.showMessageDialog(null, "Error");
                    break;
                case 5:
                    listChoice = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "(1) Personal items    OR    (2) Common items"));
                    if (listChoice == 1 && !PersonalItems.isEmpty())
                        deleteById(PersonalItems);
                    else if (listChoice == 2 && !CommonItems.isEmpty())
                        deleteById(CommonItems);
                    else
                        JOptionPane.showMessageDialog(null, "Error");
                    break;
                case 6:
                    listChoice = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "(1) Personal items    OR    (2) Common items"));
                    if (listChoice == 1 && !PersonalItems.isEmpty())
                        deleteByType(PersonalItems);
                    else if (listChoice == 2 && !CommonItems.isEmpty())
                        deleteByType(CommonItems);
                    else
                        JOptionPane.showMessageDialog(null, "Error");
                    break;
                case 7:
                    choice = 0;
                    break;
            }
        } while (choice != 0);
    }

    public static int mainMenu() {
        return Integer.parseInt(JOptionPane.showInputDialog(null,
                "MENU:\n1) Add item.\n2) Share item by ID.\n3) Search item by ID.\n" +
                        "4) Search item by type.\n5) Delete item by ID.\n6) Delete item by type.\n7) EXIT\n" +
                        ""));
    }

    public static Item addItem () {
        String tipo = JOptionPane.showInputDialog(null, "Item type: ");
        String name = JOptionPane.showInputDialog(null, "Name: ");
        int weight = Integer.parseInt((JOptionPane.showInputDialog(null, "Weight: ")));
        String description = JOptionPane.showInputDialog(null, "Description: ");
        if (tipo.equalsIgnoreCase("potion") || tipo.equalsIgnoreCase("Elixir")) {
            int reuseTime = Integer.parseInt((JOptionPane.showInputDialog(null, "ReuseTime: ")));
            String level = JOptionPane.showInputDialog(null, "Level: ");
            String type = JOptionPane.showInputDialog(null, "Type: ");
            int amount = Integer.parseInt((JOptionPane.showInputDialog(null, "Amount: ")));
            if (tipo.equalsIgnoreCase("potion"))
                return  new Potion(IDGenerator.generateID(), name, weight, description, reuseTime, level, type, amount);
            else {
                int time = Integer.parseInt((JOptionPane.showInputDialog(null, "Time: ")));
                return new Elixir(IDGenerator.generateID(), name, weight, description, reuseTime, level, type, amount, time);
            }
        }
        else if (tipo.equalsIgnoreCase("ammo") || tipo.equalsIgnoreCase("weapon")) {
            int remainingUses = Integer.parseInt((JOptionPane.showInputDialog(null, "Remaining uses: ")));
            if (tipo.equalsIgnoreCase("ammo")) {
                Boolean equipped = Boolean.parseBoolean(JOptionPane.showInputDialog(null, "Equipped (true/false):"));
                return new Ammo(IDGenerator.generateID(), name, weight, description, remainingUses, equipped);
            }
            else {
                String type = JOptionPane.showInputDialog(null, "Type: ");
                double speed = Double.parseDouble(JOptionPane.showInputDialog(null, "Speed: "));
                double damage = Double.parseDouble(JOptionPane.showInputDialog(null, "Damage: "));
                String wieldType = JOptionPane.showInputDialog(null, "Wield type: ");
                int level = Integer.parseInt(JOptionPane.showInputDialog(null, "Level: "));
                return new Weapon(IDGenerator.generateID(), name, weight, description, remainingUses, type, speed, damage, wieldType, level);
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Operation failed");
        return null;
    }

    public static Item shareItem(ArrayList<Item> list) {
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "ID: "));
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id)
                return list.get(i);
        }
        return null;
    }

    public static void searchById(ArrayList<Item> list) {
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "ID: "));
        list.forEach(obj -> {
            if (obj.getId() == id)
                JOptionPane.showMessageDialog(null, obj.toString());
        });
    }

    public static void searchByType(ArrayList<Item> list) {
        String type = JOptionPane.showInputDialog(null, "Type: ");
        if (type.equalsIgnoreCase("potion")) {
            list.forEach(obj -> {
                if (obj instanceof Potion)
                    JOptionPane.showMessageDialog(null, obj.toString());
            });
        }
        else if (type.equalsIgnoreCase("elixir")) {
            list.forEach(obj -> {
                if (obj instanceof Elixir)
                    JOptionPane.showMessageDialog(null, obj.toString());
            });
        }
        else if (type.equalsIgnoreCase("ammo")) {
            list.forEach(obj -> {
                if (obj instanceof Ammo)
                    JOptionPane.showMessageDialog(null, obj.toString());
            });
        }
        else if (type.equalsIgnoreCase("weapon")) {
            list.forEach(obj -> {
                if (obj instanceof Weapon)
                    JOptionPane.showMessageDialog(null, obj.toString());
            });
        }
    }

    public static void deleteById(ArrayList<Item> list) {
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "ID: "));
        list.removeIf(obj -> (obj.getId() == id));
    }

    public static void deleteByType(ArrayList<Item> list) {
        String type = JOptionPane.showInputDialog(null, "Type: ");
        if (type.equalsIgnoreCase("potion"))
            list.removeIf(obj -> (obj instanceof Potion));
        else if (type.equalsIgnoreCase("elixir"))
            list.removeIf(obj -> (obj instanceof Elixir));
        else if (type.equalsIgnoreCase("ammo"))
            list.removeIf(obj -> (obj instanceof Ammo));
        else if (type.equalsIgnoreCase("weapon"))
            list.removeIf(obj -> obj instanceof Weapon);
    }
}
