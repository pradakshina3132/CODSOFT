import java.util.Scanner;

public class GradeCalculator {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

System.out.println("\n📚 Student Grade Calculator 📚");

System.out.print("Enter the number of subjects: ");
int subjects = sc.nextInt();
double[] marks = new double[subjects];

for (int i = 0; i < subjects; i++) {
while (true) {
System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
double score = sc.nextDouble();
if (score >= 0 && score <= 100) {
marks[i] = score;
break;
} else {
System.out.println("⚠️ Marks must be between 0 and 100.");
}
}
}

double total = 0;
for (double m : marks) {
total += m;
}

double average = total / subjects;
String grade;

if (average >= 90) {
grade = "A+";
} else if (average >= 80) {
grade = "A";
} else if (average >= 70) {
grade = "B";
} else if (average >= 60) {
grade = "C";
} else if (average >= 50) {
grade = "D";
} else {
grade = "F";
}

System.out.println("\n--- RESULT ---");
System.out.println("Total Marks: " + total + " / " + (subjects * 100));
System.out.printf("Average Percentage: %.2f%%\n", average);
System.out.println("Grade: " + grade);

sc.close();
}
}
