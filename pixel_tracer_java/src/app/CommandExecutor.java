package app;

import scene.Area;
import scene.IdGenerator;
import scene.Layer;
import shape.*;
import java.util.List;


/**
 * @file CommandExecutor.java
 * @brief Exécute les commandes sur l'état de l'application (équivalent de read_exec_command en C).
 *
 * Codes de retour :
 *   0 = succès (redessin nécessaire)
 *   2 = aucune commande saisie
 *   3 = erreur de paramètres
 *   4 = exit
 *   5 = clear écran
 *   6 = plot (afficher)
 *   8 = succès sans redessin
 *   9 = identifiant inconnu
 */
public class CommandExecutor {

  /**
   * @brief Exécute une Command sur l'application.
   * @param app l'état de l'application
   * @param cmd la commande à exécuter
   * @return le code de retour indiquant le résultat
   */
  public int executer (PixelTracerApp app, Command cmd) {
    if (cmd == null || cmd.getNom().isBlank()) return 2;

    String nom = cmd.getNom();

    return switch (nom) {
      case "exit"      -> 4;
      case "clear"     -> 5;
      case "plot"      -> 6;
      case "help"      -> { afficherAide(); yield 7; }
      case "point"     -> creerPoint(app, cmd);
      case "line"      -> creerLigne(app, cmd);
      case "square"    -> creerCarre(app, cmd);
      case "rectangle" -> creerRectangle(app, cmd);
      case "circle"    -> creerCercle(app, cmd);
      case "polygon"   -> creerPolygone(app, cmd);
      case "curve"     -> creerCourbe(app, cmd);
      case "list"      -> lister(app, cmd);
      case "new"       -> creerElement(app, cmd);
      case "select"    -> selectionner(app, cmd);
      case "delete"    -> supprimer(app, cmd);
      case "set"       -> modifier(app, cmd);
      default          -> { System.out.println("commande inconnue"); yield 1; }
    };
  }

  // -------------------------------------------------------------------------
  // Commandes de dessin
  // -------------------------------------------------------------------------

  private int creerPoint (PixelTracerApp app, Command cmd) {
    if (cmd.getParamsInt().size() != 2) return 3;
    Point pt = new Point();
    pt.setId(IdGenerator.getNextId());
    pt.setPos_x(cmd.getParamsInt().get(0));
    pt.setPos_y(cmd.getParamsInt().get(1));
    app.getCalqueCourant().ajouterForme(pt);
    return 0;
  }

  private int creerLigne (PixelTracerApp app, Command cmd) {
    if (cmd.getParamsInt().size() != 4) return 3;
    List<Integer> p = cmd.getParamsInt();
    Point p1 = new Point(); p1.setPos_x(p.get(0)); p1.setPos_y(p.get(1));
    Point p2 = new Point(); p2.setPos_x(p.get(2)); p2.setPos_y(p.get(3));
    Line ligne = new Line();
    ligne.setId(IdGenerator.getNextId());
    ligne.setP1(p1);
    ligne.setP2(p2);
    app.getCalqueCourant().ajouterForme(ligne);
    return 0;
  }

  private int creerCarre (PixelTracerApp app, Command cmd) {
    if (cmd.getParamsInt().size() != 3) return 3;
    List<Integer> p = cmd.getParamsInt();
    Point p1 = new Point(); p1.setPos_x(p.get(0)); p1.setPos_y(p.get(1));
    Square carre = new Square();
    carre.setId(IdGenerator.getNextId());
    carre.setP1(p1);
    carre.setLength(p.get(2));
    app.getCalqueCourant().ajouterForme(carre);
    return 0;
  }

  private int creerRectangle (PixelTracerApp app, Command cmd) {
    if (cmd.getParamsInt().size() != 4) return 3;
    List<Integer> p = cmd.getParamsInt();
    Point p1 = new Point(); p1.setPos_x(p.get(0)); p1.setPos_y(p.get(1));
    Rectangle rect = new Rectangle();
    rect.setId(IdGenerator.getNextId());
    rect.setP1(p1);
    rect.setWidth(p.get(2));
    rect.setHeight(p.get(3));
    app.getCalqueCourant().ajouterForme(rect);
    return 0;
  }

  private int creerCercle (PixelTracerApp app, Command cmd) {
    if (cmd.getParamsInt().size() != 3) return 3;
    List<Integer> p = cmd.getParamsInt();
    Point centre = new Point(); centre.setPos_x(p.get(0)); centre.setPos_y(p.get(1));
    Circle cercle = new Circle();
    cercle.setId(IdGenerator.getNextId());
    cercle.setCenter(centre);
    cercle.setRadius(p.get(2));
    app.getCalqueCourant().ajouterForme(cercle);
    return 0;
  }

  private int creerPolygone (PixelTracerApp app, Command cmd) {
    List<Integer> p = cmd.getParamsInt();
    if (p.size() < 2 || p.size() % 2 != 0) return 3;
    java.util.ArrayList<Point> sommets = new java.util.ArrayList<>();
    for (int i = 0; i < p.size(); i += 2) {
      Point pt = new Point();
      pt.setPos_x(p.get(i));
      pt.setPos_y(p.get(i + 1));
      sommets.add(pt);
    }
    Polygone poly = new Polygone();
    poly.setId(IdGenerator.getNextId());
    poly.setPoints(sommets);
    app.getCalqueCourant().ajouterForme(poly);
    return 0;
  }

  private int creerCourbe (PixelTracerApp app, Command cmd) {
    if (cmd.getParamsInt().size() != 8) return 3;
    List<Integer> p = cmd.getParamsInt();
    Point p1 = new Point(); p1.setPos_x(p.get(0)); p1.setPos_y(p.get(1));
    Point p2 = new Point(); p2.setPos_x(p.get(2)); p2.setPos_y(p.get(3));
    Point p3 = new Point(); p3.setPos_x(p.get(4)); p3.setPos_y(p.get(5));
    Point p4 = new Point(); p4.setPos_x(p.get(6)); p4.setPos_y(p.get(7));
    Curve courbe = new Curve();
    courbe.setId(IdGenerator.getNextId());
    courbe.setP1(p1); courbe.setP2(p2); courbe.setP3(p3); courbe.setP4(p4);
    app.getCalqueCourant().ajouterForme(courbe);
    return 0;
  }

  // -------------------------------------------------------------------------
  // Commandes de gestion
  // -------------------------------------------------------------------------

  private int lister (PixelTracerApp app, Command cmd) {
    if (cmd.getParamsStr().isEmpty()) return 3;
    String cible = cmd.getParamsStr().get(0);

    switch (cible) {
      case "areas" -> {
        for (Area a : app.getAreas()) {
          String marqueur = (a == app.getAreaCourante()) ? " * " : " - ";
          System.out.printf("%s%3d %s%n", marqueur, a.getId(), a.getNom());
        }
      }
      case "layers" -> {
        for (Layer c : app.getAreaCourante().getCalques()) {
          String marqueur = (c == app.getCalqueCourant()) ? " * " : " - ";
          char vis = c.isVisible() ? 'V' : 'H';
          System.out.printf("%s%3d (%c) %s%n", marqueur, c.getId(), vis, c.getNom());
        }
      }
      case "shapes" -> {
        for (Shape f : app.getCalqueCourant().getFormes()) {
          String marqueur = (f == app.getFormeCourante()) ? " * " : " - ";
          System.out.printf("%s%3d : %s%n", marqueur, f.getId(), f.toString());
        }
      }
      default -> { return 3; }
    }
    return 8;
  }

  private int creerElement (PixelTracerApp app, Command cmd) {
    if (cmd.getParamsStr().isEmpty()) return 3;
    String cible = cmd.getParamsStr().get(0);

    if (cible.equals("area")) {
      Area area = new Area(80, 40, IdGenerator.getNextId(), "area_name");
      Layer calque = new Layer(IdGenerator.getNextId(), "Layer 1");
      area.ajouterCalque(calque);
      app.getAreas().add(area);
      app.setAreaCourante(area);
      app.setCalqueCourant(calque);
      app.setFormeCourante(null);
      return 8;
    }

    if (cible.equals("layer")) {
      Layer calque = new Layer(IdGenerator.getNextId(), "layer_name");
      app.getAreaCourante().ajouterCalque(calque);
      app.setCalqueCourant(calque);
      app.setFormeCourante(null);
      return 8;
    }

    return 3;
  }

  private int selectionner (PixelTracerApp app, Command cmd) {
    if (cmd.getParamsStr().isEmpty() || cmd.getParamsInt().isEmpty()) return 3;
    String cible = cmd.getParamsStr().get(0);
    long id = cmd.getParamsInt().get(0);

    if (cible.equals("area")) {
      for (Area a : app.getAreas()) {
        if (a.getId() == id) {
          app.setAreaCourante(a);
          if (!a.getCalques().isEmpty())
            app.setCalqueCourant(a.getCalques().get(a.getCalques().size() - 1));
          app.setFormeCourante(null);
          System.out.printf("%3d %s : sélectionnée%n", a.getId(), a.getNom());
          return 8;
        }
      }
      return 9;
    }

    if (cible.equals("layer")) {
      Layer found = app.getAreaCourante().trouverCalque(id);
      if (found != null) {
        app.setCalqueCourant(found);
        app.setFormeCourante(null);
        return 8;
      }
      return 9;
    }

    if (cible.equals("shape")) {
      for (Shape f : app.getCalqueCourant().getFormes()) {
        if (f.getId() == id) {
          app.setFormeCourante(f);
          return 8;
        }
      }
      return 9;
    }

    return 3;
  }

  private int supprimer (PixelTracerApp app, Command cmd) {
    if (cmd.getParamsStr().isEmpty() || cmd.getParamsInt().isEmpty()) return 3;
    String cible = cmd.getParamsStr().get(0);
    long id = cmd.getParamsInt().get(0);

    if (cible.equals("shape")) {
      boolean ok = app.getCalqueCourant().supprimerForme(id);
      if (!ok) return 9;
      app.setFormeCourante(null);
      return 8;
    }

    if (cible.equals("layer")) {
      boolean ok = app.getAreaCourante().supprimerCalque(id);
      if (!ok) return 9;
      List<Layer> calques = app.getAreaCourante().getCalques();
      app.setCalqueCourant(calques.isEmpty() ? null : calques.get(calques.size() - 1));
      app.setFormeCourante(null);
      return 8;
    }

    return 3;
  }

  private int modifier (PixelTracerApp app, Command cmd) {
    List<String> strs = cmd.getParamsStr();
    List<Integer> ints = cmd.getParamsInt();

    if (strs.size() < 2) return 3;
    String cible   = strs.get(0);
    String option  = strs.get(1);

    if (cible.equals("char") && ints.size() == 1) {
      char c = (char) ints.get(0).intValue();
      if (option.equals("border"))     { app.getAreaCourante().setCharPlein(c); return 0; }
      if (option.equals("background")) { app.getAreaCourante().setCharVide(c);  return 0; }
      return 3;
    }

    if (cible.equals("layer") && ints.size() == 1) {
      long id = ints.get(0);
      Layer calque = app.getAreaCourante().trouverCalque(id);
      if (calque == null) return 9;
      if (option.equals("visible"))   { calque.setVisible(true);  return 0; }
      if (option.equals("unvisible")) { calque.setVisible(false); return 0; }
      return 3;
    }

    return 3;
  }

  // -------------------------------------------------------------------------
  // Aide
  // -------------------------------------------------------------------------

  private void afficherAide () {
    System.out.println("\t**************************************************");
    System.out.println("\t****         VECTOR TEXT-BASED EDITOR         ****");
    System.out.println("\t**************************************************");
    System.out.println("\t==== Contrôle ====");
    System.out.println("\tclear         : vider l'écran");
    System.out.println("\texit          : quitter");
    System.out.println("\thelp          : afficher cette aide");
    System.out.println("\tplot          : afficher le dessin");
    System.out.println("\t==== Dessiner ====");
    System.out.println("\tpoint x y");
    System.out.println("\tline x1 y1 x2 y2");
    System.out.println("\tsquare x y l");
    System.out.println("\trectangle x y w h");
    System.out.println("\tcircle x y r");
    System.out.println("\tpolygon x1 y1 x2 y2 ...");
    System.out.println("\tcurve x1 y1 x2 y2 x3 y3 x4 y4");
    System.out.println("\t==== Gestion ====");
    System.out.println("\tlist {areas, layers, shapes}");
    System.out.println("\tnew {area, layer}");
    System.out.println("\tselect {area, layer, shape} id");
    System.out.println("\tdelete {shape, layer} id");
    System.out.println("\tset char {border, background} code_ascii");
    System.out.println("\tset layer {visible, unvisible} id");
  }

}
