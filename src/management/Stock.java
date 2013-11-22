package management;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import objects.Material;

public class Stock {
	List<Reservation>	reservList;

	public Stock() {
		this.reservList = new ArrayList<Reservation>();

	}

	/**
	 * This method looks if the materiel specified is available for a given
	 * period.
	 * 
	 * @param mat
	 *            the material that want to be reserved
	 * @param startDate
	 *            the beginning of the emprunt
	 * @param endDate
	 *            the end of the emprunt
	 * @return true if the material is available during this period false in
	 *         other cases
	 */
	public boolean isAvailable(Material mat, GregorianCalendar startDate,
			GregorianCalendar endDate) {
		for (Reservation reserv : reservList) {
			int compare = reserv.getEndDate().compareTo(startDate);
			if (compare == 0) {
				// that means that endDate is before startDate
				return false;
			} else if (compare > 0) {
				// that means that endDate is after startDate
				if (reserv.getStartDate().compareTo(endDate) < 0) {
					// here the dates are crossing each other
					return false;
				}
			}
		}
		return true;
	}
}
