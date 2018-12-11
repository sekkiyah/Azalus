
/** No longer used
 * @author shinshaw
 *
 */
public class Key {
	private int keyNum;
	private final int KEY_LIMIT = 999999999;
	
	public Key(){
		this.keyNum = 0;
	}
	
	/**
	 * Increments number by one
	 */
	public int generateKey() {
		if(keyNum < KEY_LIMIT) {
			keyNum++;
		} else {
			keyNum = 1;
		}
		return keyNum;
	}
	
	/**
	 * @return the keyNum
	 */
	public int getKey() {
		return keyNum;
	}
}