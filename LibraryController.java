/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.BufferedReader;
import java.io.File;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

/**
 * FXML Controller class
 *
 * @author gabri
 */
public class LibraryController implements Initializable {

    /*File currentDir = new File("");
    private String path = "currentDir.getAbsolutePath()" +"/game.txt";
    */
    private String path = "C:/Users/gabri/Desktop/Games/1_GameSelecter/game.txt";
    private String path2 = "C:/Users/gabri/Desktop/Games/1_GameSelecter/paths.txt";
    private String path3 = "C:/Users/gabri/Desktop/Games/1_GameSelecter/wish.txt";
    private ArrayList<String> games = new ArrayList<>();
    private ArrayList<String> wishes = new ArrayList<>();
    private ArrayList<String> paths = new ArrayList<>();
    private String currentLine;
    private String currentLine2;
    private String currentLine3;
    @FXML
    private Label title1;
    @FXML
    private ListView<String> list;
    @FXML
    private Button buttonrun;
    @FXML
    private Label title11;
    @FXML
    private Label title111;
    @FXML
    private ListView<String> wishlist;
    @FXML
    private Button buttondel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //game
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
        for (int i = 0; i < games.size(); i++) {
            list.getItems().add(list.getItems().size(), games.get(i));
        }
        //path
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
        //wishes
        BufferedReader br3 = null;
        FileReader fr3 = null;
        try {
            fr3 = new FileReader(path3);
            br3 = new BufferedReader(fr3);

            while ((currentLine3 = br3.readLine()) != null) {
                wishes.add(currentLine3);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br3 != null) {
                    br3.close();
                }
                if (fr3 != null) {
                    fr3.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        for (int i = 0; i < wishes.size(); i++) {
            wishlist.getItems().add(wishlist.getItems().size(), wishes.get(i));
        }
        /*for (int i = 0; i < paths.size(); i++) {
            System.out.println(paths.get(i));
        }*/
    }

    @FXML
    private void clickRun(ActionEvent event) throws IOException {
        //Process process = new ProcessBuilder(paths.get(0),"param1","param2").start();
        /*Runtime rt = Runtime.getRuntime();
        try {
            rt.exec(paths.get(0));
        } catch (Exception e) {
        }
         */
        int nr = games.indexOf(list.getSelectionModel().getSelectedItem());
        //run file
        Runtime.getRuntime().exec(new File(paths.get(nr).trim()).getCanonicalPath());
    }

    @FXML
    private void clickDelete(ActionEvent event) throws IOException {

        if (list.getSelectionModel().getSelectedIndex() > -1) {
            int nr = games.indexOf(list.getSelectionModel().getSelectedItem());
            games.remove(nr);
            paths.remove(nr);

            //games
            FileWriter fw = new FileWriter(path);
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < games.size(); i++) {
                pw.printf("%s" + "%n", games.get(i));
            }
            pw.close();
            //paths
            //path
            FileWriter fw2 = new FileWriter(path2);
            PrintWriter pw2 = new PrintWriter(fw2);
            for (int i = 0; i < paths.size(); i++) {
                pw2.printf("%s" + "%n", paths.get(i));
            }
            pw2.close();
            //liste
            list.getItems().clear();
            for (int i = 0; i < games.size(); i++) {
                list.getItems().add(list.getItems().size(), games.get(i));
            }
        }

        //wish
        if (wishlist.getSelectionModel().getSelectedIndex() > -1) {
            int nr2 = wishes.indexOf(wishlist.getSelectionModel().getSelectedItem());
            wishes.remove(nr2);
            FileWriter fw3 = new FileWriter(path3);
            PrintWriter pw3 = new PrintWriter(fw3);
            for (int i = 0; i < wishes.size(); i++) {
                pw3.printf("%s" + "%n", wishes.get(i));
            }
            pw3.close();
            wishlist.getItems().clear();
            for (int i = 0; i < wishes.size(); i++) {
                wishlist.getItems().add(wishlist.getItems().size(), wishes.get(i));
            }
        }

    }

}
