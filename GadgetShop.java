import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GadgetShop {

    private ArrayList<Gadget> stock = new ArrayList<>();

    private JTextField model = new JTextField(10);
    private JTextField price = new JTextField(10);
    private JTextField weight = new JTextField(10);
    private JTextField size = new JTextField(10);

    private JTextField credit = new JTextField(10);
    private JTextField memory = new JTextField(10);

    private JTextField phone = new JTextField(10);
    private JTextField duration = new JTextField(10);
    private JTextField download = new JTextField(10);
    private JTextField indexField = new JTextField(10);

    public GadgetShop() {

        JFrame frame = new JFrame("My Gadget Shop");
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Basic Info"));

        inputPanel.add(new JLabel("Model:"));
        inputPanel.add(model);

        inputPanel.add(new JLabel("Price:"));
        inputPanel.add(price);

        inputPanel.add(new JLabel("Weight:"));
        inputPanel.add(weight);

        inputPanel.add(new JLabel("Size:"));
        inputPanel.add(size);

        JPanel extraPanel = new JPanel(new GridLayout(3, 2));
        extraPanel.setBorder(BorderFactory.createTitledBorder("Extras"));

        extraPanel.add(new JLabel("Credit:"));
        extraPanel.add(credit);

        extraPanel.add(new JLabel("Memory:"));
        extraPanel.add(memory);

        extraPanel.add(new JLabel("Index:"));
        extraPanel.add(indexField);

        JPanel actionPanel = new JPanel(new GridLayout(3, 2));
        actionPanel.setBorder(BorderFactory.createTitledBorder("Actions"));

        JButton addMobile = new JButton("Add Mobile");
        JButton addMP3 = new JButton("Add MP3");
        JButton display = new JButton("Show All");
        JButton call = new JButton("Call");
        JButton downloadBtn = new JButton("Download");
        JButton clear = new JButton("Clear");

        actionPanel.add(addMobile);
        actionPanel.add(addMP3);
        actionPanel.add(display);
        actionPanel.add(call);
        actionPanel.add(downloadBtn);
        actionPanel.add(clear);

        JPanel bottomPanel = new JPanel(new GridLayout(2, 2));
        bottomPanel.setBorder(BorderFactory.createTitledBorder("Extra Actions"));

        bottomPanel.add(new JLabel("Phone:"));
        bottomPanel.add(phone);

        bottomPanel.add(new JLabel("Duration / Download:"));
        bottomPanel.add(duration);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(extraPanel, BorderLayout.CENTER);
        frame.add(actionPanel, BorderLayout.EAST);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        addMobile.addActionListener(e -> {
            try {
                Mobile m = new Mobile(
                        model.getText(),
                        Double.parseDouble(price.getText()),
                        Integer.parseInt(weight.getText()),
                        size.getText(),
                        Integer.parseInt(credit.getText())
                );
                stock.add(m);
                System.out.println("Mobile added.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Check your input.");
            }
        });

        addMP3.addActionListener(e -> {
            try {
                MP3 m = new MP3(
                        model.getText(),
                        Double.parseDouble(price.getText()),
                        Integer.parseInt(weight.getText()),
                        size.getText(),
                        Integer.parseInt(memory.getText())
                );
                stock.add(m);
                System.out.println("MP3 added.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Check your input.");
            }
        });

        display.addActionListener(e -> {
            System.out.println("\n=== ALL GADGETS ===");
            for (int i = 0; i < stock.size(); i++) {
                System.out.println("Index: " + i);
                stock.get(i).display();
            }
        });

        call.addActionListener(e -> {
            int i = getIndex(frame);
            if (i != -1) {
                try {
                    Mobile m = (Mobile) stock.get(i);
                    m.makeCall(phone.getText(), Integer.parseInt(duration.getText()));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Not a mobile!");
                }
            }
        });

        downloadBtn.addActionListener(e -> {
            int i = getIndex(frame);
            if (i != -1) {
                try {
                    MP3 m = (MP3) stock.get(i);
                    m.downloadMusic(Integer.parseInt(duration.getText()));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Not an MP3!");
                }
            }
        });

        clear.addActionListener(e -> {
            JTextField[] fields = {
                    model, price, weight, size,
                    credit, memory, phone, duration, indexField
            };
            for (JTextField f : fields) {
                f.setText("");
            }
        });

        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private int getIndex(JFrame frame) {
        try {
            int i = Integer.parseInt(indexField.getText());
            if (i < 0 || i >= stock.size()) {
                JOptionPane.showMessageDialog(frame, "Index out of range");
                return -1;
            }
            return i;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Enter a valid number");
            return -1;
        }
    }

    public static void main(String[] args) {
        new GadgetShop();
    }
}

