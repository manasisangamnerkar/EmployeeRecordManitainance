package assignment5;

import java.util.Scanner;
class person
{
    int pin;
    String apartmentName,apartmentNumber,road,name;
    Scanner sc=new Scanner(System.in);

    void accept()
    {
        System.out.println("NAME:");
        name = sc.nextLine();

        System.out.println("\nADDRESS DETAILS\n APARTMENT NAME: ");
        apartmentName=sc.nextLine();

        System.out.println("\n APARTMENT NUMBER:");
        apartmentNumber=sc.nextLine();

        System.out.println("\n ROAD NAME:");
        road=sc.nextLine();

        System.out.println("\n PIN CODE:");
        pin=sc.nextInt();
    }

    void display()
    {
        System.out.println("\n EMPLOYEE NAME:"+name+"\n ADDRESS:"+apartmentNumber+","+apartmentName+","+road+","+pin);
    }
}

class employee extends person
{
    double basicSalary;
    String empId;
    double houseAllowance,dearAllowance,tax,home,gross;

    void accept()
    {  super.accept();

        System.out.println("ENTER THE EMPLOYEE ID:");
        empId=sc.next();

        System.out.println("ENTER THE BASIC SALARY:");
        basicSalary=sc.nextDouble();
    }

    void gross()
    {
        tax=0.07*basicSalary;
        houseAllowance=0.2*basicSalary;
        dearAllowance=0.45*basicSalary;
        gross= basicSalary+houseAllowance+dearAllowance;
        home=gross-tax;
    }
    void display()
    {
        super.display();
        gross();
        System.out.println("");
    }
}

public class Main{
    public static void main(String[]args){

        Scanner sc=new Scanner(System.in);
        int i=0,n=0,a=0,ch,d;

        System.out.println("Enter number of employees:");
        n=sc.nextInt();
        employee[]obj=new employee[n];
        person[]obj_1=new person[a];
        for(i=0;i<n;i++)
        {
            obj[i]= new employee ();
            System.out.println("Employee"+(i+1)+":");
            obj[i].accept();

        }
        System.out.println("Details of all Employees:\n");
        for(i=0;i<n;i++)
        {
            System.out.println("\nEmployee"+ (i+1)+ ":");
            obj[i].gross();
            obj[i].display();
        }

        do{
            System.out.println("INFORMATION REQUIRED:");
            System.out.println("1.Display salary of all employees\n2.Display Information as per ID\n3.Display information as per Pin\nEnter Your Choice");
            ch=sc.nextInt();
            switch(ch)
            {
                case 1:System.out.println("Salary Info of All Employees:");
                    for(i=0;i<n;i++)
                    {
                        System.out.println("\nEmployee"+(i+1)+":");
                        obj[i].display();
                    }
                    break;

                case 2:

                    System.out.println("INFORMATION AS PER ID:");
                    for(i=0;i<n;i++)
                    {
                        obj[i].accept();
                    }
                    break;

                case 3:

                    System.out.println("INFORMATION AS PER PIN:");
                    for(i=0;i<n;i++)
                    {

                        obj[i].display();
                    }
                    break;

                default: System.out.println("INVALID CHOICE");
            }

            System.out.println("press 1 to continue else press 0 to exit");

            d=sc.nextInt();
        }
        while(d==1);

    }
}




