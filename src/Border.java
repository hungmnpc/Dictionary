import javafx.scene.Group;
import javafx.scene.shape.Line;

public class Border {
    private Group border = new Group();

    public Border() {
        Line line = new Line( 350, 0, 350, 800);

        this.border.getChildren().add(line);
    }

    public Group getBorder() {
        return this.border;
    }
}
