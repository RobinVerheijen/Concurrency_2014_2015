
public class Sinterklaas extends Thread {
	
	public boolean isUiltjeAanHetKnappen;
	
	private int amountOfWaitingGatheringPietsForGatheringConsultation = 0;
	private int amountOfWaitingWorkingPietsForGatheringConsultation = 0;
	
	private boolean inMeeting = false;
		
	public Sinterklaas() {
		
		isUiltjeAanHetKnappen = true;		
	}
	
	public void run(){
		
		while(true) {
			
			try {
				Werkplek.gatheringConsultationInvitation.acquire();
				
				if(amountOfWaitingGatheringPietsForGatheringConsultation <= 2) {
					
					amountOfWaitingGatheringPietsForGatheringConsultation += 1;
					System.out.println("Invitation accepted");
				} else {
					
					System.out.println("Invitation not accepted");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void siegeGatheringConsultation() {
		
		// attendees: Sint + 1 werkpiet + minimaal 3 verzamelpieten
		
		// if 3 verzamelpieten are available
	}
	
	public void knapUiltje() {
		
		isUiltjeAanHetKnappen = true;
	}
	
	public void unKnapUiltje() {
		
		isUiltjeAanHetKnappen = false;
	}
}