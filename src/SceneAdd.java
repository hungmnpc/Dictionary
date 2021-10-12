import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

import java.io.IOException;
import java.util.Optional;

public class SceneAdd {

    private final Scene scene_add;
    private final GridPane layout;
    private final Label word = new Label("New word");
    private final Label word_explain = new Label("Explain");
    private final Label pronunciation = new Label("Pronunciation");
    private  TextField input_new_word = new TextField();
    private  TextField input_word_explain = new TextField();
    private  TextField input_pronunciation = new TextField();
    private Button button = new Button();
    private final Group root1 = new Group();
    private AlertAdd alertAdd = new AlertAdd();

    public SceneAdd(Dictionary dictionary) {
        this.layout = new GridPane();
        this.scene_add = new Scene(root1, 1200, 800, Color.web("#3DB2FF", 1));
        setLayout();

        layout.setVgap(50);
        layout.setHgap(20);
        layout.getChildren().addAll(word_explain,
                word,
                pronunciation,
                input_word_explain,
                input_new_word,
                input_pronunciation,
                button);
        root1.getChildren().addAll(layout, new Border().getBorder());
        scene_add.getStylesheets().add("css/Add.css");
        eventHandler();
        addNewWord(dictionary);

    }

    public void addMenu(Menu menu) {
        root1.getChildren().add(menu.getLayout());
    }

    private void setLayoutGrid() {
        this.layout.setLayoutX(400);
        this.layout.setLayoutY(100);
        GridPane.setConstraints(input_new_word, 1, 0);
        GridPane.setConstraints(input_word_explain, 1, 1);
        GridPane.setConstraints(input_pronunciation, 1, 2);
        GridPane.setConstraints(word, 0, 0);
        GridPane.setConstraints(word_explain, 0, 1);
        GridPane.setConstraints(pronunciation, 0, 2);
        GridPane.setConstraints(button,1, 3);

    }

    private void setCssLabel() {
        word.getStyleClass().add("label1");
        word_explain.getStyleClass().add("label1");
        pronunciation.getStyleClass().add("label1");
        word_explain.setOnMouseClicked(event -> {
            input_word_explain.setFocusTraversable(true);
        });
        word.setOnMouseClicked(event -> {
            input_new_word.setFocusTraversable(true);
        });
        pronunciation.setOnMouseClicked(event -> {
            input_pronunciation.setFocusTraversable(true);
        });
    }

    private void setCssInput() {
        input_new_word.getStyleClass().add("input");
        input_word_explain.getStyleClass().add("input");
        input_pronunciation.getStyleClass().add("input");
        input_new_word.setPromptText("New word...");
        input_word_explain.setPromptText("Explain...");
        input_pronunciation.setPromptText("Pronunciation...");
        input_word_explain.setFocusTraversable(false);
        input_new_word.setFocusTraversable(false);
        input_pronunciation.setFocusTraversable(false);

    }

    private void setEmptyInput() {
        input_new_word.setText(null);
        input_pronunciation.setText(null);
        input_word_explain.setText(null);
    }

    private void setBtn_confirm() {
        button.setText("Add");
        button.getStyleClass().add("button");
        button.getStylesheets().add("css/Button.css");
        button.setDisable(false);

    }

    private void setLayout() {
        setCssInput();
        setCssLabel();
        setBtn_confirm();
        setLayoutGrid();
    }

    private void eventHandler() {

            input_new_word.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ENTER) {
                    if (!input_new_word.getText().isEmpty()) {
                        input_word_explain.requestFocus();
                    }
                }
            });


            input_word_explain.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ENTER) {
                    if (!input_word_explain.getText().isEmpty()) {
                        input_pronunciation.requestFocus();
                    }
                }
            });


    }

    private void addNewWord(Dictionary dictionary) {
        this.button.setOnAction(event -> {
            if (!input_new_word.getText().isEmpty()) {
                if (!input_word_explain.getText().isEmpty()) {
                    if (!input_pronunciation.getText().isEmpty()) {
                        Alert alert = alertAdd.getAlert_confirm();
                        Alert alert1 = alertAdd.getAlert_information();
                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.get().getButtonData() == ButtonBar.ButtonData.OK_DONE) {
                            try {
                                dictionary.insertNewWord(input_new_word.getText(),  input_pronunciation.getText()
                                        , input_word_explain.getText());

                                alert1.setContentText("Add successfully!");
                                setEmptyInput();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            alert1.setContentText("Add fail!");
                            System.out.println("không thành công");
                        }
                        alert1.show();

                    }
                }
            }
        });
    }


    public Scene getScene() {
        return this.scene_add;
    }
}
