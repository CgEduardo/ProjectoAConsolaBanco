
package proyectob;

import java.util.Scanner;

public class ProyectoB {

     static int seleccion;
    public static void main(String[] args) {
        int validar=0, numeroTarjeta, nip, menu;
        Scanner te = new Scanner(System.in);
        
        Usuario usuario = new Usuario();
        Conexion c = new Conexion();
        Transacciones caja = new Transacciones();
        
        Administracion admi = new Administracion();
        System.out.println("Menu");
        System.out.println("Nuevo Usuario: 1");
        System.out.println("Iniciar sesion: 2");
        validar = te.nextInt();
        while(validar==1){
            admi.crearCuenta();
            System.out.println("Desea agregar otro usuario?");
            System.out.println("Ingrese \n 1....SI \n 2....NO");
            validar = te.nextInt();
        }
        
        System.out.println(c.seleccionarUsuario(usuario)+"\n \n");
        System.out.println(c.Mostrarlist());
        
        
        
        
        
        System.out.println("******************************");
        System.out.println("INICIAR SESION");
        System.out.println("******************************");
        System.out.println("Ingrese el numero de tarjeta:");
        numeroTarjeta = te.nextInt();
        
        System.out.println("Ingrese su nip:");
        nip = te.nextInt();
        
        if(caja.validacionTarjeta(numeroTarjeta, nip)==true){
            do{
                seleccion=numeroTarjeta;
                System.out.println("---------------------------------");
                System.out.println("               MENU               ");
                System.out.println("----------------------------------");
                
                System.out.println("Elija un numero:");
                System.out.println("0)............. Fondos Actuales");
                System.out.println("1)............. Depositar");
                System.out.println("2)............... Retirar");
                System.out.println("3)............... Cerrar Sesion");
                menu = te.nextInt();
                
                switch(menu){
                    case 0:
                        caja.verFondos(seleccion);
                        break;
                    case 1:
                        caja.deposito(seleccion);
                        break;
                    case 2:
                        caja.retiro();
                        break;
                    case 3:
                        System.exit(0);
                        break;
                }
            }while(1==1);            
        }else{
            System.out.println("NIP erroneo");
        }  
    }
    
}
