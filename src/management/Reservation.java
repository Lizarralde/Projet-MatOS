package management;

import java.util.GregorianCalendar;

import objects.MaterialQuantity;
import users.User;

public class Reservation {
	private User				user;
	private MaterialQuantity	materialQuant;
	private GregorianCalendar	startDate, endDate;

	public Reservation(User user, MaterialQuantity materialQuant,
			GregorianCalendar start, GregorianCalendar end) {
		this.setUser(user);
		this.setMaterialQuantity(materialQuant);
		this.setStartDate(start);
		this.setEndDate(end);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public MaterialQuantity getMaterialQuantity() {
		return materialQuant;
	}

	public void setMaterialQuantity(MaterialQuantity materialQuant) {
		this.materialQuant = materialQuant;
	}

	public GregorianCalendar getStartDate() {
		return startDate;
	}

	public void setStartDate(GregorianCalendar startDate) {
		this.startDate = startDate;
	}

	public GregorianCalendar getEndDate() {
		return endDate;
	}

	public void setEndDate(GregorianCalendar endDate) {
		this.endDate = endDate;
	}

	public String toString() {
		String strDate1 = startDate.get(GregorianCalendar.DAY_OF_MONTH) + "/"
				+ (startDate.get(GregorianCalendar.MONTH) + 1) + "/"
				+ startDate.get(GregorianCalendar.YEAR);
		String strDate2 = endDate.get(GregorianCalendar.DAY_OF_MONTH) + "/"
				+ (endDate.get(GregorianCalendar.MONTH) + 1) + "/"
				+ endDate.get(GregorianCalendar.YEAR);
		return ("User: " + user.getForname() + " " + user.getName()
				+ "\t Object: " + materialQuant.getMat().getName()
				+ "\tQuantity: " + materialQuant.getQuantity()
				+ "\tDate d'emprunt: " + strDate1 + "\tDate de retour: "
				+ strDate2 + ".");
	}

}
