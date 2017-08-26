package emiliano.sangoi.apps.spmovil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Toast.makeText(this, "Hola usuario!!!", Toast.LENGTH_LONG).show();
    }
}
