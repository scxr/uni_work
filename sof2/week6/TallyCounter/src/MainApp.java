public class MainApp {
    public static void main(String[] args) {
        TallyCounter tallyCount = new TallyCounter();
        System.out.println(tallyCount.toString());
        tallyCount.increment();
        System.out.println(tallyCount.read());
        tallyCount.reset();
        System.out.println(tallyCount.read());
    }
}
