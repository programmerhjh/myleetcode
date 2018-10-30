package myleetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

/**
 * 最小栈
 * @author acer
 *
 */
public class MinStack {
	
	int min = Integer.MAX_VALUE;
	private Stack<Integer> stack;
    public MinStack() {
    	stack = new Stack<Integer>();
    }
    
    public void push(int x) {
    	// 如果x比min还要小的话，就把min压入，x作为min的新值作为比对值，在压入x
    	// 否则只压入x
        if(x <= min){          
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }
    
    public void pop() {
        // 如果栈顶弹出值与min相等就把min改为栈顶第二次弹出值
        if(stack.pop() == min) min=stack.pop();
    }
    
    public int top() {
    	return stack.peek();
    }
    
    public int getMin() {
    	return min;
    }
    
    @Override
    public String toString() {
    	for (int i = 0; i < stack.size(); i++) {
    		System.out.println(stack.get(i));
		}
    	return super.toString();
    }
	
}
