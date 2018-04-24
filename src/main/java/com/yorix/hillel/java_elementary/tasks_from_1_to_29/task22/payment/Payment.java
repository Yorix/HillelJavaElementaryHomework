package com.yorix.hillel.java_elementary.tasks_from_1_to_29.task22.payment;

import java.util.LinkedList;

public class Payment {
    private LinkedList<Item> items = new LinkedList<>();
    private Item nullItem = new Item(null, 0);
    private int totalCost;

    public void addItem(String name, int price) {
        Item current = new Item(name, price);
        items.add(current);
        totalCost += current.price;
    }

    public boolean removeItem(String name) {
        for (int i = 0, len = items.size(); i < len; i++) {
            if (items.get(i).name.equals(name)) {
                totalCost -= items.get(i).price;
                items.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean removeItem(int index) {
        if (index >= items.size() || index < 0) return false;
        totalCost -= items.get(index).price;
        items.remove(index);
        return true;
    }

    public Item getItem(String name) {
        for (Item item : items) {
            if (item.name.equals(name)) {
                return item;
            }
        }
        return nullItem;
    }

    public Item getItem(int index) {
        if (index >= items.size() || index < 0) return nullItem;
        return items.get(index);
    }

    public int getTotalCost() {
        return totalCost;
    }

    @Override
    public String toString() {
        return "Payment: " + items + "\nTotal cost: " + totalCost;
    }


    public static class Item {
        private String name;
        private int price;

        private Item(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
