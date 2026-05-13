/**
 * @file area.c
 * @brief Gestion des aires et des listes d’aires.
 * @details Ce fichier contient les fonctions de création, suppression et manipulation
 * des aires (grilles) ainsi que des listes chaînées d’aires.
 * @author Maryam et Younes
 * @date 2026
 */

#include "area.h"

/**
 * @brief Alloue et initialise une aire avec sa grille et une liste de calques vide.
 * @param width Largeur de l’aire.
 * @param height Hauteur de l’aire.
 * @param id Identifiant de l’aire.
 * @param name Nom de l’aire.
 * @return Pointeur vers l’aire créée.
 */
Area *create_area(unsigned int width,
                  unsigned int height, unsigned char id, char *name) {
    Area *ptr_area = (Area *) malloc(sizeof(Area));
    ptr_area->width = width;
    ptr_area->height = height;
    ptr_area->lst_layers = create_layers_list();
    ptr_area->id = id;
    ptr_area->empty_char = '.';
    ptr_area->full_char = '@';
    strcpy(ptr_area->name, name);
    ptr_area->area = (char **) malloc(height * sizeof(char *));
    for (unsigned int i = 0; i < ptr_area->height; i++) {
        ptr_area->area[i] = (char *) malloc(width * sizeof(char));
    }
    return ptr_area;
}


/**
 * @brief Libère la grille et les calques.
 * @param area Aire à supprimer.
 */
void delete_area(Area * area) {
    // todo: delate layers
    for (unsigned int i = 0; i < area->height; i++) {
        free(area->area[i]);
    }
    free(area);
}


/**
 * @brief Crée une liste chaînée d’aires.
 * @return Liste d’aires créée.
 */
AreaList *create_area_list() {
    AreaList *lst_area;
    lst_area = lst_create_list();
    return lst_area;
}


/**
 * @brief Supprime la liste et libère les aires.
 * @param area_list Liste à supprimer.
 */
void delete_area_list(AreaList * area_list) {
    /* TODO : delete all layers on the list */
    lst_delete_list(area_list);
}


/**
 * @brief Insère une aire en queue de liste.
 * @param area_list Liste d’aires.
 * @param area Aire à ajouter.
 */
void add_area_to_list(AreaList * area_list, Area * area) {
    lnode *l = lst_create_lnode(area);
    lst_insert_tail(area_list, l);
}


/**
 * @brief Supprime une aire de la liste.
 * @param area_list Liste d’aires.
 * @param area Aire à supprimer.
 */
void remove_area_from_list(AreaList * area_list, Area * area) {
    /* TODO  */
}