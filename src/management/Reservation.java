package management;

import java.util.GregorianCalendar;

import objects.Materiel;
import users.User;

public class Reservation {
	private User		user;
	private Materiel	materiel;
	private GregorianCalendar	startDate, endDate;
	private int					quantity;

	public Reservation(User user, Materiel mat, int quantity,
			GregorianCalendar start, GregorianCalendar end) {
		this.setUser(user);
		this.setMateriel(mat);
		this.setQuantity(quantity);
		this.setStartDate(start);
		this.setEndDate(end);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Materiel getMateriel() {
		return materiel;
	}

	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
