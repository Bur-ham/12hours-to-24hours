import java.util.Scanner;


class ConvertFrom12To24Hours {

    public static int countDigits(int n) {
        int digits = (int) Math.log10(n);
        return digits + 1;
    }

    public static String ConvertFrom12To24HoursFormat(String s) throws Exception {
        int firstPart, secondPart;

        if (s.contains("am")) {
            s = s.replace("am", "").strip();
            String[] time = s.split(":");

            if (time[0].equals("12")) {
                firstPart = 0;
            } else {
                firstPart = Integer.parseInt(time[0]);
            }
            
            secondPart = Integer.parseInt(time[1]);
        } else if (s.contains("pm")) {
            s = s.replace("pm", "").strip();
            String[] time = s.split(":");

            if (time[0].equals("12")) {
                firstPart = 12;
            } else {
                firstPart = Integer.parseInt(time[0]) + 12;
            }

            secondPart = Integer.parseInt(time[1]);
        } else {
            throw new Exception("Invalid time format");
        }

        return String.format("%02d:%02d", firstPart, secondPart);
        
    }

    public static void reverseArray(int[] arr) {
        int a;
        int b;
        for (int i = 0; i < arr.length / 2; i++) {
            a = arr[i];
            b = arr[arr.length - i - 1];
            arr[i] = b;
            arr[arr.length - i - 1] = a;
        }
    }

    public static void main(String[] args) {
        // System.out.println(twoSum(new int[] {2, 7, 11, 15}, 9));
        Scanner res = new Scanner(System.in);
        try {
            System.out.print("Enter a time in 12-hour format: ");
            String s = res.nextLine();
            System.out.println("24-hour format of " + s + ": " + ConvertFrom12To24HoursFormat(s));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        res.close();
    }
}