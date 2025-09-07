package BinarySearchTree;

import java.lang.reflect.Array;
import java.lang.reflect.*;
import java.util.StringJoiner;

public class TreeNode<T extends Comparable<T>> {

	private final T value;
	private TreeNode<T> leftChild;
	private TreeNode<T> rightChild;
	private final Type tp ;
	private final TypeReference<T> tr;

	public TreeNode(TypeReference<T> typRef,T value)
	{
		this.tr = typRef;
		this.tp = typRef.getType();
		System.out.println(tp.toString() + "   " + tp.getTypeName());

		if(value.getClass().getGenericSuperclass().equals(tp)) {
			this.value = value;
		}else
		{
			throw new IllegalArgumentException();
		}

	}

	private boolean checkChild(TreeNode<T> childNode)
	{

		if(childNode!=null && childNode.tp.equals(this.tp))
		{
			return true;
		}
		return false;

	}

	public void insert(T value)
	{
		T currVal = this.value;
			if(currVal.compareTo(value)==0)
			{
				return;
			}

			else if(currVal.compareTo(value) > 0)
			{
				if(leftChild==null)
				{
					leftChild = new TreeNode<T>(tr,value);
				}
				else
				{
					leftChild.insert(value);
				}
			}
			else
			{
				if(rightChild==null)
				{
					rightChild = new TreeNode<T>(tr,value);
				}
				else
				{
					rightChild.insert(value);
				}
			}
	}

	public void setLeftChild(TreeNode<T> leftChild)
	{
		if(checkChild(leftChild)) {
			this.leftChild = leftChild;
		}
	}

	public void setRightChild(TreeNode<T> rightChild)
	{
		if(checkChild(rightChild)) {
			this.rightChild = rightChild;
		}
	}

	public TreeNode<T> getLeftChild()
	{
		return this.leftChild;
	}

	public TreeNode<T> getRightChild()
	{
		return this.rightChild;
	}

	@Override
	public String toString()
	{

		String lc = leftChild!=null?leftChild.value.toString():"null";
		String rc = rightChild!=null?rightChild.value.toString():"null";

		return "root : " +this.value.toString() + "\n" + "left child :"+lc+ "    "  + "right child : " +rc;

	}

}
