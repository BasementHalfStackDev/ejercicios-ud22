package JPallas.TA22.ejercicio2.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	public JButton btnClientes;
	public JButton btnVideos;

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setTitle("Welcome!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 359, 282);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel("Select a Table");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitle.setBounds(10, 0, 323, 61);
		contentPane.add(lblTitle);

		btnClientes = new JButton("Clientes");
		btnClientes.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnClientes.setBounds(91, 72, 148, 61);
		contentPane.add(btnClientes);

		btnVideos = new JButton("Videos");
		btnVideos.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnVideos.setBounds(91, 144, 148, 61);
		contentPane.add(btnVideos);
		setVisible(true);
	}
}
