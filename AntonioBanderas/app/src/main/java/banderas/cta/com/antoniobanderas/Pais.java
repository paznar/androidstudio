package banderas.cta.com.antoniobanderas;

import java.io.Serializable;

/**
 * Created by cta on 17/04/2015.
 */
public class Pais implements Serializable
{
    private String nombre;
    private int poblacion;
    private boolean UE;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public boolean isUE() {
        return UE;
    }

    public void setUE(boolean UE) {
        this.UE = UE;
    }
}
