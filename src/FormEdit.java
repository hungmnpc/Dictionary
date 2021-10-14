import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class FormEdit {
    private Button buttonEdit =  new Button();
    private Button buttonDelete = new Button();
    private HBox layout = new HBox();
    private VBox layout_btn = new VBox();
    private VBox infoWord = new VBox();
    private String word;



    public FormEdit(Word word) {
        setItem(word);
        setLayout();
    }

    private void setLayout() {
        setButton();
        layout_btn.getChildren().addAll(buttonDelete, buttonEdit);
        layout_btn.setSpacing(20);
        layout.getChildren().addAll(infoWord, layout_btn);
        layout.setLayoutX(400);
        layout.setLayoutY(250);
        layout_btn.setStyle("-fx-background-color: #EDEDED");
    }

    private void setButton() {
        buttonDelete.setText("Delete");
        buttonEdit.setText("Edit");
        buttonEdit.getStylesheets().add("css/Button.css");
        buttonDelete.getStylesheets().add("css/Button.css");
        buttonDelete.setStyle("-fx-background-radius:0;" + "-fx-max-width: 120px;" + "-fx-font-size: 20px");
        buttonEdit.setStyle("-fx-background-radius:0;" + "-fx-min-width: 120px;" + "-fx-font-size: 20px");

    }

    private void setItem(Word word) {
        this.word = word.getWord_target();
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

    public HBox getLayout() {
        return layout;
    }

    public String getWord() {
        return word;
    }
}
