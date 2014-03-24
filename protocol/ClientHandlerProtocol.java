package protocol;
/**
 * <p>
 * Het protocol waarmee de server (client handler) met de clients communiceert.
 * Bij het implementeren moet in ieder geval een invulling gegeven worden aan de
 * standaardcommando's. Als de handler hierdoor niet aan een verzoek van een
 * client kan voldoen, moet de betreffende foutmelding worden doorgegeven met
 * het <tt>error</tt>-commando.
 * </p>
 * <p>
 * Elk commando wordt over de socket gestuurd als een string met daarin het
 * keyword, gevolgd door de argumenten en beëindigd met een newline character.
 * De javadocs bij de commando's leggen de syntax uit bij de <tt>syntax</tt>
 * -tag, en ook eventuele pre- en postcondities. Het keyword en de argumenten
 * worden van elkaar gescheiden door een spatie, opgeslagen in
 * <tt>DELIM</tt>. Bijvoorbeeld:
 * </p>
 * <p>
 * <tt>
 * "startGame" + DELIM + "Pietje" + DELIM + "Henk" '\n'
 * </tt>
 * </p>
 * 
 * @author Paul Velthuis
 * @version 20140312
 */
 public interface ClientHandlerProtocol {
 
 
	/**
	 * Scheidingsteken voor keywords en argumenten
	 */
	public static final String DELIM = " ";
	
	//standaardcommando's 
	/**
	 * Geeft aan de client door dat het verbinding maken met de server is gelukt.
	 * Hiernaast geeft het aan of de chat functie ondersteund is en/of de challenge functie ondersteund is.
	 * Dit doen we door middel van een getal op te sturen. 
	 * 
	 * @param getalOndersteund Dit getal kan 0, 1, 2 of 3 zijn. 
	 *												 0 betekent dat zowel de chat als de challenge functie niet ondersteund is.
	 *												 1 betekent dat de chat ondersteund is.
	 * 												 2 betekent dat de challenge ondersteund is.
	 *												 3 betekent dat zowel de chat als de challenge functie ondersteund is. 
	 * 
	 * @require Een client heeft het <tt>join</tt>-commando gebruikt.
	 * @require <tt>0<=getalOndersteund<4 </tt>
	 * 
	 * @syntax <code>accept &lt;Int:getalOndersteund</code>
	 */
	public static final String ACCEPT = "accept";
	
	/**
	 * Geeft aan de client de spelernamen door van de partij waar hij in zit. 
	 * De speler die als eerste genoemd is die moet ook de eerste zet doen.
	 * @param naam            Spelernaam
	 * 
	 * @require Alle spelers waarvan de namen worden doorgegeven bevinden zich
	 *          in de "pre-game" lobby en zijn dus niet met een partij bezig.
	 * @ensure de eerste naam die doorgegeven wordt begint het spel
	 * 
	 * @syntax <code>startGame &lt;String:naam&gt;(1..4)</code>
	 */
	public static final String START_GAME = "startGame";
	
		/**
	 * Geeft aan de  clients door dat er een zet is gedaan en specificeert deze.
	 * Als de server een zet heeft goedgekeurd wordt dit commando verstuurd naar
	 * alle clients van de betreffende partij, inclusief de client die de zet
	 * deed.
	 * Het punt 0,0 bevindt zich linksboven
	 * 
	 * @param naam	
	 * 			  naam van de speler die de zet gedaan heeft
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
	 
	 * @require <tt>naam != "" </tt>
	 * @require <tt> 0<=x<9 </tt>
	 * @require <tt> 0<=y<9 </tt>
	 * @require <tt> 0<=vak<9 </tt>
	 * @require de draaiRichting is "links"(tegen de klok in) of rechts(met de klok mee)
	 * 
	 * @syntax <code>updateField &lt;String:naam&gt; &lt;Int:x&gt; &lt;Int:y &gt; &lt;Int:vak &gt; String:draairichting</code>
	 */
	public static final String UPDATE_FIELD = "updateField";
	
	/**
	* Geeft aan de clients door dat het spel over is en wie de winnaars zijn
	 * door het aantal spelers dat gewonnen heeft op te sturen.
	* @param namen
	*            Namen van de winnaars
	*            
	* @require <tt>naam != ""</tt> 
	* @require de namen van de winnaars deden mee aan de game
	* 
	* @syntax <code>Winner &lt;String:naam&gt;(1..*)</code>
	*/
	public static final String WINNER="winner";
	
	/**
	 * Geeft een fout door aan de client. Bijvoorbeeld als er een verkeerde naam wordt gebruikt of een verkeerde zet wordt gedaan.
	 * Als er een fout optreed dan verbreekt de server de verbinding met de Client. Als deze Client nog in een game zit dan wint de rest.
	 * 
	 * @param beschrijving
	 *            Een beschrijving van de fout. Voor een standaardbeschrijving
	 *            kan <tt>toString()</tt> van een <tt>Error</tt>-instantie
	 *            gebruikt worden. De server is vrij om te kiezen tussen de
	 *            standaardbeschrijving of de meegegeven beschrijving.
	 *
	 * @require <tt>beschrijving != ""</tt>
	 * 
	 * @syntax <code>error &lt;String:beschrijving&gt;</code>
	 */
	public static final String ERROR = "error";
		// Chatcommando
	/**
	 * Geeft een chatbericht door aan de client, met de naam van de afzender. 
	 * Na de eerste delimeter alle spaties gewoon mee nemen in het bericht.
	 * 
	 * @param naam         Naam van de afzender
	 * @param bericht      Bericht van de afzender
	 * 
	 * @require <tt>naam != ""</tt> 
	 * 
	 * @syntax <code>chat &lt;String:naam &gt; &lt;String:bericht &gt;</code>
	 */
	public static final String BROADCAST = "broadcast";
	
	//challenge commando's 
	/**
	 * Wijst een uitnodiging af als deze speler al uitgedaagt wordt. De server zal de zeggen dat de partij niet mogelijk is.
	 *  
	 * @syntax <code>challengeReject &gt;</code>
	 */
	public static final String CHALLENGE_REJECT = "challengeReject";
	
	/**
	 * Geeft aan de client door dat hij uitgenodigd is door de gegeven speler. Er wordt ook bij gestuurd met hoeveel spelers deze speler wil spelen.
	 * @param naam         Naam van de uitnodiger
	 * 
	 * @param aantalSpelers         aantalspelers om de game mee te spelen
	 *								2 betekent dat jij tegen de uitdager speelt
	 *								3 betekent dat jij tegen de uitdager en nog iemand anders speelt
	 *								4 betekent dat jij tegen de uitdager en nog 2 andere speelt.
	 * 
	 * @require <tt>0<=getalOndersteund<4 </tt>
	 * 
	 * @syntax <code>challengedBy &lt;String:name&gt ; &lt;Int:aantalSpelers&gt</code>
	 */
	public static final String CHALLENGED_BY = "challengedBy";
	
	
	
	/**
	*geeft aan dat er een nieuwe speler online is gekomen en/of die chat en challenge ondersteund. Dit bericht wordt verstuurd naar alle spelers die challenge ondersteunen.
	* @param naam 	Naam van de speler die online is gekomen
	* 
	* @param getalOndersteund Dit getal kan 0, 1, 2,3 zijn. 
	*												 0 betekent dat zowel de chat als de challenge functie niet ondersteund is.
	*												 1 betekent dat de chat ondersteund is.
	* 												 2 betekent dat de challenge ondersteund is.
	*												 3 betekent dat zowel de chat als de challenge functie ondersteund is. 
	*
	* @require <tt>naam != ""</tt>
	* @syntax <code>online &lt;String:naam&gt; &lt;Int:getalOndersteund&gt;</code>
	*/
	public static final String ONLINE = "online";
	
	/**
	*geeft aan dat er een nieuwe speler offline is gegaan. Dit bericht wordt verstuurd naar alle spelers die challenge ondersteunen.
	*
	* @param naam 	Naam van de speler die offnline is gegaan
	*
	* @require <tt>naam != ""</tt>
	* 
	* @syntax <code>offline &lt;String:naam&gt; </code>
	*/
	public static final String OFFLINE = "offline";
	}
	