package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

public class GUI_main {
    JFrame mainFrame;
    JPanel panel;
    JButton orderButton;
    JButton historyButton;
    JCheckBox vensionCheckBox;
    JCheckBox sauceCheckBox;
    JCheckBox flatbreadCheckBox;
    JCheckBox BerriesCheckBox;
    JTextArea resultArea;
    History history;

    public GUI_main() {
        history = new History();

        mainFrame = new JFrame("Заказ похлебки");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 450);
        mainFrame.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JLabel titleLabel = new JLabel("Выберите ингредиенты для похлебки:");
        panel.add(titleLabel);
        vensionCheckBox = new JCheckBox("Двойная оленина");
        panel.add(vensionCheckBox);
        sauceCheckBox = new JCheckBox("Острый соус");
        panel.add(sauceCheckBox);
        flatbreadCheckBox = new JCheckBox("Лепешка");
        panel.add(flatbreadCheckBox);
        BerriesCheckBox = new JCheckBox("Снежные ягоды");
        panel.add(BerriesCheckBox);
        panel.add(Box.createVerticalStrut(20));

        orderButton = new JButton("Сделать заказ");
        panel.add(orderButton);

        panel.add(Box.createVerticalStrut(10));

        historyButton = new JButton("Показать историю заказов");
        panel.add(historyButton);

        panel.add(Box.createVerticalStrut(10));

        resultArea = new JTextArea(5, 30);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        panel.add(scrollPane);

        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeOrder();
            }
        });

        historyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showHistory();
            }
        });

        mainFrame.add(panel);
        mainFrame.setVisible(true);
    }

    private void makeOrder() {
        int count = (vensionCheckBox.isSelected() ? 1 : 0) +
                (sauceCheckBox.isSelected() ? 1 : 0) +
                (flatbreadCheckBox.isSelected() ? 1 : 0) +
                (BerriesCheckBox.isSelected() ? 1 : 0);

        String errorMessage = count > 3 ? "Ошибка: нельзя выбрать больше 3 добавок!" : null;

        Stew stew = new BasicStew();
        stew = vensionCheckBox.isSelected() ? new DoubleVenisonDecorator(stew) : stew;
        stew = sauceCheckBox.isSelected() ? new HotSauceDecorator(stew) : stew;
        stew = flatbreadCheckBox.isSelected() ? new NordicFlatbreadDecorator(stew) : stew;
        stew = BerriesCheckBox.isSelected() ? new SnowBerriesDecorator(stew) : stew;

        if (errorMessage == null) {
            Order newOrder = new Order(stew.getName(), stew.getCost());
            history.addOrder(newOrder);
        }

        resultArea.setText(errorMessage != null ? errorMessage :
                "Вы заказали - " + stew.getName() + "\n" + "Цена:" + stew.getCost());
    }

    private void showHistory() {
        List<Order> orders = history.getOrders();

        JFrame historyFrame = new JFrame("История заказов");
        historyFrame.setSize(450, 350);
        historyFrame.setLocationRelativeTo(mainFrame);

        JTextArea historyArea = new JTextArea();
        historyArea.setEditable(false);

        if (orders.isEmpty()) {
            historyArea.setText("История заказов пуста");
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy");
            StringBuilder sb = new StringBuilder();
            sb.append("История заказов\n");
            for (int i = 0; i < orders.size(); i++) {
                Order order = orders.get(i);
                sb.append(i + 1).append(". [").append(sdf.format(order.getTimestamp()))
                        .append("] ").append(order.getStewName())
                        .append(" - ").append(order.getPrice()).append(" монет\n");
            }
            historyArea.setText(sb.toString());
        }

        JScrollPane scrollPane = new JScrollPane(historyArea);
        historyFrame.add(scrollPane);
        historyFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI_main();
            }
        });
    }
}