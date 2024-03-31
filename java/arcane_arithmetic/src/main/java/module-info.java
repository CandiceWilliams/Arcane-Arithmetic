module com.arcane.arithmetic {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    
    requires com.almasb.fxgl.all;
    requires org.controlsfx.controls;
	requires com.fasterxml.jackson.databind;
    requires java.desktop;

    opens com.arcane.arithmetic to javafx.fxml;
    exports com.arcane.arithmetic;
}