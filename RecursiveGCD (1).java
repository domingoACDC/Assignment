/* Description: Computes the GCD of two non-negative integers using the
 *              recursive form of the Euclidean algorithm, and prints a
 *              full trace of every recursive call and every return.
 * Programmed by: <Leader: Joe Ronrex Magdaluyong Aring
 
MEMBERS: Dionzon Domingo
GIAN ANDREW LAURON
HERVIE LADUBA
ARJHIEY CATALAN> <BSIT> <B6> <DATA STRUCTURES AND ALGORITHM>
 
* Last Modified: <SEP 22, 2026>
 * Version: 1.0
 * [Acknowledgements: <list sources / Claude, if any>]
 */

import java.util.Scanner;

public class RecursiveGCD {

    // Recursive GCD with trace output
    public static long gcd(long a, long b, int depth) {
        String indent = "  ".repeat(depth);

        // ---- trace: entering call ----
        if (b != 0) {
            System.out.println(indent + "gcd(" + a + ", " + b + ")  ->  a % b = " + (a % b));
        } else {
            System.out.println(indent + "gcd(" + a + ", " + b + ")");
        }

        // ---- Base case ----
        if (b == 0) {
            System.out.println(indent + "Base case reached (b == 0). Returning " + a + ".");
            return a;
        }

        // ---- Recursive case + state change: gcd(a, b) -> gcd(b, a % b) ----
        long result = gcd(b, a % b, depth + 1);

        // ---- Unwinding / return phase ----
        System.out.println(indent + "gcd(" + a + ", " + b + ") returns " + result
                + " (from gcd(" + b + ", " + (a % b) + "))");
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first non-negative integer (a): ");
        long a = scanner.nextLong();
        System.out.print("Enter second non-negative integer (b): ");
        long b = scanner.nextLong();

        if (a == 0 && b == 0) {
            System.out.println("Both values cannot be zero. GCD is undefined.");
            return;
        }

        System.out.println("\n--- Recursion Trace ---");
        long result = gcd(a, b, 0);
        System.out.println("-----------------------");
        System.out.println("\nThe GCD of " + a + " and " + b + " is " + result);

        scanner.close();
    }
}
