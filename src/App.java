import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
//asd
public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Dictionary");

        Dictionary dictionary = new Dictionary();
        SceneSearch scene1 = new SceneSearch(dictionary);
        SceneAdd scene2 = new SceneAdd(dictionary);
        SceneEdit scene4 = new SceneEdit(dictionary);
        Menu menu = new Menu();
        primaryStage.setScene(scene1.getScene());
        scene1.addMenu(menu);
        menu.addClassSelected(menu.getBtn_search());
        primaryStage.getIcons().add(new Image("file:src/image/logo.png"));

        menu.getBtn_search().setOnAction(event -> {
            if (!primaryStage.getScene().equals(scene1.getScene())) {
                primaryStage.setScene(scene1.getScene());
                scene1.addMenu(menu);
                menu.addClassSelected(menu.getBtn_search());
            }
        });

        menu.getBtn_add().setOnAction(event -> {
            if (!primaryStage.getScene().equals(scene2.getScene())) {
                primaryStage.setScene(scene2.getScene());
                scene2.addMenu(menu);
                menu.addClassSelected(menu.getBtn_add());
            }
        });

        menu.getBtn_edit().setOnAction(event -> {
            if (!primaryStage.getScene().equals(scene4.getScene())) {
                primaryStage.setScene(scene4.getScene());
                scene4.addMenu(menu);
                menu.addClassSelected(menu.getBtn_edit());
            }
        });


        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
