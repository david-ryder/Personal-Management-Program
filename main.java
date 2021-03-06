import java.util.*;
import java.lang.*;

/*
 * Java project 1
 * David Winfield
 * Madelyn Glickman
 * Christian Samson
 */

public class Project1 {
	
	static class Student {
		String name;
		String id;
		double gpa;
		int credit_hours;
	}
	
	static class Faculty {
		String name;
		String id;
		String department;
		String rank;
	}
	
	static class Staff {
		String name;
		String id;
		String department;
		String status;
	}
	
	
	public static void main(String[] args)
	{

		Scanner scnr = new Scanner(System.in);
		
		Student student_1 = new Student(); // create new students
		Student student_2 = new Student();
		
		Faculty faculty_1 = new Faculty(); // create new faculty
		
		Staff staff_1 = new Staff(); // create new staff

	    boolean facultyEntered = false; // catch statements so program wont try to print info that doesn't exist
	    boolean studentsEntered = false;
	    boolean staffEntered = false;
	    boolean exit = false;
    
	    System.out.println("\t\tWelcome to my Personal Management Program\n\n");
	    
	    while(!exit)
	    {
	      switch (menu(scnr)) 
	      {
	        case 1:
	          facultyEntered = createFaculty(faculty_1, scnr); // create faculty function
	          break;
	
	        case 2:
	        	if(studentsEntered)
	            {
		            System.out.println("You already have two students filled in. Do you want to update their information? \n Yes or no?");
		            String input = scnr.nextLine();
		            
		            if (!input.toLowerCase().equals("yes"))
		            	break;
	            }
	        	else if(!studentsEntered)
	        	{
	        		System.out.println("Sorry! No students entered yet\n");
	        	}
	            studentsEntered = createStudents(student_1, student_2, scnr);
	            break;

	        case 3:
		        if(studentsEntered)
		        {
		        	Student selectedStudent = selectStudent(student_1, student_2, scnr);
		            if(selectedStudent != null)
		              printTuitionInvoice(selectedStudent);
		            
		        }
		        else if(!studentsEntered)
	            	System.out.println("Sorry! No students entered yet\n");
	            break;

	        case 4:
		        if(facultyEntered)
		            printFacultyInfofmation(faculty_1);
		        else
		            System.out.println("Sorry! No faculty entered yet\n");
		        break;

	        case 5:
	          staffEntered = createStaff(staff_1, scnr);
	          break;
	          
	        case 6:
		        if(staffEntered)
		        	printStaff(staff_1);  
		        else
		            System.out.println("Sorry! No staff entered yet\n");
		        break;

	        case 7:
		        System.out.println("\n\nGoodbye!\n");
		        
		        exit = true;
		        
		        break;  
	      	}
	    }
	}

	public static int menu(Scanner scnr) 
  {	
		System.out.println("Choose one of the options:\n");
		System.out.println("1 - Enter the information of the faculty");
		System.out.println("2 - Enter the information of the two students");
		System.out.println("3 - Print tuition invoice");
		System.out.println("4 - Print faculty information");
		System.out.println("5 - Enter the information of the staff member");
		System.out.println("6 - Print the information of the staff member");
		System.out.println("7 - Exit program\n");
		
		System.out.print("\tEnter your selection: ");
	    int response = 0;
		try {
			response = Integer.parseInt(scnr.nextLine());
		}catch (NumberFormatException e) {
	      System.out.print("Invalid Input\n");
	    }
			return response;
	}
	
	public static boolean createFaculty(Faculty a, Scanner scnr) 
  {	
		System.out.print("\nEnter faculty info:\n\n");
		System.out.print("\tName of the faculty: ");
		a.name = scnr.nextLine();
		
		
		System.out.print("\n\tID: ");
		a.id = scnr.nextLine();
		

		// force user to enter correct input
		boolean exit = false;
		
		while(!exit)
		{
			System.out.print("\n\tDepartment: ");
			a.department = scnr.nextLine();
			
			if(!(a.department.toLowerCase().equals("mathematics") || a.department.toLowerCase().equals("engineering") || a.department.toLowerCase().equals("english")) )
		    {
		        System.out.print("Invalid entry - please try again\n");
		    }
		    else
		    	exit = true;
		}
		
		exit = false;
		
		while(!exit)
		{
			System.out.print("\n\tRank: ");
			a.rank = scnr.nextLine();
			
		    if(!(a.rank.toLowerCase().equals("professor")|| a.rank.toLowerCase().equals("adjunct")) )
		    {
		        System.out.print("Invalid entry - please try again\n");
		    }   
		    else
		    	exit = true;
		}
		 

		System.out.print("\n\n\tFaculty successfully added!\n");
		
		return true;
	}
	
	public static boolean createStudents(Student a, Student b, Scanner scnr) {
		try {
			System.out.print("\nEnter student 1 info:\n\n");
      
			System.out.print("\tName of Student: ");
			a.name = scnr.nextLine();
	      
			System.out.print("\n\tID: ");
			a.id = scnr.nextLine();
	      
			System.out.print("\n\tGpa: ");
			a.gpa = Double.parseDouble(scnr.nextLine());
	      
			System.out.print("\n\tCredit hours: ");
			a.credit_hours = Integer.parseInt(scnr.nextLine());
	      
			System.out.print("\nThanks!\n");
	      
			System.out.print("\nEnter student 2 info:\n\n");
      
			System.out.print("\tName of Student: ");
			b.name = scnr.nextLine();
      
			System.out.print("\n\tID: ");
			b.id = scnr.nextLine();
      
			System.out.print("\n\tGpa: ");
			b.gpa = Double.parseDouble(scnr.nextLine());
      
			System.out.print("\n\tCredit hours: ");
			b.credit_hours = Integer.parseInt(scnr.nextLine());
      
			System.out.print("\nThanks!\n");
      
		}catch (NumberFormatException e) {
			System.out.print("Invalid Input\n");
			return false;
		}
		return true;
	}

	public static Student selectStudent (Student a, Student b , Scanner scnr)
	  {
	    	System.out.printf("Which Student? Enter 1 for %s or enter 2 for %s: ", a.name, b.name);
	    	
	    	int choice;
	    	
	    	try {
	    		choice = Integer.parseInt(scnr.nextLine());
	
	    	}catch (NumberFormatException e) {
	    		System.out.print("Invalid Input\n");
	    		return null; 
	    	}
	    	
	    	if(choice == 1)
	    		return a;
	    	else if (choice == 2)
	    		return b;
	    	else{ 
	    		System.out.print("Invalid Input\n");
	    		return null;
	    	}
	  }

	public static void printTuitionInvoice (Student a)
	{
	    System.out.printf("\n---------------------------------------------------------------------------\n");
	    System.out.printf("%s\t\t%s\n", a.name, a.id);
	    System.out.printf("Credit Hours:%d  (236.45/credit hour)\n", a.credit_hours);
	    System.out.println("Fees: $52\n\n");
	    
	    double total_payment = 236.45 * a.credit_hours + 52;
	    double discount = 0;
	    
	    if (a.gpa >= 3.85){
	      discount = .15 * total_payment;
	      total_payment = total_payment - discount;
	    }
	    
	    System.out.printf("Total Payment (after discount): %.2f\t\t ($%.2f discount applied)\n", total_payment, discount);
	    System.out.printf("---------------------------------------------------------------------------\n");
	}

	public static void printFacultyInfofmation (Faculty a)
	{
	    System.out.print("\n---------------------------------------------------------------------------\n");
	    System.out.printf("%s\t\t%s\n",a.name, a.id);
	    System.out.printf("%s, %s\n", a.department, a.rank);
	    System.out.print("---------------------------------------------------------------------------\n");
	}

	public static boolean createStaff(Staff a, Scanner scnr) 
	{
	    System.out.print("\nEnter staff member info:\n\n");
	
	    System.out.print("\tName of Staff member: ");
	    a.name = scnr.nextLine();
	
	    System.out.print("\n\tEnter the id: ");
	    a.id = scnr.nextLine();

    
	    boolean exit = false;
    
	    while(!exit)
	    {
	    	System.out.print("\n\tDepartment: ");
	        a.department = scnr.nextLine();
	        
	        if(!(a.department.toLowerCase().equals("mathematics") || a.department.toLowerCase().equals("engineering") || a.department.toLowerCase().equals("english")) )
	        {
	            System.out.print("Invalid entry - please try again\n");
	        }
	        else
		        exit = true;
	    }
    
	    exit = false;
	    
	    while(!exit)
	    {
	    	System.out.print("\n\nStatus, enter P for part time or enter F for full time: ");
	        a.status = scnr.nextLine();
	
	        if(!(a.status.equals("P") ||  a.status.equals("p") ||  a.status.equals("F") || a.status.equals("f"))) {
	        	System.out.print("Invalid entry- please try again\n");
	        }
	        else
	        	exit = true;
	    }
	    
	    System.out.print("\n\n\tStaff member added!\n");
	
	    return true;
	}

	public static void printStaff(Staff a) 
	{
	    System.out.print("\n--------------------------------------------------");
	
	    System.out.print("\n" + a.name + "\t\t"+ a.id);
	
	    System.out.print("\n" + a.department.toLowerCase() + " Department, ");
	    
	    if(a.status.equals("p") || a.status.equals("P"))
	        System.out.print("Part Time");
	    else if(a.status.equals("f") || a.status.equals("F"))
	        System.out.print("Full Time");
	    System.out.print("\n--------------------------------------------------\n");
    }
} 