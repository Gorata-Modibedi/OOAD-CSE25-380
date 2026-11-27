package GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class DashboardView {

    private VBox root = new VBox(20);

    public DashboardView(int customerId) {

        Label heading = new Label("ABSA BANK");
        heading.setStyle(
            "-fx-font-size: 26px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #A00000;"
        );

        Label welcome = new Label(
            "Welcome, Customer " + customerId
        );
        welcome.setStyle("-fx-font-size: 18px;");

        Button accountButton = new Button("My Account");
        Button depositButton = new Button("Deposit");
        Button withdrawButton = new Button("Withdraw");
        Button historyButton = new Button("Transaction History");
        Button logoutButton = new Button("Logout");

        accountButton.setMaxWidth(250);
        depositButton.setMaxWidth(250);
        withdrawButton.setMaxWidth(250);
        historyButton.setMaxWidth(250);
        logoutButton.setMaxWidth(250);

        root.getChildren().addAll(
            heading,
            welcome,
            accountButton,
            depositButton,
            withdrawButton,
            historyButton,
            logoutButton
        );

        root.setPadding(new Insets(35));
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #F5F5F5;");
    }

    public VBox getRoot() {
        return root;
    }
}
