import javax.swing.*;
import java.awt.*;

public class FormDaftarUlang extends JFrame {

    JTextField namaField, tglLahirField, noPendaftaranField, noTelpField, emailField;
    JTextArea alamatArea;
    JButton submitButton;

    public FormDaftarUlang() {
        setTitle("Form Daftar Ulang Mahasiswa Baru");
        setSize(420, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        //panel form
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        namaField          = new JTextField(20);
        tglLahirField      = new JTextField(20);
        noPendaftaranField = new JTextField(20);
        noTelpField        = new JTextField(20);
        alamatArea         = new JTextArea(3, 20);
        emailField         = new JTextField(20);

        alamatArea.setLineWrap(true);
        JScrollPane alamatScroll = new JScrollPane(alamatArea);

        String[] labels = {"Nama Lengkap", "Tanggal Lahir", "Nomor Pendaftaran",
                           "No. Telp", "Alamat", "E-mail"};
        Component[] fields = {namaField, tglLahirField, noPendaftaranField,
                              noTelpField, alamatScroll, emailField};

        for (int i = 0; i < labels.length; i++) {
            gbc.gridx = 0; gbc.gridy = i; gbc.weightx = 0;
            formPanel.add(new JLabel(labels[i]), gbc);
            gbc.gridx = 1; gbc.weightx = 1;
            formPanel.add(fields[i], gbc);
        }

        //tombol submit
        submitButton = new JButton("Submit");
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 10));
        btnPanel.add(submitButton);

        add(formPanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);

        // action submit
        submitButton.addActionListener(e -> {
            // validasi (semua kolom harus diisi)
            if (namaField.getText().trim().isEmpty() ||
                tglLahirField.getText().trim().isEmpty() ||
                noPendaftaranField.getText().trim().isEmpty() ||
                noTelpField.getText().trim().isEmpty() ||
                alamatArea.getText().trim().isEmpty() ||
                emailField.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(this,
                    "Semua kolom harus diisi!", "Peringatan",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            // konfirmasi data
            int pilihan = JOptionPane.showConfirmDialog(this,
                "Apakah anda yakin data yang Anda isi sudah benar?",
                "Konfirmasi", JOptionPane.OK_CANCEL_OPTION);

            if (pilihan == JOptionPane.OK_OPTION) {
                tampilkanData();
            }
        });

        setVisible(true);
    }

    void tampilkanData() {
        JFrame dataFrame = new JFrame("Data Mahasiswa");
        dataFrame.setSize(320, 280);
        dataFrame.setLocationRelativeTo(this);
        dataFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // panel untuk menampilkan data
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel title = new JLabel("Data Mahasiswa", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.PLAIN, 13));
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        // text area untuk menampilkan data
        JTextArea dataArea = new JTextArea();
        dataArea.setEditable(false);
        dataArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        dataArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        dataArea.setText(String.format(
            "%-15s: %s%n%-15s: %s%n%-15s: %s%n%-15s: %s%n%-15s: %s%n%-15s: %s",
            "Nama",            namaField.getText(),
            "Tanggal Lahir",   tglLahirField.getText(),
            "No.Pendaftaran",  noPendaftaranField.getText(),
            "No.Telp",         noTelpField.getText(),
            "Alamat",          alamatArea.getText(),
            "E-mail",          emailField.getText()
        ));

        panel.add(title, BorderLayout.NORTH);
        panel.add(dataArea, BorderLayout.CENTER);
        dataFrame.add(panel);
        dataFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new FormDaftarUlang();
    }
}