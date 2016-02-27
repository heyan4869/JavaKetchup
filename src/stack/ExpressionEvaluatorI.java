package stack;

import java.util.Stack;

public class ExpressionEvaluatorI {
	public static int evaluate(String exp) {
		int len = exp.length(), sign = 1, result = 0;
		Stack<Integer> nums = new Stack<Integer>();
		for (int i = 0; i < len; i++) {
			if (Character.isDigit(exp.charAt(i))) {
				int sum = exp.charAt(i) - '0';
				while (i + 1 < len && Character.isDigit(exp.charAt(i + 1))) {
					sum = sum * 10 + exp.charAt(i + 1) - '0';
					i++;
				}
				result += sum * sign;
			} else if (exp.charAt(i) == '+') {
				sign = 1;
			} else if (exp.charAt(i) == '-') {
				sign = -1;
			} else if (exp.charAt(i) == '(') {
				nums.push(result);
				nums.push(sign);
				result = 0;
				sign = 1;
			} else if (exp.charAt(i) == ')') {
				result = result * nums.pop() + nums.pop();
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
