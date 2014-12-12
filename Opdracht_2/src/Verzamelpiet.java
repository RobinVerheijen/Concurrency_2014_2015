import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Verzamelpiet extends Piet{
	
	private ArrayList<String> wishlists;
	
	private Semaphore gatherSemaphore;
		
	public Verzamelpiet(String color) {
		super(color);
	}
	
	public void run(){
			
		try {
			gatherSemaphore.acquire();
			
			gatherWishlists();
			
			Werkplek.gatheringConsultationInvitation.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void gatherWishlists() {
		
		System.out.println("Started gathering some wishlists");
		
		try {
			Thread.sleep((int)(Math.random() * 1000));
		} catch (InterruptedException e) {}	
		
		gatherSemaphore.release();
	}
	
	public ArrayList<String> getWishlists() {
		
		return wishlists;
	}
	
	public void goToSint() {
		
	}
	
	public void setGatherWishlistsSemaphore(Semaphore theSemaphore) {
		
		this.gatherSemaphore = theSemaphore;
	}	
}
