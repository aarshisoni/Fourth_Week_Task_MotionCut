import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextAdventureGame {
    private JFrame frame;
    private JPanel mainPanel;
    private JTextArea textArea;
    private JTextField inputField;
    private JButton submitButton;
    private JPanel optionsPanel;
    private JTextArea optionsTextArea;
    private boolean gameOver = false;
    private String currentChoice;

    public TextAdventureGame() {
        frame = new JFrame("Text Adventure Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        mainPanel = new JPanel(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        inputField = new JTextField(30);
        submitButton = new JButton("Submit");

        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        inputPanel.add(new JLabel("Enter your choice: "));
        inputPanel.add(inputField);
        inputPanel.add(submitButton);
        mainPanel.add(inputPanel, BorderLayout.NORTH);

        optionsPanel = new JPanel(new BorderLayout());
        optionsTextArea = new JTextArea();
        optionsTextArea.setEditable(false);
        optionsTextArea.setMargin(new Insets(10, 10, 10, 10));
        optionsTextArea.setFont(new Font("Arial", Font.BOLD, 14));
        optionsPanel.add(optionsTextArea, BorderLayout.SOUTH);
        mainPanel.add(optionsPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String choice = inputField.getText().toLowerCase();
                handleInput(choice);
                inputField.setText("");
            }
        });

        frame.setVisible(true);
        start();
    }

    private void handleInput(String choice) {
        if (gameOver) {
            appendText("Game over. You can't make any more choices.");
            return;
        }

        currentChoice = choice;

        switch (currentChoice) {
            case "start":
                start();
                break;
            case "explore the forest":
                exploreForest();
                break;
            case "go to the cave":
                goToCave();
                break;
            case "open the treasure chest":
                openTreasureChest();
                break;
            case "fight the dragon":
                fightDragon();
                break;
            case "run away":
                runAway();
                break;
            case "quit":
                quit();
                break;
            default:
                appendText("Invalid choice. Try again.");
        }
    }

    private void start() {
        appendText("Welcome to the Text Adventure Game!");
        appendText("You find yourself in a dark forest. What will you do? \n\n");
        updateOptions("Available Options (type them exactly):\n - start\n - explore the forest\n - go to the cave\n - open the treasure chest\n - fight the dragon\n - run away\n - quit");
    }

    private void exploreForest() {
        appendText("You decide to explore the forest and come across a fork in the path.");
        appendText("Do you want to go to the cave or continue through the forest? \n\n");
        updateOptions("Available Options (type them exactly):\n - go to the cave\n - continue through the forest");
    }

    private void goToCave() {
        appendText("You enter a mysterious cave and discover a treasure chest.");
        appendText("Do you want to open the chest or leave it? \n\n");
        updateOptions("Available Options (type them exactly):\n - open the treasure chest\n - leave it");
    }

    private void openTreasureChest() {
        appendText("Congratulations! You found a valuable treasure.");
        appendText("You win the game! \n\n");
        gameOver = true;
        updateOptions("");
    }

    private void fightDragon() {
        appendText("You bravely attempt to fight the dragon, but it's too powerful.");
        appendText("You are defeated. Game over! \n\n");
        gameOver = true;
        updateOptions("");
    }

    private void runAway() {
        appendText("You wisely decide to run away from the dragon and return to the cave entrance.");
        appendText("Do you want to continue exploring the cave or go back to the forest? \n\n");
        updateOptions("Available Options (type them exactly):\n - continue exploring the cave\n - go back to the forest");
    }

    private void quit() {
        appendText("Quitting the game. Goodbye! \n\n");
        gameOver = true;
        updateOptions("");
    }

    private void appendText(String text) {
        // Create a font with the desired size
        Font font = new Font("Arial", Font.PLAIN, 25); // You can adjust the size as needed

        // Set the font for the text area
        textArea.setFont(font);

        // Append text with the updated font
        textArea.append(text + "\n");
    }

    private void updateOptions(String text) {
        Font option = new Font("Arial", Font.PLAIN, 20); // You can adjust the size as needed
        // Set the font for the text area
        optionsTextArea.setFont(option);

        optionsTextArea.setText(text);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TextAdventureGame());
    }
}