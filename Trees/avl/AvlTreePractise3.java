package avl;

public class AvlTreePractise3 {


	Node root;




	class Node{

		int data ;
		int height;
		Node left,right;
		public Node(int data){}
	}



	private Node insert(Node currNode, int data)
	{
		if(currNode == null)
		{
			Node newNode = new Node(data);
			newNode.height = 0;
			return newNode;
		}

		if(data < currNode.data) currNode.left = insert(currNode.left,data);
		if(data > currNode.data) currNode.right = insert(currNode.right,data);


		//if we use 0 convention then we will be off by 1 , but -1 works naturally
		int leftHeight = currNode.left == null ? -1 : currNode.left.height;
		int rightHeight = currNode.right == null ? -1 : currNode.right.height;

		int balanceFactor = leftHeight - rightHeight;


		int leftBalanceFactor = switch()


		//Left imbalance from currNode
		if(balanceFactor > 1)
		{
			//LL case



		}





	}



}
