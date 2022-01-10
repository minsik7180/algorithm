package Friend디비;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class FriendConnectionDB {
	static Connection con = null;
	static String[] dbTableField = { "std_id","dept","name","phone"};
	public static void main(String[] args) throws SQLException {
		//con = makeConnection();
		//dropTable(con,"books201858034");
		//createTable(con);
		
		//alterTable("books201858034");
	}
	
	public static void deleteOnTable(Connection con,String dbTableName, int std_id) {
		PreparedStatement DeleteTable;
		String deleteTableSQL = " delete from "+ dbTableName + " where std_id = ? ;";
		try {
			DeleteTable = con.prepareStatement(deleteTableSQL);
			
			DeleteTable.setInt(1, std_id);
			DeleteTable.executeUpdate();
			System.out.println("delete ok");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			System.out.println("delete SQL error");
		}
	}
	public static void alterTable(String dbTableName) {
		String alterTableSQL = "ALTER TABLE " + dbTableName + " convert to charset utf8;";
		try {
			PreparedStatement alterTable = con.prepareStatement(alterTableSQL);
			alterTable.execute();
			System.out.println("ALTER Table ok");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ALTER table error");
		}
	}
	
	public static void dropTable(Connection con, String dbTableName) {
		String dropTableSQL = "DROP TABLE if exists " + dbTableName + ";";
		try {
			PreparedStatement dropTable = con.prepareStatement(dropTableSQL);
			dropTable.execute();
			System.out.println("Drop Table ok");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Drop Table error");
		}
	}
	
	public static void printList(ArrayList<String> list) {
		for(String record: list) {
			System.out.println(record);
		}
	}
	public static void printList2(Vector<String> list) {
		for(String record: list) {
			System.out.println(record);
		}
	}
	
	public static ArrayList<String> getDataFromTable(Connection con){
		String selectDataSQL = "select * from books201858034;";
		ArrayList<String> retlist = new ArrayList<String>();
		try {
			PreparedStatement selectData = con.prepareStatement(selectDataSQL);
			ResultSet result = selectData.executeQuery();
			while(result.next()) {
				retlist.add(
						"title: " + result.getString("title")+
						" publisher: " + result.getString("publisher")+
						" year: " +result.getString("year") +
						" price: " + result.getString("price")
						);
			}
			return retlist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("select error");
		}
		return null;
	}
	
	public static Vector<String> getDataFromTable2(Connection con, String dbTableName){
		String selectDataSQL = "select std_id, dept, name, phone from "+ dbTableName +";";
		Vector<String> retlist = new Vector<String>();
		try {
			PreparedStatement selectData = con.prepareStatement(selectDataSQL);
			ResultSet result = selectData.executeQuery();
			while(result.next()) {
				retlist.add(
						" 학번: " + result.getString("std_id")+ "\t" +
						" 학과: " + result.getString("dept")+"\t" +
						" 이름: " +result.getString("name") + "\t" +
						" 전화번호: " + result.getString("phone")
						);
			}
			System.out.println("select ok");
			return retlist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("select error");
		}
		return null;
	}
	
	public static void update(Connection con, String dbTableName, int std_id, String dept, String name, String phone) {
		String updateTableSQL = "UPDATE " + dbTableName+
								" set name = '" + name+ "', "+
								" dept = '" +dept+"', "+
								" phone ='" +phone+"' "+
								" where std_id = " +std_id+";";
								
								
		try {
			PreparedStatement updateTable = con.prepareStatement(updateTableSQL);
			updateTable.execute();
			System.out.println("update ok");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("update error");
		}
	}

	public static void deleteAll(Connection con, String dbTableName) {
		String deleteTableSQL = "delete from "+dbTableName;
		try {
			PreparedStatement deleteAll = con.prepareStatement(deleteTableSQL);
			deleteAll.executeUpdate();
			System.out.println("delete ok");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("delete error");
		}
	}
	
	public static void insertDataOnTable(Connection con, String dbTableName, int std_id, String name, String dept, String phone) {
		String insertTableSQL = "replace into "+ dbTableName+
								" (std_id, name, dept, phone) " +
								" values "+
								" (?,?,?,?);";
			
			
			try {
				PreparedStatement insertTable = con.prepareStatement(insertTableSQL);
				insertTable.setInt(1, std_id);
				insertTable.setString(2, dept);
				insertTable.setString(3, name);
				insertTable.setString(4, phone);
				insertTable.executeUpdate();
				
				
				System.out.println("insert SQL ok");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("insert SQL error");
			}
					
	}
	public static void createTable(Connection con , String dbTableName) {
		String createTableSQL = "create table if not exists "+dbTableName+" ("+
				"std_id INT NOT NULL auto_increment, "+
				"name VARCHAR(50), "+
				"dept VARCHAR(20), "+
				"phone VARCHAR(50), "+
				"UNIQUE INDEX (std_id), "+
				"PRIMARY KEY(std_id) ) default charset=utf8;";
		
		try {
			PreparedStatement createTable = con.prepareStatement(createTableSQL);
			createTable.execute();
			System.out.println("create table "+dbTableName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("create error");
		}
					
			
	}	
	
	public static Connection makeConnection() throws SQLException {
		String driver = "com.mysql.cj.jdbc.Driver";
		String hostname = "sql6.freemysqlhosting.net";
		String databaseName = "sql6448156";
		String userName = "sql6448156";
		String passward = "Tec5ucNzLn";
		String utf8Connection ="?useUnicode=ture&characterEncoding=utf8";
		String url = "jdbc:mysql://"+hostname+":3306/"+databaseName + utf8Connection;
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,userName,passward);
			System.out.println("DB Connection");
			return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ERROR : Class.forName(driver);");
			return null;
		}
	}

}
