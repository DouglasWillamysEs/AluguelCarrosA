module com.example.aluguelcarros {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.aluguelcarros to javafx.fxml;
    exports com.example.aluguelcarros;
    exports br.ufrpe.aluguelCarros.GUI;
    opens br.ufrpe.aluguelCarros.GUI to javafx.fxml;
}