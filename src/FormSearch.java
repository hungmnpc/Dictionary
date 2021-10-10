
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.control.ScrollPane;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.text.TextAlignment;

public class FormSearch {
    private VBox layout = new VBox();
    private ArrayList<VBox> item =  new ArrayList<>();
    private ScrollPane scroller;

    public FormSearch(ArrayList<Word> list) {

        scroller = new ScrollPane();
        layout.getChildren().add(scroller);
        setItems(list);
        setLayout();
        VBox.setVgrow(scroller, Priority.ALWAYS);
        scroller.setPrefSize(800, 600);
        scroller.setContent(layout);
        scroller.setPannable(true);
        scroller.setStyle("-fx-background: #3DB2FF;" +
                "-fx-border-color: #3DB2FF;");
        scroller.setFitToWidth(true);
    }

    private void setLayout() {
        layout.getChildren().addAll(item);
        layout.setMinWidth(700);
        layout.setMinHeight(600);
        scroller.setLayoutX(400);
        scroller.setLayoutY(170);

    }

    private void setRoot() {

    }

    public static VBox setItem(Word word) {
        VBox newItem = new VBox();
        newItem.setLayoutX(400);
        newItem.setLayoutY(200);
        Text word_target = new Text(word.getWord_target());
        word_target.getStyleClass().add("text-target");
        word_target.setFill(Color.web("#3D0000", 1));

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
        return newItem;
    }

    private void setItems(ArrayList<Word> list) {
        for (Word word: list) {
            VBox newItem = setItem(word);
            this.item.add(newItem);
        }
    }

    public ScrollPane getLayout() {
        return this.scroller;
    }
}
