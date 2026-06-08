package command;

import area.Area;
import id.Id;
import layers.Layer;
import pixeltracer.PixelTracerApp;
import shape.Shape;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommandManager {
    private static final String[] ERROR_MESSAGES = {
        "",
        "commande inconnue",
        "commande manquante",
        "erreur paramètres, consulter la commande help",
        "exit",
        "clear",
        "plot",
        "~~~ Help ~~~",
        "done",
        "id inconnu dans la list"
    };

    private final Scanner scanner = new Scanner(System.in);

    public int readExecCommand(PixelTracerApp app) {
        int errorNum = 1;
        System.out.print("~> ");
        String line = scanner.nextLine().toLowerCase();
        int commentIndex = line.indexOf('#');
        if (commentIndex >= 0) {
            line = line.substring(0, commentIndex);
        }
        line = line.trim();

        if (line.isEmpty()) {
            errorNum = 2;
            System.out.println(ERROR_MESSAGES[errorNum]);
            return errorNum;
        }

        String[] tokens = line.split("\\s+");
        String cmdName = tokens[0];
        List<String> words = new ArrayList<>();
        List<Integer> ints = new ArrayList<>();
        List<Float> floats = new ArrayList<>();

        for (String token : tokens) {
            if (isWord(token)) words.add(token);
            else if (isInt(token)) ints.add(Integer.parseInt(token));
            else if (isFloat(token)) floats.add(Float.parseFloat(token));
            else {
                words.add("error");
                words.add("line");
            }
        }

        switch (cmdName) {
            case "exit" -> errorNum = check(words, ints, floats, 1, 0, 0) ? 4 : 3;
            case "clear" -> errorNum = check(words, ints, floats, 1, 0, 0) ? 5 : 3;
            case "plot" -> errorNum = check(words, ints, floats, 1, 0, 0) ? 6 : 3;
            case "help" -> {
                if (!check(words, ints, floats, 1, 0, 0)) errorNum = 3;
                else {
                    printHelp();
                    errorNum = 7;
                }
            }
            case "point" -> {
                if (!check(words, ints, floats, 1, 2, 0)) errorNum = 3;
                else {
                    app.currentLayer.addShape(Shape.createPointShape(ints.get(0), ints.get(1)));
                    errorNum = 0;
                }
            }
            case "line" -> {
                if (!check(words, ints, floats, 1, 4, 0)) errorNum = 3;
                else {
                    app.currentLayer.addShape(Shape.createLineShape(ints.get(0), ints.get(1), ints.get(2), ints.get(3)));
                    errorNum = 0;
                }
            }
            case "circle" -> {
                if (!check(words, ints, floats, 1, 3, 0)) errorNum = 3;
                else {
                    app.currentLayer.addShape(Shape.createCercleShape(ints.get(0), ints.get(1), ints.get(2)));
                    errorNum = 0;
                }
            }
            case "square" -> {
                if (!check(words, ints, floats, 1, 3, 0)) errorNum = 3;
                else {
                    app.currentLayer.addShape(Shape.createSquareShape(ints.get(0), ints.get(1), ints.get(2)));
                    errorNum = 0;
                }
            }
            case "rectangle" -> {
                if (!check(words, ints, floats, 1, 4, 0)) errorNum = 3;
                else {
                    app.currentLayer.addShape(Shape.createRectangleShape(ints.get(0), ints.get(1), ints.get(2), ints.get(3)));
                    errorNum = 0;
                }
            }
            case "polygon" -> {
                if (!checkPolygon(words, ints, floats)) errorNum = 3;
                else {
                    Shape shape = Shape.createPolygonShape(ints);
                    if (shape != null) app.currentLayer.addShape(shape);
                    errorNum = 0;
                }
            }
            case "curve" -> {
                if (!check(words, ints, floats, 1, 8, 0)) errorNum = 3;
                else {
                    app.currentLayer.addShape(Shape.createCurveShape(ints.get(0), ints.get(1), ints.get(2), ints.get(3), ints.get(4), ints.get(5), ints.get(6), ints.get(7)));
                    errorNum = 0;
                }
            }
            case "list" -> errorNum = execList(app, words, ints, floats);
            case "new" -> errorNum = execNew(app, words, ints, floats);
            case "select" -> errorNum = execSelect(app, words, ints, floats);
            case "delete" -> errorNum = execDelete(app, words, ints, floats);
            case "set" -> errorNum = execSet(app, words, ints, floats);
            default -> errorNum = 1;
        }

        System.out.println(ERROR_MESSAGES[errorNum]);
        return errorNum;
    }

    private static int execList(PixelTracerApp app, List<String> words, List<Integer> ints, List<Float> floats) {
        if (!check(words, ints, floats, 2, 0, 0)) return 3;
        switch (words.get(1)) {
            case "areas" -> {
                for (Area area : app.listArea) {
                    System.out.printf(" %s %3d %s%n", area == app.currentArea ? "*" : "-", area.id, area.name);
                }
                return 8;
            }
            case "layers" -> {
                for (Layer layer : app.currentArea.lstLayers) {
                    char vis = layer.visible == Layer.LAYER_VISIBLE ? 'V' : 'H';
                    System.out.printf(" %s %3d (%c) %s%n", layer == app.currentLayer ? "*" : "-", layer.id, vis, layer.name);
                }
                return 8;
            }
            case "shapes" -> {
                for (Shape shape : app.currentLayer.shapes) {
                    System.out.printf(" %s %3d : %s %s%n", shape == app.currentShape ? "*" : "-", shape.id, shape.shapeType, shape.sprintShape());
                }
                return 8;
            }
            default -> { return 3; }
        }
    }

    private static int execNew(PixelTracerApp app, List<String> words, List<Integer> ints, List<Float> floats) {
        if (!check(words, ints, floats, 2, 0, 0)) return 3;
        if (words.get(1).equals("area")) {
            Area area = new Area(80, 40, Id.getNextId(), "area_name");
            app.listArea.add(area);
            app.currentArea = area;
            Layer layer = new Layer(Id.getNextId(), "Layer 1");
            area.addLayer(layer);
            app.currentLayer = layer;
            app.currentShape = null;
            return 8;
        }
        if (words.get(1).equals("layer")) {
            Layer layer = new Layer(Id.getNextId(), "layer_name");
            app.currentArea.addLayer(layer);
            app.currentLayer = layer;
            app.currentShape = null;
            return 8;
        }
        return 3;
    }

    private static int execSelect(PixelTracerApp app, List<String> words, List<Integer> ints, List<Float> floats) {
        if (!check(words, ints, floats, 2, 1, 0)) return 3;
        long id = ints.get(0);
        if (words.get(1).equals("area")) {
            for (Area area : app.listArea) {
                if (area.id == id) {
                    app.currentArea = area;
                    app.currentLayer = area.lstLayers.isEmpty() ? null : area.lstLayers.get(area.lstLayers.size() - 1);
                    app.currentShape = null;
                    System.out.printf("%3d %s : selected%n", area.id, area.name);
                    return 8;
                }
            }
            return 9;
        }
        if (words.get(1).equals("layer")) {
            for (Layer layer : app.currentArea.lstLayers) {
                if (layer.id == id) {
                    app.currentLayer = layer;
                    app.currentShape = null;
                    return 8;
                }
            }
            return 9;
        }
        if (words.get(1).equals("shape")) {
            for (Shape shape : app.currentLayer.shapes) {
                if (shape.id == id) {
                    app.currentShape = shape;
                    return 8;
                }
            }
            return 9;
        }
        return 3;
    }

    private static int execDelete(PixelTracerApp app, List<String> words, List<Integer> ints, List<Float> floats) {
        if (!check(words, ints, floats, 2, 1, 0)) return 3;
        if (words.get(1).equals("shape")) {
            boolean removed = app.currentLayer.removeShapeById(ints.get(0));
            app.currentShape = null;
            return removed ? 8 : 9;
        }
        return 3;
    }

    private static int execSet(PixelTracerApp app, List<String> words, List<Integer> ints, List<Float> floats) {
        if (!check(words, ints, floats, 3, 1, 0)) return 3;
        if (words.get(1).equals("char")) {
            if (words.get(2).equals("border")) {
                app.currentArea.fullChar = (char) ints.get(0).intValue();
                return 0;
            }
            if (words.get(2).equals("background")) {
                app.currentArea.emptyChar = (char) ints.get(0).intValue();
                return 0;
            }
            return 3;
        }
        if (words.get(1).equals("layer") && (words.get(2).equals("visible") || words.get(2).equals("unvisible"))) {
            for (Layer layer : app.currentArea.lstLayers) {
                if (layer.id == ints.get(0)) {
                    if (words.get(2).equals("visible")) layer.setVisible();
                    else layer.setUnvisible();
                    return 0;
                }
            }
            return 9;
        }
        return 3;
    }

    private static boolean check(List<String> words, List<Integer> ints, List<Float> floats, int nbStr, int nbInt, int nbFlt) {
        return words.size() == nbStr && ints.size() == nbInt && floats.size() == nbFlt;
    }

    private static boolean checkPolygon(List<String> words, List<Integer> ints, List<Float> floats) {
        return words.size() == 1 && !ints.isEmpty() && ints.size() % 2 == 0 && floats.isEmpty();
    }

    private static boolean isInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isFloat(String str) {
        try {
            Float.parseFloat(str);
            return str.contains(".");
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isWord(String str) {
        return str.matches("[a-z]+");
    }

    private static void printHelp() {
        System.out.println("\t**************************************************");
        System.out.println("\t****         VECTOR TEXT-BASED EDITOR         ****");
        System.out.println("\t**************************************************");
        System.out.println("\t==== Control ====");
        System.out.println("\tclear : clear screen");
        System.out.println("\texit : exit the program");
        System.out.println("\thelp : print this help");
        System.out.println("\tplot : draw screen");
        System.out.println("\t==== Draw shapes ====");
        System.out.println("\tpoint px py");
        System.out.println("\tline x1 y1 x2 y2");
        System.out.println("\tsquare x1 y1 l");
        System.out.println("\trectangle x1 y1 w h");
        System.out.println("\tcircle x y r");
        System.out.println("\tpolygon x1 y1 x2 y2 ...");
        System.out.println("\tcurve x1 y1 x2 y2 x3 y3 x4 y4");
        System.out.println("\t==== Draw manager ====");
        System.out.println("\tlist {areas, layers, shapes}");
        System.out.println("\tselect {area, layer, shape} {id}");
        System.out.println("\tdelete shape {id}");
        System.out.println("\tnew {area, layer}");
        System.out.println("\tset char {border, background} ascii_code");
        System.out.println("\tset layer {visible, unvisible} {id}");
    }
}
