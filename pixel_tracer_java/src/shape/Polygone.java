package shape;
 
import java.util.ArrayList;
 
/**
 * Représente un polygone défini par une liste ordonnée de sommets.
 * Le rendu trace un segment entre chaque paire de points consécutifs
 * de la liste.
 */
public class Polygone extends Shape {
 
    // -------------------------------------------------------------------------
    // Champs
    // -------------------------------------------------------------------------
 
    /** Liste ordonnée des sommets du polygone. */
    private ArrayList<Point> points;
 
    // -------------------------------------------------------------------------
    // Constructeurs
    // -------------------------------------------------------------------------
 
    /**
     * Constructeur par défaut (liste de sommets vide).
     */
    public Polygone() {
        super();
        this.points = new ArrayList<>();
    }
 
    /**
     * Constructeur avec une liste de sommets existante.
     *
     * @param points liste de points formant le polygone
     */
    public Polygone(ArrayList<Point> points) {
        super();
        this.points = points;
    }
 
    /**
     * Constructeur à partir d'un tableau de coordonnées entières.
     * Le tableau doit contenir des paires (x, y) successives ;
     * sa taille doit donc être paire.
     *
     * @param coords tableau [x0, y0, x1, y1, ...]
     * @throws IllegalArgumentException si le nombre de valeurs est impair
     */
    public Polygone(int[] coords) {
        super();
        if (coords.length % 2 != 0) {
            throw new IllegalArgumentException(
                "Le tableau de coordonnées doit avoir un nombre pair de valeurs.");
        }
        this.points = new ArrayList<>();
        for (int i = 0; i < coords.length; i += 2) {
            this.points.add(new Point(coords[i], coords[i + 1]));
        }
    }
 
    // -------------------------------------------------------------------------
    // Accesseurs
    // -------------------------------------------------------------------------
 
    /** @param newVar nouvelle liste de sommets */
    public void setPoints(ArrayList<Point> newVar) { points = newVar; }
    /** @return liste des sommets */
    public ArrayList<Point> getPoints()            { return points; }
 
    // -------------------------------------------------------------------------
    // Méthodes
    // -------------------------------------------------------------------------
 
    /**
     * Ajoute un sommet en fin de liste.
     *
     * @param p point à ajouter
     */
    public void addPoint(Point p) {
        points.add(p);
    }
 
    /**
     * Retourne le nombre de sommets du polygone.
     *
     * @return nombre de sommets
     */
    public int getNbPoints() {
        return points.size();
    }
 
    /**
     * Retourne le sommet à l'index donné.
     *
     * @param index position dans la liste
     * @return point à cet index
     */
    public Point getPoint(int index) {
        return points.get(index);
    }
 
    /**
     * Représentation textuelle du polygone.
     *
     * @return "Polygone[points=[...]]"
     */
    @Override
    public String toString() {
        return "Polygone[points=" + points + "]";
    }
}

