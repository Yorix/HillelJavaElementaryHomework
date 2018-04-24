package com.yorix.hillel.java_elementary.tasks_from_1_to_29.task19;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Strings {

    public static void main(String[] args) {

        String text = getTextFromFile();
        String punctuation = "[\\.\\?\\!\\*\\,\\:\\;\\—\\)\\(\\»\\«\\]\\[\"\\-]";
    /*
    В тексте найти и напечатать n символов (и их количество), встречающихся
    наиболее часто.
     */
        char[] charArr = text.toLowerCase().replaceAll(" ", "").toCharArray();
        Arrays.sort(charArr);

        int count = 0;
        int max = 0;
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < charArr.length - 1; i++) {
            if (charArr[i] == charArr[i + 1]) {
                count++;
                if (count > max) {
                    max = count;
                }
            } else count = 1;
        }

        for (int i = 0; i < charArr.length - 1; i++) {
            if (charArr[i] == charArr[i + 1]) {
                count++;
                if (count == max) {
                    res.append(charArr[i]).append(" ");
                }
            } else count = 1;
        }

        System.out.printf("Самые употребляемые символы в тексте, встречающиеся %d раз: %s\n", max, res);

        /*
        Найти, каких букв, гласных или согласных, больше в каждом предложении
        текста.
        (Сделал для первых 10 предложений, поскольку предложений в выбранном тексте очень много.)
         */

        for (int i = 0, j = 0; i < 10; i++, j++) {

            int numOfVowels = 0;
            int numOfConsonants = 0;
            String vowels = "аеёиоуыэюя";
            String consonants = "бвгджзйклмнпрстфхцчшщъь";
            StringBuilder sentence = new StringBuilder();

            while (text.charAt(j) != '.') {
                if (vowels.contains(text.toLowerCase().substring(j, j + 1))) {
                    numOfVowels++;
                } else if (consonants.contains(text.toLowerCase().substring(j, j + 1))) {
                    numOfConsonants++;
                }
                sentence.append(text.charAt(j));
                j++;
            }
            System.out.println(sentence);
            System.out.println("Гласных в предложении " + numOfVowels);
            System.out.println("Согласных в предложении " + numOfConsonants);
            System.out.println("==========================");
        }

        /*
         Из текста удалить все символы, кроме пробелов, не являющиеся буквами.
         */
        StringBuilder processedText = new StringBuilder(text.replaceAll(punctuation, " "));
        processedText = new StringBuilder(processedText.toString().replaceAll("\\d", ""));
        System.out.println(processedText);

        /*
        В тексте найти и напечатать все слова максимальной и все слова минимальной длины.
         */
        processedText = new StringBuilder(processedText.toString().replaceAll("\\s+", " "));
        String[] words = processedText.toString().toLowerCase().split(" ");

        int min = max = words[0].length();
        StringBuilder minLen = new StringBuilder();
        StringBuilder maxLen = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() < min) {
                min = words[i].length();
            } else if (words[i].length() > max) {
                max = words[i].length();
            }
        }
        for (String word : words) {
            if (word.length() == min && !minLen.toString().contains(word)) {
                minLen.append(word).append(" ");
            }
            if (word.length() == max && !maxLen.toString().contains(word)) {
                maxLen.append(word).append(" ");
            }
        }
        System.out.println("Самые короткие слова: " + minLen);
        System.out.println("Самые длинные слова: " + maxLen);

        /*
        Подсчитать количество содержащихся в данном тексте знаков препинания.
         */
        System.out.println("Количество знаков препинания в тексте: " + (text.split(punctuation).length - 1));

        /*
        Подсчитать, сколько раз заданное слово входит в текст.
         */
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите искомое слово: ");
        String input = scanner.next().toLowerCase();
        System.out.printf("Слово \"%s\" встерчается в тексте %d раз.\n", input, text.toLowerCase().split(input).length - 1);

        /*
        В каждом слове текста k-ю букву заменить заданным символом. Если k
        больше длины слова, корректировку не выполнять.
         */
        System.out.print("Введите номер заменяемой буквы: ");
        int k = scanner.nextInt() - 1;
        System.out.print("Введите букву для замены: ");
        input = "input";
        while (input.length() > 1) {
            input = scanner.next();
        }
        char letter = input.charAt(0);


        StringBuilder newText = new StringBuilder();
        String[] splitText = text.split(" ");

        for (int i = 0; i < splitText.length; i++) {
            if (splitText[i].length() > k
                    && !Pattern.matches(punctuation, Character.toString(splitText[i].charAt(k)))) {
                StringBuilder builder = new StringBuilder(splitText[i]);
                builder.setCharAt(k, letter);
                splitText[i] = builder.toString();
            }
            newText.append(splitText[i]).append(" ");
        }

        System.out.println(newText);
    }


    public static String getTextFromFile() {
        File file = new File("src/com.yorix.hillel.java_elementary.tasks_from_1_to_29.task19/Хемингуэй Эрнест. Старик и море.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder builder = new StringBuilder();

        while (scanner.hasNextLine()) {
            builder.append(scanner.nextLine());
        }

        return builder.toString();
    }
}
