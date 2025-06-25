import java.util.Scanner;

public class SimpleChatBot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ChatBot: Hello! Welcome to Online Shop Support. How can I help you?");

        while (true) {
            System.out.print("You: ");
            String input = scanner.nextLine().toLowerCase();

            if (input.contains("order status")) {
                System.out.println("ChatBot: You can check your order status by logging into your account.");
            } else if (input.contains("return")) {
                System.out.println("ChatBot: You can return an item within 7 days of delivery.");
            } else if (input.contains("refund")) {
                System.out.println("ChatBot: Refunds are processed within 5-7 business days after approval.");
            } else if (input.contains("cancel order")) {
                System.out.println("ChatBot: Orders can be cancelled before they are shipped.");
            } else if (input.contains("exit") || input.contains("bye")) {
                System.out.println("ChatBot: Thank you for visiting! Have a great day!");
                break;
            } else {
                System.out.println("ChatBot: I'm sorry, I didn't understand that. Can you please rephrase?");
            }
        }

        scanner.close();
    }
}
