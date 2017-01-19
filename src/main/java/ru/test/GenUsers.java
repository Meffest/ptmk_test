package ru.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static ru.test.StrGenerator.Consist.ONLY_LETTERS;

/**
 * Класс для генерации списка пользователей
 */
public class GenUsers {

    public static List<User> createUser(int amount) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            if (i < 100) {
                users.add(new User("Ф" + StrGenerator.generateString(8, ONLY_LETTERS), new Date(1990, 6, 8), Gender.MAN));
            } else users.add(new User(StrGenerator.generateString(8, ONLY_LETTERS), new Date(1990, 6, 8), i % 2 == 0 ? Gender.MAN : Gender.WOMAN));

        }
        return users;
    }
}
