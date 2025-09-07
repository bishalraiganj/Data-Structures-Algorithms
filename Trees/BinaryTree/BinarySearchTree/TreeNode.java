package BinaryTree.BinarySearchTree;

public class TreeNode<T extends Comparable<T>> {


	private final T currVal;
	private final Class<T> valClazz;
	private TreeNode<T> leftChild;
	private TreeNode<T> rightChild;


	public TreeNode(Class<T> valClazz, T currVal) {
		this.valClazz = valClazz;
		if (this.valClazz.equals(currVal.getClass())) {
			this.currVal = currVal;
		} else {
			throw new IllegalArgumentException("Require : " + valClazz.getTypeName() + " Provided: " + currVal.getClass().getTypeName());
		}
	}


	public void insert(T value) {
		if (currVal.compareTo(value) == 0) {
			return;
		} else if (currVal.compareTo(value) > 0) {
			if (leftChild == null) {
				leftChild = new TreeNode<T>(valClazz, value);
			} else {
				leftChild.insert(value);
			}
		} else {
			if (rightChild == null) {
				rightChild = new TreeNode<T>(valClazz, value);
			} else {
				rightChild.insert(value);
			}
		}
	}


	public void traverseInOrder()
	{
		if(leftChild != null)
		{
			leftChild.traverseInOrder();
		}

		System.out.print(currVal +",");

		if(rightChild !=null)
		{
			rightChild.traverseInOrder();
		}

	}


	public TreeNode<T> getLeftChild() {
		return leftChild;
	}

	public TreeNode<T> getRightChild() {
		return rightChild;
	}


	public void setLeftChild(TreeNode<T> leftChild) {
		if (leftChild != null && leftChild.currVal.getClass().equals(valClazz)) {
			this.leftChild = leftChild;
		} else {
			throw new IllegalArgumentException("Required: " + this.leftChild.valClazz.getTypeName() + " Provided: " + leftChild.currVal.getClass().getTypeName());
		}
	}

	public void setRightChild(TreeNode<T> rightChild) {
		if (rightChild != null && rightChild.currVal.getClass().equals(valClazz)) {
			this.rightChild = rightChild;
		} else {
			throw new IllegalArgumentException("Required: " + this.rightChild.valClazz.getTypeName() + " Provided: " + rightChild.currVal.getClass().getTypeName());
		}

	}


	@Override
	public String toString()
	{
		return "Root(%s)  \n  leftChild(%s)     rightChild(%s)".formatted(currVal,leftChild.currVal,rightChild.currVal);

	}






}
