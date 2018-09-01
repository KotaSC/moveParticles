Mover[] movers = new Mover[30000];

void setup(){

	fullScreen(P2D);
	blendMode(ADD);
	frameRate(30);
	background(0);

	for(int i = 0; i < movers.length; i++){

		movers[i] = new Mover();
	}
}

void draw(){

	background(0);

	for(int i = 0; i < movers.length; i++){

		movers[i].update();
		movers[i].display();
	}
}