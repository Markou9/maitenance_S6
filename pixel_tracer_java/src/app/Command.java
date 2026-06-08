package app;

import java.util.ArrayList;
import java.util.List;


/**
 * @file Command.java
 * @brief Représente une commande saisie par l'utilisateur (équivalent de la structure Command en C).
 *
 * Stocke le nom de la commande ainsi que ses paramètres
 * (chaînes, entiers, flottants) extraits par le CommandParser.
 */
public class Command {

  //
  // Fields
  //

  private String nom;
  private List<String> paramsStr;
  private List<Integer> paramsInt;
  private List<Float> paramsFloat;

  //
  // Constructors
  //

  public Command () {
    this.nom        = "";
    this.paramsStr   = new ArrayList<>();
    this.paramsInt   = new ArrayList<>();
    this.paramsFloat = new ArrayList<>();
  }

  //
  // Accessor methods
  //

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
   * @brief Get the list of string parameters
   * @return the list of string parameters
   */
  public List<String> getParamsStr () { return paramsStr; }

  /**
   * @brief Get the list of integer parameters
   * @return the list of integer parameters
   */
  public List<Integer> getParamsInt () { return paramsInt; }

  /**
   * @brief Get the list of float parameters
   * @return the list of float parameters
   */
  public List<Float> getParamsFloat () { return paramsFloat; }

  //
  // Other methods
  //

  /**
   * @brief Ajoute un paramètre entier.
   * @param val la valeur entière à ajouter
   */
  public void ajouterInt (int val) { paramsInt.add(val); }

  /**
   * @brief Ajoute un paramètre chaîne.
   * @param val la chaîne à ajouter
   */
  public void ajouterStr (String val) { paramsStr.add(val); }

  /**
   * @brief Ajoute un paramètre flottant.
   * @param val la valeur flottante à ajouter
   */
  public void ajouterFloat (float val) { paramsFloat.add(val); }

  /**
   * @brief Returns a string representation of the command.
   * @return       String
   */
  public String toString () {
    return "Command[nom=" + nom
           + ", str=" + paramsStr
           + ", int=" + paramsInt
           + ", float=" + paramsFloat + "]";
  }

}
