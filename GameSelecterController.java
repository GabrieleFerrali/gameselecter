/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameselecter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import library.LibraryController;

/**
 *
 * @author gabri
 */
public class GameSelecterController implements Initializable {

    private Image imageOk = new Image(getClass().getResourceAsStream("/gameselecter/info_1.PNG"));
    private double x;
    private double y;
    private Label label;
    @FXML
    private Button buttonlib;
    @FXML
    private Button buttonran;
    @FXML
    private Button buttonins;
    @FXML
    private Button buttonqui;
    @FXML
    private ImageView image;
    @FXML
    private Label title1;
    @FXML
    private Button buttonhelp = new Button();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        /*Image image1 = new Image("/gameselecter/logo.PNG");
        image.setImage(image1);
        double x = image.getLayoutX();
        double y = image.getLayoutY();
        //bounce();
         */
        buttonhelp.setGraphic(new ImageView(imageOk));
    }

    @FXML
    private void clickLibrary(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/library/Library.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.getIcons().add(new Image("/gameselecter/icon.PNG"));
        stage.setTitle("Library");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void clickRandom(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/random/Random.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.getIcons().add(new Image("/gameselecter/icon.PNG"));
        stage.setTitle("Random");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void clickInsert(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/insert/Insert.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.getIcons().add(new Image("/gameselecter/icon.PNG"));
        stage.setTitle("Insert");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void clickQuit(ActionEvent event) {
        System.exit(0);
    }

    /*public void bounce() {
        do {
            x++;
            y++;
            image.setLayoutX(x);
            image.setLayoutY(y);
        } while (image.getLayoutX() < this.x);
    }
     */
    @FXML
    private void clickHelp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/info/Info.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.getIcons().add(new Image("/gameselecter/icon.PNG"));
        stage.setTitle("Info");
        stage.setScene(scene);
        stage.show();
    }
}
