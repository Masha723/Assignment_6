
import java.util.InputMismatchException;
import java.util.*;



public class BevShopDriverApp {
	
	
	public static boolean char_validation(char[] input) {
		
		boolean flag=true;
		for (int i=0;i<input.length;i++) 
		{
			Character ch=input[i];
			flag=Character.isLetter(ch);
			if(!flag) {break;}

		}
		return flag;
	}
	

	public static String string_validation() {
		boolean flag=true;
		
		Scanner sc=new Scanner(System.in);
		String str="";
		
		while(flag) 
		{
			str=sc.nextLine();
			char[] input=str.toCharArray();
			flag=BevShopDriverApp.char_validation(input);
			if(!flag) {
				System.out.println("\t\tThe name must contain only letters. Please enter your name one more time");
				flag=true;
			}
			else {
				flag=false;
			}
			
		}
		
		return str;
	}
	
	public static int size_menu_validation_adults() {
		Scanner sc=new Scanner(System.in);
		
		int option=-1;
		while (1>option || option>3) 
		{
			String answer=sc.nextLine();
			try
			{
				option=Integer.parseInt(answer);
				if (1>option || option>3) 
				{System.out.println("Please enter number in range 1 to 3");}
			}
			catch(NumberFormatException e) {
				System.out.println("Please enter integer");
			}

		}
		return option;

	}
	
	public static int size_menu_validation_kids() {
		Scanner sc=new Scanner(System.in);
		
		int option=-1;
		while (1>option || option>2) 
		{
			String answer=sc.nextLine();
			try
			{
				option=Integer.parseInt(answer);
				if (1>option || option>3) 
				{System.out.println("Please enter number in range 1 to 3");}
			}
			catch(NumberFormatException e) {
				System.out.println("Please enter integer");
			}

		}
		return option;

	}
	
	
	
	
	
	public static boolean yes_no_validation() {
		Scanner sc=new Scanner(System.in);
		int answer=0;
		while (1>answer || answer>3) 
		{
			String validate=sc.nextLine();
			try
			{
				answer=Integer.parseInt(validate);
				if (1>answer || answer>3) 
				{System.out.println("Please enter number in range 1 - yes to 2 - no");}
			}
			catch(NumberFormatException e) {
				System.out.println("Please enter integer");
			}

		}
		
		boolean result=answer==1?true:false;
		return result;
	}
	
	public static void choose_drink_adult(BevShop bevshop, int recursion_loop) {
		
		Scanner sc=new Scanner(System.in);

		boolean extra_shot,extra_syrup;
		boolean add_protein;
	
		String beverage;
		
		if (recursion_loop==0)
		{System.out.println("*************************************************************************************************\n"
							+"*\t\tOur store menu includes three types of beverages: Alcohol, Coffee and Smoothie. *\n"
							+"*************************************************************************************************\n"
							+"*\t\tTo add an alcohol to your order, please:    ENTER 1                             *\n"
							+"*\t\tTo add an coffee to your order, please:     ENTER 2                             *\n"
							+"*\t\tTo add an smoothie to your order, please:   ENTER 3                             *\n"
							+"*************************************************************************************************");}
		else {
			System.out.println("\t\tPlease enter the number from the menu above.");
		}

		int option=BevShopDriverApp.size_menu_validation_adults();
		
		System.out.println("\t\tWhat size would you like? Please ENTER for small - 1, medium - 2, large - 3");
		
	
		int size=BevShopDriverApp.size_menu_validation_adults();
		
		switch(option) 
		{
			case 1:
			{
				System.out.println("\t\tPlease enter the Alcohol beverage name:");
				beverage=BevShopDriverApp.string_validation();
				bevshop.processAlcoholOrder(beverage, Size.values()[size-1]);
				break;
			}
			case 2:
			{ 
				System.out.println("\t\tPlease enter the type of coffee:");
				beverage=BevShopDriverApp.string_validation();
				System.out.println("\t\tWould you like an extra shot?Please ENTER for yes - 1 /no - 2");
				extra_shot=BevShopDriverApp.yes_no_validation();
				System.out.println("\t\tWould you like an extra syrup?Please ENTER for yes - 1 /no - 2");
				extra_syrup=BevShopDriverApp.yes_no_validation();
				bevshop.processCoffeeOrder(beverage, Size.values()[size-1], extra_shot, extra_syrup);
				break;
				
			}
			case 3:
			{
				System.out.println("\t\tPlease enter the smoothie name:");
				beverage=BevShopDriverApp.string_validation();
				System.out.println("\t\tWould you like an add protein?Please ENTER for yes - 1 /no - 2");
				add_protein=BevShopDriverApp.yes_no_validation();
				System.out.println("\t\tWould you like an extra fruit? (5 maximum per drink) Please ENTER a number");
				int fruits=sc.nextInt();
				bevshop.processSmoothieOrder(beverage, Size.values()[size-1], fruits, add_protein);
				break;

			}
		
		}
		boolean answer=true;
		
		// Recursion
		
		System.out.println("\t\tWould you like to add another beverage order? Please ENTER for yes - 1, no - 2");		
		answer=BevShopDriverApp.yes_no_validation();
		if (answer)
		{
			recursion_loop+=1;
			BevShopDriverApp.choose_drink_adult(bevshop,recursion_loop);
		}
	
		
	}
	
	public static void choose_drink_child(BevShop bevshop, int recursion_loop) {
		
		Scanner sc=new Scanner(System.in);

		boolean extra_shot,extra_syrup;
		boolean add_protein;
	
		String beverage;
		
		if (recursion_loop==0)
		{System.out.println("*************************************************************************************************\n"
							+"*\t\tOur store KID'S menu includes two types of beverages: Coffee and Smoothie.      *\n"
							+"*************************************************************************************************\n"
							+"*\t\tTo add an coffee to your order, please:     ENTER 1                             *\n"
							+"*\t\tTo add an smoothie to your order, please:   ENTER 2                             *\n"
							+"*************************************************************************************************");}
		else {
			System.out.println("\t\tPlease enter the number from the menu above.");
		}

		int option=BevShopDriverApp.size_menu_validation_kids();
		
		System.out.println("\t\tWhat size would you like? Please ENTER for small - 1, medium - 2, large - 3");
		
	
		int size=BevShopDriverApp.size_menu_validation_kids();
		
		switch(option) 
		{
			
			case 1:
			{ 
				System.out.println("\t\tPlease enter the type of coffee:");
				beverage=BevShopDriverApp.string_validation();
				System.out.println("\t\tWould you like an extra shot? Please ENTER for yes - 1 /no - 2");
				extra_shot=BevShopDriverApp.yes_no_validation();
				System.out.println("\t\tWould you like an extra syrup? Please ENTER for yes - 1 /no - 2");
				extra_syrup=BevShopDriverApp.yes_no_validation();
				bevshop.processCoffeeOrder(beverage, Size.values()[size-1], extra_shot, extra_syrup);
				break;
				
			}
			case 2:
			{
				System.out.println("\t\tPlease enter type of smoothie:");
				beverage=BevShopDriverApp.string_validation();
				System.out.println("\t\tWould you like an add protein? Please ENTER for yes - 1 /no - 2");
				add_protein=BevShopDriverApp.yes_no_validation();
				System.out.println("\t\tWould you like an extra fruit? (5 maximum per drink) Please enter a number");
				int fruits=sc.nextInt();
				bevshop.processSmoothieOrder(beverage, Size.values()[size-1], fruits, add_protein);
				break;

			}
		
		}
		boolean answer=true;
		
		// Recursion
		
		System.out.println("\t\tWould you like to add another beverage order? Please ENTER for yes - 1 /no - 2");		
		answer=BevShopDriverApp.yes_no_validation();
		if (answer)
		{
			recursion_loop+=1;
			BevShopDriverApp.choose_drink_child(bevshop,recursion_loop);
		}
	
		
	}
	
	public static void order_processing(BevShop bevshop, int random_time, Day order_day) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("\t\tWould you like to start a new order? Please ENTER for yes - 1, no - 2");
		boolean answer=BevShopDriverApp.yes_no_validation();
		String name;
		int age_verified=0;
	
		while(answer)
		{

			System.out.println("\t\tPlease enter your name:");
			name=BevShopDriverApp.string_validation();
		
			System.out.println("\t\tPlease enter your age:");
			boolean flag=true;
			while(flag)
			{
				String age=sc.nextLine();
				try
				{	
					age_verified=Integer.parseInt(age);
					if (age_verified>0 && age_verified<150)
					{
						bevshop.startNewOrder(random_time, order_day, name, age_verified);
						flag=false;
					}
					else {System.out.println("\t\tPlease enter a positive number");}
				}
				catch(NumberFormatException e) 
				{	
					System.out.println("\t\tPlease enter digits");
					System.out.println("\t\tPlease enter your age again:");
				}
			}
			
			
			if(bevshop.isValidAge(age_verified)) {
				BevShopDriverApp.choose_drink_adult(bevshop,0);
			}
			else {
				System.out.println("\n\t\t You are not eligible for an alcohol drink. Here is our KID's menu.\n");
				BevShopDriverApp.choose_drink_child(bevshop,0);
			}
		

			System.out.println("\t\tWould you like a receipt? Please ENTER for yes - 1, no - 2");	
			boolean receipt=BevShopDriverApp.yes_no_validation();
		
			if (receipt)
			{
				System.out.println(bevshop.getCurrentOrder().toString());
			
			}
		
			System.out.println("\t\tWould you like to start a new order? Please ENTER for yes - 1, no - 2");
			answer=BevShopDriverApp.yes_no_validation();
		
		}
		System.out.println("\t\tThank for visiting  Bradley Beverage Shop. Have a Lovely Day");
	}
	
	
	
	
	public static void main(String[] args) 
	{
		
	
	
		Scanner sc=new Scanner(System.in);
		BevShop bevshop=new BevShop();
		Random rn = new Random();
		int random_day =  rn.nextInt(6);
		Day order_day=Day.values()[random_day];
		int random_time= 18;
		
		System.out.println("************************************************************************************************\n"
							+"*\t\tWelcome to Bradley Beverage Shop.                                              *\n"
							+"************************************************************************************************\n");
		
		if (bevshop.isValidTime(random_time)) 
		{
			BevShopDriverApp.order_processing(bevshop, random_time, order_day);
		}
		else 
		{
			System.out.println("\t\tThe storre is closed. Store hours: from 08::00 AM to 11:00 from Mon to Sun");
		}
		
		System.out.println("\t\tWould you like to print out monthly sales RECEITS? Please ENTER for yes - 1, no - 2");
		boolean answer=BevShopDriverApp.yes_no_validation();
		if (answer) 
		{
			System.out.println(bevshop.toString());
		}
		
		System.out.println("\t\tWould you like to print out the TOTAL monthly sales? Please ENTER for yes - 1, no - 2");
		answer=BevShopDriverApp.yes_no_validation();
		if (answer) 
		{
			System.out.println("\t\tTotal sum of sales "+bevshop.totalMonthlySale());
			System.out.println("\t\tTotal number of orders "+bevshop.totalNumOfMonthlyOrders());
		}
		
		

	}
	
	
			
}
	
	

