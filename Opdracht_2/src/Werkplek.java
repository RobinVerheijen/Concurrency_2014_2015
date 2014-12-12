import java.util.concurrent.Semaphore;

public class Werkplek {
	
	private static final int AMOUNT_OF_VERZAMELPIETEN = 20;
	private static final int AMOUNT_OF_WERKPIETEN = 40;
	
	private Verzamelpiet[] verzamelPieten;
	private Werkpiet[] werkPieten;
	
	private static boolean isInstantiated = false;
    private static Werkplek singletonObject = null;
    
	public static Semaphore 	gatherWishlists, 
								gatherPresents,
								gatheringConsultationInvitation;
	
	public static Werkplek getWerkplek() {
		
		if (isInstantiated) {
            return singletonObject;
        } else {
        	isInstantiated = true;
            singletonObject = new Werkplek();
            return singletonObject;
        }
	}
	
	private Werkplek() {
				
		verzamelPieten = new Verzamelpiet[AMOUNT_OF_VERZAMELPIETEN];
		werkPieten = new Werkpiet[AMOUNT_OF_WERKPIETEN];
		
		gatherWishlists = new Semaphore(AMOUNT_OF_VERZAMELPIETEN);
		for(int i = 0; i < verzamelPieten.length; i++) {
			
			Verzamelpiet currentPiet = new Verzamelpiet("zwart");
			currentPiet.setGatherWishlistsSemaphore(gatherWishlists);
			currentPiet.start();
		}
		
		gatheringConsultationInvitation = new Semaphore(0);
		Sinterklaas sinterklaas = new Sinterklaas();
		sinterklaas.start();
	}
}
