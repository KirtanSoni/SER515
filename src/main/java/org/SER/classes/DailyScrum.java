package org.SER.classes;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author monil
 */
public class DailyScrum extends javax.swing.JFrame {

    int move1=-1;
    int move2=-1;
    SprintBacklog spbl;
    List<UserStory> todo;
    List<UserStory> inprogress;
    List<UserStory> done;
    /**
     * Creates new form DailyScrum
     */
    public class TableActionCellRenderDropDown extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object o, boolean isSelected, boolean hasFocus, int row, int column) {
            Component com = super.getTableCellRendererComponent(table, o, isSelected, hasFocus, row, column); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody

            PanelActionMove action =  new PanelActionMove();

            if(isSelected==false && row%2==0){
                action.setBackground(Color.WHITE);
            }else{
                action.setBackground(com.getBackground());
            }
            return action;
        }



    }

    public class TableActionCellEditorDropDown extends DefaultCellEditor{

        public TableActionCellEditorDropDown() {
            super(new JCheckBox());
        }



        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

            PanelActionMove action = new PanelActionMove();
            action.setBackground(table.getSelectionBackground());
            return action;
        }



    }


    public class PanelActionMove extends javax.swing.JPanel {

        /**
         * Creates new form PanelAction2
         */
        public PanelActionMove() {
            initComponents();
        }


        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        private void initComponents() {

            jButton1 = new javax.swing.JButton();

            setAlignmentX(0.0F);
            setAlignmentY(0.0F);
            setPreferredSize(new java.awt.Dimension(51, 21));

            jButton1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
            jButton1.setText("Move");

            jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    move1 = TodoTable.getSelectedRow();
                    move2 = ProgressTable.getSelectedRow();
                    if(move1>-1){
                        todo.get(TodoTable.getSelectedRow()).setStatus(Status.IN_PROGRESS);
                    }
                    if(move2>-1){
                        inprogress.get(ProgressTable.getSelectedRow()).setStatus(Status.DONE);
                    }
                }
            });

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
        }// </editor-fold>


        // Variables declaration - do not modify
        private javax.swing.JButton jButton1;
        // End of variables declaration
    }

    public DailyScrum(SprintBacklog sprint) {
        initComponents(sprint);

        TodoTable.getColumnModel().getColumn(1).setCellRenderer(new TableActionCellRenderDropDown());
        TodoTable.getColumnModel().getColumn(1).setCellEditor(new TableActionCellEditorDropDown());
        ProgressTable.getColumnModel().getColumn(1).setCellRenderer(new TableActionCellRenderDropDown());
        ProgressTable.getColumnModel().getColumn(1).setCellEditor(new TableActionCellEditorDropDown());
        DoneTable.getColumnModel().getColumn(1).setCellRenderer(new TableActionCellRenderDropDown());
        DoneTable.getColumnModel().getColumn(1).setCellEditor(new TableActionCellEditorDropDown());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents(SprintBacklog sprint) {

        jLabel1 = new javax.swing.JLabel();
        ProgressPanel = new javax.swing.JScrollPane();
        ProgressTable = new javax.swing.JTable();
        TodoPanel = new javax.swing.JScrollPane();
        TodoTable = new javax.swing.JTable();
        DonePanel = new javax.swing.JScrollPane();
        DoneTable = new javax.swing.JTable();
        progressLabel = new javax.swing.JLabel();
        todoLabel = new javax.swing.JLabel();
        doneLabel = new javax.swing.JLabel();
        spbl = sprint;
        todo = sprint.getUserStoriesbyStatus(Status.TODO);
        inprogress = sprint.getUserStoriesbyStatus(Status.IN_PROGRESS);
        done = sprint.getUserStoriesbyStatus(Status.DONE);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Daily Scrum");

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("Daily Scrum");




        Object[][]  todoRow = new Object[todo.size()][2];
        for (int i = 0; i < todo.size(); i++) {
            todoRow[i][0] = todo.get(i).getTitle();
            todoRow[i][1] = "TODO";

        }
        Object[][]  progressRow = new Object[inprogress.size()][2];
        for (int i = 0; i < inprogress.size(); i++) {
            progressRow[i][0] = inprogress.get(i).getTitle();
            progressRow[i][1] = "IN_PROGRESS";

        }
        Object[][]  doneRow = new Object[done.size()][2];
        for (int i = 0; i < done.size(); i++) {
            doneRow[i][0] = done.get(i).getTitle();
            doneRow[i][1] = "DONE";

        }

        ProgressTable.setModel(new javax.swing.table.DefaultTableModel(
                progressRow,
                new String [] {
                        "User Story", "Status"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ProgressTable.setSelectionBackground(new java.awt.Color(102, 153, 0));
        ProgressTable.setSelectionForeground(new java.awt.Color(255, 255, 255, 0));
        ProgressTable.setShowHorizontalLines(true);
        ProgressPanel.setViewportView(ProgressTable);
        ProgressTable.setRowHeight(30);
        if (ProgressTable.getColumnModel().getColumnCount() > 0) {
            ProgressTable.getColumnModel().getColumn(1).setMinWidth(100);
            ProgressTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            ProgressTable.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        TodoTable.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        TodoTable.setModel(new javax.swing.table.DefaultTableModel(
                todoRow,
                new String [] {
                        "User Story", "Status"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TodoTable.setSelectionBackground(new java.awt.Color(102, 153, 0));
        TodoTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        TodoTable.setShowHorizontalLines(true);
        TodoPanel.setViewportView(TodoTable);
        TodoTable.setRowHeight(30);
//        TodoTable.getSelectedRow();
        if (TodoTable.getColumnModel().getColumnCount() > 0) {
            TodoTable.getColumnModel().getColumn(1).setMinWidth(100);
            TodoTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            TodoTable.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        DoneTable.setModel(new javax.swing.table.DefaultTableModel(
                doneRow,
                new String [] {
                        "User Story", "Status"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DoneTable.setSelectionBackground(new java.awt.Color(102, 153, 0));
        DoneTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        DoneTable.setShowHorizontalLines(true);
        DonePanel.setViewportView(DoneTable);
        DoneTable.setRowHeight(30);
        if (DoneTable.getColumnModel().getColumnCount() > 0) {
            DoneTable.getColumnModel().getColumn(1).setMinWidth(100);
            DoneTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            DoneTable.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        progressLabel.setBackground(new java.awt.Color(255, 255, 255));
        progressLabel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        progressLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        progressLabel.setText("IN PROGRESS");

        todoLabel.setBackground(new java.awt.Color(255, 255, 255));
        todoLabel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        todoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        todoLabel.setText("TODO");

        doneLabel.setBackground(new java.awt.Color(255, 255, 255));
        doneLabel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        doneLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        doneLabel.setText("DONE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(309, Short.MAX_VALUE)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(64, 64, 64))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(todoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(5, 5, 5)
                                                                .addComponent(TodoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(progressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(ProgressPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(DonePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                                        .addComponent(doneLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(progressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(todoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(doneLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(DonePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                                        .addComponent(ProgressPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(TodoPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>

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
            java.util.logging.Logger.getLogger(DailyScrum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DailyScrum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DailyScrum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DailyScrum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DailyScrum(new SprintBacklog()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JScrollPane DonePanel;
    private javax.swing.JTable DoneTable;
    private javax.swing.JScrollPane ProgressPanel;
    private javax.swing.JTable ProgressTable;
    private javax.swing.JScrollPane TodoPanel;
    private javax.swing.JTable TodoTable;
    private javax.swing.JLabel doneLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel progressLabel;
    private javax.swing.JLabel todoLabel;
    // End of variables declaration
}

