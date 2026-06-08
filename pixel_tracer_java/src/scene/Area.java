package scene;

import java.util.ArrayList;
import java.util.List;


/**
 * @file Area.java
 * @brief Représente une zone de dessin contenant des calques (équivalent de area.c).
 *
 * Une Area possède une largeur et une hauteur, des caractères d'affichage
 * (vide et plein), et une liste de calques.
 */
public class Area {

  //
  // Fields
  //

  private long id;
  private String nom;
  private int largeur;
  private int hauteur;
  private char charVide;
  private char charPlein;
  private List<Layer> calques;

  //
  // Constructors
  //

  public Area (int largeur, int hauteur, long id, String nom) {
    this.largeur   = largeur;
    this.hauteur   = hauteur;
    this.id        = id;
    this.nom       = nom;
    this.charVide  = '.';
    this.charPlein = '@';
    this.calques   = new ArrayList<>();
  }

  //
  // Accessor methods
  //

  /**
   * @brief Set the value of id
   * @param newVar the new value of id
   */
  public void setId (long newVar) { id = newVar; }

  /**
   * @brief Get the value of id
   * @return the value of id
   */
  public long getId () { return id; }

  /**
   * @brief Set the value of nom
   * @param newVar the new value of nom
   */
  public void setNom (String newVar) { nom = newVar; }

  /**
   * @brief Get the value of nom
   * @return the value of nom
   */
  public String getNom () { return nom; }

  /**
   * @brief Set the value of largeur
   * @param newVar the new value of largeur
   */
  public void setLargeur (int newVar) { largeur = newVar; }

  /**
   * @brief Get the value of largeur
   * @return the value of largeur
   */
  public int getLargeur () { return largeur; }

  /**
   * @brief Set the value of hauteur
   * @param newVar the new value of hauteur
   */
  public void setHauteur (int newVar) { hauteur = newVar; }

  /**
   * @brief Get the value of hauteur
   * @return the value of hauteur
   */
  public int getHauteur () { return hauteur; }

  /**
   * @brief Set the value of charVide
   * @param newVar the new value of charVide
   */
  public void setCharVide (char newVar) { charVide = newVar; }

  /**
   * @brief Get the value of charVide
   * @return the value of charVide
   */
  public char getCharVide () { return charVide; }

  /**
   * @brief Set the value of charPlein
   * @param newVar the new value of charPlein
   */
  public void setCharPlein (char newVar) { charPlein = newVar; }

  /**
   * @brief Get the value of charPlein
   * @return the value of charPlein
   */
  public char getCharPlein () { return charPlein; }

  /**
   * @brief Get the list of calques
   * @return the list of calques
   */
  public List<Layer> getCalques () { return calques; }

  //
  // Other methods
  //

  /**
   * @brief Ajoute un calque à la zone.
   * @param calque le calque à ajouter
   */
  public void ajouterCalque (Layer calque) {
    calques.add(calque);
  }

  /**
   * @brief Supprime un calque par son id.
   * @param idCalque l'identifiant du calque à supprimer
   * @return true si le calque a été trouvé et supprimé
   */
  public boolean supprimerCalque (long idCalque) {
    return calques.removeIf(c -> c.getId() == idCalque);
  }

  /**
   * @brief Recherche un calque par son id.
   * @param idCalque l'identifiant recherché
   * @return le calque trouvé, ou null si absent
   */
  public Layer trouverCalque (long idCalque) {
    for (Layer c : calques) {
      if (c.getId() == idCalque) return c;
    }
    return null;
  }

  /**
   * @brief Returns a string representation of the area.
   * @return       String
   */
  public String toString () {
    return "Area[id=" + id + ", nom=" + nom
           + ", " + largeur + "x" + hauteur
           + ", calques=" + calques.size() + "]";
  }

}
