import java.util.Scanner;

class ParanthesisChecking {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		CapacityGetterSetter getset = new CapacityGetterSetter();
		
		int testcases = Integer.parseInt(scan.nextLine());
		for (int j=0;j<testcases;j++){
			int stacksize = Integer.parseInt(scan.nextLine());
			getset.setCapacity(stacksize);
			int inputs = Integer.parseInt(scan.nextLine());

			while (inputs >0) {
				String pattern = scan.nextLine();
		
				System.out.println(paranthesisCheck(pattern));

				}
			}
		}
		public boolean paranthesisCheck(String input) {
		// TODO Auto-generated method stub
			stack<Character> S = new StackArray<Character>();
			return false;
		
		}
	
}

interface stack<E> {
	int size();
	boolean isEmpty();
	void push(E e);
	E pop();
	E top();
	boolean paranthesisCheck(String input);
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

	public int size() {
		// TODO Auto-generated method stub
		return (t + 1);
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (t < 0);
	}

	public void push(E e) {
		// TODO Auto-generated method stub
		if (size() == CAPACITY)
		{
			System.out.println("StackFullException");
		}
		else {
			t = t + 1;
			data[t] = e;
		}
	}

	public E top() {
		// TODO Auto-generated method stub
		if (isEmpty()){
			System.out.println("StackEmptyException");
			return null;
		}
		else {
			return data[t];
		}
	}

	public E pop() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			System.out.println("StackEmptyException");
			return null;
		} else {
			E temp = data[t];
			data[t] = null;
			t = t - 1;
			return temp;
		}

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

	public void flush(){
		for (int i = 0; i < size(); i++) {
			pop();
		}
	}
	
}
