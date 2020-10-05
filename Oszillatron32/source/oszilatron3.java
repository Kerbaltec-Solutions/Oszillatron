import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.sound.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class oszilatron3 extends PApplet {


  
BufferedReader reader;
int vib=0;
int dub1=0;
int dub2=0;
int dub3=0;
int dub4=0;
int keyp=0;
int vibon=0;
int vibdiv=5;
int x1=0;
int y1=0;
int x2=0;
int y2=0;
int x3=0;
int y3=0;
int x4=0;
int y4=0;
int min=250;
int max=1050;
int w;
int rec = 0;
int play = 0;
int pos = 0;
float pamp = 0;
float bamp = 0;
float damp = 0;
float [] recf = new float[1000000];
float [] reca = new float[1000000];
float [] recc = new float[1000000];
float [] recd = new float[1000000];
String line;
float[] note;
SawOsc sig0a = new SawOsc(this);
SinOsc sig0b = new SinOsc(this);
SawOsc sig1a = new SawOsc(this);
SinOsc sig1b = new SinOsc(this);
SawOsc sig2a = new SawOsc(this);
SinOsc sig2b = new SinOsc(this);
SawOsc sig3a = new SawOsc(this);
SinOsc sig3b = new SinOsc(this);
SawOsc sig4a = new SawOsc(this);
SinOsc sig4b = new SinOsc(this);
SawOsc sigva = new SawOsc(this);
SinOsc sigvb = new SinOsc(this);
SawOsc sigra = new SawOsc(this);
SinOsc sigrb = new SinOsc(this);
SinOsc druma = new SinOsc(this);
SinOsc drumb = new SinOsc(this);
PinkNoise pnoise = new PinkNoise(this);
BrownNoise bnoise = new BrownNoise(this);

public void settings(){
  w=displayWidth-50;
  size(w,600);
}

public void setup(){
  frameRate(100);
  reader = createReader("frequencies.txt");
  try{
    line = reader.readLine();
  } catch (IOException e) {
    e.printStackTrace();
    exit();
  }
  note=PApplet.parseFloat(split(line,' '));
  min=round(note[0]);
  max=round(note[1]);
  //
  println(min);
  println(max);
  println((max-min)*2);
  background(0);
  textSize(12);
  
  while (note[1] >= 0){
    try{
      line = reader.readLine();
    } catch (IOException e) {
      e.printStackTrace();
      exit();
    }
    println(line);
    println(PApplet.parseInt(split(line,' ')));
    note=PApplet.parseFloat(split(line,' '));
    stroke(note[1]);
    line(map(note[0], min, max, 0, width),0,map(note[0], min, max, 0, width),500);
  }
  stroke(255);
  line(0,500,width,500);
  fill(0);
  rect(0,500,70,20);
  rect(70,500,100,20);
  rect(170,500,100,20);
  rect(270,500,100,20);
  rect(370,500,100,20);
  rect(470,500,150,20);
  rect(620,500,20,20);
  rect(640,500,20,20);
}

public void draw() {
  float amplitude = map(mouseY, 0, height, 0.5f, -0.1f);
  if (amplitude<0){amplitude=0;}
  float frequency = map(mouseX, 0, width, min, max);
  sig0a.play(frequency, amplitude/20);
  sig0b.play(frequency, amplitude);
  if (keyPressed == true & keyp==0){
    if (key=='1'){
      if (dub1==0){
        dub1=1;
      }else{
        dub1=0;
      }
      if(dub1==1){
        sig1a.play(frequency, amplitude/20);
        sig1b.play(frequency, amplitude);
        x1=mouseX;
        y1=mouseY;
        stroke(255,0,0);
        fill(255,0,0);
        ellipse(x1,y1,5,5);
        text("D-1: " + round(frequency) + "|" + round(amplitude*200),74,515);
      }else{
        sig1a.stop();
        sig1b.stop();
        stroke(0);
        fill(0);
        ellipse(x1,y1,7,7);
        stroke(255);
        rect(70,500,100,20);
      }
    }
    if (key=='2'){
      if (dub2==0){
        dub2=1;
      }else{
        dub2=0;
      }
      if(dub2==1){
        sig2a.play(frequency, amplitude/20);
        sig2b.play(frequency, amplitude);
        x2=mouseX;
        y2=mouseY;
        stroke(0,0,255);
        fill(0,0,255);
        ellipse(x2,y2,5,5);
        text("D-2: " + round(frequency) + "|" + round(amplitude*200),174,515);
      }else{
        sig2a.stop();
        sig2b.stop();
        stroke(0);
        fill(0);
        ellipse(x2,y2,7,7);
        stroke(255);
        rect(170,500,100,20);
      }
    }
    if (key=='3'){
      if (dub3==0){
        dub3=1;
      }else{
        dub3=0;
      }
      if(dub3==1){
        sig3a.play(frequency, amplitude/20);
        sig3b.play(frequency, amplitude);
        x3=mouseX;
        y3=mouseY;
        stroke(0,255,0);
        fill(0,255,0);
        ellipse(x3,y3,5,5);
        text("D-3: " + round(frequency) + "|" + round(amplitude*200),274,515);
      }else{
        sig3a.stop();
        sig3b.stop();
        stroke(0);
        fill(0);
        ellipse(x3,y3,7,7);
        stroke(255);
        rect(270,500,100,20);
      }
    }
    if (key=='4'){
      if (dub4==0){
        dub4=1;
      }else{
        dub4=0;
      }
      if(dub4==1){
        sig4a.play(frequency, amplitude/20);
        sig4b.play(frequency, amplitude);
        x4=mouseX;
        y4=mouseY;
        stroke(255,255,0);
        fill(255,255,0);
        ellipse(x4,y4,5,5);
        text("D-4: " + round(frequency) + "|" + round(amplitude*200),374,515);
      }else{
        sig4a.stop();
        sig4b.stop();
        stroke(0);
        fill(0);
        ellipse(x4,y4,7,7);
        stroke(255);
        rect(370,500,100,20);
      }
    }
    if (key=='m'){
      stroke(255);
      fill(0);
      ellipse(mouseX,mouseY,7,7);
    }
    if (key=='v'){
      if (vib==0){
        vib=1;
      }else{
        vib=0;
      }
    }
    if (key=='s'){
      vibdiv=vibdiv-1;
      stroke(255);
      fill(0);
      rect(0,500,70,20);
      fill(255);
      text("vibrato " + vibdiv,4,515);
    }
    if (key=='f'){
      vibdiv=vibdiv+1;
      stroke(255);
      fill(0);
      rect(0,500,70,20);
      fill(255);
      text("vibrato " + vibdiv,4,515);
    }
    if (key=='d'){
      damp=1;
    }
    if (key=='r'){
      if (rec == 0 & play == 0){
        pos=0;
        while (recf[pos] > 0){
          stroke(0);
          fill(0);
          if(reca[pos] > 0.001f){
            ellipse(map(recf[pos], min, max, 0, width),map(reca[pos], 0.5f, -0.1f, 0, 600),3,3);
          }
          pos=pos+1;
        }
        recf = new float[1000000];
        reca = new float[1000000];
        pos=0;
        rec=1;
      }else{
        rec=0;
        stroke(255);
        fill(0);
        rect(470,500,150,20);
      }
    }
    if (key=='p'){
      if (play == 0 & rec == 0){
        play=1;
      }else{
        play=0;
        sigra.stop();
        sigrb.stop();
        stroke(255);
        fill(0);
        rect(470,500,150,20);
      }
    }
    if (key=='c'){
      pamp=1;
      bamp=1;
    }
    
    keyp=1;
  }
  if (keyPressed == false & keyp==1){
    keyp=0;
  }
  if(vib==1){
    sigva.play(frequency+vibdiv, amplitude/20);
    sigvb.play(frequency+vibdiv, amplitude);
    if(vibon==0){
      fill(255);
      text("vibrato " + vibdiv,4,515);
      vibon=1;
    }
  }else{
    sigva.stop();
    sigvb.stop();
    if(vibon==1){
      stroke(255);
      fill(0);
      rect(0,500,70,20);
      vibon=0;
    }
  }
  if(rec == 1){
    recf[pos] = frequency;
    reca[pos] = amplitude;
    if(pamp==1){
      recc[pos] = 1;
    }else{
      recc[pos] = 0;
    }
    if(damp==1){
      recd[pos] = 1;
    }else{
      recd[pos] = 0;
    }
    stroke(255);
    fill(0);
    rect(470,500,150,20);
    fill(255);
    if(reca[pos] > 0.001f){
      ellipse(map(recf[pos], min, max, 0, width),map(reca[pos], 0.5f, -0.1f, 0, 600),1,1);
    }
    text("REC:  " + pos + "|" + (1000000-pos),474,515);
    pos = pos+1;
  }
  if(play == 1){
    sigra.play(recf[pos],reca[pos]/20);
    sigrb.play(recf[pos],reca[pos]);
    if(recc[pos]==1){
      pamp = 1;
      bamp = 1;
    }
    if(recd[pos]==1){
      damp = 1;
    }
    stroke(255);
    fill(0);
    rect(470,500,150,20);
    fill(255);
    text("PLAY: " + pos,474,515);
    if(recf[pos]==0){
      pos=0;
    }else{
      pos = pos+1;
    }
  }
  if (pamp != 0){
    pnoise.play(pamp);
    bnoise.play(bamp/5);
    if (pamp<0.05f){
      pnoise.stop();
      bnoise.stop();
      pamp=0;
      bamp=0;
      stroke(255);
      fill(0);
      rect(620,500,20,20);
    }else{
      pamp=pamp/1.02f;
      bamp=bamp/1.05f;
      stroke(255);
      fill(pamp*255);
      rect(620,500,20,20);
    }
  }
  if (damp!=0){
    druma.play(80,damp);
    drumb.play(80,damp);
    if (damp<0.001f){
      druma.stop();
      drumb.stop();
      damp=0;
      stroke(255);
      fill(0);
      rect(620,500,20,20);
    }else{
      damp=damp/1.1f;
      stroke(255);
      fill(damp*255);
      rect(640,500,20,20);
    }
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "oszilatron3" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
