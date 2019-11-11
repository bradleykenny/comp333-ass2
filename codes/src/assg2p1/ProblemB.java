package assg2p1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

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

	HashMap<String, HashMap<String, Integer>> graph = new HashMap<String, HashMap<String, Integer>>();
	HashMap<String, HashMap<String, Integer>> rGraph = new HashMap<String, HashMap<String, Integer>>();
	
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
		verticeDevices.put(start, 0);
		verticeDevices.put(end, 0);
		for (int i = 0; i < numVertices; i++) {
			line = in.readLine().split("\\s+");
			verticeDevices.put(line[0], Integer.parseInt(line[1]));
		} 
		
		// read in line devices
		for (int i = 0; i < numEdges; i++) {
			line = in.readLine().split("\\s+");
			
			// direction 1
			if (graph.containsKey(line[0])) {
				graph.get(line[0]).put(line[1], Integer.parseInt(line[2]));
			} else {
				HashMap<String, Integer> temp = new HashMap<String, Integer>();
				temp.put(line[1], Integer.parseInt(line[2]));
				graph.put(line[0], temp);
			}

			// direction 2
			if (graph.containsKey(line[1])) {
				graph.get(line[1]).put(line[0], Integer.parseInt(line[2]));
			} else {
				HashMap<String, Integer> temp = new HashMap<String, Integer>();
				temp.put(line[0], Integer.parseInt(line[2]));
				graph.put(line[1], temp);
			}
		}

		// make any remaining connections 0 as there is no flow between them
		for (String i : verticeDevices.keySet()) {
			for (String j : verticeDevices.keySet()) {
				System.out.println(i + " " + j);
				if (!graph.containsKey(i)) {
					HashMap<String, Integer> temp = new HashMap<String, Integer>();
					temp.put(j, 0);
					graph.put(i, temp);
				} else {
					if (!graph.get(i).containsKey(j)) {
						graph.get(i).put(j, 0);
					}
				}
			}
		}

		System.out.println(graph);
		in.close();
	}
	
	/**
	 * Returns the minimum number of device failures that will cause 
	 * the two stations in the input file to be disconnected 
	 * (please refer to the assignment spec for the details)
	 * 
	 * @return an integer denoting the minimum number of device failures
	 */
	public Integer computeMinDevice() {
		String u, v; 
		// set up residual graph to be copy of initial graph
		// if edge is 0, no connection between them
		for (String i : verticeDevices.keySet()) {
			for (String j : verticeDevices.keySet()) {
				if (rGraph.containsKey(i)) {
					rGraph.get(i).put(j, graph.get(i).get(j));
				} else {
					HashMap<String, Integer> temp = new HashMap<String, Integer>();
					temp.put(j, graph.get(i).get(j));
					rGraph.put(i, temp);
				}
			}
		}

		HashMap<String, String> parent = new HashMap<String, String>();
		for (String p : verticeDevices.keySet()) {
			parent.put(p, "");
		}
		int max_flow = 0;

		while (bfs(rGraph, start, end, parent)) {
			int path_flow = Integer.MAX_VALUE;
			
			v = end;
			while (!v.equals(start)) {
                u = parent.get(v); 
				path_flow = Math.min(path_flow, rGraph.get(u).get(v)); 
				v = parent.get(v);
            } 
  
            // update residual capacities of the edges and 
            // reverse edges along the path 
            v = end;
			while (!v.equals(start)) {
                u = parent.get(v); 
                rGraph.get(u).replace(v, rGraph.get(u).get(v) - path_flow); 
				rGraph.get(v).replace(u, rGraph.get(v).get(u) + path_flow); 
				v = parent.get(v);
            } 
  
            // Add path flow to overall flow 
            max_flow += path_flow; 
        } 
  
        // Return the overall flow 
        return max_flow; 
	}


	boolean bfs(HashMap<String, HashMap<String, Integer>> rGraph, String s, String t, HashMap<String, String> parent) { 
        // Create a visited array and mark all vertices as not 
        // visited 
        HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
        for (String v : verticeDevices.keySet()) { 
			visited.put(v, false); 
		}
  
        // Create a queue, enqueue source vertex and mark 
        // source vertex as visited 
        LinkedList<String> queue = new LinkedList<String>(); 
        queue.add(s); 
        visited.replace(s, true); 
        parent.replace(s, ""); 
  
        // Standard BFS Loop 
        while (queue.size()!=0) 
        { 
            String u = queue.poll(); 
  
            for (String v : verticeDevices.keySet()) 
            { 
                if (visited.get(v)==false && rGraph.get(u).get(v) > 0) 
                { 
                    queue.add(v); 
                    parent.replace(v, u); 
                    visited.replace(v, true); 
                } 
            } 
        } 
  
        // If we reached sink in BFS starting from source, then 
        // return true, else false 
        return (visited.get(t) == true); 
    } 
}
