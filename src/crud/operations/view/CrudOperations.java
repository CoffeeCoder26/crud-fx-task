package crud.operations.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CrudOperations extends Application {

    static LeftPane leftPane = new LeftPane();
    static RightPane rightPane = new RightPane();

    public static void main(String[] args) {

        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox hBox = new HBox();
        hBox.getChildren().addAll(leftPane, rightPane);

        leftPane.prefWidthProperty().bind(hBox.widthProperty().divide(4));

        rightPane.prefWidthProperty().bind(hBox.widthProperty().subtract(hBox.widthProperty().divide(4)));

        Scene scene = new Scene(hBox);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

}
