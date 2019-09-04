package Q4_01_Route_Between_Nodes;

import java.util.LinkedList;

public class Question {
	public enum State {
		Unvisited, Visited, Visiting;
	} 

	public static void main(String a[])
	{
		Graph g = createNewGraph();
		Node[] n = g.getNodes();
		Node start = n[3];
		Node end = n[5];
		System.out.println(search(g, start, end));
	}
	
	public static Graph createNewGraph()
	{
		Graph g = new Graph();        
		Node[] temp = new Node[6];

		temp[0] = new Node("a", 3);
		temp[1] = new Node("b", 0);
		temp[2] = new Node("c", 0);
		temp[3] = new Node("d", 1);
		temp[4] = new Node("e", 1);
		temp[5] = new Node("f", 0);

		temp[0].addAdjacent(temp[1]);
		temp[0].addAdjacent(temp[2]);
		temp[0].addAdjacent(temp[3]);
		temp[3].addAdjacent(temp[4]);
		temp[4].addAdjacent(temp[5]);
		for (int i = 0; i < 6; i++) {
			g.addNode(temp[i]);
		}
		return g;
	}
// Use Linked list to implement a queue to do BFS
// search the adjacent nodes level by level from node start
// if nodes value equals to end, return true
// else put the node to the end of the queue
// every time remove the node from the head of the linked list which is the first value of queue
// Every time fined iterating through a level, change the father node status to be visited to avoid infinite loop
    public static boolean search(Graph g,Node start,Node end) {      	
    	LinkedList<Node> queueLinkedList = new LinkedList<Node>();
    	
    	for(Node u: g.getNodes()) {
    		u.state = State.Unvisited;
    	}
    	start.state = State.Visiting;
    	queueLinkedList.add(start);
    	Node uNode;
    	while(!queueLinkedList.isEmpty()) {
    		uNode = queueLinkedList.removeFirst();
    		if (uNode != null) {
    			for(Node v: uNode.getAdjacent()) {
    				if (v.state == State.Unvisited) {
    					if (v == end) {
        					return true;
        				} else {
        					v.state = State.Visiting;
        					queueLinkedList.add(v);
        				}
    				}
    			}
    			uNode.state = State.Visited;
    		}
    	}
    	return false;
    }
}
