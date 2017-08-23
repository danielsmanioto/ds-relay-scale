package setbackscale.dsmanioto.com.setbackscale;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import setbackscale.dsmanioto.com.setbackscale.model.Shift;
import setbackscale.dsmanioto.com.setbackscale.model.Team;
import setbackscale.dsmanioto.com.setbackscale.model.Worker;
import setbackscale.dsmanioto.com.setbackscale.service.Calculate;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by danielsmanioto on 8/9/2017.
 */
public class CalculateTest {

    @Test
    public void calculate_trabalhando() {
        Calendar dateFind = Calendar.getInstance();
        dateFind.set(Calendar.DAY_OF_MONTH, 3);
        dateFind.set(Calendar.MONTH, Calendar.JANUARY);
        dateFind.set(Calendar.YEAR, 2017);
        Worker worker = new Worker("Worker Name", Team.TURMA_C);
        Calculate calculate = new Calculate(worker, dateFind);

        assertEquals(0, calculate.getDaysFolga());
        assertFalse(calculate.isFolga());
        assertEquals(3, calculate.getDaysWorking());
        assertEquals(Shift.Turma2, calculate.getEscala().getShift());
    }

    @Test
    public void calculate_trabalhando_2() {
        Calendar dateFind = Calendar.getInstance();
        dateFind.set(Calendar.DAY_OF_MONTH, 27);
        dateFind.set(Calendar.MONTH, Calendar.JANUARY);
        dateFind.set(Calendar.YEAR, 2017);
        Worker worker = new Worker("Worker Name", Team.TURMA_C);
        Calculate calculate = new Calculate(worker, dateFind);

        assertEquals(0, calculate.getDaysFolga());
        assertFalse(calculate.isFolga());
        assertEquals(3, calculate.getDaysWorking());
        assertEquals(Shift.Turma2, calculate.getEscala().getShift());
    }

    @Test
    public void calculate_trabalhando_3() {
        Calendar dateFind = Calendar.getInstance();
        dateFind.set(Calendar.DAY_OF_MONTH, 4);
        dateFind.set(Calendar.MONTH, Calendar.JUNE);
        dateFind.set(Calendar.YEAR, 2017);
        Worker worker = new Worker("Worker Name", Team.TURMA_C);
        Calculate calculate = new Calculate(worker, dateFind);

        assertEquals(0, calculate.getDaysFolga());
        assertFalse(calculate.isFolga());
        assertEquals(3, calculate.getDaysWorking());
        assertEquals(Shift.Turma1, calculate.getEscala().getShift());
    }

    @Test
    public void calculate_folgando_1() {
        Calendar dateFind = Calendar.getInstance();
        dateFind.set(Calendar.DAY_OF_MONTH, 7);
        dateFind.set(Calendar.MONTH, Calendar.JANUARY);
        dateFind.set(Calendar.YEAR, 2017);
        Worker worker = new Worker("Worker Name", Team.TURMA_C);
        Calculate calculate = new Calculate(worker, dateFind);

        assertEquals(1, calculate.getDaysFolga());
        assertTrue(calculate.isFolga());
        assertEquals(0, calculate.getDaysWorking());
    }

    @Test
    public void calculate_folgando_2() {
        Calendar dateFind = Calendar.getInstance();
        dateFind.set(Calendar.DAY_OF_MONTH, 16);
        dateFind.set(Calendar.MONTH, Calendar.FEBRUARY);
        dateFind.set(Calendar.YEAR, 2017);
        Worker worker = new Worker("Worker Name", Team.TURMA_C);
        Calculate calculate = new Calculate(worker, dateFind);

        assertEquals(1, calculate.getDaysFolga());
        assertTrue(calculate.isFolga());
        assertEquals(0, calculate.getDaysWorking());
    }

}
