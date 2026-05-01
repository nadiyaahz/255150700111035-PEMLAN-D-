import java.awt.*;
import java.awt.event.*;

public class MainFrame extends Frame {
    Label titleLabel, tugasLabel, kuisLabel, utsLabel, uasLabel, hasilLabel;
    TextField tugasField, kuisField, utsField, uasField, hasilField;
    Button hitungButton, tampilButton;

    CheckboxGroup group;
    Checkbox rbASD, rbPemlan, rbMatkomlan, rbProbstat;

    TextArea resultArea;

    public MainFrame() {
        setSize(320, 480);
        setLayout(new BorderLayout());

        //panel judul
        Panel topPanel = new Panel(new FlowLayout(FlowLayout.CENTER));
        titleLabel = new Label("Hitung Nilai Akhir");
        topPanel.add(titleLabel);

        //radio button
        Panel radioPanel = new Panel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        group = new CheckboxGroup();
        rbASD      = new Checkbox("ASD",      group, false);
        rbPemlan   = new Checkbox("Pemlan",   group, true);
        rbMatkomlan= new Checkbox("Matkomlan",group, false);
        rbProbstat = new Checkbox("Probstat", group, false);
        radioPanel.add(rbASD);
        radioPanel.add(rbPemlan);
        radioPanel.add(rbMatkomlan);
        radioPanel.add(rbProbstat);

        // panel form
        Panel formPanel = new Panel(new GridLayout(5, 2, 5, 5));
        tugasLabel = new Label("Tugas :");
        kuisLabel  = new Label("Kuis :");
        utsLabel   = new Label("UTS :");
        uasLabel   = new Label("UAS :");
        hasilLabel = new Label("Hasil :");

        tugasField = new TextField(10);
        kuisField  = new TextField(10);
        utsField   = new TextField(10);
        uasField   = new TextField(10);
        hasilField = new TextField(10);
        hasilField.setEditable(false);

        formPanel.add(tugasLabel); formPanel.add(tugasField);
        formPanel.add(kuisLabel);  formPanel.add(kuisField);
        formPanel.add(utsLabel);   formPanel.add(utsField);
        formPanel.add(uasLabel);   formPanel.add(uasField);
        formPanel.add(hasilLabel); formPanel.add(hasilField);

        // panel tengah
        Panel centerPanel = new Panel(new BorderLayout());
        centerPanel.add(radioPanel, BorderLayout.NORTH);

        Panel formWrapper = new Panel(new FlowLayout(FlowLayout.CENTER));
        formWrapper.add(formPanel);
        centerPanel.add(formWrapper, BorderLayout.CENTER);

        //hitung
        hitungButton = new Button("Hitung");
        Panel hitungPanel = new Panel(new FlowLayout(FlowLayout.CENTER));
        hitungPanel.add(hitungButton);
        centerPanel.add(hitungPanel, BorderLayout.SOUTH);

        // hasil semua matkul
        resultArea = new TextArea("HASIL NILAI SEMUA MATA KULIAH\n", 6, 30, TextArea.SCROLLBARS_BOTH);
        resultArea.setEditable(false);

        // tampil semua matkul
        tampilButton = new Button("Tampilkan nilai semua matkul");
        Panel tampilPanel = new Panel(new FlowLayout(FlowLayout.CENTER));
        tampilPanel.add(tampilButton);

        // panel bawah
 Panel bottomPanel = new Panel(new BorderLayout());
        bottomPanel.add(resultArea, BorderLayout.CENTER);
        bottomPanel.add(tampilPanel, BorderLayout.SOUTH);

        add(topPanel,    BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        hitungButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int nilaiTugas = Integer.parseInt(tugasField.getText());
                    int nilaiKuis  = Integer.parseInt(kuisField.getText());
                    int nilaiUTS   = Integer.parseInt(utsField.getText());
                    int nilaiUAS   = Integer.parseInt(uasField.getText());

                    MataKuliah mk;
                     if (rbPemlan.getState()) {
                        mk = new Pemlan();
                    } else if (rbASD.getState()) {
                        mk = new ASD();
                    } else if (rbMatkomlan.getState()) {
                        mk = new Matkomlan();
                    } else {
                        mk = new Probstat();
                    }

                    mk.setNilai(nilaiUTS, nilaiUAS, nilaiTugas, nilaiKuis);
                    double nilaiAkhir = mk.hitungNilaiAkhir();

                    hasilField.setText(String.valueOf(nilaiAkhir));
                } catch (NumberFormatException ex) {
                    hasilField.setText("Input tidak valid");
                }
            }
        });

        // tampilkan nilai semua matkul
        tampilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int nilaiTugas = Integer.parseInt(tugasField.getText());
                    int nilaiKuis  = Integer.parseInt(kuisField.getText());
                    int nilaiUTS   = Integer.parseInt(utsField.getText());
                    int nilaiUAS   = Integer.parseInt(uasField.getText());

                    MataKuliah[] semuaMK = {
                        new Pemlan(), new ASD(), new Matkomlan(), new Probstat()
                    };

                    StringBuilder sb = new StringBuilder("HASIL NILAI SEMUA MATA KULIAH\n\n");
                    for (MataKuliah mk : semuaMK) {
                        mk.setNilai(nilaiUTS, nilaiUAS, nilaiTugas, nilaiKuis);
                        sb.append(String.format("%-10s : %.1f%n", mk.getNama(), mk.hitungNilaiAkhir()));
                    }
                    resultArea.setText(sb.toString());
                } catch (NumberFormatException ex) {
                    resultArea.setText("Input tidak valid. Masukkan angka terlebih dahulu.");
                }
            }
        });

        // window
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setTitle("Hitung Nilai Akhir");
        mainFrame.setVisible(true);
    }
}