import java.util.Scanner;


class StackFinal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		CapacityGetterSetter getset = new CapacityGetterSetter();
		int testcases = Integer.parseInt(scan.nextLine());
		int stacksize = Integer.parseInt(scan.nextLine());
		getset.setCapacity(stacksize);
		stack1<Integer> S = new StackArray1<Integer>();
		int inputs = Integer.parseInt(scan.nextLine());

		while (inputs >0) {
			String operation = scan.nextLine();
			String[] temp = operation.split(" ");
			if (temp[0].equals("S"))
				System.out.println(S.size());
			if (temp[0].equals("I"))
				System.out.println(S.isEmpty());
			if (temp[0].equals("P")){
				S.push(Integer.parseInt(temp[1]));				
				
			}
			if (temp[0].equals("O")){
				System.out.println(S.pop());
				S.printStack();
			}
			if (temp[0].equals("T"))
				System.out.println(S.top());
			inputs--;
			if (temp[0].equals("F")){
				S.multipop(Integer.parseInt(temp[1]));
				S.printStack();
				
			}
		}

	}
}

interface stack1<E> {
	int size();

	boolean isEmpty();

	void push(E e);

	E pop();

	E top();
	
	void multipop(int k);

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

class StackArray1<E> implements stack1<E> {
	// public static final int CAPACITY=20;
	CapacityGetterSetter getset = new CapacityGetterSetter();
	private E[] data; // array container
	 // Add index to top position
	// constructor
	int CAPACITY=0;

	public StackArray1() {
		CAPACITY = getset.getCapacity();
		//initialize the data array
	}

	public int size() {
		// TODO Auto-generated method stub
		return -1;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return true;
	}

	public void push(E e) {
		// TODO Auto-generated method stub
		
	}

	public E top() {
		// TODO Auto-generated method stub
		return null;
	}

	public E pop() {
		// TODO Auto-generated method stub
		return null;

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

	public void multipop(int k) {
		// TODO Auto-generated method stub
	
	}
}

