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
	JLabel titleLabel;
	JPanel top, bottom, query; 
	JScrollPane  scrollPane;
	JTextArea textArea;

	
	setLayout(new GridLayout(2, 1,0,10));
	
	top = new JPanel(new BorderLayout());
	query = new JPanel(new BorderLayout());
	
	//query
	titleLabel = new JLabel("Query: ");
	Font font = new Font("SansSerif", Font.BOLD,12);
	titleLabel.setFont(font);
	query.add(titleLabel, BorderLayout.WEST);
	textArea = new JTextArea(1,10);
	query.add(textArea, BorderLayout.CENTER);
	clearButton = new JButton("Clear");
	clearButton.addActionListener(this);
	query.add(clearButton, BorderLayout.EAST);
	
	top.add(query, BorderLayout.NORTH);
	
	// results
	textArea = new JTextArea();
	textArea.setEditable(false);
	scrollPane = new JScrollPane(textArea);
	scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	top.add(textArea, BorderLayout.CENTER);

	//contents	
	bottom = new JPanel(new BorderLayout());
	titleLabel = new JLabel(" ");
	textArea = new JTextArea();
	textArea.setEditable(false);
	scrollPane = new JScrollPane(textArea);
	scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
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
