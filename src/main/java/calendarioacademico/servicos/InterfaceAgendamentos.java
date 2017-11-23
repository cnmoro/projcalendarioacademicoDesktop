/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendarioacademico.servicos;

import calendarioacademico.commons.Reuniaoprofessor;
import calendarioacademico.utils.EManager;
import javax.swing.JOptionPane;

/**
 *
 * @author moro
 */
public class InterfaceAgendamentos extends javax.swing.JFrame {

    /**
     * Creates new form InterfaceAgendamentos
     */
    public InterfaceAgendamentos() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
 
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        CalendarioPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("CalendarioPU").createEntityManager();
        
        if (UsuarioManager.getUsuario().getNivelacesso().equalsIgnoreCase("Professor")) {
            reuniaoprofessorList = EManager.getInstance().createNamedQuery("Reuniaoprofessor.findByProf").setParameter("idprofessor", UsuarioManager.getUsuario()).getResultList();
        } else {
            reuniaoprofessorList = EManager.getInstance().createNamedQuery("Reuniaoprofessor.findByUser").setParameter("idusuario", UsuarioManager.getUsuario()).getResultList();
        }
        
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_agendamentos = new javax.swing.JTable();
        bt_cancelaragendamento = new javax.swing.JButton();

        setTitle("Agendamentos");

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, reuniaoprofessorList, tabela_agendamentos);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idusuario.login}"));
        columnBinding.setColumnName("Usuário");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idprofatendimento.idprofessor.login}"));
        columnBinding.setColumnName("Professor");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idprofatendimento.datainicio}"));
        columnBinding.setColumnName("Data Inicio");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idprofatendimento.datafim}"));
        columnBinding.setColumnName("Data Fim");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(tabela_agendamentos);

        bt_cancelaragendamento.setText("Cancelar agendamento");
        bt_cancelaragendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelaragendamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_cancelaragendamento)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_cancelaragendamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }

    private void bt_cancelaragendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelaragendamentoActionPerformed
        if (reuniaoprofessorList.get(tabela_agendamentos.getSelectedRow()) != null) {
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja Cancelar?", "Confirmação",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resposta == JOptionPane.YES_OPTION) {
                Reuniaoprofessor rp = reuniaoprofessorList.get(tabela_agendamentos.getSelectedRow());
                EManager.getInstance().getTransaction().begin();
                EManager.getInstance().remove(EManager.getInstance().createNamedQuery("Reuniaoprofessor.findById", Reuniaoprofessor.class).setParameter("id", rp.getId()).getSingleResult());
                EManager.getInstance().getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Agendamento cancelado.");
            }
        }
    }//GEN-LAST:event_bt_cancelaragendamentoActionPerformed

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
            java.util.logging.Logger.getLogger(InterfaceAgendamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceAgendamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceAgendamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceAgendamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceAgendamentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager CalendarioPUEntityManager;
    private javax.swing.JButton bt_cancelaragendamento;
    private javax.swing.JScrollPane jScrollPane1;
    public static java.util.List<calendarioacademico.commons.Reuniaoprofessor> reuniaoprofessorList;
    private javax.persistence.Query reuniaoprofessorQuery;
    private static javax.swing.JTable tabela_agendamentos;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
