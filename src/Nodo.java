public class Nodo
{
    private float dato;
    private int fila;
    private int col;
    private Nodo ligafila;
    private Nodo ligacol;
    private Nodo liga;

    public Nodo(int fila, int col,float dato) {
        this.dato = dato;
        this.fila = fila;
        this.col = col;
        ligafila=null;
        ligacol=null;
        liga=null;
    }

    public float getDato() {
        return dato;
    }

    public void setDato(float dato) {
        this.dato = dato;
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

    public Nodo getLigafila() {
        return ligafila;
    }

    public void setLigafila(Nodo ligafila) {
        this.ligafila = ligafila;
    }

    public Nodo getLigacol() {
        return ligacol;
    }

    public void setLigacol(Nodo ligacol) {
        this.ligacol = ligacol;
    }

    public Nodo getLiga() {
        return liga;
    }

    public void setLiga(Nodo liga) {
        this.liga = liga;
    }
}
