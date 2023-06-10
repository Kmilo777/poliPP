import java.util.Scanner;

public class EnglishTimeTrial {
    private static final int NUM_PLAYERS = 3;
    private static final int NUM_QUESTIONS = 10;
    private static final int QUESTION_TIME_LIMIT = 10;

    private String[] players;
    private int[] scores;
    private String[] categories;
    private String[][] questions;
    private String[][] answers;

    public EnglishTimeTrial() {
        players = new String[NUM_PLAYERS];
        scores = new int[NUM_PLAYERS];
        categories = new String[] {"animales", "frutas", "prendas de vestir", "partes del cuerpo", "emociones", "partes de la casa"};
        questions = new String[NUM_QUESTIONS][NUM_PLAYERS];
        answers = new String[NUM_QUESTIONS][NUM_PLAYERS];
    }

    public void startGame() {
        initializePlayers();
        initializeQuestions();
        playGame();
        showResults();
    }

    private void initializePlayers() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < NUM_PLAYERS; i++) {
            System.out.print("Ingrese el nombre del jugador " + (i + 1) + ": ");
            players[i] = scanner.nextLine();
        }
    }

    private void initializeQuestions() {
        for (int i = 0; i < NUM_QUESTIONS; i++) {
            System.out.println("Categorías disponibles:");
            for (int j = 0; j < categories.length; j++) {
                System.out.println((j + 1) + ". " + categories[j]);
            }
            System.out.print("Seleccione la categoría para la pregunta " + (i + 1) + ": ");
            Scanner scanner = new Scanner(System.in);
            int categoryIndex = scanner.nextInt() - 1;
            scanner.nextLine();

            System.out.print("Ingrese la pregunta: ");
            questions[i][0] = scanner.nextLine();

            System.out.println("Respuestas para " + players[0] + ":");
            answers[i][0] = scanner.nextLine();

            System.out.println("Respuestas para " + players[1] + ":");
            answers[i][1] = scanner.nextLine();

            System.out.println("Respuestas para " + players[2] + ":");
            answers[i][2] = scanner.nextLine();
        }
    }

    private void playGame() {
        for (int i = 0; i < NUM_QUESTIONS; i++) {
            System.out.println("\nPregunta " + (i + 1) + ": " + questions[i][0]);

            for (int j = 0; j < NUM_PLAYERS; j++) {
                System.out.print(players[j] + ", ingrese su respuesta: ");
                Scanner scanner = new Scanner(System.in);
                String playerAnswer = scanner.nextLine();
                if (playerAnswer.equalsIgnoreCase(answers[i][j])) {
                    scores[j]++;
                }
            }
        }
    }

    private void showResults() {
        System.out.println("\n--- Resultados finales ---");
        for (int i = 0; i < NUM_PLAYERS; i++) {
            System.out.println(players[i] + ": " + scores[i] + " aciertos");
        }

        int maxScore = scores[0];
        int winnerIndex = 0;

        for (int i = 1; i < NUM_PLAYERS; i++) {
            if (scores[i] > maxScore) {
                maxScore = scores[i];
                winnerIndex = i;
            }
        }

        System.out.println(players[winnerIndex] + " es el ganador!");
    }
}