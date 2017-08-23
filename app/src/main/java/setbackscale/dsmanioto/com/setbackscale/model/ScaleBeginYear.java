package setbackscale.dsmanioto.com.setbackscale.model;

/**
 * Created by danielsmanioto on 8/8/2017.
 */
public class ScaleBeginYear {

    private int diasTrabalhados;
    private int diasFolga;
    private Shift currentShift;

    public ScaleBeginYear(Team turma) {
        selectionTeam(turma);
    }

    private void selectionTeam(Team turma) {
        // TODO will change to database configuration

        switch (turma.getId()) {
            case "A":
                this.diasTrabalhados = 5;
                this.diasFolga = 0;
                this.currentShift = Shift.Turma1;
                break;
            case "B":
                this.diasTrabalhados = 0;
                this.diasFolga = 1;
                this.currentShift = Shift.Folga;
                break;
            case "C":
                this.diasTrabalhados = 1;
                this.diasFolga = 0;
                this.currentShift = Shift.Turma2;
                break;
            case "D":
                this.diasTrabalhados = 4;
                this.diasFolga = 0;
                this.currentShift = Shift.Turma3;
                break;
        }
    }

    public int getDiasTrabalhados() {
        return diasTrabalhados;
    }

    public int getDiasFolga() {
        return diasFolga;
    }

    public Shift getCurrentShift() {
        return currentShift;
    }

}
