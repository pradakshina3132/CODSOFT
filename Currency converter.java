
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.JSONObject;

public class CurrencyConverter {
private static final String API_URL = "https://api.exchangerate.host/convert";

public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

try {
System.out.println("💱 Currency Converter 💱");

// Base Currency
System.out.print("Enter base currency (e.g., USD, EUR, INR): ");
String baseCurrency = sc.next().toUpperCase();

// Target Currency
System.out.print("Enter target currency (e.g., USD, EUR, INR): ");
String targetCurrency = sc.next().toUpperCase();

// Amount
System.out.print("Enter amount to convert: ");
double amount = sc.nextDouble();

// Build API URL
String urlStr = API_URL + "?from=" + baseCurrency + "&to=" + targetCurrency + "&amount=" + amount;

// Send GET request
URL url = new URL(urlStr);
HttpURLConnection conn = (HttpURLConnection) url.openConnection();
conn.setRequestMethod("GET");

BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
StringBuilder response = new StringBuilder();
String line;

while ((line = br.readLine()) != null) {
response.append(line);
}
br.close();

// Parse JSON response
JSONObject json = new JSONObject(response.toString());
double result = json.getDouble("result");

// Display Result
System.out.println("\n--- RESULT ---");
System.out.println(amount + " " + baseCurrency + " = " + result + " " + targetCurrency);

} catch (Exception e) {
System.out.println("⚠️ Error: " + e.getMessage());
}

sc.close();
}
}
