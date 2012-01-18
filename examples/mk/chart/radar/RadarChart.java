package mk.chart.radar;

import java.awt.BasicStroke;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.SpiderWebPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;

/**
 * A class for testing some Spider Web Plot features.
 * <p/>
 * Needs some tweaks here and there. Uploaded after the request to see some demo of spider web plot with negative
 * values.
 */
public final class RadarChart extends JFrame {

    private static final double START_ANGLE = 0d;
    private final ChartPanel radarPanel;
    private SpiderWebPlot plot;

    public RadarChart() {
        initComponents();
        JFreeChart chart = createChart(createDataset());
        radarPanel = new ChartPanel(chart);
        chartArea.add(radarPanel);
        plot.setAxisTickVisible(true);
        pointSizeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = pointSizeSlider.getValue();
                float lineWidth = value / 10f;
                plot.setSeriesOutlineStroke(new BasicStroke(lineWidth));
                float headStroke = (lineWidth / 10f) + 0.5f;
                plot.setHeadOutlineStroke(new BasicStroke(headStroke));
                plot.setHeadPercent(0.01f + (lineWidth / 400f));
            }
        });

        originsSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                plot.setOrigin((Double) originsSpinner.getValue());
            }
        });
        angleSpinner.setValue(START_ANGLE);
        angleSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                plot.setStartAngle((Double) angleSpinner.getValue());
            }
        });
        axisTick.setSelected(true);
        pack();
    }

    private JFreeChart createChart(CategoryDataset dataset) {
        plot = new SpiderWebPlot(dataset);
        for (int i = 0; i < dataset.getColumnCount(); i++) {
            plot.setOrigin(i, 0d);
        }

        // molWeight
        plot.setOrigin(0, 140d);
        plot.setMaxValue(0, 10d);

        // testCat
        plot.setOrigin(4, -120d);

        plot.setStartAngle(START_ANGLE);
        plot.setToolTipGenerator(new StandardCategoryToolTipGenerator());
        plot.setDrawOutOfRangePoints(true);
        JFreeChart chart = new JFreeChart("Spider Web Chart Test",
                TextTitle.DEFAULT_FONT, plot, false);
        LegendTitle legend = new LegendTitle(plot);
        legend.setPosition(RectangleEdge.BOTTOM);
        chart.addSubtitle(legend);
        ChartUtilities.applyCurrentTheme(chart);
        return chart;
    }

    private static CategoryDataset createDataset() {
        // row keys...
        String water = "H2O";
        String ethanol = "C2H6O";
        String adenine = "C5H5N5";

        // column keys...
        String mwCat = "Mol Weight";
        String logpCat = "LogP";
        String acidicPKa = "Strongest acidic pKa";
        String basicPKa = "Strongest basic pKa";
        String testCat = "Test Category";
        String zeroCat = "Zero Category";

        // create the dataset...
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Molecular weight
        dataset.addValue(18.02, water, mwCat);
        dataset.addValue(46.07, ethanol, mwCat);
        dataset.addValue(135.13, adenine, mwCat);

        // basic PKa
        dataset.addValue(1.80, water, basicPKa);
        dataset.addValue(2.16, ethanol, basicPKa);
        dataset.addValue(5.43, adenine, basicPKa);

        // acidic PKa
        dataset.addValue(15.70, water, acidicPKa);
        dataset.addValue(16.47, ethanol, acidicPKa);
        dataset.addValue(9.91, adenine, acidicPKa);

        // logP
        dataset.addValue(0.65, water, logpCat);
        dataset.addValue(0.16, ethanol, logpCat);
        dataset.addValue(0.53, adenine, logpCat);

        // test category
        dataset.addValue(-100, water, testCat);
        dataset.addValue(50, ethanol, testCat);
        dataset.addValue(100, adenine, testCat);

        // a zero category
        dataset.addValue(0, water, zeroCat);
        dataset.addValue(0, ethanol, zeroCat);
        dataset.addValue(0, adenine, zeroCat);

        return dataset;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     *
     * WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chartArea = new JPanel();
        pointSizeSlider = new JSlider();
        originsLabel = new JLabel();
        originsSpinner = new JSpinner();
        angleLabel = new JLabel();
        angleSpinner = new JSpinner();
        axisTick = new JCheckBox();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        chartArea.setLayout(new GridLayout(1, 0));

        pointSizeSlider.setMaximum(50);

        originsLabel.setDisplayedMnemonic('O');
        originsLabel.setLabelFor(originsSpinner);
        originsLabel.setText("Origins:");

        originsSpinner.setModel(new SpinnerNumberModel(Double.valueOf(0.0d), null, null, Double.valueOf(0.1d)));

        angleLabel.setDisplayedMnemonic('S');
        angleLabel.setLabelFor(angleSpinner);
        angleLabel.setText("Start Angle:");

        angleSpinner.setModel(new SpinnerNumberModel(Double.valueOf(0.0d), null, null, Double.valueOf(4.0d)));

        axisTick.setMnemonic('T');
        axisTick.setText("Show Axis Ticks");
        axisTick.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                axisTickActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(chartArea, GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(pointSizeSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(Alignment.LEADING)
                            .addComponent(angleLabel)
                            .addComponent(originsLabel))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(Alignment.LEADING)
                            .addComponent(originsSpinner, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(angleSpinner, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)))
                    .addComponent(axisTick))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addComponent(chartArea, GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pointSizeSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(originsLabel)
                    .addComponent(originsSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(angleLabel)
                    .addComponent(angleSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addComponent(axisTick)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void axisTickActionPerformed(ActionEvent evt) {//GEN-FIRST:event_axisTickActionPerformed
        plot.setAxisTickVisible(axisTick.isSelected());
    }//GEN-LAST:event_axisTickActionPerformed

    private void runInEDT() {
        RefineryUtilities.centerFrameOnScreen(this);
        setVisible(true);
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RadarChart().runInEDT();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JLabel angleLabel;
    private JSpinner angleSpinner;
    private JCheckBox axisTick;
    private JPanel chartArea;
    private JLabel originsLabel;
    private JSpinner originsSpinner;
    private JSlider pointSizeSlider;
    // End of variables declaration//GEN-END:variables
}
