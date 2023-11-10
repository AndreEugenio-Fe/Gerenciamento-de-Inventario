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
public class Produto extends javax.swing.JFrame {

    
    public Produto() {
        initComponents();
        SelectProd();
        GetCat();
        id_autoincrement();
    }

//Estabelece as conexões      
   Connection Con = null;
   Statement St = null;     
   ResultSet Rs = null;
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ProdId = new javax.swing.JTextField();
        ProdNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ProdQtd = new javax.swing.JTextField();
        ProdDesc = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        CatCb = new javax.swing.JComboBox<>();
        IncluirBTN = new javax.swing.JButton();
        ExcluirBtn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        EditarBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProdutosTable = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(1080, 645));

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));
        jPanel2.setForeground(new java.awt.Color(255, 102, 102));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mini_ksol.png"))); // NOI18N

        jLabel10.setBackground(new java.awt.Color(51, 51, 51));
        jLabel10.setFont(new java.awt.Font("Arial Black", 1, 30)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("GERENCIAR PRODUTOS");

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
        jLabel5.setText("LISTA DE PRODUTOS");

        ProdId.setBackground(new java.awt.Color(255, 255, 255));
        ProdId.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        ProdId.setForeground(new java.awt.Color(255, 102, 102));
        ProdId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdIdActionPerformed(evt);
            }
        });

        ProdNome.setBackground(new java.awt.Color(255, 255, 255));
        ProdNome.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        ProdNome.setForeground(new java.awt.Color(255, 102, 102));
        ProdNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdNomeActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 102, 102));
        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nome");

        jLabel6.setBackground(new java.awt.Color(255, 102, 102));
        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Quantidade");

        ProdQtd.setBackground(new java.awt.Color(255, 255, 255));
        ProdQtd.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        ProdQtd.setForeground(new java.awt.Color(255, 102, 102));
        ProdQtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdQtdActionPerformed(evt);
            }
        });

        ProdDesc.setBackground(new java.awt.Color(255, 255, 255));
        ProdDesc.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        ProdDesc.setForeground(new java.awt.Color(255, 102, 102));
        ProdDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdDescActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 102, 102));
        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Descrição");

        jLabel8.setBackground(new java.awt.Color(255, 102, 102));
        jLabel8.setFont(new java.awt.Font("Arial Black", 0, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Categoria");

        CatCb.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        CatCb.setForeground(new java.awt.Color(255, 102, 102));

        IncluirBTN.setBackground(new java.awt.Color(255, 255, 255));
        IncluirBTN.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        IncluirBTN.setForeground(new java.awt.Color(255, 102, 102));
        IncluirBTN.setText("INCLUIR");
        IncluirBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IncluirBTNMouseClicked(evt);
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

        ProdutosTable.setBackground(new java.awt.Color(255, 255, 255));
        ProdutosTable.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        ProdutosTable.setForeground(new java.awt.Color(255, 102, 102));
        ProdutosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Quantidade", "Descrição", "Categoria"
            }
        ));
        ProdutosTable.setRowHeight(25);
        ProdutosTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        ProdutosTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProdutosTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ProdutosTable);

        jLabel11.setBackground(new java.awt.Color(255, 102, 102));
        jLabel11.setFont(new java.awt.Font("Arial Black", 0, 30)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Código");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel11))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ProdId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ProdNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8))
                                    .addGap(36, 36, 36))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(CatCb, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ProdQtd, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(ProdDesc, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(IncluirBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(EditarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(ExcluirBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(140, 140, 140))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ProdId, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(ProdNome, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ProdQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(ProdDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(CatCb, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ExcluirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IncluirBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    
//Seleciona os Produtos no Banco de Dados    
    public void SelectProd()
{
    try{
    Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Inventariodb","Andre","1234");
    St = Con.createStatement();
    Rs = St.executeQuery("select * from PRODUTOTBL");
    ProdutosTable.setModel(DbUtils.resultSetToTableModel(Rs));
    }catch(SQLException e)
    {
        e.printStackTrace();
    }    
}

//Seleciona as Categorias no Banco de Dados        
private void GetCat(){
    try{
        Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Inventariodb","Andre","1234");
        St = Con.createStatement();
        String query = "select * from Andre.CATEGORIATBL";
        Rs = St.executeQuery(query);
        while(Rs.next()){
            String MyCat = Rs.getString("CATNOME");
            CatCb.addItem(MyCat);
        }
    }catch(Exception e){
        
    }
}

//Auto preenchimento e incremento   
 private void id_autoincrement(){
        try{
            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Inventariodb","Andre","1234");
            String sqlquery = "select max(PRODID) from PRODUTOTBL";
            PreparedStatement pst = Con.prepareStatement(sqlquery);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                int id = rs.getInt(1);
                int n = id+1;
                ProdId.setText(Integer.toString(n));
            }else{
                
            }
        }catch (Exception ex){
            
        }
    }
 
    private void ProdIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProdIdActionPerformed
    ProdId.setText("");
    id_autoincrement();
    }//GEN-LAST:event_ProdIdActionPerformed

    private void ProdNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProdNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProdNomeActionPerformed

    private void ProdQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProdQtdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProdQtdActionPerformed

    private void ProdDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProdDescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProdDescActionPerformed

//Botão que inclui as entradas no banco de dados       
    private void IncluirBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IncluirBTNMouseClicked
        try{
            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Inventariodb","Andre","1234");
            PreparedStatement add = Con.prepareStatement("insert into PRODUTOTBL values(?,?,?,?,?)");
            add.setInt(1, Integer.valueOf(ProdId.getText()));
            add.setString(2, ProdNome.getText());
            add.setInt(3, Integer.valueOf(ProdQtd.getText()));
            add.setString(4, ProdDesc.getText());
            add.setString(5, CatCb.getSelectedItem().toString());
            int row = add.executeUpdate();
            JOptionPane.showMessageDialog(this, "Produto Adicionado com Sucesso");
            Con.close();
            SelectProd();
        }catch(SQLException e)
        {
            e.printStackTrace();
        } 
        
    }//GEN-LAST:event_IncluirBTNMouseClicked

//Botão que exclui no banco de dados     
    private void ExcluirBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExcluirBtnMouseClicked
        if(ProdId.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Insira o Produto que será exluído");
        }
        else
        {
            try{
            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Inventariodb","Andre","1234");
            String Id = ProdId.getText();
            String Query = "Delete from Andre.PRODUTOTBL where PRODID="+Id;
            Statement Add = Con.createStatement();
            Add.executeUpdate(Query);
            SelectProd();
            JOptionPane.showMessageDialog(this, "Produto Excluído com sucesso");
            }catch(SQLException e)
            {
                e.printStackTrace();
            }
        }    
    }//GEN-LAST:event_ExcluirBtnMouseClicked

//Seleciona um item na tabela que preenche as entradas vazias ou não         
    private void ProdutosTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProdutosTableMouseClicked
        DefaultTableModel model = (DefaultTableModel) ProdutosTable.getModel();
        int Meuindice = ProdutosTable.getSelectedRow();
        ProdId.setText(model.getValueAt(Meuindice, 0).toString());
        ProdNome.setText(model.getValueAt(Meuindice, 1).toString());
        ProdQtd.setText(model.getValueAt(Meuindice, 2).toString());
        ProdDesc.setText(model.getValueAt(Meuindice, 3).toString());
    }//GEN-LAST:event_ProdutosTableMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

//Botão que edita no banco de dados        
    private void EditarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditarBtnMouseClicked
        if(ProdId.getText().isEmpty()||ProdNome.getText().isEmpty()||ProdQtd.getText().isEmpty()||ProdDesc.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Faltam Informações");
        }
        else
        {
            try {
            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Inventariodb","Andre","1234");    
            String Editar = "update Andre.PRODUTOTBL set PRODNOME='"+ProdNome.getText()+"'"+",PRODQTD="+ProdQtd.getText()+""+",PRODDESC='"+ProdDesc.getText()+"'"+",PRODCAT='"+CatCb.getSelectedItem()+"'"+"where PRODID ="+ProdId.getText();
            Statement Add = Con.createStatement();
            Add.executeUpdate(Editar);
            JOptionPane.showMessageDialog(this,"Produto Editado com sucesso");
            SelectProd();
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
            java.util.logging.Logger.getLogger(Produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Produto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CatCb;
    private javax.swing.JButton EditarBtn;
    private javax.swing.JButton ExcluirBtn;
    private javax.swing.JButton IncluirBTN;
    private javax.swing.JTextField ProdDesc;
    private javax.swing.JTextField ProdId;
    private javax.swing.JTextField ProdNome;
    private javax.swing.JTextField ProdQtd;
    private javax.swing.JTable ProdutosTable;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
