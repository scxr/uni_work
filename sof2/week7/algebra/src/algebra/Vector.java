package algebra;
import java.util.Arrays;
public class Vector {
    double[] vector;

    public Vector(double[] vector_sent) {
        vector = vector_sent;   
        
    }

    public String toString() {
        String result = Arrays.toString(vector);
        return result;
    }

    int size() {
        return vector.length;
    }
    
    double get(int index) throws InvalidDimensionException {
        if (index <0 || index > vector.length) {
            throw new InvalidDimensionException("Invalid dimension");
        }
        return vector[index];
        
    }

    Vector scalarProduct(double scalar) {
        return new Vector(Arrays.stream(vector).map(x->x*scalar).toArray());
    }

    double set(int index, double value) throws InvalidDimensionException {
        if (index < 0 || index >= vector.length) {
            throw new InvalidDimensionException("Invalid dimensions");
        }
        double old_value = vector[index];
        vector[index] = value;
        return old_value;
    }

    Vector add(Vector other) throws InvalidDimensionException, IncompatibleDimensionException {
        Vector copy_vector = new Vector(vector);
        if (copy_vector.size() != other.size()) {
            throw new IncompatibleDimensionException("Not equal");
            
        } else {
            for (int i = 0; i < copy_vector.size(); i++) {
                double a = copy_vector.get(i);
                double b = other.get(i);
                copy_vector.set(i, a+b);
            }
        }
        return copy_vector;
    }

    public static void main(String[] args) {
        double[] arg = {1,2,3};
        double[] arg2 = {3,4,1,5};
        Vector my_vector = new Vector(arg);
        Vector other = new Vector(arg2);
        System.out.print(my_vector.scalarProduct(3.0).toString());
        
        
    }
}