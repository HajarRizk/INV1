import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class output extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					output frame = new output();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public output() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 709, 397);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel
				(
			new Object[][] {
			},
			new String[] {
				"File Name", "content"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		DefaultTableModel model=(DefaultTableModel)table.getModel();

		for (int i=0 ;i<r.l.size()-1;i++)
			
		 { 
			String content = null;
			   File file = new File(r.s+"\\"+r.l.get(i+1));
			   try {
			       FileReader reader = new FileReader(file);
			       char[] chars = new char[(int) file.length()];
			       reader.read(chars);
			       content = new String(chars);
			       reader.close();
					model.addRow(new Object[] {r.l.get(i+1),content});
			   } catch (IOException e) {
			       e.printStackTrace();
			   }

		
			
		}
		table.getColumnModel().getColumn(0).setPreferredWidth(61);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		scrollPane.setViewportView(table);
	}
}