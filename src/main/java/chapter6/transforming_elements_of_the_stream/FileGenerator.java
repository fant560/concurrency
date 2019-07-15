package chapter6.transforming_elements_of_the_stream;

import java.util.ArrayList;
import java.util.List;

public class FileGenerator {

    public static List<String> generateFile(int size){
        List<String> file = new ArrayList<>();
        for (int i = 0; i < size; i++){
            file.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi lobortis " +
                    "cucsus venenatis. Mauris tempus elit ut malesuada luctus. Interdum et malesuada fames" +
                    "ac ante ipsum primis in faucibus. Phasellus laoreet sapien eu pulvinar rhoncus. Integer " +
                    "val ultricis leo. Donec vel sagittis nibh. Maecenas eu quam non est hendrerit pu");
        }
        return file;
    }

}
