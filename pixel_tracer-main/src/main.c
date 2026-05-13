/**
 * @file main.c
 * @brief Point d’entrée de l’application Pixel Tracer.
 * @details Lance l’initialisation de l’application, puis exécute la boucle principale
 * de lecture et d’exécution des commandes utilisateur. Gère également le rendu et
 * les codes de retour du système de commandes.
 * @author Maryam et Younes
 * @date 2026
 */

#include <stdio.h>
#include <stdlib.h>
#include "pixel_tracer.h"
#include "command.h"


/**
 * @brief Fonction principale du programme.
 * @return Code de sortie du programme.
 */
int main() {
    Pixel_tracer_app app;
    init_app(&app);
    clear_screen();
    draw_all_layers(app.current_area);
    draw_area(app.current_area);

    while (1) {
        int err = read_exec_command(&app);
        if (err == 0 || err == 6) {
            clear_screen();
            draw_all_layers(app.current_area);  // make pixels
            draw_area(app.current_area);        // render
        }
        if (err == 6) {
            clear_screen();
            draw_all_layers(app.current_area);  // make pixels
            draw_area(app.current_area);        // render
        }
        if (err == 4) {
            break;
        }
        if (err == 5) {
            clear_screen();
        }
        if (err == 7 || err == 8) {
            continue;
        }
    }

    destry_app(&app);
}