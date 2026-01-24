package avl;

import java.util.Arrays;

public class AvlTreePractise2 {

	//AVL tree practise 2 by Bishal Adhikary (current known most optimized  )

	//For Simplicity not applying encapsulation

	Node root ;

	class Node {

		public int data;
		public int height;
		public Node left;
		public Node right;

		public Node(int data)
		{
			this.data = data;
		}

		@Override
		public String toString()
		{
			return  "[data:"+data+" L:"+left.data+" R:"+right.data+"] ";
		}
	}


	public AvlTreePractise2(int rootData)
	{
		root=new Node(rootData);
	}


	//Single node/vertex insert
	public void insert(int data)
	{
		root = insert(root,data);
	}

	//Batch insertion
	public void insert(int... data)
	{
//		Arrays.stream(data).forEach(e->insert(e));
		Arrays.stream(data).forEach(this::insert);
	}

	private Node insert(Node currNode,int data)
	{
		//Base case , Breaking Condition
		if(currNode==null)
		{
			Node newNode = new Node(data);
			newNode.height=0;
			return newNode;
		}

		//Equals case handling
		if(currNode.data == data)
		{
			return currNode;
		}

		//Goes to the left if smaller than currNode
		if(data < currNode.data) currNode.left = insert(currNode.left,data);
		//Goes to the right if greater than currNode
		if(data > currNode.data) currNode.right = insert(currNode.right,data);

		//Here control comes means recursion started unfolding ,(except for the recursive call where the base case is met)

		//Following logics are for balanceFactor calculation ( can't be safely used to calculate height )

		int leftHeight = currNode.left == null ? -1 : currNode.left.height;
		int rightHeight = currNode.right == null ? -1 : currNode.right.height;

		int balanceFactor = leftHeight - rightHeight;


		//To track , if rotation happened for the currNode and it changed and this recursive call needs to return a different node/vertex
		Node toReturn = currNode;

		//Checking imbalance immediately during recursion unfolding thus balancing each node from bottom-up

		//Left imbalance checking and balancing using rotations
		if(balanceFactor > 1)
		{
			//if LL rotation required
			if(data < currNode.left.data)
			{
				toReturn = LLrotation(currNode);
				//since , parent child relationship has changed for some of the node need to reset for those
				setHeightSimple(currNode);
				setHeightSimple(toReturn);
			}
			//LR rotation required
			else{
					toReturn = LRrotation(currNode);
				//since , parent child relationship has changed for some of the node need to reset for those
					setHeightSimple(currNode);
					setHeightSimple(toReturn.left);
				    setHeightSimple(toReturn);
			}
		}

		//Right imbalance and balancing

		if(balanceFactor < -1 )
		{
			//RR rotation required
			if(data> currNode.right.data)
			{
				toReturn = RRrotation(currNode);
				//since , parent child relationship has changed for some of the node need to reset for those
				setHeightSimple(currNode);
				setHeightSimple(toReturn);
			}
			//RL rotation required
			else{
				toReturn = RLrotation(currNode);
				//since , parent child relationship has changed for some of the node need to reset for those
				setHeightSimple(currNode);
				setHeightSimple(toReturn.right);
				setHeightSimple(toReturn);

			}

		}

		//Re-set the heights even if no rotation happened on it because , rotations may have happened on it's (left,right ) child
		if(toReturn ==currNode)
		{
			setHeightSimple(currNode);
		}
		return toReturn;
	}


	//LL Rotation Logic
	private Node LLrotation(Node imbalancedNode)
	{
		Node newNode = imbalancedNode.left;
		Node newNodeRightChild = newNode.right;
		newNode.right = imbalancedNode;
		imbalancedNode.left = newNodeRightChild;
		return newNode;
	}


	//RR Rotation Logic
	private  Node RRrotation(Node imbalancedNode)
	{
		Node newNode = imbalancedNode.right;
		Node newNodeLeftChild = newNode.left;
		newNode.left = imbalancedNode;
		imbalancedNode.right  = newNodeLeftChild;
		return newNode;
	}

	//LR Rotation ( Composititon of RR and then LL rotation)

	private Node LRrotation(Node imbalancedNode)
	{
		imbalancedNode.left = RRrotation(imbalancedNode.left);
		return LLrotation(imbalancedNode);
	}

	//RL rotation (Composition of LL and then RR rotation)

	private Node RLrotation(Node imbalancedNode)
	{
		imbalancedNode.right = LLrotation(imbalancedNode.right);
		return  RRrotation(imbalancedNode);
	}


	//Simple Height Calculation using child heights (with -1 convention /nulls returning -1 )  this always works because
	//During recursion unwinding the heights are calculated bottom up so child heights are always correct

	public void setHeightSimple(Node currNode)
	{
		if(currNode == null) return;
		int leftHeight = currNode.left == null ? -1 : currNode.left.height;
		int rightHeight = currNode.right == null ? -1  : currNode.right.height;
		currNode.height = Math.max(leftHeight, rightHeight) + 1;
	}


	//Traversal Logics
	public void preOrderInvoke()
	{
		preOrder(root);
	}

	private void preOrder(Node currNode)
	{
		if(currNode == null) return ;
		System.out.print(currNode);
		preOrder(currNode.left);
		preOrder(currNode.right);
	}

	public void inOrderInvoke()
	{
		inOrder(root);
	}
	private void inOrder(Node currNode)
	{
		if(currNode == null) return;
		inOrder(currNode.left);
		System.out.print(currNode);
		inOrder(currNode.right);
	}


	public void postOrderInvoke()
	{
		postOrder(root);
	}
	private void postOrder(Node currNode)
	{
		if(currNode == null) return;
		postOrder(currNode.left);
		postOrder(currNode.right);
		System.out.print(currNode);
	}


}
