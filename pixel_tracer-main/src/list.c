/**
 * @file list.c
 * @brief Implémentation d’une liste doublement chaînée générique.
 * @details Ce module fournit une structure de liste chaînée avec insertion,
 * suppression et parcours de nœuds contenant des données génériques (void*).
 * @author Maryam et Younes
 * @date 2026
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "list.h"

/**
 * @brief Crée un nouveau nœud de liste.
 * @param dat Donnée stockée dans le nœud.
 * @return Pointeur vers le nœud créé.
 */
lnode *lst_create_lnode(void *dat) {
    lnode *ptmp = (lnode *) malloc(sizeof(lnode));
    ptmp->data = dat;
    ptmp->next = NULL;
    ptmp->prev = NULL;
    return ptmp;
}


/**
 * @brief Crée une liste vide.
 * @return Pointeur vers la liste créée.
 */
list *lst_create_list() {
    list *lst = (list *) malloc(sizeof(list));
    lst->head = NULL;
    lst->tail = NULL;
    return lst;
}


/**
 * @brief Détruit une liste et libère ses nœuds.
 * @param lst Liste à supprimer.
 */
void lst_delete_list(list * lst) {
    lst_erase(lst);
    free(lst);
}


/**
 * @brief Insère un nœud en tête de liste.
 * @param lst Liste cible.
 * @param pnew Nœud à insérer.
 */
void lst_insert_head(list * lst, lnode * pnew) {
    if (lst->head == NULL) {
        lst->head = pnew;
        lst->tail = pnew;
        return;
    }
    pnew->next = lst->head;
    pnew->prev = NULL;
    lst->head = pnew;
    pnew->next->prev = pnew;
}


/**
 * @brief Insère un nœud en queue de liste.
 * @param lst Liste cible.
 * @param pnew Nœud à insérer.
 */
void lst_insert_tail(list * lst, lnode * pnew) {
    if (lst->head == NULL) {
        lst->head = pnew;
        lst->tail = pnew;
        return;
    }
    pnew->next = NULL;
    pnew->prev = lst->tail;
    lst->tail = pnew;
    pnew->prev->next = pnew;
}


/**
 * @brief Insère un nœud après un autre nœud.
 * @param lst Liste cible.
 * @param pnew Nouveau nœud.
 * @param ptr Nœud de référence.
 */
void lst_insert_after(list * lst, lnode * pnew, lnode * ptr) {
    if (lst->head == NULL) {
        lst->head = pnew;
        lst->tail = pnew;
    } else if (ptr == NULL) {
        return;
    } else if (lst->tail == ptr) {
        lst_insert_tail(lst, pnew);
    } else {
        pnew->next = ptr->next;
        pnew->prev = ptr;
        pnew->next->prev = pnew;
        pnew->prev->next = pnew;
    }
}


/**
 * @brief Supprime le premier nœud de la liste.
 * @param lst Liste cible.
 */
void lst_delete_head(list * lst) {
    if (lst->head->next == NULL) {
        free(lst->head);
        lst->head = NULL;
        lst->tail = NULL;
        return;
    }
    lst->head = lst->head->next;
    free(lst->head->prev);
    lst->head->prev = NULL;
}


/**
 * @brief Supprime le dernier nœud de la liste.
 * @param lst Liste cible.
 */
void lst_delete_tail(list * lst) {
    if (lst->tail->prev == NULL) {
        free(lst->tail);
        lst->head = NULL;
        lst->tail = NULL;
        return;
    }
    lst->tail = lst->tail->prev;
    free(lst->tail->next);
    lst->tail->next = NULL;
}


/**
 * @brief Supprime un nœud précis de la liste.
 * @param lst Liste cible.
 * @param ptr Nœud à supprimer.
 */
void lst_delete_lnode(list * lst, lnode * ptr) {
    if (ptr == NULL)
        return;
    if (ptr == lst->head) {
        lst_delete_head(lst);
        return;
    }
    if (ptr == lst->tail) {
        lst_delete_tail(lst);
        return;
    }
    ptr->next->prev = ptr->prev;
    ptr->prev->next = ptr->next;
    free(ptr);
}


/**
 * @brief Vide complètement une liste.
 * @param lst Liste à vider.
 */
void lst_erase(list * lst) {
    if (lst->head == NULL)
        return;
    while (lst->head != lst->tail) {
        lst->head = lst->head->next;
        free(lst->head->prev);
    }
    free(lst->head);
    lst->head = NULL;
    lst->tail = NULL;
}


/**
 * @brief Retourne le premier nœud de la liste.
 * @param lst Liste cible.
 * @return Premier nœud ou NULL.
 */
lnode *get_first_node(list * lst) {
    if (lst->head == NULL)
        return NULL;
    return lst->head;
}


/**
 * @brief Retourne le dernier nœud de la liste.
 * @param lst Liste cible.
 * @return Dernier nœud ou NULL.
 */
lnode *get_last_node(list * lst) {
    if (lst->tail == NULL)
        return NULL;
    return lst->tail;
}


/**
 * @brief Retourne le nœud suivant.
 * @param lst Liste (non utilisé mais gardé pour cohérence API).
 * @param lnode Nœud courant.
 * @return Nœud suivant ou NULL.
 */
lnode *get_next_node(list * lst, lnode * lnode) {
    if (lnode == NULL)
        return NULL;
    return lnode->next;
}


/**
 * @brief Retourne le nœud précédent.
 * @param lst Liste (non utilisé mais gardé pour cohérence API).
 * @param lnode Nœud courant.
 * @return Nœud précédent ou NULL.
 */
void *get_previous_elem(list * lst, lnode * lnode) {
    if (lnode == NULL)
        return NULL;
    return lnode->prev;
}