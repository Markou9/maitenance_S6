package scene;

import shape.Shape;
import java.util.ArrayList;
import java.util.List;


/**
 * @file Layer.java
 * @brief Représente un calque contenant des formes géométriques (équivalent de layers.c).
 *
 * Un calque peut être rendu visible ou invisible.
 * Il contient une liste ordonnée de formes.
 */
public class Layer {

  //
  // Fields
  //

  private long id;
  private String nom;
  private boolean visible;
  private List<Shape> formes;

  //
  // Constructors
  //

  public Layer (long id, String nom) {
    this.id      = id;
    this.nom     = nom;
    this.visible = true;
    this.formes  = new ArrayList<>();
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
   * @brief Set the value of visible
   * @param newVar the new value of visible
   */
  public void setVisible (boolean newVar) { visible = newVar; }

  /**
   * @brief Get the value of visible
   * @return the value of visible
   */
  public boolean isVisible () { return visible; }

  /**
   * @brief Get the list of shapes
   * @return the list of shapes
   */
  public List<Shape> getFormes () { return formes; }

  //
  // Other methods
  //

  /**
   * @brief Ajoute une forme au calque.
   * @param forme la forme à ajouter
   */
  public void ajouterForme (Shape forme) {
    formes.add(forme);
  }

  /**
   * @brief Supprime une forme du calque par son id.
   * @param idForme l'identifiant de la forme à supprimer
   * @return true si la forme a été trouvée et supprimée
   */
  public boolean supprimerForme (long idForme) {
    return formes.removeIf(f -> f.getId() == idForme);
  }

  /**
   * @brief Returns a string representation of the layer.
   * @return       String
   */
  public String toString () {
    char vis = visible ? 'V' : 'H';
    return "Layer[id=" + id + ", nom=" + nom + ", visible=" + vis
           + ", formes=" + formes.size() + "]";
  }

}
