package org.example;

import java.util.Scanner;

public class Quiz {
    private Question[] questions;
    private Scanner scanner;

    public Quiz(Question[] questions) {
        this.questions = questions;
        this.scanner = new Scanner(System.in);
    }

    public void InicioPreguntas() {
        System.out.println("Bienvenido al Juego de Trivia!");
        System.out.println("Responde las siguientes preguntas seleccionando el número de la opción correcta.");

        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            Question currentQuestion = questions[i];
            System.out.println("Pregunta " + (i + 1) + ": " + currentQuestion.getDescription());
            String[] options = currentQuestion.getOptions();
            for (int j = 0; j < options.length; j++) {
                System.out.println((j + 1) + ") " + options[j]);
            }
            System.out.print("Tu respuesta: ");
            int userAnswer = getUserAnswer(scanner.nextLine());
            if (userAnswer == currentQuestion.getCorrectAnswerIndex()) {
                score++;
                System.out.println("¡Correcto!");
            } else {
                System.out.println("Incorrecto.");
            }
        }

        System.out.println("Juego terminado. Aquí está tu puntuación:");
        System.out.println("Preguntas contestadas: " + questions.length);
        System.out.println("Respuestas correctas: " + score);
        System.out.println("Respuestas incorrectas: " + (questions.length - score));
    }

    public int getUserAnswer(String answer) {
        try {
            int parsedAnswer = Integer.parseInt(answer);
            if (parsedAnswer < 1 || parsedAnswer > 4) {
                throw new NumberFormatException();
            }
            return parsedAnswer;
        } catch (NumberFormatException e) {
            System.out.print("Por favor, ingresa un número válido: ");
            return 0;
        }
    }
}