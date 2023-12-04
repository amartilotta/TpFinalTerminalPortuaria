package tpFinalTerminalPortuaria.Ubicacion;

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

    public double calcularDistancia(Ubicacion otraUbicacion) {
        double radioTierra = 6371; // Radio medio de la Tierra en kilómetros

        double dLatitud = Math.toRadians(otraUbicacion.getLatitud() - this.latitud);
        double dLongitud = Math.toRadians(otraUbicacion.getLongitud() - this.longitud);

        double a = Math.sin(dLatitud / 2) * Math.sin(dLatitud / 2) +
                   Math.cos(Math.toRadians(this.latitud)) * Math.cos(Math.toRadians(otraUbicacion.getLatitud())) *
                   Math.sin(dLongitud / 2) * Math.sin(dLongitud / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return radioTierra * c;
    }
}
	//Se debe hacer un metodo qe reciba una terminal y sepa calcular la distancia a ella. + ubicacion.actualizarUbicacion();

