
package proyectob;

public class Usuario {
     private int id;
    private String nombreCompleto;
    private int edad;
    private int NIP;
    private int numTarjeta;
    private int fondosIni;
     private String Historial;
    private String tutor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNIP() {
        return NIP;
    }

    public void setNIP(int NIP) {
        this.NIP = NIP;
    }

    public int getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(int numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public int getFondosIni() {
        return fondosIni;
    }

    public void setFondosIni(int fondosIni) {
        this.fondosIni = fondosIni;
    }

    public String getHistorial() {
        return Historial;
    }

    public void setHistorial(String Historial) {
        this.Historial = Historial;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    @Override
    public String toString() {
        return "Usuario:" + "id=" + id +
                ", nombreCompleto=" + nombreCompleto +
                ", edad=" + edad +
                ", NIP=" + NIP +
                ", numTarjeta=" + numTarjeta +
                ", fondosIni=" + fondosIni +
                ", Historial=" + Historial +
                ", tutor=" + tutor + "\n" ;
    }
   
}
