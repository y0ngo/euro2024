module com.example.euros_new {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.euros_new to javafx.fxml;
    exports com.example.euros_new;
}