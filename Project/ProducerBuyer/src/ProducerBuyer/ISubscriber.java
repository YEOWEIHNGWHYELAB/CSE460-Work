package ProducerBuyer;

public interface ISubscriber {

	public abstract boolean subscribe(String buyer, String prodCat);

	public abstract boolean unsubscribe(String buyer, String prodCat);
}
