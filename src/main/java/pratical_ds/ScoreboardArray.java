package pratical_ds;

class ScoredboardArray {
    private int numEntries = 0; // number of actual entries
    private GameEntry[] board; // array of game entries (names & scores)

    /**
     * Constructs an empty scoreboard with the given capacity for storing entries.
     */
    public ScoredboardArray(int capacity) {
        board = new GameEntry[capacity];
    }

    public class GameEntry {
        private String name;
        private int score;

        /** Constructs a game entry with given parameters */
        public GameEntry(String n, int s) {
            name = n;
            score = s;
        }

        /** Returns the name field */
        public String getName() {
            return name;
        }

        /** Returns the score field */
        public int getScore() {
            return score;
        }

        /** Returns a string representation of this entry */
        public String toString() {
            return "(" + name + ", " + score + ")";
        }
    }

    /** Attempt to add a new score to the collection (if it is high enough) */
    public void add(GameEntry e) {
        int newScore = e.getScore();
        // is the new entry e really a high score?
        if (numEntries < board.length || newScore > board[numEntries - 1].getScore()) {
            if (numEntries < board.length) // no score drops from the board
                numEntries++; // so overall number increases
            // shift any lower scores rightward to make room for the new entry
            int j = numEntries - 1;
            while (j > 0 && board[j - 1].getScore() < newScore) {
                board[j] = board[j - 1];
                j--;
            }
            board[j] = e;
        }

    }

    /** Remove and return the high score at index i. */
    public GameEntry remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= numEntries)
            throw new IndexOutOfBoundsException("Invalid index: " + i);

        GameEntry temp = board[i]; // save the object to be removed

        for (int j = i; j < numEntries - 1; j++) // count up from i (not down)
            board[j] = board[j + 1]; // move one cell to the left

        board[numEntries - 1] = null; // null out the old last score
        numEntries--;

        return temp; // return the removed object
    }

    /** Returns a string representation of the scoreboard */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Scoreboard: [");
        for (int i = 0; i < numEntries; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(board[i].toString());
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        // Create a scoreboard with capacity of 5
        ScoredboardArray scoreboard = new ScoredboardArray(5);

        // Add some test scores
        scoreboard.add(scoreboard.new GameEntry("Alice", 100));
        scoreboard.add(scoreboard.new GameEntry("Bob", 85));
        scoreboard.add(scoreboard.new GameEntry("Carol", 95));
        scoreboard.add(scoreboard.new GameEntry("David", 80));

        // Print initial scoreboard
        System.out.println("Initial " + scoreboard);

        // Test adding a high score
        scoreboard.add(scoreboard.new GameEntry("Eve", 98));
        System.out.println("After adding Eve's score: " + scoreboard);

        // Test adding a low score (shouldn't be added)
        scoreboard.add(scoreboard.new GameEntry("Frank", 70));
        System.out.println("After trying to add Frank's score: " + scoreboard);

        // Test removing a score
        GameEntry removed = scoreboard.remove(1);
        System.out.println("Removed: " + removed);
        System.out.println("After removing index 1: " + scoreboard);

        // Test adding after removing
        scoreboard.add(scoreboard.new GameEntry("Frank", 70));
        System.out.println("After trying to add Frank's score: " + scoreboard);

    }
}