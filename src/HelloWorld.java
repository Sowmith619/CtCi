
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = new Scanner(System.in).next();

		String str = s.toLowerCase().trim();
		System.out.println("s=" + str);
		if (str == "blue") {
			System.out.println("Correct - " + (str == "blue"));
		} else {
			System.out.println("Wrong -" + (str.equals("blue")));
		}

		System.out.println("Hello world!");
		Set<Integer> set = new HashSet<>();
		set.add(1);

		System.out.println(set.add(1));

		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.peek());
		// fibin
		// (a)recursion
		int n = 10;
		System.out.println("(a)Fibonacci Series recur:");
		for (int i = 0; i <= n; i++) {
			System.out.print("-" + fibin(i));
		}
		System.out.print("\nnth=" + fibin(n));
		// (b)using prev value
		System.out.println("\n(b)Fibonacci Series var:");
		System.out.print("\nnth=" + fibinIter(n));

		// (c)fibin memo top--> down
		n = 10;
		int[] memo = new int[n + 1];
		System.out.println("\n(c)Fibonacci Series Memo(top->down):");
		System.out.print(fibinMemo(n, memo) + ":");
		for (int k : memo)
			System.out.print("-" + k);
		// (d)fibin dp bottom-->up
		memo = new int[n + 1];
		System.out.println("\n(d)Fibonacci Series DP(bottom->up):");
		System.out.print(fibinMemo2(n, memo) + ":");
		for (int k : memo)
			System.out.print("-" + k);
		// n stairs
		n = 10;
		System.out.println("\nstairs:" + countWays(n) + ":");
		System.out.println("stairs:" + countWays_memo(n, new int[n + 1]) + ":");
		System.out.println("Stairs dp:" + countWays_dp(n));
		// print power of 2 from 1 throught n(inclusive)
		System.out.print("\n\npowerOf2:");
		powerOf2(16);
		Parentheses();
	}

	// (a)recursion:Time Complexity: T(n) = T(n-1) + T(n-2) which is exponential.
	// Runtime:O(2^N)
	// Extra Space: O(n) if we consider the function call stack size, otherwise
	// O(1).
	public static int fibin(int n) {
		if (n == 0 || n == 1)
			return n;
		return fibin(n - 1) + fibin(n - 2);
	}

	// (b)using prev value:Runtime:O(N) space=O(1)
	public static int fibinIter(int n) {
		if (n == 0 || n == 1)
			return n;
		int a = 0, b = 1, z = 0;
		System.out.print("-" + a + "-" + b);
		for (int i = 2; i <= n; i++) {
			z = a + b;
			a = b;
			b = z;
			System.out.print("-" + z);
		}
		return z;
	}

	// (c)fibin memo top--> down:Runtime: O(N) space=:O(N) = memoization (top→down)
	public static int fibinMemo(int n, int[] memo) {
		if (n == 0 || n == 1) {
			memo[n] = n;
			return n;
		}
		if (memo[n] == 0)
			memo[n] = fibinMemo(n - 1, memo) + fibinMemo(n - 2, memo);
		return memo[n];
	}

	// (d)fibin dp bottom-->upRuntime: O(N) space=:O(N) = DP (bottom→up)
	public static int fibinMemo2(int n, int[] memo) {
		if (n == 0 || n == 1)
			return n;
		memo[0] = 0;
		memo[1] = 1;
		for (int i = 2; i <= n; i++) {
			memo[i] = memo[i - 1] + memo[i - 2];
		}
		return memo[n];
	}

	// triple steps: n steps stairs, can hop either 1 step, 2 steps, or 3 steps at a
	// time.
	public static int countWays(int n) {
		if (n < 0)
			return 0;
		else if (n == 0 || n == 1)
			return 1;
		else
			return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
	}

	// triple steps: using memoization (top→down)
	public static int countWays_memo(int n, int[] memo) {
		if (n < 0)
			return 0;
		else if (n == 0 || n == 1)
			return 1;
		else if (memo[n] == 0)
			memo[n] = countWays_memo(n - 1, memo) + countWays_memo(n - 2, memo) + countWays_memo(n - 3, memo);
		return memo[n];
	}

	// DP (bottom→up)
	public static int countWays_dp(int n) {
		int[] dp = new int[n + 1];
		if (n < 0)
			return 0;
		else if (n == 0 || n == 1)
			return 1;
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++)
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		return dp[n];
	}

	// print power of 2 from 1 throught n(inclusive)
	public static int powerOf2(int n) {
		if (n < 1)
			return 0;
		else if (n == 1)
			return 1;
		else {
			int prev = powerOf2(n / 2);
			int curr = prev * 2;
			System.out.print(curr + "-");
			return curr;
		}
	}

	public static void Parentheses() {
		String str = "{{}}}";
		int negCount = 0, counter = 0;
		for (char c : str.toCharArray()) {
			if (c == '{')
				counter++;
			else if (c == '}' && counter == 0)
				negCount++;
			else if (c == '}')
				counter--;
		}
		// negCount+count = total number of bracket need for balancing the string
		System.out.println("\ncounter:" + counter + " close:" + negCount);
		System.out.println("Total unbalanced:" + (counter + negCount));
		checkParentheses();
		checkParentheses_order();
	}

	public static void checkParentheses() {
		String str = "Hello{}world}";
		int counter = 0;
		for (char c : str.toCharArray()) {
			if (c == '{')
				counter++;
			else if (c == '}')
				counter--;
			if (counter < 0)
				break;
		}
		if (counter == 0)
			System.out.println("checkParentheses: balanced");
		else
			System.out.println("checkParentheses: Not balanced");
	}

	public static void checkParentheses_order() {
		String str = "Hello{{}}";
		Stack<Character> stack = new Stack<>();
		for (char c : str.toCharArray()) {
			if (c == '{')
				stack.push('}');
			else if (c == '}') {
				if (stack.isEmpty() || stack.pop() != c) {
					System.out.println("checkParentheses_order: Not ordered");
					return;
				}
			}
		}
		if (stack.isEmpty())
			System.out.println("checkParentheses_order: Ordered");
		else
			System.out.println("checkParentheses_order: Not ordered");
	}

}
