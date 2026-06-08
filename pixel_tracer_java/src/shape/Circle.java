package shape;


/**
 * @file Circle.java
 * @brief Classe représentant un cercle défini par son centre.
 */
public class Circle extends Shape {

  //
  // Fields
  //

  private shape.Point center;
  private int radius;

  //
  // Constructors
  //
  public Circle () { };

  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * @brief Set the value of center
   * @param newVar the new value of center
   */
  public void setCenter (shape.Point newVar) {
    center = newVar;
  }

  /**
   * @brief Get the value of center
   * @return the value of center
   */
  public shape.Point getCenter () {
    return center;
  }

  /**
   * @brief Set the value of radius
   * @param newVar the new value of radius
   */
  public void setRadius (int newVar) {
    radius = newVar;
  }

  /**
   * @brief Get the value of radius
   * @return the value of radius
   */
  public int getRadius () {
    return radius;
  }

  //
  // Other methods
  //

  /**
   * @brief Returns a string representation of the circle.
   * @return       String
   */
  public String toString()
  {
    return "Circle[center=" + center + ", radius=" + radius + "]";
  }


}
