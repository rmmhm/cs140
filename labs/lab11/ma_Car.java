import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Iterator;

class ma_Car implements CarFunctions {
	private final String id;
	private final int fuelEconomyInMilesPerGallon;
	private final int fuelCapacityInGallons;
	private double currentFuelInGallons;

	public ma_Car(String id, int fuelEconomyInMilesPerGallon, int fuelCapacityInGallons, double currentFuelInGallons) {
		this.id = id;
		this.fuelEconomyInMilesPerGallon = fuelEconomyInMilesPerGallon;
		this.fuelCapacityInGallons = fuelCapacityInGallons;
		this.currentFuelInGallons = currentFuelInGallons;
	}

	public String getId() {
		return id;
	}

	public int getFuelEconomyInMilesPerGallon() {
		return fuelEconomyInMilesPerGallon;
	}

	public int getFuelCapacityInGallons() {
		return fuelCapacityInGallons;
	}

	public double getCurrentFuelInGallons() {
		return currentFuelInGallons;
	}

	public void setCurrentFuelInGallons(double v) {
		currentFuelInGallons = v;
	}

	public String toString() {
		return getId() + "\t" + getFuelEconomyInMilesPerGallon() + "\t" + getFuelCapacityInGallons() + "\t" + getCurrentFuelInGallons() + "\t" + getTotalRangeInMiles() + "\t" + getRemainingRangeInMiles();
	}
}
