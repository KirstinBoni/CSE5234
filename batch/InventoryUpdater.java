package edu.osu.cse5234.batch;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
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
		// TODO Auto-generated method stub
		// This method returns a map of two integers. The first Integer is item ID, and
		// the second is cumulative requested quantity across all new orders
		return null;
	}
	
	private static void updateInventory(Map<Integer, Integer> orderedItems,Connection conn) throws SQLException {
		// TODO Auto-generated method stub
	}
	
	private static void updateOrderStatus(Collection<Integer> newOrderIds, Connection conn) throws SQLException {
		// TODO Auto-generated method stub
	}
}
