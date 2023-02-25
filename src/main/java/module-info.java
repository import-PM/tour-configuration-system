module org.importpm {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens org.importpm to javafx.fxml;
    exports org.importpm;
}
