package mx.unam.mcc.pa;

public class Simple {
    private static Simple INSTANCE = new Simple();
     
    //Se hace privada para evitar instanciacion directa
    private Simple() {
    }
 
    //Metodo para obtener la instancia
    public static Simple getInstance() {
        return INSTANCE;
    }
}