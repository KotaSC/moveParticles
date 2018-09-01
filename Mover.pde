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

	void update(){

		PVector mouse = new PVector(mouseX, mouseY);
		PVector dir   = PVector.sub(mouse, location);  

		dir.normalize();
		dir.mult(0.5);
		acceleration = dir;  

		velocity.add(acceleration);
		velocity.limit(topspeed);
		location.add(velocity);
	}

	void display(){

		strokeWeight(2);
		stroke(0, 100 , 200);
		point(location.x, location.y);
	}
}