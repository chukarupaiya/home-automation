package com.example.livesmart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;


import android.app.ProgressDialog;
import android.content.Context;

import android.widget.Toast;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class MainActivity extends AppCompatActivity {
    String strEmail;
    String strSerEmail;
    String strPass;

    EditText txtAddress;
    public static String wifiModuleIp = "";
    public static int wifiModulePort = 0;
    public static String CMD = "0";

    TextView iPAdd;


    Button btnon1;
    Button btnon2;
    Button btnon3;
    Button btnon4;
    Button btnon5;
    Button btnon6;
    Button btnon7;
    Button btnon8;
    Button btnon9;
    Button btnon10;
    Button btnon11;
    Button btnon12;
    Button btnon13;
    Button btnon14;
    Button btnon15;
    Button btnon16;
    Button btnon17;
    Button btnon18;
    Button btnon19;
    Button btnon20;
    Button btnon21;
    Button btnon22;
    Button btnon23;


    Button btnoff1;
    Button btnoff2;
    Button btnoff3;
    Button btnoff4;
    Button btnoff5;
    Button btnoff6;
    Button btnoff7;
    Button btnoff8;
    Button btnoff9;
    Button btnoff10;
    Button btnoff11;
    Button btnoff12;
    Button btnoff13;
    Button btnoff14;
    Button btnoff15;
    Button btnoff16;
    Button btnoff17;
    Button btnoff18;
    Button btnoff19;
    Button btnoff20;
    Button btnoff21;
    Button btnoff22;
    Button btnoff23;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Switch swNetwork = (Switch)this.findViewById(R.id.swNetwork);

        btnon1 = (Button) findViewById(R.id.btn1);
        btnon2 = (Button) findViewById(R.id.btn3);
        btnon3 = (Button) findViewById(R.id.btn5);
        btnon4 = (Button) findViewById(R.id.btn7);
        btnon5 = (Button) findViewById(R.id.btn9);
        btnon6 = (Button) findViewById(R.id.btn11);
        btnon7 = (Button) findViewById(R.id.btn13);
        btnon8 = (Button) findViewById(R.id.btn15);
        btnon9 = (Button) findViewById(R.id.btn17);
        btnon10 = (Button) findViewById(R.id.btn19);
        btnon11 = (Button) findViewById(R.id.btn21);
        btnon12 = (Button) findViewById(R.id.btn23);
        btnon13 = (Button) findViewById(R.id.btn25);
        btnon14 = (Button) findViewById(R.id.btn27);
        btnon15 = (Button) findViewById(R.id.btn29);
        btnon16 = (Button) findViewById(R.id.btn31);
        btnon17 = (Button) findViewById(R.id.btn33);
        btnon18 = (Button) findViewById(R.id.btn35);
        btnon19 = (Button) findViewById(R.id.btn37);
        btnon20 = (Button) findViewById(R.id.btn39);
        btnon21 = (Button) findViewById(R.id.btn41);
        btnon22= (Button) findViewById(R.id.btn43);
        btnon23 = (Button) findViewById(R.id.btn45);




        btnoff1 = (Button) findViewById(R.id.btn2);
        btnoff2 = (Button) findViewById(R.id.btn4);
        btnoff3 = (Button) findViewById(R.id.btn6);
        btnoff4 = (Button) findViewById(R.id.btn8);
        btnoff5 = (Button) findViewById(R.id.btn10);
        btnoff6 = (Button) findViewById(R.id.btn12);
        btnoff7 = (Button) findViewById(R.id.btn14);
        btnoff8 = (Button) findViewById(R.id.btn16);
        btnoff9 = (Button) findViewById(R.id.btn18);
        btnoff10 = (Button) findViewById(R.id.btn20);
        btnoff11 = (Button) findViewById(R.id.btn22);
        btnoff12 = (Button) findViewById(R.id.btn24);
        btnoff13 = (Button) findViewById(R.id.btn26);
        btnoff14 = (Button) findViewById(R.id.btn28);
        btnoff15 = (Button) findViewById(R.id.btn30);
        btnoff16 = (Button) findViewById(R.id.btn32);
        btnoff17 = (Button) findViewById(R.id.btn34);
        btnoff18 = (Button) findViewById(R.id.btn36);
        btnoff19 = (Button) findViewById(R.id.btn38);
        btnoff20 = (Button) findViewById(R.id.btn40);
        btnoff21 = (Button) findViewById(R.id.btn42);
        btnoff22 = (Button) findViewById(R.id.btn44);
        btnoff23= (Button) findViewById(R.id.btn46);


         String clientEmail = "arjunkarupaiya28@gmail.com";
         String serverEmail = "arjunsudhakar23@gmail.com";
         String passW = "fjuanckcyuqcikwf" ;


        txtAddress = (EditText)this.findViewById(R.id.txtIP);

    //bed room -1
       btnon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("bd1l1_on","bd1l1_on");
                }
                else
                {
                    getIPandPort();
                    CMD = "bd1l1_on";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });
        btnoff1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("bd1l1_off","bd1l1_off");
                }
                else
                {
                    getIPandPort();
                    CMD = "bd1l1_off";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });






        btnon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("bd1l2_on","bd1l2_on");
                }
                else
                {
                    getIPandPort();
                    CMD = "bd1l2_on";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });
        btnoff2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("bd1l2_off","bd1l2_off");
                }
                else
                {
                    getIPandPort();
                    CMD = "bd1l2_off";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });






        btnon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("bd1f1_on","bd1f1_on");
                }
                else
                {
                    getIPandPort();
                    CMD = "bd1f1_on";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });
        btnoff3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("bd1f1_off","bd1f1_off");
                }
                else
                {
                    getIPandPort();
                    CMD = "bd1f1_off";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });



        btnon4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("bd1s1_on","bd1s1_on");
                }
                else
                {
                    getIPandPort();
                    CMD = "bd1s1_on";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });
        btnoff4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("bd1s1_off","bd1s1_off");
                }
                else
                {
                    getIPandPort();
                    CMD = "bd1s1_off";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });




//bed room-2

        btnon5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("bd2l1_on","bd2l1_on");
                }
                else
                {
                    getIPandPort();
                    CMD = "bd2l1_on";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });
        btnoff5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("bd2l1_off","bd2l1_off");
                }
                else
                {
                    getIPandPort();
                    CMD = "bd2l1_off";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });




        btnon6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("bd2l2_on","bd2l2_on");
                }
                else
                {
                    getIPandPort();
                    CMD = "bd2l2_on";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });
        btnoff6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("bd2l2_off","bd2l2_off");
                }
                else
                {
                    getIPandPort();
                    CMD = "bd2l2_off";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });




        btnon7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("bd2f1_on","bd2f1_on");
                }
                else
                {
                    getIPandPort();
                    CMD = "bd2f1_on";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });
        btnoff7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("bd2f1_off","bd2f1_off");
                }
                else
                {
                    getIPandPort();
                    CMD = "bd2f1_off";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });




        btnon8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("bd2s1_on","bd2s1_on");
                }
                else
                {
                    getIPandPort();
                    CMD = "bd2s1_on";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });
        btnoff8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("bd2s1_off","bd2s1_off");
                }
                else
                {
                    getIPandPort();
                    CMD = "bd2s1_off";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });



//bed-room -3


        btnon9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("bd3l1_on","bd3l1_on");
                }
                else
                {
                    getIPandPort();
                    CMD = "bd3l1_on";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });
        btnoff9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("bd3l1_off","bd3l1_off");
                }
                else
                {
                    getIPandPort();
                    CMD = "bd3l1_off";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });






        btnon10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("bd3l2_on","bd3l2_on");
                }
                else
                {
                    getIPandPort();
                    CMD = "bd3l2_on";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });
        btnoff10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("bd3l2_off","bd3l2_off");
                }
                else
                {
                    getIPandPort();
                    CMD = "bd3l2_off";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });






        btnon11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("bd3f1_on","bd3f1_on");
                }
                else
                {
                    getIPandPort();
                    CMD = "bd3f1_on";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });
        btnoff11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("bd3f1_off","bd3f1_off");
                }
                else
                {
                    getIPandPort();
                    CMD = "bd3f1_off";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });



        btnon12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("bd3s1_on","bd3s1_on");
                }
                else
                {
                    getIPandPort();
                    CMD = "bd3s1_on";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });
        btnoff12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("bd3s1_off","bd3s1_off");
                }
                else
                {
                    getIPandPort();
                    CMD = "bd3s1_off";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });





//bed room-4

        btnon13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("bd4l1_on","bd4l1_on");
                }
                else
                {
                    getIPandPort();
                    CMD = "bd4l1_on";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });
        btnoff13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("bd4l1_off","bd4l1_off");
                }
                else
                {
                    getIPandPort();
                    CMD = "bd4l1_off";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });






        btnon14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("bd4l2_on","bd4l2_on");
                }
                else
                {
                    getIPandPort();
                    CMD = "bd4l2_on";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });
        btnoff14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("bd4l2_off","bd4l2_off");
                }
                else
                {
                    getIPandPort();
                    CMD = "bd4l2_off";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });






        btnon15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("bd4f1_on","bd4f1_on");
                }
                else
                {
                    getIPandPort();
                    CMD = "bd4f1_on";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });
        btnoff15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("bd4f1_off","bd4f1_off");
                }
                else
                {
                    getIPandPort();
                    CMD = "bd4f1_off";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });



        btnon16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("bd4s1_on","bd4s1_on");
                }
                else
                {
                    getIPandPort();
                    CMD = "bd4s1_on";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });
        btnoff16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("bd4s1_off","bd4s1_off");
                }
                else
                {
                    getIPandPort();
                    CMD = "bd4s1_off";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });




//hall

        btnon17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("hl1_on","hl1_on");
                }
                else
                {
                    getIPandPort();
                    CMD = "hl1_on";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });
        btnoff17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("hl1_off","hl1_off");
                }
                else
                {
                    getIPandPort();
                    CMD = "hl1_off";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });






        btnon18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("hl2_on","hl2_on");
                }
                else
                {
                    getIPandPort();
                    CMD = "hl2_on";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });
        btnoff18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("hl2_off","hl2_off");
                }
                else
                {
                    getIPandPort();
                    CMD = "hl2_off";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });






        btnon19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("hf1_on","hf1_on");
                }
                else
                {
                    getIPandPort();
                    CMD = "hf1_on";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });
        btnoff19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("hf1_off","hf1_off");
                }
                else
                {
                    getIPandPort();
                    CMD = "hf1_off";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });



        btnon20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("hs1_on","hs1_on");
                }
                else
                {
                    getIPandPort();
                    CMD = "hs1_on";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });
        btnoff20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("hs1_off","hs1_off");
                }
                else
                {
                    getIPandPort();
                    CMD = "hs1_off";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });




    //kitchen


        btnon21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("kl1_on","kl1_on");
                }
                else
                {
                    getIPandPort();
                    CMD = "kl1_on";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });
        btnoff21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("kl1_off","kl1_off");
                }
                else
                {
                    getIPandPort();
                    CMD = "kl1_off";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });






        btnon22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("kl2_on","kl2_on");
                }
                else
                {
                    getIPandPort();
                    CMD = "kl2_on";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });
        btnoff22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("kl2_off","kl2_off");
                }
                else
                {
                    getIPandPort();
                    CMD = "kl2_off";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });



        btnon23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("ks1_on","ks1_on");
                }
                else
                {
                    getIPandPort();
                    CMD = "ks1_on";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });
        btnoff23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!swNetwork.isChecked())
                {
                    sendEmail("ks1_off","ks1_off");
                }
                else
                {
                    getIPandPort();
                    CMD = "ks1_off";
                    Socket_AsyncTask cmd_increase_servo = new Socket_AsyncTask();
                    cmd_increase_servo.execute();
                }
            }
        });




    }
   private void sendEmail(String subj, String msg) {



        strEmail = "arjunkarupaiya28@gmail.com";
        strSerEmail = "arjunsudhakar23@gmail.com";
        strPass = "fjuanckcyuqcikwf" ;
        String email = strSerEmail;
        String subject = subj;
        String message = msg;
        //Creating SendMail object
        ActivitySendEmail sm = new ActivitySendEmail(this, email, subject, message, strEmail, strPass);
        //Executing sendmail to send email
        sm.execute();
    }

    public void getIPandPort()
    {
        String iPandPort = txtAddress.getText().toString();
        Log.d("MYTEST","IP String: "+ iPandPort);
        String temp[]= iPandPort.split(":");
        wifiModuleIp = temp[0];
        wifiModulePort = Integer.valueOf(temp[1]);
        Log.d("MY TEST","IP:" +wifiModuleIp);
        Log.d("MY TEST","PORT:"+wifiModulePort);

    }
    public class Socket_AsyncTask extends AsyncTask<Void,Void,Void>
    {
        Socket socket;

        @Override
        protected Void doInBackground(Void... params){
            try{
                InetAddress inetAddress = InetAddress.getByName(MainActivity.wifiModuleIp);
                socket = new java.net.Socket(inetAddress,MainActivity.wifiModulePort);
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeUTF(CMD);
                dataOutputStream.close();
                socket.close();


            }catch (UnknownHostException e){e.printStackTrace();}catch (IOException e){e.printStackTrace();}
            return null;
        }
    }



    public class ActivitySendEmail extends AsyncTask<Void,Void,Void> {

        //Declaring Variables
        private Context context;
        private Session session;
        //Information to send email
        private String email;
        private String subject;
        private String message;
        private String clientemail;
        private String clientpass;


        //Progressdialog to show while sending email
        private ProgressDialog progressDialog;

        //Class Constructor
        public ActivitySendEmail(Context context, String email, String subject, String message, String clientemail,String clientpass){
            //Initializing variables
            this.context = context;
            this.email = email;
            this.subject = subject;
            this.message = message;
            this.clientemail = clientemail;
            this.clientpass = clientpass;


        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Showing progress dialog while sending email
            progressDialog = ProgressDialog.show(context,"Sending Command","Please wait...",false,false);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //Dismissing the progress dialog
            progressDialog.dismiss();
            //Showing a success message
            Toast.makeText(context,"Message Sent", Toast.LENGTH_LONG).show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            //Creating properties
            Properties props = new Properties();

            try {

                //Configuring properties for gmail
                //If you are not using gmail you may need to change the values
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.socketFactory.port", "465");
                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "465");

                //Creating a new session
                session = Session.getDefaultInstance(props,
                        new javax.mail.Authenticator() {
                            //Authenticating the password
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(clientemail, clientpass);
                            }
                        });

                try {
                    //Creating MimeMessage object
                    Message mm = new MimeMessage(session);

                    //Setting sender address
                    mm.setFrom(new InternetAddress(clientemail));
                    //Adding receiver
                    mm.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
                    //Adding subject
                    mm.setSubject(subject);
                    //Adding message
                    mm.setText(message);

                    //Sending email
                    Transport.send(mm);

                } catch (MessagingException e) {
                    e.printStackTrace();
                }

            }catch (Exception e){

            }
            return null;


        }
    }

}