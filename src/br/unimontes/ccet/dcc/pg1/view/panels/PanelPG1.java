package br.unimontes.ccet.dcc.pg1.view.panels;

import javax.swing.JPanel;

import br.unimontes.ccet.dcc.pg1.view.interfaces.PanelInterface;
import java.awt.Component;
import java.util.HashMap;

public class PanelPG1 extends JPanel implements PanelInterface {

    @Override
    public HashMap<String, Component> getMapComponents() {
        HashMap<String, java.awt.Component> map = new HashMap<>();
        Component[] vetor = this.getComponents();

        for (int i = 0; i < vetor.length; i++) {
            map.put(vetor[i].getName(), vetor[i]);
        }

        return map;
    }

}
