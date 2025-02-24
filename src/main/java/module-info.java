module br.ufrpe.aluguelcarros {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens br.ufrpe.aluguelcarros to javafx.fxml;
    exports br.ufrpe.aluguelcarros;
    exports br.ufrpe.aluguelcarros.GUI;
    opens br.ufrpe.aluguelcarros.GUI to javafx.fxml;
}