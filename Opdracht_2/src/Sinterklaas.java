/**
 * Class 
 * @author Robin Verheijen <301782@student.saxion.nl>
 *
 */
public class Sinterklaas extends Thread {
	
	
	private int amountOfWaitingGatheringPietsForGatheringConsultation = 0;
	private int amountOfWaitingWorkingPietsForGatheringConsultation = 0;
	
	public boolean inMeeting = false;
	
	// Constructor
	public Sinterklaas() {}
	
	public void run(){
		
		while(true) {
			
			if(inMeeting == false) {
				
				try {
					
					Werkplek.sintWachtOpPiet.acquire();
					
					System.out.println("Aantal zwarte pieten: " + Werkplek.aantalZwarteWerkpietenBeschikbaarVoorOverleg + " werkpieten: " + Werkplek.aantalWerkpietenBeschikbaarVoorOverleg + " verzamelpieten: " + Werkplek.aantalVerzamelpietenBeschikbaarVoorOverleg);
					
					if(Werkplek.aantalZwarteWerkpietenBeschikbaarVoorOverleg >= 1 && Werkplek.aantalVerzamelpietenBeschikbaarVoorOverleg >= 3) {
						
						System.out.println("Start verzameloverleg");
						Werkplek.overleg.release();
						
						inMeeting = true;
						
						try {
							
							Thread.sleep((int)(Math.random() * 10000));
						} catch (InterruptedException e) {
							
							e.printStackTrace();
						}
						
						Werkplek.aantalZwarteWerkpietenBeschikbaarVoorOverleg = 0;
						Werkplek.aantalWerkpietenBeschikbaarVoorOverleg = 0;
						Werkplek.aantalVerzamelpietenBeschikbaarVoorOverleg = 0;
						System.out.println("Verzameloverleg afgerond");
						
						inMeeting = false;
						
						Werkplek.verzamelOverleg.release();
					} else if(Werkplek.aantalWerkpietenBeschikbaarVoorOverleg >= 3) {
						
						System.out.println("Start werkoverleg");
						Werkplek.overleg.release();
						
						inMeeting = true;
						
						try {
							
							Thread.sleep((int)(Math.random() * 10000));
						} catch (InterruptedException e) {
							
							e.printStackTrace();
						}
						
						Werkplek.aantalZwarteWerkpietenBeschikbaarVoorOverleg = 0;
						Werkplek.aantalWerkpietenBeschikbaarVoorOverleg = 0;
						Werkplek.aantalVerzamelpietenBeschikbaarVoorOverleg = 0;
						
						System.out.println("Werkoverleg afgerond");
						
						inMeeting = false;
						
						Werkplek.werkOverleg.release();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public String getOverlegType() {
		
//		System.out.println("Aantal zwarte pieten: " + Werkplek.aantalZwarteWerkpietenBeschikbaarVoorOverleg + " werkpieten: " + Werkplek.aantalWerkpietenBeschikbaarVoorOverleg + " verzamelpieten: " + Werkplek.aantalVerzamelpietenBeschikbaarVoorOverleg);

		if(Werkplek.aantalZwarteWerkpietenBeschikbaarVoorOverleg >= 1 && Werkplek.aantalVerzamelpietenBeschikbaarVoorOverleg >= 3) {
			
			return "verzameloverleg";
		} else if(Werkplek.aantalWerkpietenBeschikbaarVoorOverleg >= 3) {
						
			return "werkoverleg";
		}
		
		return null;
	}
}