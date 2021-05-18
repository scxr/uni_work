
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LevelChecker {
    /**
     * Implement the check method without recursion, in a dynamic programming
     * way, return true if the level is possible, return false if it is not completable
     * @param level
     *          an array of integers representing our level
     * @return true if the level is possible, return false if it is not completable
     */
    public static boolean betterCheck(int[] level) {
        // check this before we reach the end to save time
        int i = 0; // counter
        int initial_i;
        if (level[level.length-1] == 0 || level[0] == 0) {
            return false; // check the level doesnt start or end with a 0, speeds up unfeasible check
        }

        while (true) {
            int longestJump = level[i]; // the furthest we can possibly go
            initial_i = i; // stop an infinite loop if the level is unfeasible
            i += longestJump; // increment i by longest possible distance
            if (i > level.length - 1) {
                break; // we have reached the end successfully
            }
            if (level[i] <= 0) {
                while (!(level[i] > 0)) { // loop until not on death square
                    i--; // if we are on death we need to move back one
                    longestJump--; // if we are on death we need to move back one
                }
            }
            if (initial_i == i) {
                return false; // check we dont get trapped in infinite loop
            }
        }
        return true; // we made it here so must be feasible

    }

    /**
     * A recursive algorithm to check if the level is completeable, return true if the level is possible
     * return false if the level is impossible
     * @param level
     *          integer array representing our level
     * @return true if the level is possible
     *       return false if the level is impossible
     */
    public static boolean check(int[] level){
        if (level.length==1 && level[0] > 0) { // we are at the final node and it isnt a death node
            return true;
        }
        if (level[0] == 0) {
            return false; // cannot start with a 0
        }
        int maxJump = Math.min(level[0], (level.length)-1);
        for (int i=1; i<maxJump+1;i++) {
                int[] A = Arrays.copyOfRange(level, i, level.length); // level parts left to complete
                if (check(A)) { // recursion
                    return true;
            }
        }
        return false;
    }


    /**
     * Get the shortest possible path of jumps, returns a list of integers representing shortest amount of jumps to
     * complete otherwise returns an empty list if the level is impossible
     * @param level
     *          integer array representing the level
     * @return list of integers representing shortest amount of jumps to
     *       complete otherwise returns an empty list if the level is impossible
     */
    public static List<Integer> getJumps(int[] level) {
        int i = 0;
        if (!(check(level))) {
            return new ArrayList<Integer>(); // return empty array if impossible
        }
        List<Integer> output = new ArrayList<>(); // to return
        while (!(i == level.length)) {
            int maxJumpSize = level[i]; // furthest we can go
            int toEnd = (level.length-1) - i; // if we jump further than end
            i += maxJumpSize;
            if (i > level.length - 1) {
                if (!(toEnd==0)) {
                    output.add(toEnd); // we jumped further on end so jump to end instead
                }
                return output;
            }
            if (level[i] <= 0) { // we jumped to a death square
                while (!(level[i] > 0)) { // find next none death square
                    i--;
                    maxJumpSize--;
                }
            }
            output.add(maxJumpSize); // add to our output
        }
        return output; // return answer
    }
}
