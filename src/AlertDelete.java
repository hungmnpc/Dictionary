import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

public class AlertDelete {
    private Alert alert_confirm = new Alert(Alert.AlertType.CONFIRMATION);
    private Alert alert_information = new Alert(Alert.AlertType.INFORMATION);

    public AlertDelete() {
        setAlert_confirm();
        setAlert_information();
    }

    private void setAlert_confirm() {
        alert_confirm.setTitle("Confirmation");
        alert_confirm.setHeaderText("Confirm delete this word");
        alert_confirm.getButtonTypes().clear();
        ButtonType buttonTypeConfirm = new ButtonType("Delete", ButtonBar.ButtonData.OK_DONE);
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert_confirm.getButtonTypes().addAll(buttonTypeConfirm, buttonTypeCancel);
    }

    private void setAlert_information() {
        alert_information.setTitle("Information");
        alert_information.setHeaderText("Notification");
    }

    public Alert getAlert_confirm() {
        return this.alert_confirm;
    }

    public Alert getAlert_information() {
        return this.alert_information;
    }



}
