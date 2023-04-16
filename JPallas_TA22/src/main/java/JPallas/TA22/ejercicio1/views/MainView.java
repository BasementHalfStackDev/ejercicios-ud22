/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */

package JPallas.TA22.ejercicio1.views;

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
public class MainView extends JFrame {

	// Public variables to be accessed by controller
	public JButton btnAdd;
	public JButton btnDel;
	public JButton btnReset;
	public JButton btnModify;
	public JTable table;
	public JTextField textFieldDNI;
	public JTextField textFieldNombre;
	public JTextField textFieldApellido;
	public JTextField textFieldDireccion;
	public JTextField textFieldFecha;
	public JTextField textFieldSearch;
	public JTextField textFieldID;

	private JPanel contentPane;
	private JScrollPane tableScroll;

	/**
	 * Create the frame.
	 */
	public MainView() {
		setTitle("SQL Form");
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
		lblDNI.setBounds(10, 32, 32, 17);
		FormPanel.add(lblDNI);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(258, 32, 67, 17);
		FormPanel.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblApellido.setBounds(562, 32, 67, 17);
		FormPanel.add(lblApellido);

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDireccion.setBounds(10, 77, 67, 17);
		FormPanel.add(lblDireccion);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFecha.setBounds(545, 77, 67, 17);
		FormPanel.add(lblFecha);

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblId.setBounds(10, 1, 32, 17);
		FormPanel.add(lblId);

		// TextFields
		textFieldDNI = new JTextField();
		textFieldDNI.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldDNI.setBounds(52, 32, 196, 20);
		FormPanel.add(textFieldDNI);
		textFieldDNI.setColumns(10);

		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(335, 30, 220, 20);
		FormPanel.add(textFieldNombre);

		textFieldApellido = new JTextField();
		textFieldApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(639, 30, 309, 20);
		FormPanel.add(textFieldApellido);

		textFieldDireccion = new JTextField();
		textFieldDireccion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldDireccion.setColumns(10);
		textFieldDireccion.setBounds(87, 77, 448, 20);
		FormPanel.add(textFieldDireccion);

		textFieldFecha = new JTextField();
		textFieldFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(597, 75, 282, 20);
		FormPanel.add(textFieldFecha);

		textFieldID = new JTextField();
		textFieldID.setEditable(false);
		textFieldID.setBounds(52, 1, 111, 20);
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
