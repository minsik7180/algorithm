package 기말평가;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;





public class lastterm extends JFrame implements ActionListener, MouseListener{
	Connection con;
	String TableName = "lastterm201858034";
	public DefaultTableModel model;
	public JTable table;
	public JPanel westpanel = new JPanel();
	public JPanel bottompanel = new JPanel();
	public Vector title = new Vector();
	public Vector result = new Vector();
	public Vector data = new Vector();
	PreparedStatement selectData;
	ResultSet rs;
	String lbText[] = {"학번","학과(부)명","이름","수학","과학","국어"};
	String btText[] = {"삽입","삭제","수정","초기화","이전","이후","학점","개발자"};
	String blbText[] = {"이름","총점","평균","최고점","최저점"};
	
	JLabel lb[] = new JLabel[lbText.length];
	JLabel blb[] = new JLabel[blbText.length];
	JButton bt[] = new JButton[btText.length];
	JTextField tf[] = new JTextField[lbText.length];
	JTextField btf[] = new JTextField[blbText.length];
	public lastterm() throws SQLException {
		con = DBConnection.makeConnection();
		DBConnection.createTable(con, TableName);
		
		title.add("학번");
		title.add("학과(부)명");
		title.add("이름");
		title.add("수학");
		title.add("과학");
		title.add("영어");
		
		result = selectFromDB(con,TableName);
		model = new DefaultTableModel(result, title);   
		table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		this.add(sp, BorderLayout.CENTER);  
		
		westpanel.setLayout(new GridLayout(0,2));
		for(int i=0; i<lbText.length; i++) {
			lb[i] = new JLabel(lbText[i], JLabel.CENTER);
			tf[i] = new JTextField(10);
			westpanel.add(lb[i]);
			westpanel.add(tf[i]);
		}
		for(int i=0; i<btText.length; i++) {
			bt[i] = new JButton(btText[i]);
			westpanel.add(bt[i]);
			bt[i].addActionListener(this);
		}
		table.addMouseListener(this);
		
		bottompanel.setLayout(new GridLayout(0,10));
		for(int i=0; i<blbText.length; i++) {
			blb[i] = new JLabel(blbText[i], JLabel.CENTER);
			btf[i] = new JTextField(5);
			bottompanel.add(blb[i]);
			bottompanel.add(btf[i]);
		}
		
		this.add(bottompanel, BorderLayout.SOUTH);
		this.add(westpanel,BorderLayout.WEST);
		this.setTitle("기말평가 201858034");
		this.setSize(800,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
	}
	
	private Vector selectFromDB(Connection con2, String dbTableName2) {
		// TODO Auto-generated method stub
		String selectDataSQL = "SELECT std_id, dept, name, math, science, english FROM " + TableName + ";" ;
		try {
			selectData = con.prepareStatement(selectDataSQL);
			rs = selectData.executeQuery();
			while(rs.next()) {
				Vector<String> line = new Vector<String>();
				line.add(rs.getString("std_id"));
				line.add(rs.getString("dept"));
				line.add(rs.getString("name"));
				line.add(rs.getString("math"));
				line.add(rs.getString("science"));
				line.add(rs.getString("english"));
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
		if (e.getSource() == bt[0]) {   // 삽입 버튼 ... 
			int std_id = Integer.parseInt(tf[0].getText());
			String dept = tf[1].getText();
			String name = tf[2].getText();
			int math = Integer.parseInt(tf[3].getText());
			int science = Integer.parseInt(tf[4].getText());
			int english= Integer.parseInt(tf[5].getText());
			try {
				DBConnection.insertDataOnTable(con, TableName, std_id, dept, name, math, science, english);
				result.clear();
				result =  selectFromDB(con, TableName);
				model.setDataVector(result, title);
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == bt[1]) {   // 삭제 버튼 
			int std_id = Integer.parseInt(tf[0].getText());
			DBConnection.deleteFromTable(con, TableName, std_id);
			result.clear();
			result =  selectFromDB(con, TableName);
			model.setDataVector(result, title);
		}
		
		if (e.getSource() == bt[2]) {   // 수정 버튼 
			int std_id = Integer.parseInt(tf[0].getText());
			String dept = tf[1].getText();
			String name = tf[2].getText();
			int math = Integer.parseInt(tf[3].getText());
			int science = Integer.parseInt(tf[4].getText());
			int english= Integer.parseInt(tf[5].getText());
			try {
				DBConnection.updateDataOnTable(con, TableName, std_id, dept, name, math, science, english);
				System.out.println("수정 완료");
				result.clear();
				result =  selectFromDB(con, TableName);
				model.setDataVector(result, title);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("수정 실패");
			}
		}
		
		if (e.getSource() == bt[3]) {   // 초기화 버튼 ... 
			
			for(int i=0; i<lbText.length; i++) {
			tf[i].setText("");
			}
			for(int i=0; i<blbText.length; i++) {
				btf[i].setText("");
			}
		}
		
		if (e.getSource() == bt[4]) {
			try {
				
				if(rs.previous()) {
					tf[0].setText(rs.getString("std_id"));
					tf[1].setText(rs.getString("dept"));
					tf[2].setText(rs.getString("name"));
					tf[3].setText(rs.getString("math"));
					tf[4].setText(rs.getString("science"));
					tf[3].setText(rs.getString("english"));
					
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == bt[5]) {
			try {
				if(rs.next()) {
					tf[0].setText(rs.getString("std_id"));
					tf[1].setText(rs.getString("dept"));
					tf[2].setText(rs.getString("name"));
					tf[3].setText(rs.getString("math"));
					tf[4].setText(rs.getString("science"));
					tf[3].setText(rs.getString("english"));
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == bt[6]) {//추가 기능
		
			int math = Integer.parseInt(tf[3].getText());
			int science = Integer.parseInt(tf[4].getText());
			int english = Integer.parseInt(tf[5].getText());
			int sum = math + science + english;
			int avg = sum/3;
			
			if(avg > 90) {
				JOptionPane.showMessageDialog(null, "A학점입니다");
			}
			else if(avg >=80 && avg <=90) {
				JOptionPane.showMessageDialog(null, "B학점입니다");
			}
			else if(avg >=70 && avg <=80) {
				JOptionPane.showMessageDialog(null, "C학점입니다");
			}
			else if(avg >=60 && avg <=70) {
				JOptionPane.showMessageDialog(null, "D학점입니다");
			}
			else {
				JOptionPane.showMessageDialog(null, "F학점입니다");
			}
			
		}
		
		if(e.getSource() == bt[7]) {
			JOptionPane.showMessageDialog(null, "개발자 : 201858034, 최민식, 2021.12.14");
		}
		
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int index = table.getSelectedRow();
		Vector<String> line = new Vector<String>();
		line = (Vector<String>) data.get(index);

		
		for (int i=0; i<tf.length; i++) {
			tf[i].setText(line.get(i));
		}
		btf[0].setText(line.get(2));
		
		int math = Integer.parseInt(line.get(3));
		int science = Integer.parseInt(line.get(4));
		int english = Integer.parseInt(line.get(5));
		int sum = math + science + english;
		int avg = sum/3;
		
		int max = Math.max(Math.max(math,science),english);
		int min = Math.min(Math.min(math, science),english);
		
		btf[1].setText(Integer.toString(sum));
		btf[2].setText(Integer.toString(avg));
		btf[3].setText(Integer.toString(max));
		btf[4].setText(Integer.toString(min));
		
		
		
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
