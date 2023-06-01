package com.example.todoapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import Model.Model;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;


public class ToDoController implements Initializable {

    @FXML
    private Button addTaskButton;
    @FXML
    private TextField explainTextField;
    @FXML
    DatePicker datePicker;
    @FXML
    private ListView<Model> taskListView;

    ObservableList<Model> dataModel = FXCollections.observableArrayList();
    @FXML
    private void butonCalisanKod(ActionEvent e) {
         var newTask = new Model(datePicker.getValue(), explainTextField.getText());

         dataModel.add(newTask);
         taskListView.setItems(dataModel);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        datePicker.setValue(LocalDate.now());
    }
}


