/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
import java.util.*;

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        /*
            queue q
            
            hashset visited
            q.offer node
            while q not empty:
                n=q.poll
                for nn in n.neighbors:
                    if not visited.contains nn:
                        q.offer nn
                n.neighbors.add new UndirectedGraphNode(n.label)
                visited.add n
            
            visited.clear
            q.offer node
            while q not empty:
                n=q.poll
                for nn in n.neighbors:
                    if not visited.contains nn:
                        q.offer nn
                    n.neighbors.last.neighbors.add(nn.neighbors.last)
                visited.add n
            
            r = node.neighbors.last
            
            visited.clear
            q.offer node
            while q not empty:
                n=q.poll
                for nn in n.neighbors:
                    if not visited.contains nn:
                        q.offer nn
                n.neigbors.removeLast
                visited.add n
            
            return r
        */
        ArrayDeque<UndirectedGraphNode> q = new ArrayDeque<UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        q.offer(node);
        while(!q.isEmpty()) {
            UndirectedGraphNode n = q.poll();
            for(UndirectedGraphNode nn : n.neighbors) {
                if(!visited.contains(nn)) q.offer(nn);
            }
            n.neighbors.add(new UndirectedGraphNode(n.label));
            visited.add(n);
        }
        
        visited.clear();
        q.offer(node);
        while(!q.isEmpty()) {
            UndirectedGraphNode n = q.poll();
            for(UndirectedGraphNode nn : n.neighbors) {
                if(!visited.contains(nn)) q.offer(nn);
                n.neighbors.get(n.neighbors.size()-1).neighbors.add(nn.neighbors.get(nn.neighbors.size()-1));
            }
            visited.add(n);
        }
        
        UndirectedGraphNode r = node.neighbors.get(node.neighbors.size()-1);
        
        visited.clear();
        q.offer(node);
        while(!q.isEmpty()) {
            UndirectedGraphNode n = q.poll();
            for(UndirectedGraphNode nn : n.neighbors) {
                if(!visited.contains(nn)) q.offer(nn);
            }
            n.neighbors.remove(n.neighbors.size()-1);
            visited.add(n);
        }
        
        return r;
    }
}
