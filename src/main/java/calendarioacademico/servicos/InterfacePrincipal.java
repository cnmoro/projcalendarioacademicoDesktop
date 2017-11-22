package calendarioacademico.servicos;

import calendarioacademico.utils.SendMail;
import javax.swing.JOptionPane;

/**
 *
 * @author moro
 */
public class InterfacePrincipal extends javax.swing.JFrame {

    /**
     * Creates new form InterfacePrincipal
     */
    public InterfacePrincipal() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        if (UsuarioManager.getUsuario().getNivelacesso().equalsIgnoreCase("Usuário")) {
            this.botaoPrivilegio.setEnabled(true);
        } else {
            this.botaoPrivilegio.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        CalendarioPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("CalendarioPU").createEntityManager();
        eventoQuery = java.beans.Beans.isDesignTime() ? null : CalendarioPUEntityManager.createQuery("SELECT e FROM Evento e");
        eventoList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : eventoQuery.getResultList();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_eventos = new javax.swing.JTable();
        botaoHorarios = new javax.swing.JButton();
        botaoParticipados = new javax.swing.JButton();
        botaoPrivilegio = new javax.swing.JButton();

        setTitle("Eventos Acadêmicos");

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, eventoList, tabela_eventos);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${autor}"));
        columnBinding.setColumnName("Autor");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${horas}"));
        columnBinding.setColumnName("Horas");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${datainicio}"));
        columnBinding.setColumnName("Data Início");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${datafim}"));
        columnBinding.setColumnName("Data Fim");
        columnBinding.setColumnClass(java.util.Date.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(tabela_eventos);

        botaoHorarios.setText("Horários Professores");
        botaoHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoHorariosActionPerformed(evt);
            }
        });

        botaoParticipados.setText("Eventos Participados");
        botaoParticipados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoParticipadosActionPerformed(evt);
            }
        });

        botaoPrivilegio.setText("Pedir Privilégio");
        botaoPrivilegio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPrivilegioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoHorarios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoParticipados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoPrivilegio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoHorarios)
                    .addComponent(botaoParticipados)
                    .addComponent(botaoPrivilegio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoHorariosActionPerformed
        new InterfaceHorarios().setVisible(true);
    }//GEN-LAST:event_botaoHorariosActionPerformed

    private void botaoParticipadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoParticipadosActionPerformed
        new InterfaceParticipados().setVisible(true);
    }//GEN-LAST:event_botaoParticipadosActionPerformed

    private void botaoPrivilegioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPrivilegioActionPerformed
        Object[] selectionValues = { "Professor", "Colaborador Semana Acadêmica" };
        String initialSelection = "Professor";
        Object selection = JOptionPane.showInputDialog(null, "Qual nível de acesso deseja requisitar?",
            "Seleção", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        try {
            SendMail.enviaEmail(selection.toString());
            JOptionPane.showMessageDialog(null, "Pedido enviado com sucesso.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_botaoPrivilegioActionPerformed

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
            java.util.logging.Logger.getLogger(InterfacePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfacePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfacePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfacePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfacePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager CalendarioPUEntityManager;
    public javax.swing.JButton botaoHorarios;
    public javax.swing.JButton botaoParticipados;
    public javax.swing.JButton botaoPrivilegio;
    private java.util.List<calendarioacademico.commons.Evento> eventoList;
    private javax.persistence.Query eventoQuery;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela_eventos;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
