package pirexGUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class SearchDoc extends JPanel implements ActionListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public SearchDoc() {
	super();
	setupLayout();
    }

    /**
     * Setup and layout for Search
     */
    private void setupLayout()
    {
	setLayout(new BorderLayout());

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
