package JPallas.TA22.ejercicio1.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

public class mainView extends JFrame {

	private JPanel contentPane;

	private JList list;
	private JButton btnAdd;
	private JButton btnDel;

	/**
	 * Create the frame.
	 */
	public mainView() {
		setTitle("SQL view");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 994, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(175, 300, 89, 23);
		contentPane.add(btnAdd);
		
		btnDel = new JButton("Delete");
		btnDel.setBounds(505, 300, 89, 23);
		contentPane.add(btnDel);
		
		JLabel lblNewLabel = new JLabel("Cliente");
		lblNewLabel.setBounds(39, 69, 46, 14);
		contentPane.add(lblNewLabel);
		
		list = new JList();
		list.setBounds(175, 68, 1, 1);
		contentPane.add(list);
	}
}
