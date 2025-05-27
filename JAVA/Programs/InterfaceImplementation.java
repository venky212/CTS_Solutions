package Programs;
interface Playable {
    void play();
}
class Guitar implements Playable {
    @Override
    public void play() {
        System.out.println("Strumming the guitar");
    }
}
class Piano implements Playable {
    @Override
    public void play() {
        System.out.println("Playing the piano");
    }
}
public class InterfaceImplementation {
public static void main(String[] args) {
		 Playable myGuitar = new Guitar();
	        Playable myPiano = new Piano();

	   
	        System.out.print("Guitar: ");
	        myGuitar.play();

	        System.out.print("Piano: ");
	        myPiano.play();

	}

}
