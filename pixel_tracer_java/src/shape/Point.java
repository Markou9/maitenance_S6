package shape;
 
/**
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
}

