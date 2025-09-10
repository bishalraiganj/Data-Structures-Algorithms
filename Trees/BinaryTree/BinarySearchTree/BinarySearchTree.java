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


	public TreeNode<T> getMax(TreeNode<T> root)
	{
		if(root.getRightChild() == null)
		{
			return root;
		}

	return	getMax(root.getRightChild());
	}



	public void delete2(T value)
	{
		root = delete2(root,value);
	}

	public TreeNode<T> delete2(TreeNode<T> node,T value)
	{
		if(node == null )
		{
			return node;
		}



		if(node.getValue().compareTo(value) == 0) {
			if (node.getLeftChild() == null)
			{
//				if (node.getRightChild().getLeftChild() != null) {
//					TreeNode<T> rpn = getMinParent(node.getRightChild());
//					TreeNode<T> rn = getMin(node.getRightChild());
//
//
//
//						rpn.setLeftChild(rn.getRightChild());
//
//
//					rn.setRightChild(rpn);
//					return rn;

					return node.getRightChild();

				}

			else if (node.getRightChild() == null) {


				return node.getLeftChild();
			}



			else
			{
				if(node.getLeftChild().getRightChild() != null) {
					TreeNode<T> rpn = getMaxParent(node.getLeftChild());
					TreeNode<T> rn = getMax(node.getLeftChild());


					rpn.setRightChild(rn.getLeftChild());

					rn.setRightChild(node.getRightChild());
					rn.setLeftChild(node.getLeftChild());
					return rn;
				}
				else{
					node.getLeftChild().setRightChild(node.getRightChild());
					return node.getLeftChild();
				}


//				node.setValue(node.getLeftChild().getMax().getValue());
//
//				node.setLeftChild(delete(node.getLeftChild(),node.getValue()));


			}



		}

		else
		{
			if(node.getValue().compareTo(value) > 0)
			{
				 node.setLeftChild(delete2(node.getLeftChild(),value));
			}
			else if(node.getValue().compareTo(value) < 0)
			{
				node.setRightChild(delete2(node.getRightChild(),value));
			}
		}

		return node;


	}



	public TreeNode<T> getMaxParent(TreeNode<T> root)
	{
		 if(root.getRightChild().getRightChild() == null)
		{
			return root;
		}

		return getMaxParent(root.getRightChild());
	}




	public TreeNode<T> getMinParent(TreeNode<T> root)
	{
//		if(root.getLeftChild() == null)
//		{
//			return root;
//		}
		if(root.getLeftChild().getLeftChild() == null)
		{
			return root;
		}

		return getMinParent(root.getLeftChild());
	}

	public TreeNode<T> getMin(TreeNode<T> root)
	{
		if(root.getLeftChild() == null)
		{
			return root;
		}

		return getMin(root.getLeftChild());
	}



	public void preOrderTraversal()
	{
		root.preOrderTraversal(root);
	}

}
