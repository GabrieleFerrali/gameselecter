/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package random;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author gabri
 */
public class RandomController implements Initializable {

    private String path = "C:/Users/gabri/Desktop/Games/1_GameSelecter/game.txt";
    private String path2 = "C:/Users/gabri/Desktop/Games/1_GameSelecter/paths.txt";
    private ArrayList<String> games = new ArrayList<>();
    private ArrayList<String> paths = new ArrayList<>();
    private String currentLine;
    private String currentLine2;

    @FXML
    private Label title1;
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private Button buttonqui;
    @FXML
    private Button buttonrun;
    @FXML
    private CheckBox checkbox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //games
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);

            while ((currentLine = br.readLine()) != null) {
                games.add(currentLine);
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
        //paths
        BufferedReader br2 = null;
        FileReader fr2 = null;
        try {
            fr2 = new FileReader(path2);
            br2 = new BufferedReader(fr2);

            while ((currentLine2 = br2.readLine()) != null) {
                paths.add(currentLine2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br2 != null) {
                    br2.close();
                }
                if (fr2 != null) {
                    fr2.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @FXML
    private void clickQuit(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void clickChoose(ActionEvent event) {
        java.util.Random rdm = new java.util.Random();
        String ausgabe = games.get(rdm.nextInt(games.size()));
        label.setText(ausgabe);
    }

    @FXML
    private void clickRun(ActionEvent event) throws IOException {
        int nr = games.indexOf(label.getText());
        //run file
        Runtime.getRuntime().exec(new File(paths.get(nr).trim()).getCanonicalPath());
    }

    @FXML
    private void clickCheck(ActionEvent event) {
        if (checkbox.isSelected()) {
            label.setVisible(false);
        } else {
            label.setVisible(true);
        }
    }

}
