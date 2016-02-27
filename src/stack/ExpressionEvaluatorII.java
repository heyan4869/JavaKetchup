package stack;

import java.util.Stack;

public class ExpressionEvaluatorII {
	public static int evaluate(String exp) {
		int len = exp.length();
		if (exp == null || len == 0) {
			return 0;
		}
		Stack<Integer> stack = new Stack<Integer>();
		int num = 0;
		char sign = '+';
		for (int i = 0; i < len; i++) {
			if (Character.isDigit(exp.charAt(i))) {
				num = num * 10 + exp.charAt(i) - '0';
			}
			if ((!Character.isDigit(exp.charAt(i)) && ' ' != exp.charAt(i))
					|| i == len - 1) {
				if (sign == '-') {
					stack.push(-num);
				}
				if (sign == '+') {
					stack.push(num);
				}
				if (sign == '*') {
					stack.push(stack.pop() * num);
				}
				if (sign == '/') {
					stack.push(stack.pop() / num);
				}
				sign = exp.charAt(i);
				num = 0;
			}
		}

		int res = 0;
		for (int i : stack) {
			res += i;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
