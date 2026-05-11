#include "layers.h"

/**
 * Alloue un calque et initialise les formes comme visible
 * 
 * @param id
 * @param name
 */
Layer *create_layer(int id, char *name) {
    Layer *ptr_layer = (Layer *) malloc(sizeof(Layer));
    ptr_layer->id = id;
    strcpy(ptr_layer->name, name);
    ptr_layer->shapes = *lst_create_list();
    ptr_layer->visible = 1;
    return ptr_layer;
}


/**
 * Efface la liste de formes et libère le calque
 * 
 * @param layer
 */
void delete_layer(Layer * layer) {
    lst_erase(&layer->shapes);
    free(layer);
}


/**
 * Crée une nouvelle liste chaînée de calques
 * 
 */
LayersList *create_layers_list() {
    LayersList *lst_layer;
    lst_layer = lst_create_list();
    return lst_layer;
}


/**
 * Supprime la liste de calques
 * 
 * @param layer_list
 */
void delete_layers_list(LayersList * layer_list) {
    lst_delete_list(layer_list);
}


/**
 * Ajoute un calque en queue de liste
 * 
 * @param layer_list
 * @param layer
 */
void add_layer_to_list(LayersList * layer_list, Layer * layer) {
    lnode *l = lst_create_lnode(layer);
    lst_insert_tail(layer_list, l);
}


/**
 * Supprime un calque en queue de liste
 * 
 * @param layer_list
 * @param layer
 */
void remove_layer_from_list(LayersList * layer_list, Layer * layer) {
    /* TODO  */
}


/**
 * Passe le calque en visible
 * 
 * @param layer
 */
void set_layer_visible(Layer * layer) {
    layer->visible = LAYER_VISIBLE;
}


void set_layer_unvisible(Layer * layer) {
    layer->visible = LAYER_UNVISIBLE;
}


/**
 * Ajoute une forme en queue de la liste du calque
 * 
 * @param layer
 * @param shape
 */
void add_shape_to_layer(Layer * layer, Shape * shape) {
    lnode *l = lst_create_lnode(shape);
    lst_insert_tail(&(layer->shapes), l);
}


/**
 * Supprime une forme en queue de la liste du calque
 * 
 * @param layer
 * @param shape
 */
void remove_shape_to_from(Layer * layer, Shape * shape) {

}
