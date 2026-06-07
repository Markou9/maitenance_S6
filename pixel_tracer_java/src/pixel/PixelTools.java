package pixel;

import shape.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PixelTools {
    private PixelTools() {}

    public static List<Pixel> createShapeToPixel(Shape shape) {
        List<Pixel> pixels = new ArrayList<>();
        if (shape == null || shape.ptrShape == null) return pixels;

        switch (shape.shapeType) {
            case POINT -> pixelPoint(shape, pixels);
            case LINE -> pixelLine(shape, pixels);
            case SQUAR -> pixelSquare(shape, pixels);
            case RECTANGLE -> pixelRectangle(shape, pixels);
            case CERCLE -> pixelCercle(shape, pixels);
            case POLYGON -> pixelPolygon(shape, pixels);
            case CURVE -> pixelCurve(shape, pixels);
        }
        return pixels;
    }

    private static void pixelPoint(Shape shape, List<Pixel> pixels) {
        Point pt = (Point) shape.ptrShape;
        pixels.add(new Pixel(pt.posX, pt.posY, shape.color));
    }

    private static void drawSegment(int x, int y, int dx, int dy, Color color, List<Pixel> pixels) {
        int xinc = dx > 0 ? 1 : -1;
        int yinc = dy > 0 ? 1 : -1;
        dx = Math.abs(dx);
        dy = Math.abs(dy);

        pixels.add(new Pixel(x, y, color));

        if (dx > dy) {
            int cumul = dx / 2;
            for (int i = 1; i <= dx; i++) {
                x += xinc;
                cumul += dy;
                if (cumul >= dx) {
                    cumul -= dx;
                    y += yinc;
                }
                pixels.add(new Pixel(x, y, color));
            }
        } else {
            int cumul = dy / 2;
            for (int i = 1; i <= dy; i++) {
                y += yinc;
                cumul += dx;
                if (cumul >= dy) {
                    cumul -= dy;
                    x += xinc;
                }
                pixels.add(new Pixel(x, y, color));
            }
        }
    }

    private static void pixelLine(Shape shape, List<Pixel> pixels) {
        Line line = (Line) shape.ptrShape;
        int x = line.p1.posX;
        int y = line.p1.posY;
        int dx = line.p2.posX - line.p1.posX;
        int dy = line.p2.posY - line.p1.posY;
        drawSegment(x, y, dx, dy, shape.color, pixels);
    }

    private static void pixelCercle(Shape shape, List<Pixel> pixels) {
        Cercle cercle = (Cercle) shape.ptrShape;
        int x = 0;
        int y = cercle.radus;
        int d = cercle.radus - 1;

        while (y >= x) {
            addCircleSymmetryPixels(cercle, x, y, shape.color, pixels);
            if (d >= 2 * x) {
                d -= 2 * x + 1;
                x++;
            } else if (d < 2 * (cercle.radus - y)) {
                d += 2 * y - 1;
                y--;
            } else {
                d += 2 * (y - x - 1);
                y--;
                x++;
            }
        }
    }

    private static void addCircleSymmetryPixels(Cercle cercle, int x, int y, Color color, List<Pixel> pixels) {
        int cx = cercle.center.posX;
        int cy = cercle.center.posY;
        pixels.add(new Pixel(cx + x, cy + y, color));
        pixels.add(new Pixel(cx + y, cy + x, color));
        pixels.add(new Pixel(cx - x, cy + y, color));
        pixels.add(new Pixel(cx - y, cy + x, color));
        pixels.add(new Pixel(cx + x, cy - y, color));
        pixels.add(new Pixel(cx + y, cy - x, color));
        pixels.add(new Pixel(cx - x, cy - y, color));
        pixels.add(new Pixel(cx - y, cy - x, color));
    }

    private static void pixelRectangle(Shape shape, List<Pixel> pixels) {
        Rectangle rec = (Rectangle) shape.ptrShape;
        drawSegment(rec.p1.posX, rec.p1.posY, 0, rec.width - 1, shape.color, pixels);
        drawSegment(rec.p1.posX, rec.p1.posY, rec.height - 1, 0, shape.color, pixels);
        drawSegment(rec.p1.posX, rec.p1.posY + rec.width - 1, rec.height - 1, 0, shape.color, pixels);
        drawSegment(rec.p1.posX + rec.height - 1, rec.p1.posY, 0, rec.width - 1, shape.color, pixels);
    }

    private static void pixelSquare(Shape shape, List<Pixel> pixels) {
        Squar square = (Squar) shape.ptrShape;
        drawSegment(square.p1.posX, square.p1.posY, square.length - 1, 0, shape.color, pixels);
        drawSegment(square.p1.posX, square.p1.posY, 0, square.length - 1, shape.color, pixels);
        drawSegment(square.p1.posX, square.p1.posY + square.length - 1, square.length - 1, 0, shape.color, pixels);
        drawSegment(square.p1.posX + square.length - 1, square.p1.posY, 0, square.length - 1, shape.color, pixels);
    }

    private static void pixelPolygon(Shape shape, List<Pixel> pixels) {
        Polygon poly = (Polygon) shape.ptrShape;
        for (int i = 1; i < poly.points.size(); i++) {
            Point p1 = poly.points.get(i - 1);
            Point p2 = poly.points.get(i);
            drawSegment(p1.posX, p1.posY, p2.posX - p1.posX, p2.posY - p1.posY, shape.color, pixels);
        }
    }

    private static Point calcPointMedian(Point p1, Point p2, double t) {
        int x = (int) (p1.posX * (1 - t) + p2.posX * t);
        int y = (int) (p1.posY * (1 - t) + p2.posY * t);
        return new Point(x, y);
    }

    private static Point cjCalc(List<Point> points, double t) {
        List<Point> tmp = new ArrayList<>();
        for (Point p : points) tmp.add(new Point(p.posX, p.posY));

        for (int i = tmp.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                tmp.set(j, calcPointMedian(tmp.get(j), tmp.get(j + 1), t));
            }
        }
        return tmp.get(0);
    }

    private static void pixelCurve(Shape shape, List<Pixel> pixels) {
        Curve curve = (Curve) shape.ptrShape;
        List<Point> points = Arrays.asList(curve.p1, curve.p2, curve.p3, curve.p4);
        for (double t = 0; t < 1.0; t += 0.0001) {
            Point point = cjCalc(points, t);
            pixels.add(new Pixel(point.posX, point.posY, shape.color));
        }
    }
}
