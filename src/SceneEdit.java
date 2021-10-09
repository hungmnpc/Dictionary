import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class SceneEdit {

    private final TextField input = new TextField();
    private final Button btn_1 = new Button();
    private final Label heading = new Label("Type the word you want to edit");
    private final Scene scene;
    private final Group root = new Group();
    private final Group layout = new Group();

    public SceneEdit() {
        scene = new Scene(root, 1200, 800, Color.web("3DB2FF", 1));
        setLayout();
        root.getChildren().addAll(layout, new Border().getBorder());
        root.getStylesheets().add("css/Edit.css");
    }

    private void setLayout() {
        layout.getChildren().addAll(input, btn_1, heading);
        layout.setLayoutX(400);
        setInput();
        setBtn_1();
        setHeading();

    }

    private void setInput() {
        input.setPromptText("Word...");
        input.getStyleClass().add("input");
        input.getStylesheets().add("css/Input.css");
        input.setLayoutY(150);
        input.setFocusTraversable(false);
    }

    private void setBtn_1() {
        btn_1.getStyleClass().add("button");
        btn_1.getStylesheets().add("css/Button.css");
        btn_1.setText("Search");
        btn_1.setLayoutY(150);
        btn_1.setLayoutX(610);
    }

    public void setHeading() {
        heading.setLayoutY(100);
        heading.getStyleClass().add("heading");
    }

    public Scene getScene() {
        return this.scene;
    }

    public void addMenu(Menu menu) {
        root.getChildren().add(menu.getLayout());
    }


}
