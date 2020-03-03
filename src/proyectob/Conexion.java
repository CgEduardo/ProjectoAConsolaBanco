
package proyectob;


import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.util.ArrayList;
import java.util.List;

public class Conexion {
     private ObjectContainer db = null;

    private void abrirRegistro() {
        db = Db4oEmbedded.openFile("RegistroUsuario");
    }

    private void cerrarConexion() {
        db.close();
    }

    public void insertarRegistro(Usuario u) {
        abrirRegistro();
        db.store(u);
        cerrarConexion();
    }
    
     public List<Usuario> Mostrarlist()
        {
	abrirRegistro();
	ObjectSet listaUsuarios = db.queryByExample(Usuario.class);
	List<Usuario> lu = new ArrayList<>();
	for(Object listaUsuarios1 : listaUsuarios){
	    lu.add((Usuario) listaUsuarios1);
	}
	cerrarConexion();
	return lu;
	}
    
    public Usuario seleccionarUsuario(Usuario u) {
        abrirRegistro();
        ObjectSet resultado = db.queryByExample(u);
        Usuario usuario = (Usuario) resultado.next();
        cerrarConexion();
        return usuario;
    }
    
    public void actualizacionFondos(int id, int cantidad ){
        abrirRegistro();
        Usuario u = new Usuario();
        u.setId(id);
        ObjectSet resultado = db.queryByExample(u);
        
        Usuario preresultado = (Usuario) resultado.next();
        preresultado.setFondosIni(preresultado.getFondosIni() + cantidad);
        
        db.store(preresultado);
        cerrarConexion();
    }
    
   
}
