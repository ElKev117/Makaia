public class Main {
    public static void main(String[] args) {
        String siNO;
        Capitan capitan1 = new Capitan("Juan", "Osorio", "12345");
        Capitan capitan2 = new Capitan("Kevin", "Gómez", "6789");
        Velero velero1 = new Velero(capitan1, 100000, 20000, 2021, 10.5, 5);
        Yate yate1 = new Yate(capitan2, 200000, 20000, 2019, 15.0, 10);

        velero1.setValorAdicional(velero1.getValorAdicional() + (velero1.getCantidadMastiles()*5000));
        yate1.setValorAdicional(yate1.getValorAdicional() + (yate1.getCantidadCamarotes()*9000));


        double montoAlquilerVelero1 = velero1.calcularMontoAlquiler();
        double montoAlquilerYate1 = yate1.calcularMontoAlquiler();

        boolean velero1EsGrande = velero1.esGrande();
        boolean yate1EsDeLujo = yate1.esDeLujo();
        if (velero1EsGrande){
            siNO = "si";
        }else {
            siNO = "no";
        }

        System.out.println("El velero tiene "+ velero1.getCantidadMastiles()+ " de mastiles por lo que "+ siNO+ " es grande y su valor total es de $"+ montoAlquilerVelero1+
                " y su capitán es "+ capitan1.getNombre()+ " " + capitan1.getApellido()+ " con maticula de navegción: "+ capitan1.getMatriculaNavegacion());

        if (yate1EsDeLujo){
            siNO = "si";
        }else {
            siNO = "no";
        }

        System.out.println("El velero tiene "+ yate1.getCantidadCamarotes() + " de camarotes por lo que "+ siNO+ " es de lujo y su valor total es de $"+ montoAlquilerYate1+
                " y su capitán es "+ capitan2.getNombre()+ " " + capitan2.getApellido()+ " con maticula de navegción: "+ capitan2.getMatriculaNavegacion());


    }
}