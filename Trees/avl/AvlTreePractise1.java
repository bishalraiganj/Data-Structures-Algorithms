package avl;

import java.util.Arrays;

public class AvlTreePractise1 {


	private Node root;

	public AvlTreePractise1(Node root)
	{
		this.root = root;
	}


	public static class Node {

		int data;
		int height;
		Node left;
		Node right;

		public Node(int data)
		{
			this.data = data;
		}

		@Override
		public String toString()
		{
			return "%d(%d)".formatted(data, height);
		}
	}



	public static void main(String... args)
	{
		Node root = new Node(1);
		AvlTreePractise1 tree = new AvlTreePractise1(root);
		tree.insertAll(2,4,3,5);
		tree.preOrder();

	}



	public void insert(int data)
	{
		this.root = insert(this.root, data);
	}

	public void insertAll(int... nodes)
	{
		Arrays.stream(nodes).forEach(this::insert);
	}



	public Node insert(Node root, int data)
	{



		//Base Case / Breaking Condition
		if(root == null) {
			Node newNode = new Node(data);
			newNode.height = 0;
			return newNode;
		}

		//Duplicate Handling Logic
		if(root.data == data) return root;

		if(data < root.data) root.left = insert(root.left,data);
		if(data > root.data) root.right = insert(root.right,data);

		int leftHeight = root.left == null ? -1 : root.left.height;
		int rightHeight =  root.right == null ? -1 : root.right.height;

		int balanceFactor = leftHeight - rightHeight;
		//George Adelson Velsky Landis Tree By Bishal_Adhikary 11/01/2026 simple implementaion Practise

		Node toReturn = root;

		//Left Imbalance
		if(balanceFactor > 1) {
			//LL Imbalance Case
			if(data < root.left.data)
			{
				toReturn  = LlRotate(root);
				setHeightSimple(root);
				setHeightSimple(toReturn);
			}else
			{
				//LR Imbalance Case
				toReturn  = LrRotate(root);
				setHeightSimple(root);
				setHeightSimple(toReturn.left);
				setHeightSimple(toReturn);

			}
		}
		//Right Imbalance Case
		if(balanceFactor < -1)
		{
			//RR Imbalance Case
			if(data > root.right.data)
			{
				toReturn  = RrRotate(root);
				setHeightSimple(root);
				setHeightSimple(toReturn);
			}else
			{
				//Rl Case
				toReturn = RlRotate(root);
				setHeightSimple(root);
				setHeightSimple(toReturn.right);
				setHeightSimple(toReturn);
			}
		}

		if(toReturn == root) setHeightSimple(root);
		return toReturn;

	}


	//The Following are Rotation Methods

	//LL Rotate
	public Node LlRotate(Node root)
	{
		Node newRoot = root.left;
		root.left = newRoot.right;
		newRoot.right = root;
		return newRoot;
	}

	//LR Rotate
	public Node LrRotate(Node root)
	{
		root.left =  RrRotate(root.left);
		return LlRotate(root);
	}


	//RR Case
	public Node RrRotate(Node root)
	{
		Node newRoot = root.right;
		root.right = newRoot.left;
		newRoot.left = root;
		return  newRoot;
	}

	//RL Rotate
	public Node RlRotate(Node root)
	{
		root.right = LrRotate(root.right);
		return RrRotate(root);
	}


	public void setHeightSimple(Node root)
	{
		if(root == null) return;
		int leftHeight = root.left == null  ? -1 : root.left.height;
		int rightHeight = root.right == null ? -1 : root.right.height;
		root.height = Math.max(leftHeight, rightHeight) + 1;
	}


	//The Following Are Traversal Methods by - Bishal Adhikary |Software Engineer| 2026 Please Give Proper Credits If using my Code ;-)


	public void inOrder()
	{
		inOrder(root);
	}

	private void inOrder(Node root)
	{
		if(root == null) return;
		inOrder(root.left);
		System.out.println(root);
		inOrder(root.right);
	}

	public void preOrder()
	{
		preOrder(root);
	}

	private void preOrder(Node root)
	{
		if(root == null) return;
		System.out.println(root);
		preOrder(root.left);
		preOrder(root.right);
	}


	public void postOrder()
	{
		postOrder(root);
	}

	private void postOrder(Node root)
	{
		if(root == null) return ;
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root);
	}

}
