package com.jsp.grooming.Company;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class CompanyServices {
	
	Scanner sc = new Scanner(System.in);
	
	public void addCompany()
	{
		System.out.println("Enter the companyId");
		int companyId = sc.nextInt();
		
		System.out.println("Enter the companyName");
		String companyName = sc.next();
		
		System.out.println("Enter the HeadQuarters");
		String headQuarter = sc.next();
		
		System.out.println("Enter the total Braches");
		int branches = sc.nextInt();
		
		System.out.println("Enter the companyType");
		String companyType = sc.next();
		
		System.out.println("Enter the total Emplooyees");
		int totalEmployee = sc.nextInt();
		
		System.out.println("Enter the companyCeo");
		String ceo = sc.next();
		
		Company cmp = new Company();
		cmp.setCoompanyId(companyId);
		cmp.setCompanyName(companyName);
		cmp.setHeadQuarterLocation(headQuarter);
		cmp.setTotalBranches(branches);
		cmp.setCompanyType(companyType);
		cmp.setTotalEmployees(totalEmployee);
		cmp.setCompanyCeo(ceo);
		
		Session sc = new Configuration().configure().addAnnotatedClass(Company.class).buildSessionFactory().openSession();
		Transaction t = sc.beginTransaction();
		sc.save(cmp);
		t.commit();
		sc.close();
		
		System.out.println("Company Data Addedd SuccessFully");
				
				
				
	}
	
	public void findCompanyById()
	{
		System.out.println("Enter the companyId");
		int companyId = sc.nextInt();
		
	    Session sc = new Configuration().configure().addAnnotatedClass(Company.class).buildSessionFactory().openSession();
	    Transaction t = sc.beginTransaction();
	    Company company = sc.get(Company.class, companyId);
	    System.out.println("Company Details are "+company);
	    t.commit();
	    sc.close();
	 
	 
	}
	
	
	public void findCompanyByName()
	{
		System.out.println("Enter the companyName");
		String companyName = sc.nextLine();
		Session sc = new Configuration().configure().addAnnotatedClass(Company.class).buildSessionFactory().openSession();
		Transaction t = sc.beginTransaction();
		
		 NativeQuery nq = sc.createNativeQuery("select * from company where companyName =:companyName ");
		 nq.setParameter("companyName",companyName);
		 List<Object[]> list = nq.list();
		 
		 for(Object[] o:list)
		 {
			 for(Object ans:o)
			 {
				 System.out.print(ans+" ");	 
			 }
			
		 }
		
		t.commit();
		sc.close();
		
	}

	
	public void findCompanyByCeo()
	{
		System.out.println("Enter the ceoname");
		String ceoName = sc.nextLine();
		Session sc = new Configuration().configure().addAnnotatedClass(Company.class).buildSessionFactory().openSession();
		Transaction t = sc.beginTransaction();
		
		 NativeQuery nq = sc.createNativeQuery("select * from company where companyCeo =:ceo ");
		 nq.setParameter("ceo",ceoName);
		 List<Object[]> list = nq.list();
		 
		 for(Object[] o:list)
		 {
			 for(Object ans:o)
			 {
				 System.out.print(ans+" ");	 
			 }
			
		 }
		
		t.commit();
		sc.close();
		
	}
public void findAllCompanyByType()
{
	System.out.println("Enter the type of the company");
	String companyType =sc.nextLine();
	Session sc = new Configuration().configure().addAnnotatedClass(Company.class).buildSessionFactory().openSession();
	Transaction t = sc.beginTransaction();
	
	 NativeQuery nq = sc.createNativeQuery("select * from company where companyType =:cType ");
	 nq.setParameter("cType",companyType);
	 List<Object[]> list = nq.list();
	 
	 for(Object[] o:list)
	 {
		 for(Object ans:o)
		 {
			 System.out.println(ans+" ");	 
		 }
		
	 }
	
	t.commit();
	sc.close();
	
	
	
}
public void updateTotalEmployeeById()
{
	System.out.println("Enter the companyId");
	int cId = sc.nextInt();
	System.out.println("Enter the updated value of total employee");
	int updatedEmployee = sc.nextInt();
	Session sc = new Configuration().configure().addAnnotatedClass(Company.class).buildSessionFactory().openSession();
	Transaction t = sc.beginTransaction();
	NativeQuery nq = sc.createNativeQuery("update company set totalEmployees=:updatedEmployee where coompanyId =:companyId");
	nq.setParameter("updatedEmployee", updatedEmployee);
	nq.setParameter("companyId", cId);
	int eq = nq.executeUpdate();
	if(eq==1)
	{
		System.out.println("Record Updated Successfully");
	}
	else
	{
		System.out.println("Reocord Not Updated");
	}
	t.commit();
	sc.close();
	
}

public void updateBranchesByName()
{
	System.out.println("Enter the companyName");
	String companyName = sc.nextLine();
	
	System.out.println("Enter the updated Branch Values");
	int updatedBranch = sc.nextInt();
	
	Session sc = new Configuration().configure().addAnnotatedClass(Company.class).buildSessionFactory().openSession();
	Transaction t = sc.beginTransaction();
	NativeQuery nq = sc.createNativeQuery("update company set totalBranches=:updatedBranch where companyName =:companyName");
	nq.setParameter("updatedBranch", updatedBranch);
	nq.setParameter("companyName", companyName);
	int eq = nq.executeUpdate();
	if(eq==1)
	{
		System.out.println("Record Updated Successfully");
	}
	else
	{
		System.out.println("Reocord Not Updated");
	}
	t.commit();
	sc.close();
	
	
}

public void deleteCompanyById()
{
	System.out.println("Enter the companyId that has to be deleted");
	int cId = sc.nextInt();
	
	Session sc = new Configuration().configure().addAnnotatedClass(Company.class).buildSessionFactory().openSession();
	Transaction t = sc.beginTransaction();
//	Company company = sc.get(Company.class, cId);
//	sc.delete(company);
//	System.out.println("Company Deleted Suuccessfuully");
	
	NativeQuery nq = sc.createNativeQuery("delete  from company where coompanyId =:companyId");
	nq.setParameter("companyId", cId);
	int ans = nq.executeUpdate();
	if(ans==1)
	{
		  System.out.println("Deleted Successfully");		
	}
	else
		System.out.println("Not Deleted");
  
	t.commit();
	sc.close();
	
	
}

public void deleteByName()
{
	System.out.println("Enter the companyName that has to be deleted");
	String companyName = sc.nextLine();
	Session sc = new Configuration().configure().addAnnotatedClass(Company.class).buildSessionFactory().openSession();
	Transaction t = sc.beginTransaction();

	NativeQuery nq = sc.createNativeQuery("delete  from company where companyName =:companyName");
	nq.setParameter("companyName", companyName);
	int ans = nq.executeUpdate();
	if(ans==1)
	{
		  System.out.println("Deleted Successfully");		
	}
	else
		System.out.println("Not Deleted");
  
	t.commit();
	sc.close();
	
	

	
	
	
}
}
