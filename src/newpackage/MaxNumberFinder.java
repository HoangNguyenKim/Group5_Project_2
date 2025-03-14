import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class MaxNumberFinder extends JFrame {
    private JTextField inputField;
    private JButton findButton;
    private JLabel resultLabel;

    public MaxNumberFinder() {
        setTitle("Tìm Số Lớn Nhất");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel inputLabel = new JLabel("Nhập mảng (cách nhau bằng dấu phẩy):");
        inputField = new JTextField(20);
        findButton = new JButton("Tìm Số Lớn Nhất");
        resultLabel = new JLabel("");

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findMaxNumber();
            }
        });

        add(inputLabel);
        add(inputField);
        add(findButton);
        add(resultLabel);

        setVisible(true);
    }

    private void findMaxNumber() {
        try {
            // Lấy chuỗi nhập vào, tách thành mảng số nguyên
            String input = inputField.getText();
            String[] numbers = input.split(",");
            int[] array = Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();

            // Tìm số lớn nhất
            int max = Arrays.stream(array).max().orElseThrow();
            resultLabel.setText("Số lớn nhất: " + max);
        } catch (Exception ex) {
            resultLabel.setText("Lỗi: Vui lòng nhập đúng định dạng!");
        }
    }

    public static void main(String[] args) {
        new MaxNumberFinder();
    }
}
