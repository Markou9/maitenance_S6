package shape;
 
/**
 * Représente un segment de droite défini par deux points.
 * Le rendu utilise l'algorithme de Bresenham pour rasteriser
 * la ligne en pixels.
 */
public class Line extends Shape {
 
    // -------------------------------------------------------------------------
    // Champs
    // -------------------------------------------------------------------------
 
    /** Point de départ du segment. */
    private Point p1;
 
    /** Point d'arrivée du segment. */
    private Point p2;
 
    // -------------------------------------------------------------------------
    // Constructeurs
    // -------------------------------------------------------------------------
 
    /**
     * Constructeur par défaut (points à null).
     */
    public Line() {
        super();
        this.p1 = null;
        this.p2 = null;
    }
 
    /**
     * Constructeur avec les deux points extrémités.
     *
     * @param p1 point de départ
     * @param p2 point d'arrivée
     */
    public Line(Point p1, Point p2) {
        super();
        this.p1 = p1;
        this.p2 = p2;
    }
 
    /**
     * Constructeur avec coordonnées directes.
     *
     * @param x1 X du point de départ
     * @param y1 Y du point de départ
     * @param x2 X du point d'arrivée
     * @param y2 Y du point d'arrivée
     */
    public Line(int x1, int y1, int x2, int y2) {
        super();
        this.p1 = new Point(x1, y1);
        this.p2 = new Point(x2, y2);
    }
 
    // -------------------------------------------------------------------------
    // Accesseurs
    // -------------------------------------------------------------------------
 
    /** @param newVar nouveau point de départ */
    public void setP1(Point newVar) { p1 = newVar; }
    /** @return point de départ */
    public Point getP1()            { return p1; }
 
    /** @param newVar nouveau point d'arrivée */
    public void setP2(Point newVar) { p2 = newVar; }
    /** @return point d'arrivée */
    public Point getP2()            { return p2; }
 
    // -------------------------------------------------------------------------
    // Méthodes
    // -------------------------------------------------------------------------
 
    /**
     * Représentation textuelle de la ligne.
     *
     * @return "Line[p1=..., p2=...]"
     */
    @Override
    public String toString() {
        return "Line[p1=" + p1 + ", p2=" + p2 + "]";
    }
}

