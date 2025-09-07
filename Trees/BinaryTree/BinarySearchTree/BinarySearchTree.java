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






}
