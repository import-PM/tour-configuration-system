module org.importpm {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires transitive javafx.graphics;

    opens org.importpm to javafx.fxml;
    opens org.importpm.controllers to javafx.fxml;
    exports org.importpm;
    exports org.importpm.controllers.enums;
    
}
