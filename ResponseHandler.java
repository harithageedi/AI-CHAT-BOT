import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.ArrayList;

public class ResponseHandler {

    private Map<String, String> responses;
    private String userName = "";
    private ArrayList<String> jokes;
    private ArrayList<String> quotes;
    private Random random;

    public ResponseHandler() {

        responses = new HashMap<>();
        jokes = new ArrayList<>();
        quotes = new ArrayList<>();
        random = new Random();

        // Greetings
        responses.put("hello", "Hello! Nice to meet you.");
        responses.put("hi", "Hi! How can I help you?");
        responses.put("good morning", "Good morning! Hope you're having a wonderful day.");
        responses.put("good evening", "Good evening!");

        // Questions
        responses.put("how are you", "I'm doing great! Thanks for asking.");

        // Programming
        responses.put("java", "Java is an Object-Oriented Programming language.");
        responses.put("python", "Python is a simple and powerful programming language.");
        responses.put("c++", "C++ is widely used in competitive programming and game development.");

        // College
        responses.put("placement", "Keep practicing DSA and build good projects.");
        responses.put("project", "Building projects is the best way to learn programming.");

        // Farewell
        responses.put("bye", "Goodbye! Have a wonderful day.");

        // Jokes
        jokes.add("Why do programmers prefer dark mode? Because light attracts bugs!");
        jokes.add("Why did the Java developer wear glasses? Because they couldn't C#.");
        jokes.add("Debugging is like being the detective in a crime movie where you're also the murderer.");
        jokes.add("There are only 10 types of people: those who understand binary and those who don't.");
        // Quotes
        quotes.add("Success is the sum of small efforts repeated every day.");
        quotes.add("Dream big. Start small. Act now.");
        quotes.add("Don't stop until you're proud.");
        quotes.add("Every expert was once a beginner.");
        quotes.add("The best way to predict the future is to create it.");
    }

    public String generateResponse(String message) {

        String input = message.toLowerCase().trim();

        // Remember the user's name
        if (input.startsWith("my name is ")) {

            userName = message.substring(11).trim();

            return "Nice to meet you, " + userName + "!";
        }

        // Recall the user's name
        if (input.equals("who am i")) {

            if (userName.isEmpty()) {
                return "I don't know your name yet. Tell me by saying: My name is Haritha";
            }

            return "You are " + userName + ".";
        }

        // Search predefined responses
        // Emotion Detection

if (input.contains("sad")) {
    return "I'm sorry you're feeling sad. Remember, tough times don't last forever. ❤️";
}

if (input.contains("happy")) {
    return "That's wonderful! Keep smiling. 😊";
}

if (input.contains("angry")) {
    return "Take a deep breath. Staying calm often helps solve problems.";
}

if (input.contains("tired")) {
    return "Make sure you get enough rest and drink some water. 😴";
}
// Date

if (input.equals("date")) {
    return "Today's date is " + LocalDate.now();
}

// Time

if (input.equals("time")) {

    DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("hh:mm a");

    return "Current time: "
            + LocalTime.now().format(formatter);
}

// Joke
if (input.equals("joke")) {

    int index = random.nextInt(jokes.size());

    return jokes.get(index);
}

// Motivation
if (input.equals("motivate me")) {

    int index = random.nextInt(quotes.size());

    return quotes.get(index);
}

// Help
if (input.equals("help")) {

    return """
========== SMART AI CHATBOT ==========
Available Commands:

hello
hi
how are you

my name is <your name>
who am i

date
time

calculate 25+30
calculate 100/5
calculate 8*9

joke
motivate me

java
python
c++

project
placement

bye
exit
======================================
""";
}

        for (String key : responses.keySet()) {

            if (input.contains(key)) {
                return responses.get(key);
            }

        }

        return "Sorry, I don't understand that yet.";
    }
}