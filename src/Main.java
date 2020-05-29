import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String gender;      //male or female converted to LOWERCASE
        double weight;      //weight in pounds
        double height;     //height in inches
        double waistNarrow;        //measurement in inches around waist at narrowest part
        double hipSize;        //hip size
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
        scan.nextLine();
        System.out.println("Now your height in this format: feet,inches");
        String inputHeight = scan.next();
        String[] ftHeight = inputHeight.split(",");
        //int feet = Integer.parseInt(ftHeight[0]);
        //int inches = Integer.parseInt(ftHeight[1]);
        //height = (feet * 12) + inches;
        height = ((Integer.parseInt(ftHeight[0])) * 12) + (Integer.parseInt(ftHeight[1]));       //height = (first array value * 12) + (second array value)

        System.out.println("Now measure around your waist at the narrowest part. Enter the value in inches. \n(this is usually just above the belly button)");
        waistNarrow = scan.nextInt();

        System.out.println("Measure the circumference of your hips at the widest part and enter the value in inches.");
        hipSize = scan.nextInt();

        System.out.println("How many days of the week do you workout or have physical activity?");
        daysPerWeek = scan.nextInt();

        BMI_Index = (weight * 703) / (height * height);
        System.out.println("Your BMI (body mass index) is " + BMI_Index);

        waistHip_Ratio = waistNarrow / hipSize;
        System.out.println("Your waist to hip ratio is " + waistHip_Ratio);

        waistHeight_Ratio = hipSize / height;
        System.out.println("Your waist to Height Ratio is " + waistHeight_Ratio);

        Person newPerson = new Person(gender, daysPerWeek, BMI_Index, waistHip_Ratio, waistHeight_Ratio);

        System.out.println(newPerson.getGend());
        System.out.println(newPerson.checkBMI());
        System.out.println(newPerson.cardioDisease());
        System.out.println(newPerson.healthyWeight());

        if (((newPerson.cardioDisease().compareTo("low risk") == 0) ||
                (newPerson.cardioDisease().compareTo("moderate risk") == 0)) && newPerson.healthyWeight() == true) {
            System.out.println("You are probably in pretty good shape and should not worry too much about cardiovascular disease complications. \n " +
                    "Keep working out and stay healthy");

        } else if (daysPerWeek <= 4) {
            System.out.println("In order to lower your risk for cardiovascular complications or other serious health problems in the future, \n " +
                    "you should probably increase the number of times you workout per week");
            System.out.println("Would you like to save your current data to a file on this device for future comparison? Type yes or no:");
            String response = scan.next();
            if (response.compareToIgnoreCase("yes") == 0) {
                System.out.println("What is your last name?");
                String lastName = scan.next();
                String date;
                System.out.println("What is today's date? mm.dd.yyyy");
                date = scan.next();
                //call class that writes all saved info in newPerson to a file
                writeFile(newPerson, lastName, date);
            }   else {
                System.out.println("Ok have a nice day!");
            }
        }
    }

    public static void writeFile(Person newPerson, String name, String date) {
        try {
            File healthRecord = new File("C:\\Users\\mgriffin\\Documents\\CS Projects\\HealthRecords" + name + date + ".txt");
            if (healthRecord.createNewFile())   {
                System.out.println("File name created: " + healthRecord.getName());
            }   else    {
                System.out.println("File already exists");
            }

            FileWriter fw = new FileWriter(healthRecord.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(name + " " + date + "\n" + newPerson.toString());     //write toString to file
            bw.close();     //close writing stream

        } catch (IOException exception) {
            System.out.println("Unable to create file");

        }

    }
}
