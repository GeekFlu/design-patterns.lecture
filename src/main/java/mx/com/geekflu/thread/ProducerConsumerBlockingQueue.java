package mx.com.geekflu.thread;

public class ProducerConsumerBlockingQueue {
	public static Integer counter = 0;
	public static void main(String[] args) throws InterruptedException {
//		BlockingQueue<Item> bq = new ArrayBlockingQueue<>(10);
		CustomBlockingQueue<Item> bq = new CustomBlockingQueue<>(10);

		//Producer
		final Runnable producer = () -> {
			while (true) {
				try {
					bq.put(createItem());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		
		//Consumer
		final Runnable consumer = () -> {
			while(true) {
				Item i;
				try {
					i = bq.take();
					process(i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		new Thread(consumer).start();
		new Thread(consumer).start();
		new Thread(consumer).start();
		new Thread(consumer).start();
		new Thread(consumer).start();
		new Thread(consumer).start();
		
		Thread.sleep(1000);
	}

	private static void process(Item i) {
		System.out.println("Item is being processed: " + i);
	}

	private static Item createItem() {
		return new Item(ProducerConsumerBlockingQueue.counter++);
	}
}
