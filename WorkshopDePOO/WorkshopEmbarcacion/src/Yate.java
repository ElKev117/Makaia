public class Yate extends Embarcacion {
    private int cantidadCamarotes;

    public Yate(Capitan capitan, double precioBase, double valorAdicional, int anioFabricación, double eslora, int cantidadCamarotes) {
        super(capitan, precioBase, valorAdicional, anioFabricación, eslora);
        this.cantidadCamarotes = cantidadCamarotes;
    }

    public boolean esDeLujo(){
        return (cantidadCamarotes>7);
    }

    public int getCantidadCamarotes() {
        return cantidadCamarotes;
    }

    public void setCantidadCamarotes(int cantidadCamarotes) {
        this.cantidadCamarotes = cantidadCamarotes;
    }
}
