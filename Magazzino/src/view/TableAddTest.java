package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableAddTest extends JPanel {

    private static String[] header = {"Tipo di articolo", "Prezzo", "Data di produzione"};
    
    private DefaultTableModel dtm = new DefaultTableModel(null, header) {
    	@Override
        public boolean isCellEditable(int row, int column) {
           //all cells false
           return false;
        }
    	
        @Override
        public Class<?> getColumnClass(int col) {
            return getValueAt(0, col).getClass();
        }
    };
    private JTable table = new JTable(dtm);
    private JScrollPane scrollPane = new JScrollPane(table);
    private JScrollBar vScroll = scrollPane.getVerticalScrollBar();
    private int row;
    private boolean isAutoScroll;

    public TableAddTest() {
        this.setLayout(new BorderLayout());
        this.setFont(new Font("SansSerif", Font.PLAIN, 14));
        Dimension d = new Dimension(627, 200);
        table.setPreferredScrollableViewportSize(d);
        scrollPane.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        vScroll.addAdjustmentListener(new AdjustmentListener() {

            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                isAutoScroll = !e.getValueIsAdjusting();
            }
        });
        this.add(scrollPane, BorderLayout.CENTER);
    }

    public void addRow(String type, Object price, String date) {
        dtm.addRow(new Object[]{
                type,
                price,
                date
            });
    }
}
