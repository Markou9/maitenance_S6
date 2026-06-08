package scene;


/**
 * @file IdGenerator.java
 * @brief Générateur d'identifiants uniques globaux (équivalent de id.c).
 *
 * Maintient un compteur statique auto-incrémenté pour attribuer
 * un identifiant unique à chaque entité créée (Area, Layer, Shape).
 */
public class IdGenerator {

  private static long compteur = 0;

  private IdGenerator () { }

  /**
   * @brief Retourne le prochain identifiant disponible et l'incrémente.
   * @return le nouvel identifiant unique
   */
  public static long getNextId () {
    compteur++;
    return compteur;
  }

  /**
   * @brief Réinitialise le compteur à une valeur donnée.
   * @param valeur la nouvelle valeur du compteur
   */
  public static void setCompteur (long valeur) {
    compteur = valeur;
  }

}
