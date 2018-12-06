package com.asrori;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        //buat text
        Text tulisan = new Text("hello javafx");

        //buat vBox
        VBox mainvBox = new VBox();

        //tambahkan text ke vbox
        mainvBox.getChildren().add(tulisan);

        //mengatur ukuran vbox
        mainvBox.setMinSize(350, 250);


        Scene scene = new Scene(mainvBox);

        //atur stage
        primaryStage.setX(100);
        primaryStage.setY(200);
        primaryStage.setMinHeight(300);
        primaryStage.setMinWidth(400);

        primaryStage.setScene(scene);

        primaryStage.setTitle("program pertama javaFX");

        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
