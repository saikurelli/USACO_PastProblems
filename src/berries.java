import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class berries {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("berries" + ".in"));
		PrintWriter out = new PrintWriter("berries.out");
		int n = sc.nextInt();
		int k = sc.nextInt();
		int [] berries = new int[n];
		for(int i = 0;i< n;i++){
			berries[i]=sc.nextInt();
		}
		Arrays.sort(berries);
		ArrayList<Integer> bessie = new ArrayList<>();
		ArrayList<Integer> elsie = new ArrayList<>();
		for(int i = n - k; i < n;i++){
			if(i< (n-k) + (k/2)){
				bessie.add(berries[i]);
			}else{
				elsie.add(berries[i]);
			}
		}
		System.out.println(bessie);
		System.out.println(elsie);
		int small = bessie.get(0);
		int sum =k;
		loop:
		while (sum>=k){
			int tryval = small+1;
			sum = 0;
			for(int i = k; i>0; i--){
				System.out.println(sum + " " + tryval);
				if(i> k/2){
					sum += elsie.get((i-k/2)-1)/tryval;
					System.out.println();
				}else{
					sum+= (bessie.get(i-1)/ tryval);
				}
				if(sum>=k){
					break loop;
				}
			}
		}
		//assumes all the buckets same size and finds that value
		// need to see if improving all last values and then one of bessie will work, etc


	}
}