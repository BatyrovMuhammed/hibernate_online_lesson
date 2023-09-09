package legendSoft;

import legendSoft.model.Client;
import legendSoft.service.ClientServiceImpl;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {

        ClientServiceImpl clientService = new ClientServiceImpl();

        Scanner scanner = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("""
                    press r to register
                    press f to show all client
                    press l to log in
                    """);
            char operation = sc.next().charAt(0);
            switch (operation){
                case 'r' ->{
                    System.out.println("first name: ");
                    String firstName = scanner.nextLine();
                    System.out.println("last name: ");
                    String lastName = scanner.nextLine();
                    System.out.println("phoneNumber: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.println("email: ");
                    String email = scanner.nextLine();
                    System.out.println("password: ");
                    String password = scanner.nextLine();
                    clientService.register(new Client(firstName,lastName,phoneNumber,email,password));
                }
                case 'f' -> clientService.findAll().forEach(System.out::println);
                case 'l' -> {
                    System.out.println("email");
                    String email = scanner.nextLine();
                    System.out.println("password");
                    String password = scanner.nextLine();
                    try {
                        clientService.login(email, password);
                        System.out.println("SUCCESSFULLY!!!");

                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                default -> throw new IllegalStateException("you pressed wrong letter");
            }
        }

    }
}
