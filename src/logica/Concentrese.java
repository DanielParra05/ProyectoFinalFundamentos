/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Jose Daniel Parra - Andres Felipe Cortes.
 */
public class Concentrese {

    private ArrayList<Jugador> jugadores;

    /**
     * Inicializa la(s) variable(s) de la clase.
     */
    public Concentrese() {
        jugadores = new ArrayList<>();
    }

    /**
     * Obtiene el ArrayList Jugadores.
     *
     * @return
     */
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    /**
     * Modifica el ArrayList Jugadores.
     *
     * @param Jugadores
     */
    public void setJugadores(ArrayList<Jugador> Jugadores) {
        this.jugadores = Jugadores;
    }

    /**
     * Agrega un jugador.
     *
     * @param j
     * @return true si el jugador fue agregado, de lo contrario retorna false.
     */
    public boolean agregarJugador(Jugador j) {

        int i = buscarJugador(j.getId());
        if (i == -1) {
            return jugadores.add(j);

        }

        return false;
    }

    /**
     * Busca un jugador.
     *
     * @param id
     * @return la posicion del jugador si lo encuentra, de lo contrario retorna
     * -1.
     */
    public int buscarJugador(String id) {

        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getId().equals(id)) {
                return i;
            }

        }
        return -1;

    }

    /**
     * Obtiene una lista tipo String de Todos los jugadores
     * @return la lista con los jugadores
     */
    public String[] obtenerListaDeJugadores() {

        String[] listaDeJugadores = new String[jugadores.size()];

        for (int i = 0; i < listaDeJugadores.length; i++) {
            listaDeJugadores[i] = jugadores.get(i).toString();
        }

        return listaDeJugadores;
    }

    /**
     * Actualiza el tiempo y las jugadas de un jugador
     *
     * @param tiempo
     * @param jugadas
     * @param jugador
     */
    public void actualizarDatos(Jugador jugador, double tiempo, int jugadas) {
        if (jugador.getTiempo() != 0 && jugador.getJugadas() != 0) {
            if (jugador.getTiempo() > tiempo && jugador.getJugadas() > jugadas) {
                jugador.setJugadas(jugadas);
                jugador.setTiempo(tiempo);
            }
        } else {
            jugador.setJugadas(jugadas);
            jugador.setTiempo(tiempo);
        }

    }

    /**
     * Obtiene un arreglo de Jugadores ordenados por jugadas.
     * @return arreglo de jugadores ordenados por jugadas.
     */
    public Jugador[] jugadoresPorNumJugadas() {

        Jugador[] jugadoresPorJugadas = new Jugador[jugadores.size()];

        for (int i = 0; i < jugadoresPorJugadas.length; i++) {
            jugadoresPorJugadas[i] = jugadores.get(i);
        }

        Arrays.sort(jugadoresPorJugadas);
        return jugadoresPorJugadas;
    }

    /**
     * Desempata los jugadores con mismo numero de
     * jugadas respecto al tiempo
     * @return arreglo de Juadores ordenados por numero
     * de jugadas y tiempo(si hay jugadores con las mismas jugadas)
     */
    public String[] desempate() {

        Jugador[] aux = jugadoresPorNumJugadas();
        String[] listaDeJugadoresOrdenados = new String[aux.length];

        for (int i = 0; i < aux.length; i++) {
            for (int j = 0; j < aux.length; j++) {

                if (aux[i].getJugadas() == aux[j].getJugadas()) {

                    if (aux[i].getTiempo() > aux[j].getTiempo()) {
                        Jugador aux1 = aux[j];
                        Jugador aux2 = aux[j];
                        aux[i] = aux1;
                        aux[j] = aux2;
                    }
                }
            }
        }
        for (int i = 0; i < aux.length; i++) {
            listaDeJugadoresOrdenados[i] = aux[i].toString();
        }
        return listaDeJugadoresOrdenados;
    }
}
