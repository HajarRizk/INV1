import java.io.File;
import java.io.FileNotFoundException;
import java.util.Timer; 
import java.util.TimerTask; 
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JOptionPane;

public class fn {
private File f;
private binarysearchtree b=new binarysearchtree();
public Vector<LinkedList<String>> invertedIndex=new Vector<LinkedList<String>>(42000);
public  Node root =null;
public void setFolder (File folder) {
	
	f=folder;
	
}


public void go()
{
    
	String[] fileList = f.list();  //List of names of file in the Folder

   for(int i=0;i<fileList.length;i++)  //Loop on the files in the folder //fileList.length
	{
	   
   

	String str=new String();
	str=fileList[i] ; //Name of the file
	try {
	      File myFile = new File(f +"\\"+ str); //Path of the file
	      Scanner myReader = new Scanner(myFile);
	      while (myReader.hasNext())
	      { //Loop on every word in the file
	       String word = myReader.next();
	       word= word.replace('(', ' ');  //Removing all characters from the word
	       word= word.replace(')', ' ');
	       word= word.replace('?', ' ');
	       word= word.replace(',', ' ');
	       word= word.replace('.', ' ');
	       word= word.replace('!', ' ');
	       word= word.replace('/', ' ');
	       word= word.replace(':', ' ');
	       word= word.replace(';', ' ');
	       word=word.trim();
	       word=word.toLowerCase();      //Changing word to LowerCase maybe removed
	       Boolean found=false;
	      
	       for(int j=0;j<invertedIndex.size();j++)// Loop on the vector to see if the word already exists
	       {
	   
	    	   if(invertedIndex.get(j).get(0).equals(word)) 
	    	   {  //the word exists invertedIndex[j]
	    		   if(invertedIndex.get(j).getLast().equals(myFile.getName()))   //the file already exists// if the words exists multiple time in the file
	    		   {
	    			   found=true;
	    			   break;
	    		   }
	    		   else  //add file name to the LinkedList
	    		   {
	    			   invertedIndex.elementAt(j).add(myFile.getName());
	    			   found=true;
	    			   break;
	    		   }
	    	   }
	    	   
	       }
	       if(!found) //if the word doesn't exists in the invertedIndex
	       {
	    	   LinkedList<String> l=new  LinkedList<String>();
	    	   l.add(word);  //first add the word in element(0)
	    	   l.add(myFile.getName());  //then add fileName
	    	   invertedIndex.add(l);
	    	   
	       }
	        
	        
	      }
	      
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	
	        
	}
 
    root =	b.insert(root,invertedIndex.get(0).getFirst() ,invertedIndex.get(0));
	for(int i=1;i<invertedIndex.size();i++)
	{	
		b.insert(root,invertedIndex.get(i).getFirst() ,invertedIndex.get(i));
		
	}
	 JOptionPane.showMessageDialog(null,"Program is Ready Enter your Word "  );
	// System.out.println(invertedIndex.size());	
  //System.out.println("DONE");	

	
		
}

public LinkedList<String> search(Node node,String val){

	while(node!=null) {
		if(node.word.compareToIgnoreCase(val)<0) {
			node=node.right;
		}
		else if(node.word.compareToIgnoreCase(val)>0) {
			node=node.left;
		}
		else {
			break;
		}
		
			
		}
	return node.ids;
	}




}
