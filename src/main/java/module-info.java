module org.main.namelens {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires com.google.gson;

    opens org.main.namelens to javafx.fxml;
    exports org.main.namelens;
    exports org.main.namelens.backend;
//    opens org.main.namelens.backend to javafx.fxml;
    opens org.main.namelens.backend to javafx.fxml, com.google.gson;
}