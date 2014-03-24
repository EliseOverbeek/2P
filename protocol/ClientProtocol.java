package protocol;

/**
 * <p>
 * Het protocol waarmee de client met de server (client handler) communiceert.
 * Bij het implementeren moet in ieder geval een invulling gegeven worden aan de
 * standaardcommando's. Als de client hierdoor niet aan een verzoek van een
 * server kan voldoen, moet de betreffende foutmelding worden doorgegeven met
 * het <tt>error</tt>-commando.
 * </p>
 * <p>
 * Elk commando wordt over de socket gestuurd als een string met daarin het
 * keyword, gevolgd door de argumenten en beëindigd met een newline character.
 * De javadocs bij de commando's leggen de syntax uit bij de <tt>syntax</tt>
 * -tag, en ook eventuele pre- en postcondities. Het keyword en de argumenten
 * worden van elkaar gescheiden door een gereserveerd karakter, opgeslagen in
 * <tt>DELIM</tt>. Bijvoorbeeld:
 * </p>
 * <p>
 * <tt>
 * "setMove" + DELIM + 9 + DELIM + 2 + DELIM + 3 + DELIM + links + '\n'
 * </tt>
 * </p>
 * <p>
 * Vanzelfsprekend mag het scheidingsteken niet in een spelernaam worden
 * opgenomen.
 * </p>
 * 
 * @author Paul Velthuis
 * @version 20140312
 */
public interface ClientProtocol {

	/**
	 * Scheidingsteken voor keywords en argumenten.
	 */
	public static final String DELIM = ClientHandlerProtocol.DELIM;

	// standaardcommando's
	/**
	 * Meldt zich aan bij de server en geeft zijn spelernaam door aan de server.
	 * Geeft ook het aantal tegenstanders mee, maximaal 3. Als 0 ingegeven
	 * wordt, wordt een random aantal tegenspelers gekozen.
	 * 
	 * @param naam
	 *            Spelernaam
	 * @param getalOndersteund Dit getal kan 0, 1, 3 of 2  zijn. 
	 *												 0 betekent at zowel de chat als de challenge functie niet ondersteund is.
	 *												 1 betekent dat de chat ondersteund is.
	 * 												 2 betekent dat de challenge ondersteund is.
	 *												 3 betekent dat zowel de chat als de challenge functie ondersteund is.
	 * @require <tt>naam != "" </tt>
	 * @require <tt>0<=getalOndersteund<4 </tt>
	 * 
	 * @syntax <code>join &lt;String:naam&gt; &lt;Int:getalOndersteund&gt;</code>
	 */
	public static final String JOIN = "join";

	/**
	 * Verzoekt de server om een zet te doen. Een zet bestaat uit het plaatsen
	 * van een steen. De client krijgt zijn eigen zet terug van de server, mits
	 * deze is goedgekeurd.
	 * Het punt 0,0 bevindt zich linksboven
	 * 
	 * @param x
	 *            integer horizontaal
	 * 
	 * @param y
	 *            integer verticaal
	 *
	 * @param vak integer van het vak
	 *			 je geeft het vak mee als een getal en 
	 *            0 1 2
	 *			  3 4 5
     *			  6 7 8 

	 * @param draaiRichting de draaiRichting is "links"(tegen de klok in) of "rechts"(met de klok mee)
	 * 
	 * @require <tt> 0<=x<9 </tt>
	 * @require <tt> 0<=y<9 </tt>
	 * @require <tt> 0<=vak<9 </tt>
	 * @require de draaiRichting is "links"(tegen de klok in) of "rechts"(met de klok mee)
	 * 
	 * @syntax <code>setMove &lt;Int:x&gt; &lt;Int:y&gt; &lt;Int:vak&gt; &lt; String:draaiRichting &gt</code>
	 */
	public static final String SET_MOVE = "setMove";

	

	// chatcommando
	/**
	 * Geeft een chatbericht door aan de server. Als deze functie gebruikt wordt dan is alles wat na de delimeter van Send_Message komt het bericht.
	 * Kort gezegd de spaties na de eerste delimeter dienen meegenomen te worden.
	 * 
	 * @param bericht
	 *            Bericht
	 *            
	 * @syntax <code>sendMessage &lt;String:bericht&gt;</code>
	 */
	public static final String SEND_MESSAGE = "sendMessage";

	// challenge-commando's


	/**
	 * Verzoekt de server om één of meerdere spelers uit te nodigen voor een
	 * potje.
	 * 
	 * @param namen
	 *            Namen van de gewenste tegenstanders
	 *            
	 * @require <tt>naam != ""</tt>
	 * @require De gegeven namen zijn bekend bij de server.
	 * 
	 * @syntax <code>challenge &lt;String:naam&gt;(1..3)</code>
	 */
	public static final String CHALLENGE = "challenge";

	/**
	 * Accepteert een uitnodiging. De partij kan ook door iemand anders
	 * geannuleerd worden.
	 * 
	 * @param naam
	 *            Naam van de uitnodiger
	 * @require <tt>naam</tt> heeft deze client uitgenodigd.
	 * 
	 * @syntax <code>challengeAccept &lt;String:naam&gt;</code>
	 */
	public static final String CHALLENGE_ACCEPT = "challengeAccept";

	/**
	 * Wijst een uitnodiging af. De server zal de partij nu annuleren.
	 * 
	 * @param naam
	 *            Naam van de uitnodiger
	 *            
	 * @require <tt>naam</tt> heeft deze client uitgenodigd.
	 * 
	 * @syntax <code>challengeReject &lt;String:naam&gt;</code>
	 */
	public static final String CHALLENGE_REJECT = "challengeReject";

}
