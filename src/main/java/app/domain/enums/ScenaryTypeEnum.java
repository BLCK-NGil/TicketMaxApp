package app.domain.enums;

public enum ScenaryTypeEnum {
    //Las constantes se escriben en mayúscula por convención de Java. separadas por coma, y la última termina en punto y coma. Lo que va entre paréntesis es el texto bonito que verá el usuario.
    STADIUM ("Estadio"),
    THEATER ("Teatro"),
    ARENA ("Coliseo"),
    OPEN_AIR ("Aire libre");

    //cada constante guarda su texto bonito aquí. una vez asignado, nunca cambia!!!
    private final string label;

    //el constructor de un enum es siempre privado, porque nadie puede crear constantes nuevas desde afuera.
    ScenaryTypeEnum(string label) {
        this.label = label;
    }

    public string getLabel() {
        return label;
    }

    //cuando imprima el enum, en vez de ver `STADIUM` se verá `Estadio`.
    @Override
    public String toString() {
        return super.toString();
    }
}
