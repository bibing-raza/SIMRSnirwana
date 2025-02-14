/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DlgPenyakit.java
 *
 * Created on May 23, 2010, 12:57:16 AM
 */

package bridging;

import simrskhanza.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fungsi.WarnaTable;
import fungsi.batasInput;
import fungsi.koneksiDB;
import fungsi.validasi;
import fungsi.akses;
import fungsi.sekuel;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

/**
 *
 * @author dosen
 */
public final class DlgTambahAntrian extends javax.swing.JDialog {
    private validasi Valid = new validasi();
    private Connection koneksi = koneksiDB.condb();
    private sekuel Sequel = new sekuel();
    private HttpHeaders headers;
    private HttpEntity requestEntity;
    private ObjectMapper mapper = new ObjectMapper();
    private JsonNode root;
    private JsonNode nameNode;
    private JsonNode response;
    private BPJSCekReferensiPoli poli = new BPJSCekReferensiPoli(null, false);
    private BPJSCekReferensiDokterDPJP dokter = new BPJSCekReferensiDokterDPJP(null, false);
    private String utc = "", URL = "", link = "", requestJson = "";
    private ApiMobileJKN api = new ApiMobileJKN();
    
    /** Creates new form DlgPenyakit
     * @param parent
     * @param modal */
    public DlgTambahAntrian(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocation(10,2);
        setSize(656,250);

        TsisaKuota.setDocument(new batasInput((byte) 3).getOnlyAngka(TsisaKuota));
        TkuotaJkn.setDocument(new batasInput((byte) 3).getOnlyAngka(TkuotaJkn));
        TsisaNon.setDocument(new batasInput((byte) 3).getOnlyAngka(TsisaNon));
        TkuotaNon.setDocument(new batasInput((byte) 3).getOnlyAngka(TkuotaNon));
        
        poli.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}
            @Override
            public void windowClosing(WindowEvent e) {}
            @Override
            public void windowClosed(WindowEvent e) {
                if (poli.getTable().getSelectedRow() != -1) {
                    TkdPoli.setText(poli.getTable().getValueAt(poli.getTable().getSelectedRow(), 1).toString());
                    TnmPoli.setText(poli.getTable().getValueAt(poli.getTable().getSelectedRow(), 2).toString());
                    btnPoli.requestFocus();
                }
            }
            @Override
            public void windowIconified(WindowEvent e) {}
            @Override
            public void windowDeiconified(WindowEvent e) {}
            @Override
            public void windowActivated(WindowEvent e) {}
            @Override
            public void windowDeactivated(WindowEvent e) {}
        });
     
        poli.getTable().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    poli.dispose();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        dokter.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}
            @Override
            public void windowClosing(WindowEvent e) {}
            @Override
            public void windowClosed(WindowEvent e) {
                if (dokter.getTable().getSelectedRow() != -1) {
                    TkdDokter.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(), 1).toString());
                    TnmDokter.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(), 2).toString());
                    btnDokter.requestFocus();
                }
            }
            @Override
            public void windowIconified(WindowEvent e) {}
            @Override
            public void windowDeiconified(WindowEvent e) {}
            @Override
            public void windowActivated(WindowEvent e) {}
            @Override
            public void windowDeactivated(WindowEvent e) {}
        });
        
        dokter.getTable().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_SPACE){
                    dokter.dispose();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {}
        });
        
        try {
            link = koneksiDB.URLAPIMOBILEJKN();
        } catch (Exception e) {
            System.out.println("E : " + e);
        }
    }    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        internalFrame1 = new widget.InternalFrame();
        panelisi4 = new widget.panelisi();
        jLabel4 = new widget.Label();
        TNoRw = new widget.TextBox();
        TNoRM = new widget.TextBox();
        TPasien = new widget.TextBox();
        jLabel5 = new widget.Label();
        cmbJenisPasien = new widget.ComboBox();
        jLabel6 = new widget.Label();
        TnoKartu = new widget.TextBox();
        jLabel7 = new widget.Label();
        Tnik = new widget.TextBox();
        jLabel8 = new widget.Label();
        TnoHp = new widget.TextBox();
        jLabel9 = new widget.Label();
        TkdPoli = new widget.TextBox();
        TnmPoli = new widget.TextBox();
        jLabel11 = new widget.Label();
        cmbPasienBaru = new widget.ComboBox();
        jLabel12 = new widget.Label();
        TtglPeriksa = new widget.Tanggal();
        btnPoli = new widget.Button();
        jLabel13 = new widget.Label();
        TkdDokter = new widget.TextBox();
        TnmDokter = new widget.TextBox();
        btnDokter = new widget.Button();
        jLabel14 = new widget.Label();
        jLabel15 = new widget.Label();
        cmbJenisKunjungan = new widget.ComboBox();
        jLabel16 = new widget.Label();
        TnoReferensi = new widget.TextBox();
        jLabel17 = new widget.Label();
        TnoAntrian = new widget.TextBox();
        jLabel18 = new widget.Label();
        TangkaAntrian = new widget.TextBox();
        jLabel19 = new widget.Label();
        Testimasi = new widget.TextBox();
        jLabel20 = new widget.Label();
        TsisaKuota = new widget.TextBox();
        jLabel21 = new widget.Label();
        TkuotaJkn = new widget.TextBox();
        jLabel22 = new widget.Label();
        TsisaNon = new widget.TextBox();
        jLabel23 = new widget.Label();
        Tketerangan = new widget.TextBox();
        TjamPraktek = new widget.TextBox();
        jLabel24 = new widget.Label();
        TkuotaNon = new widget.TextBox();
        jLabel25 = new widget.Label();
        Tnotif = new widget.TextBox();
        jLabel26 = new widget.Label();
        TnoBoking = new widget.TextBox();
        panelisi6 = new widget.panelisi();
        BtnSimpan = new widget.Button();
        BtnBatal = new widget.Button();
        BtnKeluar = new widget.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Tambah Antrian Online ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(50, 50, 50))); // NOI18N
        internalFrame1.setName("internalFrame1"); // NOI18N
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

        panelisi4.setName("panelisi4"); // NOI18N
        panelisi4.setPreferredSize(new java.awt.Dimension(400, 268));
        panelisi4.setLayout(null);

        jLabel4.setText("No.Rawat :");
        jLabel4.setName("jLabel4"); // NOI18N
        panelisi4.add(jLabel4);
        jLabel4.setBounds(0, 10, 110, 23);

        TNoRw.setEditable(false);
        TNoRw.setBackground(new java.awt.Color(245, 250, 240));
        TNoRw.setName("TNoRw"); // NOI18N
        panelisi4.add(TNoRw);
        TNoRw.setBounds(113, 10, 152, 23);

        TNoRM.setName("TNoRM"); // NOI18N
        panelisi4.add(TNoRM);
        TNoRM.setBounds(267, 10, 110, 23);

        TPasien.setEditable(false);
        TPasien.setBackground(new java.awt.Color(245, 250, 240));
        TPasien.setName("TPasien"); // NOI18N
        panelisi4.add(TPasien);
        TPasien.setBounds(379, 10, 368, 23);

        jLabel5.setText("Jenis Pasien :");
        jLabel5.setName("jLabel5"); // NOI18N
        panelisi4.add(jLabel5);
        jLabel5.setBounds(0, 38, 110, 23);

        cmbJenisPasien.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "JKN", "NON JKN" }));
        cmbJenisPasien.setEnabled(false);
        cmbJenisPasien.setName("cmbJenisPasien"); // NOI18N
        panelisi4.add(cmbJenisPasien);
        cmbJenisPasien.setBounds(113, 38, 75, 23);

        jLabel6.setText("No. Kartu :");
        jLabel6.setName("jLabel6"); // NOI18N
        panelisi4.add(jLabel6);
        jLabel6.setBounds(190, 38, 70, 23);

        TnoKartu.setEditable(false);
        TnoKartu.setBackground(new java.awt.Color(245, 250, 240));
        TnoKartu.setName("TnoKartu"); // NOI18N
        panelisi4.add(TnoKartu);
        TnoKartu.setBounds(264, 38, 190, 23);

        jLabel7.setText("NIK :");
        jLabel7.setName("jLabel7"); // NOI18N
        panelisi4.add(jLabel7);
        jLabel7.setBounds(456, 38, 50, 23);

        Tnik.setBackground(new java.awt.Color(245, 250, 240));
        Tnik.setName("Tnik"); // NOI18N
        panelisi4.add(Tnik);
        Tnik.setBounds(512, 38, 236, 23);

        jLabel8.setText("No. HP :");
        jLabel8.setName("jLabel8"); // NOI18N
        panelisi4.add(jLabel8);
        jLabel8.setBounds(0, 66, 110, 23);

        TnoHp.setBackground(new java.awt.Color(245, 250, 240));
        TnoHp.setName("TnoHp"); // NOI18N
        panelisi4.add(TnoHp);
        TnoHp.setBounds(113, 66, 152, 23);

        jLabel9.setText("Kode Poli :");
        jLabel9.setName("jLabel9"); // NOI18N
        panelisi4.add(jLabel9);
        jLabel9.setBounds(0, 94, 110, 23);

        TkdPoli.setEditable(false);
        TkdPoli.setBackground(new java.awt.Color(245, 250, 240));
        TkdPoli.setName("TkdPoli"); // NOI18N
        panelisi4.add(TkdPoli);
        TkdPoli.setBounds(113, 94, 60, 23);

        TnmPoli.setEditable(false);
        TnmPoli.setBackground(new java.awt.Color(245, 250, 240));
        TnmPoli.setName("TnmPoli"); // NOI18N
        panelisi4.add(TnmPoli);
        TnmPoli.setBounds(176, 94, 300, 23);

        jLabel11.setText("Pasien Baru :");
        jLabel11.setName("jLabel11"); // NOI18N
        panelisi4.add(jLabel11);
        jLabel11.setBounds(265, 66, 80, 23);

        cmbPasienBaru.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "1(Ya)", "0(Tidak)" }));
        cmbPasienBaru.setEnabled(false);
        cmbPasienBaru.setName("cmbPasienBaru"); // NOI18N
        panelisi4.add(cmbPasienBaru);
        cmbPasienBaru.setBounds(350, 66, 75, 23);

        jLabel12.setText("Tgl. Periksa :");
        jLabel12.setName("jLabel12"); // NOI18N
        panelisi4.add(jLabel12);
        jLabel12.setBounds(427, 66, 80, 23);

        TtglPeriksa.setForeground(new java.awt.Color(50, 70, 50));
        TtglPeriksa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "12-02-2025" }));
        TtglPeriksa.setDisplayFormat("dd-MM-yyyy");
        TtglPeriksa.setEnabled(false);
        TtglPeriksa.setName("TtglPeriksa"); // NOI18N
        TtglPeriksa.setOpaque(false);
        TtglPeriksa.setPreferredSize(new java.awt.Dimension(95, 23));
        panelisi4.add(TtglPeriksa);
        TtglPeriksa.setBounds(512, 66, 95, 23);

        btnPoli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnPoli.setMnemonic('X');
        btnPoli.setToolTipText("Alt+X");
        btnPoli.setName("btnPoli"); // NOI18N
        btnPoli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPoliActionPerformed(evt);
            }
        });
        panelisi4.add(btnPoli);
        btnPoli.setBounds(480, 94, 28, 23);

        jLabel13.setText("Kode Dokter :");
        jLabel13.setName("jLabel13"); // NOI18N
        panelisi4.add(jLabel13);
        jLabel13.setBounds(0, 122, 110, 23);

        TkdDokter.setEditable(false);
        TkdDokter.setBackground(new java.awt.Color(245, 250, 240));
        TkdDokter.setName("TkdDokter"); // NOI18N
        panelisi4.add(TkdDokter);
        TkdDokter.setBounds(113, 122, 60, 23);

        TnmDokter.setEditable(false);
        TnmDokter.setBackground(new java.awt.Color(245, 250, 240));
        TnmDokter.setName("TnmDokter"); // NOI18N
        panelisi4.add(TnmDokter);
        TnmDokter.setBounds(176, 122, 300, 23);

        btnDokter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnDokter.setMnemonic('X');
        btnDokter.setToolTipText("Alt+X");
        btnDokter.setName("btnDokter"); // NOI18N
        btnDokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDokterActionPerformed(evt);
            }
        });
        panelisi4.add(btnDokter);
        btnDokter.setBounds(480, 122, 28, 23);

        jLabel14.setText("Jam Praktek :");
        jLabel14.setName("jLabel14"); // NOI18N
        panelisi4.add(jLabel14);
        jLabel14.setBounds(543, 122, 80, 23);

        jLabel15.setText("Jenis Kunjungan :");
        jLabel15.setName("jLabel15"); // NOI18N
        panelisi4.add(jLabel15);
        jLabel15.setBounds(0, 150, 110, 23);

        cmbJenisKunjungan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "1 (Rujukan FKTP)", "2 (Rujukan Internal)", "3 (Kontrol)", "4 (Rujukan Antar RS)" }));
        cmbJenisKunjungan.setName("cmbJenisKunjungan"); // NOI18N
        panelisi4.add(cmbJenisKunjungan);
        cmbJenisKunjungan.setBounds(113, 150, 135, 23);

        jLabel16.setText("Nomor Referensi :");
        jLabel16.setName("jLabel16"); // NOI18N
        panelisi4.add(jLabel16);
        jLabel16.setBounds(340, 150, 110, 23);

        TnoReferensi.setBackground(new java.awt.Color(245, 250, 240));
        TnoReferensi.setName("TnoReferensi"); // NOI18N
        panelisi4.add(TnoReferensi);
        TnoReferensi.setBounds(455, 150, 292, 23);

        jLabel17.setText("Nomor Antrian :");
        jLabel17.setName("jLabel17"); // NOI18N
        panelisi4.add(jLabel17);
        jLabel17.setBounds(0, 178, 110, 23);

        TnoAntrian.setBackground(new java.awt.Color(245, 250, 240));
        TnoAntrian.setName("TnoAntrian"); // NOI18N
        panelisi4.add(TnoAntrian);
        TnoAntrian.setBounds(113, 178, 60, 23);

        jLabel18.setText("Angka Antrian :");
        jLabel18.setName("jLabel18"); // NOI18N
        panelisi4.add(jLabel18);
        jLabel18.setBounds(175, 178, 90, 23);

        TangkaAntrian.setBackground(new java.awt.Color(245, 250, 240));
        TangkaAntrian.setName("TangkaAntrian"); // NOI18N
        panelisi4.add(TangkaAntrian);
        TangkaAntrian.setBounds(268, 178, 60, 23);

        jLabel19.setText("Estimasi Dilayani :");
        jLabel19.setName("jLabel19"); // NOI18N
        panelisi4.add(jLabel19);
        jLabel19.setBounds(350, 178, 100, 23);

        Testimasi.setEditable(false);
        Testimasi.setBackground(new java.awt.Color(245, 250, 240));
        Testimasi.setName("Testimasi"); // NOI18N
        panelisi4.add(Testimasi);
        Testimasi.setBounds(455, 178, 218, 23);

        jLabel20.setText("Sisa Kuota JKN :");
        jLabel20.setName("jLabel20"); // NOI18N
        panelisi4.add(jLabel20);
        jLabel20.setBounds(0, 206, 110, 23);

        TsisaKuota.setBackground(new java.awt.Color(245, 250, 240));
        TsisaKuota.setName("TsisaKuota"); // NOI18N
        panelisi4.add(TsisaKuota);
        TsisaKuota.setBounds(113, 206, 60, 23);

        jLabel21.setText("Kuota JKN :");
        jLabel21.setName("jLabel21"); // NOI18N
        panelisi4.add(jLabel21);
        jLabel21.setBounds(175, 206, 90, 23);

        TkuotaJkn.setBackground(new java.awt.Color(245, 250, 240));
        TkuotaJkn.setName("TkuotaJkn"); // NOI18N
        panelisi4.add(TkuotaJkn);
        TkuotaJkn.setBounds(268, 206, 60, 23);

        jLabel22.setText("Sisa Non JKN :");
        jLabel22.setName("jLabel22"); // NOI18N
        panelisi4.add(jLabel22);
        jLabel22.setBounds(350, 206, 100, 23);

        TsisaNon.setBackground(new java.awt.Color(245, 250, 240));
        TsisaNon.setName("TsisaNon"); // NOI18N
        panelisi4.add(TsisaNon);
        TsisaNon.setBounds(455, 206, 60, 23);

        jLabel23.setText("Keterangan :");
        jLabel23.setName("jLabel23"); // NOI18N
        panelisi4.add(jLabel23);
        jLabel23.setBounds(0, 234, 110, 23);

        Tketerangan.setBackground(new java.awt.Color(245, 250, 240));
        Tketerangan.setName("Tketerangan"); // NOI18N
        panelisi4.add(Tketerangan);
        Tketerangan.setBounds(113, 234, 630, 23);

        TjamPraktek.setBackground(new java.awt.Color(245, 250, 240));
        TjamPraktek.setName("TjamPraktek"); // NOI18N
        panelisi4.add(TjamPraktek);
        TjamPraktek.setBounds(628, 122, 120, 23);

        jLabel24.setText("Kuota Non JKN :");
        jLabel24.setName("jLabel24"); // NOI18N
        panelisi4.add(jLabel24);
        jLabel24.setBounds(520, 206, 90, 23);

        TkuotaNon.setBackground(new java.awt.Color(245, 250, 240));
        TkuotaNon.setName("TkuotaNon"); // NOI18N
        panelisi4.add(TkuotaNon);
        TkuotaNon.setBounds(613, 206, 60, 23);

        jLabel25.setText("Notifikasi WS :");
        jLabel25.setName("jLabel25"); // NOI18N
        panelisi4.add(jLabel25);
        jLabel25.setBounds(0, 262, 110, 23);

        Tnotif.setEditable(false);
        Tnotif.setBackground(new java.awt.Color(245, 250, 240));
        Tnotif.setForeground(new java.awt.Color(0, 0, 255));
        Tnotif.setName("Tnotif"); // NOI18N
        panelisi4.add(Tnotif);
        Tnotif.setBounds(113, 262, 630, 23);

        jLabel26.setText("No. Booking :");
        jLabel26.setName("jLabel26"); // NOI18N
        panelisi4.add(jLabel26);
        jLabel26.setBounds(513, 94, 80, 23);

        TnoBoking.setEditable(false);
        TnoBoking.setBackground(new java.awt.Color(245, 250, 240));
        TnoBoking.setForeground(new java.awt.Color(0, 0, 255));
        TnoBoking.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TnoBoking.setName("TnoBoking"); // NOI18N
        panelisi4.add(TnoBoking);
        TnoBoking.setBounds(596, 94, 152, 23);

        internalFrame1.add(panelisi4, java.awt.BorderLayout.CENTER);

        panelisi6.setName("panelisi6"); // NOI18N
        panelisi6.setPreferredSize(new java.awt.Dimension(100, 43));
        panelisi6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 4, 9));

        BtnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/save-16x16.png"))); // NOI18N
        BtnSimpan.setMnemonic('S');
        BtnSimpan.setText("Simpan");
        BtnSimpan.setToolTipText("Alt+S");
        BtnSimpan.setName("BtnSimpan"); // NOI18N
        BtnSimpan.setPreferredSize(new java.awt.Dimension(100, 23));
        BtnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSimpanActionPerformed(evt);
            }
        });
        BtnSimpan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnSimpanKeyPressed(evt);
            }
        });
        panelisi6.add(BtnSimpan);

        BtnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Cancel-2-16x16.png"))); // NOI18N
        BtnBatal.setMnemonic('B');
        BtnBatal.setText("Baru");
        BtnBatal.setToolTipText("Alt+B");
        BtnBatal.setName("BtnBatal"); // NOI18N
        BtnBatal.setPreferredSize(new java.awt.Dimension(100, 23));
        BtnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBatalActionPerformed(evt);
            }
        });
        BtnBatal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnBatalKeyPressed(evt);
            }
        });
        panelisi6.add(BtnBatal);

        BtnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/exit.png"))); // NOI18N
        BtnKeluar.setMnemonic('4');
        BtnKeluar.setText("Keluar");
        BtnKeluar.setToolTipText("Alt+4");
        BtnKeluar.setName("BtnKeluar"); // NOI18N
        BtnKeluar.setPreferredSize(new java.awt.Dimension(80, 23));
        BtnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKeluarActionPerformed(evt);
            }
        });
        panelisi6.add(BtnKeluar);

        internalFrame1.add(panelisi6, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        dispose();
    }//GEN-LAST:event_BtnKeluarActionPerformed

    private void btnPoliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPoliActionPerformed
        akses.setform("DlgTambahAntrian");
        poli.setSize(internalFrame1.getWidth() - 40, internalFrame1.getHeight() - 40);
        poli.setLocationRelativeTo(internalFrame1);
        poli.setVisible(true);
    }//GEN-LAST:event_btnPoliActionPerformed

    private void btnDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDokterActionPerformed
        akses.setform("DlgTambahAntrian");
        dokter.setSize(internalFrame1.getWidth() - 40, internalFrame1.getHeight() - 40);
        dokter.setLocationRelativeTo(internalFrame1);
        dokter.setVisible(true);
    }//GEN-LAST:event_btnDokterActionPerformed

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        if (TNoRw.getText().trim().equals("") || TPasien.getText().trim().equals("")) {
            Valid.textKosong(TNoRw, "Pasien");
        } else {
            if (Sequel.cariInteger("select count(-1) from antrol_bpjs where kd_booking='" + TNoRw.getText() + "' and respon_taskid_0 in ('200','208')") == 0) {
                kirimAntrol();
            } else {
                JOptionPane.showMessageDialog(null,"Data antrian online pasien ini sudah tersimpan...!!!");
                emptTeks();
            }
        }
    }//GEN-LAST:event_BtnSimpanActionPerformed

    private void BtnSimpanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnSimpanKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            BtnSimpanActionPerformed(null);
        }
    }//GEN-LAST:event_BtnSimpanKeyPressed

    private void BtnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatalActionPerformed
        emptTeks();
    }//GEN-LAST:event_BtnBatalActionPerformed

    private void BtnBatalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnBatalKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            emptTeks();
        }
    }//GEN-LAST:event_BtnBatalKeyPressed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            DlgTambahAntrian dialog = new DlgTambahAntrian(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private widget.Button BtnBatal;
    private widget.Button BtnKeluar;
    private widget.Button BtnSimpan;
    private widget.TextBox TNoRM;
    private widget.TextBox TNoRw;
    private widget.TextBox TPasien;
    private widget.TextBox TangkaAntrian;
    private widget.TextBox Testimasi;
    private widget.TextBox TjamPraktek;
    private widget.TextBox TkdDokter;
    private widget.TextBox TkdPoli;
    private widget.TextBox Tketerangan;
    private widget.TextBox TkuotaJkn;
    private widget.TextBox TkuotaNon;
    private widget.TextBox Tnik;
    private widget.TextBox TnmDokter;
    private widget.TextBox TnmPoli;
    private widget.TextBox TnoAntrian;
    private widget.TextBox TnoBoking;
    private widget.TextBox TnoHp;
    private widget.TextBox TnoKartu;
    private widget.TextBox TnoReferensi;
    private widget.TextBox Tnotif;
    private widget.TextBox TsisaKuota;
    private widget.TextBox TsisaNon;
    private widget.Tanggal TtglPeriksa;
    private widget.Button btnDokter;
    private widget.Button btnPoli;
    private widget.ComboBox cmbJenisKunjungan;
    private widget.ComboBox cmbJenisPasien;
    private widget.ComboBox cmbPasienBaru;
    private widget.InternalFrame internalFrame1;
    private widget.Label jLabel11;
    private widget.Label jLabel12;
    private widget.Label jLabel13;
    private widget.Label jLabel14;
    private widget.Label jLabel15;
    private widget.Label jLabel16;
    private widget.Label jLabel17;
    private widget.Label jLabel18;
    private widget.Label jLabel19;
    private widget.Label jLabel20;
    private widget.Label jLabel21;
    private widget.Label jLabel22;
    private widget.Label jLabel23;
    private widget.Label jLabel24;
    private widget.Label jLabel25;
    private widget.Label jLabel26;
    private widget.Label jLabel4;
    private widget.Label jLabel5;
    private widget.Label jLabel6;
    private widget.Label jLabel7;
    private widget.Label jLabel8;
    private widget.Label jLabel9;
    private widget.panelisi panelisi4;
    private widget.panelisi panelisi6;
    // End of variables declaration//GEN-END:variables

    public void emptTeks() {
        TtglPeriksa.setDate(new Date());
        TtglPeriksa.requestFocus();
        TkdPoli.setText("");
        TnmPoli.setText("");
        TkdDokter.setText("");
        TnmDokter.setText("");
        cmbJenisKunjungan.setSelectedIndex(0);
        TnoReferensi.setText("");
        TnoAntrian.setText("");
        TangkaAntrian.setText("");
        Testimasi.setText("");
        TsisaKuota.setText("");
        TkuotaJkn.setText("");
        TsisaNon.setText("");
        TkuotaNon.setText("");
        Tketerangan.setText("");
        Tnotif.setText("");
        TnoBoking.setText("");
    }
    
    public void setData(String norw, String norm, String nmpasien, String noka, String kdpoli, String nmpoli, String kddokter, 
            String nmdokter, String noreferensi, String jnsKun) {
        TNoRw.setText(norw);
        TNoRM.setText(norm);
        TPasien.setText(nmpasien);
        cmbJenisPasien.setSelectedIndex(1);
        TnoKartu.setText(noka);
        Tnik.setText(Sequel.cariIsi("select no_ktp from pasien where no_rkm_medis='" + norm + "'"));
        TnoHp.setText(Sequel.cariIsi("select no_tlp from pasien where no_rkm_medis='" + norm + "'"));
        Valid.SetTgl(TtglPeriksa, Sequel.cariIsi("select tgl_registrasi from reg_periksa where no_rawat='" + norw + "'"));        
        TnoReferensi.setText(noreferensi);        
        Tketerangan.setText("-");
        Testimasi.setText(Sequel.cariIsi("select LEFT((UNIX_TIMESTAMP(concat(tgl_registrasi,' ',jam_reg)))*1000,13) hasil from reg_periksa WHERE no_rawat='" + norw + "'"));

        TnoBoking.setText(Sequel.cariIsi("select nobooking from referensi_mobilejkn_bpjs where no_rawat='" + norw + "'"));
        if (TnoBoking.getText().equals("")) {
            TnoBoking.setText(norw);
            TnoAntrian.setText(Sequel.cariIsi("select no_antrian from antrian_history where no_rawat='" + norw + "'"));
            TangkaAntrian.setText(TnoAntrian.getText());
        } else {
            TnoBoking.setText(TnoBoking.getText());
            TnoAntrian.setText(Sequel.cariIsi("select nomorantrean from referensi_mobilejkn_bpjs where no_rawat='" + norw + "'"));
            TangkaAntrian.setText(Sequel.cariIsi("select angkaantrean from referensi_mobilejkn_bpjs where no_rawat='" + norw + "'"));
        }
        
        if (kdpoli.equals("")) {
            TkdPoli.setText(Sequel.cariIsi("select m.kd_poli_bpjs from reg_periksa rp inner join maping_poli_bpjs m on m.kd_poli_rs=rp.kd_poli where rp.no_rawat='" + norw + "'"));
            TnmPoli.setText(Sequel.cariIsi("select m.nm_poli_bpjs from reg_periksa rp inner join maping_poli_bpjs m on m.kd_poli_rs=rp.kd_poli where rp.no_rawat='" + norw + "'"));
        } else {
            TkdPoli.setText(kdpoli);
            TnmPoli.setText(nmpoli);
        }

        if (kddokter.equals("")) {
            TkdDokter.setText(Sequel.cariIsi("select m.kd_dokter_bpjs from reg_periksa rp inner join maping_dokter_dpjpvclaim m on m.kd_dokter_bpjs=rp.kd_dokter "
                    + "where rp.no_rawat='" + norw + "'"));
            TnmDokter.setText(Sequel.cariIsi("select m.nm_dokter_bpjs from reg_periksa rp inner join maping_dokter_dpjpvclaim m on m.kd_dokter_bpjs=rp.kd_dokter "
                    + "where rp.no_rawat='" + norw + "'"));
        } else {
            TkdDokter.setText(kddokter);
            TnmDokter.setText(nmdokter);
        }
        
        if (Sequel.cariIsi("select ifnull(j.kuota,'60') from jadwal j inner join maping_dokter_dpjpvclaim m on m.kd_dokter=j.kd_dokter "
                + "where m.kd_dokter_bpjs='" + TkdDokter.getText() + "'").equals("")) {
            TkuotaJkn.setText("60");
            TkuotaNon.setText(TkuotaJkn.getText());
        } else {
            TkuotaJkn.setText(Sequel.cariIsi("select ifnull(j.kuota,'60') from jadwal j inner join maping_dokter_dpjpvclaim m on m.kd_dokter=j.kd_dokter "
                    + "where m.kd_dokter_bpjs='" + TkdDokter.getText() + "'"));
            TkuotaNon.setText(TkuotaJkn.getText());
        }

        TsisaKuota.setText(Sequel.cariIsi("SELECT count(-1) FROM reg_periksa rp INNER JOIN maping_dokter_dpjpvclaim m ON m.kd_dokter=rp.kd_dokter "
                + "WHERE rp.tgl_registrasi=DATE(NOW()) AND rp.kd_poli='" + TkdPoli.getText() + "' AND m.kd_dokter_bpjs='" + TkdDokter.getText() + "'"));
        TsisaNon.setText(TsisaKuota.getText());

        TjamPraktek.setText(Sequel.cariIsi("select concat(time_format(j.jam_mulai,'%H:%i'),'-',time_format(j.jam_selesai,'%H:%i')) from jadwal j "
                + "inner join maping_dokter_dpjpvclaim m on m.kd_dokter=j.kd_dokter where m.kd_dokter_bpjs='" + TkdDokter.getText() + "'"));
        
        if (jnsKun.equals("-")) {
            cmbJenisKunjungan.setSelectedIndex(1);
        } else if (jnsKun.equals("internal")) {
            cmbJenisKunjungan.setSelectedIndex(2);
        } else if (jnsKun.equals("kontrol")) {
            cmbJenisKunjungan.setSelectedIndex(3);
        } else if (jnsKun.equals("rujukanRS")) {
            cmbJenisKunjungan.setSelectedIndex(4);
        }
        
        if (Sequel.cariInteger("select count(-1) from reg_periksa where no_rawat='" + norw + "' and stts_daftar='Baru'") > 0) {
            cmbPasienBaru.setSelectedIndex(1);
        } else {
            cmbPasienBaru.setSelectedIndex(2);
        }
    }
    
    private void kirimAntrol() {
        try {
            headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            headers.add("X-Cons-ID", koneksiDB.CONSIDAPIMOBILEJKN());
            utc = String.valueOf(api.GetUTCdatetimeAsString());
            headers.add("X-Timestamp", utc);
            headers.add("X-Signature", api.getHmac(utc));
            headers.add("user_key", koneksiDB.USERKEYAPIMOBILEJKN());
            URL = link + "/antrean/add";
            requestJson = "{"
                    + "\"kodebooking\":\"" + TnoBoking.getText() + "\","
                    + "\"jenispasien\":\"" + cmbJenisPasien.getSelectedItem().toString() + "\","
                    + "\"nomorkartu\":\"" + TnoKartu.getText() + "\","
                    + "\"nik\":\"" + Tnik.getText() + "\","
                    + "\"nohp\":\"" + TnoHp.getText() + "\","
                    + "\"kodepoli\":\"" + TkdPoli.getText() + "\","
                    + "\"namapoli\":\"" + TnmPoli.getText() + "\","
                    + "\"pasienbaru\":\"" + cmbPasienBaru.getSelectedItem().toString().substring(0, 1) + "\","
                    + "\"norm\":\"" + TNoRM.getText() + "\","
                    + "\"tanggalperiksa\":\"" + Valid.SetTgl(TtglPeriksa.getSelectedItem() + "") + "\","
                    + "\"kodedokter\":\"" + TkdDokter.getText() + "\","
                    + "\"namadokter\":\"" + TnmDokter.getText() + "\","
                    + "\"jampraktek\":\"" + TjamPraktek.getText() + "\","
                    + "\"jeniskunjungan\":\"" + cmbJenisKunjungan.getSelectedItem().toString().substring(0, 1) + "\","
                    + "\"nomorreferensi\":\"" + TnoReferensi.getText() + "\","
                    + "\"nomorantrean\":\"" + TnoAntrian.getText() + "\","
                    + "\"angkaantrean\":\"" + TangkaAntrian.getText() + "\","
                    + "\"estimasidilayani\":\"" + Testimasi.getText() + "\","
                    + "\"sisakuotajkn\":\"" + TsisaKuota.getText() + "\","
                    + "\"kuotajkn\":\"" + TkuotaJkn.getText() + "\","
                    + "\"sisakuotanonjkn\":\"" + TsisaNon.getText() + "\","
                    + "\"kuotanonjkn\":\"" + TkuotaNon.getText() + "\","
                    + "\"keterangan\":\"" + Tketerangan.getText() + "\""
                    + "}";
            
            System.out.println("JSON : " + requestJson);
            requestEntity = new HttpEntity(requestJson, headers);
            root = mapper.readTree(api.getRest().exchange(URL, HttpMethod.POST, requestEntity, String.class).getBody());
            nameNode = root.path("metadata");
            System.out.println("code : " + nameNode.path("code").asText());
            System.out.println("Pesan JSON : " + nameNode.path("message").asText());
//            JOptionPane.showMessageDialog(null, "Notifikasi Bridging Antrol : " + nameNode.path("message").asText());
            Tnotif.setText("Bridging Antrol : " + nameNode.path("message").asText());
            if (nameNode.path("code").asText().equals("200") || nameNode.path("code").asText().equals("208")) {
                if (Sequel.queryu2tf("update antrol_bpjs set kd_booking=?,request_json=?,respon_taskid_0=?,keterangan_taskid_0=? where no_rawat=?", 5,
                        new String[]{
                            TnoBoking.getText(), requestJson, nameNode.path("code").asText(), nameNode.path("message").asText(),
                            TNoRw.getText()
                        }) == true) {
                    emptTeks();
                    akses.setNomorAntrian("");
                    Tnotif.setText("Bridging Antrol : " + nameNode.path("message").asText());
                }
            } else {
                if (Sequel.queryu2tf("update antrol_bpjs set kd_booking=?,request_json=?,respon_taskid_0=?,keterangan_taskid_0=? where no_rawat=?", 5,
                        new String[]{
                            TnoBoking.getText(), requestJson, nameNode.path("code").asText(), nameNode.path("message").asText(),
                            TNoRw.getText()
                        }) == true) {
                    akses.setNomorAntrian("");
                    Tnotif.setText("Bridging Antrol : " + nameNode.path("message").asText());
                }
            }
            
        } catch (Exception ex) {
            System.out.println("Notifikasi Antrian Online : " + ex);
            if (ex.toString().contains("UnknownHostException")) {
//                JOptionPane.showMessageDialog(null, "Koneksi ke server BPJS terputus...!");
                Tnotif.setText("Koneksi ke server BPJS terputus...!");
            }
        }
    }
}
