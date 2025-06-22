package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class PersonajeRepoTest {

    private PersonajeRepo personajeRepo;

    @BeforeEach
    void setUp() {
         personajeRepo = new PersonajeRepo();
    }

    @Test
    void testAgregarPersonaje(){
        Personaje p = personajeRepo.agregarPersonaje("Scorpion",100,NivelPoder.ALTO, List.of("TP","Aliento de dragon"));
        assertNotNull(p.getId());
        assertEquals("Scorpion", p.getNombre());
        assertEquals(100, p.getSaludMaxima());
        assertEquals(NivelPoder.ALTO, p.getNivelPoder());
        assertTrue(p.getMovimientos().contains("TP"));
    }

    // ahora los que faltan, en x4 para ir mas rapido

    @Test
    void testEditarPersonaje(){
        Personaje p = personajeRepo.agregarPersonaje("Sub-Zero",120,NivelPoder.MEDIO, List.of("Congelar"
                ,"Bola de hielo"));
        personajeRepo.editarPersonaje(p.getId(), "Sub-Zero V2",150,NivelPoder.ALTO, List.of("Pegar"));

        Personaje editado = personajeRepo.obtenerPorId(p.getId());
        assertEquals("Sub-Zero V2", editado.getNombre());
        assertEquals(150, editado.getSaludMaxima());
        assertEquals(NivelPoder.ALTO, editado.getNivelPoder());
        assertTrue(editado.getMovimientos().contains("Pegar"));

    }

    @Test
    void testEliminarPersonaje(){
        Personaje p = personajeRepo.agregarPersonaje("Raiden",110,NivelPoder.MEDIO, List.of("Rayo"));
        boolean eliminado = personajeRepo.eliminarPersonaje(p.getId());
        assertTrue(eliminado);
    }


    @Test
    void testListarPersonajes(){
        personajeRepo.agregarPersonaje("Liu kang" , 130 ,NivelPoder.ALTO, List.of("Patada voladora"));
        personajeRepo.agregarPersonaje("Raiden" , 100 ,NivelPoder.BAJO, List.of("Rayo"));

        List<Personaje> personajes = personajeRepo.listarTodos();
        assertEquals(2,personajes.size());
    }

    @Test
    void testBuscarNivelMayorOIgualAMedio(){
        personajeRepo.agregarPersonaje("Johnny cage" , 130 ,NivelPoder.BAJO, List.of("Pegar"));
        personajeRepo.agregarPersonaje("Sonya Blade",120,NivelPoder.MEDIO,List.of("Patada"));
        personajeRepo.agregarPersonaje("Raiden" , 100 ,NivelPoder.ALTO, List.of("Rayo"));

        List<Personaje> resultado = personajeRepo.buscarPorNivelMinimo(NivelPoder.MEDIO);

        assertEquals(2,resultado.size());
        assertTrue(resultado.stream().anyMatch(p -> p.getNombre().equals("Sonya Blade")));
        assertTrue(resultado.stream().anyMatch(p -> p.getNombre().equals("Raiden")));
    }

    @Test
    void testBuscarPorNombre(){
        personajeRepo.agregarPersonaje("Liu kang" , 130 ,NivelPoder.ALTO, List.of("Patada voladora"));
        personajeRepo.agregarPersonaje("Raiden" , 100 ,NivelPoder.BAJO, List.of("Rayo"));
        List<Personaje> resultado = personajeRepo.buscarPorNombre("Rai");
        assertEquals(1,resultado.size());
        assertEquals("Raiden",resultado.get(0).getNombre());
    }

    @Test
    void testOrdenarPorSaludMaxima(){
        personajeRepo.agregarPersonaje("Baraka" , 130 ,NivelPoder.ALTO, List.of("Comer"));
        personajeRepo.agregarPersonaje("Liu kang" , 100 ,NivelPoder.BAJO, List.of("Patada voladora"));
        personajeRepo.agregarPersonaje("Kitana" , 101 ,NivelPoder.BAJO, List.of("Patada"));

        List<Personaje> ordenados = personajeRepo.ordenarPorSaludDesc();
        assertEquals("Baraka",ordenados.get(0).getNombre());
        assertEquals("Kitana",ordenados.get(1).getNombre());
    }


}