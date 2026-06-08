package shape;
 
/**
<<<<<<< HEAD
 * @file Shape.java
 * @brief Classe abstraite de base pour toutes les formes géométriques.
 */
abstract public class Shape {

  //
  // Fields
  //

  private long id;
  private char fill;
  private float thickness;
  private int color;
  private double rotation;

  //
  // Constructors
  //
  public Shape () { };

  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * @brief Set the value of id
   * @param newVar the new value of id
   */
  public void setId (long newVar) {
    id = newVar;
  }

  /**
   * @brief Get the value of id
   * @return the value of id
   */
  public long getId () {
    return id;
  }

  /**
   * @brief Set the value of fill
   * @param newVar the new value of fill
   */
  public void setFill (char newVar) {
    fill = newVar;
  }

  /**
   * @brief Get the value of fill
   * @return the value of fill
   */
  public char getFill () {
    return fill;
  }

  /**
   * @brief Set the value of thickness
   * @param newVar the new value of thickness
   */
  public void setThickness (float newVar) {
    thickness = newVar;
  }

  /**
   * @brief Get the value of thickness
   * @return the value of thickness
   */
  public float getThickness () {
    return thickness;
  }

  /**
   * @brief Set the value of color
   * @param newVar the new value of color
   */
  public void setColor (int newVar) {
    color = newVar;
  }

  /**
   * @brief Get the value of color
   * @return the value of color
   */
  public int getColor () {
    return color;
  }

  /**
   * @brief Set the value of rotation
   * @param newVar the new value of rotation
   */
  public void setRotation (double newVar) {
    rotation = newVar;
  }

  /**
   * @brief Get the value of rotation
   * @return the value of rotation
   */
  public double getRotation () {
    return rotation;
  }

  //
  // Other methods
  //

  /**
   * @brief Returns a string representation of the shape.
   * @return       String
   */
  public String toString()
  {
    return "Shape[id=" + id + ", fill=" + fill + ", thickness=" + thickness + ", color=" + color + ", rotation=" + rotation + "]";
  }


=======
 * Classe abstraite représentant une forme géométrique générique.
 * Toutes les formes héritent de cette classe.
 */
abstract public class Shape {
 
    // -------------------------------------------------------------------------
    // Champs
    // -------------------------------------------------------------------------
 
    /** Identifiant unique de la forme. */
    private long id;
 
    /** Caractère utilisé pour remplir la forme lors du rendu. */
    private char fill;
 
    /** Épaisseur du contour. */
    private float thickness;
 
    /** Couleur de la forme (code entier). */
    private int color;
 
    /** Angle de rotation en degrés. */
    private double rotation;
 
    // -------------------------------------------------------------------------
    // Compteur global d'ID (remplace id.c)
    // -------------------------------------------------------------------------
 
    /** Compteur statique auto-incrémenté pour générer des ID uniques. */
    private static long nextId = 1;
 
    /**
     * Retourne et incrémente le prochain identifiant disponible.
     *
     * @return prochain ID unique
     */
    public static long getNextId() {
        return nextId++;
    }
 
    // -------------------------------------------------------------------------
    // Constructeurs
    // -------------------------------------------------------------------------
 
    /**
     * Constructeur par défaut.
     * Initialise l'ID automatiquement, la couleur à 0 (noir),
     * l'épaisseur à 1.0 et la rotation à 0.
     */
    public Shape() {
        this.id        = getNextId();
        this.color     = 0;
        this.thickness = 1.0f;
        this.rotation  = 0.0;
        this.fill      = '@';
    }
 
    // -------------------------------------------------------------------------
    // Accesseurs
    // -------------------------------------------------------------------------
 
    /** @param newVar nouvel identifiant */
    public void setId(long newVar)       { id = newVar; }
    /** @return identifiant de la forme */
    public long getId()                  { return id; }
 
    /** @param newVar nouveau caractère de remplissage */
    public void setFill(char newVar)     { fill = newVar; }
    /** @return caractère de remplissage */
    public char getFill()                { return fill; }
 
    /** @param newVar nouvelle épaisseur */
    public void setThickness(float newVar) { thickness = newVar; }
    /** @return épaisseur du contour */
    public float getThickness()          { return thickness; }
 
    /** @param newVar nouvelle couleur */
    public void setColor(int newVar)     { color = newVar; }
    /** @return couleur de la forme */
    public int getColor()                { return color; }
 
    /** @param newVar nouvel angle de rotation (degrés) */
    public void setRotation(double newVar) { rotation = newVar; }
    /** @return angle de rotation en degrés */
    public double getRotation()          { return rotation; }
 
    // -------------------------------------------------------------------------
    // Méthodes
    // -------------------------------------------------------------------------
 
    /**
     * Représentation textuelle de la forme.
     *
     * @return chaîne décrivant la forme
     */
    @Override
    public String toString() {
        return "Shape[id=" + id
             + ", fill=" + fill
             + ", thickness=" + thickness
             + ", color=" + color
             + ", rotation=" + rotation + "]";
    }
>>>>>>> 69c30e581e9ef21ebebe1c615df1175df3684726
}

