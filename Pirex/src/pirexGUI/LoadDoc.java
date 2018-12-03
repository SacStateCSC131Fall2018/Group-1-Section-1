package pirexGUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoadDoc extends JPanel implements ActionListener,ItemListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Container contentPane;
    private JTextField textFileField, authorField, titleField;
    
    public LoadDoc(Container contentPane) {
	super();
	this.contentPane = contentPane;
	setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        setupLayout();
    }
    
    /**
     * Setup and layout for Loading
     */
    private void setupLayout() {
	JButton browseButton, processButton;
	JComboBox<String> comboBox;
	JLabel titleLabel;
	JPanel textFile, textType, title, author, titleAuthor, button, top, bottom, line; 
	JScrollPane  scrollPane;
	JTextArea textArea;
	JTextField hiddenText;
	String[] data;
	
	Font font = new Font("SansSerif", Font.BOLD,12);
	
	setLayout(new BorderLayout()); 
	
	textFile = new JPanel(new BorderLayout());
	textType = new JPanel(new BorderLayout());
	title = new JPanel(new BorderLayout());
	author = new JPanel(new BorderLayout());
	titleAuthor = new JPanel(new GridLayout(1,2,40,0));
	button = new JPanel(new BorderLayout());
	top = new JPanel(new BorderLayout());
	bottom = new JPanel(new BorderLayout());
	line = new JPanel(new BorderLayout());
	//Text File
	titleLabel = new JLabel("Text File: ");

	titleLabel.setFont(font);
	textFileField = new JTextField(1);
	browseButton = new JButton("Browse");
	browseButton.addActionListener(this);

	textFile.add(titleLabel, BorderLayout.WEST);
	textFile.add(textFileField, BorderLayout.CENTER);
	textFile.add(browseButton, BorderLayout.EAST);
	textFile.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
	top.add(textFile,BorderLayout.NORTH);
	
	//Text Type 
	titleLabel = new JLabel("Text File Type: ");
	titleLabel.setFont(font);
	data = new String[3];
	data[0] = "Project Gutenberg File";
	data[1] = "HTML Document";
	data[2] = "Rich Text Format (rtf) Document";
	comboBox = new JComboBox<String>(data);
	comboBox.addItemListener(this);
	comboBox.setEditable(true);
	
	textType.add(titleLabel, BorderLayout.WEST);
	textType.add(comboBox, BorderLayout.CENTER);
	textType.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
	top.add(textType,BorderLayout.CENTER);
	
	//Title Author
	titleLabel = new JLabel("Title: ");
	titleLabel.setFont(font);
	titleField = new JTextField(1);
	title.add(titleLabel, BorderLayout.WEST);
	title.add(titleField, BorderLayout.CENTER);
	
	titleLabel = new JLabel("Author: ");
	titleLabel.setFont(font);
	authorField = new JTextField(1);
	author.add(titleLabel, BorderLayout.WEST);
	author.add(authorField, BorderLayout.CENTER);
	
	titleAuthor.add(title);
	titleAuthor.add(author);
	titleAuthor.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 0));
	
	line.add(titleAuthor, BorderLayout.CENTER);
	line.add(new JSeparator(SwingConstants.HORIZONTAL), BorderLayout.SOUTH);
	line.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
	top.add(line, BorderLayout.SOUTH);
	
	//Process Button
	processButton = new JButton("Process");
	processButton.addActionListener(this);
	hiddenText = new JTextField(1);
	hiddenText.setVisible(false);
	
	//Text Area
	textArea = new JTextArea();
	textArea.setEditable(false);
	scrollPane = new JScrollPane(textArea);
	scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	
	button.add(processButton, BorderLayout.WEST);
	button.add(hiddenText, BorderLayout.CENTER);

	bottom.add(button, BorderLayout.NORTH);
	bottom.add(textArea, BorderLayout.CENTER);

	
	add(top, BorderLayout.NORTH);
	add(bottom,BorderLayout.CENTER);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
	String command;
	command = e.getActionCommand();
	
	if(command.equals("Browse")) {
	    int retval;
	    JFileChooser jfc;
	    jfc = new JFileChooser();
	    retval = jfc.showOpenDialog(contentPane);

	    if (retval == JFileChooser.APPROVE_OPTION) {
		textFileField.setText(jfc.getSelectedFile().getPath());
	    }
	} 
	else if(command.equals("Process")) {
	    System.out.println("Process");
	} 
    }

    @SuppressWarnings("unused")
    @Override
    public void itemStateChanged(ItemEvent e) {
	int state;
	String selected;

	selected = (String) (e.getItem());
	state = e.getStateChange();
	
	
    }

}
	