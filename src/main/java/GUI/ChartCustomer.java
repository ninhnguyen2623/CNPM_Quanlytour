package GUI;

import java.util.ArrayList;

import javax.swing.JFrame;

import org.apache.poi.ss.formula.functions.Index;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import BUS.CustomerBUS;
import DAO.CustomerDAO;
import DTO.CustomerDTO;

/**
 *
 * @author TVD
 */
public class ChartCustomer {

    public static JFreeChart createChart() {
        JFreeChart barChart = ChartFactory.createBarChart(
                "BIỂU ĐỒ SỐ LƯỢNG KHÁCH HÀNG",
                "Năm", "Số người",
                createDataset(), PlotOrientation.VERTICAL, false, false, false);
        return barChart;
    }

    private static CategoryDataset createDataset() {
    	CustomerBUS customerBUS = new CustomerBUS();
    	ArrayList<CustomerDTO> fffArrayList = customerBUS.getAll();
  
    	int i =0;
    	for(CustomerDTO customerDTO: fffArrayList) {
    		i++;
    	}
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(5, "Số người", "2020");
        dataset.addValue(7, "Số người", "2010");
        dataset.addValue(9, "Số người", "2000");
        dataset.addValue(i, "Số người", "2023");
        return dataset;
    }

    public static void main(String[] args) {
        ChartPanel chartPanel = new ChartPanel(createChart());
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        JFrame frame = new JFrame();
        frame.add(chartPanel);
        frame.setTitle("Biểu đồ JFreeChart trong Java Swing");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }


}