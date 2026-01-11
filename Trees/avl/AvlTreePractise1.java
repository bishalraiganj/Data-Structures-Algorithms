package avl;
public class AvlTreePractise1 {


	private Node root;

	public AvlTreePractise1(Node root)
	{
		this.root = root;
	}


	public class Node {

		int data;
		int height;
		Node left;
		Node right;

		public Node(int data)
		{
			this.data = data;
		}
	}




	public Node insert(Node root, int data)
	{
		if(root == null) {
			Node newNode = new Node(data);
			newNode.height = 0;
			return newNode;
		}

		if(data < root.data) insert(root.left,data);
		if(data > root.data) insert(root.right,data);

		int leftHeight = root.left == null ? -1 : root.left.height;
		int rightHeight =  root.right == null ? -1 : root.right.height;

		int balanceFactor = leftHeight - rightHeight;
		//Geor Adelson Velsky Landis Tree By Bishal_Adhikary 11/01/2026 simple implementaion Practise

		Node toReturn = null;

		//Left Imbalance
		if(balanceFactor > 1) {
			//LL Imbalance Case
			if(data > root.left.data)
			{

			}else
			{
				//LR Imbalance Case
			}
		}
		//Right Imbalance Case
		if(balanceFactor < -1)
		{
			//RR Imbalance Case
			if(data < root.right.data)
			{

			}else
			{
				//RL Imbalance Case
			}
		}

		if(toReturn == root) toReturn.height = Math.max(leftHeight, rightHeight) + 1;
		return toReturn;

	}

	public void setSimpleHeight(Node root)
	{
		if(root == null) return;
		int leftHeight = root.left == null  ? -1 : root.left.height;
		int rightHeight = root.right == null ? -1 : root.right.height;
		root.height = Math.max(leftHeight, rightHeight) + 1;
	}
}
