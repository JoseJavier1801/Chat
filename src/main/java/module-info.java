module dev.IESFranciscodelosRios {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.bind;

    opens dev.IESFranciscodelosRios to javafx.fxml;
    exports dev.IESFranciscodelosRios;
    exports dev.IESFranciscodelosRios.Controller;
    opens dev.IESFranciscodelosRios.Controller to javafx.fxml;
    opens dev.IESFranciscodelosRios.Domain.Model to java.xml.bind;
}