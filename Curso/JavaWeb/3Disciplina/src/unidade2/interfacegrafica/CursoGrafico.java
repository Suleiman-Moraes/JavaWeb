package unidade2.interfacegrafica;

import javax.swing.JOptionPane;

import unidade2.model.Curso;
import unidade2.persistencia.ClienteDAO;
import unidade2.persistencia.CriaCurso;
import unidade2.persistencia.CursoDAO;

public class CursoGrafico extends javax.swing.JFrame implements CriaCurso {

	private static final long serialVersionUID = 1L;
	private Curso curso;
	private CursoDAO cursoDAO;

	public CursoGrafico() {
		initComponents();
	}

	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jTextFieldNome = new javax.swing.JTextField();
		jTextFieldUrl = new javax.swing.JTextField();
		jTextFieldValor = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jTextFieldCdCurso = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		jButtonAcao = new javax.swing.JButton();
		jComboBoxEscolha = new javax.swing.JComboBox<>();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextAreaSaida = new javax.swing.JTextArea();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)), "CLIENTE",
				javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Tahoma", 1, 24))); // NOI18N

		jTextFieldNome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

		jTextFieldUrl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

		jTextFieldValor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		jLabel1.setText("NOME");

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		jLabel2.setText("URL");

		jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		jLabel3.setText("C�DIGO DO CURSO");

		jTextFieldCdCurso.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

		jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		jLabel4.setText("VALOR");

		jButtonAcao.setBackground(java.awt.Color.red);
		jButtonAcao.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		jButtonAcao.setForeground(java.awt.Color.yellow);
		jButtonAcao.setText("A��O");
		jButtonAcao.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(0, 0, 0)), "CLIK AKI",
				javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
				new java.awt.Font("Tahoma", 1, 11))); // NOI18N
		jButtonAcao.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonAcaoActionPerformed(evt);
			}
		});

		jComboBoxEscolha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jComboBoxEscolha.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "", "NOVO", "DELETE", "ALTERAR", "VISUALIZAR UM", "TODOS" }));
		jComboBoxEscolha.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)), "ESCOLHA",
				javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP,
				new java.awt.Font("Tahoma", 1, 14))); // NOI18N

		jTextAreaSaida.setEditable(false);
		jTextAreaSaida.setColumns(20);
		jTextAreaSaida.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jTextAreaSaida.setRows(5);
		jTextAreaSaida.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)), "SA�DA",
				javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM,
				new java.awt.Font("Tahoma", 1, 12))); // NOI18N
		jScrollPane1.setViewportView(jTextAreaSaida);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane1)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 202,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18).addComponent(jLabel1)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabel4).addGap(18, 18, 18).addComponent(jTextFieldValor,
												javax.swing.GroupLayout.PREFERRED_SIZE, 202,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(jTextFieldUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 202,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18).addComponent(jLabel2)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabel3).addGap(18, 18, 18).addComponent(jTextFieldCdCurso,
												javax.swing.GroupLayout.PREFERRED_SIZE, 202,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										jPanel1Layout.createSequentialGroup()
												.addComponent(jComboBoxEscolha, 0, 460, Short.MAX_VALUE)
												.addGap(18, 18, 18).addComponent(jButtonAcao,
														javax.swing.GroupLayout.PREFERRED_SIZE, 455,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel1))
						.addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)).addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jTextFieldUrl, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2)
								.addComponent(jTextFieldCdCurso, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel3))
						.addGap(18, 18, 18)
						.addGroup(
								jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jButtonAcao, javax.swing.GroupLayout.DEFAULT_SIZE, 54,
												Short.MAX_VALUE)
										.addComponent(jComboBoxEscolha))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
						.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap().addComponent(jPanel1,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup()
										.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addContainerGap()));

		pack();
	}// </editor-fold>

	private void jButtonAcaoActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			saida(chamaMetodo(combobox()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(rootPane, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(CursoGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(CursoGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(CursoGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(CursoGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new CursoGrafico().setVisible(true);
			}
		});
	}

	//Metodos
    private void criarCliente() throws Exception {
    	this.curso = criacao(Long.parseLong(jTextFieldCdCurso.getText()), jTextFieldNome.getText(), 
    			Float.parseFloat(jTextFieldValor.getText()), jTextFieldUrl.getText());
    }
    private long pegarCod() {
    	return Long.parseLong(jTextFieldCdCurso.getText());
    }
    private int combobox() {
    	return jComboBoxEscolha.getSelectedIndex();
    }
    private String chamaMetodo(int combobox) throws Exception {
    	switch (combobox) {
		case 1:{
			criarCliente();
			cursoDAO = new CursoDAO(curso);
			return cursoDAO.novo();
		}
		case 2:{
			cursoDAO = new CursoDAO();
			return cursoDAO.delete(pegarCod());
		}
		case 3:{
			criarCliente();
			cursoDAO = new CursoDAO(curso);
			return cursoDAO.alterar();
		}
		case 4:{
			cursoDAO = new CursoDAO();
			return cursoDAO.visualisarUm(pegarCod());
		}
		case 5:{
			cursoDAO = new CursoDAO();
			return cursoDAO.visualisarTodos();
		}
		default : {return "";}
    	}
    	
    }
    private void saida(String texto) {
    	limpar();
    	jTextAreaSaida.setText(texto);
    }
    private void limpar() {
    	jTextAreaSaida.setText("");
    }
	
	// Variables declaration - do not modify
	private javax.swing.JButton jButtonAcao;
	private javax.swing.JComboBox<String> jComboBoxEscolha;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextAreaSaida;
	private javax.swing.JTextField jTextFieldCdCurso;
	private javax.swing.JTextField jTextFieldNome;
	private javax.swing.JTextField jTextFieldUrl;
	private javax.swing.JTextField jTextFieldValor;
	// End of variables declaration
}
