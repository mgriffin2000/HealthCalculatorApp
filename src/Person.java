public class Person {
    String gend;
    int daysWeek;
    double BMI;
    double waist_Hip;
    double waist_Height;
    String healthStatus;

    public Person(String gender, int numDaysOfWeek, double bodyMass, double hipRatio, double heightRatio)    {      //creates person object that contains all the data about that person
        gend = gender;
        daysWeek = numDaysOfWeek;
        BMI = bodyMass;
        waist_Hip = hipRatio;
        waist_Height = heightRatio;

    }

    public String getGend() {
        return gend;
    }

    public String checkBMI()   {
        if (BMI <= 18.5)        //check BMI and returns string with status of BMI
            return "underweight";
        else if ((BMI > 18.5) && (BMI <= 24.9))
            return "ideal";
        else if ((BMI > 25) && (BMI <= 29.9))
            return "overweight";
        else
            return "obese";
    }

    public String cardioDisease()   {       //returns whether person is at risk for cardiovascular disease or not based on waist to hip ratio
        String cvdStatus = "";
        if (gend == "male")  {      //if person is male
            if (waist_Hip <= 0.9)
                cvdStatus = "low risk";
            if ((waist_Hip > 0.9) && (waist_Hip <= 0.99))
                cvdStatus = "moderate risk";
            else
                return "high risk";
        }   else {          //if person is female
            if (waist_Hip <= 0.8)
                cvdStatus = "low risk";
            if ((waist_Hip > 0.8) && (waist_Hip <= 0.89))
                cvdStatus = "moderate risk";
            else
                return "high risk";
        }

        return cvdStatus;
    }

    public String healthyWeight()   {       //if waist_height ratio is less than a 0.5, they have a healthy weight
                                            //if less than 0.5 they have a lower risk of a number of life threatening health complications including: heart attacks, strokes, diabetes, and hypertension
        if (waist_Height <= 0.5)
            return "healthy weight";
        else return "unhealthy weight";

    }

    public String getOverallHealthStatus() {

        return healthStatus;        //return overall health status of individual
    }


}
