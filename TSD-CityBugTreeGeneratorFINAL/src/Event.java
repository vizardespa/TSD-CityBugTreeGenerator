import java.util.Date;

public class Event {
	int id;
	int event_type;
	double height;
	double weight;
	String mac;
	Date time = new Date();
	
	public Event(){}
	
	public Event(int ID, int EVENT_TYPE, double HEIGHT, double WEIGHT, String MAC, Date TIME){
		id=ID;
		event_type=EVENT_TYPE;
		height=HEIGHT;
		weight=WEIGHT;
		mac=MAC;
		time=TIME;
	}
	public Event( double w, double h){
		height=h;
		weight=w;
	}
	public Event(String m,double w, double h){
		mac=m;
		height=h;
		weight=w;
	}
	public Event (String m){
		mac=m;
	}
	}

