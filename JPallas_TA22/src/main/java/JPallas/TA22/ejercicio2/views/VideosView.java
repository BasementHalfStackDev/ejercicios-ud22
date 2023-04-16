/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */

package JPallas.TA22.ejercicio2.views;

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
public class VideosView extends JFrame {

	// Public variables to be accessed by controller
	public JButton btnAdd;
	public JButton btnDel;
	public JButton btnReset;
	public JButton btnModify;
	public JTable table;
	public JTextField textFieldTitle;
	public JTextField textFieldDirector;
	public JTextField textFieldCli_id;
	public JTextField textFieldSearch;
	public JTextField textFieldID;

	private JPanel contentPane;
	private JScrollPane tableScroll;

	/**
	 * Create the frame.
	 */
	public VideosView() {
		setTitle("Videos Form");
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
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTitle.setBounds(10, 44, 32, 17);
		FormPanel.add(lblTitle);

		JLabel lblDirector = new JLabel("Director");
		lblDirector.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDirector.setBounds(10, 84, 67, 17);
		FormPanel.add(lblDirector);

		JLabel lblCli_id = new JLabel("Cliente Id");
		lblCli_id.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCli_id.setBounds(704, 44, 73, 17);
		FormPanel.add(lblCli_id);

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblId.setBounds(10, 11, 32, 17);
		FormPanel.add(lblId);

		// TextFields
		textFieldTitle = new JTextField();
		textFieldTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldTitle.setBounds(52, 44, 642, 20);
		FormPanel.add(textFieldTitle);
		textFieldTitle.setColumns(10);

		textFieldDirector = new JTextField();
		textFieldDirector.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldDirector.setColumns(10);
		textFieldDirector.setBounds(76, 82, 618, 20);
		FormPanel.add(textFieldDirector);

		textFieldCli_id = new JTextField();
		textFieldCli_id.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldCli_id.setColumns(10);
		textFieldCli_id.setBounds(787, 42, 161, 20);
		FormPanel.add(textFieldCli_id);

		textFieldID = new JTextField();
		textFieldID.setEditable(false);
		textFieldID.setBounds(52, 11, 111, 20);
		FormPanel.add(textFieldID);
		textFieldID.setColumns(10);

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
