/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmbook;


import Properties.Purchase;
import Properties.Rent;
import db.DB;
import enums.PurchaseEnum;
import enums.RentEnum;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MNK
 */
public class ListAdminReport {
    List<Purchase> purchases = new ArrayList<>();
    List<Rent> rents = new ArrayList<>();
    
    public void gatherPurchaseData(){
        purchases.clear();
        String query = "SELECT * FROM purchase";
        DB db = new DB();
        
        try {
            ResultSet rs = db.connect().executeQuery(query);
            
            while (rs.next()) {                
                Purchase p = new Purchase();
                p.setPurchaseID(rs.getString("" + PurchaseEnum.purchase_id));
                p.setUserID(rs.getString("" + PurchaseEnum.user_id));
                p.setProductID(rs.getString("" + PurchaseEnum.product_id));
                //p.setPurchaseType(rs.getString("" + PurchaseEnum.purchase_type));
                if (rs.getString("" + PurchaseEnum.purchase_type).equals("0")) {
                    p.setPurchaseType("User");
                }else if(rs.getString("" + PurchaseEnum.purchase_type).equals("-1")){
                    p.setPurchaseType("Guest");
                }
                p.setPurchasePrice(rs.getString("" + PurchaseEnum.purchase_price));
                //p.setProductType(rs.getString("" + PurchaseEnum.product_type));
                if (rs.getString("" + PurchaseEnum.product_type).equals("0")) {
                    p.setProductType("Film");
                }else if (rs.getString("" + PurchaseEnum.product_type).equals("1")){
                    p.setProductType("Book");
                }
                p.setPurchaseDate(rs.getString("" + PurchaseEnum.purchase_date));
                
                purchases.add(p);
            }
        } catch (SQLException e) {
            System.err.println("PURCHASES DATA CEKME HATASI" + e);
        }finally{
            db.close();
        }
    }
    public DefaultTableModel listPurchases(){
        gatherPurchaseData();
        
        DefaultTableModel purchaseTable = new DefaultTableModel(){

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        
        purchaseTable.addColumn("ID");
        purchaseTable.addColumn("User ID");
        purchaseTable.addColumn("Product ID");
        purchaseTable.addColumn("Purchase Type");
        purchaseTable.addColumn("Price");
        purchaseTable.addColumn("Product Type");
        purchaseTable.addColumn("Date");
        
        for (Purchase purchase : purchases) {
            purchaseTable.addRow(new String[] {purchase.getPurchaseID(),purchase.getUserID(),purchase.getProductID(),purchase.getPurchaseType(),purchase.getPurchasePrice(),purchase.getProductType(),purchase.getPurchaseDate()});
            
        }
        return purchaseTable;
    }
    
    public void gatherRentData(){
        rents.clear();
        String query = "SELECT * FROM rent";
        DB db = new DB();
        
        try {
            ResultSet rs = db.connect().executeQuery(query);
            
            while (rs.next()) {                
                Rent r = new Rent();
                r.setRentID(rs.getString(""+ RentEnum.rent_id));
                r.setUserID(rs.getString(""+RentEnum.user_id));
                r.setProductID(rs.getString(""+ RentEnum.product_id));
                r.setRentPrice(rs.getString("" + RentEnum.rent_price));
                //r.setRentProductType(rs.getString("" + RentEnum.rent_product_type));
                if (rs.getString("" + RentEnum.rent_product_type).equals("0")) {
                    r.setRentProductType("Film");
                }else if (rs.getString("" + RentEnum.rent_product_type).equals("1")){
                    r.setRentProductType("Book");
                }
                r.setRentHireDate(rs.getString("" + RentEnum.rent_hire_date));
                r.setRentWithdrawDate(rs.getString("" + RentEnum.rent_withdraw_date));
                r.setRentWithdrawStatus(rs.getString("" + RentEnum.rent_withdraw_status));
                
                rents.add(r);
            }
        } catch (SQLException e) {
            System.err.println("RENT DATA CEKME HATASI" + e);
        }finally{
            db.close();
        }
        
    }
    public DefaultTableModel listRents(){
        gatherRentData();
        
        DefaultTableModel rentTable = new DefaultTableModel(){

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        
        rentTable.addColumn("ID");
        rentTable.addColumn("User ID");
        rentTable.addColumn("Product ID");
        rentTable.addColumn("Price");
        rentTable.addColumn("Product Type");
        rentTable.addColumn("Rent Hire Date");
        rentTable.addColumn("Rent Withdraw Date");
        rentTable.addColumn("Withdraw Status");
        
        for (Rent rent : rents) {
            rentTable.addRow(new String[] {rent.getRentID(),rent.getUserID(),rent.getProductID(),rent.getRentPrice(),rent.getRentProductType(),rent.getRentHireDate(),rent.getRentWithdrawDate(),rent.getRentWithdrawStatus()});
            
        }
        return rentTable;
    }
    
    
    
}
