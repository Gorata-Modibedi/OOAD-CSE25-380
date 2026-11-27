package GUI;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class AccountView {

    private VBox root;

    private Label accountNumberLabel;
    private Label accountTypeLabel;
    private Label balanceLabel;
    private Label branchLabel;
    private Label openingDateLabel;

    public AccountView() {

        root = new VBox(15);

        Label title = new Label("ACCOUNT DETAILS");
        title.setStyle(
            "-fx-font-size: 22px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #A00000;"
        );

        accountNumberLabel = new Label("Account Number: ");
        accountTypeLabel = new Label("Account Type: ");
        balanceLabel = new Label("Account Balance: ");
        branchLabel = new Label("Branch: ");
        openingDateLabel = new Label("Opening Date: ");

        root.getChildren().addAll(
            title,
            accountNumberLabel,
            accountTypeLabel,
            balanceLabel,
            branchLabel,
            openingDateLabel
        );

        root.setPadding(new Insets(30));
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #F5F5F5;");
    }

    public VBox getRoot() {
        return root;
    }

    public void displayAccountDetails(
            String accountNumber,
            String accountType,
            double balance,
            String branch,
            String openingDate) {

        accountNumberLabel.setText(
            "Account Number: " + accountNumber
        );

        accountTypeLabel.setText(
            "Account Type: " + accountType
        );

        balanceLabel.setText(
            "Account Balance: BWP " + balance
        );

        branchLabel.setText(
            "Branch: " + branch
        );

        openingDateLabel.setText(
            "Opening Date: " + openingDate
        );
    }
}