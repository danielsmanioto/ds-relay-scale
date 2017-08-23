package setbackscale.dsmanioto.com.setbackscale.service;

import android.support.annotation.NonNull;

import java.util.Calendar;
import java.util.Date;

import setbackscale.dsmanioto.com.setbackscale.model.Scale;
import setbackscale.dsmanioto.com.setbackscale.model.ScaleBeginYear;
import setbackscale.dsmanioto.com.setbackscale.model.Shift;
import setbackscale.dsmanioto.com.setbackscale.model.Worker;

/**
 * Created by danie on 8/8/2017.
 */
public class Calculate {

    private Worker trabalhador;
    private ScaleBeginYear escalaInicioAno;
    private Scale escala;
    private Calendar data;

    private int daysWorking;
    private int daysFolga;

    public Calculate(Worker trabalhador, Calendar data) {
        this.trabalhador = trabalhador;
        this.escalaInicioAno = new ScaleBeginYear(this.trabalhador.getTeam());
        setEscalaDesejada(data);
    }

    private void setEscalaDesejada(Calendar dataFind) {
        final Calendar dateInit = getInitialDate();

        int diasTrabalhados = this.escalaInicioAno.getDiasTrabalhados();
        int diasFolga = this.escalaInicioAno.getDiasFolga();
        Shift turno = this.escalaInicioAno.getCurrentShift();

        for (int day = dateInit.get(Calendar.DAY_OF_YEAR); day <  dataFind.get(Calendar.DAY_OF_YEAR); day++) {

            if (diasTrabalhados > 0 && diasTrabalhados <= 6 && diasFolga == 0) {
                diasTrabalhados++;
            } else if (diasFolga > 0 && diasFolga <= 2 && diasTrabalhados == 0) {
                diasFolga++;
            }

            if(diasFolga > 2 && diasTrabalhados == 0) {
                diasTrabalhados = 1;
                diasFolga = 0;
                turno = verifyAlterShift(turno);
            } else if (diasTrabalhados > 6 && diasFolga == 0) {
                diasFolga = 1;
                diasTrabalhados = 0;
            }


        }

        this.daysWorking = diasTrabalhados;
        this.daysFolga = diasFolga;
        escala = new Scale(diasTrabalhados, diasFolga, turno);
    }

    @NonNull
    private Calendar getInitialDate() {
        //TODO configure this
        Calendar dateInit = Calendar.getInstance();
        dateInit.set(Calendar.DAY_OF_MONTH, 1);
        dateInit.set(Calendar.MONTH, Calendar.JANUARY);
        dateInit.set(Calendar.YEAR, 2017);
        return dateInit;
    }

    /**
     * Verifica / Altera o turno do funcionário(altera sempre quando termina um novo ciclo)
     */
    private Shift verifyAlterShift(Shift atual) {
        if (atual.equals(Shift.Turma3)) {
            return Shift.Turma2;
        } else if (atual.equals(Shift.Turma2)) {
            return Shift.Turma1;
        } else if (atual.equals(Shift.Turma1)) {
            return Shift.Turma3;
        }

        return Shift.Folga;
    }

    public boolean isFolga() {
        return this.escala.getDiaFolga() > 0 && this.escala.getDiasTrabalhados() == 0;
    }

    public Scale getEscala() {
        return escala;
    }

    public Calendar getData() {
        return data;
    }

    public int getDaysWorking() {
        return daysWorking;
    }

    public int getDaysFolga() {
        return daysFolga;
    }

}
