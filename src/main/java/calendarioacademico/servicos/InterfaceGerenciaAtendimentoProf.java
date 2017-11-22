/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendarioacademico.servicos;

import calendarioacademico.commons.Profatendimento;
import calendarioacademico.utils.EManager;
import javax.swing.JOptionPane;
import org.freixas.jcalendar.JCalendar;

/**
 *
 * @author moro
 */
public class InterfaceGerenciaAtendimentoProf extends javax.swing.JFrame {

    /**
     * Creates new form InterfaceAddHorario
     */
    public InterfaceGerenciaAtendimentoProf() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        if (!InterfaceHorarios.inserir) {
            this.jcalendar_inicio.setDisplayDate(InterfaceHorarios.getProfatendimentoList().get(InterfaceHorarios.getTabela_horarios().getSelectedRow()).getDatainicio());
            this.jcalendar_fim.setDisplayDate(InterfaceHorarios.getProfatendimentoList().get(InterfaceHorarios.getTabela_horarios().getSelectedRow()).getDatafim());
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

        CalendarioPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("CalendarioPU").createEntityManager();
        profatendimentoQuery = java.beans.Beans.isDesignTime() ? null : CalendarioPUEntityManager.createQuery("SELECT p FROM Profatendimento p");
        profatendimentoList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : profatendimentoQuery.getResultList();
        jCalendar1 = new org.freixas.jcalendar.JCalendar();
        jCalendar2 = new org.freixas.jcalendar.JCalendar();
        jCalendar3 = new org.freixas.jcalendar.JCalendar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcalendar_inicio = new JCalendar( JCalendar.DISPLAY_DATE | JCalendar.DISPLAY_TIME, true);
        jcalendar_fim = new JCalendar( JCalendar.DISPLAY_DATE | JCalendar.DISPLAY_TIME, true);
        jSeparator1 = new javax.swing.JSeparator();
        bt_add = new javax.swing.JButton();

        setTitle("Adicionar Atendimentos");

        jLabel1.setText("Data de Início:");

        jLabel2.setText("Data Final:");

        bt_add.setText("Confirmar");
        bt_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_addActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcalendar_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcalendar_fim, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_add)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jcalendar_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcalendar_fim, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_add)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_addActionPerformed
        if (InterfaceHorarios.inserir) {
            Profatendimento pa = new Profatendimento();
            pa.setIdprofessor(UsuarioManager.getUsuario());
            pa.setDatainicio(this.jcalendar_inicio.getDate());
            pa.setDatafim(this.jcalendar_fim.getDate());
            EManager.getInstance().getTransaction().begin();
            EManager.getInstance().persist(pa);
            EManager.getInstance().getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Horário de atendimento adicionado com sucesso.");
        } else {
            Profatendimento pa = InterfaceHorarios.getProfatendimentoList().get(InterfaceHorarios.getTabela_horarios().getSelectedRow());
            if (pa != null) {
                pa.setDatainicio(this.jcalendar_inicio.getDate());
                pa.setDatafim(this.jcalendar_fim.getDate());
                EManager.getInstance().getTransaction().begin();
                EManager.getInstance().merge(pa);
                EManager.getInstance().getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Horário de atendimento modificado com sucesso.");
            }
        }
        this.dispose();
    }//GEN-LAST:event_bt_addActionPerformed

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
            java.util.logging.Logger.getLogger(InterfaceGerenciaAtendimentoProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceGerenciaAtendimentoProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceGerenciaAtendimentoProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceGerenciaAtendimentoProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceGerenciaAtendimentoProf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager CalendarioPUEntityManager;
    private javax.swing.JButton bt_add;
    private org.freixas.jcalendar.JCalendar jCalendar1;
    private org.freixas.jcalendar.JCalendar jCalendar2;
    private org.freixas.jcalendar.JCalendar jCalendar3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private org.freixas.jcalendar.JCalendar jcalendar_fim;
    private org.freixas.jcalendar.JCalendar jcalendar_inicio;
    private static java.util.List<calendarioacademico.commons.Profatendimento> profatendimentoList;
    private javax.persistence.Query profatendimentoQuery;
    // End of variables declaration//GEN-END:variables
}