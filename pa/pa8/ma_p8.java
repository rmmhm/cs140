import java.awt.Panel;

class ma_p8 {
    private static int frameWidth = 700;
    private static int frameHeight = 350;
    private static int buttonPanelWidth = 330;
    private static int buttonPanelHeight = 350;
    public static void main(String[] args) {
        createGui();
    }

    public static void createGui() {
        // JFrame
        javax.swing.JFrame f = new javax.swing.JFrame();
		f.setPreferredSize(new java.awt.Dimension(frameWidth, frameHeight));
		f.setMinimumSize(new java.awt.Dimension(frameWidth, frameHeight));
        f.setMaximumSize(new java.awt.Dimension(frameWidth, frameHeight));
		f.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

        // JMenuBar
        javax.swing.JMenuBar menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu("File");
        javax.swing.JMenuItem readSortFile = new javax.swing.JMenuItem("Read sort file");
		javax.swing.JMenuItem readSearchFile = new javax.swing.JMenuItem("Read search file");
        javax.swing.JMenuItem exit = new javax.swing.JMenuItem("Exit");
        MenuItemActionListener readSortFileMenuItemActionListener = new MenuItemActionListener(readSortFile);
		MenuItemActionListener readSearchFileMenuItemActionListener = new MenuItemActionListener(readSearchFile);
        MenuItemActionListener exitFileMenuItemActionListener = new MenuItemActionListener(exit);
        readSortFile.addActionListener(readSortFileMenuItemActionListener);
        readSearchFile.addActionListener(readSearchFileMenuItemActionListener);
        exit.addActionListener(exitFileMenuItemActionListener);
        menuBar.add(fileMenu);
        fileMenu.add(readSortFile);
        fileMenu.add(readSearchFile);
        fileMenu.add(exit);

        // left button panel
        javax.swing.JPanel leftButtonPanel = new javax.swing.JPanel();
        leftButtonPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0,0,0,255),2));
        java.awt.GridBagLayout leftGridBagLayout = new java.awt.GridBagLayout();
        leftButtonPanel.setLayout(leftGridBagLayout);
        leftButtonPanel.setPreferredSize(new java.awt.Dimension(buttonPanelWidth, buttonPanelHeight));

        // right button panel
        javax.swing.JPanel rightButtonPanel = new javax.swing.JPanel();
        rightButtonPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0,0,0,255),2));
        java.awt.GridBagLayout rightGridBagLayout = new java.awt.GridBagLayout();
        rightButtonPanel.setLayout(rightGridBagLayout);
        rightButtonPanel.setPreferredSize(new java.awt.Dimension(buttonPanelWidth, buttonPanelHeight));

        // main button panel
        javax.swing.JPanel mainButtonPanel = new javax.swing.JPanel();
        mainButtonPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0,0,0,255),2));
        javax.swing.BoxLayout boxLayout = new javax.swing.BoxLayout(mainButtonPanel, javax.swing.BoxLayout.X_AXIS);
		mainButtonPanel.setLayout(boxLayout);
        mainButtonPanel.add(leftButtonPanel);
        mainButtonPanel.add(rightButtonPanel);

        // main panel
        javax.swing.JPanel mainPanel = new javax.swing.JPanel();
        mainPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0,0,0,255),2));
        mainPanel.setLayout(new java.awt.BorderLayout());
        mainPanel.add(menuBar, java.awt.BorderLayout.NORTH);
        mainPanel.add(mainButtonPanel, java.awt.BorderLayout.CENTER);

        f.setContentPane(mainPanel);
		
		f.validate();
		f.setVisible(true);
    }

    static class ButtonActionListener implements java.awt.event.ActionListener {
		// the button associated with the action listener, so that we can
		// share this one class with multiple buttons
		private javax.swing.JButton b;
		
		ButtonActionListener(javax.swing.JButton b) {
			this.b = b;
		}
		
		public void actionPerformed(java.awt.event.ActionEvent e) {
			System.out.println("action performed on " + b.getText() + " button");
		}
	}

    static class MenuItemActionListener implements java.awt.event.ActionListener {
		private javax.swing.JMenuItem m;
		
		MenuItemActionListener(javax.swing.JMenuItem m) {
			this.m = m;
		}
		
		public void actionPerformed(java.awt.event.ActionEvent e) {
			System.out.println("action performed on " + m.getText() + " menu item");
			
			// if exit is selected from the file menu, exit the program
			if( m.getText().toLowerCase().equals("exit") ) {
				System.exit(0);
			}
			if(m.getText().toLowerCase().equals("read sort file")) {
                System.out.println("read sort file");
            }
            if(m.getText().toLowerCase().equals("read search file")) {
                System.out.println("read search file");
            }
		}
	}
}
