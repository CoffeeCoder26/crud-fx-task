package crud.operations.view;

import crud.operations.controller.UserController;
import crud.operations.model.UserData;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class RightPane extends VBox {

    HBox searchPaneBox = new HBox();
    TextField searchtTextField = new TextField();
    Button searthButton = new Button("Search");

    TableView<UserData> tableView = new TableView();
    UserController uc = new UserController();

    public RightPane() {
        TableColumn<UserData, Integer> columnId = new TableColumn("User Id");
        TableColumn<UserData, String> columnName = new TableColumn("User Name");
        TableColumn<UserData, String> columnEmail = new TableColumn("User Email");
        TableColumn<UserData, Integer> columnAge = new TableColumn("User Age");

        columnId.setCellValueFactory(new PropertyValueFactory<>("UserId"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("UserName"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("UserEmail"));
        columnAge.setCellValueFactory(new PropertyValueFactory<>("UserAge"));

        tableView.getColumns().addAll(columnId, columnName, columnEmail, columnAge);
        tableView.setItems(uc.getAllData());

        tableView.setOnMouseClicked(e -> {
            UserData ud = tableView.getSelectionModel().getSelectedItem();

            CrudOperations.leftPane.txtFullNameField.setText(ud.getUserName());
            CrudOperations.leftPane.txtUserEmailField.setText(ud.getUserEmail());
            CrudOperations.leftPane.txtAgeField.setText(ud.getUserAge() + "");
            CrudOperations.leftPane.tempId = ud.getUserId();

        });
        
        
        searthButton.setOnMouseClicked(e -> {
            this.tableView.setItems(uc.searchAllUsers(searchtTextField.getText()));

        });
        
        

        searchPaneBox.getChildren().addAll(searchtTextField, searthButton);
        searchPaneBox.setAlignment(Pos.CENTER);
        searchPaneBox.setSpacing(20);
        searchPaneBox.setPadding(new Insets(20));

        this.setPadding(new Insets(20));
        this.getChildren().addAll(searchPaneBox, tableView);
    }

}
