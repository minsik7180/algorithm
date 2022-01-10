package 기말평가;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class DBConnection {
	static Connection con = null; 
	static String dbTableName = "FriendsDB201858034";  
	static String[] dbTableField = {"std_id", "dept", "name", "phone"};

	public static void dropTable(Connection con, String dbTableName) {
		// TODO Auto-generated method stub
		String dropTableSQL = "DROP TABLE if exists " + dbTableName + ";" ;
		
		try {
			PreparedStatement dropTable = con.prepareStatement(dropTableSQL);
			dropTable.execute();
			System.out.println("Drop Table OK!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Drop Table ERROR!!!");
		}
	}

	public static void printList(ArrayList<String> list) {
		// TODO Auto-generated method stub
		for (String record: list) {
			System.out.println(record);
		}
	}
	
	public static void printList2(Vector<String> list) {
		// TODO Auto-generated method stub
		for (String record: list) {
			System.out.println(record);
		}
	}

	// ******* 수정 필요 ********
	public static ArrayList<String> getDataFromTable(Connection con, String dbTableName) {
		// TODO Auto-generated method stub
		String selectDataSQL = "SELECT std_id, dept, name, phone FROM " + dbTableName + ";" ;
		ArrayList<String> retList = new ArrayList<String>();
		try {
			PreparedStatement selectData = con.prepareStatement(selectDataSQL);
			ResultSet result = selectData.executeQuery();
			while (result.next()) {
				retList.add(dbTableField[0] + ": " + result.getString(dbTableField[0]) + "\t" +  //*******
						dbTableField[1] + ": " + result.getString(dbTableField[1]) + "\t" + //*******
						dbTableField[2] + ": "  + result.getString(dbTableField[2]) + "\t" + //*******
						dbTableField[3] + ": " + result.getString(dbTableField[3]) 
						);
			}
			System.out.println("Select SQL OK!!!");
			return retList;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Select SQL ERROR!!!");
		}
		
		return null;
	}

	// ******* 수정 필요 ********
	public static Vector<String> getDataFromTable2(Connection con, String dbTableName) {
		// TODO Auto-generated method stub
		String selectDataSQL = "SELECT std_id, dept, name, phone FROM " + dbTableName + ";" ;
		Vector<String> retList = new Vector<String>();
		try {
			PreparedStatement selectData = con.prepareStatement(selectDataSQL);
			ResultSet result = selectData.executeQuery();
			while (result.next()) {
				retList.add(dbTableField[0] + ": " + result.getString(dbTableField[0]) + "\t" +  //*******
						dbTableField[1] + ": " + result.getString(dbTableField[1]) + "\t" + //*******
						dbTableField[2] + ": "  + result.getString(dbTableField[2]) + "\t" + //*******
						dbTableField[3] + ": " + result.getString(dbTableField[3]) 
						);
			}
			System.out.println("Select SQL OK!!!");
			return retList;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Select SQL ERROR!!!");
		}
		
		return null;
	}

	// ******* 수정 필요 ********
	public static void insertDataOnTable(Connection con, String dbTableName, int std_id, String dept, String name, int math, int science, int english) throws SQLException {
		// TODO Auto-generated method stub
		String insertTableSQL = "REPLACE INTO " + dbTableName + " (std_id, dept, name, math, science, english) values (?,?,?,?,?,?);" ;
		try {
			PreparedStatement insertTable = con.prepareStatement(insertTableSQL);
			
			insertTable.setInt(1, std_id);       // 이유 : dbTable 내에 각 필드내 저장되는 데이터 타입에 따라서... std_id INT
			insertTable.setString(2, dept);
			insertTable.setString(3, name);
			insertTable.setInt(4,math);
			insertTable.setInt(5,science);
			insertTable.setInt(6,english);
			
			
			insertTable.executeUpdate();
			System.out.println("Insert SQL (Using pstmt) OK!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Insert SQL (Using pstmt) ERROR!!!");
		}
		
		
	}
	
	// ******* 수정 필요 ********
	public static void createTable(Connection con, String dbTableName) {
		// TODO Auto-generated method stub
		//*****************
		String createTableSQL = "CREATE TABLE if not exists " + dbTableName + " (" +
				"std_id INT NOT NULL, " +
				"dept VARCHAR(15), " +
				"name VARCHAR(10), " +
				"math INT, " +
				"science INT, "+
				"english INT, "+
				"UNIQUE INDEX (std_id), " +     
				"PRIMARY KEY(std_id) ) default charset=utf8;" ;  //***** default charset=utf8; 추
		
		try {
			PreparedStatement createTable = con.prepareStatement(createTableSQL);
			createTable.execute();
			System.out.println("Create Table " + dbTableName + " OK!!!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Create Table " + dbTableName + " ERROR!!!");
		}
		
		
	}

	/// 그대로 사용 가능!!!
	public static Connection makeConnection() throws SQLException {
		// TODO Auto-generated method stub
		String driver = "com.mysql.cj.jdbc.Driver";
		String hostName = "sql6.freemysqlhosting.net";		
		String databaseName = "sql6448156";
		String utf8Connection = "?useUnicode=true&characterEncoding=utf8";
		String url = "jdbc:mysql://"+hostName+":3306/"+databaseName + utf8Connection;
		String userName = "sql6448156";
		String password = "Tec5ucNzLn";
		
		try {
			Class.forName(driver);
			System.out.println("JDBC Driver Load OK!!!");
			con = DriverManager.getConnection(url, userName, password);
			System.out.println("DB Connection OK!!");
			return con;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("\nError : Class.forName(driver)\n");
			return null;
		}
		
	}

	// ******* 수정 필요 ********
	public static void deleteFromTable(Connection con, String dbTableName, int std_id) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt;
		
		String deleteSQL = "DELETE FROM " + dbTableName + " WHERE std_id= ?;";
		try {
			pstmt = con.prepareStatement(deleteSQL);
			pstmt.setInt(1, std_id);
			pstmt.executeUpdate();
			System.out.println("Delete SQL OK!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Delete SQL ERROR!!!");
		}
		
	}
	
	public static void updateDataOnTable(Connection con, String dbTableName, int std_id, String dept, String name, int math, int science, int english) throws SQLException {
		// TODO Auto-generated method stub
		String updateTableSQL = "UPDATE " + dbTableName + " SET dept = ?, name = ?, math = ?, science = ?, english = ?  WHERE  std_id = ? ;" ;
		try {
			PreparedStatement updateTable = con.prepareStatement(updateTableSQL);
			
			updateTable.setString(1, dept);       //  '김철수'
			updateTable.setString(2, name);
			updateTable.setInt(3, math);
			updateTable.setInt(4, science);
			updateTable.setInt(5, english);
			updateTable.setInt(6, std_id);        // 
			
			updateTable.executeUpdate();
			System.out.println("수정 완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("수정 실패");
		}
		
	}
	public static void deleteAll(Connection con, String TableName) {
		String deleteAllSQL = " delete from "+TableName+ ";";
		try {
			PreparedStatement deleteAll = con.prepareStatement(deleteAllSQL);
			deleteAll.executeUpdate();
			System.out.println("전체 삭제완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("전체 삭제실패");
		}
	}


}