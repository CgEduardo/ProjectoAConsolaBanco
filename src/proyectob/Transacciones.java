
package proyectob;

import java.util.Scanner;


public class Transacciones {
Conexion c = new Conexion();
    Usuario u = new Usuario();
    Scanner te = new Scanner(System.in);
    
    int num;
    
    public boolean validacionTarjeta(int numeroTarjeta, int nip){
        u.setNumTarjeta(numeroTarjeta);
        u = c.seleccionarUsuario(u);
        if(nip==u.getNIP()){
            System.out.println(u.toString());
            num = numeroTarjeta;
            return true;            
        }        
        return false;
    }
    
    public boolean validacionFondos(int cantidad){
        Usuario usuarioA = new Usuario();
        usuarioA.setNumTarjeta(num);
        usuarioA = c.seleccionarUsuario(usuarioA);
        if(cantidad<=usuarioA.getFondosIni()){
            c.actualizacionFondos(usuarioA.getId(), (0-cantidad));
            return true;            
        }        
        return false;
    }
    
    public void deposito(int numt){
        System.out.println("Ingrese la cantidad a depositar ");
        int cantidad = te.nextInt();
        c.actualizacionFondos(u.getId(), cantidad);
        System.out.println("\nDeposito realizado con exito");
    }
    public void retiro(){
        System.out.println("Ingrese la cantidad a retirar");
        int cantidad = te.nextInt();
        if(validacionFondos(cantidad)==true){
            System.out.println("\nRetiro realizado con exito\n");
        }else{
            System.out.println("SALDO INSUFICIENTE");
            System.out.println("Desea intentarlo de nuevo?\nSI=1 NO=Cualquier Numero");
            int v =te.nextInt();
            if (v==1) {
                retiro();
            }
        }
    }
    
    public void verFondos(int numeroTarjeta){
        Usuario usuarioA = new Usuario();
        usuarioA.setNumTarjeta(numeroTarjeta);
        usuarioA = c.seleccionarUsuario(usuarioA);        
        System.out.println("\nFondos Actuales: " + usuarioA.getFondosIni());
    }    
}
