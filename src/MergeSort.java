/**
 * Created by Leo on 4/16/2017.
 */
public class MergeSort {
    public MergeSort() {
    }

    int[] mergeSort(int[] s) {
        int[] s1, s2; //split into two subarrays (unsorted) as input [] for recursive mergesSort
        int[] m = new int[s.length];
        int[] m1, m2; // subarrays to do mergeSort on, output [] for recursive mergesSort

        s1 = new int[s.length/2];
        m1 = new int[s.length/2];

        if(s.length%2==1){ //odd length array
            s2 = new int[s.length/2+1];
            m2 = new int[s.length/2+1];
        }
        else {//even number array
            s2 = new int[s.length/2];
            m2 = new int[s.length/2];
        }
        for (int i = 0; i < s.length / 2; i++) {
            s1[i] = s[i];
        }
        for (int i = s.length / 2; i < s.length; i++) {
            s2[i] = s[i];
        }

        //split the array into two subarrays a1 and a2

        // now merge sort the two subarrays (m1, m2) recursively
        m1 = mergeSort(s1);
        m2 = mergeSort(s2);

        //merge sort the two already sorted subarrays
        int i=0;
        int j=0;
        int c=0;

        while(i<m1.length && j<m2.length){
            if (i==m1.length){ //m1 str empty
                if(j==m2.length){//m2 str empty already
                    return m;
                }
                else{//copy remainder of the m2 str to m.
                    m[j]=m2[j];
                    j++;
                }
            }
            else if(j==m2.length){//m2 str empty
                if(i==m1.length){//m1 str empty already
                    return m;
                }
                else{ //copy remainder of the m1 str to m.
                    m[i]=m1[i];
                    i++;
                }
            }

            //neither strs are empty yet, merge by copying the smaller char of the two heads
            if (m1[i]<=m2[j]){
                m[c]=m1[i];
                c++;
                i++;
            }
            else{
                m[c]=m2[j];
                c++;
                j++;
            }
        }

        return m;
    }

    public static void main(String [] args){
        int [] myArray = new int[] {1, 3, 5, 10, 23, 51, 91, 30, 82, 31, 20, 205, 310, 21, 72, 14, 39, 42, 8, 121, 139};
        String stringVar = java.util.Arrays.toString( myArray );
        System.out.println("mergeSorting ... : " + stringVar);
        MergeSort mergesort = new MergeSort();
        //
        stringVar = java.util.Arrays.toString( mergesort.mergeSort(myArray));
        System.out.println("Result sorted array " + (stringVar));
    }
}
