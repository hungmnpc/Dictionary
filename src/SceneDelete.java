import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class SceneDelete {
    private final Scene scene_delete;
    private final Label heading = new Label("Type the word you want to delete");
    private final Group root;
    private final Group layout;
    private final TextField input_word = new TextField();
    private final Button btn_confirmdelete =  new Button("Delete");

    public SceneDelete() {
        this.root = new Group();
        this.layout = new Group();
        this.scene_delete = new Scene(root, 1200, 800, Color.web("3DB2FF", 1));
        layout.getChildren().addAll(heading, input_word, btn_confirmdelete);
            root.getChildren().addAll(layout, new Border().getBorder());

        setLayout();
        root.getStylesheets().add("css/Delete.css");
    }

    public void addMenu(Menu menu) {
        root.getChildren().add(menu.getLayout());
    }

    private void setLayout() {
        this.layout.setLayoutX(400);
        setInput_word();
        setHeading();
        setBtn();

    }

    private void setInput_word() {
        input_word.getStyleClass().add("input");
        input_word.setLayoutX(0);
        input_word.setLayoutY(150);
        input_word.setFocusTraversable(false);
        input_word.setPromptText("Word...");
    }

    private void setHeading() {
        heading.getStyleClass().add("heading");
        heading.setLayoutX(0);
        heading.setLayoutY(100);
    }

    private void setBtn() {
        btn_confirmdelete.getStyleClass().add("button");
        btn_confirmdelete.getStylesheets().add("css/Button.css");
        btn_confirmdelete.setLayoutX(610);
        btn_confirmdelete.setLayoutY(150);
    }

    public Scene getScene() {
        return this.scene_delete;
    }
}
