package br.unimontes.ccet.dcc.pg1.view.components;

import javax.swing.JTextField;

import br.unimontes.ccet.dcc.pg1.view.interfaces.TextFieldInterface;

public class TextFieldPG1 extends JTextField implements TextFieldInterface {

    @Override
    public void setText(String text) {
        super.setText(text);
    }

    @Override
    public String getText() {
        return super.getText();
    }

}
