
public class Werkpiet extends Piet {
		
	public Werkpiet() {
		super();
	}
	
	public void run(){
		
		while(true) {
			
			try {
				buyPresents();

				Werkplek.meldVoorOverleg(this);
								
				if(Werkplek.sinterklaas.inMeeting == false) {
										
					if(Werkplek.sinterklaas.getOverlegType().equals("werkoverleg")) {
						
						Werkplek.werkOverleg.acquire();
					} else if(Werkplek.sinterklaas.getOverlegType().equals("verzameloverleg")) {
						
						Werkplek.verzamelOverleg.acquire();
					}
				}
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public void buyPresents() {
		
		try {
			
			Thread.sleep((int)(Math.random() * 10000));
		} catch (InterruptedException e) {}		
	}
}