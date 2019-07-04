
import java.util.Scanner;

 class Browser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		CapacityGetterSetter getset = new CapacityGetterSetter();
		int testcases=0 ;
		int operations=0;
		int historysize=0;
		 try {
			 testcases= Integer.parseInt(scan.nextLine());		 	
		 }catch (NumberFormatException e){}
	
		
		while (testcases>0) {
		   operations= Integer.parseInt(scan.nextLine());		
		   historysize= Integer.parseInt(scan.nextLine());
			getset.setCapacity(historysize);
		   stack<String> history = new StackArray<String>();
		  for(int i=0;i<operations;i++) {
		   	String operation = scan.nextLine();
			String[] temp = operation.split(" ");
			if (temp[0].equals("V")){
				history.VisitPage(temp[1]);				
			}
			if (temp[0].equals("R"))
				{
				   String s= history.RecentlyVisitedPage();
				   if(s==null) System.out.println("History is empty");
				   else System.out.println(s);
				}
			if (temp[0].equals("CA"))
				history.ClearAll();
			if (temp[0].equals("C"))
				history.Clear(Integer.parseInt(temp[1]));
			if (temp[0].equals("S"))
				System.out.println(history.size());
			if (temp[0].equals("L"))
				history.List();		
		  }
		  testcases --;
		}
	}

}
interface stack<E> {
	int size();
	boolean isEmpty();
	void VisitPage(E e);
	E pop();
	E RecentlyVisitedPage();
    	void ClearAll();
    	void Clear(int n);
	void List();
}

class CapacityGetterSetter {
	private static int stackcap;

	public int getCapacity() {
		return this.stackcap;
	}

	public void setCapacity(int cap) {
		stackcap = cap;
	}
}

class StackArray<E> implements stack<E> {
	// public static final int CAPACITY=20;
	CapacityGetterSetter getset = new CapacityGetterSetter();
	private E[] data; // array container
	private int t = -1; // index to top position
	// constructor
	int CAPACITY=0;

	public StackArray() {
		CAPACITY = getset.getCapacity();
		data = (E[]) new Object[CAPACITY];
	}

	public int size() {
		// TODO Auto-generated method stub
		return (t + 1);
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (t < 0);
	}

	public void VisitPage(E e) {
		// TODO Auto-generated method stub
		
		
	}

	public E RecentlyVisitedPage() {
		// TODO Auto-generated method stub
		
	}
	
	public void ClearAll() {
		
	}
	
	public void Clear(int n){
		
	}
	
	
	public E pop() {
		// TODO Auto-generated method stub
		
	}

	public void  List() {
		
	}
}
