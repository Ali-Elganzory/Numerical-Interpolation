package Interpolation;
import java.util.Scanner;

/**
 * Lagrange *
 * 
 * @author AhmedSalah
 */
public class Lagrange {

    public int size;
    private Scanner sc = new Scanner(System.in);
    private float []X;
    private float []y; 
    private float vals[]; 
    private double value;
    private double result=0;
    private boolean isOn = true;
    
    public Lagrange(int size){
        this.size = size;
        X = new float[size];
        y = new float[size];
        vals = new float[size];
    }
    
    public  Lagrange(float []X, float []y){

        this(X.length);   //initialize the size of the array
        this.X = X;     //initialize the array of X values
        this.y = y;     //initialize the array of y values
        
        while (isOn){

            System.out.printf("Input value: ");
            this.value = sc.nextDouble();     //taking value from user
            for (int i = 0; i < size; i++) {
                float divs = 1;     //to calculate the denomenator of each term
                float ups = 1;      //to calculate numenator of each term
                for(int j = 0; j < size; j++){
                    if (X[i] == this.X[j])   //skip the current term as in lagrange formula
                    continue;
                    ups*=(this.value-X[j]); //calculate numenator in current term
                    divs *= (X[i] - X[j]);  //calculte denomenator in current term
                }
                
                this.vals[i] = (ups*this.y[i]) / divs;  // multiply the term with the current y and store in array
            }
            
            //adding the array elements inside the array of values (vals)
            for (int i = 0; i < size; i++) {
                this.result += vals[i];
            }
            System.out.printf("Output: %.2f\n", this.result);

            //take another value or not
            System.out.printf("take another value (true or false): ");
            this.isOn = sc.nextBoolean();     // see whether the user wants to continue or not
            if(isOn ==true) this.result = 0;  // initialzing the value of result to 0
            System.out.println("");
        }
        
    }
    
    //return the result
    public double getValue(){
        return this.result;
    }

}