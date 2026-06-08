package shape;


/**
 * @file Point.java
 * @brief Classe représentant un point dans un espace 2D.
 */
public class Point extends Shape {

  //
  // Fields
  //

  private int pos_x;
  private int pos_y;

  //
  // Constructors
  //
  public Point () { };

  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * @brief Set the value of pos_x
   * @param newVar the new value of pos_x
   */
  public void setPos_x (int newVar) {
    pos_x = newVar;
  }

  /**
   * @brief Get the value of pos_x
   * @return the value of pos_x
   */
  public int getPos_x () {
    return pos_x;
  }

  /**
   * @brief Set the value of pos_y
   * @param newVar the new value of pos_y
   */
  public void setPos_y (int newVar) {
    pos_y = newVar;
  }

  /**
   * @brief Get the value of pos_y
   * @return the value of pos_y
   */
  public int getPos_y () {
    return pos_y;
  }

  //
  // Other methods
  //

  /**
   * @brief Returns a string representation of the point.
   * @return       String
   */
  public String toString()
  {
    return "Point[pos_x=" + pos_x + ", pos_y=" + pos_y + "]";
  }


}
