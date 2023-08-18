public class Parqueadero {
    private Carro[][] matriz;
    private double tarifaPorHora;

    public Parqueadero(int filas, int columnas, double tarifaPorHora) {
        this.matriz = new Carro[filas][columnas];
        this.tarifaPorHora = tarifaPorHora;
    }

    public boolean parquearCarro(Carro carro, int fila, int columna){
        if (fila >= 0 && fila < matriz.length && columna >= 0 && columna < matriz.length){
            if(matriz[fila][columna] == null){
                matriz[fila][columna] = carro;
                return true;
            }
        }return false;
    }

    public double cobrarPorTiempo(Carro carro, int horas){
        return (horas*tarifaPorHora);
    }

    public void mostrarEstadoParqueadero(int filas, int columnas){
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] == null) {
                    System.out.print("| ");
                    if(j==(columnas-1)){
                        System.out.print("|");
                    }
                } else {
                    System.out.print("|X");
                    if(j==(columnas-1)){
                        System.out.print("|");
                    }
                }
            }
            System.out.println();
        }
    }

    public Carro[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(Carro[][] matriz) {
        this.matriz = matriz;
    }

    public double getTarifaPorHora() {
        return tarifaPorHora;
    }

    public void setTarifaPorHora(double tarifaPorHora) {
        this.tarifaPorHora = tarifaPorHora;
    }


}
