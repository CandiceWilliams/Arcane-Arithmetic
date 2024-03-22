module com.arcane.arithmetic {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires org.controlsfx.controls;

    opens com.arcane.arithmetic to javafx.fxml;
    exports com.arcane.arithmetic;
}