package GUI;

import java.sql.SQLException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {

        try {
            BankingController controller = new BankingController();

            LoginView loginView = new LoginView();

            loginView.getLoginButton().setOnAction(event -> {

                try {
                    int customerId = Integer.parseInt(
                        loginView.getIdText().trim()
                    );

                    String password = loginView.getPasswordText();

                    boolean loggedIn = controller.loginCustomer(
                        customerId, password
                    );

                    if (loggedIn) {
                        loginView.showMessage("Login successful!");
                    } else {
                        loginView.showMessage(
                            "Invalid customer ID or password."
                        );
                    }

                } catch (NumberFormatException e) {
                    loginView.showMessage(
                        "Please enter a valid numeric Customer ID."
                    );
                }
            });

            stage.setScene(
                new Scene(loginView.getRoot(), 350, 300)
            );

            stage.setTitle("Banking System");
            stage.show();

        } catch (SQLException e) {
            System.out.println(
                "Could not connect to the database: " + e.getMessage()
            );
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
