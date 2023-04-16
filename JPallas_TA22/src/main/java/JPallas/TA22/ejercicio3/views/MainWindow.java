package JPallas.TA22.ejercicio3.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	private JPanel contentPane;
	public JButton btnScientists;
	public JButton btnProjects;
	public JButton btnAssignations;

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setTitle("Welcome!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 359, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel("Select a Table");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitle.setBounds(10, 0, 323, 61);
		contentPane.add(lblTitle);

		btnScientists = new JButton("Scientists");
		btnScientists.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnScientists.setBounds(56, 72, 217, 61);
		contentPane.add(btnScientists);

		btnProjects = new JButton("Projects");
		btnProjects.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnProjects.setBounds(56, 144, 217, 61);
		contentPane.add(btnProjects);
		
		btnAssignations = new JButton("Assignations");
		btnAssignations.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnAssignations.setBounds(56, 216, 217, 61);
		contentPane.add(btnAssignations);
		setVisible(true);
	}
}
