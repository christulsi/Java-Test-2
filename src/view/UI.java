package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UI extends JFrame implements ActionListener{
	
	private JToolBar toolBar ;
	private JFileChooser fileChooser;
	private File input;
	private JButton action1,action2,action3,action4;
	private JMenuBar menuBar;
	
	public UI(){
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		fileChooser = new JFileChooser();
		//setFilter
		FileNameExtensionFilter filter = new FileNameExtensionFilter("bin", "txt");
		fileChooser.setFileFilter(filter);
			
//		addMenuBar();
//		setJMenuBar(menuBar);
		
		addToolBar();
		contentPane.add(toolBar, BorderLayout.SOUTH);
		
		setTitle("Java Test 2");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000,600);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
	}
	
	private void addMenuBar(){
		
		menuBar = new JMenuBar();		
		JMenu file = new JMenu("File");
		JMenuItem open = new JMenuItem("Open");
		open.addActionListener(this);
		file.add(open);
		menuBar.add(file);
	}
	
	private void addToolBar(){
		
		toolBar = new JToolBar();
		toolBar.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		action1 = new JButton("Action 1");
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;
		toolBar.add(action1,c);
		
		action2 = new JButton("Action 2");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 1;
		c.gridy = 0;
		toolBar.add(action2,c);
		
		action3 = new JButton("Action 3");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 2;
		c.gridy = 0;
		toolBar.add(action3,c);
		
		action4 = new JButton("Action 4");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 3;
		c.gridy = 0;
		toolBar.add(action4,c);
		
		//add ActionListeners to Buttons
		action1.addActionListener(this);
		action2.addActionListener(this);
		action3.addActionListener(this);
		action4.addActionListener(this);
	}
	
	private void open(){

		int ret = fileChooser.showOpenDialog(null);
		
		if (ret == JFileChooser.APPROVE_OPTION) {
			
			input = fileChooser.getSelectedFile();
            //This is where a real application would open the file.
			int extension = input.getName().indexOf('.');
			
			System.out.println("You chose to open this file: " +
		            fileChooser.getSelectedFile().getName());
			
        } else {
           System.out.println("rtyu");
        }
		
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
	
		//handles events for the menu items
		String source = evt.getActionCommand();
		
		if(source.equals("Open")) open();	
		if(source.equals("Exit")) System.exit(0);
		if(source.equals("About")) System.exit(0);
		
		//handles events for the buttons in the toolbar
		if(evt.getSource() instanceof JButton){		
			System.out.println("action");
			JButton clicked = (JButton)evt.getSource();
		
			if(clicked == action1) open();
			if(clicked == action2) open();
			if(clicked == action3) open();
			if(clicked == action4) open();
		
		}
		
		
	}
	
}
