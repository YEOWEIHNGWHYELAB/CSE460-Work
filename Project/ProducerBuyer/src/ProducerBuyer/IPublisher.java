package ProducerBuyer;

public interface IPublisher {

	public abstract boolean publish(String producer, String prodCat, String modelType, String fuelType);

}
