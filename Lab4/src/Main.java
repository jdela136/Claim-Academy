
public class Main {

	public static void main(String[] args) {
//		// Question 1
		AandB nums1 =  new AandB(2,3);
		System.out.println(nums1.sumLimit());
		AandB nums2 =  new AandB(8,3);
		System.out.println(nums2.sumLimit());
		AandB nums3 =  new AandB(8,1);
		System.out.println(nums3.sumLimit());
		
//		//	Question 2
		SquirrelPlay squirrel1 = new SquirrelPlay(70,false);
		System.out.println(squirrel1.squirrelPlay());
		SquirrelPlay squirrel2 = new SquirrelPlay(95,false);
		System.out.println(squirrel2.squirrelPlay());
		SquirrelPlay squirrel3 = new SquirrelPlay(95,true);
		System.out.println(squirrel3.squirrelPlay());
		
//		//	Question 3
		LotteryTicket ticket1 = new LotteryTicket(1, 2, 3);
		System.out.println(ticket1.greenTicket());
		LotteryTicket ticket2 = new LotteryTicket(2, 2, 2);
		System.out.println(ticket2.greenTicket());
		LotteryTicket ticket3 = new LotteryTicket(1, 1, 2);
		System.out.println(ticket3.greenTicket());
		
//		// Question 4
		XXFinder one = new XXFinder("abcxx");
		System.out.println(one.countXX());
		XXFinder two = new XXFinder("xxx");
		System.out.println(two.countXX());
		XXFinder three = new XXFinder("xxxx");
		System.out.println(three.countXX());
		
//		// Question 5
		StringRepeater string1 = new StringRepeater("Hi", 2);
		System.out.println(string1.stringTimes());
		StringRepeater string2 = new StringRepeater("Hi", 3);
		System.out.println(string2.stringTimes());
		StringRepeater string3 = new StringRepeater("Hi", 1);
		System.out.println(string3.stringTimes());
	}
}