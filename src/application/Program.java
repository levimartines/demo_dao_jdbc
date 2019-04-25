package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("--- TEST 1: findById ---");
		Seller seller = sellerDao.findById(6);
		System.out.println(seller);
		System.out.println();

		System.out.println("--- TEST 2: findByDepartment ---");
		Department dep = new Department(3,null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		for(Seller obj:list) {
			System.out.println(obj);
		}
		System.out.println();
		
		System.out.println("--- TEST 3: findAll ---");
		list = sellerDao.findAll();
		for(Seller obj:list) {
			System.out.println(obj);
		}
		System.out.println();
		
		System.out.println("--- TEST 4: seller insert ---");
		Seller newSeller = new Seller(null, "Dark Paulinho", "dark@gmail.com", new Date(), 5464.12, dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! Seller ID = " + newSeller.getId());
		System.out.println();
		
		System.out.println("--- TEST 5: seller update ---");
		seller = sellerDao.findById(8);
		seller.setName("Dibraldinho");
		seller.setEmail("dibra@gmail.gol");
		seller.setBaseSalary(999999.99);
		sellerDao.update(seller);
		System.out.println(seller);
		System.out.println();
		
		System.out.println("--- TEST 6: seller delete");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete complete!");
		
		sc.close();
	}
}
