package binartreecontest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TestTree<E> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int size=0;
		Scanner scan=new Scanner(System.in);
		CapacityGetterSetter getset = new CapacityGetterSetter();
		size=Integer.parseInt(scan.nextLine());
		size++;
		getset.setCapacity(size);
		Integer[] testlist = new Integer[size];
		testlist[0] = null;
		String data=scan.nextLine();
		String[] items=data.split(" ");
		for (int i = 1; i <size; i++) {
			if(Integer.parseInt(items[i-1])!=0)
			{
				testlist[i]=Integer.parseInt(items[i-1]);
			}
				
		}
		IBinaryTree<Integer> btree1 = new BinaryTree<Integer>();
		btree1.constructTree(testlist);
		//System.out.println();
		int inputs = Integer.parseInt(scan.nextLine());

		while (inputs > 0) {
			String operation = scan.nextLine();
			String[] temp = operation.split(" ");
			if (temp[0].equals("P"))
				btree1.printTree();
			if (temp[0].equals("H"))
			{
				Node<Integer> node = (Node<Integer>) btree1.getNode(Integer.parseInt(temp[1]));
				System.out.println("Height " + btree1.getHeight(node));
			}
			if (temp[0].equals("D")) {
				Node<Integer> node = (Node<Integer>) btree1.getNode(Integer.parseInt(temp[1]));
				System.out.println("Depth " + btree1.getDepth(node));

			}
			if (temp[0].equals("PRE")) {
				System.out.println("Preorder Traversal");
				btree1.preorderTraverse((Node<Integer>) btree1.getRoot());
				System.out.println();
			}
			if (temp[0].equals("POS")) {
				System.out.println("Postorder Traversal");
				btree1.postorderTraverse((Node<Integer>) btree1.getRoot());
				System.out.println();
			}
			if (temp[0].equals("IN")) {
				System.out.println("Inorder Traversal");
				btree1.inorderTraverse((Node<Integer>) btree1.getRoot());
				System.out.println();
			}
			if (temp[0].equals("LEV")) {
				System.out.println("Level order Traversal");
				btree1.levelorderTraverse((Node<Integer>) btree1.getRoot());
				System.out.println();
			}
			if (temp[0].equals("IP")) {
				System.out.println(btree1.isProper());
			}
			if (temp[0].equals("EXT")) {
				System.out.println("External nodes are");
				btree1.printExternal();
				System.out.println();
			}
			if (temp[0].equals("BOT")) {
				System.out.println("BOUNDARY Traversal");
				btree1.boundaryTraverse((Node<Integer>) btree1.getRoot());
				System.out.println();
			}
				
			inputs--;
		}	
		
	}

}

class CapacityGetterSetter {
	private static int treesize;

	public int getCapacity() {
		return this.treesize;
	}

	public void setCapacity(int cap) {
		treesize = cap;
	}
}
interface IBinaryTree<E> {
	int size();
	boolean isEmpty();
	Object getRoot();
	void setRoot(Node<E> node);
	Object getNode(int pos);
	Object findNode(E val);
	void insertChild(Node<E> curnode, E elt, char type);
	void constructTree(E[] eltArray);
	void printTree();
	void inorderTraverse(Node<E> node);
	void preorderTraverse(Node<E> node);
	void postorderTraverse(Node<E> node);
	void levelorderTraverse(Node<E> node);
	int getDepth(Node<E> node);
	int getHeight(Node<E> node);
	boolean isProper(); //this method checks if the given tree is Proper or not
	void printExternal(); //it prints all the external nodes of a tree
	void boundaryTraverse(Node<E> node);
}


class Node<E> {
	private E element; 
	private Node<E> parent;
	private Node<E> leftchild;
	private Node<E> rightchild;
	public Node(){
		element = null;
		parent = null;
		leftchild = null;
		rightchild = null;
	}
	public Node(E e, Node curparent)
	{
		element = e;
		parent = curparent;
	}
	public E getElement(){
		return element;
	}
	public Node<E> getParent(){
		return parent;
	}
	public Node<E> getlChild(){
		return leftchild;
	}
	public Node<E> getrChild(){
		return rightchild;
	}
	public void setElement(E e){
		element = e;
	}
	public void setParent(Node<E> parent1){
		parent = parent1;
	}
	public void setLeft(Node<E> lchild){
		leftchild = lchild;
		leftchild.setParent(this);
	}
	public void setRight(Node<E> rchild){
		rightchild = rchild;
		rightchild.setParent(this);
	}
	public boolean isInternal(){
		return (leftchild!=null||rightchild!=null);
	}
	public boolean isExternal(){
		return (leftchild==null && rightchild ==null);
	}
	public boolean isRoot(){
		return (parent == null);
	}
}
class BinaryTree<E> implements IBinaryTree<E>{

	private Node<E> root;
	private int sz;
	CapacityGetterSetter getset = new CapacityGetterSetter();
	int size=0;
	private Node<E>[] nodelist;
	public BinaryTree(){
		size=getset.getCapacity();
		nodelist = new Node[size];
		root = null;
		sz=0;
	}


	public Node<E> getRoot() {
		// TODO Auto-generated method stub
		return root;
	}

	public void setRoot(Node<E> node) {
		// TODO Auto-generated method stub
		root = node;
		sz++;
	}

	public Node<E> findNode(E val){
		return null;
	}

	public Node<E> getNode(int pos){
		return nodelist[pos];
	}
	//inserts a node whose value is elt as a child of curnode

	public void insertChild(Node<E> curnode, E elt, char type) {
		// TODO Auto-generated method stub
		Node<E> curchild=new Node<>(elt,curnode);
		if(type=='l') {
			curnode.setLeft(curchild);
			curchild.setParent(curnode);
		}
		
		else 
			{curnode.setRight(curchild);
			curchild.setParent(curnode);
			}

	}

	public void constructTree(E[] eltArray) {
		// TODO Auto-generated method stub
		Node<E> newnode = new Node<E>(eltArray[1],null);
		root = newnode;
		nodelist[0]=null;
		nodelist[1]=root;
		for (int i=2; i<eltArray.length;i++){
			if (eltArray[i]!=null){

				if(i%2==0){
					//System.out.println(nodelist[i/2]);
					insertChild(nodelist[i/2],eltArray[i],'l');
					nodelist[i]=nodelist[i/2].getlChild();
				}
				else{
					insertChild(nodelist[i/2],eltArray[i],'r');
					nodelist[i]=nodelist[i/2].getrChild();
				}
			}
			else nodelist[i]=null;
		}
	}

	public void printTree() {
		// TODO Auto-generated method stub
		for (int i=1;i<nodelist.length;i++)
		{
			if (nodelist[i]!=null){
				System.out.println("Elt-"+nodelist[i].getElement() + "; Pos"+i);
			}
		}

	}

	public void inorderTraverse(Node<E> node) {
		// TODO Auto-generated method stub
		

	}

	public void preorderTraverse(Node<E> node) {
		// TODO Auto-generated method stub
		

	}

	public void postorderTraverse(Node<E> node) {
		// TODO Auto-generated method stub

		
	}

	public void levelorderTraverse(Node<E> node) {
		// TODO Use the queue to do the traversal. You can also use the inbuilt Queue
		
	}
	
	public void boundaryTraverse(Node<E> node) {
		// TODO Auto-generated method stub
		

	}
	void printLeaves(Node node) 
    {
        //use System.out.print(node.getElement() + "->");
    }
	void printBoundaryLeft(Node node) 
    {
        //use System.out.print(node.getElement() + "->");
    }
	 void printBoundaryRight(Node node) 
	    {
	        use System.out.print(node.getElement() + "->");
	    }

	public int getDepth(Node<E> node) {
		// TODO Auto-generated method stub
		
		
	}

	public int getHeight(Node<E> node) {
		// TODO Auto-generated method stub
		
	}

	public int size() {
		// TODO Auto-generated method stub
		return sz;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (sz==0);
	}


	public boolean isProper() {
		
		
	}


	public void printExternal() {
		// TODO Auto-generated method stub
		// TODO Use the queue to do the traversal. You can also use the inbuilt Queue
		for(Node<E> temp:nodelist){
			if(temp!=null && temp.isExternal())
			{
				System.out.print(temp.getElement()+"->");
			}
		}

	}

}