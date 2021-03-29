public class main{
    public static void main(String[] args) {
        ArraySet<String> arraySet = new ArraySet<String>(5);
        System.out.print(arraySet.add("hello"));
        
        arraySet.add("world");
        System.out.println(arraySet.contains("hello"));
        System.out.print(arraySet.contents());
    }
}