import java.util.Arrays;
import java.util.Random;

//Class that handles generalized rules
public class RuleCalcs {
	static Random rnd = new Random();
	
	/*
	 * Divides the first number by the second number, rounding up.
	 * This is common enough for a full method to be practical.
	 */
	public static int divUp(int divident, int divisor) {
		return (int) Math.ceil(((double) divident)/((double) divisor));
	}
	
	/*
	 * Makes a standard 2d10 roll.
	 * 
	 * Input: { mod = the roll's modifier
	 * 			advan = the number of stacks of (dis)advantage }
	 * 
	 * Output:	int value of roll
	 * 
	 */
	public static int makeRoll(int mod, int advan) {
		//Result value of roll
		int roll = 0;
		
		if(advan == 0) { //If there is no (dis)advantage, just roll 2d10
			roll = rnd.nextInt(10) + rnd.nextInt(10) + 2;
		}
		else { //If there is (dis)advantage, roll multiple times and take highest/lowest two
			int[] rollArr = new int[Math.abs(advan) + 2];
			for(int i = 0; i < rollArr.length; i++) {
				rollArr[i] = rnd.nextInt(10) + 1;
			}
			Arrays.sort(rollArr);
			if(advan < 0) {
				roll = rollArr[0] + rollArr[1];
			}
			else{
				roll = rollArr[Math.abs(advan)] + rollArr[Math.abs(advan) + 1];
			}
		}
		assert(2 <= roll && roll <= 20);
		roll += mod;
		
		//Calculate crits
		if(roll == 20) {
			roll *= 2;
		}
		else if(roll == 2) {
			roll = divUp(roll, 2);
		}
		
		return roll;
	}
	
}
