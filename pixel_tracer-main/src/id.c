/**
 * @file id.c
 * @brief Gestion des identifiants uniques globaux.
 * @details Ce module permet de générer, modifier, sauvegarder et charger un identifiant global
 * utilisé pour attribuer des IDs uniques aux objets du programme.
 * @author Maryam et Younes
 * @date 2026
 */

#include "id.h"

static unsigned long long int global_id = 0;

/**
 * @brief Retourne le prochain identifiant unique.
 * @return Nouvel identifiant généré.
 */
unsigned long long int get_next_id() {
    global_id++;
    return global_id;
}

/**
 * @brief Définit la valeur actuelle de l’identifiant global.
 * @param id Nouvelle valeur de l’identifiant.
 */
void set_id(unsigned long long int id) {
    global_id = id;
}

/**
 * @brief Sauvegarde l’identifiant global dans un fichier.
 * @details Fonction non encore implémentée.
 */
void save_id() {
    // todo save id in file ID_FILE
}

/**
 * @brief Charge l’identifiant global depuis un fichier.
 * @details Fonction non encore implémentée.
 */
void load_id() {
    // todo load id from file ID_FILE
}