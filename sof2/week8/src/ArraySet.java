import java.security.PublicKey;
import java.util.Arrays;

public class ArraySet<T> implements ISet<T>{
    //private T t;
    private T data[];

    @SuppressWarnings("unchecked")
    public ArraySet(int size) {
        data = (T[]) new Object[size];
    }
    
    @Override
    public boolean add(T element) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = element;
                return true;
            }
        }
        return true;
    }
    @Override
    public void clear() {
        Arrays.fill(data, null);
    }
    @Override
    public boolean contains(T element) {
        for (int i=0;i<data.length;i++) {
            if (data[i] == element) {
                System.out.print(data[i]);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        for (int i=0;i<data.length;i++) {
            if (data[i] != null) {
                return false;
            }
        }
        return true;
    }
    @Override
    public boolean remove(T element) {
        for (int i=0; i<data.length;i++) {
            if (data[i] == element) {
                data[i] = null;
                return true;
            }
        
        }
        return false;
    }
    @Override
    public int size() {
        return data.length;
    }

    public String contents() {
        return Arrays.toString(data);
    }

}
