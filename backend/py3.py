from time import ctime
import RPi.GPIO as GPIO

#the program to turn in the street lights at 6pm-6am

GPIO.setmode(GPIO.BOARD)

GPIO.setup(8,GPIO.OUT)
GPIO.output(8,GPIO.HIGH)

while(TRUE):
    GPIO.output(8,GPIO.LOW)
    #time.sleep(43200);
    time.sleep(5)
    GPIO.output(8,GPIO.HIGH)