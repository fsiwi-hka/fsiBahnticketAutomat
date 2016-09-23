package info.hska.infovorkurs;

public class Bahnticketautomat {

	// Klassenvariablen hierhin


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
	 *	wird diese Methode aufgerufen mit newTicket = "Frankfurt" und
	 *	bahncard = true. Nun soll ein Array angelegt werden (und zurück
	 *	gegeben werden, der folgende Werte enthält:
	 *	{"Frankfurt","München","München (Bahncard)","Frankfurt (Bahncard)"}
	 *
	 * @param oldTickets Das Array mit allen bisher gebuchten Tickets.
	 * @param newTicket Die Stadt, zu der das neue Ticket gebucht werden soll.
	 * @param bahncard Gibt an, ob eine Bahncard für dieses Ticket angegeben wurde.
	 * @return Ein Array, der das neue Ticket mit beinhaltet.
	 */
	public static String[] addNewTicket(String[] oldTickets, String newTicket, boolean bahncard) {

		/*
		 * Statt null muss hier ein String-Array zurückgegeben werden.
		 * Dieses muss dafür natürlich zuerst erzeugt und befüllt werden.
		 * Stark vereinfacht sieht das Ganze so aus:
		 * String[] newTickets = new String[passendeLaenge];
		 * ... (hier wird das Array befüllt)
		 * return newTickets;
		 */

		return null;
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


	}

	/**
	 * Diese Methode soll den Gesamtenpreis aller bisher ausgewählten
	 * Tickets in Euro zurückgeben.
	 *
	 * @return Gesamtpreis aller Tickets in Euro
	 */
	public static double getSum() {

		return 0.0;

	}

	/**
	 * Hier soll der Gesamtpreis der bisher gekauften Tickets zurück gesetzt
	 * werden.
	 */
	public static void resetSum() {


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
	 * Diese Methode wird aufgerufen, wenn der Kunde beim Bezahlen einen
	 * Geldschein einführt. Der noch zu bezahlende Betrag muss dementsprechend
	 * angepasst werden.
	 *
	 * @param amount Wert des Geldscheines in Euro
	 */
	public static void insertMoney(int amount) {


	}

	/**
	 * Hier wird der noch zu bezahlende Betrag abgefragt.
	 *
	 * @return Noch zu bezahlender Betrag in Euro
	 */
	public static double getAmountLeft() {

		return 0.0;

	}

	/**
	 * Diese Methode wird benutzt, um zu überprüfen, ob noch ein Restbetrag
	 * zu zahlen ist. Die Methode soll true zurück geben, falls noch Geld
	 * zu bezahlen ist.
	 *
	 * @return
	 *	True, falls noch Geld zu bezahlen ist.
	 *	False, wenn der volle Betrag eingeworfen wurde.
	 */
	public static boolean isAmountLeft() {

		return true;

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

		return 0.0;

	}

	/**
	 * Hier soll das Wechselgeld berechnet und in einem Array zurückgegeben
	 * werden. Dabei soll die 1. Stelle des Arrays enthalten, wie viele 2€
	 * Münzen, die 2. Stelle wie viele 1€ Münzen, die 3. Stelle, wie viele 50
	 * Cent Münzen, die 4. Stelle, wie viele 20 Cent Münzen, die 5. Stelle,
	 * wie viele 10 Cent Münzen, die 6. Stelle, wie viele 5 Cent Münzen, die
	 * 7. Stelle, wie viele 2 Cent Stücke und die 8. Stelle, wie viele 1 Cent
	 * Münzen als Wechselgeld zurück gegeben werden.
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

		return null;

	}
}
