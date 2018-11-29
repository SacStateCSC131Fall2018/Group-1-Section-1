package pirexGUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class SumDoc extends JPanel implements ActionListener{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public SumDoc() {
	super();
        setupLayout();
    }

    /**
     * Setup and layout for Summarizing
     */
    private void setupLayout() {
	setLayout(new BorderLayout());
	
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
    }

}
