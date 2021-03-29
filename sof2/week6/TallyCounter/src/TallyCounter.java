public class TallyCounter {
    private int counter;
    private int size;
    public TallyCounter() {
        counter = 0;
        size=3;
    }

    public TallyCounter(int size) {
        counter = 0;
        size = size;
    }

    public String toString(){
        if (counter<100) {
            return "0".repeat(size - String.valueOf(counter).length()) + String.valueOf(counter); 
        } else {
            return String.valueOf(counter);
        }
    }

    public void increment() {
        if (counter == 999) {
            counter = 0;
        } else {
            counter++;
        }
    }

    public String read() {
        return toString();
    }

    public void reset() {
        counter = 0;
    }
}
