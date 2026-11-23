import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LatihanGUI extends JFrame {

    private JTextField txtNama;
    private JLabel lblHasil;

    public LatihanGUI() {
        setTitle("Latihan GUI Java");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        JPanel panelInput = new JPanel(new GridLayout(2, 2, 5, 5));
        panelInput.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

       
        panelInput.add(new JLabel("Nama:"));
        txtNama = new JTextField();
        panelInput.add(txtNama);
        panelInput.add(new JLabel("Hasil:"));
        lblHasil = new JLabel("-");
        panelInput.add(lblHasil);


        JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnSapa = new JButton("Sapa");     
        JButton btnReset = new JButton("Reset");
        panelTombol.add(btnSapa);
        panelTombol.add(btnReset);

        setLayout(new BorderLayout(10, 10));
        add(panelInput, BorderLayout.CENTER);
        add(panelTombol, BorderLayout.SOUTH);

        btnSapa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = txtNama.getText();
                if (nama.isEmpty()) {
                    lblHasil.setText("Isi nama dulu!");
                } else {
                    lblHasil.setText("Halo, " + nama + "!");
                }
            }
        });

        btnReset.addActionListener(e -> {
            txtNama.setText("");
            lblHasil.setText("-");
        });

        lblHasil.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lblHasil.setText("Label diklik!");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LatihanGUI().setVisible(true));
    }
}
