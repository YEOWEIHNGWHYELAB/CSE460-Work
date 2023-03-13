package ProducerBuyer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Buyer implements ISubscriber {
	// buyer -> car, sport utility, truck
	private HashMap<String, Boolean[]> hm = new HashMap<String, Boolean[]>();

	public Buyer() {}

	public void reset() {
		hm.clear();
	}

	/**
	 * Concatenates all the vehicle models returned by the print method from producer with the buyer's name
	 *
	 * @param pd Producer object
	 * @return List of notification
	 */
	public List<String> print_notification(Producer pd) {
		List<String> print_string = new ArrayList<String>();

		for (Map.Entry<String, Boolean[]> stringEntry : hm.entrySet()) {
			Map.Entry<String, Boolean[]> mapElement = stringEntry;

			String buyer = mapElement.getKey();
			Boolean[] subscribe = mapElement.getValue();

			List<String> buyer_notification = pd.print(subscribe);

			for (String noti : buyer_notification) {
				String required_str = buyer + " notified car: " + noti;
				print_string.add(required_str);
			}
		}

		return print_string;
	}

	/**
	 * @see ISubscriber#subscribe(java.lang.String, java.lang.String)
	 */
	public boolean subscribe(String buyer, String prodCat) {
		Boolean[] cat = new Boolean[3];

		if (!hm.containsKey(buyer)) {
			Boolean[] default_bool = new Boolean[]{false, false, false};
			hm.put(buyer, default_bool);
		}

		if (prodCat.equalsIgnoreCase("car")) {
			cat = hm.get(buyer);
			cat[0] = true;
			hm.put(buyer, cat);
		} else if (prodCat.equalsIgnoreCase("truck")) {
			cat = hm.get(buyer);
			cat[2] = true;
			hm.put(buyer, cat);
		} else {
			cat = hm.get(buyer);
			cat[1] = true;
			hm.put(buyer, cat);
		}

		return false;
	}


	/**
	 * @see ISubscriber#unsubscribe(java.lang.String, java.lang.String)
	 */
	public boolean unsubscribe(String buyer, String prodCat) {
		if (prodCat.equalsIgnoreCase("car")) {
			Boolean[] cat = hm.get(buyer);
			cat[0] = false;
			hm.put(buyer, cat);
		} else if (prodCat.equalsIgnoreCase("truck")) {
			Boolean[] cat = hm.get(buyer);
			cat[2] = false;
			hm.put(buyer, cat);
		} else {
			Boolean[] cat = hm.get(buyer);
			cat[1] = false;
			hm.put(buyer, cat);
		}

		return false;
	}
}
