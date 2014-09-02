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
                n.neighbors.add new UndirectedGraphNode(n.label)
                visited.add n
                for nn in n.neighbors not including the last one:
                    if not visited.contains nn:
                        q.offer nn
            
            visited.clear
            q.offer node
            while q not empty:
                n=q.poll
                visited.add n
                for nn in n.neighbors not including the last one:
                    if not visited.contains nn:
                        q.offer nn
                    n.neighbors.last.neighbors.add(nn.neighbors.last)
            
            r = node.neighbors.last
            
            visited.clear
            q.offer node
            while q not empty:
                n=q.poll
                n.neigbors.removeLast
                visited.add n
                for nn in n.neighbors:
                    if not visited.contains nn:
                        q.offer nn
            
            return r
        */
        if(node==null) return null;
        ArrayDeque<UndirectedGraphNode> q = new ArrayDeque<UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        q.offer(node);
        while(!q.isEmpty()) {
            UndirectedGraphNode n = q.poll();
            UndirectedGraphNode newn = new UndirectedGraphNode(n.label);
            n.neighbors.add(newn);
            visited.add(n);
            for(UndirectedGraphNode nn : n.neighbors) {
                if(nn != newn && !visited.contains(nn)) q.offer(nn);
            }
        }
        
        visited.clear();
        q.offer(node);
        while(!q.isEmpty()) {
            UndirectedGraphNode n = q.poll();
            visited.add(n);
            UndirectedGraphNode newn = n.neighbors.get(n.neighbors.size()-1);
            for(UndirectedGraphNode nn : n.neighbors) {
                if(nn != newn) {
                    if(!visited.contains(nn)) q.offer(nn);
                    newn.neighbors.add(nn.neighbors.get(nn.neighbors.size()-1));
                }
            }
        }
        
        UndirectedGraphNode r = node.neighbors.get(node.neighbors.size()-1);
        
        visited.clear();
        q.offer(node);
        while(!q.isEmpty()) {
            UndirectedGraphNode n = q.poll();
            n.neighbors.remove(n.neighbors.size()-1);
            visited.add(n);
            for(UndirectedGraphNode nn : n.neighbors) {
                if(!visited.contains(nn)) q.offer(nn);
            }
        }
        
        return r;
    }
}
