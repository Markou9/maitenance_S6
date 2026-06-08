package id;

public final class Id {
    private static long globalId = 0;

    private Id() {}

    public static long getNextId() {
        return ++globalId;
    }

    public static void setId(long id) {
        globalId = id;
    }

    public static void saveId() {
        // TODO: sauvegarder l'id dans un fichier si demandé par le TP
    }

    public static void loadId() {
        // TODO: charger l'id depuis un fichier si demandé par le TP
    }
}
