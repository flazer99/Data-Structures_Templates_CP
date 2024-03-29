import java.util.Scanner;

public class MailSystem {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		CapacityGetterSetter getset = new CapacityGetterSetter();
		int testcases = Integer.parseInt(scan.nextLine());
		int queuesize = Integer.parseInt(scan.nextLine());
		int usercount = Integer.parseInt(scan.nextLine());
		getset.setCapacity(queuesize);
		messagesystem ms=new messagesystem(usercount);
		for(int i=0;i<usercount;i++){
			String uname=scan.nextLine();
			ms.setUsername(i,uname);
		}
		/*Queue<Integer> Q = new QueueArray<Integer>();*/
		int inputs = Integer.parseInt(scan.nextLine());

		while (inputs > 0) {
			String operation = scan.nextLine();
			String[] temp = operation.split(" ");
			if (temp[0].equals("M")){
			    ms.postMessage(Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), temp[3]);	
			    ms.printMailbox(Integer.parseInt(temp[2]));
			}
		/*	if(temp[0].equals("PM")){
			  ms.printMailbox(Integer.parseInt(temp[1]));
			}*/
			if(temp[0].equals("LM")){
				  ms.printMsgbyUname(Integer.parseInt(temp[1]),temp[2]);
			}
			if(temp[0].equals("SM")){
				  ms.sortmsg(Integer.parseInt(temp[1]));
			}
				
		//		System.out.println(Q.size());
			/*if (temp[0].equals("I"))
				System.out.println(Q.isEmpty());
			if (temp[0].equals("E")) {
				Q.enqueue(Integer.parseInt(temp[1]));

			}
			if (temp[0].equals("PE")){
				Q.priorityenque(Integer.parseInt(temp[1]),Integer.parseInt(temp[2]));								
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
				System.out.println(Q.front());*/
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

class messagesystem{
   User userlist[];
   int usercount=0;
   messagesystem(int noofusers){
   }
  void setUsername(int index, String name){
	 
	  
  }
  void postMessage(int from,int to, String message){
  }
  void printMailbox(int index){
  }
  void printMsgbyUname(int index,String uname){
  }
  void sortmsg(int index){
  }
}

class Message {
}

class User{
	String uname;
	int id;
	Queue<Message> mailbox;
	User(){
		mailbox=new QueueArray<Message>();
	}
	void addmsg(Message msg) {
		
	}
	void printMailbox(){
		CapacityGetterSetter getset = new CapacityGetterSetter();
		int cap=getset.getCapacity();
	    for(int i=mailbox.frontpos();i!=mailbox.rearpos();i=(i+1)%cap){
			Message m=mailbox.readmsg(i);
			if(m!=null)System.out.print("("+m.from+ " "+m.to+" "+m.msg+") ");
		}
		System.out.println("");
	}
	
	void printMsgbyUname(String uname){
		
	}
	void sortmsg(){
		
	}

}

interface Queue<E> {

	int size();

	boolean isEmpty();

	void enqueue(E e);

	void priorityenque(E e, int index);
	
	E dequeue();

	E front();

	void printQueue();
	int frontpos();
	int rearpos();
	void sortbyusername();
	void sortbytime();
	E readmsg(int index);
}

class QueueArray<E> implements Queue<E> {
	CapacityGetterSetter getset = new CapacityGetterSetter();
	int CAPACITY = 0;
	private E[] data;
	private int f = 0;
	private int r = 0;
	private int sz = 0;

	public E readmsg(int index){
		return data[index];
	}
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
		if (size() == CAPACITY) {
			System.out.println("QueueFullException");
		} else {
			data[r] = e;
			r = (r + 1) % CAPACITY;
			sz++;
		}
		//printQueue();
	}
	
	
	public void priorityenque(E e, int index){
		if(sz==CAPACITY) {
			System.out.println("QueueFullException");
			return;
		}
		else {
			 printQueue();
		      return;		      
		 } 
	}
	

	public E dequeue() {
		if (isEmpty()) {
			System.out.println("QueueEmptyException");
			return null;
		}
		else {
		E temp = data[f];
		data[f] = null;
		f = (f + 1) % CAPACITY;
		sz--;
		return temp;
		}
	}

	public E front() {
		if (isEmpty()) {
			//System.out.println("QueueEmptyException");
			return null;
		} else {
			return data[f];
		}
	}

	

	public void printQueue() {
		for (int i = 0; i < CAPACITY; i++) {
			 	System.out.print(data[i]);
			 	if(i==f)
					System.out.print( "(F) ");
			if(i==r)
				System.out.print( "(R) ");
		     System.out.print( " ");
		}
		System.out.println();
	}
	
	public void sortbyusername() {
		
	}
	
	public void sortbytime() {
		
	}

}
