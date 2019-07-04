import java.util.Scanner;

public class RoundRobinProcessScheduling {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		CapacityGetterSetter getset = new CapacityGetterSetter();
		int testcases = Integer.parseInt(scan.nextLine());

		for(int i=0; i<testcases; i++){
			int queuesize = Integer.parseInt(scan.nextLine());
			getset.setCapacity(queuesize);
			int numberOfProcesses = Integer.parseInt(scan.nextLine());
			int CPUexecutionTime = Integer.parseInt(scan.nextLine());
			Queue<Integer> Q =new QueueArray<Integer>();
			String input = scan.nextLine(); //Collecting run times
			Q.RoundRobin(numberOfProcesses,CPUexecutionTime, input);
		}
	}
}

interface Queue<E> {
int size();
boolean isEmpty();
void enqueue(E e);
E dequeue();
E front();
void printQueue();
void RoundRobin(int count, int CPUtime, String input);
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

class QueueArray<E> implements Queue<E> {

	CapacityGetterSetter getset = new CapacityGetterSetter();

	int CAPACITY=0;
	private E[] data;
	private int f=0;
	private int r=-1;
	private int sz=0;

	public QueueArray() {
		CAPACITY = getset.getCapacity();
		data= (E[]) new Object[CAPACITY];
	}
	public int size() {
		return sz;
	}

	public boolean isEmpty() {
		return(size()==0);
	}

	public void enqueue(E e){
		if(sz==CAPACITY)
		{
			System.out.println("QueueFullException");
			return;
		}
		else{
			r=(r+1)%CAPACITY;
			data[r]=e;
			sz++;
		}
	}
	public E dequeue() {
        if(!isEmpty()){
    		E temp= data[f];
    		data[f]=null;
    		f=(f+1)%CAPACITY;
    		sz--;
    		return temp;
        }
        else{
            System.out.println("QueueEmptyException");
			return null;
        }
	}

	public E front() {
		if(isEmpty()){
			System.out.println("QueueEmptyException");
			return null;
		}
		else{
			return data[f];
		}
	}

	public void printQueue(){
		for (int i=0;i<CAPACITY;i++){
			System.out.print(data[i] + ":");
		}
		System.out.print("\n");
	}

	public void RoundRobin(int count, int CPUtime, String input){
		String[] times = input.split(" ");
		for( ; ; ){
			//Code to insert process runtimes into queue, till queue capacity
		}
		while(!isEmpty()){
			//Your logic of Round Robin Algorithm
		}
		System.out.println();	//to separate outputs of each testcase
	}
}
