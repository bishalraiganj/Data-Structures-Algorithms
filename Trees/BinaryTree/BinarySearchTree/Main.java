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


		System.out.println("-".repeat(50));

//		bst.delete(49);

		bst.traverseInOrder();

		System.out.println();
		bst.delete(41);
		bst.traverseInOrder();

		System.out.println("\n"+"-".repeat(50));

		BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(Integer.class);

		TreeNode<Integer> n37 = new TreeNode<>(Integer.class,37);

		TreeNode<Integer> n28 = new TreeNode<>(Integer.class,28);
		TreeNode<Integer> n41 = new TreeNode<>(Integer.class,41);
		TreeNode<Integer> n19 = new TreeNode<>(Integer.class,19);
		TreeNode<Integer> n29 = new TreeNode<>(Integer.class,29);
		TreeNode<Integer> n39 = new TreeNode<>(Integer.class,39);
		TreeNode<Integer> n42 = new TreeNode<>(Integer.class,42);
		TreeNode<Integer> n15 = new TreeNode<>(Integer.class,15);
		TreeNode<Integer> n20= new TreeNode<>(Integer.class,20);
		TreeNode<Integer> n38 = new TreeNode<>(Integer.class,38);
		TreeNode<Integer> n43= new TreeNode<>(Integer.class,43);
		TreeNode<Integer> n21= new TreeNode<>(Integer.class,21);

		n37.insert(28);
		n37.insert(41);
		n37.insert(19);
		n37.insert(29);
		n37.insert(39);
		n37.insert(42);
		n37.insert(15);
		n37.insert(20);
		n37.insert(38);
		n37.insert(43);
		n37.insert(21);

		System.out.println(n37);
		System.out.println(n37.get(19));
		System.out.println(bst2.getMaxParent(n37.get(37)));












		bst2.insert(37);
		bst2.insert(28);
		bst2.insert(29);
		bst2.insert(41);
		bst2.insert(19);
		bst2.insert(20);
		bst2.insert(39);
		bst2.insert(42);
		bst2.insert(15);
		bst2.insert(38);
		bst2.insert(43);
		bst2.insert(21);


		bst2.traverseInOrder();
		System.out.println("\n"+"-".repeat(50));

//		bst2.delete2(29);
//		bst2.delete2(41);

		bst2.traverseInOrder();

		System.out.println("\n"+"-".repeat(50));

		bst2.preOrderTraversal();






















	}


}
