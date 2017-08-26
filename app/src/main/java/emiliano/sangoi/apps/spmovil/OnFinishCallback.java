package emiliano.sangoi.apps.spmovil;


import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by emi88 on 8/25/17.
 */
public class OnFinishCallback {

    private Context context;
    private Bundle data;

    public OnFinishCallback(Context context) {

        this.context = context;
        this.data = new Bundle();

    }

    /**
     * Actualiza la vista. En data se encuentra el objeto con los datos, normalmente traidos del modelo.
     * @param data
     */
    public void successAction(Object data){
        return;
    }

    /**
     *
     * @param data
     */
    public void successAction(Object[] data){
        return;
    }

    /**
     * Se debe ejecutar en caso de que haya algun error
     */
    public void errorAction(){
        return;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Bundle getData() {
        return data;
    }

    public void setData(Bundle data) {
        this.data = data;
    }

    public void showToast(String msg){
        Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();
    }
}