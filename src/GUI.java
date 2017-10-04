import java.io.IOException;
import java.util.Scanner;

public class GUI extends FileSystem {

    GUI() throws IOException {

        boolean toContinue = true;

        while (toContinue) {

            System.out.println("Hello!" + System.lineSeparator() +
                "Welcome to the To-Do App!" + System.lineSeparator() +
                "Please choose one of the below" + System.lineSeparator() +
                "1. List To-Do's" + System.lineSeparator() +
                "2. Add a new To-Do" + System.lineSeparator() +
                "3. Clear the To-Do list" + System.lineSeparator() +
                "4. Quit" + System.lineSeparator());

            Scanner input = new Scanner(System.in);

            byte choseWhich = input.nextByte();
            input.nextLine();

            switch (choseWhich) {
                case 1:
                    FileSystem.printTodos();
                    break;
                case 2:
                    System.out.println("Enter the To-Do!");
                    String todo = input.nextLine();

                    if (todo.length() == 0) {
                        System.out.println("You haven't entered anything!");
                        break;
                    }

                    FileSystem.writeToFile(todo);
                    break;
                case 3:
                    FileSystem.clearTodo();
                    System.out.println("To-Do list is cleared!" + System.lineSeparator());
                    break;
                case 4:
                    toContinue = false;
                    FileSystem.deleteFile();
                    break;

                default:
                    System.out.println("Please enter a number between 1-3!");
                    break;
            }

        }

    }

}
