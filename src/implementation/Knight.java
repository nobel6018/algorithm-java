package implementation;

import java.util.Scanner;

public class Knight {

    private static int dx[] = {-2, -2, 2, 2, -1, -1, 1, 1};
    private static int dy[] = {-1, 1, -1, 1, -2, 2, -2, 2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String inputData = sc.nextLine();
        int x = inputData.charAt(0) - 'a';
        int y = inputData.charAt(1) - '1';


        int answer = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < 8 && ny < 8) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}

/*
a1
* */
// expecting: 2

/*
c2
* */
// expecting: 6

/*
e4
* */
// expecting: 8