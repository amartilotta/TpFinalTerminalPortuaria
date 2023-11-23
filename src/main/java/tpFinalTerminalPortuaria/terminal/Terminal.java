package tpFinalTerminalPortuaria.terminal;

import tpFinalTerminalPortuaria.Ubicacion.Ubicacion;

public abstract class Terminal {
    private Ubicacion ubicacion;

    public Terminal(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Ubicacion getUbicacion() {
        return this.ubicacion;
    }
}