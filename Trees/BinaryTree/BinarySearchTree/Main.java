package BinaryTree.BinarySearchTree;

public class Main
{
	public static void main(String... args)
	{
		TreeNode<Integer> t3 = new TreeNode<>(Integer.class,3);
		t3.insert(38);
		t3.insert(2);
		System.out.println(t3);


		BinarySearchTree<Integer> bst =  new BinarySearchTree<>(Integer.class);

		bst.insert(25);
		bst.insert(23);
		bst.insert(29);




	}


}
