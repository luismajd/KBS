package com.four;

import jade.core.AID;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ClipsAgentGui extends JFrame {
    
    private ClipsAgent2 myAgent;

    private JTextField folderField;

    ClipsAgentGui(ClipsAgent2 a) {
        
        super(a.getLocalName());
		
		myAgent = a;

        JPanel p = new JPanel();
		p.setLayout(new GridLayout(1, 3));
		p.add(new JLabel("Enter folder name:"));
		folderField = new JTextField(15);
        p.add(folderField);
        JButton selectFolderButton = new JButton("Select");
		selectFolderButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
                    String folderName = folderField.getText().trim();
                    myAgent.getFolderName(folderName);
					folderField.setText("");
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(ClipsAgentGui.this, "Invalid value. "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
				}
			}
		} );
        p.add(selectFolderButton);
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
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("Closing Window...");
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