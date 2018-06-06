package com.duohui.example.android_processing;


import processing.core.PApplet;
import processing.core.PImage;


public class Sketch extends PApplet {

    PImage img1, img2, img3;

    int startSpeed = 0;
    int endSpeed = 0;

    int startDegree = 0;
    int endDegree = 0;


    int text;
    int degree;
    int arc;

    boolean start = true;

    int delaySecond =0;




    public void settings() {
        fullScreen();
    }

    public void setup() {


        background(255, 255, 255);
        noStroke();

        img1 = loadImage("back.png");
        img2 = loadImage("image.png");
        img3 = loadImage("gra_img.png");


        imageMode(CENTER);
        image(img1, width / 2, height / 2, 920, 920);

        frameRate(240);

    }


    public void setSpeed(int speed) {

        delaySecond = 0;
        frameCount = 0;

        if (start) {

            startSpeed = 0;
            endSpeed = speed;

            startDegree =0;
            endDegree = speed*2;

            start = false;

        } else {

            startSpeed = endSpeed;
            endSpeed = speed;

            startDegree = endDegree;
            endDegree = speed*2;

        }

        text = startSpeed;
        degree = startDegree;
        arc = startDegree;


    }


    int i=1;
    public void draw() {

        imageMode(CENTER);

        image(img1, width / 2, height / 2, 920, 920);


        fill(120, 199, 184);
        //각도 증가 제어
        if (startDegree <= endDegree) {
            arc = degree + 2;
            arc(width / 2, height / 2, 910, 910, radians(130),radians((arc*2+90)/2+40));



        }

        //각도 감소 제어
        else if (startDegree > endDegree) {
            arc = degree - 2;
            arc(width / 2, height / 2, 910, 910, radians(130),radians((arc*2+90)/2+40));

        }


        //main image
        image(img2, width / 2, height / 2, 880, 880);



        //draw rect
        pushMatrix();
        translate(width / 2, height / 2);


        rotate(radians(degree));



        fill(183, 194, 199, 200);
        rect(-10, 0, 20, 440);
        popMatrix();


        //gradient image
        image(img3, width / 2, height / 2, 300, 300);


        //text
        pushMatrix();
        translate(width / 2, height / 2);
        textAlign(CENTER);

        fill(255, 255, 255);
        textSize(135);


        text(text, 0, 0);


        fill(255, 255, 255, 100);
        textSize(35);
        text("km/h", 0, 80);

        popMatrix();


        //텍스트 증가제어
        if (startSpeed <= endSpeed && text <= endSpeed - 1) {
            text = text+1 ;
        }

        //텍스트 감소제어
        else if (startSpeed > endSpeed && text >= endSpeed + 1) {
            text=text-1;
        }



        //각도 증가 제어
        if (startDegree <= endDegree && degree <= endDegree - 1) {
             degree = degree + 2;
            //controllPlusDegree(abs(endSpeed-startSpeed));


        }

        //각도 감소 제어
        else if (startDegree > endDegree && degree >= endDegree + 1 ) {
             degree = degree - 2;
            //controllMinusDegree(abs(endSpeed-startSpeed));
        }




        if(frameCount > abs(abs(endSpeed-startSpeed)-30)){
                  delaySecond = delaySecond + 1;
                  delay(delaySecond);
        }




    }



}