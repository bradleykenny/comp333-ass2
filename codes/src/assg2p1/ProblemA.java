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
	HashMap<String, String> numStations = new HashMap<String, String>(); // simply to hold all stations

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
				paths.get(stations[0]).put(stations[1], 1);
			} else {
				HashMap<String, Integer> temp = new HashMap<String, Integer>();
				temp.put(stations[1], 1);
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
		// initialise all stations ->
		// add 0 to remaining stations that have no adj connection
		for (String one : numStations.keySet()) {
			for (String two : numStations.keySet()) {
				if (!paths.containsKey(one)) {
					HashMap<String, Integer> temp = new HashMap<String, Integer>();
					temp.put(two, 0);
					paths.put(one, temp);
				} else if (!paths.get(one).containsKey(two)) {
					paths.get(one).put(two, 0);
				}
			}
		}

		// update to find paths between using floyd-warshall algorithm
		for (String k : numStations.keySet()) {
			for (String i : numStations.keySet()) {
				for (String j : numStations.keySet()) {
					if (paths.get(i).get(k) * paths.get(k).get(j) > 0) {
						paths.get(i).replace(j, paths.get(i).get(j) + paths.get(i).get(k) * paths.get(k).get(j));
					}
				}
			}
		}

		// find and set cycles to -1
		for (String k : numStations.keySet()) {
			// if it has reached itself, change all paths that use that station to -1
			if (paths.get(k).get(k) > 0) {
				for (String i : numStations.keySet()) {
					for (String j : numStations.keySet()) {
						if (paths.get(i).get(k) * paths.get(k).get(j) > 0 || paths.get(i).get(k) * paths.get(k).get(j) < 0) {
							paths.get(i).replace(j, -1);
						}
					}
				}
			}
		}

		return paths;
	}
}
