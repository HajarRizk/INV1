import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;

public class fn {
private File f;
private binarysearchtree b=new binarysearchtree();
public Vector<LinkedList<String>> invertedIndex=new Vector<LinkedList<String>>(200004);

public void setFolder (File folder) {
	
	f=folder;
System.out.println(f);	
}
public void go()
{
	
	String[] fileList = f.list();  //List of names of file in the Folder

   for(int i=0;i<2;i++)  //Loop on the files in the folder //fileList.length
	{

	String str=new String();
	str=fileList[i] ; //Name of the file
//	System.out.println(str);
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

	
			


	for(int i=0;i<invertedIndex.size();i++)
	{
		System.out.println(invertedIndex.get(i));
	}

    Node root =null;
	for(int i=0;i<invertedIndex.size();i++)
	{	
		
		root=b.insert(root,invertedIndex.get(i).getFirst() ,invertedIndex.get(i));
		
	
	}
	

	
		
}



}
