package textmining;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage pStage) throws Exception {
        setPrimaryStage(pStage);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/main.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Text Mining");
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setPrimaryStage(Stage stage) {
        Main.primaryStage = stage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}