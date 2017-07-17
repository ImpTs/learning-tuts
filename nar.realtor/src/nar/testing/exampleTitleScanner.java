package nar.testing;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
public class exampleTitleScanner {
	private static Scanner scanner;
	static String mainNavURLList[] = new String[] {
		"https://www.nar.realtor/news-and-commentary",
		"https://www.nar.realtor/research-and-statistics",
		"https://www.nar.realtor/member-benefits"
	};
	public static void main(String[] args) {
		int listNumber = mainNavURLList.length;
		for (int t = 0; t < listNumber; t++) {
			internalTitleCheck(t);
		}
	}

	public static void internalTitleCheck(int t) {
			String url = mainNavURLList[t];
			InputStream response = null;
			try {
				response = new URL(url).openStream();
				scanner = new Scanner(response);
				String responseBody = scanner.useDelimiter("\\A").next();

				String output = responseBody.substring(responseBody.indexOf("<title>") + 7, responseBody.indexOf("</title>"));
				output = output.replaceAll("^\\s+", "");
				output = output.replaceAll("\\s+$", "");

				//indexOf with the plus and number means that the number if character will not be inclided in the output.
				System.out.println(output);
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				try {
					response.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
	}
}