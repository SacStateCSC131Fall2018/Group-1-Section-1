package pirexGUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	contentPane = getContentPane();
	contentPane.setLayout(new BorderLayout());

	tabbedPane = new JTabbedPane();
	contentPane.add(tabbedPane, BorderLayout.CENTER);

	setSize(900,700);

	/** Menu Bar **/
	menuBar = new JMenuBar();
	// file menu 
	fileMenu = new JMenu("File");
	//exit under file menu
	item = new JMenuItem("Exit");
	item.addActionListener(this);
	fileMenu.add(item);

	//help menu
	helpMenu = new JMenu("Help");
	// about under help menu
	item = new JMenuItem("About");
	item.addActionListener(this);
	helpMenu.add(item);

	// options menu
	optionsMenu = new JMenu("Options");

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

	if(command.equals("Exit")) {
	    dispose();
	} 
	else if (command.equals("About")) {
	    JOptionPane.showMessageDialog(contentPane, "Pirex (personal information retrieval experimental system) is an information retrieval \n "
		    + "system that individuals can use to investigate their own texts. ", "About",
		    JOptionPane.INFORMATION_MESSAGE);
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
	Pirex window;

	window = new Pirex();
	window.setTitle("Pirex");        
	window.setVisible(true);
    }


}


