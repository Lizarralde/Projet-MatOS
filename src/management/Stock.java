package management;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import objects.Material;
import objects.MaterialQuantity;

public class Stock {
	private List<Reservation>	reservList;

	public List<Reservation> getReservList() {
		return reservList;
	}

	public void setReservList(List<Reservation> reservList) {
		this.reservList = reservList;
	}

	public List<MaterialQuantity> getMaterialStock() {
		return materialStock;
	}

	public void setMaterialStock(List<MaterialQuantity> materialStock) {
		this.materialStock = materialStock;
	}

	private List<MaterialQuantity>	materialStock;

	public Stock(List<MaterialQuantity> materialStock) {
		this.reservList = new ArrayList<Reservation>();
		this.materialStock = materialStock;
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
	public boolean isAvailable(Material mat, int quantity,
			GregorianCalendar startDate, GregorianCalendar endDate) {
		GregorianCalendar day = startDate;
		int quantityAvailable;
		int i = 0;
		while (!materialStock.get(i).getMat().equals(mat)) {
			i++;
		}
		quantityAvailable = materialStock.get(i).getQuantity();
		if (quantity > quantityAvailable) {
			System.out.println("Nous ne poss�dons pas autant de "
					+ mat.getName() + ".");
			return false;
		}
		while (day.compareTo(endDate) <= 0) {
			if (!isAvailableForThisDay(mat, quantity, day, quantityAvailable)) {
				return false;
			}
			day.add(day.DATE, 1);
		}
		return true;
	}

	/**
	 * This method looks if a certain quantity of material is available for a
	 * given date
	 * 
	 * @param materialList
	 *            A list of material
	 * @param startDate
	 *            the beginning of the emprunt period
	 * @param endDate
	 *            the end of the emprunt period
	 * @return
	 */
	public boolean isAvailableForThisDay(Material mat, int quantity,
			GregorianCalendar day, int quantityAvailable) {
		for (Reservation reserv : reservList) {
			if (reserv.getMateriel().equals(mat)) {
				if (day.compareTo(reserv.getStartDate()) >= 0
						&& day.compareTo(reserv.getEndDate()) <= 0) {
					// day is in the emprunt time
					quantityAvailable -= reserv.getQuantity();
				}
			}
		}
		return (quantityAvailable >= quantity);
	}
}
