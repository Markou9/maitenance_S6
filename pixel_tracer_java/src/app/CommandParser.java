package app;


/**
 * @file CommandParser.java
 * @brief Transforme une ligne de texte en objet Command (équivalent de la partie parsing de command.c).
 *
 * La ligne est découpée en tokens séparés par des espaces.
 * Le premier token est le nom de la commande,
 * les suivants sont classés comme entiers, flottants ou chaînes.
 * Les commentaires (à partir de '#') et la casse sont ignorés.
 */
public class CommandParser {

  /**
   * @brief Parse une ligne de saisie utilisateur en Command.
   * @param ligne la ligne brute entrée par l'utilisateur
   * @return l'objet Command correspondant, ou null si la ligne est vide
   */
  public Command parser (String ligne) {
    if (ligne == null) return null;

    String nettoyee = nettoyer(ligne);
    if (nettoyee.isBlank()) return null;

    String[] tokens = nettoyee.trim().split("\\s+");
    if (tokens.length == 0) return null;

    Command cmd = new Command();
    cmd.setNom(tokens[0]);

    for (int i = 1; i < tokens.length; i++) {
      String tok = tokens[i];
      if (estEntier(tok)) {
        cmd.ajouterInt(Integer.parseInt(tok));
      } else if (estFlottant(tok)) {
        cmd.ajouterFloat(Float.parseFloat(tok));
      } else {
        cmd.ajouterStr(tok);
      }
    }

    return cmd;
  }

  // -------------------------------------------------------------------------
  // Méthodes utilitaires
  // -------------------------------------------------------------------------

  /**
   * @brief Nettoie une ligne : minuscules et troncature après '#'.
   * @param ligne la ligne à nettoyer
   * @return la ligne nettoyée
   */
  private String nettoyer (String ligne) {
    String res = ligne.toLowerCase();
    int idx = res.indexOf('#');
    if (idx >= 0) res = res.substring(0, idx);
    return res;
  }

  /**
   * @brief Teste si un token est un entier (signé ou non).
   * @param tok le token à tester
   * @return true si le token est un entier valide
   */
  private boolean estEntier (String tok) {
    try {
      Integer.parseInt(tok);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  /**
   * @brief Teste si un token est un flottant.
   * @param tok le token à tester
   * @return true si le token est un flottant valide (et pas un entier)
   */
  private boolean estFlottant (String tok) {
    if (estEntier(tok)) return false;
    try {
      Float.parseFloat(tok);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

}
