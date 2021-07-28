package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("===== TEST 1 SELLER FindById");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n===== TEST 2 SELLER FindByDepartment");
		
		Department dep = new Department(2, null);
		
		List<Seller> list = sellerDao.findByDepartment(dep);
		
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n===== TEST 3 SELLER FindAll");
		
		List<Seller> listAll = sellerDao.findAll();
		
		for (Seller obj : listAll) {
			System.out.println(obj);
		}
		
		System.out.println("\n===== TEST 3 SELLER Insert");
			Seller nSeller = new Seller(null, "teste", "zika", new Date(), 3000.0, dep);
			sellerDao.insert(nSeller);
			System.out.println("Inserted!!! Id: " + nSeller.getId());
		
		
			System.out.println("\n===== TEST 4 SELLER Update");
			seller = sellerDao.findById(1);
			seller.setName("João da Costa da Silva 26");
			sellerDao.update(seller);
			System.out.println("Update Complete!!! \n" + seller);
			
			
		
	}

}
