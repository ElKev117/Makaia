public class Main {
    public static void main(String[] args) {
        AutomovilConducible auto1 = new AutomovilConducible(4, "Toyota", "Yaris", 4, "Gasolina");
        MotocicletaConducible moto1 = new MotocicletaConducible(2, "Yamaha", "R1", 1000, "Deportiva");

        Propietario prop1 = new Propietario("Kevin", "gomez", auto1);
        Propietario prop2 = new Propietario("Maria", "Rodriguez", moto1);

        prop1.mostrar_informacion();
        prop2.mostrar_informacion();

    }
}