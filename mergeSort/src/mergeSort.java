/* MergeSort.java
 * Basic Algorithms, V22.0310.001, Fall 2005, Prof.Yap
 *
 * Merge sort is a popular recursive sorting algorithm.  
 * In this program we implement merge sort to operate on integers. 
 * Another purpose of this program is to illustrate simple
 * techniques used in Java.
 *
 * You can specify as a command line argument the number of elements
 * that you wish to sort. Then an array of the specified size is 
 * populated by random numbers and finally sorted.
 *
 * If you put this file in a file called MergerSort.java,
 * then you can compile and run this program as follows:
 *
 *        % javac MergerSort.java
 *        % java MergerSort 100
 *
 * In this case you will be sorting 100 numbers. The output (the list of 
 * sorted numbers) is sent to a data file called "output" that resides in the 
 * current directory.
 */

class mergeSort 
{
    /*
     * @param  num  an array of numbers in any order
     * @return      a sorted array of the same numbers
     **/
    static int[] mergeSort(int num[]) 
    {	int size = num.length;  // size of array holding the numbers to be sorted
        if (size <= 1)  // base step 
	{   return num;
	}
	else  // recursive step
	{   int mid = size / 2;
	    int firstHalf[] = new int[mid];
	    int secondHalf[] = new int[size - mid];
	    // Copy first half of the array
	    for (int i = 0; i < mid; i++)
	    {	firstHalf[i] = num[i];
	    }
	    // Copy second half of the array
	    for (int i = mid; i < size; i++)
	    {	secondHalf[i - mid] = num[i];
	    }	     
	    return merge(mergeSort(firstHalf), mergeSort(secondHalf));
	}
    } 

    /**
     * @param  first   array of sorted numbers
     * @param  second  another second array of sorted numbers
     * @return         a sorted array containing all numbers from both first and second
     **/
    static int[] merge(int first[], int second[])
    {	
	// First, create a new array to store the answer. You
	// can say something like:
	 int res[] = new int[first.length + second.length];

	// Then traverse through the arrays and compare their
	// elements one by one and insert them in the new
	// array (res) in sorted order.
	 int i =0;
	 int j =0;
	 while(i<first.length && j <second.length){

	 	int currentElement = first[i];
	 	int otherElement = second[j];
	 	if(currentElement< otherElement){
	 		res [i+j] = currentElement;
	 		i++;
	 	}
	 	else{
	 		res[i+j] = otherElement;
	 		j++;
	 	}

	 }
	 if(i< first.length){
	 	while(i<first.length){
	 		res[i+j] = first[i]; 
	 		i++;

	 	}
	 }
	 // should'nt calculate first and second length twice?
	 if(j<second.length){
	 	while(j<second.length){
	 		res[i+j] = second[j];
	 		j++;
	 	}

	 }
	 
	 return res;
	// At last return the sorted array	
	// return res;
    }

    /**
     * @param   num    array which is to be populated with randomly-generated integers
     **/
    static void populate(int num[])
    {	for (int i = 0; i < num.length; i++)
	{   num[i] = (int) (Math.random() * 1000);  // numbers will be in the range 1-1000
	}
    }

    /**
     * @param    num    array whose elems are to be sent to output
     **/
    public static void output(int num[])
    {	java.io.PrintWriter out;
	try 
	    {   out = new java.io.PrintWriter(new java.io.FileOutputStream("output"), true);
	    for (int i = 0; i < num.length; i++)
	    {   out.println(num[i]);
	    }
	}
        catch (java.io.IOException ioe) {ioe.printStackTrace(); }
    }

    /**
     * @param    args  command-line argumants. In this case number of elems 
     *                 to be srted is expected.
     **/
    public static void main(String[] args) 
    {	int numbers[] = new int[100];
	populate(numbers);
	long start = System.currentTimeMillis();
	int res[] = mergeSort(numbers);
	long end = System.currentTimeMillis();
	//output(res);
	for(int i=0; i< res.length;i++){
		System.out.println(res[i]);
	}
	System.out.println((end - start) + " ms");
    } 	
} // end class MergeSort













