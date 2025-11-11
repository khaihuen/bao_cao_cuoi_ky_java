package Interface;


public class frmMain extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(frmMain.class.getName());

    private String role;
    
    public frmMain(String role) {
        initComponents();
        setLocationRelativeTo(null);
        this.role = role; 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSV = new javax.swing.JButton();
        btnLop = new javax.swing.JButton();
        btnMonHoc = new javax.swing.JButton();
        btnBangDiem = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý trang chủ");

        btnSV.setText("Quản lý sinh viên");
        btnSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSVActionPerformed(evt);
            }
        });

        btnLop.setText("Quản lý lớp");
        btnLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLopActionPerformed(evt);
            }
        });

        btnMonHoc.setText("Quản lý môn học");
        btnMonHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMonHocActionPerformed(evt);
            }
        });

        btnBangDiem.setText("Quản lý bảng điểm");
        btnBangDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBangDiemActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("HỆ THỐNG QUẢN LÝ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBangDiem)
                            .addComponent(btnMonHoc)
                            .addComponent(btnLop)
                            .addComponent(btnSV)))
                    .addComponent(jLabel1))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBangDiem, btnLop, btnMonHoc, btnSV});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(btnSV)
                .addGap(18, 18, 18)
                .addComponent(btnLop)
                .addGap(18, 18, 18)
                .addComponent(btnMonHoc)
                .addGap(18, 18, 18)
                .addComponent(btnBangDiem)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSVActionPerformed
        new frmSinhvien(role).setVisible(true);
    }//GEN-LAST:event_btnSVActionPerformed

    private void btnLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLopActionPerformed
        new frmLop(role).setVisible(true);
    }//GEN-LAST:event_btnLopActionPerformed

    private void btnMonHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonHocActionPerformed
        new frmMonhoc(role).setVisible(true);
    }//GEN-LAST:event_btnMonHocActionPerformed

    private void btnBangDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBangDiemActionPerformed
        new frmBangDiem(role).setVisible(true);
    }//GEN-LAST:event_btnBangDiemActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBangDiem;
    private javax.swing.JButton btnLop;
    private javax.swing.JButton btnMonHoc;
    private javax.swing.JButton btnSV;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
