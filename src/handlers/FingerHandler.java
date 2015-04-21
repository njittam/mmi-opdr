package handlers;

import wiitracker.fingertracking.Finger;
import wiitracker.fingertracking.FingerEvent;
import wiitracker.fingertracking.FingerListener;
import MMI.RectPanel;

public class FingerHandler implements FingerListener{
	private int old_fingers = 0;
	private Finger[] old_fingers_list;
	private RectPanel rp;
	public FingerHandler(RectPanel rp){
		this.rp = rp;
	}
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
	public void finger_added(FingerEvent e){
		
	}
	public void finger_removed(FingerEvent e){
		
	}
	public void finger_moved(FingerEvent e){
		
	}
}
