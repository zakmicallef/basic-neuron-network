import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		// BUILD NETWORK CLASS 
		double[][] weights = {
				{0.9,0.0,0.1,-0.7},
				{1.2,0.1,0.0,-0.2},
				{0.6,-0.7,0.2,0}
		};
		
		int[] state = {0,1,0};
		int[] inputs = {1, 0, 0, 0};
		
		//Create and array of neurons
		Neuron[] neurons = new Neuron[state.length];
		
		for(int i = 0; i < neurons.length; i ++) {
			neurons[i] = new Neuron(weights[i], state[i]);
		}
		
		int noChange = 0;
		do {
			// Fire a neuron at random
			Random r = new Random();
			int neuronToFire = r.nextInt(state.length);
			
			// Update
			int i = 1;
			for(Neuron n : neurons) {
				System.out.println("i: " + i);
				System.out.println("in' " + inputs[i]);
				System.out.println("Act " + n.getAct());
				inputs[i] = n.getAct();
				i ++;
			}
			
			double prevAct = neurons[neuronToFire].getAct();
			double newAct = neurons[neuronToFire].calcAct(inputs);
			
			// Has it changed
			// CHANGE THIS INTO AN ARRAY OF CHANGES
			if(prevAct != newAct) {
				noChange = 0;
			} else {
				noChange ++;
			}
		}while(noChange < (state.length)*6);
		
		//Output states
		outputFinalState(neurons);
	}
	
	public static void outputFinalState(Neuron[] n) {
		System.out.println("Current State is: ");
		for(int i=n.length - 1; i >= 0; i --) System.out.print(" #" + i + ": " + n[i].getAct() + " |"); // MAKE neuron toString
		System.out.println("");
	}

}
