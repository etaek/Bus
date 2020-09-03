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
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Seat_controller implements Initializable{
	
	private Stage primaryStage1;
	private Stage primaryStage2;
	private String MyName;
	private String MyId;
	private int seatNum;
	private String start;
	private String end;
	private String date;
	private String price;
	private String day;
	
	private int emptySeat;
	public void SetStage(Stage primaryStage) {
		this.primaryStage1 = primaryStage;
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
	public void SetSeat2(int seat) {
		this.emptySeat=seat;
	}
	public void SetPrice(String price) {
		this.price=price;
	}
	private boolean bseat1=true; private boolean bseat2=true; private boolean bseat3=true; private boolean bseat4=true;
	private boolean bseat5=true; private boolean bseat6=true; private boolean bseat7=true; private boolean bseat8=true;
	private boolean bseat9=true; private boolean bseat10=true; private boolean bseat11=true; private boolean bseat12=true;
	private boolean bseat13=true; private boolean bseat14=true; private boolean bseat15=true; private boolean bseat16=true;
	private boolean bseat17=true; private boolean bseat18=true; private boolean bseat19=true; private boolean bseat20=true;
	private boolean bseat21=true; private boolean bseat22=true; private boolean bseat23=true; private boolean bseat24=true;
	private boolean bseat25=true;

	public void SetImage(String image) { this.seat1.setImage(new Image(image)); bseat1=false;}
	public void SetImage2(String image) { this.seat2.setImage(new Image(image));bseat2=false;}
	public void SetImage3(String image) { this.seat3.setImage(new Image(image));bseat3=false;}
	public void SetImage4(String image) { this.seat4.setImage(new Image(image));bseat4=false;}
	public void SetImage5(String image) { this.seat5.setImage(new Image(image));bseat5=false;}
	public void SetImage6(String image) { this.seat6.setImage(new Image(image));bseat6=false;}
	public void SetImage7(String image) { this.seat7.setImage(new Image(image));bseat7=false;}
	public void SetImage8(String image) { this.seat8.setImage(new Image(image));bseat8=false;}
	public void SetImage9(String image) { this.seat9.setImage(new Image(image));bseat9=false;}
	public void SetImage10(String image) { this.seat10.setImage(new Image(image));bseat10=false;}
	public void SetImage11(String image) { this.seat11.setImage(new Image(image));bseat11=false;}
	public void SetImage12(String image) { this.seat12.setImage(new Image(image));bseat12=false;}
	public void SetImage13(String image) { this.seat13.setImage(new Image(image));bseat13=false;}
	public void SetImage14(String image) { this.seat14.setImage(new Image(image));bseat14=false;}
	public void SetImage15(String image) { this.seat15.setImage(new Image(image));bseat15=false;}
	public void SetImage16(String image) { this.seat16.setImage(new Image(image));bseat16=false;}
	public void SetImage17(String image) { this.seat17.setImage(new Image(image));bseat17=false;}
	public void SetImage18(String image) { this.seat18.setImage(new Image(image));bseat18=false;}
	public void SetImage19(String image) { this.seat19.setImage(new Image(image));bseat19=false;}
	public void SetImage20(String image) { this.seat20.setImage(new Image(image));bseat20=false;}
	public void SetImage21(String image) { this.seat21.setImage(new Image(image));bseat21=false;}
	public void SetImage22(String image) { this.seat22.setImage(new Image(image));bseat22=false;}
	public void SetImage23(String image) { this.seat23.setImage(new Image(image));bseat23=false;}
	public void SetImage24(String image) { this.seat24.setImage(new Image(image));bseat24=false;}
	public void SetImage25(String image) { this.seat25.setImage(new Image(image));bseat25=false;}
	@FXML private ImageView seat1;
	@FXML private ImageView seat2;
	@FXML private ImageView seat3;
	@FXML private ImageView seat4;
	@FXML private ImageView seat5;
	@FXML private ImageView seat6;
	@FXML private ImageView seat7;
	@FXML private ImageView seat8;
	@FXML private ImageView seat9;
	@FXML private ImageView seat10;
	@FXML private ImageView seat11;
	@FXML private ImageView seat12;
	@FXML private ImageView seat13;
	@FXML private ImageView seat14;
	@FXML private ImageView seat15;
	@FXML private ImageView seat16;
	@FXML private ImageView seat17;
	@FXML private ImageView seat18;
	@FXML private ImageView seat19;
	@FXML private ImageView seat20;
	@FXML private ImageView seat21;
	@FXML private ImageView seat22;
	@FXML private ImageView seat23;
	@FXML private ImageView seat24;
	@FXML private ImageView seat25;
	
	@FXML private Button yes;
	
	@FXML private ComboBox<String> card_combo;
	@FXML private ComboBox<Integer> Month;
	@FXML private ComboBox<Integer> Year;
	
	ObservableList<String> cardList = FXCollections.observableArrayList("NH농협카드","신한카드","BC카드","KB국민카드","삼성카드","현대카드","롯데카드","하나카드","카카오뱅크카드","새마을금고카드");
	ObservableList<Integer> monthList = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12);
	ObservableList<Integer> yearList = FXCollections.observableArrayList(18,19,20,21,22,23,24,25,26);
	
	@FXML
	private void Click_seat() throws IOException{

		if(bseat1!=false) {
		if(seat1.onMouseClickedProperty()!=null) {seatNum=1;}
		
		Stage primaryStage = new Stage();
		primaryStage.setTitle("버스 좌석 예매 프로그램");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/Seat22.fxml"));
		Parent root = loader.load();		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toString());
		Seat_controller se=loader.getController();
		se.SetStage(primaryStage);
		se.SetSeat(seatNum);
		se.SetId(MyId);se.SetName(MyName);
		se.SetStage2(primaryStage2);
		se.SetBus(start, end, date, day); se.SetPrice(price); 
		primaryStage.setScene(scene);
		primaryStage.show();
		}
		
	}
	@FXML
	private void Click_seat2() throws IOException{
		if(bseat2!=false) {
		if(seat2.onMousePressedProperty()!=null) {seatNum=2;}
		
		
		Stage primaryStage = new Stage();
		primaryStage.setTitle("버스 좌석 예매 프로그램");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/Seat22.fxml"));
		System.out.println("좌석:"+seatNum);
		Parent root = loader.load();		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toString());
		Seat_controller se=loader.getController();
		se.SetStage(primaryStage);
		se.SetSeat(seatNum);
		se.SetId(MyId);se.SetName(MyName);
		se.SetBus(start, end, date,day); se.SetPrice(price);se.SetStage2(primaryStage2); 
		primaryStage.setScene(scene);
		primaryStage.show();
		}
	}
	@FXML
	private void Click_seat3() throws IOException{
		if(bseat3!=false) {
		if(seat3.onMousePressedProperty()!=null) {seatNum=3;}
		
		
		Stage primaryStage = new Stage();
		primaryStage.setTitle("버스 좌석 예매 프로그램");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/Seat22.fxml"));
		System.out.println("좌석:"+seatNum);
		Parent root = loader.load();		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toString());
		Seat_controller se=loader.getController();
		se.SetStage(primaryStage);
		se.SetSeat(seatNum);
		se.SetId(MyId);se.SetName(MyName);
		se.SetBus(start, end, date,day); se.SetPrice(price);se.SetStage2(primaryStage2); 
		primaryStage.setScene(scene);
		primaryStage.show();
		}
	}
	@FXML
	private void Click_seat4() throws IOException{
		if(bseat4!=false) {
		if(seat4.onMousePressedProperty()!=null) {seatNum=4;}
		
		
		Stage primaryStage = new Stage();
		primaryStage.setTitle("버스 좌석 예매 프로그램");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/Seat22.fxml"));
		System.out.println("좌석:"+seatNum);
		Parent root = loader.load();		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toString());
		Seat_controller se=loader.getController();
		se.SetStage(primaryStage);
		se.SetSeat(seatNum);
		se.SetId(MyId);se.SetName(MyName);
		se.SetBus(start, end, date,day); se.SetPrice(price);se.SetStage2(primaryStage2); 
		primaryStage.setScene(scene);
		primaryStage.show();
		}
	}
	@FXML
	private void Click_seat5() throws IOException{
		if(bseat5!=false) {
		if(seat5.onMousePressedProperty()!=null) {seatNum=5;}
		
		
		Stage primaryStage = new Stage();
		primaryStage.setTitle("버스 좌석 예매 프로그램");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/Seat22.fxml"));
		System.out.println("좌석:"+seatNum);
		Parent root = loader.load();		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toString());
		Seat_controller se=loader.getController();
		se.SetStage(primaryStage);
		se.SetSeat(seatNum);
		se.SetId(MyId);se.SetName(MyName);
		se.SetBus(start, end, date,day); se.SetPrice(price);se.SetStage2(primaryStage2); 
		primaryStage.setScene(scene);
		primaryStage.show();
		}
	}
	@FXML
	private void Click_seat6() throws IOException{
		if(bseat6!=false) {
		if(seat6.onMousePressedProperty()!=null) {seatNum=6;}
		
		
		Stage primaryStage = new Stage();
		primaryStage.setTitle("버스 좌석 예매 프로그램");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/Seat22.fxml"));
		System.out.println("좌석:"+seatNum);
		Parent root = loader.load();		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toString());
		Seat_controller se=loader.getController();
		se.SetStage(primaryStage);
		se.SetSeat(seatNum);
		se.SetId(MyId);se.SetName(MyName);
		se.SetBus(start, end, date,day); se.SetPrice(price);se.SetStage2(primaryStage2); 
		primaryStage.setScene(scene);
		primaryStage.show();
		}
	}
	@FXML
	private void Click_seat7() throws IOException{
		if(bseat7!=false) {
		if(seat7.onMousePressedProperty()!=null) {seatNum=7;}
		
		
		Stage primaryStage = new Stage();
		primaryStage.setTitle("버스 좌석 예매 프로그램");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/Seat22.fxml"));
		System.out.println("좌석:"+seatNum);
		Parent root = loader.load();		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toString());
		Seat_controller se=loader.getController();
		se.SetStage(primaryStage);
		se.SetSeat(seatNum);
		se.SetId(MyId);se.SetName(MyName);
		se.SetBus(start, end, date,day); se.SetPrice(price);se.SetStage2(primaryStage2); 
		primaryStage.setScene(scene);
		primaryStage.show();
		}
	}
	@FXML
	private void Click_seat8() throws IOException{
		if(bseat8!=false) {
		if(seat8.onMousePressedProperty()!=null) {seatNum=8;}
		
		
		Stage primaryStage = new Stage();
		primaryStage.setTitle("버스 좌석 예매 프로그램");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/Seat22.fxml"));
		System.out.println("좌석:"+seatNum);
		Parent root = loader.load();		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toString());
		Seat_controller se=loader.getController();
		se.SetStage(primaryStage);
		se.SetSeat(seatNum);
		se.SetId(MyId);se.SetName(MyName);
		se.SetBus(start, end, date,day); se.SetPrice(price);se.SetStage2(primaryStage2); 
		primaryStage.setScene(scene);
		primaryStage.show();
		}
	}
	@FXML
	private void Click_seat9() throws IOException{
		if(bseat9!=false) {
		if(seat9.onMousePressedProperty()!=null) {seatNum=9;}
		
		
		Stage primaryStage = new Stage();
		primaryStage.setTitle("버스 좌석 예매 프로그램");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/Seat22.fxml"));
		System.out.println("좌석:"+seatNum);
		Parent root = loader.load();		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toString());
		Seat_controller se=loader.getController();
		se.SetStage(primaryStage);
		se.SetSeat(seatNum);
		se.SetId(MyId);se.SetName(MyName);
		se.SetBus(start, end, date,day); se.SetPrice(price);se.SetStage2(primaryStage2); 
		primaryStage.setScene(scene);
		primaryStage.show();
		}
	}
	@FXML
	private void Click_seat10() throws IOException{
		if(bseat10!=false) {
		if(seat10.onMousePressedProperty()!=null) {seatNum=10;}
		
		
		Stage primaryStage = new Stage();
		primaryStage.setTitle("버스 좌석 예매 프로그램");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/Seat22.fxml"));
		System.out.println("좌석:"+seatNum);
		Parent root = loader.load();		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toString());
		Seat_controller se=loader.getController();
		se.SetStage(primaryStage);
		se.SetSeat(seatNum);
		se.SetId(MyId);se.SetName(MyName);
		se.SetBus(start, end, date,day); se.SetPrice(price);se.SetStage2(primaryStage2); 
		primaryStage.setScene(scene);
		primaryStage.show();
		}
	}
	@FXML
	private void Click_seat11() throws IOException{
		if(bseat11!=false) {
		if(seat11.onMousePressedProperty()!=null) {seatNum=11;}
		
		
		Stage primaryStage = new Stage();
		primaryStage.setTitle("버스 좌석 예매 프로그램");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/Seat22.fxml"));
		System.out.println("좌석:"+seatNum);
		Parent root = loader.load();		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toString());
		Seat_controller se=loader.getController();
		se.SetStage(primaryStage);
		se.SetSeat(seatNum);
		se.SetId(MyId);se.SetName(MyName);
		se.SetBus(start, end, date,day); se.SetPrice(price);se.SetStage2(primaryStage2); 
		primaryStage.setScene(scene);
		primaryStage.show();
		}
	}
	@FXML
	private void Click_seat12() throws IOException{
		if(bseat12!=false) {
		if(seat12.onMousePressedProperty()!=null) {seatNum=12;}
		
		
		Stage primaryStage = new Stage();
		primaryStage.setTitle("버스 좌석 예매 프로그램");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/Seat22.fxml"));
		System.out.println("좌석:"+seatNum);
		Parent root = loader.load();		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toString());
		Seat_controller se=loader.getController();
		se.SetStage(primaryStage);
		se.SetSeat(seatNum);
		se.SetId(MyId);se.SetName(MyName);
		se.SetBus(start, end, date,day); se.SetPrice(price);se.SetStage2(primaryStage2); 
		primaryStage.setScene(scene);
		primaryStage.show();
		}
	}
	@FXML
	private void Click_seat13() throws IOException{
		if(bseat13!=false) {
		if(seat13.onMousePressedProperty()!=null) {seatNum=13;}
		
		
		Stage primaryStage = new Stage();
		primaryStage.setTitle("버스 좌석 예매 프로그램");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/Seat22.fxml"));
		System.out.println("좌석:"+seatNum);
		Parent root = loader.load();		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toString());
		Seat_controller se=loader.getController();
		se.SetStage(primaryStage);
		se.SetSeat(seatNum);
		se.SetId(MyId);se.SetName(MyName);
		se.SetBus(start, end, date,day); se.SetPrice(price);se.SetStage2(primaryStage2); 
		primaryStage.setScene(scene);
		primaryStage.show();
		}
	}
	@FXML
	private void Click_seat14() throws IOException{
		if(bseat14!=false) {
		if(seat14.onMousePressedProperty()!=null) {seatNum=14;}
		
		
		Stage primaryStage = new Stage();
		primaryStage.setTitle("버스 좌석 예매 프로그램");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/Seat22.fxml"));
		System.out.println("좌석:"+seatNum);
		Parent root = loader.load();		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toString());
		Seat_controller se=loader.getController();
		se.SetStage(primaryStage);
		se.SetSeat(seatNum);
		se.SetId(MyId);se.SetName(MyName);
		se.SetBus(start, end, date,day); se.SetPrice(price);se.SetStage2(primaryStage2); 
		primaryStage.setScene(scene);
		primaryStage.show();
		}
	}
	@FXML
	private void Click_seat15() throws IOException{
		if(bseat15!=false) {
		if(seat15.onMousePressedProperty()!=null) {seatNum=15;}
		
		
		Stage primaryStage = new Stage();
		primaryStage.setTitle("버스 좌석 예매 프로그램");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/Seat22.fxml"));
		System.out.println("좌석:"+seatNum);
		Parent root = loader.load();		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toString());
		Seat_controller se=loader.getController();
		se.SetStage(primaryStage);
		se.SetSeat(seatNum);
		se.SetId(MyId);se.SetName(MyName);
		se.SetBus(start, end, date,day); se.SetPrice(price);se.SetStage2(primaryStage2); 
		primaryStage.setScene(scene);
		primaryStage.show();
		}
	}
	@FXML
	private void Click_seat16() throws IOException{
		if(bseat16!=false) {
		if(seat16.onMousePressedProperty()!=null) {seatNum=16;}
		
		
		Stage primaryStage = new Stage();
		primaryStage.setTitle("버스 좌석 예매 프로그램");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/Seat22.fxml"));
		System.out.println("좌석:"+seatNum);
		Parent root = loader.load();		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toString());
		Seat_controller se=loader.getController();
		se.SetStage(primaryStage);
		se.SetSeat(seatNum);
		se.SetId(MyId);se.SetName(MyName);
		se.SetBus(start, end, date,day); se.SetPrice(price);se.SetStage2(primaryStage2); 
		primaryStage.setScene(scene);
		primaryStage.show();
		}
	}
	@FXML
	private void Click_seat17() throws IOException{
		if(bseat17!=false) {
		if(seat17.onMousePressedProperty()!=null) {seatNum=17;}
		
		
		Stage primaryStage = new Stage();
		primaryStage.setTitle("버스 좌석 예매 프로그램");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/Seat22.fxml"));
		System.out.println("좌석:"+seatNum);
		Parent root = loader.load();		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toString());
		Seat_controller se=loader.getController();
		se.SetStage(primaryStage);
		se.SetSeat(seatNum);
		se.SetId(MyId);se.SetName(MyName);
		se.SetBus(start, end, date,day); se.SetPrice(price);se.SetStage2(primaryStage2); 
		primaryStage.setScene(scene);
		primaryStage.show();
		}
	}
	@FXML
	private void Click_seat18() throws IOException{
		if(bseat18!=false) {
		if(seat18.onMousePressedProperty()!=null) {seatNum=18;}
		
		
		Stage primaryStage = new Stage();
		primaryStage.setTitle("버스 좌석 예매 프로그램");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/Seat22.fxml"));
		System.out.println("좌석:"+seatNum);
		Parent root = loader.load();		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toString());
		Seat_controller se=loader.getController();
		se.SetStage(primaryStage);
		se.SetSeat(seatNum);
		se.SetId(MyId);se.SetName(MyName);
		se.SetBus(start, end, date,day); se.SetPrice(price);se.SetStage2(primaryStage2); 
		primaryStage.setScene(scene);
		primaryStage.show();
		}
	}
	@FXML
	private void Click_seat19() throws IOException{
		if(bseat19!=false) {
		if(seat19.onMousePressedProperty()!=null) {seatNum=19;}
		
		
		Stage primaryStage = new Stage();
		primaryStage.setTitle("버스 좌석 예매 프로그램");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/Seat22.fxml"));
		System.out.println("좌석:"+seatNum);
		Parent root = loader.load();		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toString());
		Seat_controller se=loader.getController();
		se.SetStage(primaryStage);
		se.SetSeat(seatNum);
		se.SetId(MyId);se.SetName(MyName);
		se.SetBus(start, end, date,day); se.SetPrice(price);se.SetStage2(primaryStage2); 
		primaryStage.setScene(scene);
		primaryStage.show();
		}
	}
	@FXML
	private void Click_seat20() throws IOException{
		if(bseat20!=false) {
		if(seat20.onMousePressedProperty()!=null) {seatNum=20;}
		
		
		Stage primaryStage = new Stage();
		primaryStage.setTitle("버스 좌석 예매 프로그램");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/Seat22.fxml"));
		System.out.println("좌석:"+seatNum);
		Parent root = loader.load();		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toString());
		Seat_controller se=loader.getController();
		se.SetStage(primaryStage);
		se.SetSeat(seatNum);
		se.SetId(MyId);se.SetName(MyName);
		se.SetBus(start, end, date,day); se.SetPrice(price);se.SetStage2(primaryStage2); 
		primaryStage.setScene(scene);
		primaryStage.show();
		}
	}
	@FXML
	private void Click_seat21() throws IOException{
		if(bseat21!=false) {
		if(seat21.onMousePressedProperty()!=null) {seatNum=21;}
		
		
		Stage primaryStage = new Stage();
		primaryStage.setTitle("버스 좌석 예매 프로그램");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/Seat22.fxml"));
		System.out.println("좌석:"+seatNum);
		Parent root = loader.load();		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toString());
		Seat_controller se=loader.getController();
		se.SetStage(primaryStage);
		se.SetSeat(seatNum);
		se.SetId(MyId);se.SetName(MyName);
		se.SetBus(start, end, date,day); 
		se.SetStage2(primaryStage2);
		se.SetPrice(price); 
		primaryStage.setScene(scene);
		primaryStage.show();
		}
	}
	@FXML
	private void Click_seat22() throws IOException{
		if(bseat22!=false) {
		if(seat22.onMousePressedProperty()!=null) {seatNum=22;}
		
		
		Stage primaryStage = new Stage();
		primaryStage.setTitle("버스 좌석 예매 프로그램");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/Seat22.fxml"));
		System.out.println("좌석:"+seatNum);
		Parent root = loader.load();		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toString());
		Seat_controller se=loader.getController();
		se.SetStage(primaryStage);
		se.SetSeat(seatNum);
		se.SetId(MyId);se.SetName(MyName);
		se.SetBus(start, end, date,day); 
		se.SetStage2(primaryStage2);
		se.SetPrice(price); 
		primaryStage.setScene(scene);
		primaryStage.show();
		}
	}
	@FXML
	private void Click_seat23() throws IOException{
		if(bseat23!=false) {
		if(seat23.onMousePressedProperty()!=null) {seatNum=23;}
		
		
		Stage primaryStage = new Stage();
		primaryStage.setTitle("버스 좌석 예매 프로그램");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/Seat22.fxml"));
		System.out.println("좌석:"+seatNum);
		Parent root = loader.load();		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toString());
		Seat_controller se=loader.getController();
		se.SetStage(primaryStage);
		se.SetSeat(seatNum);
		se.SetId(MyId);se.SetName(MyName);
		se.SetBus(start, end, date,day); 
		se.SetStage2(primaryStage2);
		se.SetPrice(price); 
		primaryStage.setScene(scene);
		primaryStage.show();
		}
	}
	@FXML
	private void Click_seat24() throws IOException{
		if(bseat24!=false) {
		if(seat24.onMousePressedProperty()!=null) {seatNum=24;}
		
		
		Stage primaryStage = new Stage();
		primaryStage.setTitle("버스 좌석 예매 프로그램");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/Seat22.fxml"));
		System.out.println("좌석:"+seatNum);
		Parent root = loader.load();		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toString());
		Seat_controller se=loader.getController();
		se.SetStage(primaryStage);
		se.SetSeat(seatNum);
		se.SetId(MyId);se.SetName(MyName);
		se.SetBus(start, end, date,day);
		se.SetStage2(primaryStage2);
		se.SetPrice(price); 
		primaryStage.setScene(scene);
		primaryStage.show();
		}
	}
	@FXML
	private void Click_seat25() throws IOException{
		if(bseat25!=false) {
		if(seat25.onMousePressedProperty()!=null) {seatNum=25;}
		
		
		Stage primaryStage = new Stage();
		primaryStage.setTitle("버스 좌석 예매 프로그램");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/Seat22.fxml"));
		System.out.println("좌석:"+seatNum);
		Parent root = loader.load();		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toString());
		Seat_controller se=loader.getController();
		se.SetStage(primaryStage);
		se.SetSeat(seatNum);
		se.SetId(MyId);se.SetName(MyName);
		se.SetBus(start, end, date,day); 
		se.SetStage2(primaryStage2);
		se.SetPrice(price); 
		primaryStage.setScene(scene);
		primaryStage.show();
		}
	}
	
	

	
	public void Setnum(ActionEvent event) throws IOException{
		
	}
	
	public void OutSeat(ActionEvent event)throws Exception{
		
		primaryStage2.close();
		Stage reserve = new Stage();
		reserve.setTitle("버스 좌석 예매 프로그램");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/Reserve.fxml"));
		
		Parent root = loader.load();		
		Scene scene = new Scene(root);
		Reserve_Demo rd=loader.getController();
		rd.SetStage(reserve);
		rd.SetName(MyName);
		scene.getStylesheets().add(getClass().getResource("application.css").toString());
		

		reserve.setScene(scene);
		reserve.show();
		/*String jdbcUrl = "jdbc:mysql://localhost:3306/join?serverTimezone=UTC&SSL=false&useSSL=false";
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
        	
            String query = "update member set start = 'null', destination = 'null', date = 'null', time = 'null' WHERE id = '"+MyId+"'";   //명령어

            
            pstmt = conn.prepareStatement(query);
            pstmt.executeUpdate();   //명령어를 mysql에 보내는 함수
           
            
                  
         } catch (Exception e) {
            e.printStackTrace();
         }*/
	}
	@FXML
	public void Back(ActionEvent event) throws IOException{
		primaryStage1.close();
		SetId(MyId);
		SetName(MyName);
		/*Stage sea = new Stage();
  		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/Seat.fxml"));		
  		 
  		Parent root = loader.load();
  		Scene scene = new Scene(root);
  	
  		
  		sea.setScene(scene);
  		sea.show();*/
  	
	}
	@FXML
	public void Close_Frame(ActionEvent event) throws Exception{
	
		primaryStage1.close();
		primaryStage2.close();
			
			Stage primaryStage = new Stage();
			primaryStage.setTitle("버스 좌석 예매 프로그램");
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/payment.fxml"));
			Parent root = loader.load();		
			Scene scene = new Scene(root);
			Pay_controller pay=loader.getController();
			pay.SetBus(start, end, date,day);
			pay.SetId(MyId);
			pay.SetSeat(seatNum);
			pay.SetStage2(primaryStage);
			pay.SetName(MyName);
			System.out.println("이름:"+MyName);
			pay.SetText(price);
			pay.SetItem(cardList, monthList, yearList);
		
			scene.getStylesheets().add(getClass().getResource("application.css").toString());
			
	
			primaryStage.setScene(scene);
			primaryStage.show();
	    
	}
	
	@FXML
	private Button paybtn;
	
	@FXML
	private void pay(ActionEvent event) throws IOException{
		Stage primaryStage = new Stage();
		primaryStage.setTitle("버스 좌석 예매 프로그램");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SceneBuilder/pay_end.fxml"));		
		 
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Seat_controller seat = loader.getController();
		seat.SetStage(primaryStage);
		scene.getStylesheets().add(getClass().getResource("application.css").toString());
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
