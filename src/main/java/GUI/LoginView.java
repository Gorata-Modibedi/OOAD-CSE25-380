package GUI;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class LoginView {

    private VBox root = new VBox(15);
    private TextField idField = new TextField();
    private PasswordField passwordField = new PasswordField();
    private Button loginButton = new Button("LOGIN");
    private Label messageLabel = new Label();

    public LoginView() {

        Label bankName = new Label("ABSA BANK");
        bankName.setStyle(
            "-fx-font-size: 26px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #A00000;"
        );

        Label subtitle = new Label("Welcome to Online Banking");
        subtitle.setStyle("-fx-font-size: 14px;");

        idField.setPromptText("Customer ID");
        idField.setMaxWidth(250);

        passwordField.setPromptText("Password");
        passwordField.setMaxWidth(250);

        loginButton.setMaxWidth(250);
        loginButton.setStyle(
            "-fx-background-color: #A00000;" +
            "-fx-text-fill: white;" +
            "-fx-font-weight: bold;" +
            "-fx-padding: 10 20 10 20;"
        );

        messageLabel.setStyle("-fx-text-fill: red;");

        root.getChildren().addAll(
            bankName,
            subtitle,
            idField,
            passwordField,
            loginButton,
            messageLabel
        );

        root.setPadding(new Insets(35));
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #F5F5F5;");
    }

    public VBox getRoot() {
        return root;
    }

    public String getIdText() {
        return idField.getText();
    }

    public String getPasswordText() {
        return passwordField.getText();
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public void showMessage(String message) {
        messageLabel.setText(message);
    }
}
