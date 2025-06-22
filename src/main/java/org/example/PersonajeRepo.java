package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonajeRepo {

    private Map<Long,Personaje> repositorio = new HashMap<>();
    private long secuencialId = 1;

    public Personaje agregarPersonaje(String nombre, int saludMaxima, NivelPoder nivel, List<String> movimientos){
        long id = secuencialId++;
        Personaje p = new Personaje(id,nombre,saludMaxima,nivel,movimientos);
        repositorio.put(id,p);
        return p;
    }

    public void editarPersonaje(Long id, String nombre, int salud, NivelPoder nivel, List<String> movimientos){
        Personaje personaje = repositorio.get(id);
        if (personaje != null){
            personaje.setNombre(nombre);
            personaje.setSaludMaxima(salud);
            personaje.setNivelPoder(nivel);
            personaje.setMovimientos(movimientos);
        }
    }

    public boolean eliminarPersonaje(Long id){
        return repositorio.remove(id) != null;
    }

    public List<Personaje> listarTodos(){
        return new ArrayList<>(repositorio.values());
    }

    public List<Personaje> buscarPorNivelMinimo(NivelPoder nivel){
        return repositorio.values().stream().filter(p -> p.getNivelPoder().ordinal() >= nivel.ordinal()).toList();
    }

    public List<Personaje> buscarPorNombre(String subcadena){
        String sub = subcadena.toLowerCase();
        return repositorio.values().stream().filter(p -> p.getNombre().toLowerCase().contains(sub)).toList();
    }

    public List<Personaje> ordenarPorSaludDesc(){
        return repositorio.values().stream().sorted((p1,p2) -> p2.getSaludMaxima() - p1.getSaludMaxima()).toList();
    }

    public Personaje obtenerPorId(Long id){
        return repositorio.get(id);
    }

}
