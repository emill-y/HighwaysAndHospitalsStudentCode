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

        // Store potential connections for each city
        // Array of Arraylists
        Object[][] cityConnections = new Object[n][2];
        for(int i = 0; i < n; i++){
            cityConnections[i][0] = new ArrayList<Integer>();
            cityConnections[i][1] = false;
        }

        for(int i = 0; i < cities.length; i++) {
            //(cityConnections[cities[i][0]][0]).add(1);
        }
        System.out.println(Arrays.toString(cityConnections));

        return 0;
//    public boolean accessHighway(){
//
//    }
    }
}
