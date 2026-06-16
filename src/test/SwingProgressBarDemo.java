package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SwingProgressBarDemo extends JFrame {
    private JProgressBar progressBar;
    private JButton startButton;
    private JButton indeterminateButton; // 无限模式按钮

    public SwingProgressBarDemo() {
        setTitle("Java Swing 进度条示例");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150);
        setLayout(new FlowLayout());

        // 创建进度条，范围 0-100
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true); // 显示百分比文本
        progressBar.setPreferredSize(new Dimension(300, 30));

        startButton = new JButton("开始任务");
        indeterminateButton = new JButton("无限模式"); // 不确定模式按钮

        startButton.addActionListener(this::startTask);
        indeterminateButton.addActionListener(e -> {
            // 点击时切换为不确定模式（循环滚动）
            progressBar.setIndeterminate(true);
            progressBar.setString("执行中...");
        });

        add(progressBar);
        add(startButton);
        add(indeterminateButton);
        setVisible(true);
    }

    private void startTask(ActionEvent e) {
        // 先切换回确定模式
        progressBar.setIndeterminate(false);
        progressBar.setValue(0);
        // 使用 SwingWorker 在后台执行，避免阻塞 UI 线程
        SwingWorker<Void, Integer> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i <= 100; i++) {
                    Thread.sleep(50); // 模拟耗时任务
                    publish(i);       // 发布进度更新
                }
                return null;
            }

            @Override
            protected void process(java.util.List<Integer> chunks) {
                int latest = chunks.get(chunks.size() - 1);
                progressBar.setValue(latest);
                progressBar.setString(latest + "%");
            }

            @Override
            protected void done() {
                progressBar.setString("完成!");
            }
        };
        worker.execute();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SwingProgressBarDemo::new);
    }
}
