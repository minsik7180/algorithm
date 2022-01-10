package db;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BookGUIFrame extends JFrame implements ActionListener{
	static Connection con = null;
	String labelText[] = {"ID","Title","Publisher","Year","Price"};
	JLabel[] lb = new JLabel[labelText.length];
	JTextField[] tf = new JTextField[labelText.length];
	String[] btnText = {"Previous", "Next", "Insert", "Delete", "Reset", "Sorting"};
	JButton[] btn = new JButton[btnText.length];
	ResultSet result;
	PreparedStatement pstmt;
	public BookGUIFrame() throws SQLException {
		
		con = Connectiondb.makeConnection();
		Connectiondb.dropTable(con, "books201858034");
		Connectiondb.createTable(con);
		ArrayList<String> list = Connectiondb.getDataFromTable(con);
		Connectiondb.printList(list);
		
		this.setTitle("Books DB GUI");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,350);
		this.setLayout(new GridLayout(0,2));
		
		String selectDataSQL = "select * from books201858034;";
		pstmt = con.prepareStatement(selectDataSQL);
		result = pstmt.executeQuery();
		
		for(int i=0; i<labelText.length; i++) {
			lb[i] = new JLabel(labelText[i], JLabel.CENTER);
			tf[i] = new JTextField(20);
			this.add(lb[i]);
			this.add(tf[i]);
		}
		
		for(int i=0; i<btnText.length; i++) {
			btn[i] = new JButton(btnText[i]);
			this.add(btn[i]);
			btn[i].addActionListener(this);
		}
		
		this.pack();
		this.setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btn[0]){
			try {
				if(result.previous()) {
					tf[0].setText(result.getString("Book_id"));
					tf[1].setText(result.getString("title"));
					tf[2].setText(result.getString("publisher"));
					tf[3].setText(result.getString("year"));
					tf[4].setText(Integer.toString(result.getInt("price")));
				}
				System.out.println("previous button ok");
			} catch(SQLException e1) {
				e1.printStackTrace();
				System.out.println("previous button error");
			}
		}
		
		if(e.getSource() == btn[1]) {
			try {
				if(result.next()) {
					tf[0].setText(result.getString("Book_id"));
					tf[1].setText(result.getString("title"));
					tf[2].setText(result.getString("publisher"));
					tf[3].setText(result.getString("year"));
					tf[4].setText(Integer.toString(result.getInt("price")));
				}
				System.out.println("next button ok");
			} catch (SQLException e1) {
				e1.printStackTrace();
				System.out.println("next button error");
			}
		}
		if(e.getSource()== btn[2]) {
			Connectiondb.insertDataOnTable(con, tf[1].getText(), tf[2].getText(), tf[3].getText(), Integer.parseInt(tf[4].getText()));
			String selectDataSQL = "select * from books201858034;";
			try {
				pstmt = con.prepareStatement(selectDataSQL);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				result = pstmt.executeQuery();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(e.getSource()== btn[3]) {
				Connectiondb.deleteOnTable(con, tf[1].getText(), tf[2].getText(), tf[3].getText(), Integer.parseInt(tf[4].getText()));		
				selectDataSQL = "select * from books 201858034";
				try {
					pstmt = con.prepareStatement(selectDataSQL);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					result = pstmt.executeQuery();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
	}
}
