import com.google.gson.Gson;
import data.InputFileFormat;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by alex on 7/15/16.
 */
public class Main {

    public static void main(String args[]) {
        if (!IsValidArgs(args)) {
            System.out.println("Incorrect arguments!");
            return;
        }

        InputFileFormat inputFileFormat = GetObjectFromFile(args[0]);
        if (inputFileFormat == null) return;

        Uploader uploader = new Uploader(inputFileFormat);
        uploader.upload();

    }

    /**
     * Read object from file
     * @param fileName
     * File name
     * @return
     * Object format file
     */
    private static InputFileFormat GetObjectFromFile(String fileName) {
        InputFileFormat inputFileFormat = null;
        Gson gson = new Gson();

        try {
            BufferedReader br = new BufferedReader(
                    new FileReader(fileName));

            inputFileFormat = gson.fromJson(br, InputFileFormat.class);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return inputFileFormat;
    }

    /**
     * Check console arguments
     * @param args
     * Console arguments
     * @return
     * Is valid arguments
     */
    private static boolean IsValidArgs(String[] args) {
        return args != null && args.length >= 1 && !(args[0] == null || args[0].length() == 0);
    }
}
