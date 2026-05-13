/**
 * @file layers.c
 * @brief Gestion des calques et des listes de calques.
 * @details Ce module permet de créer, manipuler et supprimer des calques,
 * ainsi que d’ajouter ou retirer des formes dans chaque calque.
 * @author Maryam et Younes
 * @date 2026
 */

#include "layers.h"

/**
 * @brief Alloue un calque et initialise les formes comme visibles.
 * @param id Identifiant du calque.
 * @param name Nom du calque.
 * @return Pointeur vers le calque créé.
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
 * @brief Supprime un calque et libère la liste de formes.
 * @param layer Calque à supprimer.
 */
void delete_layer(Layer * layer) {
    lst_erase(&layer->shapes);
    free(layer);
}


/**
 * @brief Crée une nouvelle liste chaînée de calques.
 * @return Liste de calques créée.
 */
LayersList *create_layers_list() {
    LayersList *lst_layer;
    lst_layer = lst_create_list();
    return lst_layer;
}


/**
 * @brief Supprime une liste de calques.
 * @param layer_list Liste de calques à supprimer.
 */
void delete_layers_list(LayersList * layer_list) {
    lst_delete_list(layer_list);
}


/**
 * @brief Ajoute un calque en queue de liste.
 * @param layer_list Liste de calques.
 * @param layer Calque à ajouter.
 */
void add_layer_to_list(LayersList * layer_list, Layer * layer) {
    lnode *l = lst_create_lnode(layer);
    lst_insert_tail(layer_list, l);
}


/**
 * @brief Supprime un calque de la liste.
 * @param layer_list Liste de calques.
 * @param layer Calque à supprimer.
 */
void remove_layer_from_list(LayersList * layer_list, Layer * layer) {
    /* TODO  */
}


/**
 * @brief Active la visibilité d’un calque.
 * @param layer Calque à rendre visible.
 */
void set_layer_visible(Layer * layer) {
    layer->visible = LAYER_VISIBLE;
}


/**
 * @brief Désactive la visibilité d’un calque.
 * @param layer Calque à rendre invisible.
 */
void set_layer_unvisible(Layer * layer) {
    layer->visible = LAYER_UNVISIBLE;
}


/**
 * @brief Ajoute une forme à un calque.
 * @param layer Calque cible.
 * @param shape Forme à ajouter.
 */
void add_shape_to_layer(Layer * layer, Shape * shape) {
    lnode *l = lst_create_lnode(shape);
    lst_insert_tail(&(layer->shapes), l);
}


/**
 * @brief Supprime une forme d’un calque.
 * @param layer Calque concerné.
 * @param shape Forme à supprimer.
 */
void remove_shape_to_from(Layer * layer, Shape * shape) {

}