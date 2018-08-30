/*
1. Reverse a linked list (recursion) (done)
2. Reverse a linked list (iterative) (done)
3. Reverse a string in place (done)
4. Binary Search (recursive) and Iterative (done)
5. Implement Merge Sort
6. Given a binary tree, write a method to find and return the sum of all nodes of the tree iteratively.
7. Write a function to find the total number of half nodes in a binary tree. A half node is a node which has exactly one child node. If there are no half nodes, return 0.
8. Number of Islands (BFS) & (DFS)
9. Dynamic Programming + Memoization (KnapSack? Fibbonaci?)
10. Graph Problem
*/

// 1. Iterative
public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
        ListNode nextTemp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextTemp;
    }
    return prev;
}


// 2. Recursive
public ListNode reverseList(ListNode head) {
    if(head == null || head.next == null) return head;
    ListNode node = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return node; 
}

 1->2->3->4->5->NULL
 
 
 // 3. Reverse a string in place
 
 public void(char[] arr) {
    int startIdx = begin;
    int endIdx = end;
    while(startIdx != endIdx && !(startIdx > endIdx)) {
        char temp = arr[endIdx];
        arr[endIdx] = arr[startIdx];
        arr[startIdx] = temp;
        startIdx++;
        endIdx--;
    }
 }
 
// 4. Binary Search Interative

public int binarySearch(int[] sortedArray, int key, int low, int high) {
    int index = Integer.MAX_VALUE;
    while(low <= high) {
        int mid = (low + high) / 2;
        if(sortedArray[mid] < key) {
            low = mid + 1;
        } else if(sortedArray[mid] > key) {
            high = mid - 1;
        } else if(sortedArray[mid] == key) {
            index = mid;
            break;
        }
    }
    return index;
}

// Recursive
// Arrays.binarySearch(sortedArray, key)

public int binarySearch(int[] sortedArray, int key, int low, int high) {
    int mid = (low + high) / 2;
    if(high < low) return -1;
    if(key == sortedArray[mid]) return middle;
    else if(key < sortedArray[middle]) return binarySearch(sortedArray, key, low, middle - 1);
    else return binarySearch(sortedArray, key, middle + 1, high);
}

// 5. Merge Sort

public void sort(int inputArr[]) {
    this.array = inputArr;
    this.length = inputArr.length;
    this.tempMergArr = new int[length];
    doMergeSort(0, length - 1);
}

private doMergeSort(int lowerIndex, int higherIndex) {
    if(lowerIndex < higher) {
        int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
        // Below step sorts the left side of the array
        doMergeSort(lowerIndex, middle);
        // Right side of the array
        doMergeSort(middle + 1, higherIndex);
        // Now merge both sides
        mergeParts(lowerIndex, middle, higherIndex);
    }
}

private void mergeParts(int lowerIndex, int middle, int higherIndex) {
    for(int i = lowerIndex; i <= higherIndex; i++) {
        tempMergArr[i] = array[i];
    }
    int i = lowerIndex;
    int j = middle + 1;
    int k = lowerIndex;
    while(i <= middle && j <= higherIndex) {
        if(tempMergeArr[i] <= tempMergArr[j]) {
            array[k] = tempMergArr[i];
            i++;
        } else {
            array[k] = tempMergArr[j];
            j++;
        }
        k++;
    }
    
    while(i <= middle) {
        array[k] = tempMergArr[i];
        k++;
        i++;
    }
}