/**
 * 
 */
package fish.dreaming.oj.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author tao
 *
 */
public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
		Queue<UndirectedGraphNode> toSearch = new LinkedList<UndirectedGraphNode>();
		toSearch.offer(node);
		UndirectedGraphNode root = new UndirectedGraphNode(node.label);
		map.put(new Integer(node.label), root);

		while (toSearch.size() > 0) {
			UndirectedGraphNode tmp = toSearch.poll();
			UndirectedGraphNode currNode = map.get(new Integer(tmp.label));

			if (tmp.neighbors != null) {
				for (UndirectedGraphNode neighbor : tmp.neighbors) {
					Integer label = new Integer(neighbor.label);
					UndirectedGraphNode newNode = map.get(label);
					if (newNode == null) {
						newNode = new UndirectedGraphNode(neighbor.label);
						map.put(label, newNode);
						toSearch.offer(neighbor);
					}
					currNode.neighbors.add(newNode);
				}
			}
		}

		return root;
	}

	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};

}
