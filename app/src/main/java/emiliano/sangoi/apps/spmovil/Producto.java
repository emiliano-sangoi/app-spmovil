package emiliano.sangoi.apps.spmovil;

import java.io.Serializable;

/**
 * Created by emi88 on 8/28/17.
 */

public class Producto implements Serializable{

    private Integer idProducto;
    private String nombreCorto;
    private String nombreLargo;
    private String descripcion;
    private String nombreProveedor;
    private String descProveedor;
    private Integer idProvedor;
    private String localidadProveedor;
    private String provinciaProveedor;

    public Producto(Integer idProducto, String nombreCorto, String nombreLargo, String descripcion, String nombreProveedor, String descProveedor, Integer idProvedor, String localidadProveedor, String provinciaProveedor) {
        this.idProducto = idProducto;
        this.nombreCorto = nombreCorto;
        this.nombreLargo = nombreLargo;
        this.descripcion = descripcion;
        this.nombreProveedor = nombreProveedor;
        this.descProveedor = descProveedor;
        this.idProvedor = idProvedor;
        this.localidadProveedor = localidadProveedor;
        this.provinciaProveedor = provinciaProveedor;
    }

    public Producto() {
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    public String getNombreLargo() {
        return nombreLargo;
    }

    public void setNombreLargo(String nombreLargo) {
        this.nombreLargo = nombreLargo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getDescProveedor() {
        return descProveedor;
    }

    public void setDescProveedor(String descProveedor) {
        this.descProveedor = descProveedor;
    }

    public Integer getIdProvedor() {
        return idProvedor;
    }

    public void setIdProvedor(Integer idProvedor) {
        this.idProvedor = idProvedor;
    }

    public String getLocalidadProveedor() {
        return localidadProveedor;
    }

    public void setLocalidadProveedor(String localidadProveedor) {
        this.localidadProveedor = localidadProveedor;
    }

    public String getProvinciaProveedor() {
        return provinciaProveedor;
    }

    public void setProvinciaProveedor(String provinciaProveedor) {
        this.provinciaProveedor = provinciaProveedor;
    }
}
