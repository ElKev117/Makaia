public class Main {
    public static void main(String[] args) {
        int filas, columnas;
        filas = 5;
        columnas = 10;
        Parqueadero parqueadero = new Parqueadero(filas, columnas, 1000);
        Carro carro1 = new Carro( "Toyota","ABC123", "Corolla");
        Carro carro2 = new Carro( "Mazda","DEF456", "3");
        Carro carro3 = new Carro( "Mazda","DEF456", "3");

        boolean sePuedeParquear1 = parqueadero.parquearCarro(carro1, 0, 0);
        boolean sePuedeParquear2 = parqueadero.parquearCarro(carro2, 0, 1);
        boolean sePuedeParquear3 = parqueadero.parquearCarro(carro3, 0, 0);

        double cobro1 = parqueadero.cobrarPorTiempo(carro1, 5);

        if(sePuedeParquear1){
            System.out.println("El parqueo fué exitoso");
        }else {
            System.out.println("No se puede parquear ya que la ubicación está fuera de los limites o el espacio ya está ocupado");
        }
        if(sePuedeParquear2){
            System.out.println("El parqueo fué exitoso");
        }else {
            System.out.println("No se puede parquear ya que la ubicación está fuera de los limites o el espacio ya está ocupado");
        }
        if(sePuedeParquear3){
            System.out.println("El parqueo fué exitoso");
        }else {
            System.out.println("No se puede parquear ya que la ubicación está fuera de los limites o el espacio ya está ocupado");
        }

        parqueadero.mostrarEstadoParqueadero(filas, columnas);
    }
}