package org.example;


import java.util.List;

public class Personaje {

    private Long id;
    private String nombre;
    private int saludMaxima;
    private NivelPoder nivelPoder;
    private List<String> movimientos;

    public Personaje(Long id, String nombre, int saludMaxima, NivelPoder nivelPoder, List<String> movimientos) {
        this.id = id;
        this.nombre = nombre;
        this.saludMaxima = saludMaxima;
        this.nivelPoder = nivelPoder;
        this.movimientos = movimientos;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSaludMaxima() {
        return saludMaxima;
    }

    public void setSaludMaxima(int saludMaxima) {
        this.saludMaxima = saludMaxima;
    }

    public NivelPoder getNivelPoder() {
        return nivelPoder;
    }

    public void setNivelPoder(NivelPoder nivelPoder) {
        this.nivelPoder = nivelPoder;
    }

    public List<String> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<String> movimientos) {
        this.movimientos = movimientos;
    }
}
