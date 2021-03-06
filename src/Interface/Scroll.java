package Interface;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Scroll extends JFrame{

	private static final long serialVersionUID = 1L;
	final JScrollPane scroll;

	public Scroll(MapPanel map, String name) throws HeadlessException {
		super(name);

		scroll = new JScrollPane(map, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVisible(true);
		scroll.getVerticalScrollBar().setValue(scroll.getVerticalScrollBar().getMaximum());
		scroll.getVerticalScrollBar().setValue(scroll.getVerticalScrollBar().getMaximum());

		this.setLayout(new BorderLayout());
		this.add(scroll, BorderLayout.CENTER);

	}

	public JScrollPane getScroll() {
		return scroll;
	}
}
