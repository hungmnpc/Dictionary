import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import java.io.IOException;
import java.util.Optional;
public class SceneAdd {

    private final Scene scene_add;
    private final Group root1 = new Group();
    private AlertAdd alertAdd = new AlertAdd();
    private FormAdd formAdd = new FormAdd();

    public SceneAdd(Dictionary dictionary) {
        this.scene_add = new Scene(root1, 1500, 800, Color.web("#3DB2FF", 1));
        root1.getChildren().addAll(formAdd.getLayout(), new Border().getBorder());
        scene_add.getStylesheets().add("css/Add.css");
        formAdd.autoConvertPronun();
        addNewWord(dictionary);

    }

    public void addMenu(Menu menu) {
        root1.getChildren().add(menu.getLayout());
    }

    private void addNewWord(Dictionary dictionary) {
        formAdd.getButton().setOnAction(event -> {
            if (!formAdd.getInput_new_word().getText().isEmpty()) {
                if (!formAdd.getInput_pronunciation().getText().isEmpty()) {
                    if (!formAdd.getInput_word_explain().getText().isEmpty()) {
                        formAdd.autoConvertPronun();
                        Alert alert = alertAdd.getAlert_confirm();
                        Alert alert1 = alertAdd.getAlert_information();
                        Word newWord = new Word(formAdd.getInput_new_word().getText(),
                                formAdd.getInput_pronunciation().getText()
                                , formAdd.getInput_word_explain().getText());
                        if (dictionary.checkAlready(newWord)) {
                            System.out.println("chưa có");
                            alert.setHeaderText("Confirm add this word");
                            Optional<ButtonType> result = alert.showAndWait();
                            if (result.get().getButtonData() == ButtonBar.ButtonData.OK_DONE) {
                                try {
                                    dictionary.insertNewWord(newWord);

                                    alert1.setContentText("Add successfully!");
                                    formAdd.setEmptyInput();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                alert1.setContentText("Add fail!");
                                System.out.println("không thành công");
                            }
                            alert1.show();
                        } else {
                            alert1.setContentText("This word already exists!");
                            alert1.show();
                        }
                    }
                }
            }
        });
    }

    public Scene getScene() {
        return this.scene_add;
    }
}
