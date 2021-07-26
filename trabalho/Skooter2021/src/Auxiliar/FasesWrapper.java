package Auxiliar;

import Data.Fases;

public class FasesWrapper {
    private Fases fFases;

    public Fases getFases() {
        return this.fFases;
    }

    public void loadFases(Fases sFases) {
        this.fFases = sFases;
    }
}
