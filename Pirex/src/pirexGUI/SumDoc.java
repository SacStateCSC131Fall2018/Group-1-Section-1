package pirexGUI;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SumDoc extends JPanel {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    JTextArea       messageArea;
    private int indexTerms;
    //Container       contentPane;
    public SumDoc() {
	super();
        setupLayout();
        indexTerms = 0;
        sumUpdate();
    }

    /**
     * Setup and layout for Summarizing
     */
    private void setupLayout() {
        setLayout(new BorderLayout());
	messageArea = new JTextArea();
	messageArea.setEditable(false);
	JScrollPane  scrollPane = new JScrollPane(messageArea);
	scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	add(scrollPane, BorderLayout.CENTER);
	
    }
    
    public void sumUpdate( ) {
	// APPEND THE DOCUMENTS HERE
	messageArea.append("Index Terms: " + indexTerms + "\n");
	messageArea.append("Postings: " + 0); // amount of books in store
    }

}
