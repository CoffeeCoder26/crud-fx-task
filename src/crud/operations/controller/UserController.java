package crud.operations.controller;

import crud.operations.model.UserData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Abo Agiza
 */
public class UserController {

    Statement myStatement;

    public void insertData(UserData userData) {
        try {
            myStatement = DBConnection.getConnection().createStatement();
            myStatement.executeUpdate("insert into users (UserName,UserEmail,UserAge) values ('" + userData.getUserName() + "','" + userData.getUserEmail() + "'," + userData.getUserAge() + ")");

        } catch (SQLException e) {
            System.out.println(e.toString());
        }

    }

    public void updateData(UserData userData) {
        try {
            myStatement = DBConnection.getConnection().createStatement();

            myStatement.executeUpdate("update users set UserName ='" + userData.getUserName() + "',UserEmail = '" + userData.getUserEmail() + "',UserAge ='" + userData.getUserAge() + "'where UserId = '" + userData.getUserId() + "'");

        } catch (SQLException e) {
            System.out.println(e.toString());
        }

    }

    public void deleteData(int userId) {
        try {
            myStatement = DBConnection.getConnection().createStatement();
            String sqlQuery = "delete from Users where UserId = " + userId + "";

            myStatement.executeUpdate(sqlQuery);

        } catch (SQLException e) {
            System.out.println(e.toString());

        }

    }

    public ObservableList<UserData> getAllData() {
        //Hint
        ObservableList<UserData> users = FXCollections.observableArrayList();
        try {
            myStatement = DBConnection.getConnection().createStatement();
            String sqlQuery = "select * from Users";
            ResultSet myResultSet = myStatement.executeQuery(sqlQuery);

            while (myResultSet.next()) {
                UserData ud = new UserData();
                ud.setUserId(myResultSet.getInt(1));
                ud.setUserName(myResultSet.getString(2));
                ud.setUserEmail(myResultSet.getString(3));
                ud.setUserAge(myResultSet.getInt(4));

                users.add(ud);

                System.out.println(ud);

            }

        } catch (SQLException e) {
            e.toString();
        }

        return users;
    }

    public ObservableList<UserData> searchAllUsers(String UserName) {
        //Hint
        ObservableList<UserData> users = FXCollections.observableArrayList();
        try {
            myStatement = DBConnection.getConnection().createStatement();
            String sqlQuery = "select * from Users where UserName like'%" + UserName + "%'";
            ResultSet myResultSet = myStatement.executeQuery(sqlQuery);

            while (myResultSet.next()) {
                UserData ud = new UserData();
                ud.setUserId(myResultSet.getInt(1));
                ud.setUserName(myResultSet.getString(2));
                ud.setUserEmail(myResultSet.getString(3));
                ud.setUserAge(myResultSet.getInt(4));

                users.add(ud);

                System.out.println(ud);

            }

        } catch (SQLException e) {
            e.toString();
        }
        return users;

    }

    public static void main(String[] args) {
        UserData userData = new UserData();

        userData.setUserName("Ahmed");

        userData.setUserEmail("ahmed@hhh.com");
        userData.setUserAge(11);
        userData.setUserId(1);

        new UserController().getAllData();

    }

}
