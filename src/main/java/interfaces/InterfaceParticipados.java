package interfaces;
import utils.EManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.Evento;
import models.Participacao;

/**
 *
 * @author moro
 */
public class InterfaceParticipados extends javax.swing.JFrame {

    /**
     * Creates new form InterfaceParticipados
     */
    public InterfaceParticipados() {
        initComponents();
        this.setDefaultCloseOperation(HIDE_ON_CLOSE); 
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        participacaoList = EManager.getInstance().getDatabaseAccessor().getParticipacoesByUsuario(UsuarioManager.getUsuario());
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaParticipacao = new javax.swing.JTable();
        botaoFeedback = new javax.swing.JButton();
        bt_verhoras = new javax.swing.JButton();

        setTitle("Eventos Participados");

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, participacaoList, tabelaParticipacao);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idevento.nome}"));
        columnBinding.setColumnName("Evento");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${feedback}"));
        columnBinding.setColumnName("Feedback");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(tabelaParticipacao);

        botaoFeedback.setText("Dar Feedback");
        botaoFeedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFeedbackActionPerformed(evt);
            }
        });

        bt_verhoras.setText("Ver Total de Horas Obtidas");
        bt_verhoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_verhorasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoFeedback)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_verhoras))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoFeedback)
                    .addComponent(bt_verhoras))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }

    private void botaoFeedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFeedbackActionPerformed
        if (participacaoList.get(tabelaParticipacao.getSelectedRow()) != null) {
            new InterfaceFeedback().setVisible(true);
        }
    }//GEN-LAST:event_botaoFeedbackActionPerformed

    private void bt_verhorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_verhorasActionPerformed
        List<Evento> eventos = EManager.getInstance().getDatabaseAccessor().getEventos();
        List<Participacao> participacoes = EManager.getInstance().getDatabaseAccessor().getParticipacoes();
        List<Integer> eventoIds = new ArrayList();
        int somaHoras = 0;
        for (int i=0; i<participacoes.size(); i++) {
            if (participacoes.get(i).getIdusuario() == UsuarioManager.getUsuario()) {
                eventoIds.add(participacoes.get(i).getIdevento().getId());
            }
        }
        for (int i=0; i<eventos.size(); i++) {
            if (eventoIds.contains((Integer) eventos.get(i).getId())) {
                somaHoras = somaHoras + eventos.get(i).getHoras();
            }
        }
//        System.out.println(somaHoras);
        JOptionPane.showMessageDialog(null, somaHoras + " horas obtidas por meio da participação em eventos acadêmicos.");
    }//GEN-LAST:event_bt_verhorasActionPerformed

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
            java.util.logging.Logger.getLogger(InterfaceParticipados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceParticipados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceParticipados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceParticipados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceParticipados().setVisible(true);
            }
        });
    }
    
    public static Participacao getParticipacaoSelecionada() {
        return participacaoList.get(tabelaParticipacao.getSelectedRow());
    }

    public javax.swing.JButton botaoFeedback;
    private javax.swing.JButton bt_verhoras;
    private javax.swing.JScrollPane jScrollPane1;
    private static List<Participacao> participacaoList;
    public static javax.swing.JTable tabelaParticipacao;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;

}
