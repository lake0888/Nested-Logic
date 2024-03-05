import java.util.Date;
import java.util.Scanner;
import java.util.stream.Stream;

class Main {
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        
        //RETURNED DATE
        String returned = getDate();
        String[] returnedDate = returned.split(" ");

        //DUE DATE
        String due = getDate();
        String[] dueDate = due.split(" ");

        int fee = calculateFee(returnedDate, dueDate);
        System.out.println(fee);
    }

    public static String getDate() {
        String pattern = "\\d{1,2}\\s\\d{1,2}\\s\\d{1,4}";
        String text;
        do {
            text = scanner.nextLine();
        } while (!text.matches(pattern));
        return text;
    }

    public static int calculateFee(String[] returnedDate, String[] dueDate) {
        int d1 = Integer.parseInt(returnedDate[0]);
        int m1 = Integer.parseInt(returnedDate[1]);
        int y1 = Integer.parseInt(returnedDate[2]);

        int d2 = Integer.parseInt(dueDate[0]);
        int m2 = Integer.parseInt(dueDate[1]);
        int y2 = Integer.parseInt(dueDate[2]);

        if (y1 > y2) {
            return 10000;
        } else if (y1 == y2) {
            if (m1 > m2) {
                return 500 * (m1 - m2);
            } else {
                if (d1 > d2) {
                    return 15 * (d1 - d2);
                } else {
                    return 0;
                }
            }
        } else {
            return 0;
        }
    }
}