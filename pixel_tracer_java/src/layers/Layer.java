package layers;

import shape.Shape;
import java.util.ArrayList;
import java.util.List;

public class Layer {
    public static final int LAYER_UNVISIBLE = 0;
    public static final int LAYER_VISIBLE = 1;

    public long id;
    public String name;
    public List<Shape> shapes;
    public int visible;

    public Layer(long id, String name) {
        this.id = id;
        this.name = name;
        this.shapes = new ArrayList<>();
        this.visible = LAYER_VISIBLE;
    }

    public void setVisible() {
        visible = LAYER_VISIBLE;
    }

    public void setUnvisible() {
        visible = LAYER_UNVISIBLE;
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public boolean removeShapeById(long id) {
        return shapes.removeIf(shape -> shape.id == id);
    }
}
