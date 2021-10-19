import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;

public class FormEdit {
    private final Button buttonEdit =  new Button();
    private final Button buttonDelete = new Button();
    private final HBox layout = new HBox();
    private final VBox layout_btn = new VBox();
    private VBox infoWord = new VBox();
    private final Label noWord = new Label();
    public LayoutEdit layoutEdit;
    private final ScrollPane scroller = new ScrollPane();
    private final Button buttonCancel = new Button();
    private final Button buttonNext = new Button();
    private final Button buttonPrevious = new Button();
    private final ArrayList<Word> list;
    private Word word;
    private int index = 0;

    public FormEdit(ArrayList<Word> list) {
        this.list = list;
        word = list.get(index);
        setItem();
        setLayout();
        layoutEdit = new LayoutEdit(word);
    }

    private void setLayout() {
        setButton();
        layout_btn.getChildren().addAll(buttonDelete, buttonEdit, buttonCancel, buttonPrevious , buttonNext);
        layout_btn.setSpacing(20);
        layout.getChildren().addAll(scroller, layout_btn);
        scroller.setContent(infoWord);
        scroller.setPrefSize(800, 300);
        layout.setLayoutX(400);
        layout.setLayoutY(250);
        layout_btn.setStyle("-fx-background-color: #EDEDED");
    }

    private void setButton() {
        buttonDelete.setText("Delete");
        buttonCancel.setText("Cancel");
        buttonEdit.setText("Edit");
        buttonNext.setText("Next");
        buttonPrevious.setText("Previous");
        buttonEdit.getStylesheets().add("css/Button.css");
        buttonDelete.getStylesheets().add("css/Button.css");
        buttonCancel.getStylesheets().add("css/Button.css");
        buttonNext.getStylesheets().add("css/Button.css");
        buttonPrevious.getStylesheets().add("css/Button.css");
        buttonDelete.setStyle("-fx-background-radius:0;" + "-fx-max-width: 120px;" + "-fx-font-size: 20px");
        buttonEdit.setStyle("-fx-background-radius:0;" + "-fx-min-width: 120px;" + "-fx-font-size: 20px");
        buttonCancel.setStyle("-fx-background-radius:0;" + "-fx-min-width: 120px;" + "-fx-font-size: 20px");
        buttonNext.setStyle("-fx-background-radius:0;" + "-fx-min-width: 120px;" + "-fx-font-size: 20px");
        buttonPrevious.setStyle("-fx-background-radius:0;" + "-fx-min-width: 120px;" + "-fx-font-size: 20px");
    }

    private void setItem() {
        VBox newItem = new VBox();
        Text word_target = new Text(word.getWord_target());
        word_target.getStyleClass().add("text-target");
        word_target.setFill(javafx.scene.paint.Color.web("#3D0000", 1));

        word_target.setTextAlignment(TextAlignment.CENTER);
        Image icon = new Image("file:src/image/iconspeaker.png");
        final ImageView selectedImage = new ImageView();
        HBox pronounce = new HBox();
        pronounce.setSpacing(10);

        Text word_explain = new Text(word.getWord_explain());
        selectedImage.setImage(icon);
        word_explain.setWrappingWidth(780);
        Text word_pronounce = new Text(word.getWord_pronounce());
        pronounce.getChildren().addAll(selectedImage, word_pronounce);
        newItem.getChildren().addAll(word_target, pronounce, word_explain);
        word_pronounce.getStyleClass().add("text-pronounce");
        word_pronounce.setFill(Color.web("#E02401", 1));

        newItem.getStylesheets().add("css/Form.css");
        newItem.getStyleClass().add("root");
        newItem.setMinWidth(600);
        newItem.setSpacing(5);
        newItem.setStyle("-fx-background-color: #EDEDED;" +
                "-fx-border-width: 0px;");

        this.infoWord = newItem;
    }

    public Button getButtonDelete() {
        return buttonDelete;
    }

    public Button getButtonEdit() {
        return buttonEdit;
    }

    public Button getButtonCancel() {
        return buttonCancel;
    }

    public HBox getLayout() {
        return layout;
    }

    public Label getNoWord() {
        return noWord;
    }

    public GridPane getLayoutEdit() {
        return layoutEdit.getLayoutEdit();
    }

    public void nextAction() {
        if (index < list.size() - 1) {
            index++;
            word = list.get(index);
            setItem();
            scroller.setContent(null);
            scroller.setContent(infoWord);
            layoutEdit.nextWord(word);
        }
    }

    public void previousAction() {
        if (index > 0) {
            index--;
            word = list.get(index);
            setItem();
            scroller.setContent(null);
            scroller.setContent(infoWord);
            layoutEdit.nextWord(word);
        }
    }

    public Button getButtonNext() {
        return buttonNext;
    }

    public Button getButtonPrevious() {
        return buttonPrevious;
    }

    public Word getWord() {
        return word;
    }
}
