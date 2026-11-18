import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

// A View only SHOWS things and COLLECTS input. It makes no decisions.
public class LoginView {
    private VBox root = new VBox(10);   // a column with 10px between items
    private TextField idField = new TextField();
    private PasswordField passwordField = new PasswordField();
    private Button loginButton = new Button("Login");
    private Label messageLabel = new Label();

    public LoginView() {
        Label title = new Label("Absa Bank - Login");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        idField.setPromptText("Customer ID");
        passwordField.setPromptText("Password");

        root.getChildren().addAll(title, idField, passwordField, loginButton, messageLabel);
        root.setPadding(new Insets(30));
        root.setAlignment(Pos.CENTER);
    }

    public VBox getRoot() { return root; }
    public String getIdText() { return idField.getText(); }
    public String getPasswordText() { return passwordField.getText(); }
    public Button getLoginButton() { return loginButton; }
    public void showMessage(String message) { messageLabel.setText(message); }
}