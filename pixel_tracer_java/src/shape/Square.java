package shape;


/**
 * @file Square.java
 * @brief Classe représentant un carré défini par un point d'origine et une longueur de côté.
 */
public class Square extends Shape {

  //
  // Fields
  //

  private shape.Point p1;
  private int length;

  //
  // Constructors
  //
  public Square () { };

  //
  // Accessor methods
  //

  /**
   * @brief Set the value of p1
   * @param newVar the new value of p1
   */
  public void setP1 (shape.Point newVar) {
    p1 = newVar;
  }

  /**
   * @brief Get the value of p1
   * @return the value of p1
   */
  public shape.Point getP1 () {
    return p1;
  }

  /**
   * @brief Set the value of length
   * @param newVar the new value of length
   */
  public void setLength (int newVar) {
    length = newVar;
  }

  /**
   * @brief Get the value of length
   * @return the value of length
   */
  public int getLength () {
    return length;
  }

  //
  // Other methods
  //

  /**
   * @brief Returns a string representation of the square.
   * @return       String
   */
  public String toString () {
    return "Square[p1=" + p1 + ", length=" + length + "]";
  }

}
