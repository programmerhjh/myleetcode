package myleetcode;

import java.util.Stack;


/**
 * 两数相加
 * @author acer
 *
 */
public class TheTwoFiguresTogether {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuffer sb = new StringBuffer();
        while(l1 != null){
            String str = "" + l1.val;
            sb.append(str);
            l1 = l1.next;
        }
        
        String num1 = sb.reverse().toString();
        sb.delete(0,sb.length());
        while(l2 != null){
            String str = "" + l2.val;
            sb.append(str);
            l2 = l2.next;
        }
        String num2 = sb.reverse().toString();
        String strResult = add(num1,num2);
        sb.delete(0,sb.length());
        strResult = sb.append(strResult).reverse().toString();
        String[] strings = strResult.split("");
        ListNode ln = new ListNode(0);
        ListNode temp = new ListNode(0);
        for(int i=0;i<strings.length-1;i++){
            if(i == 0){
                temp.val = Integer.parseInt(strings[i]);
                temp.next = new ListNode(Integer.parseInt(strings[i+1])); 
                ln = temp;
            } else {
                temp.next = new ListNode(Integer.parseInt(strings[i+1])); 
            }
            temp = temp.next;
        }
        if(strings.length == 1){
            ln.val = Integer.parseInt(strings[0]);
        }
        return ln;
    }
    
    public static Stack stringToStack(String str)
    {
        Stack stack=new Stack();
        for(int i=0; i<str.length(); i++)
        {
            char c=str.charAt(i);
            if(c>='0' && c<='9')
                stack.push(Integer.valueOf(String.valueOf(c)));
            else
                continue;
        }
        return stack;
    }
 
    public static String add(String a, String b)
    {
        Stack stackA=stringToStack(a); 
        Stack stackB=stringToStack(b);
        Stack stackSum=new Stack();   
        int tempSum;  
        boolean isCarry=false;  
 
        while(!stackA.isEmpty() && !stackB.isEmpty())
        {
            tempSum=(Integer)stackA.pop()+(Integer)stackB.pop();
            
            if(isCarry)
            {
                tempSum++;
                isCarry=false;
            }
            
            if(tempSum>=10)
            {
                tempSum-=10;
                stackSum.push(tempSum);
                isCarry=true;
            }
            else
            {
                stackSum.push(tempSum);
            }
        }

        Stack stackTemp=!stackA.isEmpty()?stackA:stackB;
        while(!stackTemp.isEmpty())
        {

            if(isCarry)
            {
                int end= (Integer)stackTemp.pop(); 
                ++end;
                if(end>=10)    
                {
                    end-=10;
                    stackSum.push(end);
                }
                else    
                {
                    stackSum.push(end);
                    isCarry=false;
                }
            }
            
            else
            {
                stackSum.push(stackTemp.pop());
            }
        }
        
        if(isCarry){
            stackSum.push(1);        
        }
    
        String result=new String();
        while(!stackSum.isEmpty())
        {
            result=result.concat(stackSum.pop().toString());
        }
        return result;
    }
	
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
