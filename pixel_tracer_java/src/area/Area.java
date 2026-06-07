package area;

import layers.Layer;
import java.util.ArrayList;
import java.util.List;

public class Area {
    public static final char EMPTY_CELL = 0;
    public static final char FULL_CHAR = 1;

    public int width;
    public int height;
    public long id;
    public String name;
    public char emptyChar;
    public char fullChar;
    public char[][] area;
    public List<Layer> lstLayers;

    public Area(int width, int height, long id, String name) {
        this.width = width;
        this.height = height;
        this.id = id;
        this.name = name;
        this.emptyChar = '.';
        this.fullChar = '@';
        this.lstLayers = new ArrayList<>();
        this.area = new char[height][width];
    }

    public void addLayer(Layer layer) {
        lstLayers.add(layer);
    }
}
