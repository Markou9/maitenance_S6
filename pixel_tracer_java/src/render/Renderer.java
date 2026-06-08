package render;

import area.Area;
import layers.Layer;
import pixel.Pixel;
import pixel.PixelTools;
import shape.Shape;
import java.util.List;

public final class Renderer {
    private Renderer() {}

    public static void clearArea(Area area) {
        for (int i = 0; i < area.height; i++) {
            for (int j = 0; j < area.width; j++) {
                area.area[i][j] = Area.EMPTY_CELL;
            }
        }
    }

    public static void drawArea(Area area) {
        for (int i = 0; i < area.height; i++) {
            for (int j = 0; j < area.width; j++) {
                if (area.area[i][j] == Area.FULL_CHAR) {
                    System.out.print(area.fullChar);
                } else {
                    System.out.print(area.emptyChar);
                }
            }
            System.out.println();
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[J");
        System.out.flush();
    }

    public static void drawAllLayers(Area area) {
        clearArea(area);
        for (Layer layer : area.lstLayers) {
            if (layer.visible == Layer.LAYER_VISIBLE) {
                drawLayerShapes(area, layer);
            }
        }
    }

    public static void drawLayerShapes(Area area, Layer layer) {
        for (Shape shape : layer.shapes) {
            List<Pixel> pixels = PixelTools.createShapeToPixel(shape);
            for (Pixel pixel : pixels) {
                if (pixel.px >= 0 && pixel.py >= 0 && pixel.px < area.height && pixel.py < area.width) {
                    area.area[pixel.px][pixel.py] = Area.FULL_CHAR;
                }
            }
        }
    }
}
