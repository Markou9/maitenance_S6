package app;

import scene.Area;
import scene.IdGenerator;
import scene.Layer;
import shape.Shape;
import java.util.ArrayList;
import java.util.List;


/**
 * @file PixelTracerApp.java
 * @brief État global de l'application Pixel Tracer (équivalent de pixel_tracer.c).
 *
 * Centralise les pointeurs courants (area, calque, forme)
 * et la liste complète des zones de dessin.
 */
public class PixelTracerApp {

  public static final int LARGEUR_DEFAUT = 80;
  public static final int HAUTEUR_DEFAUT = 40;

  //
  // Fields
  //

  private List<Area> areas;
  private Area areaCourante;
  private Layer calqueCourant;
  private Shape formeCourante;

  //
  // Constructors
  //

  public PixelTracerApp () {
    this.areas = new ArrayList<>();
  }

  //
  // Methods
  //

  /**
   * @brief Initialise l'application avec une Area et un Layer par défaut.
   */
  public void init () {
    Area area = new Area(LARGEUR_DEFAUT, HAUTEUR_DEFAUT, IdGenerator.getNextId(), "Area1");
    Layer calque = new Layer(IdGenerator.getNextId(), "Layer 1");
    area.ajouterCalque(calque);
    areas.add(area);
    areaCourante   = area;
    calqueCourant  = calque;
    formeCourante  = null;
  }

  //
  // Accessor methods
  //

  /**
   * @brief Get the list of areas
   * @return the list of areas
   */
  public List<Area> getAreas () { return areas; }

  /**
   * @brief Set the value of areaCourante
   * @param newVar the new value of areaCourante
   */
  public void setAreaCourante (Area newVar) { areaCourante = newVar; }

  /**
   * @brief Get the value of areaCourante
   * @return the value of areaCourante
   */
  public Area getAreaCourante () { return areaCourante; }

  /**
   * @brief Set the value of calqueCourant
   * @param newVar the new value of calqueCourant
   */
  public void setCalqueCourant (Layer newVar) { calqueCourant = newVar; }

  /**
   * @brief Get the value of calqueCourant
   * @return the value of calqueCourant
   */
  public Layer getCalqueCourant () { return calqueCourant; }

  /**
   * @brief Set the value of formeCourante
   * @param newVar the new value of formeCourante
   */
  public void setFormeCourante (Shape newVar) { formeCourante = newVar; }

  /**
   * @brief Get the value of formeCourante
   * @return the value of formeCourante
   */
  public Shape getFormeCourante () { return formeCourante; }

}
