
public class Main {
	
	Canvas canvas;
	
	public Main() throws InterruptedException {
		canvas = new Canvas();

		/*
		System.out.println("starting cords= "+canvas.bot.getX()+" "+canvas.bot.getY());	
		while(true) {
			for(int i=0;i<24;i++) {
				canvas.bot.rotate(Math.PI/12);
				canvas.bot.move(10);
				canvas.redraw();
				Thread.sleep(10);
			}
			System.out.println("ending cords= "+canvas.bot.getX()+" "+canvas.bot.getY());
		}
		*/
		
	
	}
	
	public static void main(String[] args) throws InterruptedException {
		new Main();
	}

}
