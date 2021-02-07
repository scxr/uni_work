import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class excersise2 {
    public static void main(String[] args) {
        System.out.print(Arrays.asList(split("hello world lol test")));
    }

    public static String[] split(String text) {
		if (text == null) {
			return null;
		}
		int len = text.length();
		if (len == 0) {
			return null;
		}
		List<String> list = new ArrayList<String>();
		int temp =0;
		int fromIndex = 0;
		while (temp>=0){
			temp = text.indexOf(" ",fromIndex);
			if(temp<0){
				list.add(text.substring(fromIndex,len));
				break;
			}else{
				list.add(text.substring(fromIndex,temp));
			}
			fromIndex = temp+1;
		}
		String[] arr = new String[list.size()];
		list.toArray(arr);
		return arr;
	}
}

