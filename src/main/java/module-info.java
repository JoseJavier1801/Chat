module org.example {
    requires javafx.controls;
    requires javafx.fxml;

    opens dev.IESFranciscodelosRios to javafx.fxml;
    exports dev.IESFranciscodelosRios;
    exports dev.IESFranciscodelosRios.Controller;
    opens dev.IESFranciscodelosRios.Controller to javafx.fxml;
}
