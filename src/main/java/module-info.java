module org.main.namelens {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens org.main.namelens to javafx.fxml;
    exports org.main.namelens;
}