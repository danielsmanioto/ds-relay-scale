package setbackscale.dsmanioto.com.setbackscale.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Calendar;

import setbackscale.dsmanioto.com.setbackscale.R;
import setbackscale.dsmanioto.com.setbackscale.service.Calculate;
import setbackscale.dsmanioto.com.setbackscale.model.Team;
import setbackscale.dsmanioto.com.setbackscale.model.Worker;

public class ExecuteFindActivity extends AppCompatActivity {

    private static final String TEAM_A = "A";
    private static final String TEAM_B = "B";
    private static final String TEAM_C = "C";
    private static final String TEAM_D = "D";

    private RadioGroup rdpTeam;
    private DatePicker dateFind;
    private TextView txtResult;

    private RadioButton rdbTeamA;
    private RadioButton rdbTeamB;
    private RadioButton rdbTeamC;
    private RadioButton rdbTeamD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setback_scale);

        setRadioComponents();

        dateFind = (DatePicker) findViewById(R.id.dateFind);
        dateFind.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                findClick();
            }
        });

        txtResult = (TextView) findViewById(R.id.txtResult);
    }

    private void setRadioComponents() {
        rdpTeam = (RadioGroup) findViewById(R.id.rdpTeam);

        rdbTeamA = (RadioButton) findViewById(R.id.TeamA);
        rdbTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findClick();
            }
        });

        rdbTeamB = (RadioButton) findViewById(R.id.TeamB);
        rdbTeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findClick();
            }
        });

        rdbTeamC = (RadioButton) findViewById(R.id.TeamC);
        rdbTeamC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findClick();
            }
        });


        rdbTeamD = (RadioButton) findViewById(R.id.TeamD);
        rdbTeamD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findClick();
            }
        });
    }

    private void findClick() {
        //Veriry informations
        RadioButton rdpSeleced = (RadioButton) findViewById(rdpTeam.getCheckedRadioButtonId());

        // Get days of quicky
        int day = dateFind.getDayOfMonth();
        int month = dateFind.getMonth();
        int year = dateFind.getYear();
        Calendar dateFind = Calendar.getInstance();
        dateFind.set(Calendar.DAY_OF_MONTH, day);
        dateFind.set(Calendar.MONTH, month);
        dateFind.set(Calendar.YEAR, year);

        //Configuration definitions
        final String teamSelected = rdpSeleced.getText().toString();
        Team team = getTeam(teamSelected);
        Worker worker = new Worker("Worker Name", team);

        // Calculate
        Calculate calculate = new Calculate(worker, dateFind);

        // Result
        if(calculate.isFolga()) {
            txtResult.setText(calculate.getDaysFolga() + "º dia de folga.");
        } else {
            txtResult.setText(calculate.getDaysWorking() + "º dia de trabalho. " +  calculate.getEscala().getShift().toString());
        }
    }

    /**
     * GET team ( default team A)
     * @param teamSelected
     * @return
     */
    private Team getTeam(String teamSelected) {
        Team team = null;
        if(TEAM_A.equals(teamSelected)) {
            team = Team.TURMA_A;
        } else if(TEAM_B.equals(teamSelected)) {
            team = Team.TURMA_B;
        } else if(TEAM_C.equals(teamSelected)) {
            team = Team.TURMA_C;
        } else if(TEAM_D.equals(teamSelected)) {
            team = Team.Turma_D;
        } else {
            team = Team.TURMA_A;
        }

        return team;
    }

}
