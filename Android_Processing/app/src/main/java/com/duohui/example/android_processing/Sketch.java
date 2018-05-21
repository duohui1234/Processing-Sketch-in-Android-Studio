package com.duohui.example.android_processing;


import processing.core.PApplet;
import processing.core.PImage;


public class Sketch extends PApplet {

    PImage img1,img2,img3;
    int speed=0;
    float degree=0;




    public void settings()
    {

        fullScreen();
    }

    public void setup(){

        background(255,255,255);
        noStroke();
        img1 = loadImage("back.png");
        imageMode(CENTER);
        image(img1,width/2,height/2,920,920);

    }

    public void setSpeed(int speed){

        this.speed = speed;

    }

    public void setDegree(float degree){

        this.degree = degree;
    }



    public void draw(){


       fill(120,199,184);
        arc(width/2, height/2, 910, 910, radians(130),radians(degree+88));


        //main image
        img2 = loadImage("image.png");
        imageMode(CENTER);
        image(img2,width/2,height/2,880,880);


        //draw rect
        pushMatrix();
        translate(width/2,height/2);
        rotate(radians(degree));
        fill(183,194,199);
        rect(-10,0,20,440);
        popMatrix();


        //gradient image
        img3 = loadImage("gra_img.png");
        imageMode(CENTER);
        image(img3,width/2,height/2,300,300);


        //text
        pushMatrix();
        translate(width/2,height/2);
        textAlign(CENTER);

        fill(255,255,255);
        textSize(135);
        text(speed,0,0);

        fill(255,255,255,100);
        textSize(35);
        text("km/h",0,80);

        popMatrix();




    }

}