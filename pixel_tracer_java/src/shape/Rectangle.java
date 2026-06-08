package shape;


/**
 * @file Rectangle.java
 * @brief Classe représentant un rectangle défini par un point d'origine, une largeur et une hauteur.
 */
public class Rectangle extends Shape {

  //
  // Fields
  //

  private shape.Point p1;
  private int width;
  private int height;

  //
  // Constructors
  //
  public Rectangle () { };

  //
  // Methods
  //


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
   * @brief Set the value of width
   * @param newVar the new value of width
   */
  public void setWidth (int newVar) {
    width = newVar;
  }

  /**
   * @brief Get the value of width
   * @return the value of width
   */
  public int getWidth () {
    return width;
  }

  /**
   * @brief Set the value of height
   * @param newVar the new value of height
   */
  public void setHeight (int newVar) {
    height = newVar;
  }

  /**
   * @brief Get the value of height
   * @return the value of height
   */
  public int getHeight () {
    return height;
  }

  //
  // Other methods
  //

  /**
   * @brief Returns a string representation of the rectangle.
   * @return       String
   */
  public String toString()
  {
    return "Rectangle[p1=" + p1 + ", width=" + width + ", height=" + height + "]";
  }


}
