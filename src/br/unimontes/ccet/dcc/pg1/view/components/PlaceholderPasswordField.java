package br.unimontes.ccet.dcc.pg1.view.components;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JPasswordField;

/**
 * Campo de senha com placeholder (texto de dica).
 * O placeholder desaparece quando o usuário começa a digitar.
 */
public class PlaceholderPasswordField extends JPasswordField implements FocusListener {

    private String placeholder;
    private boolean showingPlaceholder;
    private Color placeholderColor = new Color(150, 150, 150);
    private Color textColor = Color.BLACK;

    public PlaceholderPasswordField(String placeholder) {
        this.placeholder = placeholder;
        this.showingPlaceholder = true;
        setEchoChar((char) 0); // Mostrar texto do placeholder
        setText(placeholder);
        setForeground(placeholderColor);
        addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (showingPlaceholder) {
            setText("");
            setEchoChar('●'); // Ocultar senha
            setForeground(textColor);
            showingPlaceholder = false;
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (getPassword().length == 0) {
            setEchoChar((char) 0); // Mostrar placeholder
            setText(placeholder);
            setForeground(placeholderColor);
            showingPlaceholder = true;
        }
    }

    /**
     * Retorna a senha real (não o placeholder).
     */
    public String getRealPassword() {
        if (showingPlaceholder) {
            return "";
        }
        return new String(getPassword());
    }

    /**
     * Verifica se está mostrando o placeholder.
     */
    public boolean isShowingPlaceholder() {
        return showingPlaceholder;
    }
}
