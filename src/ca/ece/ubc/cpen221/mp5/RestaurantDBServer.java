package ca.ece.ubc.cpen221.mp5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// TODO: Implement a server that will instantiate a restaurantData, 
// process queries concurrently, etc.

/**
 * 
 * @author Jim
 * to connect, open console and type in "telnet localhost 6969" after
 * starting this file.
 */

public class RestaurantDBServer {

	private RestaurantDB restaurantData;
	private ServerSocket socket;

	/**
	 * Constructor
	 * 
	 * 
	 * @param port
	 *            is the port number we wish to connect to
	 * @param restaurantJSONfilename
	 *            the filename of the restaurant JSON file
	 * @param reviewsJSONfilename
	 *            the filename of the reviews JSON file
	 * @param usersJSONfilename
	 *            the filename of the users JSON file
	 * @throws IOException
	 */
	public RestaurantDBServer(int port, String restaurantJSONfilename, String reviewsJSONfilename,
			String usersJSONfilename) throws IOException {
		restaurantData = new RestaurantDB(restaurantJSONfilename, reviewsJSONfilename, usersJSONfilename);
		socket = new ServerSocket(port);
		// TODO: See the problem statement for what the arguments are.
		// TODO: Rename the arguments suitably.
	}

	/**
	 * returns the restaurant in JSON format if a valid businessID is given.
	 * 
	 * @param businessID
	 * @return the restaurant in JSOn format or an error message if the
	 *         businessID is not valid
	 */
	public String getRestaurant(String businessID) {
		synchronized (restaurantData) {
			return restaurantData.getRestaurant(businessID);
		}
	}

	/**
	 * Initializes the server and listens for clients to connect.
	 * @throws IOException
	 */
	public void startServer() throws IOException {
		
		while (true) {

			Socket socket2 = this.socket.accept();
			Thread processor = new Thread(new Runnable() {
				public void run() {
					try {
						try {
							process(socket2);
						} finally {
							socket.close();
						}
					} catch (IOException ioe) {

						ioe.printStackTrace();
					}
				}
			});
			processor.start();
		}
	}

	/**
	 * Processes the client queries after they've connected.
	 * 
	 * @param socket the accepted socket from the client
	 * @throws IOException if sockets are malformed
	 */
	private void process(Socket socket) throws IOException {
		System.err.println("client connected");

		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
		out.println("Enter query, or q to exit");
		while (true) {

			String query = in.readLine();

			if (query.contains("getRestaurant") && query.matches("getRestaurant[(].*[)]")) {
				int beginIndex = query.indexOf('(');
				int endIndex = query.indexOf(')');
				String id = query.substring(beginIndex + 1, endIndex);
				out.println(getRestaurant(id));
			}

			if (query.equals("q"))
				break;
		}

	}

	public static void main(String[] args) throws IOException {
		RestaurantDBServer mainServer = new RestaurantDBServer(Integer.parseInt(args[0]), args[1], args[2], args[3]);

		
		mainServer.startServer();

	}

}
