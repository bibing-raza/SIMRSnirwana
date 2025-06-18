/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DlgJnsPerawatanRalan.java
 *
 * Created on May 22, 2010, 11:58:21 PM
 */

package bridging;
import fungsi.WarnaTable;
import fungsi.batasInput;
import fungsi.koneksiDB;
import fungsi.sekuel;
import fungsi.validasi;
import fungsi.akses;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author dosen
 */
public final class MobileJKNReferensiPendaftaran extends javax.swing.JDialog {
    private final DefaultTableModel tabMode;
    private sekuel Sequel = new sekuel();
    private validasi Valid = new validasi();
    private Connection koneksi = koneksiDB.condb();
    private PreparedStatement ps;
    private ResultSet rs;
    private int i = 0;
    private String status = "", no_rawat = "", umur = "", sttsumur = "", kodePoli = "", URUTNOREG = "", kodeDokter = "";

    /** Creates new form DlgJnsPerawatanRalan
     * @param parent
     * @param modal */
    public MobileJKNReferensiPendaftaran(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.setLocation(8,1);
        setSize(628,674);

        tabMode = new DefaultTableModel(null, new Object[]{
            "No.Rawat", "No.RM", "Nama Pasien", "No.HP", "No.Kartu", "NIK", "Tanggal", "Poliklinik", "Dokter", "Jam Praktek", "Jenis Kunjungan",
            "Nomor Referensi", "Status", "Validasi Checkin", "No.Booking", "kodepoli", "thnLahir", "blnLahir", "hrLahir", "kodedokter", "nmKeluarga",
            "alamatPJ", "nmKelurahan", "nmKecamatan", "nmKabupaten", "nmPropinsi", "klgPasien", "No. Reg."
            }){
             @Override public boolean isCellEditable(int rowIndex, int colIndex){return false;}
        };
        tbJnsPerawatan.setModel(tabMode);

        tbJnsPerawatan.setPreferredScrollableViewportSize(new Dimension(500,500));
        tbJnsPerawatan.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (i = 0; i < 28; i++) {
            TableColumn column = tbJnsPerawatan.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(110);
            } else if (i == 1) {
                column.setPreferredWidth(70);
            } else if (i == 2) {
                column.setPreferredWidth(160);
            } else if (i == 3) {
                column.setPreferredWidth(83);
            } else if (i == 4) {
                column.setPreferredWidth(90);
            } else if (i == 5) {
                column.setPreferredWidth(103);
            } else if (i == 6) {
                column.setPreferredWidth(65);
            } else if (i == 7) {
                column.setPreferredWidth(140);
            } else if (i == 8) {
                column.setPreferredWidth(160);
            } else if (i == 9) {
                column.setPreferredWidth(70);
            } else if (i == 10) {
                column.setPreferredWidth(110);
            } else if (i == 11) {
                column.setPreferredWidth(125);
            } else if (i == 12) {
                column.setPreferredWidth(50);
            } else if (i == 13) {
                column.setPreferredWidth(115);
            } else if (i == 14) {
                column.setPreferredWidth(110);
            } else if (i == 15) {
                column.setMinWidth(0);
                column.setMaxWidth(0);
            } else if (i == 16) {
                column.setMinWidth(0);
                column.setMaxWidth(0);
            } else if (i == 17) {
                column.setMinWidth(0);
                column.setMaxWidth(0);
            } else if (i == 18) {
                column.setMinWidth(0);
                column.setMaxWidth(0);
            } else if (i == 19) {
                column.setMinWidth(0);
                column.setMaxWidth(0);
            } else if (i == 20) {
                column.setMinWidth(0);
                column.setMaxWidth(0);
            } else if (i == 21) {
                column.setMinWidth(0);
                column.setMaxWidth(0);
            } else if (i == 22) {
                column.setMinWidth(0);
                column.setMaxWidth(0);
            } else if (i == 23) {
                column.setMinWidth(0);
                column.setMaxWidth(0);
            } else if (i == 24) {
                column.setMinWidth(0);
                column.setMaxWidth(0);
            } else if (i == 25) {
                column.setMinWidth(0);
                column.setMaxWidth(0);
            } else if (i == 26) {
                column.setMinWidth(0);
                column.setMaxWidth(0);
            } else if (i == 27) {
                column.setPreferredWidth(60);
            }
        }
        tbJnsPerawatan.setDefaultRenderer(Object.class, new WarnaTable());

        TCari.setDocument(new batasInput((byte)100).getKata(TCari));
        
        if(koneksiDB.CARICEPAT().equals("aktif")){
            TCari.getDocument().addDocumentListener(new javax.swing.event.DocumentListener(){
                @Override
                public void insertUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        tampil();
                    }
                }
                @Override
                public void removeUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        tampil();
                    }
                }
                @Override
                public void changedUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        tampil();
                    }
                }
            });
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

        NoReg = new widget.TextBox();
        internalFrame1 = new widget.InternalFrame();
        Scroll = new widget.ScrollPane();
        tbJnsPerawatan = new widget.Table();
        jPanel3 = new javax.swing.JPanel();
        panelGlass8 = new widget.panelisi();
        jLabel7 = new widget.Label();
        LCount = new widget.Label();
        BtnEdit = new widget.Button();
        BtnBelum = new widget.Button();
        BtnBatal = new widget.Button();
        BtnPrint = new widget.Button();
        BtnKeluar = new widget.Button();
        panelGlass10 = new widget.panelisi();
        jLabel19 = new widget.Label();
        DTPCari1 = new widget.Tanggal();
        jLabel21 = new widget.Label();
        DTPCari2 = new widget.Tanggal();
        jLabel6 = new widget.Label();
        TCari = new widget.TextBox();
        BtnCari = new widget.Button();
        BtnAll = new widget.Button();

        NoReg.setHighlighter(null);
        NoReg.setName("NoReg"); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Referensi Pendaftaran Mobile JKN ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50, 50, 50))); // NOI18N
        internalFrame1.setName("internalFrame1"); // NOI18N
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

        Scroll.setName("Scroll"); // NOI18N
        Scroll.setOpaque(true);

        tbJnsPerawatan.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        tbJnsPerawatan.setName("tbJnsPerawatan"); // NOI18N
        Scroll.setViewportView(tbJnsPerawatan);

        internalFrame1.add(Scroll, java.awt.BorderLayout.CENTER);

        jPanel3.setName("jPanel3"); // NOI18N
        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(44, 100));
        jPanel3.setLayout(new java.awt.BorderLayout(1, 1));

        panelGlass8.setName("panelGlass8"); // NOI18N
        panelGlass8.setPreferredSize(new java.awt.Dimension(44, 44));
        panelGlass8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        jLabel7.setText("Record :");
        jLabel7.setName("jLabel7"); // NOI18N
        jLabel7.setPreferredSize(new java.awt.Dimension(52, 23));
        panelGlass8.add(jLabel7);

        LCount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LCount.setText("0");
        LCount.setName("LCount"); // NOI18N
        LCount.setPreferredSize(new java.awt.Dimension(50, 23));
        panelGlass8.add(LCount);

        BtnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/add-file-16x16.png"))); // NOI18N
        BtnEdit.setMnemonic('G');
        BtnEdit.setText("Regist");
        BtnEdit.setToolTipText("Alt+G");
        BtnEdit.setName("BtnEdit"); // NOI18N
        BtnEdit.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditActionPerformed(evt);
            }
        });
        panelGlass8.add(BtnEdit);

        BtnBelum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Cancel-2-16x16.png"))); // NOI18N
        BtnBelum.setMnemonic('B');
        BtnBelum.setText("Belum");
        BtnBelum.setToolTipText("Alt+B");
        BtnBelum.setName("BtnBelum"); // NOI18N
        BtnBelum.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnBelum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBelumActionPerformed(evt);
            }
        });
        BtnBelum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnBelumKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnBelum);

        BtnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/stop_f2.png"))); // NOI18N
        BtnBatal.setMnemonic('H');
        BtnBatal.setText("Batal");
        BtnBatal.setToolTipText("Alt+H");
        BtnBatal.setName("BtnBatal"); // NOI18N
        BtnBatal.setPreferredSize(new java.awt.Dimension(100, 30));
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
        panelGlass8.add(BtnBatal);

        BtnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/b_print.png"))); // NOI18N
        BtnPrint.setMnemonic('T');
        BtnPrint.setText("Cetak");
        BtnPrint.setToolTipText("Alt+T");
        BtnPrint.setName("BtnPrint"); // NOI18N
        BtnPrint.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrintActionPerformed(evt);
            }
        });
        BtnPrint.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnPrintKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnPrint);

        BtnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/exit.png"))); // NOI18N
        BtnKeluar.setMnemonic('K');
        BtnKeluar.setText("Keluar");
        BtnKeluar.setToolTipText("Alt+K");
        BtnKeluar.setName("BtnKeluar"); // NOI18N
        BtnKeluar.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKeluarActionPerformed(evt);
            }
        });
        BtnKeluar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnKeluarKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnKeluar);

        jPanel3.add(panelGlass8, java.awt.BorderLayout.CENTER);

        panelGlass10.setName("panelGlass10"); // NOI18N
        panelGlass10.setPreferredSize(new java.awt.Dimension(44, 44));
        panelGlass10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        jLabel19.setText("Tanggal :");
        jLabel19.setName("jLabel19"); // NOI18N
        jLabel19.setPreferredSize(new java.awt.Dimension(55, 23));
        panelGlass10.add(jLabel19);

        DTPCari1.setForeground(new java.awt.Color(50, 70, 50));
        DTPCari1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "12-02-2025" }));
        DTPCari1.setDisplayFormat("dd-MM-yyyy");
        DTPCari1.setName("DTPCari1"); // NOI18N
        DTPCari1.setOpaque(false);
        DTPCari1.setPreferredSize(new java.awt.Dimension(90, 23));
        panelGlass10.add(DTPCari1);

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("s.d.");
        jLabel21.setName("jLabel21"); // NOI18N
        jLabel21.setPreferredSize(new java.awt.Dimension(23, 23));
        panelGlass10.add(jLabel21);

        DTPCari2.setForeground(new java.awt.Color(50, 70, 50));
        DTPCari2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "12-02-2025" }));
        DTPCari2.setDisplayFormat("dd-MM-yyyy");
        DTPCari2.setName("DTPCari2"); // NOI18N
        DTPCari2.setOpaque(false);
        DTPCari2.setPreferredSize(new java.awt.Dimension(90, 23));
        panelGlass10.add(DTPCari2);

        jLabel6.setText("Key Word :");
        jLabel6.setName("jLabel6"); // NOI18N
        jLabel6.setPreferredSize(new java.awt.Dimension(75, 23));
        panelGlass10.add(jLabel6);

        TCari.setName("TCari"); // NOI18N
        TCari.setPreferredSize(new java.awt.Dimension(205, 23));
        TCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TCariKeyPressed(evt);
            }
        });
        panelGlass10.add(TCari);

        BtnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/accept.png"))); // NOI18N
        BtnCari.setMnemonic('2');
        BtnCari.setToolTipText("Alt+2");
        BtnCari.setName("BtnCari"); // NOI18N
        BtnCari.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCariActionPerformed(evt);
            }
        });
        BtnCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnCariKeyPressed(evt);
            }
        });
        panelGlass10.add(BtnCari);

        BtnAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Search-16x16.png"))); // NOI18N
        BtnAll.setMnemonic('M');
        BtnAll.setToolTipText("Alt+M");
        BtnAll.setName("BtnAll"); // NOI18N
        BtnAll.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAllActionPerformed(evt);
            }
        });
        BtnAll.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnAllKeyPressed(evt);
            }
        });
        panelGlass10.add(BtnAll);

        jPanel3.add(panelGlass10, java.awt.BorderLayout.PAGE_START);

        internalFrame1.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        dispose();
}//GEN-LAST:event_BtnKeluarActionPerformed

    private void BtnKeluarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnKeluarKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            dispose();
        }else{Valid.pindah(evt,BtnCari,TCari);}
}//GEN-LAST:event_BtnKeluarKeyPressed

    private void BtnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrintActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if(tabMode.getRowCount()==0){
            JOptionPane.showMessageDialog(null,"Maaf, data sudah habis. Tidak ada data yang bisa anda print...!!!!");
            //TCari.requestFocus();
        }else if(tabMode.getRowCount()!=0){
            Sequel.queryu("delete from temporary where temp37='"+akses.getalamatip()+"'");
            int row=tabMode.getRowCount();
            for(int r=0;r<row;r++){  
                Sequel.menyimpan("temporary","'"+r+"','"+
                                tabMode.getValueAt(r,0).toString().replaceAll("'","") +"','"+
                                tabMode.getValueAt(r,1).toString().replaceAll("'","")+"','"+
                                tabMode.getValueAt(r,2).toString().replaceAll("'","")+"','"+
                                tabMode.getValueAt(r,3).toString().replaceAll("'","")+"','"+
                                tabMode.getValueAt(r,4).toString().replaceAll("'","")+"','"+
                                tabMode.getValueAt(r,5).toString().replaceAll("'","")+"','"+
                                tabMode.getValueAt(r,6).toString().replaceAll("'","")+"','"+
                                tabMode.getValueAt(r,7).toString().replaceAll("'","")+"','"+
                                tabMode.getValueAt(r,8).toString().replaceAll("'","")+"','"+
                                tabMode.getValueAt(r,9).toString().replaceAll("'","")+"','"+
                                tabMode.getValueAt(r,10).toString().replaceAll("'","")+"','"+
                                tabMode.getValueAt(r,11).toString().replaceAll("'","")+"','"+
                                tabMode.getValueAt(r,12).toString().replaceAll("'","")+"','"+
                                tabMode.getValueAt(r,13).toString().replaceAll("'","")+"','"+
                                tabMode.getValueAt(r,14).toString().replaceAll("'","")+"','','','','','','','','','','','','','','','','','','','','','','"+akses.getalamatip()+"'","Rekap Harian BulananDokter"); 
            }
            
            Map<String, Object> param = new HashMap<>();
            param.put("namars",akses.getnamars());
            param.put("alamatrs",akses.getalamatrs());
            param.put("kotars",akses.getkabupatenrs());
            param.put("propinsirs",akses.getpropinsirs());
            param.put("kontakrs",akses.getkontakrs());
            param.put("emailrs",akses.getemailrs());   
            param.put("logo",Sequel.cariGambar("select setting.logo from setting")); 
            Valid.MyReportqry("rptReferensiPendaftaranMobileJKN.jasper","report","::[ Data Referensi Pendaftaran Mobile JKN ]::","select * from temporary where temporary.temp37='"+akses.getalamatip()+"' order by temporary.no",param);
        }
        this.setCursor(Cursor.getDefaultCursor());
}//GEN-LAST:event_BtnPrintActionPerformed

    private void BtnPrintKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnPrintKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnPrintActionPerformed(null);
        }else{
            Valid.pindah(evt, BtnCari, BtnKeluar);
        }
}//GEN-LAST:event_BtnPrintKeyPressed

    private void TCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TCariKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            BtnCariActionPerformed(null);
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_DOWN){
            BtnCari.requestFocus();
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_UP){
            BtnKeluar.requestFocus();
        }
}//GEN-LAST:event_TCariKeyPressed

    private void BtnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariActionPerformed
        tampil();
}//GEN-LAST:event_BtnCariActionPerformed

    private void BtnCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCariKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnCariActionPerformed(null);
        }else{
            Valid.pindah(evt, TCari, BtnAll);
        }
}//GEN-LAST:event_BtnCariKeyPressed

    private void BtnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAllActionPerformed
        TCari.setText("");
        tampil();
}//GEN-LAST:event_BtnAllActionPerformed

    private void BtnAllKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnAllKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            tampil();
            TCari.setText("");
        }else{
            Valid.pindah(evt, BtnPrint, BtnKeluar);
        }
}//GEN-LAST:event_BtnAllKeyPressed

    private void BtnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatalActionPerformed
        if(tbJnsPerawatan.getSelectedRow()!= -1){
            if(Sequel.mengedittf("referensi_mobilejkn_bpjs","nobooking=?","status='Batal',validasi=now()",1,new String[]{
                tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(),14).toString()
            })==true){
                Sequel.menyimpan2("referensi_mobilejkn_bpjs_batal","?,?,?,now(),?,?,?",6,new String[]{
                    tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(),1).toString(),tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(),0).toString(), 
                    tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(),11).toString(),"Dibatalkan Oleh Admin","Belum",tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(),14).toString()
                });
                tampil();
            }
        }else{
            JOptionPane.showMessageDialog(null,"Silahkan pilih dulu data yang mau dibatalkan..!!");
        }
    }//GEN-LAST:event_BtnBatalActionPerformed

    private void BtnBatalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnBatalKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnBatalActionPerformed(null);
        }
    }//GEN-LAST:event_BtnBatalKeyPressed

    private void BtnBelumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBelumActionPerformed
        if(Sequel.mengedittf("referensi_mobilejkn_bpjs","nobooking=?","status='Belum',validasi='0000-00-00 00:00:00'",1,new String[]{
            tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(),14).toString()
        })==true){
            Sequel.meghapus("referensi_mobilejkn_bpjs_batal","nobooking",tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(),14).toString());
            tampil();
        }
    }//GEN-LAST:event_BtnBelumActionPerformed

    private void BtnBelumKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnBelumKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnBelumActionPerformed(null);
        }
    }//GEN-LAST:event_BtnBelumKeyPressed

    private void BtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditActionPerformed
        if (tbJnsPerawatan.getSelectedRow() != -1) {
            if (!tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(), 0).toString().equals("-")) {
                JOptionPane.showMessageDialog(null, "Data pendaftaran mobile JKN pasien ini sudah tersimpan, diregistrasi..!!!");
            } else {
                if (Sequel.cariInteger("select count(-1) from referensi_mobilejkn_bpjs where "
                        + "nobooking='" + tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(), 14).toString() + "' and status='Belum'") > 0) {
                    if (Sequel.cariIsi("select tanggalperiksa from referensi_mobilejkn_bpjs where "
                            + "nobooking='" + tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(), 14).toString() + "'").equals(Sequel.cariIsi("select date(now())"))) {

                        kodePoli = Sequel.cariIsi("select kd_poli_rs from maping_poli_bpjs where kd_poli_bpjs='" + tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(), 15).toString() + "'");
                        kodeDokter = Sequel.cariIsi("select kd_dokter from maping_dokter_dpjpvclaim where kd_dokter_bpjs='" + tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(), 19).toString() + "'");
                        Sequel.mengedit("pasien", "no_rkm_medis=?", "umur=CONCAT(CONCAT(CONCAT(TIMESTAMPDIFF(YEAR, tgl_lahir, CURDATE()), ' Th '),CONCAT(TIMESTAMPDIFF(MONTH, tgl_lahir, CURDATE()) - ((TIMESTAMPDIFF(MONTH, tgl_lahir, CURDATE()) div 12) * 12), ' Bl ')),CONCAT(TIMESTAMPDIFF(DAY, DATE_ADD(DATE_ADD(tgl_lahir,INTERVAL TIMESTAMPDIFF(YEAR, tgl_lahir, CURDATE()) YEAR), INTERVAL TIMESTAMPDIFF(MONTH, tgl_lahir, CURDATE()) - ((TIMESTAMPDIFF(MONTH, tgl_lahir, CURDATE()) div 12) * 12) MONTH), CURDATE()), ' Hr'))", 1, new String[]{tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(), 1).toString()});
                        status = Sequel.cariIsi("select if((select count(no_rkm_medis) from reg_periksa where no_rkm_medis='" + tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(), 1).toString() + "' and kd_poli='" + kodePoli + "')>0,'Lama','Baru')");
                        no_rawat = Valid.autoNomer3("select ifnull(MAX(CONVERT(RIGHT(no_rawat,6),signed)),0) from reg_periksa where "
                                + "tgl_registrasi='" + Sequel.cariIsi("select date(now())") + "' ", Sequel.cariIsi("select date_format(now(),'%Y/%m/%d')") + "/", 6);
                        umur = "0";
                        sttsumur = "Th";
                        if (Double.parseDouble(tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(), 16).toString()) > 0) {
                            umur = "" + Double.parseDouble(tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(), 16).toString());
                            sttsumur = "Th";
                        } else if (Double.parseDouble(tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(), 16).toString()) == 0) {
                            if (Double.parseDouble(tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(), 17).toString()) > 0) {
                                umur = "" + Double.parseDouble(tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(), 17).toString());
                                sttsumur = "Bl";
                            } else if (Double.parseDouble(tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(), 17).toString()) == 0) {
                                umur = "" + Double.parseDouble(tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(), 18).toString());
                                sttsumur = "Hr";
                            }
                        }

                        isNomer(kodePoli, kodeDokter);
                        if (Sequel.menyimpantf2("reg_periksa", "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?", "No.Rawat", 19, new String[]{
                            tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(), 27).toString(), no_rawat, Sequel.cariIsi("select date(now())"), jam(),
                            kodeDokter, tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(), 1).toString(), kodePoli,
                            tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(), 20).toString(),
                            tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(), 21).toString() + ", " + tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(), 22).toString()
                            + ", " + tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(), 23).toString() + ", " + tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(), 24).toString()
                            + ", " + tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(), 25).toString(), tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(), 26).toString(),
                            "" + Sequel.cariIsiAngka("select poliklinik.registrasilama from poliklinik where poliklinik.kd_poli=?", kodePoli),
                            "Belum", "Lama", "Ralan", "BPJ", umur, sttsumur, "Belum Bayar", status
                        }) == true) {

                            Sequel.menyimpanignore("antrol_bpjs", "'" + no_rawat + "','" + tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(), 14).toString() + "','" + Sequel.cariIsi("select date(now())") + "',"
                                    + "'00:00:00','00:00:00','" + jam() + "','','200','Checkin melalui SIMRS','','','','','','','','','','','','','','','','','','','','',"
                                    + "'','','','','','','','','','-'");

                            if (Sequel.mengedittf("referensi_mobilejkn_bpjs", "nobooking=?", "no_rawat='" + no_rawat + "', status='Checkin', validasi=now()", 1, new String[]{
                                tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(), 14).toString()
                            }) == true) {
                                Sequel.meghapus("referensi_mobilejkn_bpjs_batal", "nobooking", tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(), 14).toString());
                            }
                            JOptionPane.showMessageDialog(null, "Pendaftaran dari mobile JKN sudah berhasil diregistrasi ke data kunjungan pasien..!!!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Maaf, tanggal pasien booking tidak sama dengan tanggal pada hari ini..!!!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Silahkan periksa kembali status Checkin mobile JKN anda..!!!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null,"Silahkan pilih dulu salah satu datanya pada tabel..!!!");
            tbJnsPerawatan.requestFocus();
        }
        tampil();
    }//GEN-LAST:event_BtnEditActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            MobileJKNReferensiPendaftaran dialog = new MobileJKNReferensiPendaftaran(new javax.swing.JFrame(), true);
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
    private widget.Button BtnAll;
    private widget.Button BtnBatal;
    private widget.Button BtnBelum;
    private widget.Button BtnCari;
    private widget.Button BtnEdit;
    private widget.Button BtnKeluar;
    private widget.Button BtnPrint;
    private widget.Tanggal DTPCari1;
    private widget.Tanggal DTPCari2;
    private widget.Label LCount;
    private widget.TextBox NoReg;
    private widget.ScrollPane Scroll;
    private widget.TextBox TCari;
    private widget.InternalFrame internalFrame1;
    private widget.Label jLabel19;
    private widget.Label jLabel21;
    private widget.Label jLabel6;
    private widget.Label jLabel7;
    private javax.swing.JPanel jPanel3;
    private widget.panelisi panelGlass10;
    private widget.panelisi panelGlass8;
    private widget.Table tbJnsPerawatan;
    // End of variables declaration//GEN-END:variables

    private void tampil() {
        Valid.tabelKosong(tabMode);
        try{
            ps = koneksi.prepareStatement(
                    "SELECT referensi_mobilejkn_bpjs.no_rawat,referensi_mobilejkn_bpjs.norm,pasien.nm_pasien,referensi_mobilejkn_bpjs.nohp,referensi_mobilejkn_bpjs.nomorkartu,"
                    + "referensi_mobilejkn_bpjs.nik,referensi_mobilejkn_bpjs.tanggalperiksa,referensi_mobilejkn_bpjs.kodepoli,referensi_mobilejkn_bpjs.kodedokter,referensi_mobilejkn_bpjs.jampraktek,"
                    + "referensi_mobilejkn_bpjs.jeniskunjungan,referensi_mobilejkn_bpjs.nomorreferensi,referensi_mobilejkn_bpjs.status,referensi_mobilejkn_bpjs.validasi,"
                    + "referensi_mobilejkn_bpjs.nobooking, TIMESTAMPDIFF(YEAR, pasien.tgl_lahir, CURDATE()) as tahun, (TIMESTAMPDIFF(MONTH, pasien.tgl_lahir, CURDATE()) - ((TIMESTAMPDIFF(MONTH, pasien.tgl_lahir, CURDATE()) div 12) * 12)) as bulan, "
                    + "TIMESTAMPDIFF(DAY, DATE_ADD(DATE_ADD(pasien.tgl_lahir,INTERVAL TIMESTAMPDIFF(YEAR, pasien.tgl_lahir, CURDATE()) YEAR), INTERVAL TIMESTAMPDIFF(MONTH, pasien.tgl_lahir, CURDATE()) - ((TIMESTAMPDIFF(MONTH, pasien.tgl_lahir, CURDATE()) div 12) * 12) MONTH), CURDATE()) as hari, "
                    + "pasien.namakeluarga, concat(pasien.alamat,', ',kelurahan.nm_kel,', ',kecamatan.nm_kec,', ',kabupaten.nm_kab) as alamatpj, pasien.kelurahanpj, pasien.kecamatanpj, pasien.kabupatenpj, "
                    + "pasien.propinsipj, pasien.keluarga, referensi_mobilejkn_bpjs.angkaantrean FROM referensi_mobilejkn_bpjs INNER JOIN pasien ON referensi_mobilejkn_bpjs.norm=pasien.no_rkm_medis "
                    + "inner join kelurahan on pasien.kd_kel=kelurahan.kd_kel "
                    + "inner join kecamatan on pasien.kd_kec=kecamatan.kd_kec "
                    + "inner join kabupaten on pasien.kd_kab=kabupaten.kd_kab "
                    + "WHERE referensi_mobilejkn_bpjs.tanggalperiksa BETWEEN ? AND ? "
                    + (TCari.getText().equals("") ? "" : "and (referensi_mobilejkn_bpjs.no_rawat LIKE ? OR referensi_mobilejkn_bpjs.norm LIKE ? OR pasien.nm_pasien LIKE ? OR "
                    + "referensi_mobilejkn_bpjs.nohp LIKE ? OR referensi_mobilejkn_bpjs.nomorkartu LIKE ? OR referensi_mobilejkn_bpjs.nik LIKE ? OR "
                    + "referensi_mobilejkn_bpjs.jeniskunjungan LIKE ? OR referensi_mobilejkn_bpjs.nomorreferensi LIKE ? OR referensi_mobilejkn_bpjs.status LIKE ?) ")
                    + "order by referensi_mobilejkn_bpjs.tanggalperiksa");
            try {
                ps.setString(1,Valid.SetTgl(DTPCari1.getSelectedItem()+""));
                ps.setString(2,Valid.SetTgl(DTPCari2.getSelectedItem()+""));
                if(!TCari.getText().trim().equals("")){
                    ps.setString(3,"%"+TCari.getText()+"%");
                    ps.setString(4,"%"+TCari.getText()+"%");
                    ps.setString(5,"%"+TCari.getText()+"%");
                    ps.setString(6,"%"+TCari.getText()+"%");
                    ps.setString(7,"%"+TCari.getText()+"%");
                    ps.setString(8,"%"+TCari.getText()+"%");
                    ps.setString(9,"%"+TCari.getText()+"%");
                    ps.setString(10,"%"+TCari.getText()+"%");
                    ps.setString(11,"%"+TCari.getText()+"%");
                }
                    
                rs=ps.executeQuery();
                while(rs.next()){
                    tabMode.addRow(new Object[]{
                        rs.getString("no_rawat"),rs.getString("norm"),rs.getString("nm_pasien"),
                        rs.getString("nohp"),rs.getString("nomorkartu"),rs.getString("nik"),
                        rs.getString("tanggalperiksa"),Sequel.cariIsi("select maping_poli_bpjs.nm_poli_bpjs from maping_poli_bpjs where maping_poli_bpjs.kd_poli_bpjs=?",rs.getString("kodepoli")),
                        Sequel.cariIsi("select maping_dokter_dpjpvclaim.nm_dokter_bpjs from maping_dokter_dpjpvclaim where maping_dokter_dpjpvclaim.kd_dokter_bpjs=?",rs.getString("kodedokter")),
                        rs.getString("jampraktek"),rs.getString("jeniskunjungan"),rs.getString("nomorreferensi"),
                        rs.getString("status"),rs.getString("validasi"),rs.getString("nobooking"),
                        rs.getString ("kodepoli"), rs.getString ("tahun"), rs.getString ("bulan"), 
                        rs.getString ("hari"), rs.getString ("kodedokter"), rs.getString ("namakeluarga"),
                        rs.getString ("alamatpj"), rs.getString ("kelurahanpj"), rs.getString ("kecamatanpj"), 
                        rs.getString ("kabupatenpj"), rs.getString ("propinsipj"), rs.getString ("keluarga"),
                        rs.getString ("angkaantrean")
                    });
                }
            } catch (Exception e) {
                System.out.println("Notif : "+e);
            } finally{
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
            }
        }catch(Exception e){
            System.out.println("Notifikasi : "+e);
        }
        LCount.setText(""+tabMode.getRowCount());
    }
    
    private String jam(){
        int nilai_jam;
        int nilai_menit;
        int nilai_detik;
        String nol_jam = "";
        String nol_menit = "";
        String nol_detik = "";
        Date now = Calendar.getInstance().getTime();
        nilai_jam = now.getHours();
        nilai_menit = now.getMinutes();
        nilai_detik = now.getSeconds();

        // Jika nilai JAM lebih kecil dari 10 (hanya 1 digit)
        if (nilai_jam <= 9) {
            // Tambahkan "0" didepannya
            nol_jam = "0";
        }
        // Jika nilai MENIT lebih kecil dari 10 (hanya 1 digit)
        if (nilai_menit <= 9) {
            // Tambahkan "0" didepannya
            nol_menit = "0";
        }
        // Jika nilai DETIK lebih kecil dari 10 (hanya 1 digit)
        if (nilai_detik <= 9) {
            // Tambahkan "0" didepannya
            nol_detik = "0";
        }
        String jam = nol_jam + Integer.toString(nilai_jam);
        String menit = nol_menit + Integer.toString(nilai_menit);
        String detik = nol_detik + Integer.toString(nilai_detik);
        return jam+":"+menit+":"+detik;
    }
    
    private void isNomer(String kdpoli, String kdDokter){
        switch (URUTNOREG) {
            case "poli":
                Valid.autoNomer3("select ifnull(MAX(CONVERT(no_reg,signed)),0) from reg_periksa where kd_poli='"+kdpoli+"' and tgl_registrasi='"+Sequel.cariIsi("select date(now())")+"'","",3,NoReg);
                break;
            case "dokter":
                Valid.autoNomer3("select ifnull(MAX(CONVERT(no_reg,signed)),0) from reg_periksa where kd_dokter='"+kdDokter+"' and tgl_registrasi='"+Sequel.cariIsi("select date(now())")+"'","",3,NoReg);
                break;
            case "dokter + poli":             
                Valid.autoNomer3("select ifnull(MAX(CONVERT(no_reg,signed)),0) from reg_periksa where kd_dokter='"+kdDokter+"' and kd_poli='"+kdpoli+"' and tgl_registrasi='"+Sequel.cariIsi("select date(now())")+"'","",3,NoReg);
                break;
            default:
                Valid.autoNomer3("select ifnull(MAX(CONVERT(no_reg,signed)),0) from reg_periksa where kd_dokter='"+kdDokter+"' and tgl_registrasi='"+Sequel.cariIsi("select date(now())")+"'","",3,NoReg);
                break;
        }
    }
}
