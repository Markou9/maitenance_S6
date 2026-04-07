#include "pixel_tracer.h"


/**
 * Crée l'aire 'Area1', un calque 'Layer 1'
 * et initialise les pointeurs de l'application
 * @param app
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
 * Libère la mémoire de la liste d'aires et met les pointeurs à null
 * @param app
 */
void destry_app(Pixel_tracer_app * app) {
    delete_area_list(app->list_area);
    app->current_area = NULL;
    app->current_layer = NULL;
    app->current_shape = NULL;
}
