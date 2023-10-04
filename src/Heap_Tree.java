public class Heap_Tree {
    public void sort(int arr[])
    {
        int n = arr.length;

        // Membuat heap (rearrange array)
        for (int i = n/2-1; i>=0; i--)
        heapify(arr,n,i);

        //satu per satu ekstrak elemen dari heap
        for (int i= n-1; i>=0; i--)
        {
            // Memindahkan current root ke akhir
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // memanggil max heapify pada heap yang dikurangi
            heapify (arr, i, 0);
        }
    }
    // untuk heapify sebuah subtree dengan root node i dimana
    // index pada arr[]. n adalah ukuran heap

    void heapify (int arr [], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2*i +1; // left = 2*1 +1
        int r = 2*i +2; // right = 2*1+2

        //Jika left child lebih besar dari root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r< n && arr[r] > arr[largest])
            largest = r;

        // jika yang terbesar bukan root
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Secara rekursif hepify mempengaruhi sub- tree
            heapify(arr, n, largest);
        }
    }

    /* Fungsi untuk mencetak array dengan ukuran n */
    static void printArray (int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    //Driver Program
    public static void main (String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        Heap_Tree ob = new Heap_Tree();
        ob.sort(arr);

        System.out.println("Sorted Array dengan Heap Tree adalah");
        printArray(arr);

    }
}
