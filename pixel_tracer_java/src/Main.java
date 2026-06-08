import app.Command;
import app.CommandExecutor;
import app.CommandParser;
import app.PixelTracerApp;
import render.ConsoleRenderer;
import java.util.Scanner;

/**
 * @file Main.java
 * @brief Point d'entrée de l'application Pixel Tracer.
 *
 * Lance la boucle interactive : lecture de commandes,
 * exécution, et affichage console.
 */
public class Main {

    public static void main(String[] args) {
        PixelTracerApp app = new PixelTracerApp();
        app.init();

        CommandParser  parser   = new CommandParser();
        CommandExecutor executor = new CommandExecutor();
        ConsoleRenderer renderer = new ConsoleRenderer();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Pixel Tracer — tapez 'help' pour la liste des commandes.");

        while (true) {
            System.out.print("> ");
            if (!scanner.hasNextLine()) break;
            String ligne = scanner.nextLine();

            Command cmd = parser.parser(ligne);
            int code = executor.executer(app, cmd);

            switch (code) {
                case 4 -> { System.out.println("Au revoir."); return; }
                case 5 -> renderer.effacerEcran();
                case 6 -> renderer.dessiner(app.getAreaCourante());
                case 3 -> System.out.println("Paramètres invalides.");
                case 9 -> System.out.println("Identifiant inconnu.");
                default -> { /* rien */ }
            }
        }

        scanner.close();
    }
}
