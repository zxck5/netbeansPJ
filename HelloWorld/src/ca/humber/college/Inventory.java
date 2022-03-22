package ca.humber.college;

import java.util.Scanner;

public class Inventory {
	
	int shampooPoint;
	int conditionerPoint;
	int gelPoint;
	int shampooQty;
	int conditionerQty;
	int gelQty;
	
	public Inventory(int shampoo, int conditioner, int gel, int shampooNum, int conditionerNum, int gelNum) {
		this.shampooPoint = shampoo;
		this.conditionerPoint = conditioner;
		this.gelPoint = gel;
		shampooQty = shampooNum;
		conditionerQty = conditionerNum;
		gelQty = gelNum;
	}
	
	public void displayProducts() {
		System.out.println("---------products----------");
		System.out.println("1.shampoo: " + shampooPoint + "points");
		System.out.println("2.conditionerPoint: " + conditionerPoint + "points");
		System.out.println("3.gelPoint: " + gelPoint + "points");
		System.out.println("4.get out");
		System.out.println("5. inventory stock for products");
		System.out.println("---------------------------");
	}
	public void inventoryStock() {
		System.out.println("--------------------------");
		System.out.println("shampooQty: "+ shampooQty);
		System.out.println("conditionerQty: "+ conditionerQty);
		System.out.println("gelQty: "+ gelQty);
		System.out.println("--------------------------");
	}
	public int purchaseShampoo(int myPoint, int count) {
		// TODO Auto-generated method stub
		shampooQty -= count;
		myPoint -= shampooPoint*count;
		System.out.println("shampoo purchased");
		return myPoint;
	}
	public int purchaseConditioner(int myPoint, int count) {
		// TODO Auto-generated method stub
		
		myPoint -= conditionerPoint*count;
		conditionerQty -= count;
		System.out.println("conditioner purchased");
		return myPoint;
		
	}
	public int purchaseGel(int myPoint, int count) {
		
		gelQty -= count;
		myPoint -= gelPoint*count;
		System.out.println("gel purchased");
		return myPoint;
	}
	
//	Create an Inventory class to be used in online shopping application.
//	The class must keep inventory and prices for three types of products: shampoo, conditioner and gel. Prices are in reward points.
//	Upon request it should display the number of products of each kind that can be purchased by a customer based on their points.
//	Inventory class can receive requests to purchase different product types. Each purchase method receives customer’s number of points and a desired product quantity. The method must return customer’s remaining number of points after purchase. Upon every sale appropriate inventory must be updated and displayed as well as customer’s purchase options.
//	In the Main method prompt the user to enter the number of points, then display the inventory and user’s purchase options.
//	Main method should make a purchase of each kind of product.
	public static void main(String[] args) {
			
		Scanner scan = new Scanner(System.in);
		System.out.println("how many points do you want to have for this online shopping?");
		int myPoint = scan.nextInt();
		
		Inventory inven = new Inventory(1,2,3,10,10,10);

		while (true) {
			int count = 0;
			inven.displayProducts();
			int select = scan.nextInt();
			if (select == 1) {
				System.out.println("how many shampoo will you buy?");
				count = scan.nextInt();
				if (count <= inven.shampooQty) {
					if (count* inven.shampooPoint <= myPoint) {
						myPoint = inven.purchaseShampoo(myPoint, count);
						System.out.println("my remaining points ="+ myPoint);
						
					} else {
						System.out.println("Not enough points");
					}
					
					
				} else {
					System.out.println("you cannot purchase");
				}
				
				
			} else if (select == 2) {
				System.out.println("how many conditioner will you buy??");
				count = scan.nextInt();
				if (count <= inven.conditionerQty) {
					if (count* inven.conditionerPoint <= myPoint) {
						myPoint = inven.purchaseConditioner(myPoint, count);
						System.out.println("my remaining points ="+ myPoint);
					} else {
						System.out.println("Not enough points");
					}
					
				}else {
					System.out.println("you cannot purchase");
				}
				
			} else if (select == 3) {
				System.out.println("how many gel will you buy??");
				count = scan.nextInt();
				if (count <= inven.gelQty) {
					if (count* inven.gelPoint <= myPoint) {
						myPoint = inven.purchaseGel(myPoint, count);
						System.out.println("my remaining points ="+ myPoint);
					} else {
						System.out.println("Not enough points");
					}
				} else {
					System.out.println("you cannot purchase");
				}
				
			} else if (select == 4) {
				System.out.println("Exit");
				break;
				
			} else if (select == 5) {
				inven.inventoryStock();
			};
		}
	}
	
}
