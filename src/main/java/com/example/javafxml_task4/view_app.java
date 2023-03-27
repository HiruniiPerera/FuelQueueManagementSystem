//Student name: Hiruni Perera Student ID: w1898953
package com.example.javafxml_task4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class view_app extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(view_app.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("View Queues");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }



}
