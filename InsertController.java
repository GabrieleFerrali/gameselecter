/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import library.LibraryController;

/**
 * FXML Controller class
 *
 * @author gabri
 */
public class InsertController implements Initializable {

    private ArrayList<String> games = new ArrayList<>();
    private ArrayList<String> paths = new ArrayList<>();
    private int num = 0;
    private LibraryController library = new LibraryController();
    private String path = "C:/Users/gabri/Desktop/Games/1_GameSelecter/game.txt";
    private String path2 = "C:/Users/gabri/Desktop/Games/1_GameSelecter/paths.txt";
    private String currentLine;
    private String currentLine2;

    @FXML
    private Label title1;
    @FXML
    private TextField textbox;
    @FXML
    private Button buttonqui;
    @FXML
    private Button buttonok;
    @FXML
    private Label label;
    @FXML
    private Button buttonsav;
    @FXML
    private TextField textbox2;
    @FXML
    private Label labelpath;
    @FXML
    private Button buttonwish;

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
    private void clickQuit(ActionEvent event) throws IOException {
        //System.exit(0);
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void clickOK(ActionEvent event) throws IOException {
        if (textbox.getText().equals("") && textbox2.getText().equals("")) {
            label.setTextFill(Color.RED);
            label.setText("Nothing there");
        }
        if (textbox.getText().equals("")) {
            label.setTextFill(Color.RED);
            label.setText("Nothing there");
        } else if (textbox2.getText().equals("")) {
            label.setTextFill(Color.RED);
            label.setText("Nothing there");
        } else {
            label.setTextFill(Color.GREEN);
            label.setText("Successfully Added");
            games.add(textbox.getText());
            paths.add(textbox2.getText());
            textbox.setText("");
            textbox2.setText("");
        }
    }

    @FXML
    private void clickSave(ActionEvent event) throws IOException {
        /*FileOutputStream fos = null;
        FileWriter fw = new FileWriter(path);
        PrintWriter pw = new PrintWriter(fw);
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(path));
        String ausgabe = textbox.getText();
        if (br.readLine() == null) {
            //Create
            try {
                fos = new FileOutputStream(path);
                fos.write(ausgabe.getBytes());
            } catch (IOException e) {
                fos.close();
                throw e;
            }
            //for (int i = 0; i < games.size(); i++) {
              //  pw.printf("%s" + "%n", games.get(i));
            //}
            pw.close();
        } else {
            //Write
            
        }
         */
        //game
        FileWriter fw = new FileWriter(path);
        PrintWriter pw = new PrintWriter(fw);
        for (int i = 0; i < games.size(); i++) {
            pw.printf("%s" + "%n", games.get(i));
        }
        pw.close();

        //path
        FileWriter fw2 = new FileWriter(path2);
        PrintWriter pw2 = new PrintWriter(fw2);
        for (int i = 0; i < paths.size(); i++) {
            pw2.printf("%s" + "%n", paths.get(i));
        }
        pw2.close();

    }

    @FXML
    private void clickWish(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/insertwish/InsertWish.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.getIcons().add(new Image("/gameselecter/icon.PNG"));
        stage.setTitle("Insert a Wish");
        stage.setScene(scene);
        stage.show();
    }

}
