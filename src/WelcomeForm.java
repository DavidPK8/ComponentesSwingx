import javax.swing.*;

public class WelcomeForm extends JFrame {
    public WelcomeForm(String username) {
        setTitle("Welcome");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JLabel welcomeLabel = new JLabel("¡Bienvenido, " + username + "!");
        welcomeLabel.setAlignmentX(CENTER_ALIGNMENT);

        JButton closeButton = new JButton("Cerrar sesión");
        closeButton.setAlignmentX(CENTER_ALIGNMENT);
        closeButton.addActionListener(e -> {
            LoginForm loginForm = new LoginForm();
            loginForm.setVisible(true);
            dispose(); // Cierra el formulario actual (WelcomeForm)
        });

        add(Box.createVerticalGlue());
        add(welcomeLabel);
        add(Box.createVerticalGlue());
        add(closeButton);

        // Centrar el formulario en la pantalla
        setLocationRelativeTo(null);
    }
}