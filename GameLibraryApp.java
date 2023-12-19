import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class VideoGame {
    String title;
    String genre;
    boolean isOwned;

    public VideoGame(String title, String genre, boolean isOwned) {
        this.title = title;
        this.genre = genre;
        this.isOwned = isOwned;
    }
}

class GameLibraryApp {
    private ArrayList<VideoGame> gameList = new ArrayList<>();

    private JFrame frame;
    private JTable gameTable;
    private DefaultTableModel tableModel;

    private JTextField titleField;
    private JTextField genreField;
    private JCheckBox ownedCheckbox;

    private JButton addButton;
    private JButton toggleDarkModeButton;

    private boolean isDarkMode = false;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameLibraryApp().createAndShowGUI());
    }

    private void createAndShowGUI() {
        frame = new JFrame("Game Library");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createUI();

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void createUI() {
        JPanel panel = new JPanel(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);

        // Set background color
        panel.setBackground(new Color(240, 240, 240));

        // Create the game table
        tableModel = new DefaultTableModel(new String[]{"Title", "Genre", "Owned"}, 0);
        gameTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(gameTable);
        panel.add(tableScrollPane, BorderLayout.CENTER);

        // Create the form for adding games
        JPanel formPanel = new JPanel(new GridLayout(4, 2));
        formPanel.setBackground(new Color(200, 200, 200));

        titleField = new JTextField();
        genreField = new JTextField();
        ownedCheckbox = new JCheckBox("Owned");

        formPanel.add(new JLabel("Title:"));
        formPanel.add(titleField);
        formPanel.add(new JLabel("Genre:"));
        formPanel.add(genreField);
        formPanel.add(new JLabel("Owned:"));
        formPanel.add(ownedCheckbox);

        addButton = new JButton("Add Game");
        addButton.setBackground(new Color(50, 150, 50)); // Green color for the button
        addButton.setForeground(Color.WHITE);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addGame();
            }
        });
        formPanel.add(addButton);

        toggleDarkModeButton = new JButton("Toggle Dark Mode");
        toggleDarkModeButton.setBackground(new Color(100, 100, 100)); // Dark grey color for the button
        toggleDarkModeButton.setForeground(Color.WHITE);
        toggleDarkModeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleDarkMode();
            }
        });
        formPanel.add(toggleDarkModeButton);

        panel.add(formPanel, BorderLayout.SOUTH);
    }

    private void addGame() {
        String title = titleField.getText();
        String genre = genreField.getText();
        boolean isOwned = ownedCheckbox.isSelected();

        VideoGame game = new VideoGame(title, genre, isOwned);
        gameList.add(game);

        // Update the table
        Object[] rowData = {title, genre, isOwned ? "Yes" : "No"};
        tableModel.addRow(rowData);

        // Clear the form fields
        titleField.setText("");
        genreField.setText("");
        ownedCheckbox.setSelected(false);
    }

    private void toggleDarkMode() {
        isDarkMode = !isDarkMode;

        if (isDarkMode) {
            frame.getContentPane().setBackground(new Color(50, 50, 50)); // Dark grey background
            gameTable.setBackground(new Color(30, 30, 30)); // Very dark grey for the table
            gameTable.setForeground(Color.WHITE);
            toggleDarkModeButton.setText("Toggle Light Mode");
        } else {
            frame.getContentPane().setBackground(new Color(240, 240, 240)); // Light grey background
            gameTable.setBackground(Color.WHITE);
            gameTable.setForeground(Color.BLACK);
            toggleDarkModeButton.setText("Toggle Dark Mode");
        }
    }
}
