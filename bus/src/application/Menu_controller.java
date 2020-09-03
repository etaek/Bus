package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Menu_controller implements Initializable {

	private Stage primarystage;
	private String start;
	private String end;
	private String date;
	private String price;
	private String day;
	private String MyName;
	private int seatNum;
	public void SetSeat(int seatnum) {
		this.seatNum=seatnum;
	}
	public void SetName(String name) {
		this.MyName=name;
	}
	public void SetBus(String start,String end, String date,String day) {
		this.start=start;
		this.end=end;
		this.date=date;
		this.day=day;
	}
	public void setstage(Stage primarystage) {
		this.primarystage = primarystage;
	}
	public Stage getstage() {
		return primarystage;
	}
	@FXML
	private Button Rbtn;
	private String fid;
	private String fname;
	@FXML
	private Label laId;
	@FXML
	private Label laName;
	@FXML
	private Label laName2;
	@FXML
	private Label laBirth;
	@FXML
	private Label laPhone;
	@FXML
	private Button info;
	@FXML
	private Button conBtn;
	@FXML private Label Start;
	@FXML private Label End;
	@FXML private Label Date;
	@FXML private Label Time;
	@FXML private Label Seatnum;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	public void SetId(String id) {
		this.fid=id;
	}
	public void SetText(String id) {
		this.fname=id;
		this.laName2.setText(id+"님 환영합니다!");
	}

	@FXML
	private void Reservebtn(ActionEvent event) throws IOException{
		Stage reserve = new Stage();
		reserve.setTitle("버스 좌석 예매 프로그램");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/Reserve.fxml"));
		Parent root = loader.load();			
		Scene scene = new Scene(root);
		Reserve_Demo rd=loader.getController();
		rd.SetId(fid);
		rd.SetName(fname);
		rd.SetStage(reserve);
		scene.getStylesheets().add(getClass().getResource("application.css").toString());
		reserve.setScene(scene);
		reserve.show();
		primarystage.close();
	}
	
	@FXML
	private void Confirmbtn(ActionEvent event) throws Exception{
		String seatnum=null;
		String start = null;
		String end=null;
		String date=null;
		String time=null;
		String jdbcUrl = "jdbc:mysql://localhost:3306/join?serverTimezone=UTC&SSL=false&useSSL=false";
        // MySQL id
        String dbId = "root";
        // MySQL password
        String dbPw = "dmsxor12";     
        System.out.println("MySQL JDBC 드라이버 로딩중...");
    	Class.forName("com.mysql.jdbc.Driver");
        Connection conn = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         try {
            conn = DriverManager.getConnection(jdbcUrl,dbId,dbPw);
            System.out.println("MySQL JDBC 드라이버 로딩 성공...");
           
            String query = "select * from member where id= '"+fid+"'";
            pstmt = conn.prepareStatement(query);
			  rs = pstmt.executeQuery();
            while(rs.next()) {
          	 start=rs.getString("start");
          	end=rs.getString("destination");
          	date=rs.getString("date");
          	time=rs.getString("time");
          	seatnum=Integer.toString(rs.getInt("seat"));
            }
       
			  
            
                  
         } catch (Exception e) {
            e.printStackTrace();
         }
      
		Stage primaryStage = new Stage();
		primaryStage.setTitle("버스 좌석 예매 프로그램");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/Confirm.fxml"));
		  
		Parent root = loader.load();		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toString());
		ConfirmController a = loader.getController();
		a.SetId(fid);
		a.SetStage(primaryStage);
		a.SetBus(start, end, time,date);
		a.SetSeat(seatnum);
		a.SetText(start, end, date, time, seatnum);
	
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@FXML
	private void LogoutBtn(ActionEvent event) throws IOException{
		Stage logoutstage = new Stage();
		logoutstage.setTitle("버스 좌석 예매 프로그램");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/Main.fxml"));
		
		Parent root = loader.load();		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toString());
		MainController mc=loader.getController();
		mc.SetStage(logoutstage);
		primarystage.close();
		
		logoutstage.setScene(scene);
		logoutstage.show();
	
	}
	@FXML
	private void go_guide(ActionEvent event) throws IOException{
		Stage guide = new Stage();
		guide.setTitle("버스 좌석 예매 프로그램");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/guide.fxml"));
		Parent root = loader.load();			
		Scene scene = new Scene(root);
		Menu_controller mc=loader.getController();
		mc.SetId(fid);
		mc.setstage(guide);
		scene.getStylesheets().add(getClass().getResource("application.css").toString());
		guide.setScene(scene);
		guide.show();
	}
	@FXML
	private void backmenu(ActionEvent event) throws IOException{
		primarystage.close();
		SetId(fid);
	}
	@FXML
	private void Information(ActionEvent event) throws Exception{
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/join?serverTimezone=UTC&SSL=false&useSSL=false";
		
		  String dbId = "root";
	
		  String dbPw = "dmsxor12";	  
			
		  System.out.println("MySQL JDBC 드라이버 로딩중...");
		  Class.forName("com.mysql.jdbc.Driver");
		  Connection conn = null;
		  PreparedStatement pstmt = null;
		  ResultSet rs = null;
		try {  
			Stage information = new Stage();
			information.setTitle("버스 좌석 예매 프로그램");
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/information.fxml"));
			Parent root = loader.load();
			conn = DriverManager.getConnection(jdbcUrl,dbId,dbPw);
			System.out.println("MySQL JDBC 드라이버 로딩 성공...");
			String query ="select * from member";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
			
				if(fname.equals(rs.getString(1))) {
					System.out.println(1);
					MainController ma=loader.getController();
					ma.SetText(rs.getString(1),rs.getString(2),rs.getString(5),rs.getString(4));
				}
			}
	
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toString());
				primarystage.close();
				MainController ma= loader.getController();
				System.out.println(fid);
				ma.SetMyId(fid);
				ma.SetMyName(fname);
				ma.SetStage2(information);
				setstage(information);
				information.setScene(scene);
			
				information.show();
			
		} catch(Exception e) {
            e.printStackTrace();	//���� ó�� 
        }
	
			
			
	}
	
	
	

}
