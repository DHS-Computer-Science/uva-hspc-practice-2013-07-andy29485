//Andriy Zasyppkin
//2016-03-TODO
//Practice 2013 - 07: Robot In A Room

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int nCases = scan.nextInt(); scan.nextLine();
    char[][] map;

    case_loop:
    for(int nCase=1; nCase<=nCases; nCase++) {
      System.out.printf("Case %d: ", nCase);

      final int SIZE = scan.nextInt();
      final int BATT = scan.nextInt(); scan.nextLine();

      int nBat = BATT;
      int nDir = 0;
      int nMin = 0;
      map = new char[SIZE][SIZE];

      for(int i=0; i<map.length; i++) {
        map[i] = scan.nextLine().toCharArray();
      }

      step_loop:
      while(nBat > 0) {
        nMin++;
        nBat--;
        for(int i=0; i<SIZE; i++) {
          for(int j=0; j<SIZE; j++) {
            if(map[i][j] == 'r') {
              if(nDir == 0) {
                if(map[i][j+1] == 'x') {
                  nDir++;
                  nDir%=4;
                }
                else if(map[i][j+1] == 'm') {
                  System.out.println(nMin);
                  continue case_loop;
                }
                else if(map[i][j+1] == 'p' && nBat <= BATT/2) {
                  nMin += BATT-nBat;
                  nBat = BATT;
                }
                else {
                  map[i][j+1] = 'r';
                  map[i][j] = '-';
                }
              }
              else if(nDir == 1) {
                if(map[i+1][j] == 'x') {
                  nDir++;
                  nDir%=4;
                }
                else if(map[i+1][j] == 'm') {
                  System.out.println(nMin);
                  continue case_loop;
                }
                else if(map[i+1][j] == 'p' && nBat <= BATT/2) {
                  nMin += BATT-nBat;
                  nBat = BATT;
                }
                else {
                  map[i+1][j] = 'r';
                  map[i][j] = '-';
                }
              }
              else if(nDir == 2) {
                if(map[i][j-1] == 'x') {
                  nDir++;
                  nDir%=4;
                }
                else if(map[i][j-1] == 'm') {
                  System.out.println(nMin);
                  continue case_loop;
                }
                else if(map[i][j-1] == 'p' && nBat <= BATT/2) {
                  nMin += BATT-nBat;
                  nBat = BATT;
                }
                else {
                  map[i][j-1] = 'r';
                  map[i][j] = '-';
                }
              }
              else if(nDir == 3) {
                if(map[i-1][j] == 'x') {
                  nDir++;
                  nDir%=4;
                }
                else if(map[i-1][j] == 'm') {
                  System.out.println(nMin);
                  continue case_loop;
                }
                else if(map[i-1][j] == 'p' && nBat <= BATT/2) {
                  nMin += BATT-nBat;
                  nBat = BATT;
                }
                else {
                  map[i-1][j] = 'r';
                  map[i][j] = '-';
                }
              }
              continue step_loop;
            }
          }
        }
      }
      System.out.println("NEVER");
    }

    System.exit(0);
  }
}
