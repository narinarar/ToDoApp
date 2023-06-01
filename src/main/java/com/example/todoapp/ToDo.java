package com.example.todoapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ToDo extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        SplitPane root = (SplitPane)FXMLLoader.load(getClass().getResource("ToDo-view.fxml"));
        //FXMLLoader fxmlLoader = new FXMLLoader(ToDo.class.getResource("ToDo-view.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("To Do!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}