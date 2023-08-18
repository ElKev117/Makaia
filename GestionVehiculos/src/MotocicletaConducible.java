public class MotocicletaConducible extends Motocicleta implements Conducible {
    public MotocicletaConducible(int ruedas, String marca, String modelo, int cilindrada, String tipo_manejo) {
        super(ruedas, marca, modelo, cilindrada, tipo_manejo);
    }

    @Override
    public void conducir() {
        System.out.println("La motocicleta esta en movimiento");
    }
}