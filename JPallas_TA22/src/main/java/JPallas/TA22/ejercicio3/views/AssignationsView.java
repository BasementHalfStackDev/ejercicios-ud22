/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */

package JPallas.TA22.ejercicio3.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class AssignationsView extends JFrame {

	// Public variables to be accessed by controller
	public JButton btnAdd;
	public JButton btnDel;
	public JButton btnReset;
	public JButton btnModify;
	public JTable table;
	public JTextField textFieldScientist;
	public JTextField textFieldProject;
	public JTextField textFieldSearch;

	private JPanel contentPane;
	private JScrollPane tableScroll;

	/**
	 * Create the frame.
	 */
	public AssignationsView() {
		setTitle("Assignations Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 994, 675);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Panel for the input form
		JPanel FormPanel = new JPanel();
		FormPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		FormPanel.setBounds(10, 11, 958, 124);
		contentPane.add(FormPanel);
		FormPanel.setLayout(null);

		// Labels
		JLabel lblScientist = new JLabel("Scientist");
		lblScientist.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblScientist.setBounds(10, 29, 64, 17);
		FormPanel.add(lblScientist);

		JLabel lblProject = new JLabel("Project");
		lblProject.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProject.setBounds(10, 82, 64, 17);
		FormPanel.add(lblProject);

		// TextFields
		textFieldScientist = new JTextField();
		textFieldScientist.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldScientist.setBounds(84, 27, 241, 20);
		FormPanel.add(textFieldScientist);
		textFieldScientist.setColumns(10);

		textFieldProject = new JTextField();
		textFieldProject.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldProject.setColumns(10);
		textFieldProject.setBounds(84, 80, 241, 20);
		FormPanel.add(textFieldProject);

		textFieldSearch = new JTextField(); // Search bar
		textFieldSearch.setToolTipText("Filter");
		textFieldSearch.setBounds(10, 210, 227, 20);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);

		// Panel for buttons
		JPanel ButtonPanel = new JPanel();
		ButtonPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		ButtonPanel.setBounds(10, 146, 958, 53);
		contentPane.add(ButtonPanel);
		ButtonPanel.setLayout(new GridLayout(1, 0, 0, 0));

		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 20));
		ButtonPanel.add(btnAdd);

		btnDel = new JButton("Delete");
		btnDel.setFont(new Font("Tahoma", Font.BOLD, 20));
		ButtonPanel.add(btnDel);

		btnModify = new JButton("Modify");
		btnModify.setFont(new Font("Tahoma", Font.BOLD, 20));
		ButtonPanel.add(btnModify);

		btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 20));
		ButtonPanel.add(btnReset);

		// Panel for table
		JPanel TablePanel = new JPanel();
		TablePanel.setBounds(10, 230, 958, 395);
		contentPane.add(TablePanel);
		TablePanel.setLayout(null);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setBounds(1, 1, 450, 0);
		TablePanel.add(table);

		tableScroll = new JScrollPane(table);
		tableScroll.setBounds(0, 0, 958, 395);
		TablePanel.add(tableScroll);

		setVisible(true);
	}
}
