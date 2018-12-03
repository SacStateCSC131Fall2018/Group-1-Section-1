package pirexGUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SearchDoc extends JPanel implements ActionListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public SearchDoc() {
	super();
	setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	setupLayout();
    }

    /**
     * Setup and layout for Search
     */
    private void setupLayout()
    {
	JButton clearButton;
	JLabel titleLabel,retrievedText;
	JPanel top, bottom, query, retrieved; 
	JScrollPane  scrollPane;
	JTextArea textArea;
	JTextField textField,hiddenText;

	
	setLayout(new GridLayout(2, 1,0,10));
	
	top = new JPanel(new BorderLayout());
	query = new JPanel(new BorderLayout());
	retrieved = new JPanel(new BorderLayout());
	bottom = new JPanel(new BorderLayout());
	
	//query
	titleLabel = new JLabel("Query: ");
	Font font = new Font("SansSerif", Font.BOLD,12);
	titleLabel.setFont(font);
	query.add(titleLabel, BorderLayout.WEST);
	textField = new JTextField(1);
	query.add(textField, BorderLayout.CENTER);
	clearButton = new JButton("Clear");
	clearButton.addActionListener(this);
	query.add(clearButton, BorderLayout.EAST);
	query.setBorder(BorderFactory.createEmptyBorder(5,0,5,0));
	top.add(query, BorderLayout.NORTH);
	
	// results
	textArea = new JTextArea();
	textArea.setEditable(false);
	scrollPane = new JScrollPane(textArea);
	scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	top.add(textArea, BorderLayout.CENTER);
	
	//retrieved text
	retrievedText = new JLabel(" ");
	retrievedText.setVisible(true);
	hiddenText = new JTextField(1);
	hiddenText.setVisible(false);
	retrieved.add(retrievedText, BorderLayout.WEST);
	retrieved.add(hiddenText, BorderLayout.CENTER);
	retrieved.setBorder(BorderFactory.createEmptyBorder(5,0,10,0));

	//contents	
	textArea = new JTextArea();
	textArea.setEditable(false);
	scrollPane = new JScrollPane(textArea);
	scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	
	bottom.add(retrieved, BorderLayout.NORTH);
	bottom.add(scrollPane, BorderLayout.CENTER);
	
	
	add(top);
	add(bottom);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	String command;
	command = e.getActionCommand();

	if(command.equals("Clear")) {
	    System.out.println("Clear");
	} 
    }

}
