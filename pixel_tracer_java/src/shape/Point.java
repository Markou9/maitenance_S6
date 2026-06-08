package shape;
 
/**
<<<<<<< HEAD
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


=======
 * Représente un point dans un espace 2D discret.
 * Un point est la forme géométrique la plus simple :
 * il correspond à un unique pixel lors du rendu.
 */
public class Point extends Shape {
 
    // -------------------------------------------------------------------------
    // Champs
    // -------------------------------------------------------------------------
 
    /** Coordonnée X (colonne). */
    private int pos_x;
 
    /** Coordonnée Y (ligne). */
    private int pos_y;
 
    // -------------------------------------------------------------------------
    // Constructeurs
    // -------------------------------------------------------------------------
 
    /**
     * Constructeur par défaut (coordonnées à 0).
     */
    public Point() {
        super();
        this.pos_x = 0;
        this.pos_y = 0;
    }
 
    /**
     * Constructeur avec coordonnées.
     *
     * @param x coordonnée X (colonne)
     * @param y coordonnée Y (ligne)
     */
    public Point(int x, int y) {
        super();
        this.pos_x = x;
        this.pos_y = y;
    }
 
    // -------------------------------------------------------------------------
    // Accesseurs
    // -------------------------------------------------------------------------
 
    /** @param newVar nouvelle coordonnée X */
    public void setPos_x(int newVar) { pos_x = newVar; }
    /** @return coordonnée X */
    public int getPos_x()            { return pos_x; }
 
    /** @param newVar nouvelle coordonnée Y */
    public void setPos_y(int newVar) { pos_y = newVar; }
    /** @return coordonnée Y */
    public int getPos_y()            { return pos_y; }
 
    // -------------------------------------------------------------------------
    // Méthodes
    // -------------------------------------------------------------------------
 
    /**
     * Représentation textuelle du point.
     *
     * @return "Point[pos_x=X, pos_y=Y]"
     */
    @Override
    public String toString() {
        return "Point[pos_x=" + pos_x + ", pos_y=" + pos_y + "]";
    }
>>>>>>> 69c30e581e9ef21ebebe1c615df1175df3684726
}

