import java.util.*;

/** Linked list queue for notes
 * @author shinshaw
 *
 */
public class NotesLink {
	private LinkedList<String> noteList;
	//private Date noteDate;
	
	public NotesLink() {
		noteList = new LinkedList<String>();
	}
	
	/** Prints all notes in list
	 * 
	 */
	public void displayNotes() {
		for(int n=0; n<noteList.size(); n++) {
			System.out.println(noteList.get(n));
		}
	}
	
	/**
	 * @return list size
	 */
	public int listSize() {
		return noteList.size();
	}
	
	/**
	 * @param index
	 * @return note at specified index
	 */
	public String displayNoteAt(int index) {
		return noteList.get(index);
	}

	/** Adds note to end of list
	 * @param note
	 */
	public void addNote(String note) {
		noteList.add(note);
	}
	
	/** Removes previous note and adds in new note
	 * @param index
	 * @param newNote
	 */
	public void updateNote(int index, String newNote) {
		noteList.remove(index);
		noteList.add(index, newNote);
	}
	
	/** Removes and returns note at index
	 * @param index
	 * @return note
	 */
	public String deleteNoteAt(int index) {
		return noteList.remove(index);
	}
	
	/** Removes and returns first note
	 * @return note
	 */
	public String deleteFirstNote() {
		return noteList.removeFirst();
	}
	
	/** Removes and returns last note
	 * @return note
	 */
	public String deleteLastNote() {
		return noteList.removeLast();
	}
}
