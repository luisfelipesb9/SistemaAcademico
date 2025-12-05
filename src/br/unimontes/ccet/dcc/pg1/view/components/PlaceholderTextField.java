package br.unimontes.ccet.dcc.pg1.view.components;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/**
 * Campo de texto com placeholder (texto de dica).
 * O placeholder desaparece quando o usuário começa a digitar.
 */
public class PlaceholderTextField extends JTextField implements FocusListener {

    private String placeholder;
    private boolean showingPlaceholder;
    private Color placeholderColor = new Color(150, 150, 150);
    private Color textColor = Color.BLACK;

    public PlaceholderTextField(String placeholder) {
        this.placeholder = placeholder;
        this.showingPlaceholder = true;
        setText(placeholder);
        setForeground(placeholderColor);
        addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (showingPlaceholder) {
            setText("");
            setForeground(textColor);
            showingPlaceholder = false;
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (getText().isEmpty()) {
            setText(placeholder);
            setForeground(placeholderColor);
            showingPlaceholder = true;
        }
    }

    /**
     * Retorna o texto real (não o placeholder).
     */
    public String getRealText() {
        if (showingPlaceholder) {
            return "";
        }
        return getText();
    }

    /**
     * Verifica se está mostrando o placeholder.
     */
    public boolean isShowingPlaceholder() {
        return showingPlaceholder;
    }

    /**
     * Limpa o campo e mostra o placeholder.
     */
    public void clear() {
        setText(placeholder);
        setForeground(placeholderColor);
        showingPlaceholder = true;
    }
}
