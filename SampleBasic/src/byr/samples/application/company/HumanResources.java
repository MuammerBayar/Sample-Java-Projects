package byr.samples.application.company;

public class HumanResources {
    //...
    public void payInsurance(Employee employee)
    {
        System.out.printf("Citizen Id:%s%n", employee.getCitizenId());
        System.out.printf("Name:%s%n", employee.getName());

        //...
        System.out.println("------------------");
    }
}