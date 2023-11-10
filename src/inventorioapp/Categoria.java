/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inventorioapp;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author andre
 */
public class Categoria extends javax.swing.JFrame {

    /**
     * Creates new form Categoria
     */
    public Categoria() {
        initComponents();
        SelectCat();
        id_autoincrement();
    }
    
//Estabelece as conexões  
    Connection Con = null;
    Statement St = null;     
    ResultSet Rs = null;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        CatId = new javax.swing.JTextField();
        CatNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        IncluirBtn = new javax.swing.JButton();
        ExcluirBtn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        EditarBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        CategoriaTbl = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));
        jPanel2.setForeground(new java.awt.Color(255, 102, 102));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mini_ksol.png"))); // NOI18N

        jLabel10.setBackground(new java.awt.Color(51, 51, 51));
        jLabel10.setFont(new java.awt.Font("Arial Black", 1, 30)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("GERENCIAR CATEGORIAS");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("X");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(224, 224, 224)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel5.setBackground(new java.awt.Color(255, 102, 102));
        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("LISTA DE CATEGORIAS");

        CatId.setEditable(false);
        CatId.setBackground(new java.awt.Color(255, 255, 255));
        CatId.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        CatId.setForeground(new java.awt.Color(255, 102, 102));
        CatId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CatIdActionPerformed(evt);
            }
        });

        CatNome.setBackground(new java.awt.Color(255, 255, 255));
        CatNome.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        CatNome.setForeground(new java.awt.Color(255, 102, 102));
        CatNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CatNomeActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 102, 102));
        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nome");

        IncluirBtn.setBackground(new java.awt.Color(255, 255, 255));
        IncluirBtn.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        IncluirBtn.setForeground(new java.awt.Color(255, 102, 102));
        IncluirBtn.setText("INCLUIR");
        IncluirBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IncluirBtnMouseClicked(evt);
            }
        });

        ExcluirBtn.setBackground(new java.awt.Color(255, 255, 255));
        ExcluirBtn.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        ExcluirBtn.setForeground(new java.awt.Color(255, 102, 102));
        ExcluirBtn.setText("EXCLUIR");
        ExcluirBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExcluirBtnMouseClicked(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 102, 102));
        jButton3.setText("INÍCIO");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        EditarBtn.setBackground(new java.awt.Color(255, 255, 255));
        EditarBtn.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        EditarBtn.setForeground(new java.awt.Color(255, 102, 102));
        EditarBtn.setText("EDITAR");
        EditarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditarBtnMouseClicked(evt);
            }
        });

        CategoriaTbl.setBackground(new java.awt.Color(255, 255, 255));
        CategoriaTbl.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        CategoriaTbl.setForeground(new java.awt.Color(255, 102, 102));
        CategoriaTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CatID", "CatName"
            }
        ));
        CategoriaTbl.setRowHeight(30);
        CategoriaTbl.setSelectionBackground(new java.awt.Color(255, 255, 255));
        CategoriaTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CategoriaTblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(CategoriaTbl);

        jLabel11.setBackground(new java.awt.Color(255, 102, 102));
        jLabel11.setFont(new java.awt.Font("Arial Black", 0, 30)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(IncluirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(EditarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(ExcluirBtn))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CatId, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(44, 44, 44)
                            .addComponent(CatNome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(92, 92, 92))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CatId, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(CatNome, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(141, 141, 141)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ExcluirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IncluirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EditarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

//Altere "CONEXAO" para a entrada do seu banco de dados
//Altere "USER" para o seu usuário do banco de dados
//Altere "SENHA" para sua senha no banco de dados    
//Altere "DB" para o nome do seu banco de dados
//Note que deve-se fazer isto em todo o código
    
//Seleciona as Categorias no Banco de Dados    
    public void SelectCat()
{
    try{
    Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Inventariodb","Andre","1234");
    St = Con.createStatement();
    Rs = St.executeQuery("select * from CATEGORIATBL");
    CategoriaTbl.setModel(DbUtils.resultSetToTableModel(Rs));
    }catch(SQLException e)
    {
        e.printStackTrace();
    }    
}   

//Auto preenchimento e incremento     
 private void id_autoincrement(){
        try{
            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Inventariodb","Andre","1234");
            String sqlquery = "select max(CATID) from CATEGORIATBL";
            PreparedStatement pst = Con.prepareStatement(sqlquery);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                int id = rs.getInt(1);
                int n = id+1;
                CatId.setText(Integer.toString(n));
            }else{
                
            }
        }catch (Exception ex){
            
        }
    }
 
    private void CatIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CatIdActionPerformed
    CatId.setText("");
    id_autoincrement();
    }//GEN-LAST:event_CatIdActionPerformed

    private void CatNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CatNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CatNomeActionPerformed

//Botão que inclui as entradas no banco de dados    
    private void IncluirBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IncluirBtnMouseClicked
        try{
            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Inventariodb","Andre","1234");
            PreparedStatement add = Con.prepareStatement("insert into CATEGORIATBL values(?,?)");
            add.setInt(1, Integer.valueOf(CatId.getText()));
            add.setString(2, CatNome.getText());
            int row = add.executeUpdate();
            JOptionPane.showMessageDialog(this, "Categoria Adicionada com sucesso");
            Con.close();
            SelectCat();
        }catch(SQLException e)
        {
            e.printStackTrace();
        } 
    }//GEN-LAST:event_IncluirBtnMouseClicked

//Seleciona um item na tabela que preenche as entradas vazias ou não        
    private void CategoriaTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CategoriaTblMouseClicked
    DefaultTableModel model = (DefaultTableModel) CategoriaTbl.getModel();
        int Meuindice = CategoriaTbl.getSelectedRow();
        CatId.setText(model.getValueAt(Meuindice, 0).toString());
        CatNome.setText(model.getValueAt(Meuindice, 1).toString());
    }//GEN-LAST:event_CategoriaTblMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
    System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

//Botão que exclui no banco de dados       
    private void ExcluirBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExcluirBtnMouseClicked
    if(CatId.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Insira o Produto que será exluído");
        }
        else
        {
            try{
            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Inventariodb","Andre","1234");
            String Id = CatId.getText();
            String Query = "Delete from Andre.CATEGORIATBL where CATID="+Id;
            Statement Add = Con.createStatement();
            Add.executeUpdate(Query);
            SelectCat();
            JOptionPane.showMessageDialog(this, "Categoria Excluída com sucesso");
            }catch(SQLException e)
            {
                e.printStackTrace();
            }
        }    
    }//GEN-LAST:event_ExcluirBtnMouseClicked

//Botão que edita no banco de dados     
    private void EditarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditarBtnMouseClicked
        if(CatId.getText().isEmpty()||CatNome.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Faltam Informações");
        }
        else
        {
            try {
            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Inventariodb","Andre","1234");    
            String Editar = "update Andre.CATEGORIATBL set CATNOME='"+CatNome.getText()+"'"+"where CATID ="+CatId.getText();
            Statement Add = Con.createStatement();
            Add.executeUpdate(Editar);
            JOptionPane.showMessageDialog(this,"Categoria Editada com sucesso");
            SelectCat();
            } catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_EditarBtnMouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
    new Home().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_jButton3MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Categoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Categoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Categoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Categoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Categoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CatId;
    private javax.swing.JTextField CatNome;
    private javax.swing.JTable CategoriaTbl;
    private javax.swing.JButton EditarBtn;
    private javax.swing.JButton ExcluirBtn;
    private javax.swing.JButton IncluirBtn;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
