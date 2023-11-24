package Logica;
class MystiMonstersGeneral {
    private String nombre;
    private int salud;
    private int ataque;
    private int defensa;

    public MystiMonstersGeneral(String nombre, int salud, int ataque, int defensa) {
        this.nombre = nombre;
        this.salud = salud;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void recibirDano(int dano) {
        salud -= dano;
        if (salud < 0) {
            salud = 0;
        }
    }
}
