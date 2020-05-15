
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class r {

	private JFrame frame;
	private JTextField textField;
	 fn f=new fn ();
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
			    File s= jfile.getSelectedFile();	
		    	
				 f.setFolder(s);
				 f.go();
				
			}
		});
		chooseFile.setBounds(75, 55, 128, 36);
		frame.getContentPane().add(chooseFile);
		
		JButton btnEnterWord = new JButton("Enter Word");
		btnEnterWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
			
			}
		});
		btnEnterWord.setBounds(75, 144, 128, 36);
		frame.getContentPane().add(btnEnterWord);
		
		textField = new JTextField();
		textField.setBounds(243, 144, 116, 36);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
