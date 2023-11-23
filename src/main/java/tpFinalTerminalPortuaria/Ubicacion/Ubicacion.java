package tpFinalTerminalPortuaria.Ubicacion;

import tpFinalTerminalPortuaria.terminal.Terminal;

public class Ubicacion {
    private double latitud;
    private double longitud;

    public Ubicacion(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public double calcularDistancia(Terminal terminal) {
        double radioTierra = 6371; // Radio medio de la Tierra en kilómetros

        double latitudTerminal = Math.toRadians(terminal.getUbicacion().getLatitud());
        double longitudTerminal = Math.toRadians(terminal.getUbicacion().getLongitud());

        double latitudActual = Math.toRadians(this.latitud);
        double longitudActual = Math.toRadians(this.longitud);

        double dLatitud = latitudTerminal - latitudActual;
        double dLongitud = longitudTerminal - longitudActual;

        double a = Math.sin(dLatitud / 2) * Math.sin(dLatitud / 2) +
                   Math.cos(latitudActual) * Math.cos(latitudTerminal) *
                   Math.sin(dLongitud / 2) * Math.sin(dLongitud / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return radioTierra * c;
    }
}
	//Se debe hacer un metodo qe reciba una terminal y sepa calcular la distancia a ella. + ubicacion.actualizarUbicacion();

