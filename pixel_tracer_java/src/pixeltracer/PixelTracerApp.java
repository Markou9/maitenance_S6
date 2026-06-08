package pixeltracer;

import area.Area;
import id.Id;
import layers.Layer;
import shape.Shape;
import java.util.ArrayList;
import java.util.List;

public class PixelTracerApp {
    public List<Area> listArea;
    public Area currentArea;
    public Layer currentLayer;
    public Shape currentShape;

    public void initApp() {
        listArea = new ArrayList<>();
        Area area = new Area(80, 40, Id.getNextId(), "Area1");
        listArea.add(area);
        currentArea = area;

        Layer layer = new Layer(Id.getNextId(), "Layer 1");
        area.addLayer(layer);
        currentLayer = layer;
        currentShape = null;
    }

    public void destroyApp() {
        listArea.clear();
        currentArea = null;
        currentLayer = null;
        currentShape = null;
    }
}
