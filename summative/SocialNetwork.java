
import java.util.*;

public class SocialNetwork {

    public String name;
    public Map<String, User> users;
    private int sum=-1;

    /**
     * Create a new instance of SocialNetwork
     * @param name
     *       The name of the social network
     */
    public SocialNetwork(String name) {
        this.name = name;
        this.users = new HashMap<String, User>(); // creates an empty hashmap
    }


    /**
     * Create a new user on the social network. Return the new user object if
     * the user id is unique throw a new IllegalArgumentException otherwise.
     *
     * @param id
     *         the unique id of the new user
     * @param name
     *         the name of the new user
     * @return the new object of the user if it is unique, throw exception
     *         otherwise.
     */
    public User createUser(String id, String name) {
        User newUser = new User(id, name);
        for (Map.Entry<String, User> u: this.users.entrySet()) { // iterate through the map of users
            if (u.getValue().id.equals(newUser.id)) {  // check if the id's are the same if they are throw exception
                throw new IllegalArgumentException();
            }
        }
        this.users.put(newUser.id, newUser); // put user in the map
        return newUser;
    }

    /**
     * Gets a user by there ID, return the user object if the user ID exists in
     * the set of users. throws an IllegalArgumentException otherwise.
     *
     * @param id
     *         unique id of the user being searched for
     * @return the user object if the user ID exists in the set of users.
     *         throws an IllegalArgumentException otherwise.
     */
    public User getUser(String id) {
        for (Map.Entry<String, User> u: this.users.entrySet()) { // iterate through the users
            if (u.getValue().id == id) { // if our current user has the same unique id return it
                return u.getValue();
            }
        }
        throw new IllegalArgumentException(); // we havent found our user yet
    }

    /**
     * Creates a relationship between the two users (user A, user B) return true
     * if the connection has been formed (both users are valid and arent already
     * connected), returns false otherwise (either user A or user B is invalid,
     * or they are already in each others circles)
     *
     * @param uA
     *         Unique user id of user A
     * @param uB
     *         Unique user id of user B
     * @return true if the connection has been formed (both users are valid and arent already
     *      connected), returns false otherwise (either user A or user B is invalid,
     *      or they are already in each others circles)
     */
    public boolean addRelationship(String uA, String uB) {
        User userOne = getUser(uA); // get our users
        User userTwo = getUser(uB);
        boolean addConnOne = userOne.addConnection(uB); // add the user connection
        boolean addConnTwo = userTwo.addConnection(uA); // add the second user connection
        return addConnOne && addConnTwo; // check they have both been connected
    }

    /**
     * This calculates the normalised closeness centrality of a User given by its unique user id,
     * the formula is : C(x)= (N−1) / ∑yd(y, x) where C(x) is the closeness of the vertex, x, d(y,x)
     * and N is the number of vertices on the graph. It is assumed the graph is strongly connected.
     * Returns the closedness value calculated from the formula (if the unique user id exists) otherwise
     * it throws a new IllegalArgumentException if the user id does not exist in the users.
     *
     * @param uA
     *         the unique user ID
     * @return the closedness value calculated from the formula (if the unique user id exists) otherwise
     *         it throws a new IllegalArgumentException if the user id does not exist in the users.
     */
    public double closeness(String uA) {
        int sum = 0; // tracking int
        User user = getUser(uA); // check our user exists
        Set<String> connections = new HashSet<>(user.getConnections()); // initialise a new connections array
                                                                        // to iterate through
        int N = this.users.size() -1; // get vertices in graph
        int toAdd = 1; // counter
        sum += connections.size(); // the nodes of 1 distance added
        while (!(connections.size() == N)) {
            toAdd++; // distance increase
            for (String c: connections) {
                User tmpUser = getUser(c); // get our user
                Set<String> tmpUserConns = tmpUser.getConnections(); // get this current users connections
                for (String conn : tmpUserConns) {
                    if (!connections.contains(conn) && !conn.equals(uA)) { // if there is a new connection not yet found
                        connections.add(conn); // add it to our connections and increment our counters
                        sum += toAdd;
                        if (connections.size() == N) { // we have found all connections
                            return (double) N / (double) sum ; // return value
                        }
                    }
                }
            }
        }
        return (double) (N-1)/ (double) sum; // if we reach here return value
    }
}
