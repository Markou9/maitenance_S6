/**
 * @file pixel_tracer.c
 * @brief Initialisation et destruction de l’application Pixel Tracer.
 * @details Ce module gère la création de l’environnement de base (aire, calques)
 * ainsi que la libération des ressources de l’application.
 * @author Maryam et Younes
 * @date 2026
 */

#include "pixel_tracer.h"

/**
 * @brief Initialise l’application avec une aire et un calque par défaut.
 * @details Crée une aire "Area1", un calque "Layer 1" et initialise les pointeurs
 * principaux de l’application.
 * @param app Application Pixel Tracer à initialiser.
 */
void init_app(Pixel_tracer_app * app) {
    app->list_area = create_area_list();
    Area *area = create_area(80, 40, get_next_id(), "Area1");
    add_area_to_list(app->list_area, area);
    app->current_area = area;

    LayersList *layerlst = create_layers_list();
    area->lst_layers = layerlst;
    Layer *layer = create_layer(get_next_id(), "Layer 1");
    add_layer_to_list(layerlst, layer);
    app->current_layer = layer;
    app->current_shape = NULL;
}


/**
 * @brief Libère les ressources de l’application.
 * @details Supprime la liste des aires et remet tous les pointeurs internes à NULL.
 * @param app Application Pixel Tracer à détruire.
 */
void destry_app(Pixel_tracer_app * app) {
    delete_area_list(app->list_area);
    app->current_area = NULL;
    app->current_layer = NULL;
    app->current_shape = NULL;
}