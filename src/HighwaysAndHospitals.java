import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Highways & Hospitals
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: Eisha Yadav
 *
 */

public class HighwaysAndHospitals {

    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {
        // Eliminate initial edge case
        if (hospitalCost <= highwayCost) {
            return ((long) n * hospitalCost);
        }

        // Take array of city connections & convert to groups of connected clusters
        // Add initial city pair to group 1, then go to next city pair, see if it is connected in group 1
        // If not create a new group
        // Until the enviormental clusters are created

        // Start each city as its own individual node (each node is its own root)
        // For each root, size[root] stores the number of nodes(cities) for that cluster
        // Size -> Allows to compress tree size as program runs
        int[] parent = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        // Loops through each road [edge] in the input
        // Convert 1 base to 0 base
        // Merge components containing cities
        // Make city groups belong to the same node
        for (int[] road : cities) {
            int u = road[0] - 1;
            int v = road[1] - 1;
            union(u, v, parent, size);
        }

        // Calculate cost once clusters are created
        long totalCost = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                // 1 Hospital per cluster
                // One less highway than the number of cities in the cluster
                int componentSize = size[i];
                totalCost += hospitalCost;
                totalCost += (long) (componentSize - 1) * highwayCost;
            }
        }
        return totalCost;
    }

    // Helper Functions

    private static int find(int x, int[] parent) {
        // Check if cluster contains root
        // If not recursively iterate to another cluster and check
        // Until found
        // Then flatten tree to make future calls more efficient
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }

    private static void union(int a, int b, int[] parent, int[] size) {
        // Get roots of a and b
        int rootA = find(a, parent);
        int rootB = find(b, parent);
        // If rootA = rootB they are already in the same component, no need to merge
        // If not, merge by adding seperate cluster to the larger cluster
        // Results in one giant cluster
        if (rootA != rootB) {
            if (size[rootA] < size[rootB]) {
                parent[rootA] = rootB;
                size[rootB] += size[rootA];
            } else {
                parent[rootB] = rootA;
                size[rootA] += size[rootB];
            }
        }
    }
}

