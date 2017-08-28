package emiliano.sangoi.apps.spmovil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    /**
     * Usuario logueado
     */
    private Usuario usuario;

    /**
     * Titulo ppal del HOME
     */
    private TextView tvTituloPpal;

    /**
     * Titulo del menu que lista los productos ofrecidos
     */
    private TextView tvTituloMenu;

    /**
     * Mensage que se muestra cuando el usuario no tiene acceso a ningun producto.
     */
    private TextView tvMsg0productos;

    /**
     * Boton para consultar la variable Temperatura para el pronostico extendido.
     */
    private Button btnMenuOpPronoExtTemp;

    /**
     * Boton para consultar la variable Precipitacion para el pronostico extendido.
     */
    private Button btnMenuOpPronoExtPrec;

    /**
     * Boton para consultar la variable Viento para el pronostico extendido.
     */
    private Button btnMenuOpPronoExtViento;

    /**
     * Boton para elegir el pronostico a corto plazo (nowcasting) productido por el radar de FICH.
     */
    private Button btnMenuOpRadarFICH;


    /**
     * Productos existentes en la app.
     */
    private List<Integer> productosDisponibles;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        this.usuario = (Usuario) bundle.getSerializable("usuario");

        //Como maximo, un usuario podra consultar los siguientes productos:
        this.productosDisponibles.add(16);
        this.productosDisponibles.add(28);
        this.productosDisponibles.add(29);
        this.productosDisponibles.add(30);

        this.initUI();
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Inicializar componentes UI
    private void initUI(){

        //Buscar componentes:
        this.tvTituloPpal = (TextView) findViewById(R.id.tvTituloPpal);
        this.tvTituloMenu = (TextView) findViewById(R.id.tvTituloMenu);
        this.tvMsg0productos = (TextView) findViewById(R.id.tvMsg0productos);
        this.btnMenuOpPronoExtTemp = (Button) findViewById(R.id.btnMenuOpPronoExtTemp);
        this.btnMenuOpPronoExtPrec = (Button) findViewById(R.id.btnMenuOpPronoExtPrec);
        this.btnMenuOpPronoExtViento = (Button) findViewById(R.id.btnMenuOpPronoExtViento);
        this.btnMenuOpRadarFICH = (Button) findViewById(R.id.btnMenuOpRadarFICH);

        //Cargar contenido:
        this.tvTituloPpal.setText("Bienvenido " + usuario.getNombres() + " !!!");
        this.tvMsg0productos.setVisibility(View.GONE);
        for(int i = 0 ; i < this.productosDisponibles.size() ; i++){
            // ? ...

        }

        //Toast.makeText(this, "Hola " + usuario.getNombres() + " !!!", Toast.LENGTH_SHORT).show();

    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Menu principal & btn volver

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mainMenuItemSalir:
                //usuario.setLogueado(false);
                startActivity( new Intent(this, LoginActivity.class) );
                break;
            default:
                Toast.makeText(this, "No implementado", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        return;
    }
}
