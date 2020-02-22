package Interpolation;

import java.util.Scanner;

public class Interpolation {

  // Newton's 'divided-difference' interpolation method 

  public static void newton_general() {

    Scanner sc = new Scanner(System.in); // for receiving console input

    System.out.print("No. of points: ");
    int ptsNum = sc.nextInt(); // enter the number (x, y) points you're willing to provide
    float[] xs = new float[ptsNum]; // to store [x] points
    float[] ys = new float[ptsNum]; // to store [y] points

    System.out.println("Enter points in pairs:  (x, y)");

    for (int i = 0; i < ptsNum; i++) { // storing (x, y) points in [xs] & [ys] arrays respectively
      xs[i] = sc.nextFloat();
      ys[i] = sc.nextFloat();
    }

    for (int i = 1; i < ptsNum; i++) { // loop for ∇y's (e.g. ∇y, ∇²y, ...)
      // loop for the sub-array of same ∇ level indices[ptsNum - 1 down to i]
      for (int j = ptsNum - 1; j >= i; j--) {
        ys[j] = (ys[j] - ys[j - 1]) / (xs[j] - xs[j - i]);
      }
    }

    short play = 1; // flag for 're-interpolating' a new [x] point

    while (play == 1) {
      System.out.print("Enter an X to find its Y: ");
      float x = sc.nextFloat();

      float res = ys[0], coef = 1;
      for (int i = 1; i < ptsNum; i++) {
        coef *= (x - xs[i - 1]);
        res += coef * ys[i];
      }

      System.out.println(res);
      System.out.print("Another X? press 1 for yes, else 0:  ");
      play = sc.nextShort();
    }

    sc.close();

  }

}
