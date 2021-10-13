/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Jose Daniel Parra - Andres Felipe Cortes.
 */
public class Jugador implements Comparable<Jugador>{

    private String id;
    private String nombre;
    private double tiempo;
    private int jugadas;

    /**
     * Inicaliza las variables de la clase jugador.
     *
     * @param id
     * @param nombre
     * @param tiempo
     * @param jugadas
     */
    public Jugador(String id, String nombre, double tiempo, int jugadas) {
        this.id = id;
        this.nombre = nombre;
        this.tiempo = tiempo;
        this.jugadas = jugadas;
    }
    
   

    /**
     * Obtiene la variable Id
     *
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Modifica la variable Id
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene la variable Nombre
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica la variable Nombre
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la variable Tiempo
     *
     * @return tiempo
     */
    public double getTiempo() {
        return tiempo;
    }

    /**
     * Modifica la variable Tiempo
     *
     * @param tiempo
     */
    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    /**
     * Obtiene la variable Jugadas
     *
     * @return jugadas
     */
    public int getJugadas() {
        return jugadas;
    }

    /**
     * Modifica la variable Jugadas
     *
     * @param jugadas
     */
    public void setJugadas(int jugadas) {
        this.jugadas = jugadas;
    }

    /**
     * Devuelve la informacion de un jugador en string
     */
    @Override
    public String toString() {
        return "Jugador: " + nombre + ", ID: " + id + ", Tiempo: " + (int)tiempo+"seg" + ", Jugadas: " + jugadas;
    }
    /**
     * Permite comparar Jugadores por el numero de jugadas
     * @param j
     * @return jugadas ordenadas de menor a mayor
     */
    @Override
    public int compareTo(Jugador j) {
        if (jugadas < j.getJugadas()) {
                return -1;
            }
            if (jugadas > j.getJugadas()) {
                return 1;
            }
            return 0;
    }

}
