import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorUsuarios {
    private List<Usuario> usuarios;
    private String archivoDatos = "usuarios.dat";

    public GestorUsuarios() {
        usuarios = new ArrayList<>();
        cargarUsuarios();
    }

    private void cargarUsuarios() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoDatos))) {
            usuarios = (List<Usuario>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // El archivo aún no existe o está vacío
            usuarios = new ArrayList<>();
        }
    }

    public void guardarUsuarios() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoDatos))) {
            oos.writeObject(usuarios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        guardarUsuarios();
    }

    public boolean verificarUsuario(String nombreUsuario, String contrasena) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrasena().equals(contrasena)) {
                return true;
            }
        }
        return false;
    }
}