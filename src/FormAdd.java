import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class FormAdd {
    private final GridPane layout = new GridPane();
    private final Label word = new Label("New word");
    private final Label word_explain = new Label("Explain");
    private final Label pronunciation = new Label("Pronunciation");
    private TextField input_new_word = new TextField();
    private  TextField input_word_explain = new TextField();
    private  TextField input_pronunciation = new TextField();
    private Button button = new Button();

    public FormAdd() {
        setLayout();
        eventHandler();
    }

    private void setLayout() {
        setCssInput();
        setCssLabel();
        setBtn_confirm();
        setLayoutGrid();
    }

    private void setLayoutGrid() {
        this.layout.setLayoutX(400);
        this.layout.setLayoutY(100);
        GridPane.setConstraints(input_new_word, 1, 0);
        GridPane.setConstraints(input_word_explain, 1, 2);
        GridPane.setConstraints(input_pronunciation, 1, 1);
        GridPane.setConstraints(word, 0, 0);
        GridPane.setConstraints(word_explain, 0, 2);
        GridPane.setConstraints(pronunciation, 0, 1);
        GridPane.setConstraints(button,1, 3);
        layout.getChildren().addAll(word_explain,
                word,
                pronunciation,
                input_word_explain,
                input_new_word,
                input_pronunciation,
                button);
        layout.setVgap(50);
        layout.setHgap(20);
        layout.getStylesheets().add("css/Add.css");

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

    private void eventHandler() {

        input_new_word.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                if (!input_new_word.getText().isEmpty()) {
                    input_pronunciation.requestFocus();
                    try {
                        input_word_explain.setText(Translator.translate(input_new_word.getText()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        input_pronunciation.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                if (!input_pronunciation.getText().isEmpty()) {
                    input_word_explain.requestFocus();
                }
            }
        });


    }

    public void autoConvertPronun() {
        if (!input_pronunciation.getText().isEmpty()) {
            if (input_pronunciation.getText().charAt(0) != '/' ) {

                input_pronunciation.setText('/' + input_pronunciation.getText());
                System.out.println(input_pronunciation.getText());
            }
            if (input_pronunciation.getText().charAt(input_pronunciation.getText().length() - 1) != '/') {
                input_pronunciation.setText(input_pronunciation.getText() + '/');
                System.out.println(input_pronunciation.getText());
            }
        }
    }

    public void setEmptyInput() {
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

    public GridPane getLayout() {
        return layout;
    }

    public Button getButton() {
        return button;
    }

    public TextField getInput_new_word() {
        return input_new_word;
    }

    public TextField getInput_pronunciation() {
        return input_pronunciation;
    }

    public TextField getInput_word_explain() {
        return input_word_explain;
    }
}
