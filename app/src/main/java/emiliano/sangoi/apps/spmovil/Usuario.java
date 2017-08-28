package emiliano.sangoi.apps.spmovil;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by emi88 on 8/27/17.
 */

public class Usuario implements Serializable{

    private Integer idUsuario;
    private String nombreUsuario;
    private String nombres;
    private String apellidos;
    private String email;
    private String telefonoFijo;
    private String telefonoCelular;
    private Producto[] productos;

    public Usuario() {
    }

    public Usuario(Integer idUsuario, String nombreUsuario, String nombres, String apellidos, String email, String telefonoFijo, String telefonoCelular, Producto[] productos) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.telefonoFijo = telefonoFijo;
        this.telefonoCelular = telefonoCelular;
        this.productos = productos;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }


    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public void setProductos(Producto[] productos) {
        this.productos = productos;
    }
}
