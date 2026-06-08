package pixel;

import shape.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @file Rasterizer.java
 * @brief Convertit des formes géométriques en listes de pixels (équivalent de pixel.c).
 *
 * Implémente l'algorithme de Bresenham pour les segments et les cercles,
 * et l'algorithme de De Casteljau pour les courbes de Bézier.
 */
public class Rasterizer {

  /**
   * @brief Convertit une Shape en liste de pixels selon son type.
   * @param shape la forme à rastériser
   * @return liste de pixels correspondant à la forme
   */
  public List<Pixel> rasterize (Shape shape) {
    List<Pixel> pixels = new ArrayList<>();

    if (shape instanceof Point pt) {
      rasterizePoint(pt, shape.getColor(), pixels);
    } else if (shape instanceof Line ln) {
      rasterizeLine(ln, shape.getColor(), pixels);
    } else if (shape instanceof Circle ci) {
      rasterizeCircle(ci, shape.getColor(), pixels);
    } else if (shape instanceof Rectangle re) {
      rasterizeRectangle(re, shape.getColor(), pixels);
    } else if (shape instanceof Square sq) {
      rasterizeSquare(sq, shape.getColor(), pixels);
    } else if (shape instanceof Polygone po) {
      rasterizePolygone(po, shape.getColor(), pixels);
    } else if (shape instanceof Curve cu) {
      rasterizeCurve(cu, shape.getColor(), pixels);
    }

    return pixels;
  }

  // -------------------------------------------------------------------------
  // Rastérisation par type de forme
  // -------------------------------------------------------------------------

  private void rasterizePoint (Point pt, int color, List<Pixel> pixels) {
    pixels.add(new Pixel(pt.getPos_x(), pt.getPos_y(), color));
  }

  private void rasterizeLine (Line ln, int color, List<Pixel> pixels) {
    int x  = ln.getP1().getPos_x();
    int y  = ln.getP1().getPos_y();
    int dx = ln.getP2().getPos_x() - x;
    int dy = ln.getP2().getPos_y() - y;
    tracerSegment(x, y, dx, dy, color, pixels);
  }

  private void rasterizeCircle (Circle ci, int color, List<Pixel> pixels) {
    int cx = ci.getCenter().getPos_x();
    int cy = ci.getCenter().getPos_y();
    int r  = ci.getRadius();
    int x  = 0;
    int y  = r;
    int d  = r - 1;

    while (y >= x) {
      // 8 octants symétriques
      pixels.add(new Pixel(cx + x, cy + y, color));
      pixels.add(new Pixel(cx + y, cy + x, color));
      pixels.add(new Pixel(cx - x, cy + y, color));
      pixels.add(new Pixel(cx - y, cy + x, color));
      pixels.add(new Pixel(cx + x, cy - y, color));
      pixels.add(new Pixel(cx + y, cy - x, color));
      pixels.add(new Pixel(cx - x, cy - y, color));
      pixels.add(new Pixel(cx - y, cy - x, color));

      if (d >= 2 * x) {
        d -= 2 * x + 1;
        x++;
      } else if (d < 2 * (r - y)) {
        d += 2 * y - 1;
        y--;
      } else {
        d += 2 * (y - x - 1);
        y--;
        x++;
      }
    }
  }

  private void rasterizeRectangle (Rectangle re, int color, List<Pixel> pixels) {
    int x = re.getP1().getPos_x();
    int y = re.getP1().getPos_y();
    int w = re.getWidth();
    int h = re.getHeight();
    // 4 côtés
    tracerSegment(x,         y,         0,     w - 1, color, pixels);
    tracerSegment(x,         y,         h - 1, 0,     color, pixels);
    tracerSegment(x,         y + w - 1, h - 1, 0,     color, pixels);
    tracerSegment(x + h - 1, y,         0,     w - 1, color, pixels);
  }

  private void rasterizeSquare (Square sq, int color, List<Pixel> pixels) {
    int x = sq.getP1().getPos_x();
    int y = sq.getP1().getPos_y();
    int l = sq.getLength();
    // 4 côtés égaux
    tracerSegment(x,         y,         l - 1, 0,     color, pixels);
    tracerSegment(x,         y,         0,     l - 1, color, pixels);
    tracerSegment(x,         y + l - 1, l - 1, 0,     color, pixels);
    tracerSegment(x + l - 1, y,         0,     l - 1, color, pixels);
  }

  private void rasterizePolygone (Polygone po, int color, List<Pixel> pixels) {
    List<Point> pts = po.getPoints();
    for (int i = 1; i < pts.size(); i++) {
      Point a = pts.get(i - 1);
      Point b = pts.get(i);
      tracerSegment(a.getPos_x(), a.getPos_y(),
                    b.getPos_x() - a.getPos_x(),
                    b.getPos_y() - a.getPos_y(),
                    color, pixels);
    }
  }

  private void rasterizeCurve (Curve cu, int color, List<Pixel> pixels) {
    Point[] ctrls = { cu.getP1(), cu.getP2(), cu.getP3(), cu.getP4() };
    for (double t = 0.0; t < 1.0; t += 0.0001) {
      Point pt = deCasteljau(ctrls, t);
      pixels.add(new Pixel(pt.getPos_x(), pt.getPos_y(), color));
    }
  }

  // -------------------------------------------------------------------------
  // Algorithmes
  // -------------------------------------------------------------------------

  /**
   * @brief Algorithme de Bresenham pour tracer un segment.
   * @param x     coordonnée X du départ
   * @param y     coordonnée Y du départ
   * @param dx    déplacement en X
   * @param dy    déplacement en Y
   * @param color couleur des pixels
   * @param pixels liste destination
   */
  private void tracerSegment (int x, int y, int dx, int dy, int color, List<Pixel> pixels) {
    int xinc = (dx > 0) ? 1 : -1;
    int yinc = (dy > 0) ? 1 : -1;
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

  /**
   * @brief Calcule le point sur une courbe de Bézier par l'algorithme de De Casteljau.
   * @param pts tableau de points de contrôle
   * @param t   paramètre dans [0, 1]
   * @return point interpolé
   */
  private Point deCasteljau (Point[] pts, double t) {
    double[] xs = new double[pts.length];
    double[] ys = new double[pts.length];
    for (int i = 0; i < pts.length; i++) {
      xs[i] = pts[i].getPos_x();
      ys[i] = pts[i].getPos_y();
    }
    for (int i = pts.length - 1; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        xs[j] = xs[j] * (1 - t) + xs[j + 1] * t;
        ys[j] = ys[j] * (1 - t) + ys[j + 1] * t;
      }
    }
    Point result = new Point();
    result.setPos_x((int) xs[0]);
    result.setPos_y((int) ys[0]);
    return result;
  }

}
