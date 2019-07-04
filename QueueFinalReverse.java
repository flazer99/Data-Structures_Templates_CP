
import java.util.Scanner;



public class QueueFinalReverse {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		CapacityGetterSetter getset = new CapacityGetterSetter();
		int testcases = Integer.parseInt(scan.nextLine());
		int queuesize = Integer.parseInt(scan.nextLine());
		getset.setCapacity(queuesize);
		Queue<Integer> Q = new QueueArray<Integer>();
		int inputs = Integer.parseInt(scan.nextLine());

		while (inputs > 0) {
			String operation = scan.nextLine();
			String[] temp = operation.split(" ");
			if (temp[0].equals("S"))
				System.out.println(Q.size());
			if (temp[0].equals("I"))
				System.out.println(Q.isEmpty());
			if (temp[0].equals("E")) {
				Q.enqueue(Integer.parseInt(temp[1]));

			}
			if (temp[0].equals("D")){
				System.out.println(Q.dequeue());
				Q.printQueue();
				
			}
			if (temp[0].equals("F"))
				System.out.println(Q.frontpos());
			if (temp[0].equals("R"))
				System.out.println(Q.rearpos());
			if (temp[0].equals("Fr"))
				System.out.println(Q.front());
			if (temp[0].equals("REV"))
			{
				Q.revkele(Integer.parseInt(temp[1]));
				Q.printQueue();
			}
			
			inputs--;
		}
	}

}

class CapacityGetterSetter {
	private static int queuecap;

	public int getCapacity() {
		return this.queuecap;
	}

	public void setCapacity(int cap) {
		queuecap = cap;
	}
}

interface Queue<E> {

	int size();

	boolean isEmpty();

	void enqueue(E e);

	E dequeue();

	E front();

	void printQueue();
	int frontpos();
	int rearpos();
	void revkele(int k);
	
	
}
interface stack<E> {
	int size();

	boolean isEmpty();

	void push(E e);

	E pop();

	E top();

	//void printStack();
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
			System.out.println("Stack full exception");
		}
		else {
			t = t + 1;
			data[t] = e;
		}
	}

	public E top() {
		// TODO Auto-generated method stub
		if (isEmpty())
			System.out.println("Stack Empty");
		return data[t];
	}

	public E pop() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			System.out.println("Stack Empty");
			return null;
		} else {
			E temp = data[t];
			data[t] = null;
			t = t - 1;
			return temp;
		}

	}

	
}

class QueueArray<E> implements Queue<E> {
	CapacityGetterSetter getset = new CapacityGetterSetter();
	int CAPACITY = 0;
	private E[] data;
	private int f = 0;
	private int r = 0;
	private int sz = 0;

	public QueueArray() {
		CAPACITY = getset.getCapacity();
		data = (E[]) new Object[CAPACITY];
	}

	public int size() {
		return sz;

	}

	public boolean isEmpty() {
		return (size() == 0);

	}

	public int rearpos(){
		return r;
	}

	public int frontpos(){
		return f;
	}

	public void enqueue(E e) throws IllegalStateException {
		//enqueue logic here...
		printQueue();
	}

	public E dequeue() {
		//dequeue logic here...
	}

	public E front() {
		if (isEmpty()) {
			System.out.println("QueueEmptyException");
			return null;
		} else {
			return data[f];
		}
	}
	
	public void revkele(int k)
	{
		if (isEmpty() == true || k >size())
            return;
        if (k <= 0)
            return;
 
        stack<E> stack = new StackArray<E>();
 
        //your logic here...
 
         
        
	}



	public void printQueue() {
		for (int i = 0; i < CAPACITY; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}


}
