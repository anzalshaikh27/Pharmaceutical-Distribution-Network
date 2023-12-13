package DashboardTrial;
import javax.swing.*;
import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.HospitalEnterprise;
import Business.Organization.Organization;
import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author zakir
 */

public class AdminDashboard extends JFrame {
    private EcoSystem system;

    public AdminDashboard() {
        DB4OUtil db4OUtil = DB4OUtil.getInstance();
        system = db4OUtil.retrieveSystem();

        // window
        setTitle("Dashboard");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // pie chart for organizations, profiles, orders, and vaccines
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Organizations", system.getCdc().getOrganizationDirectory().getOrganizationList().size());
        dataset.setValue("Profiles", system.getCdc().getPersonDirectory().getPeopleList().size());
        dataset.setValue("Orders", system.getCdc().getOrderCatalog().getOrderHistory().size());
        dataset.setValue("Drugs", system.getVaccineDirectory().getVaccineCatalog().size());
        JFreeChart pieChart = ChartFactory.createPieChart("Overview", dataset, true, false, false);
        PiePlot plot = (PiePlot) pieChart.getPlot();
        plot.setSectionPaint("Organizations", new Color(79, 129, 189)); // blue color
        plot.setSectionPaint("Profiles", new Color(155, 187, 89)); // green color
        plot.setSectionPaint("Orders", new Color(192, 80, 77)); // red color
        plot.setSectionPaint("Drugs", new Color(128, 100, 162)); // purple color
        ChartPanel pieChartPanel = new ChartPanel(pieChart);
        pieChartPanel.setPreferredSize(new java.awt.Dimension(400, 300));

        // bar chart for orders by month
        DefaultCategoryDataset barDataset = new DefaultCategoryDataset();
        for (int i = 1; i <= 12; i++) {
            String month = String.format("%02d", i);
            int orders = system.getCdc().getOrderCatalog().getOrderHistory().size();
            barDataset.addValue(orders, "Orders", month);
        }
        JFreeChart barChart = ChartFactory.createBarChart("Orders by Month", "Month", "Number of Orders", barDataset, PlotOrientation.VERTICAL, false, false, false);
        ChartPanel barChartPanel = new ChartPanel(barChart);
        barChartPanel.setPreferredSize(new java.awt.Dimension(400, 300));

        // line chart for vaccine distribution over time
        DefaultCategoryDataset lineDataset = new DefaultCategoryDataset();
        for (Organization hospital : system.getCdc().getOrganizationDirectory().getOrganizationList()) {
            for (int i = 1; i <= 12; i++) {
                String month = String.format("%02d", i);
                int vaccines = system.getVaccineDirectory().getVaccineCatalog().size();
                lineDataset.addValue(vaccines, hospital.getName(), month);
            }
        }
        JFreeChart lineChart = ChartFactory.createLineChart("Drugs Distribution by Hospital", "Month", "Number of Drugs", lineDataset, PlotOrientation.VERTICAL, true, true, false);
ChartPanel lineChartPanel = new ChartPanel(lineChart);
lineChartPanel.setPreferredSize(new java.awt.Dimension(400, 300));
    // add charts to dashboard
    JPanel chartPanel = new JPanel();
    chartPanel.add(pieChartPanel);
    chartPanel.add(barChartPanel);
    chartPanel.add(lineChartPanel);
    getContentPane().add(chartPanel);

    // display window
    setLocationRelativeTo(null);
    setVisible(true);
}

public static void main(String[] args) {
    new AdminDashboard();
}
}

                