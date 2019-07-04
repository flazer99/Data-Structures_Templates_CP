import java.util.Scanner;


public class StackFinal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		CapacityGetterSetter getset = new CapacityGetterSetter();
		int testcases = Integer.parseInt(scan.nextLine());
		int stacksize = Integer.parseInt(scan.nextLine());
		getset.setCapacity(stacksize);
		stack<Integer> S = new StackArray<Integer>();
		

		while (testcases >0) {
			String operation = scan.nextLine();
			String[] temp = operation.split(" ");
			if (temp[0].equals("S"))
				System.out.println(S.size());
			if (temp[0].equals("I"))
				System.out.println(S.isEmpty());
			if (temp[0].equals("P")){
				S.VisitPage(Integer.parseInt(temp[1]));
				S.printStack();
				
			}
			if (temp[0].equals("O")){
				System.out.println(S.pop());
				S.printStack();
			}
			if (temp[0].equals("T"))
				System.out.println(S.top());
			testcases--;
		}

	}
}

interface stack<E> {
	int size();

	boolean isEmpty();

	void VisitPage(E e);

	E pop();

	E top();

	void printStack();
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

	public int size() {return t+1;
		// TODO Auto-generated method stub
	
	}

	public boolean isEmpty() {
		if(t<0)
		return true;
		else false;
		// TODO Auto-generated method stub
	
	}

	public void push(E e) {
		if(size()<CAPACITY)
		data[++t]=e;
		else System.out.println("StackExceptionFull");
		// TODO Auto-generated method stub
		
	}

	public E top() {
		return t;
		// TODO Auto-generated method stub
	
	}

	public E pop() {
		if(!isEmpty())
		{E temp=data[t];
		 data[t]=null;
		 t--;
		 return temp;
		}
		else
			System.out.println("StackExceptionEmpty");
		// TODO Auto-generated method stub
	

	}

	public void printStack() {
		if (isEmpty())
			System.out.println("Empty");
		else{
			for (int i = 0; i < CAPACITY; i++) {
				if(data[i]!=null)
					System.out.print(data[i] + " ");
			}
			System.out.println("  ");
		}
	}
}
