import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Ticket object containing the properties of Ticket
 * 
 * @author shinshaw
 *
 */
public class Ticket {
	private int ticketNum;
	private Customer cust;
	private Date dateCreated;
	private String dateCreatedString;
	private Date dateClosed;
	private Date dueDate;
	private String urgency;
	private String status;
	private String issue;
	private String issueDesc;
	private String category;
	private NotesLink notes;
	private SimpleDateFormat formatLongDate = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a");
	// private SimpleDateFormat formatShortDate = new
	// SimpleDateFormat("MM-dd-yyyy");

	public Ticket() {
		this.dateCreated = new Date();
		dateCreatedString = formatLongDate.format(dateCreated);
		notes = new NotesLink();
		cust = new Customer();
	}

	public Ticket(String firstName, String lastName) {
		this.dateCreated = new Date();
		dateCreatedString = formatLongDate.format(dateCreated);
		notes = new NotesLink();
		cust = new Customer(firstName, lastName);

	}

	/**
	 * @return customer
	 */
	public Customer getCust() {
		return cust;
	}

	/**
	 * @return ticketNum
	 */
	public int getTicketNum() {
		return ticketNum;
	}

	/**
	 * @return ticketNum as String
	 */
	public String getTicketNumString() {
		return Integer.toString(ticketNum);
	}

	/**
	 * Sets ticketNum
	 * 
	 * @param ticketNum
	 */
	public void setTicketNum(int ticketNum) {
		this.ticketNum = ticketNum;
	}

	/**
	 * @return dateCreated
	 */
	public Date getDateCreated() {
		return dateCreated;
	}

	/**
	 * Sets dateCreated
	 * 
	 * @param dateCreated
	 */
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * @return dateCreated as String
	 */
	public String getDateCreatedString() {
		return dateCreatedString;
	}

	/**
	 * Sets dateCreated as String
	 * 
	 * @param dateCreatedString
	 */
	public void setDateCreatedString(String dateCreatedString) {
		this.dateCreatedString = dateCreatedString;
	}

	/**
	 * @return dateClosed
	 */
	public Date getDateClosed() {
		return dateClosed;
	}

	/**
	 * Sets dateClosed
	 * 
	 * @param dateClosed
	 */
	public void setDateClosed(Date dateClosed) {
		this.dateClosed = dateClosed;
	}

	/**
	 * @return dueDate
	 */
	public Date getDueDate() {
		return dueDate;
	}

	/**
	 * Sets dueDate
	 * 
	 * @param dueDate
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * @return urgency
	 */
	public String getUrgency() {
		return urgency;
	}

	/**
	 * Sets urgency
	 * 
	 * @param urgency
	 */
	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}

	/**
	 * @return status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets status
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return issue
	 */
	public String getIssue() {
		return issue;
	}

	/**
	 * Sets issue
	 * 
	 * @param issue
	 */
	public void setIssue(String issue) {
		this.issue = issue;
	}

	/**
	 * @return issueDescription
	 */
	public String getIssueDesc() {
		return issueDesc;
	}

	/**
	 * Sets issueDescription
	 * 
	 * @param issueDesc
	 */
	public void setIssueDesc(String issueDesc) {
		this.issueDesc = issueDesc;
	}

	/**
	 * @return category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Sets category
	 * 
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return notes list
	 */
	public NotesLink getNotes() {
		return notes;
	}

	/**
	 * @param note
	 *            the note to set
	 */
	public void addNote(String note) {
		notes.addNote(note);
	}

	@Override
	public String toString() {
		return "Ticket Number: " + ticketNum + ", " + cust;
	}

	/**
	 * Test code for NotesLink class interaction in Ticket
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Ticket t1 = new Ticket();
		t1.setTicketNum(123);
		t1.addNote("Hello note1");
		t1.addNote("well note2");
		t1.addNote("how note3");
		t1.addNote("are note4");
		t1.addNote("you note5");
		t1.getNotes().displayNotes();

		t1.getNotes().deleteNoteAt(2);
		t1.getNotes().addNote("what note6");
		t1.getNotes().displayNotes();
	}
}
