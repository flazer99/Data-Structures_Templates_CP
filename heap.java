
import java.util.ArrayList;
import java.util.Scanner;

public class heapfull<E> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int size=0;
		Scanner scan=new Scanner(System.in);
		int inputs = Integer.parseInt(scan.nextLine());
		IHeap<Integer> heap1 = new PriorityQueue<Integer>(); 

		while (inputs > 0) {
			String operation = scan.nextLine();
			String[] temp = operation.split(" ");
			if (temp[0].equals("I")) {
				heap1.insert(Integer.parseInt(temp[1]),Integer.parseInt(temp[2]));
				heap1.printHeap();
			}
			if (temp[0].equals("R"))
			{
				Pair<Integer> temp1 = heap1.removeMin();
				if (temp1!=null) {
					System.out.println("Min"+temp1.getKey()+":"+temp1.getValue());
					heap1.printHeap();
				}
			
			}
			if (temp[0].equals("MK")) {
				System.out.println("Min Key"+heap1.minKey());

			}
			if (temp[0].equals("MV")) {
				System.out.println("Min Value"+heap1.minValue());
			}
			inputs--;
		}

	}

}

class Pair< E> {                          
	private int key;                                            
	private E value;                                     
	                                             
	public Pair(int key1, E val1){                     
		key = key1;                                  
		value = val1;                               
	}                                              
	                                                  
	public E getValue(){                                    
		return value;                                   
	}                                        
	                                                       
	public int getKey(){                                 
		return key;                                  
	}                                                    
}     
interface IHeap<E> {
	public boolean isEmpty();
	public int size();
	public void insert(int key, E value);
	public Pair<E> removeMin();
	public int minKey();
	public E minValue();
	public void printHeap();

}
class PriorityQueue<E> implements IHeap<E>{
	
	private ArrayList<Pair<E>> heap = new ArrayList(); // arraylist in inbuilt Java list, you can use array
	 
	
	public PriorityQueue() {
			
	}
	
	protected int parent(int j){ 
		return -1; 
	}
	
	protected int left(int j) { 
		return -1; 
	} 
	
	protected int right(int j) {
		return -1; 
	} 
	
	protected boolean hasLeft(int j) { 
		false; 
	}
	
	protected boolean hasRight(int j) { 
		return false; 
	}
	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (heap.size()==0);
	}
	public int size() {
		// TODO Auto-generated method stub
		return heap.size();
	}

	public void insert(int key, E value) {
		// TODO Auto-generated method stub
		/*
		 * Add element using heap.add() function, it will add it to end of list
		 * Now do upheap
		 */
		
		
	}
	
	public Pair<E> removeMin() {
		// TODO Auto-generated method stub
		/*
		 * First replace last element with root using swap function
		 * then call downheap
		 */
		return null;
	}
	
	public int minKey() {
		// TODO Auto-generated method stub
		return -1;
	}
	
	public E minValue() {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	protected void swap(int i, int j){
		
	}
	
	//moves entry at j higher 
	protected void upheap(int j){
		
	}
	
	protected void downheap(int j){
		
		
	}
	
	public void printHeap(){
		for (int i=0;i<heap.size(); i++){
			System.out.println("Key"+heap.get(i).getKey() + "Value"+ heap.get(i).getValue());
			
		}
	}

	
}
