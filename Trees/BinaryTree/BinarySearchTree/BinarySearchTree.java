package BinaryTree.BinarySearchTree;

public class BinarySearchTree<T extends Comparable<T>> {


	private  TreeNode<T> root;
	private final Class<T> valClazz;

	public BinarySearchTree(Class<T> valClazz)
	{
		this.valClazz = valClazz;
	}

	public void insert(T value)
	{
		if(root == null && value.getClass().equals(valClazz))
		{
			this.root = new TreeNode<>((Class<T>) value.getClass(),value);
		}
		else if(value.getClass().equals(valClazz))
		{
			root.insert(value);
		}
		else
		{
			throw new IllegalArgumentException("Invalid Type pass : CHECK !");
		}
	}


	public TreeNode<T> get(T value)
	{
		if(root != null) {
			return root.get(value);
		}
		return null;
	}

	public  void delete(T value)
	{
		root = delete(root,value);
	}

	public TreeNode delete(TreeNode<T> node, T value)
	{
		if(node == null)
		{
			return node;
		}

		if(node.getValue().compareTo(value) == 0 )
		{
			if(node.getLeftChild() == null)
			{
				return node.getRightChild();
			}
			if(node.getRightChild() == null)
			{
				return node.getLeftChild();
			}
		}
		else
		{
			if(node.getValue().compareTo(value) > 0 )
			{
				node.setLeftChild(delete(node.getLeftChild(), value));
			}
			else if(node.getValue().compareTo(value) < 0)
			{
				node.setRightChild(delete(node.getRightChild(), value));
			}
		}

		return node;

	}


	public TreeNode<T> getMax()
	{
		if(root != null)
		{
			return root.getMax();
		}
		return null;

	}

	public TreeNode<T> getMin()
	{
		if(root != null)
		{
			return root.getMin();
		}

		return null;
	}


	public void traverseInOrder()
	{
		root.traverseInOrder();
	}





}
