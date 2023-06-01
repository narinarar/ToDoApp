module com.example.todoapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.example.todoapp to javafx.fxml;
    exports com.example.todoapp;
}