import java.util.concurrent.atomic.AtomicInteger;

public class CASExample {

	// Normal shared counter (not thread-safe)
	private static int normalCounter = 0;

	// CAS-based counter (thread-safe)
	private static AtomicInteger casCounter = new AtomicInteger(0);

	public static void main(String[] args) throws InterruptedException {
		int threads = 5;
		int incrementsPerThread = 1000;

		Thread[] workers = new Thread[threads];

		// Create threads
		for (int i = 0; i < threads; i++) {
			workers[i] = new Thread(() -> {
				for (int j = 0; j < incrementsPerThread; j++) {
					// Normal increment (race condition!)
					normalCounter++;

					// CAS increment
					while (true) {
						int oldValue = casCounter.get();      // read
						int newValue = oldValue + 1;          // compute
						// try to swap old with new atomically
						if (casCounter.compareAndSet(oldValue, newValue)) {
							break; // success, exit loop
						}
						// else retry (some other thread updated it)
					}
				}
			});
		}

		// Start threads
		for (Thread t : workers) t.start();
		for (Thread t : workers) t.join();

		// Results
		System.out.println("Normal counter (expected " + (threads * incrementsPerThread) + "): " + normalCounter);
		System.out.println("CAS counter    (expected " + (threads * incrementsPerThread) + "): " + casCounter.get());
	}
}
