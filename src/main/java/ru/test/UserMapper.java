package ru.test;

import java.sql.*;
import java.util.*;

/**
 * Взаимодействие с базой данных
 */
public class UserMapper {
    private static String USERNAME = "root";//имя пользователя
    private static String PASSWORD = "root";//пароль
    private static String URL = "jdbc:mysql://localhost:3306/test"; //url базы

    /**
     * Метод для генерации пользователей и заполнения ими таблицы
     * @param amountFields - количество строк
     * @throws SQLException
     */
    public static void generateFields(int amountFields) throws SQLException {
        List<User> users = GenUsers.createUser(amountFields);
        DBConnector db = new DBConnector();

        try (Connection connection = db.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {

            for (int i = 0; i < users.size(); i++) {
                statement.execute("INSERT INTO test.users(user_name, sex) VALUES (" + '"' + users.get(i).getName() + '"' +
                        "," + '"' + users.get(i).getGender().getName() + '"' + ")");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Выборка из таблицы строк с указанными именем и полом
     * @param name - имя пользователя/начало имени
     * @param gender - пол пользователя
     * @throws SQLException
     */
    public static void selectByNameAndSex(String name, Gender gender) throws SQLException {
        DBConnector db = new DBConnector();
        String query = "SELECT * FROM USERS WHERE USER_NAME LIKE '" + name + "%' AND USERS.sex LIKE '" + gender.getName() + "%'";

        try (Connection connection = db.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                String userName;
                java.util.Date date;
                String userGender;

                userName = result.getString("USER_NAME");
                date = result.getDate("birthDate");
                userGender = result.getString("sex");
                User user = new User(userName, date);
                user.setGender(userGender);
                System.out.println(user);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Выборка строк таблицы с уникальными именами и датами
     * @throws SQLException
     */
    public static void selectUniqueNameAndData() throws SQLException {
        DBConnector db = new DBConnector();
        String query = "SELECT DISTINCT USER_NAME, birthDate FROM users ORDER BY USER_NAME";

        try (Connection connection = db.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                String userName;
                java.util.Date date;

                userName = result.getString("USER_NAME");
                date = result.getDate("birthDate");
                User user = new User(userName, date);

                System.out.println(user);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод для очистки таблицы
     * @throws SQLException
     */
    public static void cleanTable() throws SQLException {
        DBConnector db = new DBConnector();

        try (Connection connection = db.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.execute("delete from test.users");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
