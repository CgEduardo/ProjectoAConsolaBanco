
package proyectob;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Administracion {
    Usuario u = new Usuario();
    Conexion c = new Conexion();

    
    public  void crearCuenta(){
        Scanner teclado = new Scanner(System.in);
        String cadena="";
        String fechadenacimiento;
        String salto;
        String dato1;
         int resultado;
        int cont=0;
        String datofijo="5555";
        int tarjeta1;
      int tarjeta2;
      int tarjeta3;
      
        // INSERT nuevo usuario
        int numero = (int)(Math.random()*(755-25+1)+25);
         tarjeta1 = (int)(Math.random()*(9999-1000+1)+1000);  
          tarjeta2 = (int)(Math.random()*(9999-1000+1)+1000);
           tarjeta3 = (int)(Math.random()*(9999-1000+1)+1000);
        u.setId(numero);
        
    

        System.out.println("**************************");
        System.out.println("Nuevo Usuario" );
        System.out.println("************************** \n");

        System.out.println("Ingrese el nombre:");
        u.setNombreCompleto(teclado.nextLine());
        
        System.out.println("Por favor ingresa tu fecha de nacimiento DD/MM/YYYY");
        fechadenacimiento=teclado.nextLine();
        
        DateTimeFormatter date=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechanacimiento=LocalDate.parse(fechadenacimiento, date);
        LocalDate fechaactual=LocalDate.now();
        
        //Calculo de la fecha actual con el año de nacimiento
        Period periodo = Period.between(fechanacimiento, fechaactual);
        resultado = Integer.parseInt(periodo.getYears()+"");   
        u.setEdad(resultado);
        
        //Validacion del campo tu tutor para verificar si lo necesita
        if(resultado>18){
        u.setTutor("Null");
        u.setEdad(resultado);
        }else{
        System.out.println("Al estar agregando un menor de edad es necesario ingresar de un tutor");
        u.setTutor(teclado.nextLine());
        u.setEdad(resultado);
        }
        
       
        System.out.println("Ingrese un NIP:");
        u.setNIP(teclado.nextInt());
        
        
        salto=Integer.toString(tarjeta1+tarjeta2+tarjeta3);
        System.out.println("Su numero de tarjeta es"+"\n"+datofijo+salto);
        u.setNumTarjeta(Integer.parseInt(datofijo+salto));  
        System.out.println("Ingrese un fondo inicial:");
        u.setFondosIni(teclado.nextInt());

        c.insertarRegistro(u);
        System.out.println("Datos Ingresados correctamente");
        
    }
}