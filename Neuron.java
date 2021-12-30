
public class Neuron {

	private double[] weights;
	private double currentNet;
	private int currentAct;
	
	
	public Neuron(double[] weights, int activater) {
		this.weights = weights;
		this.currentAct = activater;
	}
	
	public double calcNet(int[] inputs) {
		double sum = 0;
		for(int i = 0; i < weights.length; i ++) {
			sum += inputs[i]*weights[i];
		}
		this.currentNet = sum;
		return sum;
	}
	
	public int calcAct(int[] inputs) {
		double net = calcNet(inputs);
		if(net < 0) {
			this.currentAct = 0;
			return 0;
		} else {
			this.currentAct = 1;
			return 1;
		}
	}
	
	public int getAct() {
		return this.currentAct;
	}
	
	
	

}
