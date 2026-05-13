package shape;
 
/**
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
}

