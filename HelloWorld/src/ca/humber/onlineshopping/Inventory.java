package ca.humber.onlineshopping;

public class Inventory {

    private int shampooPrice;
    private int shampooQty;
    private int gelPrice;
    private int gelQty;
    private int conditionerPrice;
    private int conditionerQty;

    public Inventory() {
        shampooPrice = 10;
        conditionerPrice = 5;
        gelPrice = 5;
        shampooQty = 100;
        conditionerQty = 50;
        gelQty = 200;
    }

    // productType values: 1: shampoo, 2: conditioner, 3: gel
    public int processOrder(int customerPoints, int quantity, int productType) {
        // check the inventory for the requested product type
        if (!checkInventory(quantity, productType)) {
            System.out.println("Not enough product in stock");
            return customerPoints;
        }
        
        // check customers's number of points for the purchase
        if (!checkPoints(customerPoints, quantity, productType)) {
            System.out.println("Not enough points for this purchase");
            return customerPoints;            
        }
        
        // finalize the sale
        return finalizeSale(customerPoints, quantity, productType);
    }
    
    public int finalizeSale(int customerPoints, int quantity, int productType) {
        switch (productType) {
            case 1:
                //update inventory
                updateInventory(-quantity, 0, 0);
                return customerPoints - quantity * shampooPrice;
            case 2:
                updateInventory(0, -quantity, 0);
                return customerPoints - quantity * conditionerPrice;
            case 3:
                updateInventory(0, 0, -quantity);
                return customerPoints - quantity * gelPrice;
            default:
                return customerPoints;
        }
    }
    
    public void updateInventory(int shampoo, int conditioner, int gel) {
        shampooQty += shampoo;
        conditionerQty += conditioner;
        gelQty += gel;
    }
    
    public boolean checkPoints(int customerPoints, int quantity, int productType) {
        switch (productType) {
            case 1:
                if (quantity * shampooPrice <= customerPoints) {
                    return true;
                }
                break;
            case 2:
                if (quantity * conditionerPrice <= customerPoints) {
                    return true;
                }
                break;
            case 3:
                if (quantity * gelPrice <= customerPoints) {
                    return true;
                }
                break;
            default:
                System.out.println("No such product available");
                break;
        }
        return false;
    }
    
    public boolean checkInventory(int quantity, int productType) {
        switch (productType) {
            case 1: // shampoo
                if (quantity <= shampooQty) 
                    return true;
                break;
            case 2: // conditioner
                if (quantity <= conditionerQty) 
                    return true;                
                break;
            case 3: // gel
                if (quantity <= gelQty) 
                    return true;                
                break;
            default:
                System.out.println("No such product available");
                break;
        }
        return false;
    }
}