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

    /**
     * TODO: Complete this function, cost(), to return the minimum cost to provide
     *  hospital access for all citizens in Menlo County.
     */
    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {
        // Eliminate initial edge case
        if (hospitalCost <= highwayCost) {
            return ((long) n * hospitalCost);
        }

        // Take array of city connections & convert to groups of connected clusters
        // Add initial city pair to group 1, then go to next city pair, see if it is connected in group 1
        // If not create a new group
        // Until the enviormental clusters are created

        // Calculate cost once clusters are created

        return 0;
    }
}
