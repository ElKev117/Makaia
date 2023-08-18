class AutomovilConducible extends Automovil implements Conducible {
    public AutomovilConducible(int ruedas, String marca, String modelo, int numero_puertas, String tipo_combustible) {
        super(ruedas, marca, modelo, numero_puertas, tipo_combustible);
    }

    @Override
    public void conducir() {
        System.out.println("El automovil esta en movimiento");
    }
}
