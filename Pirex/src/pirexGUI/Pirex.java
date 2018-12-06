package pirexGUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Pirex extends JFrame implements ActionListener
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Container contentPane;
    
    /**
     * Default Constructor.
     */
    public Pirex()
    {
	super(); 
	setupLayout();
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
    }

    /**
     * Setup and layout
     */
    private void setupLayout()
    {
         
	// Layout 
	JPanel search, load, summarize;
	JTabbedPane tabbedPane;
	JMenuBar menuBar;
	JMenu fileMenu, helpMenu, optionsMenu;
	JMenuItem item;
	
	List<Image> images = new ArrayList<Image>(4);
	try {
	    images.add(ImageIO.read(getClass().getResource("icons/pirexIcon16.png")));
	    images.add(ImageIO.read(getClass().getResource("icons/pirexIcon24.png")));
	    images.add(ImageIO.read(getClass().getResource("icons/pirexIcon32.png")));
	    images.add(ImageIO.read(getClass().getResource("icons/pirexIcon48.png")));
	    setIconImages(images);
	} catch (IOException e) {
	    e.printStackTrace();
	}

	
	contentPane = getContentPane();
	contentPane.setLayout(new BorderLayout());

	tabbedPane = new JTabbedPane();
	contentPane.add(tabbedPane, BorderLayout.CENTER);
	setSize(900,700);

	/** Menu Bar **/
	menuBar = new JMenuBar();
	
	// file menu 
	fileMenu = new JMenu("File");
	
	item = new JMenuItem("Load Query");
	item.addActionListener(this);
	fileMenu.add(item);
	item = new JMenuItem("Save Query");
	item.addActionListener(this);
	fileMenu.add(item);
	item = new JMenuItem("Export");
	item.addActionListener(this);
	fileMenu.add(item);
	item = new JMenuItem("Exit");
	item.addActionListener(this);
	fileMenu.add(item);

	//help menu
	helpMenu = new JMenu("Help");

	item = new JMenuItem("About");
	item.addActionListener(this);
	helpMenu.add(item);
	item = new JMenuItem("Index");
	item.addActionListener(this);
	helpMenu.add(item);

	// options menu
	optionsMenu = new JMenu("Options");
	
	item = new JMenuItem("Sources");
	item.addActionListener(this);
	optionsMenu.add(item);
	item = new JMenuItem("Documents");
	item.addActionListener(this);
	optionsMenu.add(item);
	

	menuBar.add(fileMenu);
	menuBar.add(optionsMenu);
	menuBar.add(helpMenu);
	setJMenuBar(menuBar);

	/** TABS **/
	//search
	search = new JPanel();
	search.setLayout(new BorderLayout());
	search.add(new SearchDoc(), BorderLayout.CENTER);

	// load
	load = new JPanel();
	load.setLayout(new BorderLayout());
	load.add(new LoadDoc(contentPane), BorderLayout.CENTER);

	//summarize
	summarize = new JPanel();
	summarize.setLayout(new BorderLayout());
	summarize.add(new SumDoc(), BorderLayout.CENTER);

	tabbedPane.addTab("Search for Documents", search);
	tabbedPane.addTab("Load Documents",  load);
	tabbedPane.addTab("Summarize Documents", summarize);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	String command;
	command = e.getActionCommand();

	if (command.equals("Load Query")) { 
		String response = JOptionPane.showInputDialog("Load a query from a previous session");
		SearchDoc.setQuery(response);
	}
	else if (command.equals("Save Query")) {
		System.out.println("Saving query: " + SearchDoc.getQuery());
	}
	else if (command.equals("Export")) {
		System.out.println("Exporting search results");
	}
	else if (command.equals("Documents")) {
	    int retval;
	    JFileChooser jfc;
	    jfc = new JFileChooser();
	    retval = jfc.showOpenDialog(contentPane);
	    if (retval == JFileChooser.APPROVE_OPTION)
	    	System.out.println("Set path to Document store");
	}
	else if (command.equals("Sources")) {
	    int retval;
	    JFileChooser jfc;
	    jfc = new JFileChooser();
	    retval = jfc.showOpenDialog(contentPane);
	    if (retval == JFileChooser.APPROVE_OPTION)
	    	System.out.println("Set path to the Source store");
	}
	else if (command.equals("Index")) {
	    JOptionPane.showMessageDialog(contentPane, "Help on the various system features", "Index",
		    JOptionPane.INFORMATION_MESSAGE);
	}
	else if (command.equals("About")) {
	    JOptionPane.showMessageDialog(contentPane, "Pirex (personal information retrieval experimental system) is an information retrieval \n "
		    + "system that individuals can use to investigate their own texts. ", "About",
		    JOptionPane.INFORMATION_MESSAGE);
	}
	else if(command.equals("Exit")) {
	    System.exit(0);
	} 
    }
    
    public static void main(String[] args)
    {
	try {
	    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		if ("Nimbus".equals(info.getName())) {
		    UIManager.setLookAndFeel(info.getClassName());
		    break;
		}
	    }
	} catch (Exception e) {
	    // If Nimbus is not available, you can set the GUI to another look and feel.
	}
	Pirex window = new Pirex(); 
	window.setTitle("Pirex");        
	window.setVisible(true);
    }


}


