import processing.video.*;
Movie skibidi;
Movie sigma;
void setup() {
  size(500, 500);
  skibidi = new Movie(this, "/home/Mattia/Scrivania/Mattia/Java informatica/prova1/dop.mp4");
  sigma = new Movie(this, "/home/Mattia/Scrivania/Mattia/Java informatica/prova1/sigma.mp4");
  skibidi.play();
  skibidi.loop();
  
  sigma.play();
  sigma.loop();
  frameRate(24);
}
float oggettoX = random(30, 350), oggettoY = 20;
public static final int altezzaRett = 100;
public static final int larghezzaRett = 10;
int pX = 500/2;
void draw() {
  background(40);
  if(keyPressed){
    if(key == 'A' || key == 'a'){
      if(pX > 0)
        pX -=20;
    }
    if(key == 'D' || key == 'd'){
      if(pX < 500 - 100)
        pX +=20;
    }
  }
  sigma.read();
  image(sigma, pX, 400, 150,50);
  
  if(oggettoY > 250){
    oggettoY = 20;
    oggettoX = random(30, 350);
  }
  oggettoY += 7;
  skibidi.read();
  image(skibidi, oggettoX, oggettoY, 150,150);
  
}
