package emiliano.sangoi.apps.spmovil;

import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Esta clase permite comunicarse con la api definida en la web del sistema SPM (http://fich.unl.edu.ar/cevarcam).
 *
 * Created by emi88 on 8/25/17.
 */
public class SPMApiHandler {

    /**
     * Servidor del SPM
     */
    private String host;

    /**
     * Puerto de acceso
     */
    private Integer port;

    /**
     * URL del sitio web SPM
     */
    private String url;

    /**
     * URL a la que se le debe "pegar" para loguearse
     */
    private String endpointLogin;

    private RequestQueue requestQueue;

    /**
     * Ultimo error, si es que ocurrio alguno
     */
    private String ultimoError;



    public SPMApiHandler(RequestQueue requestQueue) {

        //Inicializacion de variables:

        //cola de request HTTP (gestionada por Volley):
        this.requestQueue = requestQueue;

        //Ultimos error:
        this.ultimoError = new String();

        //Parametros de configuracion:
        this.host = "192.168.1.106";
        this.port = 4567;

        //Endpoints utilizados:
        this.endpointLogin = this.getBaseUrl() + "/login";


    }

    /**
     * Este metodo hace un http POST contra la api del servidor. Si las credenciales son correctas devuelve informacion del usuario y sus permisos.
     *
     * @param callback
     * @param username
     * @param password
     */
    public void loguear(final OnFinishCallback callback, String username, String password) {

        Map<String, String> params = new HashMap<String, String>();
        params.put("username", username.toString());
        params.put("password", password.toString());


        JsonObjectRequest request = new JsonObjectRequest(this.getEndpointLogin(), new JSONObject(params),
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        //Gson gson = new Gson();

                        //usuario = gson.fromJson(response.toString(), Usuario.class);

                        callback.successAction(new String());

                        Log.i("USUARIO: ", response.toString());
                        //Log.i("ES PACIENTE: ", usuario.esPaciente() ? "Si" : "No");

                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        //Log.i("ERROR", (new Integer(error.networkResponse.statusCode)).toString() );

                        try {
                            switch (error.networkResponse.statusCode) {
                                case 401: //unauthorized
                                    callback.showToast("Usuario y/o contraseña incorrectos");
                                    break;
                                case 403: //unauthorized
                                    callback.showToast("Usuario y/o contraseña incorrectos");
                                    break;
                                default:
                                    callback.showToast("Ocurrio un error desde la API.");
                                    ultimoError = error.toString();
                                    Log.e("LOGIN ERROR:", error.toString());
                            }

                        } catch (NullPointerException e) {
                            callback.showToast("Ocurrio un error al intentar verificar las credenciales. Probablemente el servidor no se encuentre funcionando correctamente.");
                            e.printStackTrace();
                            Log.d("ERROR", e.getMessage());
                        }

                    }

                });

        //encolar request...
        this.requestQueue.add(request);
    }

    //Getters & Setters:

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    /*
   La IP publica fue sacada desde la terminal con hostname -I
   Por ej: 192.168.0.61 (esta ip va cambiando)
    */
    public String getBaseUrl() {
        return "http://" + this.host + ":" + this.port + "/cevarcam/api/index.php";
    }

    public String getEndpointLogin() {
        return this.endpointLogin;
    }


}
