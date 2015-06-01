package webDashboards.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.PieLabelLinkStyle;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.jdbc.JDBCPieDataset;

import java.io.OutputStream;

import Acme.JPM.Encoders.GifEncoder;

import com.redprairie.moca.MocaException;
import com.redprairie.moca.MocaResults;
import com.redprairie.moca.NotFoundException;
import com.redprairie.moca.client.ConnectionUtils;
import com.redprairie.moca.client.HttpConnection;

public class PieChart extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public PieChart() {

        // TODO Auto­generated constructor stub

    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException,
            IOException {

        DefaultPieDataset dataset;
        PiePlot plot;
        JFreeChart chart;
        ChartPanel panel;
        
        String recibido;
        String recibir;
        
        recibido = request.getParameter("recibido");
        recibir = request.getParameter("recibir");

        dataset = new DefaultPieDataset();
        dataset.setValue("Recibido", Double.parseDouble(recibido));
        dataset.setValue("Por Recibir", Double.parseDouble(recibir));

        plot = new PiePlot(dataset);
        plot.setBackgroundPaint(Color.WHITE);
        plot.setInteriorGap(0.04);
        plot.setOutlineVisible(false);
        
        plot.setBaseSectionOutlinePaint(Color.WHITE);
        plot.setSectionOutlinesVisible(true);
        plot.setBaseSectionOutlineStroke(new BasicStroke(2.0f));

        plot.setLabelFont(new Font("Arial", Font.BOLD, 14));
        plot.setLabelPaint(Color.BLACK);

        plot.setLabelLinkPaint(Color.BLACK);
        plot.setLabelLinkStyle(PieLabelLinkStyle.CUBIC_CURVE);
        plot.setLabelLinkStroke(new BasicStroke(2.0f));
        plot.setLabelOutlineStroke(new BasicStroke(2.0f));
        plot.setLabelOutlinePaint(Color.white);
        plot.setLabelBackgroundPaint(Color.WHITE);

        chart = new JFreeChart(null, JFreeChart.DEFAULT_TITLE_FONT, plot, true);
        chart.setBackgroundPaint(Color.WHITE);
        int width = 400;
        int height = 250;

        response.setContentType("image/png");
        OutputStream out = response.getOutputStream();
        ChartUtilities.writeChartAsPNG(out, chart, width, height);

    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException { // TODO Auto­generated method
                                                   // stub

        
    }

}