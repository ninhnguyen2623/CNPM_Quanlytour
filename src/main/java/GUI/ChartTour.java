package GUI;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import BUS.BookingBUS;
import DTO.BookingDTO;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ChartTour extends JFrame {

    public ChartTour() {

        initUI();
    }

    private void initUI() {

        XYDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle("Line chart");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private XYDataset createDataset() {
    	var series = new XYSeries("2023");
    	BookingBUS bookingbus = new BookingBUS();
    	ArrayList<BookingDTO> bookingdto = bookingbus.getAll();
    	double sumprice1 = 0,sumprice2 = 0,sumprice3 = 0,sumprice4 = 0,sumprice5 = 0,sumprice6 = 0,sumprice7 = 0,sumprice8 = 0,sumprice9 = 0,sumprice10 = 0,sumprice11 = 0,sumprice12 = 0;
    	for(BookingDTO item: bookingdto) {
    		 String Stringmonths = item.getCreate_at();
    		 SimpleDateFormat formatter4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		 try {
				Date months = formatter4.parse(Stringmonths);
				 SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
				int intmonth = Integer.parseInt(dateFormat.format(months));
				if(intmonth == 1) {
					sumprice1 = sumprice1 + item.getTotal_cost();
			
						series.add(1, sumprice1);
					
				}
				else if (intmonth == 2) {
					sumprice2 = sumprice2 + item.getTotal_cost();
					series.add(2, sumprice2);
				}
				else if (intmonth == 3) {
					sumprice3 = sumprice3 + item.getTotal_cost();
					series.add(3, sumprice3);
				}
				else if (intmonth == 4) {
					sumprice4 = sumprice4 + item.getTotal_cost();
					series.add(4, sumprice4);
				}
				else if (intmonth == 5) {
					sumprice5 = sumprice5 + item.getTotal_cost();
					series.add(5, sumprice5);
				}
				else if (intmonth == 6) {
					sumprice6 = sumprice6 + item.getTotal_cost();
					series.add(6, sumprice6);
				}
				else if (intmonth == 7) {
					sumprice7 = sumprice7 + item.getTotal_cost();
					series.add(7, sumprice7);
				}
				else if (intmonth == 8) {
					sumprice8 = sumprice8 + item.getTotal_cost();
					series.add(8, sumprice8);
				}
				else if (intmonth == 9) {
					sumprice9 = sumprice9 + item.getTotal_cost();
					series.add(9, sumprice9);
				}
				else if (intmonth == 10) {
					sumprice10 = sumprice10 + item.getTotal_cost();
					series.add(10, sumprice10);
				}
				else if (intmonth == 11) {
					sumprice11 = sumprice11 + item.getTotal_cost();
					series.add(11, sumprice11);
				}
				else if (intmonth == 12) {
					sumprice12 = sumprice12 + item.getTotal_cost();
					series.add(12, sumprice12);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		 
    	}
        var dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        return dataset;
    }

    private JFreeChart createChart(XYDataset dataset) {

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Thống kê danh thu trong năm theo từng tháng",
                "Tháng",
                "Danh Thu",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        
        XYPlot plot = chart.getXYPlot();

        var renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);

        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        chart.getLegend().setFrame(BlockBorder.NONE);

        chart.setTitle(new TextTitle("Thống kê danh thu trong năm theo từng tháng",
                        new Font("Serif", java.awt.Font.BOLD, 18)
                )
        );

        return chart;
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var ex = new ChartTour();
            ex.setVisible(true);
        });
    }
}