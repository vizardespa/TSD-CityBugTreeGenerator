import java.util.ArrayList;
import java.util.List;

public class Node {
	Event event;
	int label;
	List<Node> Descendants;
	Node Ancestor;
	
	public Node(){}
	
	public Node(Event EVENT, int LABEL, List<Node>DESCENDANTS, Node ANCESTOR){
	event=EVENT;
	label=LABEL;
	Descendants=DESCENDANTS;
	Ancestor=ANCESTOR;
	}
	
	public Node(Event e){
		event = e;
		Descendants = new ArrayList<Node>();
	}

	public Node getLeft() {
		// TODO Auto-generated method stub
		return null;
	}

	public Node getRight() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

