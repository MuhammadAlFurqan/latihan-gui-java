import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Top-level container: JFrame (jendela utama)
public class LatihanGUI extends JFrame {

    private JTextField txtNama;
    private JLabel lblHasil;

    public LatihanGUI() {
        setTitle("Latihan GUI Java");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Intermediate container: JPanel untuk bagian input
        // Layout Class #1: GridLayout (2 baris, 2 kolom)
        JPanel panelInput = new JPanel(new GridLayout(2, 2, 5, 5));
        panelInput.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Atomic components: JLabel dan JTextField
        panelInput.add(new JLabel("Nama:"));
        txtNama = new JTextField();
        panelInput.add(txtNama);
        panelInput.add(new JLabel("Hasil:"));
        lblHasil = new JLabel("-");
        panelInput.add(lblHasil);

        // Intermediate container: JPanel untuk tombol
        // Layout Class #2: FlowLayout (tombol di tengah)
        JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnSapa = new JButton("Sapa");     // Atomic component: JButton
        JButton btnReset = new JButton("Reset");
        panelTombol.add(btnSapa);
        panelTombol.add(btnReset);

        // Layout Class #3: BorderLayout (pengatur posisi panel di frame)
        setLayout(new BorderLayout(10, 10));
        add(panelInput, BorderLayout.CENTER);
        add(panelTombol, BorderLayout.SOUTH);

        // Event Listener Interface: ActionListener
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

        // Event Listener dengan lambda (ActionListener juga)
        btnReset.addActionListener(e -> {
            txtNama.setText("");
            lblHasil.setText("-");
        });

        // Event Adapter Class: MouseAdapter
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