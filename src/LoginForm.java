import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton; // Botón para registrar nuevo usuario
    private GestorUsuarios gestorUsuarios;

    public LoginForm() {
        // Configuración del JFrame
        setTitle("Login Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 5, 5));

        // Crear una instancia del GestorUsuarios para manejar los datos
        gestorUsuarios = new GestorUsuarios();

        // Componentes
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        registerButton = new JButton("Register");

        // Evento del botón de login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (verificarCredenciales(username, password)) {

                } else {
                    JOptionPane.showMessageDialog(LoginForm.this, "Nombre de usuario o contraseña incorrectos.",
                            "Error de login", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Evento del botón de registro
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                Usuario nuevoUsuario = new Usuario(username, password);
                gestorUsuarios.agregarUsuario(nuevoUsuario);

                JOptionPane.showMessageDialog(LoginForm.this, "Usuario registrado exitosamente.");
                usernameField.setText("");
                passwordField.setText("");
            }
        });

        // Agregar componentes al JFrame
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(registerButton);
        add(loginButton);
    }

    private boolean verificarCredenciales(String username, String password) {
        // Verificar las credenciales utilizando el GestorUsuarios
        if (gestorUsuarios.verificarUsuario(username, password)) {
            // Si las credenciales son válidas, abrir el WelcomeForm con el nombre de usuario
            WelcomeForm welcomeForm = new WelcomeForm(username);
            welcomeForm.setVisible(true);
            dispose(); // Cierra el formulario actual (LoginForm)
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginForm loginForm = new LoginForm();
                loginForm.setVisible(true);
            }
        });
    }
}