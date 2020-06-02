import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class TestFile {
	
	public static void main(String args[]) {
		int arr[] = {10, 7, 8, 9, 1, 5}; 
        int n = arr.length; 
        
        quickSortWithLastElementAsPivot(arr, 0, n-1);
      
        for (int i = 0; i < n; i++) 
            System.out.print(arr[i] + " "); 
	}
	
	static void quickSortWithLastElementAsPivot(int[] arr, int i, int j) {
		// https://www.geeksforgeeks.org/quick-sort/
		
	}

	static void quickSortWithFirstElementAsPivot(int[] a, int l, int r) {
		
		// https://www.youtube.com/watch?v=7h1s2SojIRw
		
		if(l<r) {
			int i = l+1, j=r;
			int pivot = l;
			while(i<j) {
				while(i<r && a[i]<a[pivot]) {
					i++;
				}
				while(a[j]>a[pivot] && j>pivot) {
					j--;
				}
				if(i<j) {
					int temp = a[j];
					a[j] = a[i];
					a[i]=temp;
				}
			}
			if(a[j]<=a[pivot]) {
				int temp2 = a[j];
				a[j] = a[pivot];
				a[pivot] = temp2;
			}
			
			quickSortWithFirstElementAsPivot(a, l, j-1);
			quickSortWithFirstElementAsPivot(a, j+1, r);
		}
		
	}

	static void reverseInGroupOfKWithTwoTraversal(int[] a, int n, int k) {
		// with two traversal
		// https://www.geeksforgeeks.org/reverse-an-array-in-groups-of-given-size/
		
		for(int i=0;i<n;i+=k) {
			int left = i;
			int right = Math.min(n-1, left+k-1);
			while(left<right) {
				int temp = a[left];
				a[left++] = a[right];
				a[right--] = temp;
			}
		}
		
	}

	static void reverseInGroupOfKWithOneTraversal(int[] a, int n, int k) {
		
		// https://www.geeksforgeeks.org/reverse-an-array-in-groups-of-given-size/
		
		// with one traversal
		
		int start = 0, end = k-1, i=start, j=end;
		while(start<end) {
			if(i<j) {
				int temp = a[j];
				a[j] = a[i];
				a[i]=temp;
				i++;
				j--;
			} else {
				start+=k;
				if(end+k>n-1) {
					end = n-1;
				} else {
					end+=k;
				}
				i = start;
				j = end;
			}
		}
		
	}

	static int equilibriumPoint(int arr[], int n) 
    { 
		// left sum == right sum
		// https://www.geeksforgeeks.org/equilibrium-index-of-an-array/
		
        int sum = 0; // initialize sum of whole array 
        int leftsum = 0; // initialize leftsum 
        
        for(int i=0;i<n;i++) {
        	sum += arr[i]; // calculate the total sum
        }
        
        for(int i=0;i<n;i++) {
        	sum -= arr[i]; // converting sum to the value of right sum
        	if(leftsum ==  sum) return i;
        	leftsum += arr[i];
        }
  
        /* If no equilibrium index found, then return 0 */
        return -1; 
    } 
	
	
	 static void sortArrOf0s1s2sWithOneTraversal(int[] a, int n) {
	
		 // Dutch national flag problem - one traversal required.
		 
		 // https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
		 
		 int start = 0;
		 int end = n-1;
		 int i=0;
		 while(i<=end && start < end) {
			 if(a[i]==0) {
				 a[i] = a[start];
				 a[start] = 0;
				 start++;
				 i++;
			 } else if(a[i]==2) {
				 a[i]=a[end];
				 a[end]=2;
				 end--;
			 } else {
				 i++;
			 }
		 }
		 for(int j=0;j<n;j++) {
			 System.out.print(a[j]+" ");
		 }
		 
	}


	static void sortArrOf0s1s2s(int[] arr, int n) {
		
		 // https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
		 
		 // Two traversals required for this method.
		 
		 int i=0, count0 = 0, count1 = 0, count2 = 0;
		 while(i<n) {
			 switch (arr[i]) { 
	            case 0: 
	                count0++; 
	                break; 
	            case 1: 
	                count1++; 
	                break; 
	            case 2: 
	                count2++; 
	                break; 
	            }
			 i++;
		 }
		 
		 for(int j=0;j<count0;j++) {
			 arr[j]=0;
		 }
		 for(int j=count0;j<count0+count1;j++) {
			 arr[j]=1;
		 }
		 for(int j=count0+count1;j<count0+count1+count2;j++) {
			 arr[j]=2;
		 }
		 
		 for(int j=0;j<n;j++) {
			 System.out.print(arr[j]+" ");
		 }
	}


	static int mergeSortAndCount(int[] arr, int left, int right) {

		 // Enhanced Merge Sort
		
		 // https://www.geeksforgeeks.org/counting-inversions/
		 int count = 0 ;
		 if(left < right) {
			 int mid  = (left+right)/2;
			 count += mergeSortAndCount(arr, left, mid);
			 count += mergeSortAndCount(arr, mid+1, right);
			 count += mergeAndCount(arr, left, mid, right); 
		 }
		 return count;
	}


	static int mergeAndCount(int[] arr, int left, int mid, int right) {
		int swaps = 0;
		
		int[] leftArray = Arrays.copyOfRange(arr, left, mid + 1); 
		  
        int[] rightArray = Arrays.copyOfRange(arr, mid + 1, right + 1); 
        
        int i = 0, j = 0, k = left;
        
        while(i < leftArray.length && j < rightArray.length) {
        	if(leftArray[i] < rightArray[j]) {
        		arr[k++] = leftArray[i++];
        	} else {
        		arr[k++] = rightArray[j++];
        		swaps += (mid + 1) - (left + i );
        	}
        }
        while(i<leftArray.length) {
        	arr[k++] = leftArray[i++];
        }
        while(j<rightArray.length) {
        	arr[k++] = rightArray[j++];
        }
		
		return swaps;
	}


	static void rearrange(int[] arr, int n) {
		// https://www.geeksforgeeks.org/rearrange-array-maximum-minimum-form-set-2-o1-extra-space/
		 
		 

	}


	static void rearrangeWithTwoLoops(int[] arr, int n) {
		
		 // https://www.geeksforgeeks.org/rearrange-array-maximum-minimum-form-set-2-o1-extra-space/

		 // This is O(sq(n)) 
		 
		 for(int i=0;i<n;i+=2) {
			 int temp = arr[n-1];
			 int y = n-2;
			 while(y>=i) {
				 arr[y+1] = arr[y];
				 y--;
			 }
			 arr[i] = temp;
		 }
		
	}


	static void mergeArraysUsingHashMap(int[] arr1, int[] arr2, int n1, int n2) {
		// https://www.geeksforgeeks.org/merge-two-sorted-arrays/
		
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		for(int i=0;i<n1;i++) {
			map.put(arr1[i], true);
		}
		for(int i=0;i<n2;i++) {
			map.put(arr2[i], true);
		}
		System.out.println(map.keySet());
		
	}


	 static void mergeArrays(int[] arr1, int[] arr2, int n1, int n2, int[] arr3) {
		
		// https://www.geeksforgeeks.org/merge-two-sorted-arrays/
		
		int pointerArr1 = 0;
		int pointerArr2 = 0;
		int pointerArr3 = 0;
		
		while(pointerArr1 < n1 && pointerArr2 < n2) {
			if(arr1[pointerArr1]<arr2[pointerArr2]) {
				arr3[pointerArr3] = arr1[pointerArr1];
				pointerArr1++;
			} else {
				arr3[pointerArr3] = arr2[pointerArr2];
				pointerArr2++;
			}
			pointerArr3++;
		}
		while(pointerArr1<n1) {
			arr3[pointerArr3] = arr1[pointerArr1];
			pointerArr1++;
			pointerArr3++;
		}
		while(pointerArr2<n2) {
			arr3[pointerArr3] = arr2[pointerArr2];
			pointerArr2++;
			pointerArr3++;
		}
		
	}


	 static void getMissingNo(int[] a) {
		
		// https://www.geeksforgeeks.org/find-the-missing-number/
		// Using XOR
		
		int xorOfAllNElements = 1;
		for(int i=2;i<=a.length+1;i++) {
			// Loop till n+1 as set will be of n+1 elements but array is of n elements.
			xorOfAllNElements^=i;
		}
		int xorOfAllElementsOfArray = a[0];
		for(int i=1;i<a.length;i++) {
			xorOfAllElementsOfArray^=a[i];
		}
		System.out.println(xorOfAllElementsOfArray ^ xorOfAllNElements);
	}


	 static void maxSumSubArrayKadaneAlgorithm(int[] a, int arr_size) {
		
		int curr_sum = a[0];
		int max_sum = a[0];
		for(int i=1;i<arr_size;i++) {
			
			curr_sum = Math.max(curr_sum+a[i], a[i]);
			
			if(max_sum < curr_sum) {
				max_sum = curr_sum;
			}
		}
		System.out.println(max_sum);
		
	}


	 static void find3NumbersUsingHashing(int[] a, int arr_size, int sum) {
		
		HashSet<Integer> set =  new HashSet<Integer>();
		for(int i=0;i<arr_size;i++) {
			set.add(a[i]);
		}
		for(int i=0;i<arr_size;i++) {
			int curr_sum = sum - a[i];
			for(int j=i+1;j<arr_size;j++) {
				if(set.contains(curr_sum-a[j]) && curr_sum-a[j] != a[i] && a[j]!=a[i] && curr_sum-a[j] != a[j]) {
					System.out.println(a[i]+" "+a[j]+" "+(curr_sum-a[j]));
					break;
				}
			}
		}
	}


	 static void find3Numbers(int[] a, int arr_size, int sum) {
		
		// https://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
    	
    	Arrays.sort(a);
    
    	for(int i=arr_size-1;i>=0;i--) {
    		int anchorElement = a[i];
    		int low = 0;
    		int high = i-1;
    		while(low<high) {
    			if(a[high]+a[low]+anchorElement==sum) {
    				System.out.println(a[high]+" "+a[low]+" "+anchorElement);
    				break;
    			} else if(a[high]+a[low]+anchorElement<sum) {
    				low++;
    			} else if(a[high]+a[low]+anchorElement>sum) {
    				high--;
    			}
    		}
    	}

		
	}
	
     static void countAllTheTriplets(int[] a, int arr_size) {
		
    	// https://www.geeksforgeeks.org/find-triplet-sum-two-equals-third-element/
    	
    	Arrays.sort(a);
    	int count = 0;
    	for(int i=arr_size-1;i>=0;i--) {
    		int sum = a[i];
    		int low = 0;
    		int high = i-1;
    		while(low<high) {
    			if(a[high]+a[low]==sum) {
    				System.out.println(sum);
    				count++;
    				break;
    			} else if(a[high]+a[low]<sum) {
    				low++;
    			} else if(a[high]+a[low]>sum) {
    				high--;
    			}
    		}
    	}
    	if(count == 0) {
    		System.out.println(-1);
    	} else {
    		System.out.println(count);
    	}
		
	}


	 static void findSubarrayWithGivenSumHavingNegativeNumbers(int[] arr, int n, int sum) {
		
    	// Five greatest negative element.
    	int minEle = Integer.MAX_VALUE;
    	for(int i=0;i<n;i++) {
    		if(arr[i]<minEle) {
    			minEle = arr[i];
    		}
    	}
    	minEle = Math.abs(minEle);
    	
    	int curr_sum = arr[0]+minEle;
//    	int curr_sum = arr[0] + Math.abs(minEle); 
//    	int targetSum = sum;
    	int anchor = 0;
    	for (int i=1;i<n;i++) {
    		

//    		sum = targetSum + minEle*(i-anchor);
    		while(curr_sum - (  minEle*(i-anchor))> sum && anchor<i-1) {
    			curr_sum-=(arr[anchor]+minEle);
    			anchor++;
//    			sum = targetSum + minEle*(i-anchor);
    		}
    		if(curr_sum - (  minEle*(i-anchor))== sum) {
    			System.out.println(anchor+" "+(i-1));
    			break;
    		}	
    		if(i<n) {
        		curr_sum = curr_sum + arr[i] + minEle;
    		}
    		}
    	// 10, -12, -2, -2, -20, 10
    	// 30, 8, 18, 18, 0, 30
    	}
		


	static void findSubarrayWithGivenSum(int[] arr,int size, int sum) {
		
    	int i;
    	int anchor = 0;
    	int curr_sum = 0;
    	
        // Add elements one by one to curr_sum  
        // and if the curr_sum exceeds the  
        // updated sum, then remove starting element 
    	for(i=0;i<size;i++) {
    		curr_sum+=arr[i];
    		if(curr_sum == sum) {
    			System.out.println(anchor+" "+(i));
    			break;
    		} else if(curr_sum>sum) {
    			curr_sum -=arr[anchor];
    			anchor++;
    		}

    		
    	}
		
	}

    

	static int[] rotLeft(int[] a, int d) {
    	int[] tempArray = new int[d];
    	for(int i=0;i<a.length;i++) {
    		if(i<d) {
    			tempArray[i] = a[i];
    		} else {
    			a[i-d] = a[i];
    		}
    	}
    	for(int i=0;i<tempArray.length;i++) {
    		a[a.length-i-1] = tempArray[d-i-1];
    	}
    	for(int num : a) {
    		System.out.print(num);
    	}
		return a;


    }

    static Long arrayManipulation(int n, int[][] queries) {
    	
//    	int queries[][] = {{1,2,100}, {3,4,100}, {2,5,100}};
//		arrayManipulation(5, queries);
    	
    	Long max = (long) 0;
    	Long arr[] = new Long[n]; Arrays.fill(arr, (long) 0);
    	
		/*
		 * for (int i=0;i<queries.length;i++) { for(int index = queries[i][0]-1; index
		 * <queries[i][1];index++) { arr[index]+=queries[i][2]; } }
		 * 
		 * for(int i=0;i<n;i++) { if(arr[i]>max) { max = arr[i]; } }
		 */    	
    	
    	for(int i=0;i<queries.length;i++) {
    		arr[queries[i][0]-1]+=queries[i][2];
    		if(queries[i][1] <= n-1) {
        		arr[queries[i][1]]-=queries[i][2];
    		}
    	}
//    	for(Long num : arr) {
//    		System.out.println(num);
//    	}
    	Long x=(long) 0;
    	for(Long num : arr) {
    		x+=num;
    		if(max<x) {
    			max = x;
    		}
    	}
    	
    	
//    	System.out.println(max);
    	
    	return max;

    }

}

