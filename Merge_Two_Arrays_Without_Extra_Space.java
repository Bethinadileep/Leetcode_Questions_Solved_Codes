
//Brutforce Approach
public void merge(int arr1[], int arr2[], int n, int m) {
        // code here
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr1[i] > arr2[j]) {
                    int temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
                for(int k = 1; k < m; k++) {
                    if(arr2[k] < arr2[k-1]) {
                        int temp1 = arr2[k];
                        arr2[k] = arr2[k-1];
                        arr2[k-1] = temp1;
                    }
                }
            }
        }
//Insertion sort
class Solution {

    public void merge(int arr1[], int arr2[], int n, int m) {
        // code here
        for(int i = 0; i < n; i++) {
            if(arr1[i] > arr2[0]) {
                int temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;
                
                int first = arr2[0];
                int k;
                for(k = 1; k < m && arr2[k] < first; k++) {
                    arr2[k-1] = arr2[k]; 
                }
                arr2[k-1] = first;
            }
        }
        
    }
}

//Gap Algorithm
// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int arr1[] = new int[n];
            int arr2[] = new int[m];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr1[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                arr2[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().merge(arr1, arr2, n, m);

            StringBuffer str = new StringBuffer();
            for (int i = 0; i < n; i++) {
                str.append(arr1[i] + " ");
            }
            for (int i = 0; i < m; i++) {
                str.append(arr2[i] + " ");
            }
            System.out.println(str);
        }
    }
}// } Driver Code Ends


class Solution {
    public static int nextGap(int gap) 
    {
        if (gap <= 1)
            return 0;
        return (gap / 2) + (gap % 2);        
    }

    public void merge(int arr1[], int arr2[], int n, int m) {
        // code here
        int i, j, gap = n + m;
        for(gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {
            //comparing the elements in the first array
            for (i = 0; i + gap < n; i++) 
                if (arr1[i] > arr1[i + gap])
                {
                    int temp = arr1[i];
                    arr1[i] = arr1[i + gap];
                    arr1[i + gap] = temp;
                }
                
                //comparing elements in  both arrays
                for(j = gap > n ? gap - n : 0; i < n && j < m; i++, j++) 
                    if (arr1[i] > arr2[j]) 
                    {
                        int temp = arr1[i];
                        arr1[i] = arr2[j];
                        arr2[j] = temp;
                    }
                if (j < m)
                {
                    //comparing elements in the second array
                    for (j = 0; j + gap < m; j++) 
                        if (arr2[j] > arr2[j + gap])
                        {
                            int temp = arr2[j];
                            arr2[j] = arr2[j + gap];
                            arr2[j + gap] = temp;
                        }
                    
                    
                }
        }
        
    }
}
