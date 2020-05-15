
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class r {

	private JFrame frame;
	private JTextField wooo;
	public static File s;
public static 	 fn f =new fn ();
public static  LinkedList<String> l=new  LinkedList<String>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					r window = new r();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public r() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton chooseFile = new JButton("choose Folder");
		chooseFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfile=new JFileChooser();
				jfile.setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY);
				jfile.setDialogTitle("choose Folder");
				int n= jfile.showSaveDialog(null);
			    s= jfile.getSelectedFile();	
		    	
				 f.setFolder(s);
				 f.go();
				
			}
		});
		chooseFile.setBounds(75, 55, 128, 36);
		frame.getContentPane().add(chooseFile);

		wooo = new JTextField();
		wooo.setBounds(243, 144, 116, 36);
		frame.getContentPane().add(wooo);
		wooo.setColumns(10);
		JButton btnEnterWord = new JButton("Search");
		btnEnterWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String st=wooo.getText();
				try {
		         l=	f.search(f.root, st);
				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"Word Not Found");
				}
				output o =new output();
				o.setVisible(true);
			}
		});
		btnEnterWord.setBounds(75, 144, 128, 36);
		frame.getContentPane().add(btnEnterWord);
		
	}
}
