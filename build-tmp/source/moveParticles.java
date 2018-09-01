import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class moveParticles extends PApplet {

Mover[] movers = new Mover[30000];

public void setup(){

	
	blendMode(ADD);
	frameRate(30);
	//noCursor();
	background(0);

	for(int i = 0; i < movers.length; i++){

		movers[i] = new Mover();
	}
}

public void draw(){

	background(0);

	for(int i = 0; i < movers.length; i++){

		movers[i].update();
		movers[i].display();
	}
}
class Mover{

	PVector location;
	PVector velocity;
	PVector acceleration;

	float topspeed;

	Mover(){

		location = new PVector(random(width), random(height));
		velocity = new PVector(0, 0);
		topspeed = 20;
	}

	public void update(){

		PVector mouse = new PVector(mouseX, mouseY);
		PVector dir = PVector.sub(mouse, location);    // \u73fe\u5728\u5730\u304b\u3089\u30de\u30a6\u30b9\u306e\u65b9\u5411\u3092\u6307\u3059\u30d9\u30af\u30c8\u30ebz

		dir.normalize();
		dir.mult(0.5f);
		acceleration = dir;   // \u30de\u30a6\u30b9\u306e\u65b9\u5411\u3078\u5411\u304b\u3046\u52a0\u901f\u5ea6

		velocity.add(acceleration);
		velocity.limit(topspeed);
		location.add(velocity);
	}

	public void display(){

		strokeWeight(2);
		//stroke(random(255), random(255), random(255));
		stroke(0, 100 , 200);
		point(location.x, location.y);
	}
}
  public void settings() { 	fullScreen(P2D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "moveParticles" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
