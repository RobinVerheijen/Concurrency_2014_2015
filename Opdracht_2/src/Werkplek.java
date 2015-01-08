import java.util.concurrent.Semaphore;

public class Werkplek {
	
	private static final int AMOUNT_OF_VERZAMELPIETEN = 5;
	private static final int AMOUNT_OF_WERKPIETEN = 10;
	
	private Verzamelpiet[] verzamelPieten;
	private Werkpiet[] werkPieten;
	
    private static Werkplek singletonObject = null;
    
	public static Semaphore		overleg,
								verzamelOverleg,
								werkOverleg, 
								sintWachtOpPiet;
	
	public static Sinterklaas sinterklaas;
	
	public static int aantalWerkpietenBeschikbaarVoorOverleg;
	public static int aantalZwarteWerkpietenBeschikbaarVoorOverleg;
	public static int aantalVerzamelpietenBeschikbaarVoorOverleg;
	
	public static Werkplek getWerkplek() {
		
		if(singletonObject != null) {
			
			return singletonObject;
		} else {
			
			singletonObject = new Werkplek();
            return singletonObject;
		}
	}
	
	private Werkplek() {
		
		aantalWerkpietenBeschikbaarVoorOverleg = 0;
		aantalZwarteWerkpietenBeschikbaarVoorOverleg = 0;
		aantalVerzamelpietenBeschikbaarVoorOverleg = 0;
		
		verzamelOverleg = new Semaphore(0, true);
		werkOverleg = new Semaphore(0, true);
		sintWachtOpPiet = new Semaphore(0, true);
		overleg = new Semaphore(0, true);
		
		sinterklaas = new Sinterklaas();
		sinterklaas.start();
		
		verzamelPieten = new Verzamelpiet[AMOUNT_OF_VERZAMELPIETEN];
		werkPieten = new Werkpiet[AMOUNT_OF_WERKPIETEN];
		
		for(int i = 0; i < verzamelPieten.length; i++) {
			
			Verzamelpiet currentPiet = new Verzamelpiet();
			currentPiet.start();
			verzamelPieten[i] = currentPiet;
		}
		
		for(int i = 0; i < werkPieten.length; i++) {
			
			Werkpiet currentPiet = new Werkpiet();
			currentPiet.start();
			werkPieten[i] = currentPiet;
		}
	}
	
	public static void meldVoorOverleg(Piet piet) throws InterruptedException {
		
		if(sinterklaas.inMeeting == false) {
			
			if(piet instanceof Werkpiet) {
				aantalWerkpietenBeschikbaarVoorOverleg++;
				
				if(piet.getColor().equals("zwart")) {
					aantalZwarteWerkpietenBeschikbaarVoorOverleg++;
				}
			} else if(piet instanceof Verzamelpiet) {
				
				aantalVerzamelpietenBeschikbaarVoorOverleg++;
			}
		
			sintWachtOpPiet.release();		
			
			overleg.acquire();
		}
//		System.out.println("Aantal werkpieten beschikbaar voor overleg " + aantalWerkpietenBeschikbaarVoorOverleg);
//		System.out.println("Aantal zwarte werkpieten beschikbaar voor overleg " + aantalZwarteWerkpietenBeschikbaarVoorOverleg);
//		System.out.println("Aantal verzamelpieten beschikbaar voor overleg " + aantalVerzamelpietenBeschikbaarVoorOverleg);
//		System.out.println("\n=====================================================\n");
	}
}