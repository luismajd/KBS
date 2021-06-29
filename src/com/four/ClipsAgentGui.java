package com.four;

import jade.core.AID;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ClipsAgentGui extends JFrame {
    
    private ClipsAgent myAgent;

    private JTextField factField;
    private JTextField ruleField;

    ClipsAgentGui(ClipsAgent a) {
        
        super(a.getLocalName());
		
		myAgent = a;

        JPanel p = new JPanel();
		p.setLayout(new GridLayout(2, 3));
		p.add(new JLabel("Enter fact:"));
		factField = new JTextField(15);
        p.add(factField);
        JButton addFactButton = new JButton("Add Fact");
		addFactButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
                    String fact = factField.getText().trim();
                    myAgent.getFact(fact);
					factField.setText("");
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(ClipsAgentGui.this, "Invalid value. "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
				}
			}
		} );
        p.add(addFactButton);

        p.add(new JLabel("Enter rule:"));
		ruleField = new JTextField(15);
		p.add(ruleField);
        JButton addRuleButton = new JButton("Add Rule");
		addRuleButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
                    String rule = ruleField.getText().trim();
                    myAgent.getRule(rule);
					ruleField.setText("");
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(ClipsAgentGui.this, "Invalid value. "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
				}
			}
		} );
        p.add(addRuleButton);
		getContentPane().add(p, BorderLayout.CENTER);

        JButton executeButton = new JButton("Execute");
		executeButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
                    myAgent.execute();
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(ClipsAgentGui.this, "Invalid value. "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
				}
			}
		} );
		p = new JPanel();
		p.add(executeButton);
		getContentPane().add(p, BorderLayout.SOUTH);

        // Make the agent terminate when the user closes 
		// the GUI using the button on the upper right corner	
		addWindowListener(new	WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				myAgent.doDelete();
			}
		} );
		
		setResizable(false);
    }

    public void showGui() {
		pack();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = (int)screenSize.getWidth() / 2;
		int centerY = (int)screenSize.getHeight() / 2;
		setLocation(centerX - getWidth() / 2, centerY - getHeight() / 2);
		super.setVisible(true);
	}
}