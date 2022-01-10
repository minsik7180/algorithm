package Friend디비;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FriendDBGUIFrame extends JFrame implements ActionListener, MouseListener{
	
	static Connection con;
	static String dbTableName = "Friends201858034";
	public DefaultTableModel model;
	public Vector title = new Vector();
	public JTable table = new JTable();
	public Vector result = new Vector();
	public Vector data = new Vector();
	public JPanel panelLow = new JPanel();
	String[] lbText = {"학번","학과(부)명","이름","전화번호"};
	public JLabel lb[] = new JLabel[lbText.length];
	public JTextField tf[] = new JTextField[lbText.length];
	String btnText[] = {"삽입","삭제","수정","초기화"};
	public JButton bt[] = new JButton[btnText.length];
	
	
	//String selectDataSQL = "select std_id, dept, name, phone from "+ dbTableName +";";
	PreparedStatement selectData;
	
	
	public FriendDBGUIFrame() throws SQLException {
		con = FriendConnectionDB.makeConnection();
		FriendConnectionDB.createTable(con, dbTableName);
		//FriendConnectionDB.insertDataOnTable(con, dbTableName, 201858034, "컴퓨터공학부", "최민식", "010-2434-4402");
		//Vector<String> list = FriendConnectionDB.getDataFromTable2(con,dbTableName);
		//FriendConnectionDB.printList2(list);
		
		this.setTitle("Friends GUI");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		
		title.add("학번");
		title.add("학과(부)명");
		title.add("이름");
		title.add("핸드폰번호");
		
		result = selectFromDB(con, dbTableName);
		
		model = new DefaultTableModel(result,title);
		table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		this.add(sp,BorderLayout.CENTER);
		
		panelLow.setLayout(new GridLayout(0,4));
		
		for(int i=0; i<lbText.length; i++) {
			lb[i] = new JLabel(lbText[i], JLabel.CENTER);
			tf[i] = new JTextField(15);
			
			panelLow.add(lb[i]);
			panelLow.add(tf[i]);
		}
		
		for(int i=0; i<btnText.length; i++) {
			bt[i] = new JButton(btnText[i]);
			panelLow.add(bt[i]);
			bt[i].addActionListener(this);
		}
		table.addMouseListener(this);
		
		this.add(panelLow,BorderLayout.SOUTH);
		this.pack();
		this.setVisible(true);
	}
	
	public Vector selectFromDB(Connection con2, String dbTableName) {
		String selectDataSQL = "select std_id, dept, name, phone from "+ dbTableName +";";
		PreparedStatement selectData;
		try {
			selectData = con.prepareStatement(selectDataSQL);
			ResultSet result = selectData.executeQuery();
			while(result.next()) {
				Vector<String> line = new Vector<String>();
				line.add(result.getString("std_id"));
				line.add(result.getString("dept"));
				line.add(result.getString("name"));
				line.add(result.getString("phone"));
				data.add(line);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// 버튼 액션 리스너
		
		if(e.getSource() == bt[0]) { // 삽입 버튼 
			int std_id = Integer.parseInt(tf[0].getText());
			String dept = tf[1].getText();
			String name = tf[2].getText();
			String phone = tf[3].getText();
			//FriendConnectionDB.insertDataOnTable(con, dbTableName, std_id, name, dept, phone);
			//result.clear();
			//result = selectFromDB(con,dbTableName);
			//model.setDataVector(result, data);
			
			
			//FriendConnectionDB.insertDataOnTable(con, dbTableName, Integer.parseInt(tf[0].getText()), tf[1].getText(), tf[2].getText(), tf[3].getText());
			FriendConnectionDB.insertDataOnTable(con, dbTableName, std_id, dept, name, phone);
			
			Vector tuple = new Vector();
			tuple.add(tf[0].getText());
			tuple.add(tf[1].getText());
			tuple.add(tf[2].getText());
			tuple.add(tf[3].getText());
			model.addRow(tuple);
		}
		
		if(e.getSource() == bt[1]) {//삭제 
			FriendConnectionDB.deleteOnTable(con, dbTableName, Integer.parseInt(tf[0].getText()));
			model.removeRow(table.getSelectedRow());
			
		}
		
		if(e.getSource() == bt[2]) {// 수정 
			FriendConnectionDB.update(con, dbTableName, Integer.parseInt(tf[0].getText()), tf[1].getText(), tf[2].getText(), tf[3].getText());
			int row = table.getSelectedRow();
			for(int i=0; i<lbText.length; i++) {
				table.setValueAt(tf[i].getText(), row, i);
			}
		}
		
		if(e.getSource() == bt[3]) { // 초기
			FriendConnectionDB.deleteAll(con, dbTableName);
			model.setNumRows(0);
		}
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int index = table.getSelectedRow();
		Vector<String> line = new Vector<String>();
		line = (Vector<String>)data.get(index);
		
		String std_id = line.get(0);
		String dept = line.get(1);
		String name = line.get(2);
		String phone = line.get(3);
		
		tf[0].setText(std_id);
		tf[1].setText(dept);
		tf[2].setText(name);
		tf[3].setText(phone);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
