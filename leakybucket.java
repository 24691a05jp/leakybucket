import java.util.Scanner;
public class leakybucket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bucketSize, outputRate, n, packet;
        System.out.print("Enter bucket size: ");
        bucketSize = sc.nextInt();
        System.out.print("Enter output rate: ");
        outputRate = sc.nextInt();
        System.out.print("Enter number of packets: ");
        n = sc.nextInt();
        int bucket = 0;
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter packet size " + i + ": ");
            packet = sc.nextInt();
            if (packet > bucketSize) {
                System.out.println("Packet is too large and discarded.");
            } 
            else if (bucket + packet > bucketSize) {
                System.out.println("Packet discarded due to bucket overflow.");
            } 
            else {
                bucket += packet;
                System.out.println("Packet accepted. Bucket = " + bucket);
            }
            int leaked = Math.min(bucket, outputRate);
            bucket -= leaked;
            System.out.println("Packets sent = " + leaked);
            System.out.println("Remaining in bucket = " + bucket);
            System.out.println();
        }
        sc.close();
    }
}
