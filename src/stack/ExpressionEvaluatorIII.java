package stack;

import java.util.Stack;

public class ExpressionEvaluatorIII {
	public static int evaluate(String exp) {
		char[] tokens = exp.toCharArray();
		Stack<Integer> nums = new Stack<Integer>();
		Stack<Character> ops = new Stack<Character>();

		for (int i = 0; i < tokens.length; i++) {
			// Skip the whitespace
			if (tokens[i] == ' ')
				continue;
			// Push integer into the nums stack
			if (tokens[i] >= '0' && tokens[i] <= '9') {
				StringBuffer sb = new StringBuffer();
				while (i < tokens.length && tokens[i] >= '0'
						&& tokens[i] <= '9')
					sb.append(tokens[i++]);
				nums.push(Integer.parseInt(sb.toString()));
			} else if (tokens[i] == '(') {
				ops.push(tokens[i]);
			} else if (tokens[i] == ')') {
				while (ops.peek() != '(')
					nums.push(applyOp(ops.pop(), nums.pop(), nums.pop()));
				ops.pop();
			} else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*'
					|| tokens[i] == '/') {
				// While top of 'ops' has same or greater precedence to current
				// token, which is an operator. Apply operator on top of 'ops'
				// to top two elements in nums stack
				while (!ops.empty() && hasPrecedence(tokens[i], ops.peek())) {
					nums.push(applyOp(ops.pop(), nums.pop(), nums.pop()));
				}
				// Push current token to 'ops'.
				ops.push(tokens[i]);
			}
		}

		// Apply remaining ops to remaining nums
		while (!ops.empty()) {
			nums.push(applyOp(ops.pop(), nums.pop(), nums.pop()));
		}
		return nums.pop();
	}

	// Returns true if 'op2' has higher or same precedence as 'op1',
	// otherwise returns false.
	public static boolean hasPrecedence(char op1, char op2) {
		if (op2 == '(' || op2 == ')')
			return false;
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else
			return true;
	}

	// A utility method to apply an operator 'op' on operands 'a'
	// and 'b'. Return the result.
	public static int applyOp(char op, int b, int a) {
		switch (op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			if (b == 0) {
				throw new UnsupportedOperationException("Cannot divide by zero");
			}
			return a / b;
		}
		return 0;
	}

	// Driver method to test above methods
	public static void main(String[] args) {
		System.out.println(evaluate("10 + 2 * 6"));
		System.out.println(evaluate("100 * 2 + 12"));
		System.out.println(evaluate("100 * ( 2 + 12 )"));
		System.out.println(evaluate("100 * ( 2 + 12 ) / 14"));
	}
}
