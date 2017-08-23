package setbackscale.dsmanioto.com.setbackscale.model;

/**
 * Created by danielsmanioto on 8/8/2017.
 */
public class Scale {

    private int diasTrabalhados;
    private int diaFolga;
    private Shift shift;

    private Scale(int diasTrabalhados, int diaFolga) {
        this.diasTrabalhados = diasTrabalhados;
        this.diaFolga = diaFolga;
    }

    public Scale(int diasTrabalhados, int diaFolga, Shift shift) {
        this(diasTrabalhados, diaFolga);
        this.shift = shift;
    }

    public int getDiasTrabalhados() {
        return diasTrabalhados;
    }

    public int getDiaFolga() {
        return diaFolga;
    }

    public Shift getShift() {
        return shift;
    }

}
