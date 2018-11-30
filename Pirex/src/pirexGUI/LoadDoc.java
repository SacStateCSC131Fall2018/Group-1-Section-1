package pirexGUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class LoadDoc extends JPanel implements ActionListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public LoadDoc() {
	super();
	setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        setupLayout();
    }
    
    /**
     * Setup and layout for Loading
     */
    private void setupLayout() {
	setLayout(new BorderLayout());
	
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
