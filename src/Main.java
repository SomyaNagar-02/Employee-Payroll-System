import javax.xml.xpath.XPathEvaluationResult;
import java.util.ArrayList;

abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }
  public String getName(){
        return name;
  }
  public int getId(){
        return id;
  }

  public abstract double calculateSalary();

   @Override
    public String toString(){
       return "Employee[name="+name+" ,id="+id+",salary="+calculateSalary()+"]";
   }
}

class FullTimeEmployee extends Employee{
    private double monthSalary;
    public FullTimeEmployee(String name,int id,double monthlySalary){
        super(name,id);
        this.monthSalary=monthlySalary;
    }

    @Override
    public double calculateSalary(){
        return monthSalary;
    }
}

class PartTimeEmployee extends Employee{
    private int hoursworked;
    private double hourlyRate;

    public PartTimeEmployee(String name,int id,int hoursworked,double hourlyRate){
        super(name, id);
        this.hoursworked=hoursworked;
        this.hourlyRate=hourlyRate;
    }

    @Override
    public double calculateSalary(){
        return hoursworked*hourlyRate;
    }
}

class PayrollSystem{
    private ArrayList<Employee> employeeList;
    public PayrollSystem(){
        employeeList=new ArrayList<>();
    }

    public void addemployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove=null;
        for(Employee employee: employeeList){
            if(employee.getId()==id){
                employeeToRemove=employee;
                break;
            }
        }
       if(employeeToRemove!=null){
           employeeList.remove(employeeToRemove);
       }
    }
    public void displayEmployee(){
        for(Employee employee:employeeList){
            System.out.println(employee);
        }
    }
}

public class Main{
    public static void main(String[] args) {
        PayrollSystem payroollSystem=new PayrollSystem();
        FullTimeEmployee emp1=new FullTimeEmployee("Aakash",1,70000);
        PartTimeEmployee emp2=new PartTimeEmployee("Arina",2,2,1000);

        payroollSystem.addemployee(emp1);
        payroollSystem.addemployee(emp2);
        System.out.println("Initial employee details: ");
        payroollSystem.displayEmployee();
        System.out.println("Removing Employee");
        payroollSystem.removeEmployee(2);
        System.out.println("Remaining Employees details: ");
        payroollSystem.displayEmployee();

    }
}