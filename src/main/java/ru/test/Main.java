package ru.test;

import java.sql.*;

/**
 * Проверка методов
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        UserMapper.generateFields(1000000);
        UserMapper.selectByNameAndSex("Ф",Gender.MAN);
        UserMapper.selectUniqueNameAndData();

//        UserMapper.cleanTable();
    }
}
