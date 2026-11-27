package GUI;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class TransactionView {

    private VBox root;

    private TextField accountNumberField;
    private TextField amountField;
    private ComboBox<String> transactionTypeBox;
    private Button submitButton;
    private Label messageLabel;

    public TransactionView() {

        root = new VBox(15);

        Label title = new Label("BANK TRANSACTIONS");
        title.setStyle(
            "-fx-font-size: 22px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #A00000;"
        );

        accountNumberField = new TextField();
        accountNumberField.setPromptText("Account Number");
        accountNumberField.setMaxWidth(250);

        transactionTypeBox = new ComboBox<>();
        transactionTypeBox.getItems().addAll(
            "Deposit",
            "Withdrawal"
        );
        transactionTypeBox.setPromptText("Select Transaction Type");
        transactionTypeBox.setMaxWidth(250);

        amountField = new TextField();
        amountField.setPromptText("Enter Amount (BWP)");
        amountField.setMaxWidth(250);

        submitButton = new Button("Submit Transaction");

        messageLabel = new Label();

        root.getChildren().addAll(
            title,
            accountNumberField,
            transactionTypeBox,
            amountField,
            submitButton,
            messageLabel
        );

        root.setPadding(new Insets(30));
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #F5F5F5;");
    }

    public VBox getRoot() {
        return root;
    }

    public String getAccountNumber() {
        return accountNumberField.getText();
    }

    public String getTransactionType() {
        return transactionTypeBox.getValue();
    }

    public String getAmount() {
        return amountField.getText();
    }

    public Button getSubmitButton() {
        return submitButton;
    }

    public void showMessage(String message) {
        messageLabel.setText(message);
    }
}
