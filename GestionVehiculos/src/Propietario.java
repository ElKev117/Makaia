class Propietario {
    private String nombre;
    private String apellido;
    private Vehiculo vehiculo;

    public Propietario(String nombre, String apellido, Vehiculo vehiculo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.vehiculo = vehiculo;
    }

    public void mostrar_informacion() {
        System.out.println("Propietario: " + nombre + " " + apellido);
        System.out.println("Vehiculo:");
        vehiculo.obtener_informacion();
    }
}