import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author Vishal Doshi
 *
 */
public class ReservoirSamplingJava {
	static int[] reservoir;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "input.txt";
		// Uncomment to generate a new file
		generateFile(path, 10000, 1000); // (path, number of integers in file,
											// maximum value of the randomly
											// generated integer
		reservoirSampling(path);

	}

	public static void reservoirSampling(String path) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Please provide the size of reservoir:");
			int size = Integer.parseInt(br.readLine());
			// int size = 10;
			reservoir = new int[size];

			Scanner sc = new Scanner(new File(path));
			int index = 0;
			System.out.println("=======Reservoir in the start =======");
			for (index = 0; index < size; index++) {
				reservoir[index] = Integer.parseInt(sc.next());
				System.out.print(reservoir[index] + "\t");
			}
			System.out.println("\nindex in begining: " + index);
			while (sc.hasNext()) {
				int randomIndex = (int) (Math.random() * index);

				int value = Integer.parseInt(sc.next());
				if (randomIndex < size) {
					reservoir[randomIndex] = value;

				}
				index++;
			}
			System.out.println("index in end:" + index);
			System.out.println("=======Reservoir in the end =======");
			for (index = 0; index < size; index++) {
				System.out.print(reservoir[index] + "\t");
			}
			sc.close();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//Method to generate the input file 
	public static String generateFile(String path, int number, int range) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(path));
			for (int i = 0; i < number; i++) {
				int numberToWrite = (int) (Math.random() * range);
				bw.write(numberToWrite + " ");
			}
			System.out.println("File created:" + path);
			bw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;

	}
}
