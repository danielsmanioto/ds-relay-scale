package setbackscale.dsmanioto.com.setbackscale.activity;

import setbackscale.dsmanioto.com.setbackscale.R;
import setbackscale.dsmanioto.com.setbackscale.model.Team;
import setbackscale.dsmanioto.com.setbackscale.model.Worker;
import setbackscale.dsmanioto.com.setbackscale.service.Calculate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import java.util.Calendar;

/**
 * Created by danielsmanioto on 8/9/2017.
 */
public class MainActivity extends Activity {


    private Button btnVerifyScale;
    private Button btnConfigurarions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVerifyScale = (Button) findViewById(R.id.btnVerifyScale);
        btnConfigurarions = (Button) findViewById(R.id.btnConfigurarions);

        btnVerifyScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToForm = new Intent(MainActivity.this, ExecuteFindActivity.class);
                startActivity(goToForm);}
        });

        btnConfigurarions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToForm = new Intent(MainActivity.this, ConfigurationActivity.class);
                startActivity(goToForm);}
        });

    }
}
