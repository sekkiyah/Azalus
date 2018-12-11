//import java.lang.*;
import java.util.*;
import java.util.Map.Entry;
/**
 * @author shinshaw
 *
 */
public class TicketApplication extends Ticket {
	//private static Key k;
	private int ticketCount = 0;
	private Ticket t;
	static HashMap<Integer,Ticket> hmap;
	
	public TicketApplication() {
		hmap = new HashMap<Integer,Ticket>();
	}
	
	/**
	 * Creates Ticket object without parameters
	 */
	public void createTicket() {
		t = new Ticket();
		ticketCount++;
		t.setTicketNum(ticketCount);
		hmap.put(ticketCount,t);
	}
	
	/** Creates Ticket object with customer name parameters
	 * @param custFirst
	 * @param custLast
	 */
	public void createTicket(String custFirst, String custLast) {
		t = new Ticket(custFirst, custLast);
		ticketCount++;
		t.setTicketNum(ticketCount);
		hmap.put(ticketCount,t);
	}
	
	/**
	 * @return Ticket object
	 */
	public Ticket getTicket() {
		return t;
	}
	
	/**
	 * @param index
	 * @return Ticket object with given index/ticketNum
	 */
	public Ticket getTicket(int index) {
		return hmap.get(index);
	}
	
//	public Key getKey() {
//		return k;
//	}
	
	/**
	 * @return HashMap
	 */
	public HashMap<Integer,Ticket> getHmap() {
		return hmap;
	}
	
	/**
	 * Display all tickets in HashMap
	 */
	public static void displayTickets() {
		Set<Entry<Integer, Ticket>> set = hmap.entrySet();
		Iterator<Entry<Integer, Ticket>> iterator = set.iterator();
		while(iterator.hasNext()) {
			Entry<Integer, Ticket> mentry = iterator.next();
			System.out.print("Key: "+ mentry.getKey() + ", Value: ");
			System.out.println(mentry.getValue());
		}
	}
	
	
	/** Test code for class
	 * @param args
	 */
	public static void main(String[] args) {
		TicketApplication g = new TicketApplication();
		
		g.createTicket("Adam", "Smith");
		g.createTicket();
		g.createTicket("Anna", "Malone");
		g.createTicket("Oscar", "Scott");
		for(int x=0; x<5; x++) {
			g.createTicket();
		}
		displayTickets();
		System.out.println(g.getTicket().getTicketNum());
		g.getTicket(2).getCust().setFirstName("Joe");
		g.getTicket(2).getCust().setLastName("Smith");
		System.out.println(g.getTicket(2));
	}
}
