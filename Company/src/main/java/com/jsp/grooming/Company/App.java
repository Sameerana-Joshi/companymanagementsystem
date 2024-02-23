package com.jsp.grooming.Company;

import java.util.Scanner;

 



/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		Scanner sc = new Scanner(System.in);
		CompanyServices cs = new CompanyServices();
		
		System.out.println( "Press 1 add Company\n2 to find company by id\n3 find cmpany by name \n4 tofind company by ceo\n5 to update employee by company id\n6 to update branches based on companyname\n 7 to delete coompany by id\n 8 Delete coompany by name\n9 find All Company By Type " );
		int ch = sc.nextInt();
		
		switch(ch)
		{
		case 1:  cs.addCompany();
		break;
		case 2: cs.findCompanyById();
		break;
		case 3: cs.findCompanyByName();
		break;
		case 4: cs.findCompanyByCeo();
		break;
		case 5:cs.updateTotalEmployeeById();
		break;
		case 6:cs.updateBranchesByName();
		break;
		case 7:cs.deleteCompanyById();
		break;
		case 8: cs.deleteByName();
		break;
		case 9:cs.findAllCompanyByType();
		break;

		default:System.out.println("give range from 1- 9");


		
		}

	//	EhCacheRegionFactory

	}
}
