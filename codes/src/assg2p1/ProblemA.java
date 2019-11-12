package assg2p1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
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
	ArrayList<String> stations = new ArrayList<String>(); // simply to hold all stations

	/**
	 * A helper method to process the input file.
	 * 
	 * @param infile the file containing the input
	 * @throws IOException
	 */
	public void processInput(String infile) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(infile));
		while (in.ready()) {
			String[] stationStr = in.readLine().split("\\s+");

			if (!stations.contains(stationStr[0])) {
				stations.add(stationStr[0]);
			}
			if (!stations.contains(stationStr[1])) {
				stations.add(stationStr[1]);	
			}			

			if (paths.containsKey(stationStr[0])) {
				paths.get(stationStr[0]).put(stationStr[1], 1);
			} else {
				HashMap<String, Integer> temp = new HashMap<String, Integer>();
				temp.put(stationStr[1], 1);
				paths.put(stationStr[0], temp);
			}
		}

		// initialise all stations ->
		// add 0 to remaining stations that have no adj connection
		for (String u : stations) {
			for (String v : stations) {
				if (!paths.containsKey(u)) {
					HashMap<String, Integer> temp = new HashMap<String, Integer>();
					temp.put(v, 0);
					paths.put(u, temp);
				} else if (!paths.get(u).containsKey(v)) {
					paths.get(u).put(v, 0);
				}
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
		// update to find paths between using floyd-warshall algorithm
		for (String k : stations) {
			for (String i : stations) {
				for (String j : stations) {
					if (paths.get(i).get(k) * paths.get(k).get(j) > 0) {
						paths.get(i).replace(j, paths.get(i).get(j) + paths.get(i).get(k) * paths.get(k).get(j));
					}
				}
			}
		}

		// find and set cycles to -1
		for (String k : stations) {
			// if it has reached itself, change all paths that use that station to -1
			if (paths.get(k).get(k) > 0) {
				for (String i : stations) {
					for (String j : stations) {
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
