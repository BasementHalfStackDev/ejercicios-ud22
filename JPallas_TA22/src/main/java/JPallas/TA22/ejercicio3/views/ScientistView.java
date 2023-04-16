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
public class ScientistView extends JFrame {

	// Public variables to be accessed by controller
	public JButton btnAdd;
	public JButton btnDel;
	public JButton btnReset;
	public JButton btnModify;
	public JTable table;
	public JTextField textFieldDNI;
	public JTextField textFieldNamSurnam;
	public JTextField textFieldSearch;

	private JPanel contentPane;
	private JScrollPane tableScroll;
	

	/**
	 * Create the frame.
	 */
	public ScientistView() {
		setTitle("Scientist Form");
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
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDNI.setBounds(10, 29, 32, 17);
		FormPanel.add(lblDNI);

		JLabel lblNamSurnam = new JLabel("Name and Surname");
		lblNamSurnam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNamSurnam.setBounds(10, 82, 147, 17);
		FormPanel.add(lblNamSurnam);

		// TextFields
		textFieldDNI = new JTextField();
		textFieldDNI.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldDNI.setBounds(52, 27, 194, 20);
		FormPanel.add(textFieldDNI);
		textFieldDNI.setColumns(10);

		textFieldNamSurnam = new JTextField();
		textFieldNamSurnam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldNamSurnam.setColumns(10);
		textFieldNamSurnam.setBounds(167, 80, 781, 20);
		FormPanel.add(textFieldNamSurnam);

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
