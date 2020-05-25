import java.util.Scanner;

public class Main {

    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        String gender;      //male or female converted to LOWERCASE
        double weight;      //weight in pounds
        int height;     //height in inches
        int waistNarrow;        //measurement in inches around waist at narrowest part
        int hipSize;        //hip size
        int daysPerWeek;       //number of days per week working out
        double BMI_Index;       //BMI = weight / (height^2)
        double waistHip_Ratio;   //waistNarrow/hipSize
        double waistHeight_Ratio;    //hipSize/height

        System.out.println("This program will give you a better idea " +
                "as to how good of shape you are in based on a few basic metrics");
        System.out.println("First indicate your gender. Type Male or Female and press enter.");
        gender = scan.nextLine().toLowerCase();

        System.out.println("Please enter your most recently measured weight.");
        weight = scan.nextDouble();

        System.out.println("Now your height in this format: feet,inches");
        String[] ftHeight = scan.nextLine().split(",");
        //int feet = Integer.parseInt(ftHeight[0]);
        //int inches = Integer.parseInt(ftHeight[1]);
        //height = (feet * 12) + inches;
        height = ((Integer.parseInt(ftHeight[0])) *12) + (Integer.parseInt(ftHeight[1]));       //height = (first array value * 12) + (second array value)

        System.out.println("Now measure around your waist at the narrowest part. Enter the value in inches. \n(this is usually just above the belly button)");
        waistNarrow = scan.nextInt();

        System.out.println("Measure the circumference of your hips at the widest part and enter the value in inches.");
        hipSize = scan.nextInt();

        System.out.println("How many days of the week do you workout or have physical activity?");
        daysPerWeek = scan.nextInt();

        BMI_Index = (weight * 703) / (height * height);
        System.out.println("Your BMI (body mass index) is "+ BMI_Index);

        waistHip_Ratio = waistNarrow/hipSize;
        System.out.println("Your waist to hip ratio is " + waistHip_Ratio);

        waistHeight_Ratio = hipSize/height;
        System.out.println("Your Waist to Height Ratio is "+ waistHeight_Ratio);

        Person newPerson = new Person(gender, daysPerWeek, BMI_Index, waistHip_Ratio, waistHeight_Ratio);

        


    }
}
