package setbackscale.dsmanioto.com.setbackscale.model;

/**
 * Created by danielsmanioto on 8/8/2017.
 */
public enum Shift {

    Folga(4, "Folga"), Turma1(1, "Turno 1(Manhâ)"), Turma2(2, "Turno 2(Tarde)"), Turma3(3, "Turno 3(Noite)");

    int id;
    String description;

    private Shift(int id, String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }

}
