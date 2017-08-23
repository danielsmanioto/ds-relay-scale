package setbackscale.dsmanioto.com.setbackscale.model;

/**
 * Created by danielsmanioto on 8/8/2017.
 */
public enum Team {

    TURMA_A("A", "Turma A"), TURMA_B("B", "Turma B"), TURMA_C("C", "Turma C"), Turma_D("D", "Turma D");

    private String id;
    private String descricao;

    private Team(String id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return id + " - " + descricao;
    }

    public String getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

}
