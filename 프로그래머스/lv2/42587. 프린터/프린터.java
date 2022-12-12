import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Deque<Node> deque = new ArrayDeque<>();
        
        for (int i = 0; i < priorities.length; i++) {
            Node node = new Node(i, priorities[i]);
            deque.add(node);
        }
         while (true) {
            Node node = deque.pollFirst();

            if(deque.stream().anyMatch(node1 -> node1.priorities>node.priorities)){
                deque.addLast(node);
            }
            else{
                answer++;
                if (node.originLocation == location) break;
            }
         }
        return answer;
    }
    static class Node {

        public int originLocation;
        public int priorities;

        public Node(int originLocation, int priorities) {
            this.originLocation = originLocation;
            this.priorities = priorities;
        }

        public Node() {
        }
    }
}