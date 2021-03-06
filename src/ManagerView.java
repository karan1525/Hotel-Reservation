import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A class representing the manager's functions
 *@author Matthew Binning
 *@version 11.5818.221
 *
 */
public class ManagerView extends JFrame
{
	//instance variables of the manager
	private static final int BUTTON_WIDTH=400;
	private static final int BUTTON_HEIGHT=50;
	private static final Dimension btnDim = new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT);
	private static final long serialVersionUID = 1L;
	
	/**
	 * A constructor to construct the manager's JFrame
	 * @param h - the hotel we're working with
	 * @param parent - the current panel's parent
	 */
	public ManagerView(Hotel h, JFrame parent)
	{
		setSize(600, 600);
		setResizable(false);

		setTitle("Hotel Reservation System");
		setLayout(new BorderLayout());
		
		JButton back = new JButton("<");
		back.setPreferredSize(btnDim);
		
		back.addActionListener(new
				ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent arg0)
					{
						parent.setLocation(ManagerView.this.getLocation());
						parent.setVisible(true);
						ManagerView.this.dispose();
					}
				}
		);
		JLabel managerLabel = new JLabel("Manager View Menu");
		
		JPanel managerPanel = new JPanel();
		managerPanel.setLayout(new BoxLayout(managerPanel, BoxLayout.Y_AXIS));
		
		JLabel monthLabel = new JLabel("Month View"); JPanel monthView = new MonthView(h);
		JLabel roomLabel = new JLabel("Room View"); JPanel roomView = new RoomView(h);
		
		managerPanel.add(monthLabel); managerPanel.add(monthView);
		managerPanel.add(roomLabel); managerPanel.add(roomView);
		
		add(managerLabel, BorderLayout.NORTH);
		add(managerPanel, BorderLayout.CENTER);
		add(back, BorderLayout.SOUTH);
	}
}
