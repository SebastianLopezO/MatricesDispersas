public class NodoF2
{
    private int fila;
    private int col;
    private float dato;
    private NodoF2 ligafila;
    private NodoF2 ligacol;

    public NodoF2(int fila, int col, float dato) {
        this.fila = fila;
        this.col = col;
        this.dato = dato;
        ligafila=null;
        ligacol=null;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public float getDato() {
        return dato;
    }

    public void setDato(float dato) {
        this.dato = dato;
    }

    public NodoF2 getLigafila() {
        return ligafila;
    }

    public void setLigafila(NodoF2 ligafila) {
        this.ligafila = ligafila;
    }

    public NodoF2 getLigacol() {
        return ligacol;
    }

    public void setLigacol(NodoF2 ligacol) {
        this.ligacol = ligacol;
    }


}
