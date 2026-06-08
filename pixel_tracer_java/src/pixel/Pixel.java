package pixel;

<<<<<<< HEAD

/**
 * @file Pixel.java
 * @brief Représente un pixel positionné dans la grille avec sa couleur.
 */
public class Pixel {

  //
  // Fields
  //

  private int x;
  private int y;
  private int color;

  //
  // Constructors
  //

  public Pixel (int x, int y, int color) {
    this.x = x;
    this.y = y;
    this.color = color;
  }

  //
  // Accessor methods
  //

  /**
   * @brief Set the value of x
   * @param newVar the new value of x
   */
  public void setX (int newVar) { x = newVar; }

  /**
   * @brief Get the value of x
   * @return the value of x
   */
  public int getX () { return x; }

  /**
   * @brief Set the value of y
   * @param newVar the new value of y
   */
  public void setY (int newVar) { y = newVar; }

  /**
   * @brief Get the value of y
   * @return the value of y
   */
  public int getY () { return y; }

  /**
   * @brief Set the value of color
   * @param newVar the new value of color
   */
  public void setColor (int newVar) { color = newVar; }

  /**
   * @brief Get the value of color
   * @return the value of color
   */
  public int getColor () { return color; }

  //
  // Other methods
  //

  /**
   * @brief Returns a string representation of the pixel.
   * @return       String
   */
  public String toString () {
    return "Pixel[x=" + x + ", y=" + y + ", color=" + color + "]";
  }

=======
import shape.Color;

public class Pixel {
    public int px;
    public int py;
    public Color color;

    public Pixel(int px, int py, Color color) {
        this.px = px;
        this.py = py;
        this.color = color;
    }
>>>>>>> 69c30e581e9ef21ebebe1c615df1175df3684726
}
