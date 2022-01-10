package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Connectiondb {
	static Connection con = null;
	public static void main(String[] args) throws SQLException {
		con = makeConnection();
		//dropTable(con,"books201858034");
		//createTable(con);
		
		alterTable("books201858034");
	}
	
	public static void deleteOnTable(Connection con,String title, String publisher, String year, int price) {
		String deleteTableSQL = " delete from books201858034 "+
								" where title ='"+title+"'"+
								" and publisher = '" + publisher+"'"+
								" and year = '" +year + "'"+
								" and price = '" +price +"';";
		try {
			PreparedStatement DeleteTable = con.prepareStatement(deleteTableSQL);
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
	
	public static void insertDataOnTable(Connection con, String title, String publisher, String year, int price) {
		String insertTableSQL = "replace into books201858034 "+
								
								" (title, publisher, year, price) " +
								" values "+
								" ('"+title+"', '"+publisher + "', '"+ year +"' , "+price+");";
			
			try {
				PreparedStatement insertTable = con.prepareStatement(insertTableSQL);
				insertTable.executeUpdate();
				System.out.println("insert SQL ok");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("insert SQL error");
			}
					
	}
	public static void createTable(Connection con) {
		String createTableSQL = "create table if not exists books201858034 ("+
				"book_id INT NOT NULL auto_increment, "+
				"title VARCHAR(50), "+
				"publisher VARCHAR(50), "+
				"year VARCHAR(10), "+
				"price INT, "+
				"UNIQUE INDEX (title), "+
				"PRIMARY KEY(book_id) );";
		
		try {
			PreparedStatement createTable = con.prepareStatement(createTableSQL);
			createTable.execute();
			System.out.println("create table book201858034");
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

