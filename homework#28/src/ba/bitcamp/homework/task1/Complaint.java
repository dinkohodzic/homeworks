package ba.bitcamp.homework.task1;

import java.util.Calendar;
/**
 * Class representing complaint.
 * @author Dinko Hodzic
 *
 */
public class Complaint {

	private Integer id;
	private String message;
	private Calendar timeOfComlaint;
	
	/**
	 * @param message 
	 * @param timeOfComlaint
	 */
	public Complaint(String message, Calendar timeOfComlaint) {
		super();
		this.message = message;
		this.timeOfComlaint = timeOfComlaint;
	}

	/**
	 * @param id
	 * @param message
	 * @param timeOfComlaint
	 */
	public Complaint(Integer id, String message, Calendar timeOfComlaint) {
		super();
		this.id = id;
		this.message = message;
		this.timeOfComlaint = timeOfComlaint;
	}



	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * @return the time of the complaint
	 */
	public String getTime() {
		return timeOfComlaint.get(Calendar.HOUR_OF_DAY) + "-" + timeOfComlaint.get(Calendar.MINUTE);
	}

	/**
	 * @return the date of the complaint
	 */
	public String getDate() {
		return timeOfComlaint.get(Calendar.YEAR) + "-" + timeOfComlaint.get(Calendar.MONTH) + "-" + timeOfComlaint.get(Calendar.DAY_OF_MONTH);
	}
	
}
