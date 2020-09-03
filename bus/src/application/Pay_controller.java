package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Pay_controller implements Initializable {
	
	private String MyName;
	private String MyId;
	private int seatNum;
	private String start;
	private String end;
	private String date;
	private String price;
	private String day;
	private Stage primaryStage;
	private Stage primaryStage2;
	private int emptySeat;
	public void SetSeat2(int seat) {
		this.emptySeat=seat;
	}
	public void SetStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	public void SetStage2(Stage primaryStage) {
		this.primaryStage2 = primaryStage;
	}
	public void SetName(String name) {
		this.MyName=name;
	}
	public void SetId(String id) {
		this.MyId=id;
	}
	public void SetSeat(int seatnum) {
		this.seatNum=seatnum;
	}
	public void SetBus(String start,String end, String date,String day) {
		this.start=start;
		this.end=end;
		this.date=date;
		this.day=day;
	}
	public void SetPrice(String price) {
		this.price=price;
	}
	public void SetText(String price) {
		Price.setText(price);
	}
	public void SetItem(ObservableList<String> cardList,ObservableList<Integer> monthList,ObservableList<Integer> yearList) {
		this.card_combo.setItems(cardList);
		this.Month.setItems(monthList);
		this.Year.setItems(yearList);
	}
	
	@FXML
	private Label Price;
	@FXML
	private ComboBox<String> card_combo;
	
	@FXML
	private ComboBox<Integer> Month;
	
	
	@FXML
	private ComboBox<Integer> Year;
	
	
	@FXML
	private Button cancel;
	
	@FXML
	private Button P_yes;
	
	@FXML
	private Button P_no;
	
	@FXML
	private Button paybtn;
	@FXML
	private void pay_yes(ActionEvent event) throws Exception{
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/join?serverTimezone=UTC&SSL=false&useSSL=false";
        // MySQL id
        String dbId = "root";
        // MySQL password
        String dbPw = "dmsxor12";   
        int seat;
        System.out.println("MySQL JDBC 드라이버 로딩중...");
    	Class.forName("com.mysql.jdbc.Driver");
        Connection conn = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         System.out.println(MyId);
         try {
            conn = DriverManager.getConnection(jdbcUrl,dbId,dbPw);
            System.out.println("MySQL JDBC 드라이버 로딩 성공...");
           
     
			  
            String query = "update member set start = '" + start + "', destination = '" + end + "', date = '" + day + "', time = '"+date+ "',seat = '"+seatNum+"' WHERE id = '"+MyId+"'";   //명령어

          
            pstmt = conn.prepareStatement(query);
            pstmt.executeUpdate();   //명령어를 mysql에 보내는 함수
                    
            query="select *from info";
            pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
		
            while(rs.next()) {
            	if(start.equals(rs.getString(1))&&end.equals(rs.getString(2))&&date.equals(rs.getString(3))) {
            		seat=rs.getInt(6);
            		SetSeat2(seat);
            	}
            }
         
            query="update info set seat = '"+(emptySeat-1)+"' WHERE start = '"+start+"'and end = '"+end+"'and starttime = '"+date+"'";
            pstmt = conn.prepareStatement(query);
            pstmt.executeUpdate(); 
            
                  
         } catch (Exception e) {
            e.printStackTrace();
         }
		
		Stage yes = new Stage();
		yes.setTitle("버스 좌석 예매 프로그램");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/pay_confirm.fxml"));
	
		Parent root = loader.load();	
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toString());
		Pay_controller pc=loader.getController();
		pc.SetStage(yes);
		pc.SetStage2(primaryStage2);
		pc.SetId(MyId);
		pc.SetBus(start, end, date, day);
		pc.SetName(MyName);
		pc.SetSeat(seatNum);
		yes.setScene(scene);
		yes.show();
		primaryStage.close();
	}
	@FXML
	private void backToManu(ActionEvent event) throws IOException{
		Stage re = new Stage();
		re.setTitle("버스 좌석 예매 프로그램");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/Reserve.fxml"));
	
		Parent root = loader.load();	
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toString());
		Reserve_Demo rd=loader.getController();
		rd.SetStage(re);
		rd.SetName(MyName);
		
		re.setScene(scene);
		re.show();
		primaryStage.close();
	}
	@FXML
	private void pay_no(ActionEvent event) throws IOException{
		primaryStage.close();
	}
	
	@FXML
	private void payConfitmClose(ActionEvent event) throws IOException{
		Stage menu = new Stage();
		menu.setTitle("버스 좌석 예매 프로그램");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/Menu.fxml"));
	
		Parent root = loader.load();	
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toString());
		Menu_controller mc=loader.getController();
		mc.SetId(MyId);
		mc.setstage(menu);
		mc.SetBus(start, end, date, day);
		mc.SetName(MyName);
		mc.SetSeat(seatNum);
		mc.SetText(MyName);
		
		menu.setScene(scene);
		menu.show();
		primaryStage.close();
		primaryStage2.close();
	}
	
	@FXML
	private void pay(ActionEvent event) throws IOException{
		
		
		Stage pay = new Stage();
		pay.setTitle("버스 좌석 예매 프로그램");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/pay_end.fxml"));
		
		Parent root = loader.load();		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toString());
		Pay_controller pa=loader.getController();
		pa.SetStage(pay);
		pa.SetStage2(primaryStage2);
		pa.SetBus(start, end, date,day);
		pa.SetId(MyId);
		System.out.println("ID:"+MyId);
		pa.SetSeat(seatNum);
		pa.SetName(MyName);
		
		pay .setScene(scene);
		pay .show();
	}
	

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
	}
}
