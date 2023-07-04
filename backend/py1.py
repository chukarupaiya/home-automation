from socket import *
from time import ctime
import RPi.GPIO as GPIO


ctrCmd = [ 'bd1l1_on','bd1l1_off','bd1l2_on','bd1l2_off','bd1f1_on','bd1f1_off','bd1s1_on','bd1s1_off',
           'bd2l1_on','bd2l1_off','bd2l2_on','bd2l2_off','bd2f1_on','bd2f1_off','bd2s1_on','bd2s1_off',
           'bd3l1_on','bd3l1_off','bd3l2_on','bd3l2_off','bd3f1_on','bd3f1_off','bd3s1_on','bd3s1_off',
           'bd4l1_on','bd4l1_off','bd4l2_on','bd4l2_off','bd4f1_on','bd4f1_off','bd4s1_on','bd4s1_off',
           'hl1_on','hl1_off','hl2_on','hl2_off','hf1_on','hf1_off','hs1_on','hs1_off',
           'kl1_on','kl1_off','kl2_on','kl2_off','ks1_on','ks1_off',
           ]

HOST = ''
PORT = 21568
BUFSIZE = 1024
ADDR = (HOST,PORT)



tcpSerSock = socket(AF_INET, SOCK_STREAM)
tcpSerSock.bind(ADDR)
tcpSerSock.listen(5)


GPIO.cleanup()
GPIO.setmode(GPIO.BOARD)


#bed room-1
GPIO.setup(32,GPIO.OUT)
GPIO.setup(36,GPIO.OUT)
GPIO.setup(38,GPIO.OUT)
GPIO.setup(40,GPIO.OUT)

#bed room-2
GPIO.setup(31,GPIO.OUT)
GPIO.setup(33,GPIO.OUT)
GPIO.setup(35,GPIO.OUT)
GPIO.setup(37,GPIO.OUT)


#bed room-3
GPIO.setup(18,GPIO.OUT)
GPIO.setup(22,GPIO.OUT)
GPIO.setup(24,GPIO.OUT)
GPIO.setup(26,GPIO.OUT)

#bed room-4
GPIO.setup(15,GPIO.OUT)
GPIO.setup(19,GPIO.OUT)
GPIO.setup(21,GPIO.OUT)
GPIO.setup(23,GPIO.OUT)

#hall
GPIO.setup(5,GPIO.OUT)
GPIO.setup(7,GPIO.OUT)
GPIO.setup(11,GPIO.OUT)
GPIO.setup(13,GPIO.OUT)


#kitchen
GPIO.setup(10,GPIO.OUT)
GPIO.setup(12,GPIO.OUT)
GPIO.setup(16,GPIO.OUT)




GPIO.output(32,GPIO.HIGH)
GPIO.output(36,GPIO.HIGH)
GPIO.output(38,GPIO.HIGH)
GPIO.output(40,GPIO.HIGH)

GPIO.output(31,GPIO.HIGH)
GPIO.output(33,GPIO.HIGH)
GPIO.output(35,GPIO.HIGH)
GPIO.output(37,GPIO.HIGH)

GPIO.output(18,GPIO.HIGH)
GPIO.output(22,GPIO.HIGH)
GPIO.output(24,GPIO.HIGH)
GPIO.output(26,GPIO.HIGH)

GPIO.output(15,GPIO.HIGH)
GPIO.output(19,GPIO.HIGH)
GPIO.output(21,GPIO.HIGH)
GPIO.output(23,GPIO.HIGH)

GPIO.output(5,GPIO.HIGH)
GPIO.output(7,GPIO.HIGH)
GPIO.output(11,GPIO.HIGH)
GPIO.output(13,GPIO.HIGH)

GPIO.output(10,GPIO.HIGH)
GPIO.output(12,GPIO.HIGH)
GPIO.output(16,GPIO.HIGH)

while True:
        print ('Waiting for connection')
        tcpCliSock,addr = tcpSerSock.accept()
        print ('...connected from :', addr)
        try:
                while True:
                        data = ''
                        data = tcpCliSock.recv(BUFSIZE).decode()
                        data = data[2:]
                        print(data)
                        if not data:
                                break
                        #checked
                        elif data == ctrCmd[0]:
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
                                print ('bd1s1_on')
                        elif data == ctrCmd[7]:
                                GPIO.output(40,GPIO.HIGH)
                                print ('bd1s1_off ')

                        #checked      
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
                                print ('bd2s1_on')
                        elif data == ctrCmd[15]:
                                GPIO.output(37,GPIO.HIGH)
                                print ('bd2s1_off ')


                        elif data == ctrCmd[16]:
                                GPIO.output(18,GPIO.LOW)
                                print ('bd3l1_on')
                        elif data == ctrCmd[17]:
                                GPIO.output(18,GPIO.HIGH)
                                print ('bd3l1_off ')
                        elif data == ctrCmd[18]:
                                GPIO.output(22,GPIO.LOW)
                                print ('bd3l2_on')
                        elif data == ctrCmd[19]:
                                GPIO.output(22,GPIO.HIGH)
                                print ('bd3l2_off ')
                        elif data == ctrCmd[20]:
                                GPIO.output(24,GPIO.LOW)
                                print ('bd3f1_on')
                        elif data == ctrCmd[21]:
                                GPIO.output(24,GPIO.HIGH)
                                print ('bd3f1_off ')
                        elif data == ctrCmd[22]:
                                GPIO.output(26,GPIO.LOW)
                                print ('bd3s1_on')
                        elif data == ctrCmd[23]:
                                GPIO.output(26,GPIO.HIGH)
                                print ('bd3s1_off ')


                        elif data == ctrCmd[24]:
                                GPIO.output(15,GPIO.LOW)
                                print ('bd4l1_on')
                        elif data == ctrCmd[25]:
                                GPIO.output(15,GPIO.HIGH)
                                print ('bd4l1_off ')
                        elif data == ctrCmd[26]:
                                GPIO.output(19,GPIO.LOW)
                                print ('bd4l2_on')
                        elif data == ctrCmd[27]:
                                GPIO.output(19,GPIO.HIGH)
                                print ('bd4l2_off ')
                        elif data == ctrCmd[28]:
                                GPIO.output(21,GPIO.LOW)
                                print ('bd4f1_on')
                        elif data == ctrCmd[29]:
                                GPIO.output(21,GPIO.HIGH)
                                print ('bd4f1_off ')
                        elif data == ctrCmd[30]:
                                GPIO.output(23,GPIO.LOW)
                                print ('bd4s1_on')
                        elif data == ctrCmd[31]:
                                GPIO.output(23,GPIO.HIGH)
                                print ('bd4s1_off ')



                        elif data == ctrCmd[32]:
                                GPIO.output(5,GPIO.LOW)
                                print ('hl1_on')
                        elif data == ctrCmd[33]:
                                GPIO.output(5,GPIO.HIGH)
                                print ('hl1_off ')
                        elif data == ctrCmd[34]:
                                GPIO.output(7,GPIO.LOW)
                                print ('hl2_on')
                        elif data == ctrCmd[35]:
                                GPIO.output(7,GPIO.HIGH)
                                print ('hl2_off ')
                        elif data == ctrCmd[36]:
                                GPIO.output(11,GPIO.LOW)
                                print ('hf1_on')
                        elif data == ctrCmd[37]:
                                GPIO.output(11,GPIO.HIGH)
                                print ('f1_off ')
                        elif data == ctrCmd[38]:
                                GPIO.output(13,GPIO.LOW)
                                print ('hs1_on')
                        elif data == ctrCmd[39]:
                                GPIO.output(13,GPIO.HIGH)
                                print ('hs1_off ')


                        elif data == ctrCmd[40]:
                                GPIO.output(10,GPIO.LOW)
                                print ('kl1_on')
                        elif data == ctrCmd[41]:
                                GPIO.output(10,GPIO.HIGH)
                                print ('kl1_off ')
                        elif data == ctrCmd[42]:
                                GPIO.output(12,GPIO.LOW)
                                print ('kl2_on')
                        elif data == ctrCmd[43]:
                                GPIO.output(12,GPIO.HIGH)
                                print ('kl2_off ')
                        elif data == ctrCmd[44]:
                                GPIO.output(16,GPIO.LOW)
                                print ('ks1_on')
                        elif data == ctrCmd[45]:
                                GPIO.output(16,GPIO.HIGH)
                                print ('ks1_off ')
                        
                


                        
 
                        
                                                               
        except KeyboardInterrupt:
                        GPIO.cleanup()
tcpSerSock.close();
GPIO.cleanup()
