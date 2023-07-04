# from socket import *
from time import ctime
# import RPi.GPIO as GPIO
import email
import time
import smtplib
import imaplib
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
from email.mime.base import MIMEBase
from email import encoders

ctrCmd = [ 'bd1l1_on','bd1l1_off','bd1l2_on','bd1l2_off','bd1f1_on','bd1f1_off','bd1f2_on','bd1f2_off','bd2l1_on','bd2l1_off','bd2l2_on','bd2l2_off','bd2f1_on','bd2f1_off','bd2f2_on','bd2f2_off']


# GPIO.cleanup()
# GPIO.setmode(GPIO.BOARD)

# GPIO.setup(32,GPIO.OUT)
# GPIO.setup(36,GPIO.OUT)
# GPIO.setup(38,GPIO.OUT)
# GPIO.setup(40,GPIO.OUT)


# GPIO.setup(31,GPIO.OUT)
# GPIO.setup(33,GPIO.OUT)
# GPIO.setup(35,GPIO.OUT)
# GPIO.setup(37,GPIO.OUT)


# GPIO.output(32,GPIO.HIGH)
# GPIO.output(36,GPIO.HIGH)
# GPIO.output(38,GPIO.HIGH)
# GPIO.output(40,GPIO.HIGH)
# GPIO.output(31,GPIO.HIGH)
# GPIO.output(33,GPIO.HIGH)
# GPIO.output(35,GPIO.HIGH)
# GPIO.output(37,GPIO.HIGH)


def checkEmail():
        mail = imaplib.IMAP4_SSL('imap.gmail.com')
        print("Initial Step 1")
        mail.login('arjunsudhakar23@gmail.com','bczqjopoiwtwxbmd')
        print("Initial Step 2")
        mail.list()  # Gives list of folders or labels in gmail.
        print("Initial Step 3")
        while True:
                print(">>Checking...")
                try:
                        files = []
                        # Connect to inbox
                        mail.select("inbox"); 
                        #print("first email checking")
                        # Search for an unread email from user's email address
                        result, data = mail.search(None,'(UNSEEN FROM "arjunkarupaiya28@gmail.com")');
                        ids = data[0]   # data is a list
                        id_list = ids.split() # ids is a space separated string

                        latest_email_id = id_list[-1] # get the latest
                        result, data = mail.fetch(latest_email_id, "(RFC822)");

                        raw_email = data[0][1];

                        recv_msg = email.message_from_string(raw_email.decode())
                        data=recv_msg['Subject']
                        if data == ctrCmd[0]:
                                GPIO.output(32,GPIO.LOW)
                                print ('bd1l1_on')
                        elif data == ctrCmd[1]:
                                GPIO.output(32,GPIO.HIGH)
                                print ('bd1l1_off ')
                        elif data == ctrCmd[2]:
                                GPIO.output(36,GPIO.LOW)
                                print ('bd1l2_on')
                        elif data == ctrCmd[3]:
                                GPIO.output(36,GPIO.HIGH)
                                print ('bd1l2_off ')
                        elif data == ctrCmd[4]:
                                GPIO.output(38,GPIO.LOW)
                                print ('bd1f1_on')
                        elif data == ctrCmd[5]:
                                GPIO.output(38,GPIO.HIGH)
                                print ('bd1f1_off ')
                        elif data == ctrCmd[6]:
                                GPIO.output(40,GPIO.LOW)
                                print ('bd1f2_on')
                        elif data == ctrCmd[7]:
                                GPIO.output(40,GPIO.HIGH)
                                print ('bd1f2_off ')
                        elif data == ctrCmd[8]:
                                GPIO.output(31,GPIO.LOW)
                                print ('bd2l1_on')
                        elif data == ctrCmd[9]:
                                GPIO.output(31,GPIO.HIGH)
                                print ('bd2l1_off ')
                        elif data == ctrCmd[10]:
                                GPIO.output(33,GPIO.LOW)
                                print ('bd2l2_on')
                        elif data == ctrCmd[11]:
                                GPIO.output(33,GPIO.HIGH)
                                print ('bd2l2_off ')
                        elif data == ctrCmd[12]:
                                GPIO.output(35,GPIO.LOW)
                                print ('bd2f1_on')
                        elif data == ctrCmd[13]:
                                GPIO.output(35,GPIO.HIGH)
                                print ('bd2f1_off ')
                        elif data == ctrCmd[14]:
                                GPIO.output(37,GPIO.LOW)
                                print ('bd2f2_on')
                        elif data == ctrCmd[15]:
                                GPIO.output(37,GPIO.HIGH)
                                print ('bd2f2_off ')
                         
                        else:
                              print("Not the command: ")+recv_msg['Subject']   
                                                    
                except Exception as e:
                        err = str(e)
                        print(e) 
                        #GPIO.cleanup()
                        time.sleep(1)
                        continue
loop = 1;
while loop:
        try:
                print(">Checking...")
                checkEmail()
        except Exception as e:
                print("Exception Main Continue Checking...")
                print(e)
                break
        
