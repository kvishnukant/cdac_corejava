package exc;

import java.util.Scanner;

import cust_exc.SpeedOutOfRangeException;

public class TestCustomeException {
	// speed ranges
	public static final int MIN_SPEED = 40;
	public static final int MAX_SPEED = 140;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// attach scanner for accepting speed of vehicle
		Scanner sc = new Scanner(System.in);
		// prompt user
		System.out.println("Enter current speed");
		// method should not handle excs --- main should handle it
		try {
			checkSpeed(sc.nextInt());
			System.out.println("end of main-try");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("in main's finally....");
		}
		System.out.println("over....");

	}

	private static void checkSpeed(int speed) throws Exception {
		try {
		if (speed < MIN_SPEED)
			throw new SpeedOutOfRangeException("U r driving too slow...@"
					+ speed);
		if (speed > MAX_SPEED)
			throw new SpeedOutOfRangeException("U r driving too fast FATAL @"
					+ speed);
		System.out.println("Speed within range.....");
		} finally {
			System.out.println("in meth's finally ");
		}
		System.out.println("method end");
	}

}
