package util;

import java.io.*;

public class RerunFile {

    public static void getRerunFile() throws IOException {

        File dir = new File("D:\\Mesoka_BDD\\target\\rerun");

        // create obejct of PrintWriter for output file
        PrintWriter pw = new PrintWriter("D:\\Mesoka_BDD\\target\\rerun.txt");

        // Get list of all the files in form of String Array
        String[] fileNames = dir.list();

        // loop for reading the contents of all the files
        // in the directory GeeksForGeeks
        for (String fileName : fileNames) {
            System.out.println("Reading from " + fileName);

            // create instance of file from Name of
            // the file stored in string Array
            File f = new File(dir, fileName);

            // create object of BufferedReader
            BufferedReader br = new BufferedReader(new FileReader(f));
            //pw.println("Contents of file " + fileName);

            // Read from current file
            String line = br.readLine();
            System.out.println("content is" +line);
            while (line != null) {

                // write to the output file
                pw.println(line);
                line = br.readLine();
            }
            pw.flush();
        }
        System.out.println("Reading from all files" +
                " in directory " + dir.getName() + " Completed");
    }

}
