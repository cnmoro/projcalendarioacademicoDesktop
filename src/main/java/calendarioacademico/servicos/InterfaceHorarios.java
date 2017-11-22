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
public class InterfaceHorarios extends javax.swing.JFrame {

    /** Creates new form InterfaceHorarios */
    public InterfaceHorarios() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        if (UsuarioManager.getUsuario().getNivelacesso().equalsIgnoreCase("Professor")) {
            this.bt_adicionarHorario.setEnabled(true);
            this.bt_agendarreuniao.setEnabled(false);
        } else {
            this.bt_adicionarHorario.setEnabled(false);
            this.bt_agendarreuniao.setEnabled(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        CalendarioPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("CalendarioPU").createEntityManager();
        profatendimentoQuery = java.beans.Beans.isDesignTime() ? null : CalendarioPUEntityManager.createQuery("SELECT p FROM Profatendimento p");
        profatendimentoList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : profatendimentoQuery.getResultList();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_horarios = new javax.swing.JTable();
        bt_adicionarHorario = new javax.swing.JButton();
        bt_agendarreuniao = new javax.swing.JButton();
        bt_veragendamentos = new javax.swing.JButton();

        setTitle("Horários de Atendimento dos Professores");

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, profatendimentoList, tabela_horarios);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idprofessor.login}"));
        columnBinding.setColumnName("Professor");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${datainicio}"));
        columnBinding.setColumnName("Data Início");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${datafim}"));
        columnBinding.setColumnName("Data Fim");
        columnBinding.setColumnClass(java.util.Date.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(tabela_horarios);

        bt_adicionarHorario.setText("Adicionar Horário");
        bt_adicionarHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_adicionarHorarioActionPerformed(evt);
            }
        });

        bt_agendarreuniao.setText("Agendar Reunião");
        bt_agendarreuniao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_agendarreuniaoActionPerformed(evt);
            }
        });

        bt_veragendamentos.setText("Meus Agendamentos");
        bt_veragendamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_veragendamentosActionPerformed(evt);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_adicionarHorario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_veragendamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_agendarreuniao, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_adicionarHorario)
                    .addComponent(bt_agendarreuniao)
                    .addComponent(bt_veragendamentos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_adicionarHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_adicionarHorarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_adicionarHorarioActionPerformed

    private void bt_agendarreuniaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_agendarreuniaoActionPerformed
        if (profatendimentoList.get(tabela_horarios.getSelectedRow()) != null) {
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja Agendar?", "Confirmação",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resposta == JOptionPane.YES_OPTION) {
                Reuniaoprofessor rp = new Reuniaoprofessor();
                rp.setIdprofatendimento(profatendimentoList.get(tabela_horarios.getSelectedRow()));
                rp.setIdusuario(UsuarioManager.getUsuario());
                EManager.getInstance().getTransaction().begin();
                EManager.getInstance().persist(rp);
                EManager.getInstance().getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Reunião Agendada com Sucesso.");
            }
        }
    }//GEN-LAST:event_bt_agendarreuniaoActionPerformed

    private void bt_veragendamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_veragendamentosActionPerformed
        new InterfaceAgendamentos().setVisible(true);
    }//GEN-LAST:event_bt_veragendamentosActionPerformed

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
            java.util.logging.Logger.getLogger(InterfaceHorarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceHorarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceHorarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceHorarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceHorarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager CalendarioPUEntityManager;
    public javax.swing.JButton bt_adicionarHorario;
    public javax.swing.JButton bt_agendarreuniao;
    private javax.swing.JButton bt_veragendamentos;
    private javax.swing.JScrollPane jScrollPane1;
    private static java.util.List<calendarioacademico.commons.Profatendimento> profatendimentoList;
    private javax.persistence.Query profatendimentoQuery;
    private static javax.swing.JTable tabela_horarios;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

}
