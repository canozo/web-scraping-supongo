package textmining.controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import textmining.Cleaner;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class mainController implements Initializable {

    public TextArea inputTA;
    public TextArea outputTA;
    public Button beginBTN;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void begin() {
        try {
            Cleaner cleaner = new Cleaner(new FileReader(Cleaner.archivoInput));
            cleaner.yylex();
            outputTA.setText(cleaner.buffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
