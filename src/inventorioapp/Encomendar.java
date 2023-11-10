/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inventorioapp;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author andre
 */
public class Encomendar extends javax.swing.JFrame {

    /**
     * Creates new form EncomendarPedido
     */
    public Encomendar() {
        initComponents();
        SelectProd();
        SelectCliente();
        id_autoincrement();
        GetToday();
    }
    
//Estabelece as conexões  
    Connection Con = null;
    Statement St = null;     
    ResultSet Rs = null;

//Altere "CONEXAO" para a entrada do seu banco de dados
//Altere "USER" para o seu usuário do banco de dados
//Altere "SENHA" para sua senha no banco de dados    
//Altere "DB" para o nome do seu banco de dados
//Note que deve-se fazer isto em todo o código

//Seleciona os Produtos no Banco de Dados        
    public void SelectProd()
{
    try{
    Con = DriverManager.getConnection("CONEXAO","USER","SENHA");
    St = Con.createStatement();
    Rs = St.executeQuery("select * from PRODUTOTBL");
    ProdutosTable.setModel(DbUtils.resultSetToTableModel(Rs));
    }catch(SQLException e)
    {
        e.printStackTrace();
    }    
}

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

//O código seleciona a Data do computador    
    private void GetToday(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        Datalbl.setText(dtf.format(now));
    }

//Edita os Produtos do banco de dados    
    private void atualizar(){
            int novoqtd = oldqtd - Integer.valueOf(Qtdtb.getText());
            try {
            Con = DriverManager.getConnection("CONEXAO","USER","SENHA");  
            String Editar = "update DB.PRODUTOTBL set PRODQTD="+novoqtd+""+"where PRODID ="+produtocod;
            Statement Add = Con.createStatement();
            Add.executeUpdate(Editar);
            SelectProd();
            } catch (Exception e) 
            {
                e.printStackTrace();
            }
    }

//Auto preenchimento e incremento       
    private void id_autoincrement(){
        try{
            Con = DriverManager.getConnection("CONEXAO","USER","SENHA");
            String sqlquery = "select max(ENCOMENDAID) from encomendatbl";
            PreparedStatement pst = Con.prepareStatement(sqlquery);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                int id = rs.getInt(1);
                int n = id+1;
                CodConta.setText(Integer.toString(n));
            }else{
                
            }
        }catch (Exception ex){
            
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        CodConta = new javax.swing.JTextField();
        NomeClientelbl = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Qtdtb = new javax.swing.JTextField();
        Datalbl = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        IncluirBTN = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        VerBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ClientesTable = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ProdutosTable = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ContaTbl = new javax.swing.JTable();
        Totallbl = new javax.swing.JTextField();
        AdicionarProdBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        Preco = new javax.swing.JTextField();
        AdicionarProdBtn1 = new javax.swing.JButton();
        Totallbl1 = new javax.swing.JTextField();

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
        jLabel10.setText("GERENCIAR ENCOMENDAS");

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
                .addGap(241, 241, 241)
                .addComponent(jLabel1)
                .addContainerGap(612, Short.MAX_VALUE))
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
        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("LISTA DE PRODUTOS");

        CodConta.setEditable(false);
        CodConta.setBackground(new java.awt.Color(51, 51, 51));
        CodConta.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        CodConta.setForeground(new java.awt.Color(255, 102, 102));
        CodConta.setBorder(null);
        CodConta.setCaretColor(new java.awt.Color(51, 51, 51));
        CodConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodContaActionPerformed(evt);
            }
        });

        NomeClientelbl.setEditable(false);
        NomeClientelbl.setBackground(new java.awt.Color(51, 51, 51));
        NomeClientelbl.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        NomeClientelbl.setForeground(new java.awt.Color(255, 102, 102));
        NomeClientelbl.setText("Nome do Cliente");
        NomeClientelbl.setBorder(null);
        NomeClientelbl.setCaretColor(new java.awt.Color(51, 51, 51));
        NomeClientelbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeClientelblActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 102, 102));
        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nome do Cliente");

        jLabel6.setBackground(new java.awt.Color(255, 102, 102));
        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Quantidade");

        Qtdtb.setBackground(new java.awt.Color(255, 255, 255));
        Qtdtb.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        Qtdtb.setForeground(new java.awt.Color(255, 102, 102));
        Qtdtb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QtdtbActionPerformed(evt);
            }
        });

        Datalbl.setEditable(false);
        Datalbl.setBackground(new java.awt.Color(51, 51, 51));
        Datalbl.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        Datalbl.setForeground(new java.awt.Color(255, 102, 102));
        Datalbl.setText("Data");
        Datalbl.setBorder(null);
        Datalbl.setCaretColor(new java.awt.Color(51, 51, 51));
        Datalbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DatalblActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 102, 102));
        jLabel8.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Data");

        IncluirBTN.setBackground(new java.awt.Color(255, 255, 255));
        IncluirBTN.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        IncluirBTN.setForeground(new java.awt.Color(255, 102, 102));
        IncluirBTN.setText("INCLUIR PEDIDO");
        IncluirBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IncluirBTNMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                IncluirBTNMouseEntered(evt);
            }
        });
        IncluirBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IncluirBTNActionPerformed(evt);
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

        VerBtn.setBackground(new java.awt.Color(255, 255, 255));
        VerBtn.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        VerBtn.setForeground(new java.awt.Color(255, 102, 102));
        VerBtn.setText("VER PEDIDO");
        VerBtn.setMaximumSize(new java.awt.Dimension(203, 33));
        VerBtn.setMinimumSize(new java.awt.Dimension(203, 33));
        VerBtn.setPreferredSize(new java.awt.Dimension(203, 33));
        VerBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VerBtnMouseClicked(evt);
            }
        });

        ClientesTable.setBackground(new java.awt.Color(255, 255, 255));
        ClientesTable.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        ClientesTable.setForeground(new java.awt.Color(255, 102, 102));
        ClientesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Cliente", "Nome", "Celular"
            }
        ));
        ClientesTable.setRowHeight(25);
        ClientesTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        ClientesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClientesTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ClientesTable);

        jLabel11.setBackground(new java.awt.Color(255, 102, 102));
        jLabel11.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Código do Pedido");

        ProdutosTable.setBackground(new java.awt.Color(255, 255, 255));
        ProdutosTable.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        ProdutosTable.setForeground(new java.awt.Color(255, 102, 102));
        ProdutosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Produto", "Nome", "Quantidade", "Descrição", "Categoria"
            }
        ));
        ProdutosTable.setRowHeight(25);
        ProdutosTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        ProdutosTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProdutosTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ProdutosTable);

        jLabel12.setBackground(new java.awt.Color(255, 102, 102));
        jLabel12.setFont(new java.awt.Font("Arial Black", 1, 30)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("LISTA DE CLIENTES");

        ContaTbl.setBackground(new java.awt.Color(255, 255, 255));
        ContaTbl.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        ContaTbl.setForeground(new java.awt.Color(255, 102, 102));
        ContaTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Produto", "Quantidade", "Upreco", "Total"
            }
        ));
        ContaTbl.setRowHeight(25);
        ContaTbl.setSelectionBackground(new java.awt.Color(255, 255, 255));
        ContaTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ContaTblMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(ContaTbl);

        Totallbl.setBackground(new java.awt.Color(51, 51, 51));
        Totallbl.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        Totallbl.setForeground(new java.awt.Color(255, 102, 102));
        Totallbl.setText("Total");
        Totallbl.setBorder(null);
        Totallbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotallblActionPerformed(evt);
            }
        });

        AdicionarProdBtn.setBackground(new java.awt.Color(255, 255, 255));
        AdicionarProdBtn.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        AdicionarProdBtn.setForeground(new java.awt.Color(255, 102, 102));
        AdicionarProdBtn.setText("ADICIONAR");
        AdicionarProdBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AdicionarProdBtnMouseClicked(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 102, 102));
        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Preço");

        Preco.setBackground(new java.awt.Color(255, 255, 255));
        Preco.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        Preco.setForeground(new java.awt.Color(255, 102, 102));
        Preco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrecoActionPerformed(evt);
            }
        });

        AdicionarProdBtn1.setBackground(new java.awt.Color(255, 255, 255));
        AdicionarProdBtn1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        AdicionarProdBtn1.setForeground(new java.awt.Color(255, 102, 102));
        AdicionarProdBtn1.setText("SALVAR");
        AdicionarProdBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AdicionarProdBtn1MouseClicked(evt);
            }
        });

        Totallbl1.setBackground(new java.awt.Color(51, 51, 51));
        Totallbl1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        Totallbl1.setForeground(new java.awt.Color(255, 102, 102));
        Totallbl1.setText("R$");
        Totallbl1.setBorder(null);
        Totallbl1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Totallbl1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel12)
                .addGap(186, 186, 186)
                .addComponent(jLabel5))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel8))
                            .addComponent(IncluirBTN))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(VerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(CodConta)
                                .addComponent(NomeClientelbl)
                                .addComponent(Datalbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addComponent(jLabel7)
                                .addGap(87, 87, 87))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Qtdtb, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Preco, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Totallbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Totallbl, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86)
                                .addComponent(AdicionarProdBtn1))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(906, 906, 906)
                .addComponent(AdicionarProdBtn))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CodConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NomeClientelbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(Datalbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(VerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IncluirBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(AdicionarProdBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Preco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Qtdtb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Totallbl, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AdicionarProdBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Totallbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(23, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void CodContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodContaActionPerformed
    CodConta.setText("");
    id_autoincrement();
    }//GEN-LAST:event_CodContaActionPerformed

    private void NomeClientelblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeClientelblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeClientelblActionPerformed

    private void QtdtbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QtdtbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QtdtbActionPerformed

    private void DatalblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatalblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DatalblActionPerformed

//Botão que inclui as entradas no banco de dados       
    private void IncluirBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IncluirBTNMouseClicked
        if(CodConta.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Insira o Código de Pedido ");
        }    
        try{
            Con = DriverManager.getConnection("CONEXAO","USER","SENHA");
            PreparedStatement add = Con.prepareStatement("insert into ENCOMENDATBL values(?,?,?,?)");
            add.setInt(1, Integer.valueOf(CodConta.getText()));
            add.setString(2, NomeClientelbl.getText());
            add.setString(3,Datalbl.getText());
            add.setInt(4, Integer.valueOf(Totallbl.getText()));
            int row = add.executeUpdate();
            JOptionPane.showMessageDialog(this, "Pedido Adicionado com Sucesso");
            Con.close();
            SelectProd();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }     
    }//GEN-LAST:event_IncluirBTNMouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        new Home().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3MouseClicked

//Seleciona um item na tabela que preenche as entradas vazias ou não      
    private void ClientesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClientesTableMouseClicked
        DefaultTableModel model = (DefaultTableModel) ClientesTable.getModel();
        int Meuindice = ClientesTable.getSelectedRow();
        NomeClientelbl.setText(model.getValueAt(Meuindice, 1).toString());
    }//GEN-LAST:event_ClientesTableMouseClicked
    int flag = 0,produtocod,oldqtd;
    
    private void ProdutosTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProdutosTableMouseClicked
        DefaultTableModel model = (DefaultTableModel) ProdutosTable.getModel();
        int Meuindice = ProdutosTable.getSelectedRow();
        produtocod = Integer.valueOf(model.getValueAt(Meuindice, 0).toString());
        ProdNome = model.getValueAt(Meuindice, 1).toString();
        oldqtd = Integer.valueOf(model.getValueAt(Meuindice, 2).toString());
        flag = 1;
    }//GEN-LAST:event_ProdutosTableMouseClicked

    private void ContaTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ContaTblMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ContaTblMouseClicked

    private void TotallblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotallblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotallblActionPerformed

//Botão que inclui as entradas no banco de dados      
int i = 1,Upreco,tot=0,total;
String ProdNome;
    private void AdicionarProdBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdicionarProdBtnMouseClicked
    if(flag == 0 || Qtdtb.getText().isEmpty()||Preco.getText().isEmpty()){
        JOptionPane.showMessageDialog(this,"Selecione o Produto e Adicione a Quantidade");
    }    
    else{
    Upreco = Integer.valueOf(Preco.getText());
    tot = Upreco * Integer.valueOf(Qtdtb.getText());
    Vector v = new Vector();
    v.add(i);
    v.add(ProdNome);
    v.add(Qtdtb.getText());
    v.add(Upreco);
    v.add(tot);
    DefaultTableModel dt = (DefaultTableModel)ContaTbl.getModel();
    dt.addRow(v);
    total = total + tot ;
    Totallbl.setText(""+total);
    atualizar();
    i++;
    }//GEN-LAST:event_AdicionarProdBtnMouseClicked
}
    private void PrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrecoActionPerformed

//Botão que inclui as entradas no banco de dados      
    private void AdicionarProdBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdicionarProdBtn1MouseClicked
    try{
        ContaTbl.print();
    }catch(Exception exp){
        exp.printStackTrace();
    }
    }//GEN-LAST:event_AdicionarProdBtn1MouseClicked

    private void Totallbl1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Totallbl1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Totallbl1ActionPerformed

//Abre o JFrame "VerPedidos"   
    private void VerBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VerBtnMouseClicked
    VerPedidos f2 = new VerPedidos();
    f2.setVisible(true);
    }//GEN-LAST:event_VerBtnMouseClicked

    private void IncluirBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IncluirBTNActionPerformed
    id_autoincrement();
    }//GEN-LAST:event_IncluirBTNActionPerformed

    private void IncluirBTNMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IncluirBTNMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_IncluirBTNMouseEntered

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
            java.util.logging.Logger.getLogger(Encomendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Encomendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Encomendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Encomendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Encomendar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdicionarProdBtn;
    private javax.swing.JButton AdicionarProdBtn1;
    private javax.swing.JTable ClientesTable;
    private javax.swing.JTextField CodConta;
    private javax.swing.JTable ContaTbl;
    private javax.swing.JTextField Datalbl;
    private javax.swing.JButton IncluirBTN;
    private javax.swing.JTextField NomeClientelbl;
    private javax.swing.JTextField Preco;
    private javax.swing.JTable ProdutosTable;
    private javax.swing.JTextField Qtdtb;
    private javax.swing.JTextField Totallbl;
    private javax.swing.JTextField Totallbl1;
    private javax.swing.JButton VerBtn;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
