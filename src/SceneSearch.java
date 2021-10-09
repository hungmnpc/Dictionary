import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class SceneSearch {
    private final Scene scene_search;
    private final Group root;
    private TextField input_search;
    private Button btn_search;
    private String word_search;
    private Group layout;

    public SceneSearch() {
        this.root = new Group();
        this.layout = new Group();
        scene_search = new Scene(root, 1200, 800, Color.web("#3DB2FF", 1));
        this.word_search = "";
        setLayout();
        layout.getChildren().addAll(this.getInput_search(), this.getBtn_search());
        root.getChildren().addAll(layout, new Border().getBorder());
        layout.getStyleClass().add("layout");

        clickBtnHandler();

        getSearchWordByKey();

        this.scene_search.getStylesheets().add("css/Search.css");
    }

    public void addMenu(Menu menu) {
        root.getChildren().add(menu.getLayout());
    }

    private void setLayout() {
        setBtn_search();
        setInput_search();
        layout.setLayoutX(400);
    }

    private void setInput_search() {
        input_search = new TextField();
        input_search.setPromptText("Search here");
        input_search.setFocusTraversable(false);
        input_search.setMinWidth(600);
        input_search.setMinHeight(50);
        input_search.setFont(Font.font(30));
        input_search.setLayoutX(0);
        input_search.setLayoutY(100);
        input_search.getStyleClass().add("input");
    }

    private void setBtn_search() {
        btn_search = new Button();
        btn_search.setMinWidth(150);
        btn_search.setMinHeight(50);
        btn_search.setLayoutX(610);
        btn_search.setLayoutY(100);
        btn_search.setText("Search");
        btn_search.getStyleClass().add("button_search");
        btn_search.getStylesheets().add("css/Button.css");
    }

    private void deleteSearch() {

        Button delete = new Button("delete");

        if (input_search.isFocusTraversable()) {
            root.getChildren().add(delete);
            delete.setOnAction(event -> {
                input_search.setText("");
            });
            System.out.println("ok");
        }
    }

    private void clickBtnHandler() {
        this.btn_search.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!input_search.getText().isEmpty()){
                    word_search = input_search.getText();
                    System.out.println(input_search.getText());
                }
            }
        });
    }

    private void getSearchWordByKey() {
        input_search.setOnKeyReleased( event -> {
            if (event.getCode() == KeyCode.ENTER){
                btn_search.requestFocus();
                if (!input_search.getText().isEmpty()) {
                    word_search = input_search.getText();
                    System.out.println(word_search);
                }

            }
        });

    }

    private Button getBtn_search() {
        return this.btn_search;
    }

    public String getWord_search() {
        return this.word_search;
    }

    private TextField getInput_search() {
        return this.input_search;
    }


    public Scene getScene() {
        return this.scene_search;
    }

    public Group getGroup() {
        return this.root;
    }
}
