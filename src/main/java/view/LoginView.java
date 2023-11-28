package view;
import components.*;
import controller.LoginController;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class LoginView extends JFrame {
    private static Point initialClick;
    LoginController controller;
    public PanelUI panel;
    public LeftMenu leftPanel;
    public BlanckSpace emptySpace;
    public JSeparator separator;
    public JPanel rightPanel, formPanel, centerPanel, orPanel, registerPanel;
    public JLabel title, letterORLabel;
    public PrimaryButton loginButton;
    public SecondaryButton registerButton;
    public TextInput username;
    public PasswordInput password;
    public LoginView(LoginController controller) {
        //super("SnakeRush - Login");
        this.setUndecorated(true);
        this.controller = controller;
        //this.setJMenuBar(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(800, 500);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setLocationRelativeTo(null);
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
                requestFocusInWindow();
            }
        });
        this.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point currentScreenLocation = e.getLocationOnScreen();
                setLocation(currentScreenLocation.x - initialClick.x, currentScreenLocation.y - initialClick.y);
            }
        });
        initComponents();
    }
    private void initComponents() {
        centerPanel = new JPanel();
        registerPanel = new JPanel(new GridLayout(3, 0, 0, 0));
        registerPanel.setOpaque(false);
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        title = new JLabel("Login");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(new Color(33, 36, 39));
        title.setOpaque(false);
        centerPanel.add(title);
        centerPanel.setOpaque(false);
        loginButton = new PrimaryButton("Iniciar sesión");
        registerButton = new SecondaryButton("Registrarse");
        panel = new PanelUI();
        panel.setBackground(new Color(245, 246, 250));
        panel.setLayout(new GridBagLayout());
        panel.setFocusable(true);
        GridBagConstraints gbc = new GridBagConstraints();
        username = new TextInput("Ingrese usuario");
        password = new PasswordInput("*****");
        leftPanel = new LeftMenu();
        leftPanel.setBackground(new Color(99, 131, 250));
        //START RIGHT PANEL!!!!
        rightPanel = new RightMenu();
        rightPanel.setLayout(new GridBagLayout());
        rightPanel.setBackground(new Color(245, 246, 250));
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        gbc2.gridwidth = 1;
        gbc2.gridheight = 1;
        gbc2.weightx = 1;
        gbc2.weighty = 0;
        gbc2.fill = GridBagConstraints.HORIZONTAL;
        gbc2.anchor = GridBagConstraints.NORTHWEST;
        gbc2.insets = new Insets(-70, 0, 0, 0); // Ajusta los márgenes
        gbc2.ipady = 0; // Ajusta el espacio interior en la dirección y
        gbc2.ipadx = 0; // Ajusta el espacio interior en la dirección x
        formPanel = new JPanel(new GridLayout(4, 1, 0, 5));
        formPanel.setOpaque(false);
        formPanel.add(centerPanel);
        formPanel.add(username);
        formPanel.add(password);
        formPanel.add(loginButton);
        letterORLabel = new JLabel("Ó");
        separator = new JSeparator(SwingConstants.HORIZONTAL);
        letterORLabel.setFont(new Font("SFProDisplay-Regular", Font.PLAIN, 14));
        letterORLabel.setHorizontalAlignment(SwingConstants.CENTER);
        letterORLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        letterORLabel.setForeground(Color.GRAY);
        letterORLabel.setOpaque(false);
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        gbc2.gridwidth = 1;
        gbc2.gridheight = 1;
        gbc2.weightx = 1;
        gbc2.weighty = 0;
        gbc2.fill = GridBagConstraints.HORIZONTAL;
        //CON ESTO CAMBIAMOS LA ALTURA DEL PANEL FORM
        gbc2.insets = new Insets(-14, 0, 0, 0); // Ajusta los márgenes
        //Add components to the rightPanel
        //orPanel.add(registerPanel);
        rightPanel.add(formPanel,gbc2);
        gbc2.fill = GridBagConstraints.HORIZONTAL;
        gbc2.insets = new Insets(-2, 0, 0, 0); // Ajusta los márgenes
        gbc2.gridx = 0;
        gbc2.gridy = 2;
        gbc2.gridwidth = 2;
        gbc2.gridheight = 5;
        gbc2.weightx = 1;
        gbc2.weighty = 0;
        rightPanel.add(letterORLabel,gbc2);
        emptySpace = new BlanckSpace(35, 19);
        rightPanel.add(emptySpace,gbc2);
        gbc2.insets = new Insets(1, 0, 0, 0); // Ajusta los márgenes
        rightPanel.add(separator,gbc2);
        gbc2.fill = GridBagConstraints.HORIZONTAL;
        //rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 2.0;
        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        //gbc.insets = new Insets(4, 4, 4, 4);
        panel.add(leftPanel, gbc);
        gbc.gridx = 1;
        gbc.weightx = 1.5;
        panel.add(rightPanel, gbc);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
        this.add(panel);
        panel.requestFocusInWindow();
    }
}
