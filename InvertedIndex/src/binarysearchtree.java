import java.util.LinkedList;

class binarysearchtree {
	public Node createnewnode (String s , LinkedList<String> n)
	{
		Node a=new Node();
		a.word = s;
		a.ids = n;
		a.left=null;
		a.right=null;
		return a;
		
	}
	public Node insert (Node node, String w , LinkedList<String> N) {
		if (node==null) {
			return createnewnode(w,N);
		}
		else if (node.word.compareToIgnoreCase(w)<0) {
			node.right=insert(node.right,w,N);
			
		}
		else if (node.word.compareToIgnoreCase(w)>0) {
			node.left=insert(node.left,w,N);
		}
		
			
		return node;
		
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