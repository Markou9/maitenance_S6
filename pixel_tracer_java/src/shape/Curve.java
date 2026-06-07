package shape;


/**
 * @file Curve.java
 * @brief Classe représentant une courbe de Bézier cubique définie par 4 points de contrôle.
 */
public class Curve extends Shape {

  //
  // Fields
  //

  private shape.Point p1;
  private shape.Point p2;
  private shape.Point p3;
  private shape.Point p4;

  //
  // Constructors
  //
  public Curve () { };

  //
  // Accessor methods
  //

  /**
   * @brief Set the value of p1
   * @param newVar the new value of p1
   */
  public void setP1 (shape.Point newVar) { p1 = newVar; }

  /**
   * @brief Get the value of p1
   * @return the value of p1
   */
  public shape.Point getP1 () { return p1; }

  /**
   * @brief Set the value of p2
   * @param newVar the new value of p2
   */
  public void setP2 (shape.Point newVar) { p2 = newVar; }

  /**
   * @brief Get the value of p2
   * @return the value of p2
   */
  public shape.Point getP2 () { return p2; }

  /**
   * @brief Set the value of p3
   * @param newVar the new value of p3
   */
  public void setP3 (shape.Point newVar) { p3 = newVar; }

  /**
   * @brief Get the value of p3
   * @return the value of p3
   */
  public shape.Point getP3 () { return p3; }

  /**
   * @brief Set the value of p4
   * @param newVar the new value of p4
   */
  public void setP4 (shape.Point newVar) { p4 = newVar; }

  /**
   * @brief Get the value of p4
   * @return the value of p4
   */
  public shape.Point getP4 () { return p4; }

  //
  // Other methods
  //

  /**
   * @brief Returns a string representation of the curve.
   * @return       String
   */
  public String toString () {
    return "Curve[p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + ", p4=" + p4 + "]";
  }

}
