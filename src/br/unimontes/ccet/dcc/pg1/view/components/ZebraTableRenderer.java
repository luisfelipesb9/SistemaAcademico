package br.unimontes.ccet.dcc.pg1.view.components;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Renderer para criar efeito zebra (linhas alternadas) nas tabelas.
 * Melhora a legibilidade visual dos dados.
 */
public class ZebraTableRenderer extends DefaultTableCellRenderer {

    private static final Color COR_PAR = new Color(245, 245, 250); // Cinza muito claro
    private static final Color COR_IMPAR = Color.WHITE;
    private static final Color COR_SELECIONADA = new Color(184, 207, 229); // Azul claro

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (isSelected) {
            c.setBackground(COR_SELECIONADA);
            c.setForeground(Color.BLACK);
        } else {
            // Efeito zebra
            if (row % 2 == 0) {
                c.setBackground(COR_PAR);
            } else {
                c.setBackground(COR_IMPAR);
            }
            c.setForeground(Color.BLACK);
        }

        return c;
    }
}
