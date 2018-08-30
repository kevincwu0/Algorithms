/*
218. The Skyline Problem
*/

class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        
        for(int[] b : buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        
        Collections.sort(height, (a,b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int prev = 0;
        for(int[] h: height) {
            if(h[1] < 0) pq.offer(-h[1]);
            else pq.remove(h[1]);
            int cur = pq.peek();
            if(prev != cur) {
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return result;
    }
}

/*
Explaination:

Gotcha's: mark the height as negative for all the left coordinates

1. Store all coordinate values in height arraylist and mark the height of each 
start/left coordinate as negative

2. Sort the height array such that it considers following conditions
  i. When the two points are not equal then sort them by coordinate values
  ii. When two coordinate values are the same, the check
    i. if both of them are start/left coordinates, consider the largest height 
    - that's why left coordinate heights are marked negative
    ii. if both of them are end/right coordinates, consider shortest height
    iii. end/right coordinates, if so, consider the shortest
    iv. if one of them is end/right and other is start/left then consider the start/left
    
3. Iterate height arraylist and store the height values in the priority queue (reverse ordered) only if coordinate is a left/start coordinate. Remove a height value if we encounter a right/end coordinate

4. Check if the maximum height changes in queue after each iteration, if so then
add current maxHeight and current coordinate to result array

Improvements: TreeMap -> Sort values by height (O(n)) vs O(log n)
*/