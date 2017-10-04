import java.io.*;
import java.util.Formatter;

public class FileSystem {

    private static final String FILENAME = "todo/todos.txt";

    static Formatter output;

    public static void writeToFile(String todo) {

        FileWriter fw = null;
        BufferedWriter bw = null;

        try {

            File file = new File(FILENAME);
            file.getParentFile().mkdirs();
            file.createNewFile();

            fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);

            bw.write(todo);

        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            try {

                if ( bw != null ) // Check if the file is open
                    bw.close(); // Close the file

                if ( fw != null ) // Check if the file is open
                    fw.close(); // Close the file

            } catch (IOException e) {

                e.printStackTrace();

            }

        }
    }


    public static void printTodos() throws IOException {

        FileReader fr = null;
        BufferedReader br = null;

        try {

            if ( numberOfLines() == 0 ) {
                System.out.println("Nothing to see here..." + System.lineSeparator());
                return;
            }

            File file = new File(FILENAME);
            file.getParentFile().mkdirs();
            file.createNewFile();

            fr = new FileReader(file);
            br = new BufferedReader(fr);

            String currentLine;

            for ( int i = 0; (currentLine = br.readLine()) != null; i++ ) {
                System.out.printf("%d - %s", i + 1, currentLine);
                System.out.println(System.lineSeparator());
            }


        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            if ( br != null )
                br.close();

            if ( fr != null )
                fr.close();

        }

    }

    public static void clearTodo() {

        FileWriter fw = null;
        BufferedWriter bw = null;

        try {

            File file = new File(FILENAME);
            file.getParentFile().mkdirs();
            file.createNewFile();

            fw = new FileWriter(FILENAME);
            bw = new BufferedWriter(fw);

            bw.write("");


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Integer numberOfLines() throws IOException {

        Integer numberOfLines = 0;

        FileReader fr = null;
        BufferedReader br = null;

        try {

            File file = new File(FILENAME);
            file.getParentFile().mkdirs();
            file.createNewFile();

            fr = new FileReader(file);
            br = new BufferedReader(fr);

            Integer i = 0;

            while ( br.readLine() != null )
                i++;

            numberOfLines = i;

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            if ( br != null )
                br.close();

            if ( fr != null )
                fr.close();

        }

        return numberOfLines;

    }

    public static void deleteFile() throws IOException {

        File file = new File(FILENAME);

        if (numberOfLines() == 0) {
            file.delete();
        }

        File directory = new File(file.getParent());
        directory.delete();

    }

}
