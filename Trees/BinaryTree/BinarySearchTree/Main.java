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

		bst.insert(35);
		bst.insert(45);
		bst.insert(26);
		bst.insert(22);
		bst.insert(27);
		bst.insert(40);
		bst.insert(48);
		bst.insert(39);
		bst.insert(41);
		bst.insert(46);
		bst.insert(49);

		bst.traverseInOrder();
		System.out.println("-".repeat(50));

		System.out.println(bst.get(49));
		System.out.println(bst.get(40));
		System.out.println(bst.get(26));
		System.out.println(bst.get(22));
		System.out.println(bst.get(88));

		System.out.println("-".repeat(50));

		System.out.println(bst.getMax());
		System.out.println(bst.getMin());







	}


}
