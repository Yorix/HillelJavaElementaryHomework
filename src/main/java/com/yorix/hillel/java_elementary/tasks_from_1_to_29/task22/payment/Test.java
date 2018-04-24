package com.yorix.hillel.java_elementary.tasks_from_1_to_29.task22.payment;

public class Test {
    public static void main(String[] args) {
        Payment payment = new Payment();
        System.out.println(payment);

        payment.addItem("Сапоги резиновые", 70);
        payment.addItem("Лопата", 150);
        payment.addItem("Мешок", 8);
        payment.addItem("Верёвка", 24);
        payment.addItem("Перчатки резиновые", 15);

        System.out.println(payment);

        payment.removeItem(4);
        payment.removeItem("Сапоги резиновые");

        System.out.println(payment);

        System.out.println(payment.getItem("Верёвка") + " " + payment.getItem("Верёвка").getPrice());
        System.out.println(payment.getItem(0) + " " + payment.getItem(0).getPrice());
        System.out.println(payment.getItem(4) + " " + payment.getItem(4).getPrice());
    }
}
