package render;

import pixel.Pixel;
import pixel.Rasterizer;
import scene.Area;
import scene.Layer;
import shape.Shape;
import java.util.List;


/**
 * @file ConsoleRenderer.java
 * @brief Affiche une Area dans la console sous forme de grille de caractères (équivalent de render.c).
 *
 * Rastérise toutes les formes des calques visibles dans une grille 2D,
 * puis imprime chaque ligne en console.
 */
public class ConsoleRenderer {

  private final Rasterizer rasterizer = new Rasterizer();

  /**
   * @brief Efface l'écran de la console (selon la plateforme).
   */
  public void effacerEcran () {
    String os = System.getProperty("os.name").toLowerCase();
    try {
      if (os.contains("win")) {
        new ProcessBuilder("cmd", "/c", "cls")
            .inheritIO().start().waitFor();
      } else {
        System.out.print("\033[H\033[J");
        System.out.flush();
      }
    } catch (Exception e) {
      System.out.print("\033[H\033[J");
    }
  }

  /**
   * @brief Dessine une Area : rastérise tous les calques visibles et affiche la grille.
   * @param area la zone de dessin à afficher
   */
  public void dessiner (Area area) {
    char[][] grille = initialiserGrille(area);
    rasteriserCalques(area, grille);
    afficherGrille(area, grille);
  }

  // -------------------------------------------------------------------------
  // Méthodes internes
  // -------------------------------------------------------------------------

  private char[][] initialiserGrille (Area area) {
    char[][] grille = new char[area.getHauteur()][area.getLargeur()];
    for (int i = 0; i < area.getHauteur(); i++) {
      for (int j = 0; j < area.getLargeur(); j++) {
        grille[i][j] = area.getCharVide();
      }
    }
    return grille;
  }

  private void rasteriserCalques (Area area, char[][] grille) {
    for (Layer calque : area.getCalques()) {
      if (!calque.isVisible()) continue;
      for (Shape forme : calque.getFormes()) {
        List<Pixel> pixels = rasterizer.rasterize(forme);
        for (Pixel px : pixels) {
          int x = px.getX();
          int y = px.getY();
          if (x >= 0 && x < area.getHauteur() && y >= 0 && y < area.getLargeur()) {
            grille[x][y] = area.getCharPlein();
          }
        }
      }
    }
  }

  private void afficherGrille (Area area, char[][] grille) {
    for (int i = 0; i < area.getHauteur(); i++) {
      for (int j = 0; j < area.getLargeur(); j++) {
        System.out.print(grille[i][j]);
      }
      System.out.println();
    }
  }

}
