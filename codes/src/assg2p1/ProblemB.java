package assg2p1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ProblemB {

	public ProblemB(String infile) {
		try {	
			processInput(infile);
		}
		catch (IOException e) {
			System.out.println("Exception encountered: " + e);
		}
	}

	String start;
	String end;
	int numVertices;
	int numEdges;

	HashMap<String, Integer> verticeDevices = new HashMap<String, Integer>();
	HashMap<String, Integer> lineDevices = new HashMap<String, Integer>();
	
	
	/**
	 * A helper method to process the input file. 
	 * 
	 * @param infile the file containing the input
	 * @throws IOException
	 */
	public void processInput(String infile) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(infile));
		
		// first line of input
		String[] line = in.readLine().split("\\s+");
		start = line[0];
		end = line[1];

		// second line of input
		line = in.readLine().split("\\s+");
		numVertices = Integer.parseInt(line[0]);
		numEdges = Integer.parseInt(line[1]);

		// read in station devices
		for (int i = 0; i < numVertices; i++) {
			line = in.readLine().split("\\s+");
			verticeDevices.put(line[0], Integer.parseInt(line[1]));
		} 

		// read in line devices
		for (int i = 0; i < numEdges; i++) {
			line = in.readLine().split("\\s+");
			lineDevices.put(createID(line[0], line[1]), Integer.parseInt(line[2]));
		}

		in.close();
	}

	public String createID(String name1, String name2) {
		if (name1.compareTo(name2) < 0) {
			return name1 + "-" + name2;
		} else {
			return name2 + "-" + name1;
		}
	}
	
	/**
	 * Returns the minimum number of device failures that will cause 
	 * the two stations in the input file to be disconnected 
	 * (please refer to the assignment spec for the details)
	 * 
	 * @return an integer denoting the minimum number of device failures
	 */
	public Integer computeMinDevice() {
		/*
		 * INSERT YOUR CODE HERE
		 */
	
		return 0;
	}
}
