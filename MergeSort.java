import java.util.Scanner;

class MergeSort {
	   
   
    public int[] MSort(int[] Arr) {
        // base case
	/**
          Create two temporary arrays firstArr and secArr that is of half the
          length of the original array, and copy elements to these arrays from Arr
          You can use the System.arraycopy(src,scrPos,dest,destPost,length) function
          src is the source array; srcPos is the starting position in the source array.
    	  dest is the destination array. destPos is the starting position in the destination data.
    	  and length is the number of array elements to be copied. */
        
	
    	 /**
           Now invoke the Merge sort function recursively for firstArr and secArr  */
    	
	  
    	 /**
        Now merge the two arrays by invoking the merge function */
		
	 
    }
    
    /**
     * The merge function has the following parameters; 
     * Arr1 is the first array, Arr2 is the second array, and Arr is the final merged array
     *  We copy the least element from either Arr1 or Arr2 to Arr till all elements are
     *  merged. 
     */
    
    public void Merge(int[] Arr1, int[] Arr2, int[] Arr){
    	 
    }
	public void printArray(int[] S)
	{
		 for (int j=0;j<S.length;j++) {
	            System.out.print(S[j]+" ");
	        }
		 System.out.println("");
	}
  public static void main(String args[]) throws Exception
  {
    	MergeSort MS = new MergeSort();
     	int testcases = Integer.parseInt(scan.nextLine());
        for (int j=0;j<testcases;j++){
          	int n = Integer.parseInt(scan.nextLine());
          	int arrlist[] = new int[n];
          	for (int i=0;i<n;i++){
          	   int intelement=sc.nextInt();
          	   arrlist[i] =intelement;
          	}
          	MS.MSort(arrlist);
          	System.out.println("Final list");
          	MS.printArray(arrlist);
      	}	
  }
   
}

