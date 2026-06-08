package shape;
 
/**
<<<<<<< HEAD
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


=======
 * Représente un cercle défini par un centre et un rayon.
 * Le rendu utilise l'algorithme du point médian (Bresenham cercle)
 * en exploitant la symétrie en 8 secteurs.
 */
public class Circle extends Shape {
 
    // -------------------------------------------------------------------------
    // Champs
    // -------------------------------------------------------------------------
 
    /** Point central du cercle. */
    private Point center;
 
    /** Rayon du cercle (en pixels). */
    private int radius;
 
    // -------------------------------------------------------------------------
    // Constructeurs
    // -------------------------------------------------------------------------
 
    /**
     * Constructeur par défaut (centre à null, rayon à 0).
     */
    public Circle() {
        super();
        this.center = null;
        this.radius = 0;
    }
 
    /**
     * Constructeur avec centre et rayon.
     *
     * @param center point central du cercle
     * @param radius rayon en pixels
     */
    public Circle(Point center, int radius) {
        super();
        this.center = center;
        this.radius = radius;
    }
 
    /**
     * Constructeur avec coordonnées du centre et rayon.
     *
     * @param cx     coordonnée X du centre
     * @param cy     coordonnée Y du centre
     * @param radius rayon en pixels
     */
    public Circle(int cx, int cy, int radius) {
        super();
        this.center = new Point(cx, cy);
        this.radius = radius;
    }
 
    // -------------------------------------------------------------------------
    // Accesseurs
    // -------------------------------------------------------------------------
 
    /** @param newVar nouveau centre */
    public void setCenter(Point newVar) { center = newVar; }
    /** @return centre du cercle */
    public Point getCenter()            { return center; }
 
    /** @param newVar nouveau rayon */
    public void setRadius(int newVar)   { radius = newVar; }
    /** @return rayon du cercle */
    public int getRadius()              { return radius; }
 
    // -------------------------------------------------------------------------
    // Méthodes
    // -------------------------------------------------------------------------
 
    /**
     * Représentation textuelle du cercle.
     *
     * @return "Circle[center=..., radius=R]"
     */
    @Override
    public String toString() {
        return "Circle[center=" + center + ", radius=" + radius + "]";
    }
>>>>>>> 69c30e581e9ef21ebebe1c615df1175df3684726
}

