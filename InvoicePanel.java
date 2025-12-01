import javax.swing.*;
import java.awt.*;
import java.io.*;

public class InvoicePanel extends JPanel {
    private JTextArea invoiceArea;
    private JButton saveButton, clearButton;
    private Invoice currentInvoice;

    public InvoicePanel() {
        setLayout(new BorderLayout());

        invoiceArea = new JTextArea();
        invoiceArea.setEditable(false);
        invoiceArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        add(new JScrollPane(invoiceArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        saveButton = new JButton("Save Invoice");
        clearButton = new JButton("Clear");
        buttonPanel.add(saveButton);
        buttonPanel.add(clearButton);
        add(buttonPanel, BorderLayout.SOUTH);

        saveButton.addActionListener(e -> {
            if (currentInvoice == null) {
                JOptionPane.showMessageDialog(null, "No invoice to save!");
                return;
            }
            saveInvoiceToFile(currentInvoice);
        });

        clearButton.addActionListener(e -> {
            invoiceArea.setText("");
            currentInvoice = null;
        });
    }

    public void displayInvoice(Invoice invoice) {
        this.currentInvoice = invoice;
        invoiceArea.setText(invoice.toString());
    }

    private void saveInvoiceToFile(Invoice invoice) {
        try (FileWriter writer = new FileWriter("Invoice_" + invoice.getInvoiceID() + ".txt")) {
            writer.write(invoice.toString());
            JOptionPane.showMessageDialog(null, "Invoice saved successfully!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error saving invoice: " + ex.getMessage());
        }
    }
}
