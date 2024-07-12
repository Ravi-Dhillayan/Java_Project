package studentApp;
import java.util.*;



class stack {
    int i = 0, f = -1, n;
    int a[];

    public stack() {
        System.out.println("What size do you want Stack to be : ");
        Scanner o = new Scanner(System.in);
        n = o.nextInt();
        a = new int[n]; // Initialize the array with size 'n'
    }

    void put() {
        Scanner o = new Scanner(System.in);
        if (i == n) {
            System.out.println("Stack is Overflow : ");
        } else {
            System.out.println("Enter the Stack Element : ");
            a[i] = o.nextInt();
            i++;
        }
    }

    void get() {
        if (i == -1) {
            System.out.println("Stack is Underflow : ");
        } else {
            System.out.println("One Stack Element was removed : ");
            i--;
        }
    }

    void dis() {
        if (i == -1) {
            System.out.println("Stack is Empty : ");
        } else {
            System.out.println("Printed Stack Element : ");
            for (int j = 0; j < i; j++) {
                System.out.println(a[j]);
            }
        }
    }
}

public class Staack {
    public static void main(String[] args) {
        stack ob = new stack();
        int user_input;
        boolean B = true;
        Scanner o = new Scanner(System.in);
        System.out.println("What do you want to do in Stack : ");
        while (B == true) {
            System.out.println("1st Put Element is Statck\n2nd Get Element is Stack\n"
                    + "3rd Display Element of Stack\n4 Exit the Program : ");
            user_input = o.nextInt();
            switch (user_input) {
                case 1:
                    ob.put();
                    break;
                case 2:
                    ob.get();
                    break;
                case 3:
                    ob.dis();
                    break;
                case 4:
                    B = false;
                    break;
                default:
                    System.out.println("Wrong Input!!! Please Enter a Valid Input : ");
            }
        }
    }
}
