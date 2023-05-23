import java.lang.reflect.Array;

public class Debug {
    public static void main(String[] args) {

        int array[] = new int[]{1,2,3,4,5,};

        System.out.println(avgOfIntArr(array));

    //introducing null exception by passing a null array into a method.

        //int nullArray[] = null; //before fix
        int nullArray[] = {1,2}; //after fix

        //System.out.println(avgOfIntArr(nullArray));


    // introducing arrayoutofbounds exception

        //System.out.println(Array.get(array,5)); //before fix
        //System.out.println(Array.get(array,4)); //after fix



    }

    static double avgOfIntArr(int intArray[]){
        double sum = 0;
        double arraySize = (intArray.length);
        for(int num : intArray){
            //introducing logic error

            //sum =+ num; //logical error that caused no syntax errors.
             sum += num; //correct initial way / after "fix"

        }

        return sum/arraySize;

    }

    /*Notes:
        First run issue: I'm only getting the sum. I forgot to add the total number of elements found in the array
            (now created and called arraySize) to divide the sum.
        Second run issue: I got an avg of 3.75 because I made arraySize intArray.length-1. (was thinking about iteration I think)

        Nullpointer error: I introduced the error on line 12 where I passed a null array to the method. I put a breakpoint at the same line
            and used the debugger to step through the code. After the method was called it stepped into the method and immediatly
            showed the error "intArray.length = java.lang.NullPointerException", pinpointing where the issue lies. I fixed it by adding elements so it can
            properly execute the method.

        ArrayOutOfBounds error: I introduced the error by calling the .get method for the array, but calling an element that I knew didn't exist.
            Using the debugger with a breakpoint on line 20, stepped into the code  until I came across this error:
            "Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException at java.base/java.lang.reflect.Array.get(Native Method) at Debug.main(Debug.java:20)"
            This let me know that line 20 was where the error occured and that it was the method .get that caused it on that line.
            I fixed it by calling the index that I knew existed in the array.

        Logic error: I introduced a logic error by changing the '+=' in my avgOfIntArr method to '=+'. When run, it returned 1.0 instead of the expected 3.0.
            I placed a break on line 8 where I stepped through the code and followed the sum variable and noted how the sum variable never compounded, rather it only
            changed to be equal to the current element. By the time the code finished, the sum variable was 5, and was divided by 5 which output 1. I saw that it was because
            I when the += changed to =+ it only assigned rather than added to. The fix for this is to change it back to +=.
    */
}
