public class Embarcacion {
    private Capitan capitan;
    private double precioBase;
    private double valorAdicional;
    private int anioFabricación;
    private double eslora;

    public Embarcacion(Capitan capitan, double precioBase, double valorAdicional, int anioFabricación, double eslora) {
        this.capitan = capitan;
        this.precioBase = precioBase;
        this.valorAdicional = valorAdicional;
        this.anioFabricación = anioFabricación;
        this.eslora = eslora;
    }

    public double calcularMontoAlquiler(){
        double alquiler = precioBase;
        if(anioFabricación>2020){
            alquiler += valorAdicional;
        } else if (anioFabricación<= 2020) {
            //cuando es hecho antes del 2020 solo se le sumará el valor adicional por los camarotes/mastiles, pero no los 20000 extra por ser nuevo
            alquiler += valorAdicional -20000;
        }
        return alquiler;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public double getValorAdicional() {
        return valorAdicional;
    }

    public void setValorAdicional(double valorAdicional) {
        this.valorAdicional = valorAdicional;
    }
}
