package emiliano.sangoi.apps.spmovil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class LoginActivity extends AppCompatActivity {

    /**
     * Objeto para comunicarse con la api de la web SPM
     */
    private SPMApiHandler apiSPMHandler;

    /*View components: */
    private EditText etUsername;
    private EditText etPassword;
    private Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        RequestQueue rq = Volley.newRequestQueue(this);
        this.apiSPMHandler = new SPMApiHandler(rq);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);
    }


    /**
     *
     * @param view
     */
    public void onLogin(View view){

        //Callback que se ejecuta cuando la peticion HTTP se completa:
        OnFinishCallback callback = new OnFinishCallback(this){

            @Override
            public void successAction(Object data) {

                Intent i = new Intent(this.getContext(), HomeActivity.class);
                Usuario usuario = (Usuario) data;
                Bundle bundle = new Bundle();
                bundle.putSerializable("usuario", usuario);

                i.putExtras(bundle);

                startActivity(i);

            }
        };

        String username = this.etUsername.getText().toString();
        String password = this.etPassword.getText().toString();

        this.apiSPMHandler.loguear(callback, username, password);

    }



}
