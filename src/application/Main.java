package application;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {
	BorderPane root;
	Scene scene;
	Database db = new Database();
	Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		try {
			initView();
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initView() {
		root = new BorderPane();
		scene = new Scene(root, 1024, 768);

		root.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));

		Label leftLabel = new Label();
		leftLabel.setPrefSize(8, 250);
		root.setLeft(leftLabel);

		Label rLabel = new Label();
		rLabel.setPrefSize(8, 250);
		root.setLeft(rLabel);

		root.setTop(rightSide());

		root.setCenter(shoe());
		StackPane stack = new StackPane();
		Rectangle rc = new Rectangle();
		rc.setHeight(600);
		rc.setWidth(scene.getWidth());
		rc.setFill(Color.BLACK);
		ImageView image = new ImageView("https://static.sneakerjagers.com/products/660x660/197179.jpg");
		image.setFitHeight(300);
		image.setFitWidth(400);
		StackPane.setAlignment(image, Pos.TOP_LEFT);

		HBox hz = new HBox(80);

		VBox vz = new VBox(10);
		Label merk = new Label("Adidas");
		merk.setTextFill(Color.WHITE);
		Label model = new Label("Ultra Boosts");
		model.setTextFill(Color.WHITE);
		Font font = Font.font("Serif", FontWeight.BOLD, 50);
		Font font5 = Font.font("Serif", FontWeight.BOLD, 25);
		merk.setFont(font5);
		model.setFont(font);
		Label warna = new Label("Pink");
		Font font1 = Font.font("Serif", 25);
		warna.setTextFill(Color.GRAY);
		warna.setFont(font1);

		VBox.setMargin(merk, new Insets(20, 0, 0, 0));
		HBox.setMargin(image, new Insets(0, 0, 0, 60));
		int price = 900000;
		Label price1 = new Label("Rp " + price);
		Font font2 = Font.font("Serif", FontWeight.BOLD, 40);
		price1.setFont(font2);
		price1.setTextFill(Color.WHITE);
		Button buy = new Button("Buy Now");
		ImageView imgic = new ImageView("https://cdn.icon-icons.com/icons2/2582/PNG/512/shopping_bag_icon_153998.png");

		buy.setOnAction(events -> {
			detailPage4();
		});
		VBox.setMargin(price1, new Insets(0, 0, 10, 0));
		buy.setGraphic(imgic);
		imgic.setFitHeight(22);
		imgic.setFitWidth(22);
		buy.setStyle("-fx-background-color:#FFFFFF;" + "-fx-padding: 10 15;" + "-fx-background-radius:5;");
		Font font4 = Font.font("Serif", FontWeight.BOLD, 14);
		buy.setFont(font4);

		vz.getChildren().addAll(merk, model, warna, price1, buy);
		hz.getChildren().addAll(image, vz);
		stack.getChildren().addAll(rc, hz);

		root.setBottom(stack);
		BorderPane.setMargin(stack, new Insets(40, 0, 0, 0));

	}

	public void detailPage4() {
		BorderPane detailPage = new BorderPane();
		Scene detailScene = new Scene(detailPage, 1024, 768);

		detailPage.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));

		Button back = new Button("back");
		back.setBackground(null);
		ImageView image = new ImageView("https://static.thenounproject.com/png/65506-200.png");
		back.setGraphic(image);
		image.setFitHeight(25);
		image.setFitWidth(25);

		back.setOnAction(e -> primaryStage.setScene(scene));
		detailPage.setTop(back);

		BorderPane.setAlignment(back, Pos.TOP_LEFT);

		StackPane stack = new StackPane();
		ImageView shoes = new ImageView(
				"file:///C:/Users/Livenia%20Kristina/eclipse-workspace/BNCC%20Final%20Project/src/image/skechers3.png");
		shoes.setFitHeight(200);
		shoes.setFitWidth(300);
		Rectangle rc = new Rectangle(500, 500);
		rc.setArcHeight(20);
		rc.setArcWidth(20);
		rc.setFill(Color.rgb(234, 234, 234));

		stack.getChildren().addAll(rc, shoes);

		HBox hr = new HBox(20);
		hr.setAlignment(Pos.CENTER_LEFT);
		hr.setPadding(new Insets(20));

		VBox vr = new VBox(10);
		vr.setPadding(new Insets(10));
		vr.setAlignment(Pos.CENTER_LEFT);

		Random rand = new Random();
		String id = "A" + String.format("%04d", rand.nextInt(1000));

		Label merk = new Label("Adidas");
		merk.setTextFill(Color.BLACK);
		Label model = new Label("Ultra Boosts");
		model.setTextFill(Color.BLACK);
		Font font = Font.font("Serif", FontWeight.BOLD, 50);
		Font font5 = Font.font("Serif", FontWeight.BOLD, 25);
		merk.setFont(font5);
		model.setFont(font);
		Label warna = new Label("Pink");
		Font font1 = Font.font("Serif", 25);
		warna.setTextFill(Color.GRAY);
		warna.setFont(font1);
		VBox.setMargin(warna, new Insets(0, 0, 50, 0));

		int price = 900000;
		Label price1 = new Label("Rp " + price);
		Font font2 = Font.font("Serif", FontWeight.BOLD, 30);
		price1.setFont(font2);
		price1.setTextFill(Color.BLACK);
		VBox.setMargin(price1, new Insets(0, 0, 20, 0));

		TextField qty = new TextField();
		qty.setStyle("-fx-background-fill: #EAEAEA;" + "-fx-background-radius:10px;" + "-fx-padding: 10 20");
		qty.setPrefSize(50, 30);
		Font font4 = Font.font("Serif", 14);
		qty.setFont(font4);
		qty.setPromptText("Input Quantity");
		Label error1 = new Label();
		qty.setOnKeyTyped(e -> {
			if (!e.getCharacter().matches("[0-9]")) {
				qty.setStyle("-fx-background-fill: #EAEAEA;" + "-fx-background-radius:10px;" + "-fx-padding: 10 20;"
						+ "-fx-focus-color:red;");

				error1.setText("Input must be a number");
				e.consume();
			} else {
				error1.setText("");
				qty.setStyle("-fx-background-fill: #EAEAEA;" + "-fx-background-radius:10px;" + "-fx-padding: 10 20");
			}
		});

		VBox v1 = new VBox(10, qty, error1);

		TextField money = new TextField();
		money.setStyle("-fx-background-fill: #EAEAEA;" + "-fx-background-radius:10px;" + "-fx-padding: 10 20");
		money.setPrefSize(50, 30);
		Font font3 = Font.font("Serif", 14);
		money.setFont(font3);
		money.setPromptText("Input Money");
		Label error = new Label();
		money.setOnKeyTyped(e -> {
			if (!e.getCharacter().matches("[0-9]")) {
				money.setStyle("-fx-background-fill: #EAEAEA;" + "-fx-background-radius:10px;" + "-fx-padding: 10 20;"
						+ "-fx-focus-color:red;");

				error.setText("Input must be a number");
				e.consume();
			} else {
				error.setText("");
				money.setStyle("-fx-background-fill: #EAEAEA;" + "-fx-background-radius:10px;" + "-fx-padding: 10 20");
			}
		});

		VBox v = new VBox(10, money, error);
		Button struk = new Button("Print Receipt");
		struk.setStyle("-fx-background-color: #000000;" + "-fx-padding: 10 20;" + "-fx-background-radius:5;");
		Font font6 = Font.font("Serif", FontWeight.BOLD, 14);
		struk.setFont(font6);
		struk.setTextFill(Color.WHITE);
		struk.setVisible(true);

		struk.setPrefWidth(500);

		Label gc = new Label();
		gc.setTextFill(Color.RED);

		Label suc = new Label();

		struk.setOnAction(e -> {
			int qty1 = Integer.parseInt(qty.getText());
			int money1 = Integer.parseInt(money.getText());
			int total = qty1 * price;
			if (money1 < total) {
				gc.setText("Insufficient money");
			} else {
				int change = money1 - total;
				Struk struk1 = new Struk(id, model.getText(), merk.getText(), warna.getText(), price, qty1, money1,
						change);
				writeStruk(struk1);
				db.insert(struk1);
				struk.setOnAction(event -> {
					suc.setText("Success");
				});

			}
		});

		vr.getChildren().addAll(merk, model, warna, price1, qty, v1, money, v, struk, gc, suc);

		hr.getChildren().addAll(stack, vr);

		detailPage.setCenter(hr);
		Label leftlabel = new Label();
		leftlabel.setPrefSize(20, 250);
		detailPage.setLeft(leftlabel);

		Label rlabel = new Label();
		rlabel.setPrefSize(20, 250);
		detailPage.setRight(rlabel);

		BorderPane.setMargin(hr, new Insets(20));

		primaryStage.setScene(detailScene);
	}

	public HBox rightSide() {
		HBox field = new HBox(10);
		Label title = new Label("Foot Frenzy");
		title.setTextFill(Color.BLACK);
		Font font = Font.font("Serif", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 30);
		field.setMargin(title, new Insets(10, 350, 10, 10));
		title.setFont(font);

		Button update = new Button("Update");
		update.setStyle("-fx-background-color: #000000;" + "-fx-padding: 10 20;" + "-fx-background-radius:5;");
		update.setPrefWidth(130);
		Font font4 = Font.font("Serif", FontWeight.BOLD, 14);
		update.setTextFill(Color.WHITE);
		update.setFont(font4);

		update.setOnAction(event -> {
			update();
		});

		Button delete = new Button("Delete");
		delete.setStyle("-fx-background-color: #000000;" + "-fx-padding: 10 20;" + "-fx-background-radius:5;");
		delete.setPrefWidth(130);
		delete.setTextFill(Color.WHITE);
		delete.setFont(font4);
		Button history = new Button("History");
		history.setStyle("-fx-background-color: #000000;" + "-fx-padding: 10 20;" + "-fx-background-radius:5;");
		history.setPrefWidth(130);
		history.setTextFill(Color.WHITE);
		history.setFont(font4);

		field.setMargin(history, new Insets(10));
		field.setMargin(delete, new Insets(10));
		field.setMargin(update, new Insets(10));

		delete.setOnAction(event -> {
			delete();
		});

		history.setOnAction(events -> {
			history();
		});

		field.getChildren().addAll(title, update, delete, history);
		field.setPrefHeight(50);
		return field;
	}

	public void update() {
		BorderPane update = new BorderPane();
		Scene updatesc = new Scene(update, 1024, 768);
		VBox vb = new VBox(10);
		Label updateLbl = new Label("Update Product");
		TextField id = new TextField();
		id.setPromptText("input id");
		TextField merk = new TextField();
		merk.setPromptText("input merk");

		TextField model = new TextField();
		model.setPromptText("input model");

		TextField color = new TextField();
		color.setPromptText("input color");

		TextField oldprice = new TextField();
		oldprice.setPromptText("input old price");

		TextField qty = new TextField();
		qty.setPromptText("input new qty");
		TextField money = new TextField();
		money.setPromptText("Input money");
		Button save = new Button("Save");
		Font font4 = Font.font("Serif", FontWeight.BOLD, 14);
		save.setStyle("-fx-background-color: #000000;" + "-fx-padding: 10 20;" + "-fx-background-radius:5;");
		save.setPrefWidth(130);
		save.setTextFill(Color.WHITE);
		save.setFont(font4);

		Label suc = new Label("updated");
		suc.setVisible(false);
		save.setOnAction(e -> {
			int qty1 = Integer.parseInt(qty.getText());
			int money1 = Integer.parseInt(money.getText());
			int oldprice1 = Integer.parseInt(oldprice.getText());
			int total = qty1 * oldprice1;
			String id1 = id.getText();
			if (money1 < total) {
				suc.setText("Insufficient money");
			} else {
				int change = money1 - total;
				Struk struk1 = new Struk(id1, model.getText(), merk.getText(), color.getText(), oldprice1, qty1, money1,
						change);
				db.update(struk1);
				suc.setVisible(true);

			}
		});

		vb.getChildren().addAll(updateLbl, id, merk, model, color, oldprice, qty, money, save, suc);

		Button back = new Button("back");
		back.setBackground(null);
		ImageView image = new ImageView("https://static.thenounproject.com/png/65506-200.png");
		back.setGraphic(image);
		image.setFitHeight(25);
		image.setFitWidth(25);

		back.setOnAction(e -> primaryStage.setScene(scene));
		update.setTop(back);
		update.setCenter(vb);
		Label left = new Label();
		left.setPrefSize(50, 500);

		Label right = new Label();
		right.setPrefSize(50, 500);

		update.setLeft(left);
		update.setRight(right);

		primaryStage.setScene(updatesc);

	}

	public void delete() {
		BorderPane update = new BorderPane();
		Scene updatesc = new Scene(update, 1024, 768);
		VBox vb = new VBox(10);
		Label updateLbl = new Label("Update Product");
		TextField id = new TextField();
		id.setPromptText("input id");
		TextField merk = new TextField();
		merk.setPromptText("input merk");

		TextField model = new TextField();
		model.setPromptText("input model");

		TextField color = new TextField();
		color.setPromptText("input color");

		TextField oldprice = new TextField();
		oldprice.setPromptText("input old price");

		TextField qty = new TextField();
		qty.setPromptText("input new qty");
		TextField money = new TextField();
		money.setPromptText("Input money");
		Button save = new Button("Save");
		Font font4 = Font.font("Serif", FontWeight.BOLD, 14);
		save.setStyle("-fx-background-color: #000000;" + "-fx-padding: 10 20;" + "-fx-background-radius:5;");
		save.setPrefWidth(130);
		save.setTextFill(Color.WHITE);
		save.setFont(font4);

		Label suc = new Label("updated");
		suc.setVisible(false);
		save.setOnAction(e -> {
			int qty1 = Integer.parseInt(qty.getText());
			int money1 = Integer.parseInt(money.getText());
			int oldprice1 = Integer.parseInt(oldprice.getText());
			int total = qty1 * oldprice1;
			String id1 = id.getText();
			if (money1 < total) {
				suc.setText("Insufficient money");
			} else {
				int change = money1 - total;
				Struk struk1 = new Struk(id1, model.getText(), merk.getText(), color.getText(), oldprice1, qty1, money1,
						change);
				db.delete(struk1);
				suc.setVisible(true);

			}
		});

		vb.getChildren().addAll(updateLbl, id, merk, model, color, oldprice, qty, money, save, suc);

		Button back = new Button("back");
		back.setBackground(null);
		ImageView image = new ImageView("https://static.thenounproject.com/png/65506-200.png");
		back.setGraphic(image);
		image.setFitHeight(25);
		image.setFitWidth(25);

		back.setOnAction(e -> primaryStage.setScene(scene));
		update.setTop(back);
		update.setCenter(vb);
		Label left = new Label();
		left.setPrefSize(50, 500);

		Label right = new Label();
		right.setPrefSize(50, 500);

		update.setLeft(left);
		update.setRight(right);

		primaryStage.setScene(updatesc);

	}

	public void history() {

	}

	public HBox shoe() {
		HBox ks = new HBox();
		ks.setAlignment(Pos.CENTER);

		Rectangle rc1 = new Rectangle(200, 150);

		rc1.setFill(Color.rgb(234, 234, 234));
		rc1.setArcHeight(30);
		rc1.setArcWidth(30);

		ImageView img = new ImageView(
				"file:///C:/Users/Livenia%20Kristina/eclipse-workspace/BNCC%20Final%20Project/src/image/adidas.png");
		img.setFitHeight(100);
		img.setFitWidth(160);

		VBox strc1 = new VBox();
		Label merkrc1 = new Label("Adidas");
		Label mdlrc1 = new Label("Air Max 2024");
		Font font = Font.font("Serif", 15);
		merkrc1.setFont(font);
		VBox.setMargin(merkrc1, new Insets(1.5));

		Font font1 = Font.font("Serif", FontWeight.BOLD, 15);
		mdlrc1.setFont(font1);
		merkrc1.setFont(font1);

		VBox.setMargin(mdlrc1, new Insets(1.5));

		Label crc1 = new Label("White");
		Font font3 = Font.font("Serif", 13);
		crc1.setFont(font3);
		crc1.setTextFill(Color.GREY);
		VBox.setMargin(crc1, new Insets(0, 0, 5, 0));

		int prc1 = 500000;
		Label price = new Label("Rp " + prc1);
		Font font2 = Font.font("Serif", FontWeight.BOLD, 25);
		price.setFont(font2);
		VBox.setMargin(price, new Insets(1.6));

		Button buy = new Button("Buy Now");
		ImageView imgic = new ImageView("https://cdn.icon-icons.com/icons2/2582/PNG/512/shopping_bag_icon_153998.png");

		buy.setGraphic(imgic);
		imgic.setFitHeight(20);
		imgic.setFitWidth(20);
		buy.setStyle("-fx-background-color: #EAEAEA;" + "-fx-padding: 10 20;" + "-fx-background-radius:5;");
		Font font4 = Font.font("Serif", FontWeight.BOLD, 14);
		buy.setFont(font4);

		StackPane stack = new StackPane();
		stack.getChildren().addAll(rc1, img);

		strc1.setAlignment(Pos.BOTTOM_CENTER);
		VBox.setMargin(stack, new Insets(20));
		VBox.setMargin(buy, new Insets(10));
		buy.setOnAction(e -> {
			detailPage();
		});

		strc1.getChildren().addAll(stack, merkrc1, mdlrc1, crc1, price, buy);
		ks.getChildren().addAll(strc1, rc2(), rc3());

		return ks;

	}

	public VBox rc2() {
		Rectangle rc1 = new Rectangle(200, 150);

		rc1.setFill(Color.rgb(234, 234, 234));
		rc1.setArcHeight(30);
		rc1.setArcWidth(30);

		ImageView img = new ImageView(
				"file:///C:/Users/Livenia%20Kristina/eclipse-workspace/BNCC%20Final%20Project/src/image/skechers3.png");
		img.setFitHeight(100);
		img.setFitWidth(160);

		StackPane stack = new StackPane();
		stack.getChildren().addAll(rc1, img);

		VBox strc1 = new VBox();
		Label merkrc1 = new Label("Skechers");
		Label mdlrc1 = new Label("D'Lites");
		Font font = Font.font("Serif", 15);
		merkrc1.setFont(font);
		VBox.setMargin(merkrc1, new Insets(1.5));

		Font font1 = Font.font("Serif", FontWeight.BOLD, 15);
		mdlrc1.setFont(font1);
		merkrc1.setFont(font1);

		VBox.setMargin(mdlrc1, new Insets(1.5));

		Label crc1 = new Label("Blue");
		Font font3 = Font.font("Serif", 13);
		crc1.setFont(font3);
		crc1.setTextFill(Color.GREY);
		VBox.setMargin(crc1, new Insets(0, 0, 5, 0));

		int prc1 = 520000;
		Label price = new Label("Rp " + prc1);
		Font font2 = Font.font("Serif", FontWeight.BOLD, 25);
		price.setFont(font2);
		VBox.setMargin(price, new Insets(1.6));

		Button buy = new Button("Buy Now");
		ImageView imgic = new ImageView("https://cdn.icon-icons.com/icons2/2582/PNG/512/shopping_bag_icon_153998.png");

		buy.setGraphic(imgic);
		imgic.setFitHeight(20);
		imgic.setFitWidth(20);
		buy.setStyle("-fx-background-color: #EAEAEA;" + "-fx-padding: 10 20;" + "-fx-background-radius:5;");
		Font font4 = Font.font("Serif", FontWeight.BOLD, 14);
		buy.setFont(font4);

		strc1.setAlignment(Pos.BOTTOM_CENTER);
		VBox.setMargin(stack, new Insets(20));
		VBox.setMargin(buy, new Insets(10));
		buy.setOnAction(e -> {
			detailPage2();
		});

		strc1.getChildren().addAll(stack, merkrc1, mdlrc1, crc1, price, buy);
		return strc1;

	}

	public void detailPage2() {
		BorderPane detailPage = new BorderPane();
		Scene detailScene = new Scene(detailPage, 1024, 768);

		detailPage.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));

		Button back = new Button("back");
		back.setBackground(null);
		ImageView image = new ImageView("https://static.thenounproject.com/png/65506-200.png");
		back.setGraphic(image);
		image.setFitHeight(25);
		image.setFitWidth(25);

		back.setOnAction(e -> primaryStage.setScene(scene));
		detailPage.setTop(back);

		BorderPane.setAlignment(back, Pos.TOP_LEFT);

		StackPane stack = new StackPane();
		ImageView shoes = new ImageView(
				"file:///C:/Users/Livenia%20Kristina/eclipse-workspace/BNCC%20Final%20Project/src/image/skechers3.png");
		shoes.setFitHeight(200);
		shoes.setFitWidth(300);
		Rectangle rc = new Rectangle(500, 500);
		rc.setArcHeight(20);
		rc.setArcWidth(20);
		rc.setFill(Color.rgb(234, 234, 234));

		stack.getChildren().addAll(rc, shoes);

		HBox hr = new HBox(20);
		hr.setAlignment(Pos.CENTER_LEFT);
		hr.setPadding(new Insets(20));

		VBox vr = new VBox(10);
		vr.setPadding(new Insets(10));
		vr.setAlignment(Pos.CENTER_LEFT);

		Random rand = new Random();
		String id = "A" + String.format("%04d", rand.nextInt(1000));

		Label merk = new Label("Skechers");
		merk.setTextFill(Color.BLACK);
		Label model = new Label("D'Lites");
		model.setTextFill(Color.BLACK);
		Font font = Font.font("Serif", FontWeight.BOLD, 50);
		Font font5 = Font.font("Serif", FontWeight.BOLD, 25);
		merk.setFont(font5);
		model.setFont(font);
		Label warna = new Label("Blue");
		Font font1 = Font.font("Serif", 25);
		warna.setTextFill(Color.GRAY);
		warna.setFont(font1);
		VBox.setMargin(warna, new Insets(0, 0, 50, 0));

		int price = 520000;
		Label price1 = new Label("Rp " + price);
		Font font2 = Font.font("Serif", FontWeight.BOLD, 30);
		price1.setFont(font2);
		price1.setTextFill(Color.BLACK);
		VBox.setMargin(price1, new Insets(0, 0, 20, 0));

		TextField qty = new TextField();
		qty.setStyle("-fx-background-fill: #EAEAEA;" + "-fx-background-radius:10px;" + "-fx-padding: 10 20");
		qty.setPrefSize(50, 30);
		Font font4 = Font.font("Serif", 14);
		qty.setFont(font4);
		qty.setPromptText("Input Quantity");
		Label error1 = new Label();
		qty.setOnKeyTyped(e -> {
			if (!e.getCharacter().matches("[0-9]")) {
				qty.setStyle("-fx-background-fill: #EAEAEA;" + "-fx-background-radius:10px;" + "-fx-padding: 10 20;"
						+ "-fx-focus-color:red;");

				error1.setText("Input must be a number");
				e.consume();
			} else {
				error1.setText("");
				qty.setStyle("-fx-background-fill: #EAEAEA;" + "-fx-background-radius:10px;" + "-fx-padding: 10 20");
			}
		});

		VBox v1 = new VBox(10, qty, error1);

		TextField money = new TextField();
		money.setStyle("-fx-background-fill: #EAEAEA;" + "-fx-background-radius:10px;" + "-fx-padding: 10 20");
		money.setPrefSize(50, 30);
		Font font3 = Font.font("Serif", 14);
		money.setFont(font3);
		money.setPromptText("Input Money");
		Label error = new Label();
		money.setOnKeyTyped(e -> {
			if (!e.getCharacter().matches("[0-9]")) {
				money.setStyle("-fx-background-fill: #EAEAEA;" + "-fx-background-radius:10px;" + "-fx-padding: 10 20;"
						+ "-fx-focus-color:red;");

				error.setText("Input must be a number");
				e.consume();
			} else {
				error.setText("");
				money.setStyle("-fx-background-fill: #EAEAEA;" + "-fx-background-radius:10px;" + "-fx-padding: 10 20");
			}
		});

		VBox v = new VBox(10, money, error);
		Button struk = new Button("Print Receipt");
		struk.setStyle("-fx-background-color: #000000;" + "-fx-padding: 10 20;" + "-fx-background-radius:5;");
		Font font6 = Font.font("Serif", FontWeight.BOLD, 14);
		struk.setFont(font6);
		struk.setTextFill(Color.WHITE);
		struk.setVisible(true);

		struk.setPrefWidth(500);

		Label gc = new Label();
		gc.setTextFill(Color.RED);

		Label suc = new Label();

		struk.setOnAction(e -> {
			int qty1 = Integer.parseInt(qty.getText());
			int money1 = Integer.parseInt(money.getText());
			int total = qty1 * price;
			if (money1 < total) {
				gc.setText("Insufficient money");
			} else {
				int change = money1 - total;
				Struk struk1 = new Struk(id, model.getText(), merk.getText(), warna.getText(), price, qty1, money1,
						change);
				writeStruk(struk1);
				db.insert(struk1);
				struk.setOnAction(event -> {
					suc.setText("Success");
				});

			}
		});

		vr.getChildren().addAll(merk, model, warna, price1, qty, v1, money, v, struk, gc, suc);

		hr.getChildren().addAll(stack, vr);

		detailPage.setCenter(hr);
		Label leftlabel = new Label();
		leftlabel.setPrefSize(20, 250);
		detailPage.setLeft(leftlabel);

		Label rlabel = new Label();
		rlabel.setPrefSize(20, 250);
		detailPage.setRight(rlabel);

		BorderPane.setMargin(hr, new Insets(20));

		primaryStage.setScene(detailScene);

	}

	public VBox rc3() {
		Rectangle rc1 = new Rectangle(200, 150);

		rc1.setFill(Color.rgb(234, 234, 234));
		rc1.setArcHeight(30);
		rc1.setArcWidth(30);

		ImageView img = new ImageView(
				"https://img.id.my-best.com/product_images/d6d45d64f2ad1ed03ec3ac4d684e11f3.png?ixlib=rails-4.3.1&q=70&lossless=0&w=800&h=800&fit=clip&s=347cfe9757692c0e586d0e72afab994b");
		img.setFitHeight(100);
		img.setFitWidth(160);

		StackPane stack = new StackPane();
		stack.getChildren().addAll(rc1, img);

		VBox strc1 = new VBox();
		Label merkrc1 = new Label("Nike");
		Label mdlrc1 = new Label("Air Max 270");
		Font font = Font.font("Serif", 15);
		merkrc1.setFont(font);
		VBox.setMargin(merkrc1, new Insets(1.5));

		Font font1 = Font.font("Serif", FontWeight.BOLD, 15);
		mdlrc1.setFont(font1);
		merkrc1.setFont(font1);

		VBox.setMargin(mdlrc1, new Insets(1.5));

		Label crc1 = new Label("Black");
		Font font3 = Font.font("Serif", 13);
		crc1.setFont(font3);
		crc1.setTextFill(Color.GREY);
		VBox.setMargin(crc1, new Insets(0, 0, 5, 0));

		int prc1 = 600000;
		Label price = new Label("Rp " + prc1);
		Font font2 = Font.font("Serif", FontWeight.BOLD, 25);
		price.setFont(font2);
		VBox.setMargin(price, new Insets(1.6));

		Button buy = new Button("Buy Now");
		ImageView imgic = new ImageView("https://cdn.icon-icons.com/icons2/2582/PNG/512/shopping_bag_icon_153998.png");

		buy.setGraphic(imgic);
		imgic.setFitHeight(20);
		imgic.setFitWidth(20);
		buy.setStyle("-fx-background-color: #EAEAEA;" + "-fx-padding: 10 20;" + "-fx-background-radius:5;");
		Font font4 = Font.font("Serif", FontWeight.BOLD, 14);
		buy.setFont(font4);

		strc1.setAlignment(Pos.BOTTOM_CENTER);
		VBox.setMargin(stack, new Insets(20));
		VBox.setMargin(buy, new Insets(10));
		buy.setOnAction(e -> {
			detailPage3();
		});

		strc1.getChildren().addAll(stack, merkrc1, mdlrc1, crc1, price, buy);
		return strc1;

	}

	public void detailPage3() {
		BorderPane detailPage = new BorderPane();
		Scene detailScene = new Scene(detailPage, 1024, 768);

		detailPage.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));

		Button back = new Button("back");
		back.setBackground(null);
		ImageView image = new ImageView("https://static.thenounproject.com/png/65506-200.png");
		back.setGraphic(image);
		image.setFitHeight(25);
		image.setFitWidth(25);

		back.setOnAction(e -> primaryStage.setScene(scene));
		detailPage.setTop(back);

		BorderPane.setAlignment(back, Pos.TOP_LEFT);

		StackPane stack = new StackPane();
		ImageView shoes = new ImageView(
				"https://img.id.my-best.com/product_images/d6d45d64f2ad1ed03ec3ac4d684e11f3.png?ixlib=rails-4.3.1&q=70&lossless=0&w=800&h=800&fit=clip&s=347cfe9757692c0e586d0e72afab994b");
		shoes.setFitHeight(200);
		shoes.setFitWidth(300);
		Rectangle rc = new Rectangle(500, 500);
		rc.setArcHeight(20);
		rc.setArcWidth(20);
		rc.setFill(Color.rgb(234, 234, 234));

		stack.getChildren().addAll(rc, shoes);

		HBox hr = new HBox(20);
		hr.setAlignment(Pos.CENTER_LEFT);
		hr.setPadding(new Insets(20));

		VBox vr = new VBox(10);
		vr.setPadding(new Insets(10));
		vr.setAlignment(Pos.CENTER_LEFT);

		Random rand = new Random();
		String id = "A" + String.format("%04d", rand.nextInt(1000));

		Label merk = new Label("Nike");
		merk.setTextFill(Color.BLACK);
		Label model = new Label("Air Max 270");
		model.setTextFill(Color.BLACK);
		Font font = Font.font("Serif", FontWeight.BOLD, 50);
		Font font5 = Font.font("Serif", FontWeight.BOLD, 25);
		merk.setFont(font5);
		model.setFont(font);
		Label warna = new Label("Black");
		Font font1 = Font.font("Serif", 25);
		warna.setTextFill(Color.GRAY);
		warna.setFont(font1);
		VBox.setMargin(warna, new Insets(0, 0, 50, 0));

		int price = 600000;
		Label price1 = new Label("Rp " + price);
		Font font2 = Font.font("Serif", FontWeight.BOLD, 30);
		price1.setFont(font2);
		price1.setTextFill(Color.BLACK);
		VBox.setMargin(price1, new Insets(0, 0, 20, 0));

		TextField qty = new TextField();
		qty.setStyle("-fx-background-fill: #EAEAEA;" + "-fx-background-radius:10px;" + "-fx-padding: 10 20");
		qty.setPrefSize(50, 30);
		Font font4 = Font.font("Serif", 14);
		qty.setFont(font4);
		qty.setPromptText("Input Quantity");
		Label error1 = new Label();
		qty.setOnKeyTyped(e -> {
			if (!e.getCharacter().matches("[0-9]")) {
				qty.setStyle("-fx-background-fill: #EAEAEA;" + "-fx-background-radius:10px;" + "-fx-padding: 10 20;"
						+ "-fx-focus-color:red;");

				error1.setText("Input must be a number");
				e.consume();
			} else {
				error1.setText("");
				qty.setStyle("-fx-background-fill: #EAEAEA;" + "-fx-background-radius:10px;" + "-fx-padding: 10 20");
			}
		});

		VBox v1 = new VBox(10, qty, error1);

		TextField money = new TextField();
		money.setStyle("-fx-background-fill: #EAEAEA;" + "-fx-background-radius:10px;" + "-fx-padding: 10 20");
		money.setPrefSize(50, 30);
		Font font3 = Font.font("Serif", 14);
		money.setFont(font3);
		money.setPromptText("Input Money");
		Label error = new Label();
		money.setOnKeyTyped(e -> {
			if (!e.getCharacter().matches("[0-9]")) {
				money.setStyle("-fx-background-fill: #EAEAEA;" + "-fx-background-radius:10px;" + "-fx-padding: 10 20;"
						+ "-fx-focus-color:red;");

				error.setText("Input must be a number");
				e.consume();
			} else {
				error.setText("");
				money.setStyle("-fx-background-fill: #EAEAEA;" + "-fx-background-radius:10px;" + "-fx-padding: 10 20");
			}
		});

		VBox v = new VBox(10, money, error);
		Button struk = new Button("Print Receipt");
		struk.setStyle("-fx-background-color: #000000;" + "-fx-padding: 10 20;" + "-fx-background-radius:5;");
		Font font6 = Font.font("Serif", FontWeight.BOLD, 14);
		struk.setFont(font6);
		struk.setTextFill(Color.WHITE);
		struk.setVisible(true);

		struk.setPrefWidth(500);

		Label gc = new Label();
		gc.setTextFill(Color.RED);

		Label suc = new Label();

		struk.setOnAction(e -> {
			int qty1 = Integer.parseInt(qty.getText());
			int money1 = Integer.parseInt(money.getText());
			int total = qty1 * price;
			if (money1 < total) {
				gc.setText("Insufficient money");
			} else {
				int change = money1 - total;
				Struk struk1 = new Struk(id, model.getText(), merk.getText(), warna.getText(), price, qty1, money1,
						change);
				writeStruk(struk1);
				db.insert(struk1);
				struk.setOnAction(event -> {
					suc.setText("Success");
				});

			}
		});

		vr.getChildren().addAll(merk, model, warna, price1, qty, v1, money, v, struk, gc, suc);

		hr.getChildren().addAll(stack, vr);

		detailPage.setCenter(hr);
		Label leftlabel = new Label();
		leftlabel.setPrefSize(20, 250);
		detailPage.setLeft(leftlabel);

		Label rlabel = new Label();
		rlabel.setPrefSize(20, 250);
		detailPage.setRight(rlabel);

		BorderPane.setMargin(hr, new Insets(20));

		primaryStage.setScene(detailScene);

	}

	public void detailPage() {
		BorderPane detailPage = new BorderPane();
		Scene detailScene = new Scene(detailPage, 1024, 768);

		detailPage.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));

		Button back = new Button("back");
		back.setBackground(null);
		ImageView image = new ImageView("https://static.thenounproject.com/png/65506-200.png");
		back.setGraphic(image);
		image.setFitHeight(25);
		image.setFitWidth(25);

		back.setOnAction(e -> primaryStage.setScene(scene));
		detailPage.setTop(back);

		BorderPane.setAlignment(back, Pos.TOP_LEFT);

		StackPane stack = new StackPane();
		ImageView shoes = new ImageView(
				"file:///C:/Users/Livenia%20Kristina/eclipse-workspace/BNCC%20Final%20Project/src/image/adidas.png");
		shoes.setFitHeight(200);
		shoes.setFitWidth(300);
		Rectangle rc = new Rectangle(500, 500);
		rc.setArcHeight(20);
		rc.setArcWidth(20);
		rc.setFill(Color.rgb(234, 234, 234));

		stack.getChildren().addAll(rc, shoes);

		HBox hr = new HBox(20);
		hr.setAlignment(Pos.CENTER_LEFT);
		hr.setPadding(new Insets(20));

		VBox vr = new VBox(10);
		vr.setPadding(new Insets(10));
		vr.setAlignment(Pos.CENTER_LEFT);

		Random rand = new Random();
		String id = "A" + String.format("%04d", rand.nextInt(1000));

		Label merk = new Label("Adidas");
		merk.setTextFill(Color.BLACK);
		Label model = new Label("Air Max 2024");
		model.setTextFill(Color.BLACK);
		Font font = Font.font("Serif", FontWeight.BOLD, 50);
		Font font5 = Font.font("Serif", FontWeight.BOLD, 25);
		merk.setFont(font5);
		model.setFont(font);
		Label warna = new Label("White");
		Font font1 = Font.font("Serif", 25);
		warna.setTextFill(Color.GRAY);
		warna.setFont(font1);
		VBox.setMargin(warna, new Insets(0, 0, 50, 0));

		int price = 500000;
		Label price1 = new Label("Rp " + price);
		Font font2 = Font.font("Serif", FontWeight.BOLD, 30);
		price1.setFont(font2);
		price1.setTextFill(Color.BLACK);
		VBox.setMargin(price1, new Insets(0, 0, 20, 0));

		TextField qty = new TextField();
		qty.setStyle("-fx-background-fill: #EAEAEA;" + "-fx-background-radius:10px;" + "-fx-padding: 10 20");
		qty.setPrefSize(50, 30);
		Font font4 = Font.font("Serif", 14);
		qty.setFont(font4);
		qty.setPromptText("Input Quantity");
		Label error1 = new Label();
		qty.setOnKeyTyped(e -> {
			if (!e.getCharacter().matches("[0-9]")) {
				qty.setStyle("-fx-background-fill: #EAEAEA;" + "-fx-background-radius:10px;" + "-fx-padding: 10 20;"
						+ "-fx-focus-color:red;");

				error1.setText("Input must be a number");
				e.consume();
			} else {
				error1.setText("");
				qty.setStyle("-fx-background-fill: #EAEAEA;" + "-fx-background-radius:10px;" + "-fx-padding: 10 20");
			}
		});

		VBox v1 = new VBox(10, qty, error1);

		TextField money = new TextField();
		money.setStyle("-fx-background-fill: #EAEAEA;" + "-fx-background-radius:10px;" + "-fx-padding: 10 20");
		money.setPrefSize(50, 30);
		Font font3 = Font.font("Serif", 14);
		money.setFont(font3);
		money.setPromptText("Input Money");
		Label error = new Label();
		money.setOnKeyTyped(e -> {
			if (!e.getCharacter().matches("[0-9]")) {
				money.setStyle("-fx-background-fill: #EAEAEA;" + "-fx-background-radius:10px;" + "-fx-padding: 10 20;"
						+ "-fx-focus-color:red;");

				error.setText("Input must be a number");
				e.consume();
			} else {
				error.setText("");
				money.setStyle("-fx-background-fill: #EAEAEA;" + "-fx-background-radius:10px;" + "-fx-padding: 10 20");
			}
		});

		VBox v = new VBox(10, money, error);
		Button struk = new Button("Print Receipt");
		struk.setStyle("-fx-background-color: #000000;" + "-fx-padding: 10 20;" + "-fx-background-radius:5;");
		Font font6 = Font.font("Serif", FontWeight.BOLD, 14);
		struk.setFont(font6);
		struk.setTextFill(Color.WHITE);
		struk.setVisible(true);

		struk.setPrefWidth(500);

		Label gc = new Label();
		gc.setTextFill(Color.RED);

		Label suc = new Label();

		struk.setOnAction(e -> {
			int qty1 = Integer.parseInt(qty.getText());
			int money1 = Integer.parseInt(money.getText());
			int total = qty1 * price;
			if (money1 < total) {
				gc.setText("Insufficient money");
			} else {
				int change = money1 - total;
				Struk struk1 = new Struk(id, model.getText(), merk.getText(), warna.getText(), price, qty1, money1,
						change);
//				writeStruk(struk1);
//				db.insert(struk1);
				struk.setOnAction(event -> {
					suc.setText("Success");
				});

			}
		});

		vr.getChildren().addAll(merk, model, warna, price1, qty, v1, money, v, struk, gc, suc);

		hr.getChildren().addAll(stack, vr);

		detailPage.setCenter(hr);
		Label leftlabel = new Label();
		leftlabel.setPrefSize(20, 250);
		detailPage.setLeft(leftlabel);

		Label rlabel = new Label();
		rlabel.setPrefSize(20, 250);
		detailPage.setRight(rlabel);

		BorderPane.setMargin(hr, new Insets(20));

		primaryStage.setScene(detailScene);

	}

	public void writeStruk(Struk struk) {
		FileWriter fw;
		try {
			fw = new FileWriter("Receipt BNCC.txt", true);
			String f = String.format("%s %s %s %s %d %d %d %d\n", struk.getId(), struk.getModel(), struk.getMerk(),
					struk.getColor(), struk.getPrice(), struk.getQty(), struk.getMoney(), struk.getKembalian());

			fw.write(f);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}
