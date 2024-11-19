
public class SacayanHeap {
    private int[] heap;
    private int size;
    private int capacity;

    // Constructor to initialize the heap
    public SacayanHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    // Parent index of a node
    private int parent(int i) {
        return (i - 1) / 2;
    }

    // Left child index of a node
    private int leftChild(int i) {
        return 2 * i + 1;
    }

    // Right child index of a node
    private int rightChild(int i) {
        return 2 * i + 2;
    }

    // Swap two elements in the heap
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Insert a new element into the heap
    public void insert(int key) {
        if (size == capacity) {
            System.out.println("Heap is full");
            return;
        }

        // Insert the new key at the end
        heap[size] = key;
        size++;

        // Heapify up
        int i = size - 1;
        while (i != 0 && heap[parent(i)] > heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    // Remove and return the minimum element from the heap
    public int extractMin() {
        if (size <= 0) {
            System.out.println("Heap is empty");
            return Integer.MAX_VALUE;
        }
        if (size == 1) {
            size--;
            return heap[0];
        }

        // Store the minimum value
        int root = heap[0];

        // Replace root with the last element
        heap[0] = heap[size - 1];
        size--;

        // Heapify down
        minHeapify(0);

        return root;
    }

    // Heapify the subtree rooted at index i
    private void minHeapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int smallest = i;

        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }
        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        if (smallest != i) {
            swap(i, smallest);
            minHeapify(smallest);
        }
    }

    // Print the heap array
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SacayanHeap heap = new SacayanHeap(10);
        heap.insert(3);
        heap.insert(2);
        heap.insert(1);
        heap.insert(15);
        heap.insert(5);
        heap.insert(4);
        heap.insert(45);

        System.out.println("Min Heap:");
        heap.printHeap();

        System.out.println("Extract Min: " + heap.extractMin());
        heap.printHeap();
    }
}
