module com.example.grafikrechner_t22 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.example.grafikrechner_t22 to javafx.fxml;
    exports com.example.grafikrechner_t22;
}