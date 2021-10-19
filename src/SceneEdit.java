import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class SceneEdit {

    private final TextField input = new TextField();
    private final Button btn_1 = new Button();
    private final Label heading = new Label("Type the word you want to edit");
    private final Scene scene;
    private final Group root = new Group();
    private final Group layout = new Group();
    private final Group form = new Group();

    public SceneEdit(Dictionary dictionary) {
        scene = new Scene(root, 1500, 800, Color.web("3DB2FF", 1));
        setLayout();
        root.getChildren().addAll(layout, new Border().getBorder(), form);
        root.getStylesheets().add("css/Edit.css");
        click_Btn(dictionary);
        click_Enter(dictionary);
    }

    private void setLayout() {
        layout.getChildren().addAll(input, btn_1, heading);
        layout.setLayoutX(400);
        setInput();
        setBtn_1();
        setHeading();

    }

    private void setInput() {
        input.setPromptText("Word...");
        input.getStyleClass().add("input");
        input.getStylesheets().add("css/Input.css");
        input.setLayoutY(150);
        input.setFocusTraversable(false);
    }

    private void setBtn_1() {
        btn_1.getStyleClass().add("button");
        btn_1.getStylesheets().add("css/Button.css");
        btn_1.setText("Search");
        btn_1.setLayoutY(150);
        btn_1.setLayoutX(610);
    }

    public void setHeading() {
        heading.setLayoutY(100);
        heading.getStyleClass().add("heading");
    }
    private void eventAction(Dictionary dictionary) {
        form.getChildren().clear();
        if (!input.getText().isEmpty()) {
            String word = input.getText();
            ArrayList<Word> list =  dictionary.dictionaryManagement.getListWordSearch(word);
            if (list != null) {
                FormEdit formEdit = new FormEdit(list);
                form.getChildren().add(formEdit.getLayout());
                formEdit.getButtonDelete().setOnAction(event1 -> {
                    AlertDelete alertDelete = new AlertDelete();
                    Optional<ButtonType> result = alertDelete.getAlert_confirm().showAndWait();
                    if (result.get().getButtonData() == ButtonBar.ButtonData.OK_DONE) {
                        try {
                            dictionary.dictionaryManagement.delete(formEdit.getWord());
                            alertDelete.getAlert_information().setContentText("Delete successfully!");
                            form.getChildren().clear();
                            input.setText(null);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        alertDelete.getAlert_information().setContentText("Delete fail!");
                    }
                    alertDelete.getAlert_information().show();
                });
                formEdit.getButtonEdit().setOnMouseClicked(event -> {
                    if (!form.getChildren().contains(formEdit.getLayoutEdit())) {
                        form.getChildren().add(formEdit.getLayoutEdit());
                        formEdit.layoutEdit.getButtonCancel().setOnMouseClicked(e -> {
                            form.getChildren().remove(formEdit.getLayoutEdit());
                        });

                        formEdit.layoutEdit.getButtonConfirm().setOnMouseClicked(e2 -> {
                            formEdit.layoutEdit.getChange();
                            AlertAdd alertAdd = new AlertAdd();
                            alertAdd.getAlert_confirm().setHeaderText("Confirm changes this word!");
                            Optional<ButtonType> result = alertAdd.getAlert_confirm().showAndWait();
                            if (result.get().getButtonData() == ButtonBar.ButtonData.OK_DONE) {
                                try {
                                    dictionary.dictionaryManagement.editWord(formEdit.getWord(), formEdit.layoutEdit.getChangeWord());
                                    alertAdd.getAlert_information().setContentText("Change successfully!");
                                    alertAdd.getAlert_information().show();
                                    form.getChildren().remove(formEdit.getLayoutEdit());
                                    form.getChildren().remove(formEdit.getLayout());
                                    input.setText(null);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } else  if (result.get().getButtonData() == ButtonBar.ButtonData.CANCEL_CLOSE) {
                                alertAdd.getAlert_information().setContentText("Change failed!");
                                alertAdd.getAlert_information().show();
                            }
                        });
                    }
                });

                formEdit.getButtonCancel().setOnMouseClicked(event -> {
                    form.getChildren().clear();
                });

                formEdit.getButtonNext().setOnMouseClicked(event -> {
                    form.getChildren().clear();
                    formEdit.nextAction();
                    form.getChildren().add(formEdit.getLayout());
                });

                formEdit.getButtonPrevious().setOnMouseClicked(event -> {
                    form.getChildren().clear();
                    formEdit.previousAction();
                    form.getChildren().add(formEdit.getLayout());
                });

            } else {
                Label noWord = new Label("NO have word " + input.getText());
                form.getChildren().add(noWord);
                noWord.setStyle("-fx-font-size: 30px;");
                noWord.setLayoutX(400);
                noWord.setLayoutY(220);
            }
        }
    }

    private void click_Btn(Dictionary dictionary) {
        btn_1.setOnMouseClicked(event -> {
            eventAction(dictionary);
        });
    }

    private void click_Enter(Dictionary dictionary) {
        input.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                eventAction(dictionary);
            }
        });
    }

    public Scene getScene() {
        return this.scene;
    }

    public void addMenu(Menu menu) {
        root.getChildren().add(menu.getLayout());
    }


}
