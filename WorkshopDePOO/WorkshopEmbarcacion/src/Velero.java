public class Velero extends  Embarcacion {
    private int cantidadMastiles;

    public Velero(Capitan capitan, double precioBase, double valorAdicional, int anioFabricación, double eslora, int cantidadMastiles) {
        super(capitan, precioBase, valorAdicional, anioFabricación, eslora);
        this.cantidadMastiles = cantidadMastiles;
    }

    public boolean esGrande(){
        return (cantidadMastiles>4);
    }

    public int getCantidadMastiles() {
        return cantidadMastiles;
    }

    public void setCantidadMastiles(int cantidadMastiles) {
        this.cantidadMastiles = cantidadMastiles;
    }
}
