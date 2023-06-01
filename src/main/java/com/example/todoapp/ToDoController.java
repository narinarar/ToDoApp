package com.example.todoapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import Model.Model;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

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
    private Button deleteButton;
    @FXML
    private ListView<Model> taskListView;

    ObservableList<Model> dataModel = FXCollections.observableArrayList();
    @FXML
    private void butonCalisanKod() {
         var newTask = new Model(datePicker.getValue(), explainTextField.getText());

         dataModel.add(newTask);
         taskListView.setItems(dataModel);
    }

    @FXML
    private void deleteButton(ActionEvent e) {
        dataModel.remove(taskListView.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void textFieldEnter(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER) {
            butonCalisanKod();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        datePicker.setValue(LocalDate.now());
    }
}


