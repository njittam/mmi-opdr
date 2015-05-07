package handlers;

import java.util.ArrayList;

import wiitracker.fingertracking.Finger;
import wiitracker.fingertracking.FingerEvent;
import wiitracker.fingertracking.FingerListener;
import MMI.RectPanel;

/**
 * @author mattijn
 * @author Tijs
 * 
 */
public class FingerHandler implements FingerListener{
	private int old_fingers = 0;
	private Finger[] old_fingers_list;
	private RectPanel rp;
	
	/**
	 * @param rp
	 */
	public FingerHandler(RectPanel rp){
		this.rp = rp;
	}
	
	/* (non-Javadoc)
	 * @see wiitracker.fingertracking.FingerListener#fingerChanged(wiitracker.fingertracking.FingerEvent)
	 */
	@Override
	public void fingerChanged(FingerEvent e) {
		switch(e.getFingers().length - old_fingers){
		case -1:
			old_fingers = e.getFingers().length;
			finger_removed(e);
			break;
		case 0:
			old_fingers = e.getFingers().length;
			finger_moved(e);
			break;
		case 1:
			old_fingers = e.getFingers().length;
			finger_added(e);
			break;
		default:
			old_fingers = e.getFingers().length;
			System.out.print("te veel vingers toegevoegd of verwijderd");
			break;
		}
		old_fingers_list = e.getFingers();
	}
	
	//TODO als fingers verdwijne/verschijne kijken of dat ook bedoelt is.
	//bijv door aantal keer aanroepen te onthouden sinds verchijnen
	//TODO check of coordinaten kloppen
	//TODO moeten OFF_screen fingers gehandeld worden?
	
	/**
	 * @param old_list
	 * @param new_list
	 * @return
	 */
	public  ArrayList<Finger> diff_added(Finger[] old_list, Finger[] new_list){
		ArrayList<Finger> diff = null;
		//TODO ADD CODE
		return diff;
	}
	
	/**
	 * @param old_list
	 * @param new_list
	 * @return
	 */
	public  ArrayList<Finger> diff_removed(Finger[] old_list, Finger[] new_list){
		ArrayList<Finger>  diff = null;
		//TODO addcode 
		return diff;
	}
	
	/**
	 * @param e
	 */
	public void finger_added(FingerEvent e){
		rp.add_point(10, 10);
	}
	
	/**
	 * @param e
	 */
	public void finger_removed(FingerEvent e){
		
	}
	
	/**
	 * @param e
	 */
	public void finger_moved(FingerEvent e){
		
	}
}
