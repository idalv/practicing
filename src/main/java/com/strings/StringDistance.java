package com.strings;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/6/15
 * Time: 3:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringDistance {

    /**
     * The distance is computed recursively:
     * If source = s1s2...si, target = t1t2...tj and d[i,j] is the distance between source and target, then:
     *  if target is a result of source + an insertion then d[i,j] = d[i-1,j] + 1
     *  if target is a result of source + a deletion then d[i,j] = d[i,j-1] + 1
     *  if target is a result of source + a substitution then d[i,j] = d[i-1,j-1] + 1
     *  if target is the same as source then d[i,j] = d[i-1,j-1]
     *
     *  From this definition a table d[0..i][0..j] is built where d[i][j] is min of the above conditions, see page 695
     * @param source
     * @param target
     * @return
     */
    public static int[][] computeDistance(String source, String target) {
        int dist[][] = new int[source.length() + 1][target.length() + 1];

        // Lets assume the source is on the vertical and the target is on the horizontal

        // The first row would be an empty source, i.e. d[0,j] = j
        for (int j = 0; j <= target.length(); j++) {
            dist[0][j] = j;
        }

        // The first column would be an empty target, i.e. d[i,0] = i
        for (int i = 0; i <= source.length(); i++) {
            dist[i][0] = i;
        }

        // Now calculating the rest of the distances
        for (int i = 1; i <= source.length(); i++) {
            for (int j = 1; j <= target.length(); j++) {
                int insert = dist[i-1][j] + 1;
                int delete = dist[i][j-1] + 1;
                int subs = source.charAt(i-1) == target.charAt(j-1) ? dist[i-1][j-1] : dist[i-1][j-1] + 1;
                dist[i][j] = Math.min(insert, Math.min(delete, subs));
            }
        }

        return dist;
    }

    public static String computeAlignment(String source, String target) {
        int[][] distance = StringDistance.computeDistance(source, target);

        // Now going backwards to see how we've come with this distance
        int i = source.length();
        int j = target.length();
        LinkedList<Character> sourceAlign = new LinkedList<Character>();
        LinkedList<Character> targetAlign = new LinkedList<Character>();
        while (i != 0 || j != 0) {
            if (i > 0 && distance[i][j] == distance[i-1][j] + 1) {
                // There has been a deletion
                sourceAlign.addFirst(source.charAt(i-1));
                targetAlign.addFirst('-');
                i--;
            } else if (j > 0 && distance[i][j] == distance[i][j-1] + 1) {
                // There has been an insertion
                sourceAlign.addFirst('-');
                targetAlign.addFirst(target.charAt(j-1));
                j--;
            } else if (i > 0 && j > 0 &&
                    (distance[i][j] == distance[i - 1][j - 1] ||
                            distance[i][j] == distance[i - 1][j - 1] + 1)) {
                // Either the letters are same or there has been a substitution
                sourceAlign.addFirst(source.charAt(i - 1));
                targetAlign.addFirst(target.charAt(j - 1));
                i--;
                j--;
            }
        }

        // Construct the result
        StringBuilder alignment = new StringBuilder();
        while (!sourceAlign.isEmpty()) {
            alignment.append(sourceAlign.removeFirst());
        }
        alignment.append("\n");
        while (!targetAlign.isEmpty()) {
            alignment.append(targetAlign.removeFirst());
        }

        return alignment.toString();
    }

}
