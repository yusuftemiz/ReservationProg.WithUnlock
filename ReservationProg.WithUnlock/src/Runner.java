
public class Runner {

	private int[] array = {0, 0, 0, 0, 0 }; 			//koltuk dizisi.
	
	private int reservationName; 						//rezervasyon yapan writer ismini tutuyor.
			
	private void makeReservation(int name) {
		
		if(array[1] == 0) {								//koltuk 1 boþ ise 
			
			System.out.println("Writer" + name +" booked seat number 2 successfully.");	//rezervasyon basarili.
			
			reservationName = name;						//rezerve eden writer ismini kaydediyor.
			
			array[1]=1;									//koltuk doluyor.			
		}
		
		else if(array[1] != 0) {						//koltuk 1 dolu ise
			
			System.out.print("Writer" + name +" could not booked seat number 2 since it has been already booked."); //rezervasyon basarisiz.			
		}
		
		System.out.println("\n-------------------------------");
	}
	
	private void cancelReservation(int name) {
		
		if(array[1] == 1 && reservationName == name) {		//koltuk 1 dolu ve iptal etmek isteyen writer rezervasyonu yapan writer ise
			
			System.out.println("Writer" + name +" canceled seat number 2 successfully.");	//rezervasyon iptali basarili
			
			array[1]=0;										//koltuk bosaltiliyor.
		}
		else if(array[1] == 1 && reservationName != name) {	//koltuk 1 dolu ve iptal etmek isteyen writer rezervasyonu yapan writer degil ise
			
			System.out.print("Writer" + name +" could not canceled seat number 2 because Writer" + name + " make not reservation.");	//rezervasyon iptali basarisiz
		}
		else {
			
			System.out.print("Writer" + name +" could not canceled seat number 2 because it is not reservation.");	//rezervasyon yok
		}

		System.out.println("\n-------------------------------");
	}
	
	private synchronized void queryReservation() {
		
		for (int i = 1; i < 6; i++) {
			
			System.out.print("Seat No " + i + " : " + array[i-1] + " ");	//koltuklarin durumunu yazdir.
		}
		
		System.out.println("\n-------------------------------");
	}
	
	public void writer(int name, String doString) throws InterruptedException {
		
		if (doString.equals("make")) {						//thread make yapmak isterse
				
			System.out.println("Writer" + name +" tries to book the seat 2..\n");
				
			makeReservation(name);
		}
		else if(doString.equals("cancel")) {				//thread cancel yapmak isterse
			
			System.out.println("Writer" + name +" tries to cancel the seat 2..");
				
			cancelReservation(name);
		}
		
	}
	
	public void reader(int name) throws InterruptedException {
		
		System.out.println("Reader" + name + " looks for available seats. State of the seats are :");
		
		queryReservation();
		
	}
}
