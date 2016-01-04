import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import JUNG.bin.edu.cetys.cinap.icc.test.Test;
import JUNG.edu.cetys.cinap.icc.algorithms.labelling.Level;


public class Main {
	public static List<Integer> Euler = new ArrayList<Integer>();
	public static List<Integer> NodeLevelList = new ArrayList<Integer>();
	static List<Node> Tree = new ArrayList<Node>();
	public static void main(String [ ] args)
	{
		//Level<String, String> lol = new Level<String, String>();

		List<Event> Events = new ArrayList<Event>();
		Events.add(new Event(1,6));
		Events.add(new Event(2,7));
		Events.add(new Event(3,8));
		Events.add(new Event(4,9));
		Events.add(new Event(5,10));
		
/*		int aux = 1;
		for(Event E : Events) {
			System.out.println("Event "+aux);
            System.out.println("X: "+E.weight);
            System.out.println("Y: "+E.height);
            System.out.println("");
            aux++;
            
        }*/
		/*
		List<Node> PruebaTree = new ArrayList<Node>();
		Node Na = new Node(new Event("A"));
		Node Nb = new Node(new Event("B"));
		Node Nc = new Node(new Event("C"));
		Node Nd = new Node(new Event("D"));
		Node Ne = new Node(new Event("E"));
		Node Nf = new Node(new Event("F"));
		
		Node N4 = new Node(new Event("4"));
		Node N8 = new Node(new Event("8"));
		Node N1 = new Node(new Event("1"));
		Node N9 = new Node(new Event("9"));
		Node N6 = new Node(new Event("6"));
		Node N3 = new Node(new Event("3"));
		Node N5 = new Node(new Event("5"));
		Node N10 = new Node(new Event("10"));
		Node N2 = new Node(new Event("2"));
		Node N7 = new Node(new Event("7"));
		
		Na.Descendants.add(Nb);
		Na.Descendants.add(Nc);
		Na.Descendants.add(Nd);
		Na.Descendants.add(Ne);
		Nb.Descendants.add(N4);
		Nb.Descendants.add(N8);
		Nc.Descendants.add(N1);
		Nc.Descendants.add(Nf);
		Nf.Descendants.add(N9);
		Nf.Descendants.add(N6);
		Nd.Descendants.add(N3);
		Nd.Descendants.add(N5);
		Nd.Descendants.add(N10);
		Ne.Descendants.add(N2);
		Ne.Descendants.add(N7);
		
		Nodelevel(Na, 0);
		System.out.println(NodeLevelList);
		*/
		GenerateTree(Events,null);
		int lol = 1;
		for(Node N : Tree) {
			System.out.println("Node "+lol);
			if(N.Ancestor !=null)
			System.out.println("Ancestor: "+N.Ancestor.event.weight+"-"+
					N.Ancestor.event.height);
			if(N.event.mac !=null)
				System.out.println("mac: "+N.event.mac);
            System.out.println("X: "+N.event.weight);
            System.out.println("Y: "+N.event.height);
            System.out.println("");
            lol++;
            
        }
		
	}
	
	static int PadreC = 1;
	
	//Agregar nodo padre por defecto...
	public static void GenerateTree(List<Event> events,Node root){
			
		double Xmax = MaxWeight(events);
		double Xmin = MinWeight(events);
		
		double Ymax = MaxHeight(events);
		double Ymin = MinHeight(events);
		
		double Xmean = (Xmax+Xmin)/2;
		double Ymean = (Ymax+Ymin)/2;
		
		Node pivot = new Node(new Event(Xmean, Ymean));
		pivot.event.mac = "Padre "+PadreC;
		PadreC++;
		List<List<Event>> Sets = Partition(events,pivot);
		
		if(root !=null)
		{
			root.Descendants.add(pivot);
			pivot.Ancestor = root;
		}
		
		//When the sets have just one element
		//Set 1
		if(Sets.get(0).size() == 1)
		{
			//Extraer el nodo del conjunto y agregarlo como hijo al padre actual
			//Tree.add(c);
			Tree.add(new Node(Sets.get(0).get(0)));
			pivot.Descendants.add(Tree.get(Tree.size()-1));
			Tree.get(Tree.size()-1).Ancestor = pivot;
		}
		
		//Set 2
		if(Sets.get(1).size() == 1)
		{
			//Extraer el nodo del conjunto y agregarlo como hijo al padre actual
			//Tree.add(c);
			Tree.add(new Node(Sets.get(1).get(1)));
			pivot.Descendants.add(Tree.get(Tree.size()-1));
			Tree.get(Tree.size()-1).Ancestor = pivot;
		}
		
		//Set 3
		if(Sets.get(2).size() == 1)
		{
			//Extraer el nodo del conjunto y agregarlo como hijo al padre actual
			//Tree.add(c);
			Tree.add(new Node(Sets.get(2).get(0)));
			pivot.Descendants.add(Tree.get(Tree.size()-1));
			Tree.get(Tree.size()-1).Ancestor = pivot;
		}
		
		//Set 4
		if(Sets.get(3).size() == 1)
		{
			//Extraer el nodo del conjunto y agregarlo como hijo al padre actual
			//Tree.add(c);
			Tree.add(new Node(Sets.get(3).get(0)));
			pivot.Descendants.add(Tree.get(Tree.size()-1));
			Tree.get(Tree.size()-1).Ancestor = pivot;
		}
		Tree.add(pivot);
		pivot = Tree.get(Tree.size()-1);
		//When the sets have more than one element
		//Set 1
		if(!Sets.get(0).isEmpty() && Sets.get(0).size() > 1)
		{
			GenerateTree(Sets.get(0),pivot);
		}
		
		//Set 2
		if(!Sets.get(1).isEmpty() && Sets.get(1).size() > 1)
		{
			GenerateTree(Sets.get(1),pivot);
		}
		
		//Set 3
		if(!Sets.get(2).isEmpty() && Sets.get(2).size() > 1)
		{
			GenerateTree(Sets.get(2),pivot);
		}
		
		//Set 4
		if(!Sets.get(3).isEmpty() && Sets.get(3).size() > 1)
		{
			GenerateTree(Sets.get(3),pivot);
		}
	}
	
	public void Label (List<Node> nodo)
	{
		int l = (nodo.size()*2)-1;
		
		
		for(Node n : nodo){
			
		}
	}
	public static void preorder(Node root,int index) {
	    if(root == null) return;
	    System.out.println(root);
	    
	    Euler.add(index);
	    
	    /*
	    preorder(root.getLeft());
	    preorder(root.getRight());
	    */
	    Node aux = new Node();
	    for(int i =0;i<root.Descendants.size();i++)
	    {
	    	preorder(root.Descendants.get(i),i);
	    }
	    return;
	}
	public static List<List<Event>> Partition(List<Event> events,Node p){
		
		List<List<Event>> Sets = new ArrayList<List<Event>>();
		Sets.add(new ArrayList<Event>());
		Sets.add(new ArrayList<Event>());
		Sets.add(new ArrayList<Event>());
		Sets.add(new ArrayList<Event>());
		
		//Set 1
		Point Set1a = new Point();
		Set1a.setLocation(0, 0);
		
		Point Set1b = new Point();
		Set1b.setLocation(p.event.weight, p.event.height);
		
		 for(int i =0;i<events.size();i++)
		    {
			 	if(events.get(i).weight >= Set1a.getX() && events.get(i).height >= Set1a.getY()
			 	 && events.get(i).weight < Set1b.getX() && events.get(i).height < Set1b.getY())
		    	Sets.get(0).add(events.get(i));
		    }		
		
		//Set 2
		Point Set2a = new Point();
		Set2a.setLocation(p.event.weight, 0);
		
		Point Set2b = new Point();
		Set2b.setLocation((2*p.event.weight),p.event.height);
		
		 for(int i =0;i<events.size();i++)
		    {
			 	if(events.get(i).weight >= Set2a.getX() && events.get(i).height >= Set2a.getY()
			 	 && events.get(i).weight < Set2b.getX() && events.get(i).height < Set2b.getY())
		    	Sets.get(1).add(events.get(i));
		    }
		
		//Set 3
		Point Set3a = new Point();
		Set3a.setLocation(0, p.event.height);
		
		Point Set3b = new Point();
		Set3b.setLocation(0,(2*p.event.height));
		
		 for(int i =0;i<events.size();i++)
		    {
			 	if(events.get(i).weight >= Set3a.getX() && events.get(i).height >= Set3a.getY()
			 	 && events.get(i).weight < Set3b.getX() && events.get(i).height < Set3b.getY())
		    	Sets.get(2).add(events.get(i));
		    }
		
		//Set 4
		Point Set4a = new Point();
		Set4a.setLocation(p.event.weight, p.event.height);
		
		Point Set4b = new Point();
		Set4b.setLocation((2*p.event.weight),(2*p.event.height));
		
		 for(int i =0;i<events.size();i++)
		    {
			 	if(events.get(i).weight >= Set4a.getX() && events.get(i).height >= Set4a.getY()
			 	 && events.get(i).weight < Set4b.getX() && events.get(i).height < Set4b.getY())
		    	Sets.get(3).add(events.get(i));
		    }
		
		return Sets;
				
	}	
	public static double MaxHeight(List<Event> events){
		double res = Integer.MIN_VALUE;
		for(int i = 0; i< events.size(); i++){
			if(res < events.get(i).height){
				res = events.get(i).height;
			}
		}
		return res;
	}
	public static double MinHeight(List<Event> events){
		double res = Integer.MAX_VALUE;
		for(int i = 0; i< events.size(); i++){
			if(res > events.get(i).height){
				res = events.get(i).height;
			}
		}
		return res;
	}
	public static double MaxWeight(List<Event> events){
		double res = Integer.MIN_VALUE;
		for(int i = 0; i< events.size(); i++){
			if(res < events.get(i).weight){
				res = events.get(i).weight;
			}
		}
		return res;
	}
	public static double MinWeight(List<Event> events){
		double res = Integer.MAX_VALUE;
		for(int i = 0; i< events.size(); i++){
			if(res > events.get(i).weight){
				res = events.get(i).weight;
			}
		}
		return res;
	}
	public static void Nodelevel(Node root,int level) {
	    if(root == null) return;
	    //System.out.println(root);
	    
	    NodeLevelList.add(level);
	    
	    /*
	    preorder(root.getLeft());
	    preorder(root.getRight());
	    */
	    Node aux = new Node();
	    for(int i =0;i<root.Descendants.size();i++)
	    {
	    	preorder(root.Descendants.get(i),(level+1));
	    }
	    return;
	}

}
