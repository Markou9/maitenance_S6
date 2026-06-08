package shape;

import java.util.ArrayList;


/**
 * @file Polygone.java
 * @brief Classe représentant un polygone défini par une liste de points.
 */
public class Polygone extends Shape {

  //
  // Fields
  //

  private ArrayList<Point> points;

  //
  // Constructors
  //
  public Polygone () { };

  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * @brief Set the value of points
   * @param newVar the new value of points
   */
  public void setPoints (ArrayList<Point> newVar) {
    points = newVar;
  }

  /**
   * @brief Get the value of points
   * @return the value of points
   */
  public ArrayList<Point> getPoints () {
    return points;
  }

  //
  // Other methods
  //

  /**
   * @brief Returns a string representation of the polygon.
   * @return       String
   */
  public String toString()
  {
    return "Polygone[points=" + points + "]";
  }


}
