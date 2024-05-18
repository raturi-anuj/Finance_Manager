import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class InventoryApp {
    private InventoryManager manager;
    private JTextArea outputArea;

    public InventoryApp() {
        manager = new InventoryManager();
        initUI();
    }

    private void initUI() {
        JFrame frame = new JFrame("Inventory Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Text area for output
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Control panel with buttons and input fields
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(0, 2));

        controlPanel.add(new JLabel("ID:"));
        JTextField idField = new JTextField();
        controlPanel.add(idField);

        controlPanel.add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        controlPanel.add(nameField);

        controlPanel.add(new JLabel("Description:"));
        JTextField descriptionField = new JTextField();
        controlPanel.add(descriptionField);

        controlPanel.add(new JLabel("Quantity:"));
        JTextField quantityField = new JTextField();
        controlPanel.add(quantityField);

        controlPanel.add(new JLabel("Price:"));
        JTextField priceField = new JTextField();
        controlPanel.add(priceField);

        JButton addButton = new JButton("Add Item");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String name = nameField.getText();
                String description = descriptionField.getText();
                int quantity = Integer.parseInt(quantityField.getText());
                double price = Double.parseDouble(priceField.getText());
                manager.addItem(new Item(id, name, description, quantity, price));
                outputArea.setText(manager.generateReport());
            }
        });
        controlPanel.add(addButton);

        JButton updateButton = new JButton("Update Quantity");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                int newQuantity = Integer.parseInt(quantityField.getText());
                manager.updateItemQuantity(id, newQuantity);
                outputArea.setText(manager.generateReport());
            }
        });
        controlPanel.add(updateButton);

        JButton removeButton = new JButton("Remove Item");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                manager.removeItem(id);
                outputArea.setText(manager.generateReport());
            }
        });
        controlPanel.add(removeButton);

        JButton searchButton = new JButton("Search Item");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                Item item = manager.searchItem(id);
                if (item != null) {
                    outputArea.setText(item.toString());
                } else {
                    outputArea.setText("Item not found.");
                }
            }
        });
        controlPanel.add(searchButton);

        panel.add(controlPanel, BorderLayout.NORTH);
        frame.add(panel);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InventoryApp());
    }
}
