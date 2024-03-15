module com.arcane.arithmetic.arcane_arithmetic {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.arcane.arithmetic to javafx.fxml;
    exports com.arcane.arithmetic;
}