import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class Menu {
    private Button btn_search = new Button();
    private Button btn_add = new Button();
    private Button btn_edit = new Button();
    private Button btn_translator = new Button();
    private VBox layout = new VBox();

    public Menu() {
        setLayout();
        layout.getChildren().addAll(btn_search, btn_add, btn_edit, btn_translator);
    }

    private void setLayout() {
        layout.setSpacing(0);
        layout.setLayoutX(0);
        layout.setLayoutY(100);
        layout.getStyleClass().add("root");
        setCSS();
        setBtn_search();
        setBtn_add();
        setBtn_translator();
        setBtn_edit();
    }

    private void setBtn_search() {
        btn_search.setText("Search");
        btn_search.getStyleClass().add("button");
    }

    private void setBtn_translator() {
        btn_translator.setText("Translate");
        btn_translator.getStyleClass().add("button");
    }

    private void setBtn_add() {
        btn_add.setText("Add new word");
        btn_add.getStyleClass().add("button");
    }

    private void setBtn_edit() {
        btn_edit.setText("Edit");
        btn_edit.getStyleClass().add("button");
    }

    public void addClassSelected(Button button) {
        deleteClassSelected();
        button.getStyleClass().add("btn-selected");
    }

    private void deleteClassSelected() {
        getBtn_add().getStyleClass().clear();
        getBtn_search().getStyleClass().clear();
        getBtn_edit().getStyleClass().clear();
        getBtn_translator().getStyleClass().clear();
        getBtn_search().getStyleClass().add("button");
        getBtn_add().getStyleClass().add("button");
        getBtn_edit().getStyleClass().add("button");
        getBtn_translator().getStyleClass().add("button");

    }


    private void setCSS() {
        layout.getStylesheets().add("css/Menu.css");
    }

    public VBox getLayout() {
        return this.layout;
    }

    public Button getBtn_add() {
        return btn_add;
    }

    public Button getBtn_search() {
        return btn_search;
    }

    public Button getBtn_translator() {
        return btn_translator;
    }

    public Button getBtn_edit() {
        return btn_edit;
    }
}
