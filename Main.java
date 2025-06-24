import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED= "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_YELLOW = "\u001B[33m";
        
        String secretWord = "Sapo";
        int secretWordLenght = secretWord.length();
        
        Scanner scan = new Scanner(System.in);

        System.out.println("Bem-vindo(a) ao jogo Termo!");
        System.out.println("\nRegras:");
        System.out.println("1. Você deve digitar uma palavra de até " + secretWordLenght + " caracteres.");
        System.out.println("2. Se alguma letra da palavra digitada estiver amarela, significa você acertou a letra, mas ela está na posição errada.");
        System.out.println("3. Se a letra estiver vermelha, significa que ela não existe na palavra correta.");
        System.out.println("4. Se a letra estiver verde, quer dizer que você acertou a posição e a palavra.");
        System.out.println("5. Você possui " + secretWordLenght + " tentativas para acerta a palavra correta.");
        
        int attemps = 0;
        while(attemps < secretWordLenght) {
            
            System.out.print(ANSI_RESET + "\nDigite uma palavra: ");
            String userGuess = scan.next();
            int userGuessLenght = userGuess.length();
            
            if(!userGuess.matches("[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÔÕÖÚÇÑ]+")) {
                System.out.println("Digite uma palavra válida.");
                continue;
            }

            if (userGuessLenght > secretWordLenght || userGuessLenght < secretWordLenght) {
                System.out.println("\nA palavra deve conter até " + secretWordLenght + " caracteres");
                continue;
            }

            for(int i = 0; i < secretWordLenght; i++) {
                if(Character.toLowerCase(secretWord.charAt(i)) == Character.toLowerCase(userGuess.charAt(i))) {
                    System.out.print(ANSI_GREEN + userGuess.charAt(i));
                } else if (secretWord.toLowerCase().indexOf(Character.toLowerCase(userGuess.charAt(i))) != -1) {
                    System.out.print(ANSI_YELLOW + userGuess.charAt(i));
                } else {
                    System.out.print(ANSI_RED + userGuess.charAt(i));
                }
            }

            if (secretWord.equalsIgnoreCase(userGuess)) {
                System.out.println(ANSI_RESET + "\n\nVocê ganhou!");
                break;
            }
            
            attemps++;
        }
        
        if(attemps == 4) {
            System.out.println(ANSI_RESET + "\n\nVocê perdeu :(, a palvra correta era " + secretWord);
        }
    }
}