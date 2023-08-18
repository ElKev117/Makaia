public class Vehiculo {
    private int ruedas;
    private String marca;
    private String modelo;

    public Vehiculo(int ruedas, String marca, String modelo) {
        this.ruedas = ruedas;
        this.marca = marca;
        this.modelo = modelo;
    }

    public void obtener_informacion() {
        System.out.println("Ruedas: " + ruedas);
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
    }

}