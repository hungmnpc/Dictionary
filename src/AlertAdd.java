import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class AlertAdd {
    private Alert alert_confirm = new Alert(AlertType.CONFIRMATION);
    private Alert alert_information = new Alert(AlertType.INFORMATION);
    private String alert_heading;

    public AlertAdd() {
        setAlert_confirm();
    }

    private void setAlert_confirm() {
        alert_confirm.setTitle("Confirmation");
        alert_confirm.setHeaderText("Confirm add this word");
    }

    public Alert getAlert_confirm() {
        return this.alert_confirm;
    }

}
