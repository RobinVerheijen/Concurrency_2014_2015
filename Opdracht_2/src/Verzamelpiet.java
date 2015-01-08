
public class Verzamelpiet extends Piet{
				
	public Verzamelpiet() {
		super();
	}
	
	public void run(){
		
		while(true) {
			
			gatherWishlists();
			try {
				
				Werkplek.meldVoorOverleg(this);
				
				if(Werkplek.sinterklaas.inMeeting == false) {
										
					Werkplek.verzamelOverleg.acquire();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void gatherWishlists() {
				
		try {
			Thread.sleep((int)(Math.random() * 10000));
		} catch (InterruptedException e) {}			
	}
}
