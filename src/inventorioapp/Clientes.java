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
public class Clientes extends javax.swing.JFrame {

    /**
     * Creates new form Clientes
     */
    public Clientes() {
        initComponents();
        SelectCliente();
        id_autoincrement();
    }
    
//Estabelece as conexões
    Connection Con = null;
    Statement St = null;     
    ResultSet Rs = null;
    Statement St1 = null;     
    ResultSet Rs1 = null;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ClieId = new javax.swing.JTextField();
        ClieNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ClieCel = new javax.swing.JTextField();
        IncluirBtn = new javax.swing.JButton();
        ExcluirBtn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        EditarBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ClientesTable = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Pedidolbl = new javax.swing.JLabel();
        ValorPedido = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Contadorlbl = new javax.swing.JLabel();
        NumPedido = new javax.swing.JLabel();

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
        jLabel10.setText("GERENCIAR CLIENTES");

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
        jLabel5.setText("LISTA DE CLIENTES");

        ClieId.setEditable(false);
        ClieId.setBackground(new java.awt.Color(255, 255, 255));
        ClieId.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        ClieId.setForeground(new java.awt.Color(255, 102, 102));
        ClieId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClieIdActionPerformed(evt);
            }
        });

        ClieNome.setBackground(new java.awt.Color(255, 255, 255));
        ClieNome.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        ClieNome.setForeground(new java.awt.Color(255, 102, 102));
        ClieNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClieNomeActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 102, 102));
        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nome");

        jLabel6.setBackground(new java.awt.Color(255, 102, 102));
        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Celular");

        ClieCel.setBackground(new java.awt.Color(255, 255, 255));
        ClieCel.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        ClieCel.setForeground(new java.awt.Color(255, 102, 102));
        ClieCel.setToolTipText("(XXX)9XXXX-XXXX");
        ClieCel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClieCelActionPerformed(evt);
            }
        });

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

        ClientesTable.setBackground(new java.awt.Color(255, 255, 255));
        ClientesTable.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        ClientesTable.setForeground(new java.awt.Color(255, 102, 102));
        ClientesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clientes ID", "Nome", "Número"
            }
        ));
        ClientesTable.setRowHeight(30);
        ClientesTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        ClientesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClientesTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ClientesTable);

        jLabel11.setBackground(new java.awt.Color(255, 102, 102));
        jLabel11.setFont(new java.awt.Font("Arial Black", 0, 30)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Clientes ID");

        jPanel3.setBackground(new java.awt.Color(255, 102, 102));
        jPanel3.setPreferredSize(new java.awt.Dimension(226, 117));

        Pedidolbl.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        Pedidolbl.setForeground(new java.awt.Color(255, 255, 255));
        Pedidolbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        ValorPedido.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        ValorPedido.setText("VALOR DO PEDIDO");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(ValorPedido)
                .addGap(15, 15, 15))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(Pedidolbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ValorPedido)
                .addGap(18, 18, 18)
                .addComponent(Pedidolbl, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 102, 102));

        Contadorlbl.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        Contadorlbl.setForeground(new java.awt.Color(255, 255, 255));

        NumPedido.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        NumPedido.setText("NÚMERO DO PEDIDO");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NumPedido)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Contadorlbl)
                .addGap(100, 100, 100))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NumPedido)
                .addGap(18, 18, 18)
                .addComponent(Contadorlbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(IncluirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(EditarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(ExcluirBtn))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(ClieId, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ClieCel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(102, 102, 102)
                                    .addComponent(ClieNome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ClieId, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(ClieNome, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ClieCel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ExcluirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IncluirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EditarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20))))
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

    
//Seleciona os Clientes no Banco de Dados
public void SelectCliente()
{
    try{
    Con = DriverManager.getConnection("CONEXAO","USER","SENHA");
    St = Con.createStatement();
    Rs = St.executeQuery("select * from CLIENTESTBL");
    ClientesTable.setModel(DbUtils.resultSetToTableModel(Rs));
    }catch(SQLException e)
    {
        e.printStackTrace();
    }    
}

//Auto preenchimento e incremento 
 private void id_autoincrement(){
        try{
            Con = DriverManager.getConnection("CONEXAO","USER","SENHA");
            String sqlquery = "select max(CLIEID) from CLIENTESTBL";
            PreparedStatement pst = Con.prepareStatement(sqlquery);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                int id = rs.getInt(1);
                int n = id+1;
                ClieId.setText(Integer.toString(n));
            }else{
                
            }
        }catch (Exception ex){
            
        }
    }
 
    private void ClieIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClieIdActionPerformed
    ClieId.setText("");
    id_autoincrement();
    }//GEN-LAST:event_ClieIdActionPerformed

    private void ClieNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClieNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClieNomeActionPerformed

    private void ClieCelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClieCelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClieCelActionPerformed

//Botão que inclui as entradas no banco de dados
    private void IncluirBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IncluirBtnMouseClicked
        try{
            Con = DriverManager.getConnection("CONEXAO","USER","SENHA");
            PreparedStatement add = Con.prepareStatement("insert into CLIENTESTBL values(?,?,?)");
            add.setInt(1, Integer.valueOf(ClieId.getText()));
            add.setString(2, ClieNome.getText());
            add.setString(3, ClieCel.getText());
            int row = add.executeUpdate();
            JOptionPane.showMessageDialog(this, "Cliente Adicionado com sucesso");
            Con.close();
            SelectCliente();
        }catch(SQLException e)
        {
            e.printStackTrace();
        } 
        
    }//GEN-LAST:event_IncluirBtnMouseClicked

//Botão que exclui no banco de dados    
    private void ExcluirBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExcluirBtnMouseClicked
    if(ClieId.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Insira o Cliente que será exluído");
        }
        else
        {
            try{
            Con = DriverManager.getConnection("CONEXAO","USER","SENHA");
            String Id = ClieId.getText();
            String Query = "Delete from DB.CLIENTESTBL where CLIEID="+Id;
            Statement Add = Con.createStatement();
            Add.executeUpdate(Query);
            SelectCliente();
            JOptionPane.showMessageDialog(this, "Cliente Excluído com sucesso");
            }catch(SQLException e)
            {
                e.printStackTrace();
            }
        }    
    }//GEN-LAST:event_ExcluirBtnMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
    System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

//Botão que edita no banco de dados    
    private void EditarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditarBtnMouseClicked
    if(ClieId.getText().isEmpty()||ClieNome.getText().isEmpty()||ClieCel.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Faltam Informações");
        }
        else
        {
            try {
            Con = DriverManager.getConnection("CONEXAO","USER","SENHA");    
            String Editar = "update DB.CLIENTESTBL set CLIENOME='"+ClieNome.getText()+"'"+",CLIECEL='"+ClieCel.getText()+"'"+"where CLIEID ="+ClieId.getText();
            Statement Add = Con.createStatement();
            Add.executeUpdate(Editar);
            JOptionPane.showMessageDialog(this,"Cliente Editado com sucesso");
            SelectCliente();
            } catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_EditarBtnMouseClicked

//Seleciona um item na tabela que preenche as entradas vazias ou não    
    private void ClientesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClientesTableMouseClicked
      DefaultTableModel model = (DefaultTableModel) ClientesTable.getModel();
      int Meuindice = ClientesTable.getSelectedRow();
      ClieId.setText(model.getValueAt(Meuindice, 0).toString());
      ClieNome.setText(model.getValueAt(Meuindice, 1).toString());
      ClieCel.setText(model.getValueAt(Meuindice, 2).toString());
      try{
          Con = DriverManager.getConnection("CONEXAO","USER","SENHA"); 
          St = Con.createStatement();
          St1 = Con.createStatement();
          Rs = St.executeQuery("select count(*) from DB.ENCOMENDATBL where CLIENTENOME='"+model.getValueAt(Meuindice, 1).toString()+"'");
          Rs1 = St1.executeQuery("select sum(QTDTOTAL) from DB.ENCOMENDATBL where CLIENTENOME='"+model.getValueAt(Meuindice, 1)+"'");
          while (Rs.next()){
          Contadorlbl.setText(""+Rs.getInt(1));    
          }
          while (Rs1.next()){
          Pedidolbl.setText("R$"+Rs1.getInt(1));
          }
      }catch(Exception e){
          
      }
    }//GEN-LAST:event_ClientesTableMouseClicked

//Botão redireciona para o início    
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
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ClieCel;
    private javax.swing.JTextField ClieId;
    private javax.swing.JTextField ClieNome;
    private javax.swing.JTable ClientesTable;
    private javax.swing.JLabel Contadorlbl;
    private javax.swing.JButton EditarBtn;
    private javax.swing.JButton ExcluirBtn;
    private javax.swing.JButton IncluirBtn;
    private javax.swing.JLabel NumPedido;
    private javax.swing.JLabel Pedidolbl;
    private javax.swing.JLabel ValorPedido;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
