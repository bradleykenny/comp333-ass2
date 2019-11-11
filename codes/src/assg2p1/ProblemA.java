package assg2p1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ProblemA {

	public ProblemA(String infile) {
		try {
			processInput(infile);
		} catch (IOException e) {
			System.out.println("Exception encountered: " + e);
		}
	}

	HashMap<String, HashMap<String, Integer>> paths = new HashMap<String, HashMap<String, Integer>>();
	HashMap<String, String> numStations = new HashMap<String, String>();

	/**
	 * A helper method to process the input file.
	 * 
	 * @param infile the file containing the input
	 * @throws IOException
	 */
	public void processInput(String infile) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(infile));
		while (in.ready()) {
			String[] stations = in.readLine().split("\\s+");

			numStations.put(stations[0], stations[0]);
			numStations.put(stations[1], stations[1]);

			if (paths.containsKey(stations[0])) {
				paths.get(stations[0]).put(stations[1], Integer.MAX_VALUE);
			} else {
				HashMap<String, Integer> temp = new HashMap<String, Integer>();
				temp.put(stations[1], Integer.MAX_VALUE);
				paths.put(stations[0], temp);
			}
		}
		in.close();
	}

	/**
	 * Returns the number of routes between two stations for all pairs of stations,
	 * as described in the assignment spec.
	 * 
	 * @return the 2D hashmap containing the number of routes
	 */
	public HashMap<String, HashMap<String, Integer>> findNumberOfRoutes() {
		// initialise dist array depending on paths
		HashMap<String, HashMap<String, Integer>> dist = new HashMap<String, HashMap<String, Integer>>();

		// initialise all stations
		for (String one : numStations.keySet()) {
			for (String two : numStations.keySet()) {
				if (paths.containsKey(one) && paths.get(one).containsKey(two)) {
					if (dist.containsKey(one)) {
						dist.get(one).put(two, 1);
					} else {
						HashMap<String, Integer> temp = new HashMap<String, Integer>();
						temp.put(two, 1);
						dist.put(one, temp);
					}
				} else {
					if (dist.containsKey(one)) {
						dist.get(one).put(two, 0);
					} else {
						HashMap<String, Integer> temp = new HashMap<String, Integer>();
						temp.put(two, 0);
						dist.put(one, temp);
					}
				}
			}
		}

		// update to find paths betweenn using floyd warshall
		for (String k : numStations.keySet()) {
			for (String i : numStations.keySet()) {
				for (String j : numStations.keySet()) {
					if (dist.get(i).get(k) * dist.get(k).get(j) > 0) {
						dist.get(i).replace(j, dist.get(i).get(j) + dist.get(i).get(k) * dist.get(k).get(j));
					}
				}
			}
		}

		// setting cycles to -1
		for (String k : numStations.keySet()) {
			if (dist.get(k).get(k) > 0) {
				for (String i : numStations.keySet()) {
					for (String j : numStations.keySet()) {
						if (dist.get(i).get(k) * dist.get(k).get(j) > 0 || dist.get(i).get(k) * dist.get(k).get(j) < 0) {
							dist.get(i).replace(j, -1);
						}
					}
				}
			}
		}

		return dist;
	}
}
