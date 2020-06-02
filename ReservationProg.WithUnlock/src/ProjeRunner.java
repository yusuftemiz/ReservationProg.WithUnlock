
public class ProjeRunner {

	public static void main(String[] args) throws InterruptedException {

		Runner runnerObj = new Runner();

		Thread writer1MakeThread = new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					 
					runnerObj.writer(1, "make");
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		Thread writer1CancelThread = new Thread(new Runnable() {

			@Override
			public void run() {

				try {

					runnerObj.writer(1, "cancel");
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		Thread writer2MakeThread = new Thread(new Runnable() {

			@Override
			public void run() {

				try {

					runnerObj.writer(2, "make");
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		Thread writer2CancelThread = new Thread(new Runnable() {

			@Override
			public void run() {

				try {

					runnerObj.writer(2, "cancel");
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		Thread writer3MakeThread = new Thread(new Runnable() {

			@Override
			public void run() {

				try {

					runnerObj.writer(3, "make");
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		Thread writer3CancelThread = new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					
					runnerObj.writer(3, "cancel");
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		Thread readerThread1 = new Thread(new Runnable() {

			@Override
			public void run() {

				try {

					runnerObj.reader(1);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		Thread readerThread2 = new Thread(new Runnable() {

			@Override
			public void run() {

				try {

					runnerObj.reader(2);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		Thread readerThread3 = new Thread(new Runnable() {

			@Override
			public void run() {

				try {

					runnerObj.reader(3);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		writer1MakeThread.start();
		writer2MakeThread.start();
		writer3MakeThread.start();

		writer1CancelThread.start();
		writer2CancelThread.start();
		writer3CancelThread.start();

		readerThread1.start();
		readerThread2.start();
		readerThread3.start();

		writer1MakeThread.join();
		writer2MakeThread.join();
		writer3MakeThread.join();

		writer1CancelThread.join();
		writer2CancelThread.join();
		writer3CancelThread.join();

		readerThread1.join();
		readerThread2.join();
		readerThread3.join();

	}

}

