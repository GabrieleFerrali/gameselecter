/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insertwish;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author gabri
 */
public class InsertWishController implements Initializable {

    private ArrayList<String> wishes = new ArrayList<>();
    private String path = "C:/Users/gabri/Desktop/Games/1_GameSelecter/wish.txt";
    private String currentLine;

    @FXML
    private Label title1;
    @FXML
    private TextField textbox;
    @FXML
    private Button buttonok;
    @FXML
    private Button buttonsav;
    @FXML
    private Button buttonqui;
    @FXML
    private Label label;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);

            while ((currentLine = br.readLine()) != null) {
                wishes.add(currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @FXML
    private void clickOK(ActionEvent event) {
        if (textbox.getText().equals("")) {
            label.setTextFill(Color.RED);
            label.setText("Nothing there");
        } else {
            label.setTextFill(Color.GREEN);
            label.setText("Successfully Added");
            wishes.add(textbox.getText());
            textbox.setText("");
        }
    }

    @FXML
    private void clickSave(ActionEvent event) throws IOException {
        FileWriter fw = new FileWriter(path);
        PrintWriter pw = new PrintWriter(fw);
        for (int i = 0; i < wishes.size(); i++) {
            pw.printf("%s" + "%n", wishes.get(i));
        }
        pw.close();
    }

    @FXML
    private void clickQuit(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

}
