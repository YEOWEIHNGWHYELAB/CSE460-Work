package ProducerBuyer;

import java.util.ArrayList;
import java.util.List;

public class Producer implements IPublisher {
	// product category, model type, fuel type
	private ArrayList<String[]> producer_cat_models_fuel = new ArrayList<String[]>();

	public Producer() {}

	/**
	 * Clears all the car model currently present the in array list
	 */
	public void reset() {
		producer_cat_models_fuel.clear();
	}

	/**
	 * Returns all the vehicle models of the selected vehicle categories present in the array list
	 *
	 * @param cat models' category
	 * @return	List of vehicle models to print
	 */
	public List<String> print(Boolean[] cat) {
		List<String> print_cat = new ArrayList<String>();

		for (String[] curr: producer_cat_models_fuel) {
			String fuel_type = curr[3];
			if (curr[3].equals("hybrid")) {
				fuel_type += " fuel";
			}

			if (curr[1].equals("car") && cat[0]) {
				String required_str = curr[0] + " " + curr[2] + ", " + fuel_type;
				print_cat.add(required_str);
			}

			if (curr[1].equals("truck") && cat[2]) {
				String required_str = curr[0] + " " + curr[2] + ", " + fuel_type;
				print_cat.add(required_str);
			}

			if (curr[1].equals("sport utility") && cat[1]) {
				String required_str = curr[0] + " " + curr[2] + ", " + fuel_type;
				print_cat.add(required_str);
			}
		}

		return print_cat;
	}

	/**
	 * @see IPublisher#publish(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public boolean publish(String producer, String prodCat, String modelType, String fuelType) {
		String[] new_car = {producer, prodCat.toLowerCase(), modelType, fuelType};
		producer_cat_models_fuel.add(new_car);

		return false;
	}
}
