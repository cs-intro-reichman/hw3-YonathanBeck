// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if(x2 < 0){
			return minus(x1, x2);
		}
		int answer = 0;
        for(int i = 0;i < x1;i++){
            answer++;
        }
        for(int i = 0;i < x2;i++){
            answer++;
        }
		return answer;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if(x2 < 0){
			return plus(x1, x2);
		}
		int answer = 0;
        for(int i = 0;i < x1;i++){
            answer++;
        }
        for(int i = 0;i < x2;i++){
            answer--;
        }
		return answer;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int answer = 0;
        if(x2 < 0){
			return -times(x1, -x2);
		}
		for(int i = 0; i < x2; i++){
            answer = plus(answer, x1);
        }
		return answer;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int answer = 1;
		if(n == 0){
			return 1;
		}
        for(int i = 0; i < n ; i++){
            answer = times(answer, x);
        }
		return answer;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		if(x2 == 0){
			return 0;
		}
		int answer = 1;
        int count = 0;
		if(x1 < 0 && x2 > 0){
			return -div(-x1, x2);
		}
		if(x1 < 0 && x2 < 0){
			return div(-x1, -x2);
		}
		if(x1 > 0 && x2 < 0){
			return -div(x1, -x2);
		}
        while(times(answer, x2) < x1){
            answer++;
            count = plus(count, x2);
        }
		if(times(answer, x2) == x1){
            return answer;
        }
        else{
            return --answer;
        }
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		if(x2 == 0){
			return 0;
		}
		return minus(x1, times(div(x1, x2), x2));
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
        if(x <= 0){
			return 0;
		}
		for(int i = 0; i < x; i++){
            if(times(i, i) >= x){
                return i;
            }
        }
		return 0;
	}	  	  
}