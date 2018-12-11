
/** Customer object for holding information
 * @author shinshaw
 *
 */
public class Customer {
	private String firstName;
	private String lastName;
	private String phoneNum;
	private String email;
	private String addr;

	public Customer() {
		
	}
	
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the phoneNum
	 */
	public String getPhoneNum() {
		return phoneNum;
	}

	/**
	 * @param phoneNum the phoneNum to set
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return the address
	 */
	public String getAddr() {
		return addr;
	}

	/**
	 * @param addr the address to set
	 */
	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
	
}
