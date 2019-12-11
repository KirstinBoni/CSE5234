package edu.osu.cse5234.batch;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.jms.Connection;

public class InventoryUpdater {
	public static void main(String[] args) {
		System.out.println("Starting Inventory Update ...");
		try {
			Connection conn = createConnection();
			Collection<Integer> newOrderIds = getNewOrders(conn);
			Map<Integer, Integer> orderedItems = getOrderedLineItems(newOrderIds, conn);
			updateInventory(orderedItems, conn);
			updateOrderStatus(newOrderIds, conn);
			conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	
	private static Connection createConnection() throws SQLException, ClassNotFoundException {
		Class.forName("org.h2.Driver");
		Connection conn = (Connection) DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		return conn;
	}
	private static Collection<Integer> getNewOrders(Connection conn) throws SQLException {
		Collection<Integer> orderIds = new ArrayList<Integer>();
		ResultSet rset = ((java.sql.Connection) conn).createStatement().executeQuery("select ID from CUSTOMER_ORDER where STATUS = 'New'");
		while (rset.next()) {
			orderIds.add(new Integer(rset.getInt("ID")));
		}
		return orderIds;
	}
	private static Map<Integer, Integer> getOrderedLineItems(Collection<Integer> newOrderIds, Connection conn) throws SQLException {
		Map<Integer, Integer> orderedLineItems = new HashMap<>();
		for(int orderId : newOrderIds) {
			ResultSet rset = ((java.sql.Connection) conn).createStatement().executeQuery(String.format(
					"select ID, ITEM_NUMBER from CUSTOMER_ORDER_LINE where CUSTOMER_ORDER_FK = %d", orderId));	
			int itemId = new Integer(rset.getInt("ID"));
			int itemQuantity = new Integer(rset.getInt("ITEM_NUMBER"));
			if(orderedLineItems.containsKey(itemId)){
				orderedLineItems.put(itemId, orderedLineItems.get(itemId) + itemQuantity);
			}else {
				orderedLineItems.put(itemId, itemQuantity);
			}
		}
		return orderedLineItems;
	}
	
	private static void updateInventory(Map<Integer, Integer> orderedItems,Connection conn) throws SQLException {
		for(Map.Entry<Integer, Integer> orderedItem : orderedItems.entrySet()) {
			ResultSet rset = ((java.sql.Connection) conn).createStatement().executeQuery(String.format(
					"select AVAILABLE_QUANTITY from ITEM where ID = %d", orderedItem.getKey()));	
			int currentValue = new Integer(rset.getInt("AVAILABLE_QUANTITY"));
			int newValue = currentValue - orderedItem.getValue();
			((java.sql.Connection) conn).createStatement().executeQuery(String.format(
					"UPDATE ITEM set AVAILABLE_QUANTITY = %d where ID = %d", newValue, orderedItem.getKey()));				
		}
	}
	
	private static void updateOrderStatus(Collection<Integer> newOrderIds, Connection conn) throws SQLException {
		for(Integer orderId : newOrderIds) {
			((java.sql.Connection) conn).createStatement().executeQuery(
					String.format("update ITEMS set status='PROCESSED' where ID= %d", orderId));
		}
	}
}
