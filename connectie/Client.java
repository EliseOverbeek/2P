package connectie;



import java.net.*;
import java.io.*;

/**
 * P2 prac wk4. <br>
 * Client. Een Thread-klasse voor het onderhouden van een Socket-verbinding met
 * een Server. De Thread leest berichten uit de socket en stuurt die door naar
 * zijn MessageUI.
 * 
 * @author Theo Ruys
 * @version 2005.02.21
 */
public class Client extends Thread {

	private String clientName;
	private MessageUI mui;
	private Socket sock;
	private BufferedReader in;
	private BufferedWriter out;

	/**
	 * Construeert een Client-object en probeert een socketverbinding met een
	 * Server op te starten.
	 */
	public Client(String name, InetAddress host, int port, MessageUI mui)
			throws IOException {
		super(name);
		this.mui = mui;
		this.clientName = name;

		try {
			sock = new Socket(host, port);
			

		} catch (IOException e) {
			System.out.println("Could not create socket on " + host
					+ "and port" + port);
		}
		in = new BufferedReader(new InputStreamReader(
				sock.getInputStream()));
		out= new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
		sendMessage(name);
	}

	/**
	 * Leest berichten uit de socketverbinding. Elk berichtje wordt gestuurd
	 * naar de MessageUI van deze Client. Als er iets fout gaat bij het lezen
	 * van berichten, sluit deze methode de socketverbinding.
	 */
	public void run() {
		String s=null;
		try {
			
			s = in.readLine();
			while (s != null) {
				mui.addMessage(s);
				s = in.readLine();
			}

		} catch (IOException e) {
			System.err.println(e);
			shutdown();
		}
	}

	/** Stuurt een bericht over de socketverbinding naar de ClientHandler. */
	public void sendMessage(String msg) {
		try {
			out.write(msg);
			out.newLine();
			out.flush();
		} catch (IOException e) {
			System.err.println(e);
		}

	}

	/** Sluit de socketverbinding van deze client. */
	public void shutdown() {
		mui.addMessage("Closing socket connection...");
		try {
			sock.close();
		} catch (IOException e) {
			System.err.println(e);
		}

	}

	/** Levert de naam van de gebruiker van deze Client. */
	public String getClientName() {
		return clientName;
	}

}

