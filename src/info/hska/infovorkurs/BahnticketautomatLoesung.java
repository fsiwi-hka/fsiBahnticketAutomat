package info.hska.infovorkurs;

public class BahnticketautomatLoesung {

	// Klassenvariablen hierhin

	public static int gesamtkosten;


	/**
	 * In dieser Methode wird ein neues Ticket der Liste aller bisher
	 * gebuchten Tickets hinzugefügt. Dazu soll an das Array oldTickets ein
	 * Element "angehängt" werden, welches den Ort (per newTicket übergeben)
	 * enthält und in Klammern hintendran " (Bahncard)", falls das Ticket mit
	 * einer Bahncard gebucht wurde.
	 *
	 * Beispiel:
	 *	oldTickets enthält die Werte {"Frankfurt","München","München (Bahncard)"}
	 *	Man aktiviert nun die Bahncard und klickt auf Frankfurt, dann
	 *	wird diese Methode aufgerufen mit newTicket = "München" und
	 *	bahncard = true. Nun soll ein Array angelegt werden (und zurück
	 *	gegeben werden, der folgende Werte enthält:
	 *	{"Frankfurt","München","München (Bahncard)","Frankfurt (Bahncard)"}
	 *
	 * @param oldTickets Das Array mit allen bisherig gebuchten Tickets.
	 * @param newTicket Die Stadt, zu der das neue Ticket gebucht werden soll.
	 * @param bahncard Gibt an, ob eine Bahncard für dieses Ticket angegeben wurde.
	 * @return Ein Array, der das neue Ticket mit beinhaltet.
	 */
	public static String[] addNewTicket(String[] oldTickets, String newTicket, boolean bahncard) {

		String[] newTickets = new String[oldTickets.length + 1];
		String addToNewTicket = "";
		
		
		for(int i = 0; i < oldTickets.length; i++) {
			newTickets[i] = oldTickets[i];
		}

		if(bahncard){
			addToNewTicket = " (Bahncard)";
		}
		
		newTickets[oldTickets.length] = newTicket + addToNewTicket;
		
		return newTickets;
	}


	/**
	 * Hier sollte der neue Gesamtpreis aller bisher ausgewählten Tickets
	 * berechnet werden. Diese Methode wird jedesmal aufgerufen, wenn man
	 * ein Ticket hinzufügt. Hier soll zunächst der Preis für das aktuelle
	 * Ticket berechnet werden und dieser danach zum Gesamtpreis aller Tickets
	 * addiert werden. Den Gesamtpreis müsst ihr euch selber speichern.
	 *
	 * Der Ticketpreis berechnet sich wie folgt:
	 * Strecken bis einschließlich 200 km: 10 EUR pauschal + 0.20 EUR pro km
	 * Strecken ab 200 km: 5 EUR pauschal + 0.15 EUR pro km
	 *
	 * Mit Bahncard gibt es noch 25% Rabatt auf das Ticket.
	 *
	 * Wenn man sich Geldbeträge speichert (und damit rechnet) empfiehlt es sich,
	 * um Rundungsfehler zu vermeiden, mit Centbeträgen zu rechnen und
	 * Centbeträge zu speichern und diese nur bei Bedarf in Eurobeträge
	 * umzurechnen.
	 *
	 * @param distance Die Streckendistanz zum Zielbahnhof in km
	 * @param bahncard Gibt an, ob eine Bahncard für dieses Ticket vorhanden ist
	 */
	public static void calculateNewSum(int distance, boolean bahncard) {

		int ticketPreis;

		if(distance <= 200) {
			ticketPreis = 1000 + 20 * distance;
		} else {
			ticketPreis = 500 + 15 * distance;
		}

		if(bahncard) {
			ticketPreis = (int)(ticketPreis * 0.75);
		} 
		
		gesamtkosten = gesamtkosten + ticketPreis;

	}


	/**
	 * Diese Methode soll den Gesamtenpreis aller bisher ausgewählten
	 * Tickets in Euro zurück geben.
	 *
	 * @return Gesamtpreis aller Tickets in Euro
	 */
	public static double getSum() {

		return gesamtkosten / 100.0;
	}


	/**
	 * Hier soll der Gesamtpreis der bisher gekauften Tickets zurück gesetzt
	 * werden.
	 */
	public static void resetSum() {

		gesamtkosten = 0;
	}


	/**
	 * Diese Methode wird aufgerufen, sobald der Bezahlvorgang begonnen wird.
	 * Falls ihr zu dem Zeitpunkt etwas machen wollt, dann hier!
	 *
	 * Lasst euch von dieser Methode nicht verwirren. Man benötigt
	 * sie nicht für jede Lösung. Macht zunächst die anderen Methoden weiter
	 * unten. Solltet ihr dann fest stellen, dass ihr etwas zu Beginn des
	 * Zahlvorgangs machen wollt, programmiert es hier hin. Ansonsten
	 * lasst diese Methode einfach leer.
	 */
	public static void beginPayment() {

	}
	

	/**
	 * Hier wird der noch zu bezahlende Betrag abgefragt.
	 *
	 * @return Noch zu bezahlender Betrag in Euro
	 */
	public static double getAmountLeft() {

		return gesamtkosten / 100.0;
	}


	/**
	 * Diese Methode wird aufgerufen, wenn der Kunde beim Bezahlen einen
	 * Geldschein einführt. Der noch zu bezahlende Betrag muss dementsprechend
	 * angepasst werden.
	 *
	 * @param amount Wert des Geldscheines in Euro
	 */
	public static void insertMoney(int amount) {

		gesamtkosten -= amount * 100;

	}


	/**
	 * Diese Methode wird benutzt zum Überprüfen, ob noch ein Restbetrag
	 * zu zahlen ist. Die Methode soll true zurück geben, falls noch Geld
	 * zu bezahlen ist.
	 *
	 * @return
	 *	True, falls noch Geld zu bezahlen ist.
	 *	False, wenn der volle Betrag eingeworfen wurde.
	 */
	public static boolean isAmountLeft() {
		boolean amountLeft = true;
		
		if(gesamtkosten <= 0){
			amountLeft = false;
		}
		
		return amountLeft;
	}


	/**
	 * Gibt den Betrag des Wechselgelds zurück. Wird aufgerufen, sobald
	 * kein Geld mehr eingeworfen werden muss. Dieser Betrag muss positiv sein.
	 * Also falls 5€ zurück gegeben werden sollen, dann soll diese Methode 5.0
	 * und nicht -5.0 zurück geben.
	 *
	 * @return Den Betrag, der als Wechselgeld zurückgegeben werden muss.
	 */
	public static double getChangeAmount() {

		return (gesamtkosten / 100.0) * (-1);
	}


	/**
	 * Hier soll das Wechselgeld berechnet werden und in einem Array zurück
	 * gegeben werden. Dabei soll die 1. Stelle des Arrays enthalten, wie viel 2€
	 * Münzen, die 2. Stelle wie viel 1€ Münzen, 3. Stelle wie viel 50 Cent Münzen,
	 * 4. Stelle wie viel 20 Cent Münzen, 5. Stelle wie viel 10 Cent Münzen,
	 * 6. Stelle wie viel 5 Cent Münzen, 7. Stelle wie viel 2 Cent Stücke und
	 * 8. Stelle wie viel 1 Cent Münzen als Wechselgeld zurück gegeben werden.
	 * Dabei sollen möglichst große Münzen zurück gegeben werden.
	 *
	 * 2,65 Euro sollten also als 1* 2€ Münze, 1* 50 Cent Münze, 1* 10 Cent Münze
	 * und 1* 5 Cent Münze und nicht als 265* 1 Cent Stück ausgegeben werden.
	 * Dies würde dann in einem Array so aussehen: {1,0,1,0,1,1,0,0}.
	 *
	 * Viel Spaß!
	 * 
	 * @return Array aus Wechselgeld, wie oben beschrieben
	 */
	public static int[] getChangeCoins() {

		gesamtkosten *= -1;
		int[] rueckgeld = new int[8];
		int[] muenzen = {200, 100, 50, 20, 10, 5, 2, 1};
		
		for(int i = 0; i < muenzen.length; i++) {
		   rueckgeld[i] = gesamtkosten / muenzen[i];
		   gesamtkosten = gesamtkosten % muenzen[i];
		}

		return rueckgeld;
	}

}
