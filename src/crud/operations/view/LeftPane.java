/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.operations.view;

import crud.operations.controller.UserController;
import crud.operations.model.UserData;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;

/**
 *
 * @author Abo Agiza
 */
public class LeftPane extends VBox {

    UserController uc = new UserController();

    int tempId;

    Label txtLabel = new Label("Add New User");

    TextField txtFullNameField = new TextField();
    TextField txtUserEmailField = new TextField();
    TextField txtAgeField = new TextField();

    //Buttons
    Button saveButton = new Button("Save");
    Button updateButton = new Button("Update");
    Button deleteButton = new Button("Delete");

    public LeftPane() {

        txtFullNameField.setPromptText("Enter Full Name");
        txtUserEmailField.setPromptText("Your Email");
        txtAgeField.setPromptText("Enter Your Age");

        saveButton.setPrefWidth(100);
        updateButton.setPrefWidth(100);
        deleteButton.setPrefWidth(100);

        txtLabel.setStyle("-fx-font-size: 18 ; -fx-textfill:#FFF;");
        this.setStyle("-fx-background-color:#3DB2FF");
        this.setSpacing(15);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20));
        this.getChildren().addAll(txtLabel, txtFullNameField, txtUserEmailField, txtAgeField, saveButton, updateButton, deleteButton);

        saveButton.setOnMouseClicked(e -> {
            UserData userData = new UserData();
            userData.setUserName(txtFullNameField.getText());
            userData.setUserEmail(txtUserEmailField.getText());
            userData.setUserAge(Integer.parseInt(txtAgeField.getText()));

            uc.insertData(userData);

            CrudOperations.rightPane.tableView.setItems(uc.getAllData());

            txtFullNameField.setText("");
            txtUserEmailField.setText("");
            txtAgeField.setText("");

        });

        updateButton.setOnMouseClicked(e -> {

            UserData ud = new UserData();
            ud.setUserId(tempId);
            ud.setUserName(txtFullNameField.getText());
            ud.setUserEmail(txtUserEmailField.getText());
            ud.setUserAge(Integer.parseInt(txtAgeField.getText()));

            uc.updateData(ud);

            CrudOperations.rightPane.tableView.setItems(uc.getAllData());
        });

        deleteButton.setOnMouseClicked(e -> {
            uc.deleteData(tempId);
            CrudOperations.rightPane.tableView.setItems(uc.getAllData());

        });

    }

}
