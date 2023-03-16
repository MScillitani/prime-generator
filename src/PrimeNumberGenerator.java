import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;

public class PrimeNumberGenerator {

    public static void generatePrimes() {
        SecureRandom random = new SecureRandom();
        int count = 0;
        BigInteger prime; // declaring a BigInt (we're generating #s that are too large for a reg int or long)

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("primes.txt"))) {
            while (count < 100) { // remember that count is initially set to 0
                prime = BigInteger.probablePrime(120, random); // bit length = 120 because (120/log2(10) = 36)
                writer.write(prime + "\n"); // writes prime to .txt file
                count++;
            } // console success or failure message
            System.out.println("Successfully wrote " + count + " primes to primes.txt.");
        } catch (IOException e) {
            System.out.println("Something went wrong.");
            e.printStackTrace();
        }
    }
}
