import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.util.Locale;

public class LayoutEdit {
    private final Label wordTarget = new Label("Word");
    private final Label pronunciation = new Label("Pronunciation");
    private final Label wordExplain = new Label("Explain");
    private final TextField tfword = new TextField();
    private final TextField tfpronunciation = new TextField();
    private final TextArea tawordExplain = new TextArea();
    private final Button buttonConfirm = new Button("Change");
    private final Button buttonCancel = new Button("Cancel");
    private final GridPane layoutEdit = new GridPane();
    private Word changeWord = new Word();
    private Word currentWord = new Word();

    public LayoutEdit(Word word) {
        this.currentWord = word;
        setLayout(word);
        setChangeAction();
    }

    private void setChangeAction() {
        tfword.textProperty().addListener(((observable, oldValue, newValue) -> {
            if (!newValue.equals(currentWord.getWord())) {
                buttonConfirm.setDisable(false);
            }
        }));
        tfpronunciation.textProperty().addListener(((observable, oldValue, newValue) -> {
            if (!newValue.equals(currentWord.getWord_pronounce())) {
                buttonConfirm.setDisable(false);
            }
        }));
        tawordExplain.textProperty().addListener(((observable, oldValue, newValue) -> {
            if (!newValue.equals(currentWord.getWord_explain())) {
                buttonConfirm.setDisable(false);
            }
        }));
    }

    private void setLayout(Word word) {
        GridPane.setConstraints(wordTarget, 0, 0);
        GridPane.setConstraints(tfword, 1, 0);
        GridPane.setConstraints(pronunciation, 0, 1);
        GridPane.setConstraints(tfpronunciation, 1, 1);
        GridPane.setConstraints(wordExplain, 0, 2);
        GridPane.setConstraints(tawordExplain, 1, 2);
        GridPane.setConstraints(buttonConfirm, 2, 0);
        GridPane.setConstraints(buttonCancel, 2, 1);
        buttonConfirm.setDisable(true);
        layoutEdit.setHgap(10);
        layoutEdit.setVgap(10);
        layoutEdit.getChildren().addAll(wordExplain, tawordExplain, pronunciation, tfpronunciation, wordTarget, tfword, buttonConfirm,  buttonCancel);
        tfpronunciation.setText(word.getWord_pronounce());
        tfpronunciation.setFont(Font.font(20));
        tfword.setText(word.getWord_target());
        tfword.setFont(Font.font(20));
        tawordExplain.setText(word.getWord_explain());
        tawordExplain.setMaxHeight(120);
        tawordExplain.setWrapText(true);
        tawordExplain.setFont(Font.font(20));
        layoutEdit.setLayoutX(400);
        layoutEdit.setLayoutY(560);
    }

    public GridPane getLayoutEdit() {
        return layoutEdit;
    }

    public Button getButtonCancel() {
        return buttonCancel;
    }

    public Button getButtonConfirm() {
        return buttonConfirm;
    }
    public void getChange() {
        changeWord.setWord_target(tfword.getText());
        if (tfpronunciation.getText().charAt(0) != '/') {
            tfpronunciation.setText("/" + tfpronunciation.getText());
        }
        if (tfpronunciation.getText().charAt(tfpronunciation.getText().length() - 1) != '/') {
            tfpronunciation.setText(tfpronunciation.getText() + "/");
        }
        changeWord.setWord_pronounce(tfpronunciation.getText());
        changeWord.setWord_explain(tawordExplain.getText());
    }

    public Word getChangeWord() {
        return changeWord;
    }
}

