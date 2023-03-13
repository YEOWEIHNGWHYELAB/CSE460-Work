package ProducerBuyer;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the class that processes input commands and collects and returns output notifications. 
 */
public class ProducerBuyer {
	public Buyer buyer;
	public Producer producer;

	/**
	 * Constructor which will be called by the test cases to create the instance of this class.
	 */
	public ProducerBuyer() {
		this.buyer = new Buyer();
		this.producer = new Producer();
	}

	/**
	 * This method parses the input. Based on the input command, it will call the appropriate publisher or subscriber.
	 */
	public void processInput(String command) {
		String[] commandParam = command.split(",");

		for (int i = 0; i < commandParam.length; i++) {
			commandParam[i] = commandParam[i].trim();
		}

		if (commandParam[0].equals("subscribe")) {
			// subscribe, Avis, car
			if (commandParam.length != 3) {
				return;
			}

			buyer.subscribe(commandParam[1], commandParam[2]);
		} else if (commandParam[0].equals("unsubscribe")) {
			// unsubscribe, Avis, car
			if (commandParam.length != 3) {
				return;
			}

			buyer.unsubscribe(commandParam[1], commandParam[2]);
		} else {
			// publish, Honda, car, civic, hybrid
			if (commandParam.length != 5) {
				return;
			}

			producer.publish(commandParam[1], commandParam[2], commandParam[3], commandParam[4]);
		}
	}

	/**
	 * This method is responsible for returning the consolidated notifications when the getAggregatedOutput( ) is called.
	 */
	public List<String> getAggregatedOutput() {
		return buyer.print_notification(producer);
	}

	/**
	 * This method is responsible for removing all the stored published and subscribed events when the getAggregatedOutput( ) method is called.
	 */
	public void reset() {
		producer.reset();
		buyer.reset();
	}

}
