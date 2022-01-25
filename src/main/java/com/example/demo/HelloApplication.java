package com.example.demo;

import javafx.application.Application;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import java.sql.*;
import java.io.IOException;


public class HelloApplication extends Application {

    //creating connection object
    public Connection con;
    public ObservableList<person> list = FXCollections.observableArrayList();
    public ObservableList<product> sellslist = FXCollections.observableArrayList();


    public void start(Stage primaryStage) throws IOException {


        // TODO Auto-generated method stub
        primaryStage.setTitle("Welcome-page");
        primaryStage.setResizable(false);



        //creating some awesome fonts
        Font wlcmfnt=new Font("Arial",35);
        Font erfnt=Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 10);


        //creating groups to be added to our scenes
        Group g1=new Group();
        Group g2=new Group();
        Group g3=new Group();
        Group g4=new Group();
        Group g5=new Group();
        Group g6=new Group();
        Group g7=new Group();
        Group g8=new Group();


        //creating elements and setting it up
        Button ext=new Button("Exit");
        ext.setTranslateX(250);
        ext.setTranslateY(250);


        Button sinIn=new Button("SignIn");
        sinIn.setTranslateX(132);
        sinIn.setTranslateY(168);


        Button bck=new Button("DisConnectDB");
        bck.setTranslateX(180);
        bck.setTranslateY(240);


        TextField userfld=new TextField("");
        userfld.setTranslateX(100);
        userfld.setTranslateY(90);


        PasswordField passfld=new PasswordField();
        passfld.setTranslateX(100);
        passfld.setTranslateY(130);


        Label userlbl=new Label("UserName :");
        userlbl.setTranslateX(25);
        userlbl.setTranslateY(90);


        Label passlbl=new Label("Password :");
        passlbl.setTranslateX(25);
        passlbl.setTranslateY(130);


        Label wlcm=new Label("Welcome \n      signIn to be\n           processed");
        wlcm.setFont(wlcmfnt);
        wlcm.setTranslateX(15);
        wlcm.setTranslateY(60);
        wlcm.setTextFill(Color.GRAY);


        Button nxt=new Button("Next");
        nxt.setTranslateX(250);
        nxt.setTranslateY(250);


        Label er=new Label("");
        er.setTranslateX(125);
        er.setTranslateY(220);
        er.setFont(erfnt);


        Label er_auth=new Label("");
        er_auth.setTranslateX(125);
        er_auth.setTranslateY(220);
        er_auth.setFont(erfnt);


        Label dbl=new Label("DB :");
        dbl.setTranslateX(25);
        dbl.setTranslateY(52);
        dbl.setFont(erfnt);


        TextField dbtf=new TextField("");
        dbtf.setTranslateX(100);
        dbtf.setTranslateY(48);


        Label opt=new Label("Options:");
        opt.setTranslateX(16);
        opt.setTranslateY(12);
        opt.setFont(wlcmfnt);

        Label id_auth=new Label("ID :");
        id_auth.setTranslateX(25);
        id_auth.setTranslateY(52);

        Label pass_auth=new Label("Password :");
        pass_auth.setTranslateX(25);
        pass_auth.setTranslateY(102);

        TextField id_auth_tf=new TextField();
        id_auth_tf.setTranslateX(100);
        id_auth_tf.setTranslateY(52);

        PasswordField pass_auth_tf=new PasswordField();
        pass_auth_tf.setTranslateX(100);
        pass_auth_tf.setTranslateY(102);

        Button signin_btn_auth=new Button("SignIn");
        signin_btn_auth.setTranslateX(140);
        signin_btn_auth.setTranslateY(150);


        Button back_opt=new Button("Back");
        back_opt.setTranslateX(40);
        back_opt.setTranslateY(540);


        Button exit_opt=new Button("Exit");
        exit_opt.setTranslateX(700);
        exit_opt.setTranslateY(540);
        exit_opt.setPrefWidth(80);
        exit_opt.setPrefHeight(30);


        Button add_opt=new Button("ADD");
        add_opt.setTranslateX(250);
        add_opt.setTranslateY(200);
        add_opt.setPrefWidth(120);
        add_opt.setPrefHeight(50);


        Button mod_opt=new Button("Modify");
        mod_opt.setTranslateX(250);
        mod_opt.setTranslateY(280);
        mod_opt.setPrefWidth(120);
        mod_opt.setPrefHeight(50);


        Button del_opt=new Button("Delete");
        del_opt.setTranslateX(250);
        del_opt.setTranslateY(360);
        del_opt.setPrefWidth(120);
        del_opt.setPrefHeight(50);


        Button sub_opt=new Button("Subscribtions");
        sub_opt.setTranslateX(450);
        sub_opt.setTranslateY(200);
        sub_opt.setPrefWidth(155);
        sub_opt.setPrefHeight(60);


        Button sell_opt=new Button("Sells");
        sell_opt.setTranslateX(450);
        sell_opt.setTranslateY(350);
        sell_opt.setPrefWidth(155);
        sell_opt.setPrefHeight(60);


        Label title_opt=new Label("GYM SYSTEM");
        title_opt.setTranslateX(290);
        title_opt.setTranslateY(20);
        title_opt.setFont(wlcmfnt);


        //creating labels of addition page :
        Button back_add=new Button("Back");
        back_add.setTranslateX(40);
        back_add.setTranslateY(540);

        //sells
        Label sells_lbl_sell=new Label("Sells");
        sells_lbl_sell.setTranslateX(400);
        sells_lbl_sell.setTranslateY(30);
        sells_lbl_sell.setFont(wlcmfnt);

        Label name_lbl_sell=new Label("Name :");
        name_lbl_sell.setTranslateX(400);
        name_lbl_sell.setTranslateY(120);
        TextField name_text_sell=new TextField();
        name_text_sell.setTranslateX(450);
        name_text_sell.setTranslateY(120);

        Label Price_lbl_sell=new Label("Price :");
        Price_lbl_sell.setTranslateX(400);
        Price_lbl_sell.setTranslateY(160);
        TextField Price_txt_sell=new TextField();
        Price_txt_sell.setTranslateX(450);
        Price_txt_sell.setTranslateY(160);

        Label date_lbl_sell=new Label("Date :");
        date_lbl_sell.setTranslateX(400);
        date_lbl_sell.setTranslateY(200);
        TextField date_txt_sell=new TextField();
        date_txt_sell.setTranslateX(450);
        date_txt_sell.setTranslateY(200);

        //subscriptions
        Label subscription_lbl_sub=new Label("Subscriptions");
        subscription_lbl_sub.setTranslateX(50);
        subscription_lbl_sub.setTranslateY(30);
        subscription_lbl_sub.setFont(wlcmfnt);

        Label name_lbl_sub=new Label("Name :");
        name_lbl_sub.setTranslateX(50);
        name_lbl_sub.setTranslateY(120);
        TextField name_txt_sub=new TextField();
        name_txt_sub.setTranslateX(160);
        name_txt_sub.setTranslateY(120);

        Label Age_lbl_sub=new Label("Age :");
        Age_lbl_sub.setTranslateX(50);
        Age_lbl_sub.setTranslateY(160);
        TextField Age_txt_sub=new TextField();
        Age_txt_sub.setTranslateX(160);
        Age_txt_sub.setTranslateY(160);

        Label Subscription_type_lbl_sub=new Label("Subscription-Type :");
        Subscription_type_lbl_sub.setTranslateX(50);
        Subscription_type_lbl_sub.setTranslateY(200);
        TextField Subscription_type_txt_sub=new TextField();
        Subscription_type_txt_sub.setTranslateX(160);
        Subscription_type_txt_sub.setTranslateY(200);

        Label date_from_lbl_sub=new Label("Date-from :");
        date_from_lbl_sub.setTranslateX(50);
        date_from_lbl_sub.setTranslateY(240);
        TextField date_from_txt_sub=new TextField();
        date_from_txt_sub.setTranslateX(160);
        date_from_txt_sub.setTranslateY(240);

        Label date_to_lbl_sub=new Label("Date-to :");
        date_to_lbl_sub.setTranslateX(50);
        date_to_lbl_sub.setTranslateY(280);
        TextField date_to_txt_sub=new TextField();
        date_to_txt_sub.setTranslateX(160);
        date_to_txt_sub.setTranslateY(280);

        Label address_lbl_sub=new Label("Address :");
        address_lbl_sub.setTranslateX(50);
        address_lbl_sub.setTranslateY(320);
        TextField address_txt_sub=new TextField();
        address_txt_sub.setTranslateX(160);
        address_txt_sub.setTranslateY(320);

        Label phone_lbl_sub=new Label("Phone :");
        phone_lbl_sub.setTranslateX(50);
        phone_lbl_sub.setTranslateY(360);
        TextField phone_txt_sub=new TextField();
        phone_txt_sub.setTranslateX(160);
        phone_txt_sub.setTranslateY(360);

        Button subscription_btn_add_sub=new Button("Subscription-Add");
        subscription_btn_add_sub.setTranslateX(400);
        subscription_btn_add_sub.setTranslateY(320);
        subscription_btn_add_sub.setPrefWidth(150);
        subscription_btn_add_sub.setPrefHeight(50);

        Button sell_btn_add_sell=new Button("Sell-Add");
        sell_btn_add_sell.setTranslateX(580);
        sell_btn_add_sell.setTranslateY(320);
        sell_btn_add_sell.setPrefWidth(100);
        sell_btn_add_sell.setPrefHeight(50);

        Button ext_btn_add=new Button("Exit");
        ext_btn_add.setTranslateX(750);
        ext_btn_add.setTranslateY(540);

        Label msg=new Label("");
        msg.setTranslateX(480);
        msg.setTranslateY(480);
        msg.setFont(erfnt);
        msg.setTextFill(Color.GREEN);

        //creating elements of g6   --->    s6
        TableView <person>sub_table=new TableView<person>();
        sub_table.setTranslateX(80);
        sub_table.setTranslateY(50);
        sub_table.editableProperty().set(false);
        TableColumn idCol = new TableColumn("ID");
        TableColumn nameCol = new TableColumn("Name");
        TableColumn ageCol = new TableColumn("Age");
        TableColumn subTypeCol = new TableColumn("S_type");
        TableColumn fromCol = new TableColumn("From");
        TableColumn toCol = new TableColumn("To");
        TableColumn addressCol = new TableColumn("Address");
        TableColumn phoneCol = new TableColumn("Phone");
        idCol.setCellValueFactory(new PropertyValueFactory<person, String>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<person, String>("name"));
        ageCol.setCellValueFactory(new PropertyValueFactory<person, String>("age"));
        subTypeCol.setCellValueFactory(new PropertyValueFactory<person, String>("sub_type"));
        fromCol.setCellValueFactory(new PropertyValueFactory<person, String>("date_from"));
        toCol.setCellValueFactory(new PropertyValueFactory<person, String>("date_to"));
        addressCol.setCellValueFactory(new PropertyValueFactory<person, String>("address"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<person, String>("phone"));
        sub_table.setItems(list);

        Button ext_sub_btn=new Button("Exit");
        ext_sub_btn.setTranslateX(750);
        ext_sub_btn.setTranslateY(540);

        Button bck_sub_btn=new Button("Back");
        bck_sub_btn.setTranslateX(50);
        bck_sub_btn.setTranslateY(540);

        //creating sells-page elements
        TableView <product>sells_table=new TableView<product>();
        sells_table.setTranslateX(80);
        sells_table.setTranslateY(50);
        sells_table.editableProperty().set(false);
        TableColumn idsell = new TableColumn("ID");
        idsell.setCellValueFactory(new PropertyValueFactory<product, String>("id"));
        TableColumn namesell = new TableColumn("Product_Name");
        namesell.setCellValueFactory(new PropertyValueFactory<product, String>("name"));
        TableColumn pricesell = new TableColumn("Product_Price");
        pricesell.setCellValueFactory(new PropertyValueFactory<product, String>("price"));
        TableColumn datesell = new TableColumn("Date");
        datesell.setCellValueFactory(new PropertyValueFactory<product, String>("date"));
        TableColumn sub_id_sell = new TableColumn("SUB_ID");
        sub_id_sell.setCellValueFactory(new PropertyValueFactory<product, String>("sub_id"));
        sells_table.setItems(sellslist);

        Button ext_sells_btn =new Button("Exit");
        ext_sells_btn.setTranslateX(750);
        ext_sells_btn.setTranslateY(540);

        Button bck_sells_btn =new Button("Back");
        bck_sells_btn.setTranslateX(50);
        bck_sells_btn.setTranslateY(540);


        //adding elements to group1
        g1.getChildren().add(ext);
        g1.getChildren().add(sinIn);
        g1.getChildren().add(userlbl);
        g1.getChildren().add(passlbl);
        g1.getChildren().add(userfld);
        g1.getChildren().add(passfld);
        g1.getChildren().add(er);
        g1.getChildren().add(dbl);
        g1.getChildren().add(dbtf);


        //adding elements to group2
        g2.getChildren().add(wlcm);
        g2.getChildren().add(nxt);


        //adding elements to group3 ()
        g3.getChildren().add(bck);
        g3.getChildren().add(id_auth);
        g3.getChildren().add(pass_auth);
        g3.getChildren().add(id_auth_tf);
        g3.getChildren().add(pass_auth_tf);
        g3.getChildren().add(signin_btn_auth);
        g3.getChildren().add(er_auth);

        //adding elements to group4 (options_page)
        g4.getChildren().add(back_opt);
        g4.getChildren().add(exit_opt);
        g4.getChildren().add(add_opt);
        g4.getChildren().add(mod_opt);
        g4.getChildren().add(del_opt);
        g4.getChildren().add(sell_opt);
        g4.getChildren().add(sub_opt);
        g4.getChildren().add(title_opt);


        //adding elements to group5 (add option)
        g5.getChildren().add(name_lbl_sub);
        g5.getChildren().add(name_lbl_sell);
        g5.getChildren().add(back_add);
        g5.getChildren().add(Age_lbl_sub);
        g5.getChildren().add(Subscription_type_lbl_sub);
        g5.getChildren().add(date_from_lbl_sub);
        g5.getChildren().add(date_to_lbl_sub);
        g5.getChildren().add(address_lbl_sub);
        g5.getChildren().add(phone_lbl_sub);
        g5.getChildren().add(sells_lbl_sell);
        g5.getChildren().add(subscription_lbl_sub);
        g5.getChildren().add(Price_lbl_sell);
        g5.getChildren().add(date_lbl_sell);
        g5.getChildren().add(name_text_sell);
        g5.getChildren().add(Price_txt_sell);
        g5.getChildren().add(date_txt_sell);
        g5.getChildren().add(name_txt_sub);
        g5.getChildren().add(Age_txt_sub);
        g5.getChildren().add(Subscription_type_txt_sub);
        g5.getChildren().add(date_from_txt_sub);
        g5.getChildren().add(date_to_txt_sub);
        g5.getChildren().add(address_txt_sub);
        g5.getChildren().add(phone_txt_sub);
        g5.getChildren().add(subscription_btn_add_sub);
        g5.getChildren().add(sell_btn_add_sell);
        g5.getChildren().add(ext_btn_add);
        g5.getChildren().add(msg);


        //adding g6 elements
        g6.getChildren().add(sub_table);
        g6.getChildren().add(ext_sub_btn);
        g6.getChildren().add(bck_sub_btn);


        //adding g7 elements
        g7.getChildren().addAll(sells_table,ext_sells_btn,bck_sells_btn);

        //creating container(scene)
        Scene s1=new Scene(g1,300,300);
        Scene s2=new Scene(g2,300,300);
        Scene s3=new Scene(g3,300,300);
        Scene s4=new Scene(g4,800,600);
        Scene s5=new Scene(g5,800,600);
        Scene s6=new Scene(g6,800,600);
        Scene s7=new Scene(g7,800,600);
        Scene s8=new Scene(g8,300,300);

        //setting our scene
        primaryStage.setScene(s2);


        //showing the stage
        primaryStage.show();









        //adding events for the elements
        ext.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.exit(0);
            }
        });


        //adding event for next in home page
        nxt.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                // TODO Auto-generated method stub
                primaryStage.setScene(s1);
                primaryStage.setTitle("LogIn-page");
            }
        });


        //adding event for back in LogIn page
        bck.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                // TODO Auto-generated method stub
                primaryStage.setScene(s1);
                primaryStage.setTitle("LogIn-page");
                er.setText("");
                try {
                    con.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    System.out.println("Error:"+e);
                }
            }
        });


        //adding event for sinIn in LogIn page
        sinIn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                // TODO Auto-generated method stub
                //getting values of username and password fields into variables
                String user= userfld.getText();
                String pass= passfld.getText();
                String db=dbtf.getText();



                //initializing connection object
                try {
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db+"?useSSL=false", user, pass);
                    if(con!=null) {

                        primaryStage.setScene(s3);
                        primaryStage.setTitle("AuthenticationPage");
                        passfld.clear();
                        userfld.clear();
                        er.setText("Correct");
                        er.setTextFill(Color.DARKGREEN);

                    }

                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    System.out.println("Error:"+e);
                    er.setText("Invalid");
                    er.setTextFill(Color.DARKRED);
                }
            }

        });



        signin_btn_auth.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                // TODO Auto-generated method stub
                int id=Integer.parseInt(id_auth_tf.getText());
                String pass=pass_auth_tf.getText();
                String q="select "+id+","+pass+" from employees";


                try {
                    //creating statement object from the current DBconnection
                    Statement st=con.createStatement();
                    ResultSet stres=st.executeQuery("select * from employees;");
                    //extracting retrieved data from the result-set
                    while(stres.next()) {
                        int id_=stres.getInt("id_");
                        String pass_=stres.getString("pass_").toString();
                        //verifying that user_id and password are correct
                        if(pass.equals(pass_) && id==id_) {

                            //calling the nextPage(option page) function
                            primaryStage.setScene(s4);
                            primaryStage.setTitle("OptionPage");
                            er_auth.setText("LoggedIn");
                            er_auth.setTextFill(Color.DARKGREEN);

                        }else {
                            //creating error msg
                            er_auth.setText("Invalid!");
                            er_auth.setTextFill(Color.DARKRED);
                        }


                    }
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    System.out.print("error:"+e1);
                }

            }
        });





        //adding events for the elements
        back_opt.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                // TODO Auto-generated method stub
                id_auth_tf.setText("");
                pass_auth_tf.setText("");
                er_auth.setText("");
                primaryStage.setScene(s3);
            }
        });

        exit_opt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent a) {
                System.exit(0);
            }
        });



        add_opt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent a) {
                primaryStage.setScene(s5);
                primaryStage.setTitle("AddPage");
            }
        });



        back_add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent a) {
                primaryStage.setScene(s4);
                primaryStage.setTitle("OptionsPage");
                msg.setText("");
            }
        });




        ext_btn_add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent a) {
                System.exit(0);
            }
        });





        subscription_btn_add_sub.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent a) {
                String name=name_txt_sub.getText();
                int age=Integer.parseInt(Age_txt_sub.getText().toString());
                String sub_type=Subscription_type_txt_sub.getText();
                String date_from=date_from_txt_sub.getText();
                String date_to=date_to_txt_sub.getText();
                String address=address_txt_sub.getText();
                int phone=Integer.parseInt(phone_txt_sub.getText().toString());


                try {
                    Statement stmt = con.createStatement();
                    String s="insert into subscribtions(_id,_name,_age,_subscribtionsType,_date_from,_date_to,_address,_phone) values(_id"+",'"+name+"'"+","+age+",'"+sub_type+"','"+date_from+"','"+date_to+"','"+address+"',"+phone+")";
                    con.prepareStatement(s).executeUpdate();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    System.out.println("Error:"+e);
                }

                name_txt_sub.setText("");
                Age_txt_sub.setText("");
                Subscription_type_txt_sub.setText("");
                date_from_txt_sub.setText("");
                date_to_txt_sub.setText("");
                address_txt_sub.setText("");
                phone_txt_sub.setText("");
                msg.setText("Subscription added successfully");



            }
        });





        sell_btn_add_sell.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent a) {
                String name=name_text_sell.getText();
                double price=Double.parseDouble(Price_txt_sell.getText().toString());
                String date=date_txt_sell.getText();


                try {
                    Statement stmt = con.createStatement();
                    String s="insert into sells(_name,_price,_date) values('"+name+"',"+price+",'"+date+"')";
                    con.prepareStatement(s).executeUpdate();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    System.out.println("Error:"+e);
                }

                name_text_sell.setText("");
                date_txt_sell.setText("");
                Price_txt_sell.setText("");
                msg.setText("Sell added successfully");



            }
        });


        ext_sub_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.exit(0);
            }
        });


        bck_sub_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.setScene(s4);
                list.clear();
            }
        });




        sub_opt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                //Adding data to the table
                try {
                    String query = "select * from subscribtions";
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    while (rs.next()) {
                        person temp = new person(String.valueOf(rs.getInt(1)), rs.getString(2), String.valueOf(rs.getInt(3)), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), String.valueOf(rs.getInt(8)));
                            list.add(temp);
                        }
                    sub_table.getColumns().setAll(idCol, nameCol, ageCol, subTypeCol, fromCol, toCol, addressCol, phoneCol);

                } catch (Exception e) {
                    System.out.println("Error:" + e);
                }


                primaryStage.setScene(s6);
                primaryStage.setTitle("Subscriptions-Page");
        }
        });


        bck_sells_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                sellslist.clear();
                primaryStage.setScene(s4);
            }
        });

        ext_sells_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.exit(0);
            }
        });


        sell_opt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //Adding data to the table
                try {
                    String query1 = "select * from sells";
                    Statement st1 = con.createStatement();
                    ResultSet rs1 = st1.executeQuery(query1);
                    while (rs1.next()) {
                        product temp1 = new product(rs1.getString(1),rs1.getString(2),rs1.getString(3), rs1.getString(4), rs1.getString(5));
                        sellslist.add(temp1);
                    }
                    sells_table.getColumns().setAll(idsell,namesell,pricesell,datesell,sub_id_sell);

                } catch (Exception e) {
                    System.out.println("Error:" + e);
                }

                primaryStage.setScene(s7);
                primaryStage.setTitle("Sells-Page");
            }
        });




    }


    public class person {
        String id;
        String name;
        String age;
        String sub_type;
        String date_from;
        String date_to;
        String address;
        String phone;
        person(String id, String name, String age, String sub_type,String date_from,String date_to,String address,String phone) {
            this.id= id;
            this.name=name;
            this.age=age;
            this.sub_type=sub_type;
            this.date_from=date_from;
            this.date_to=date_to;
            this.address=address;
            this.phone=phone;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getAge() {
            return age;
        }

        public String getSub_type() {
            return sub_type;
        }

        public String getDate_from() {
            return date_from;
        }

        public String getDate_to() {
            return date_to;
        }

        public String getAddress() {
            return address;
        }

        public String getPhone() {
            return phone;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public void setSub_type(String sub_type) {
            this.sub_type = sub_type;
        }

        public void setDate_from(String date_from) {
            this.date_from = date_from;
        }

        public void setDate_to(String date_to) {
            this.date_to = date_to;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
}



public class product{
        String id;
        String name;
        String price;
        String date;
        String sub_id;
        product(String id,String name,String price,String date,String sub_id){
            this.id=id;
            this.name=name;
            this.price=price;
            this.date=date;
            this.sub_id=sub_id;
        }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }

    public String getSub_id() {
        return sub_id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setSub_id(String sub_id) {
        this.sub_id = sub_id;
    }
}



    public static void main(String[] args) {
        launch();
    }


}