package com.evam.jfreechart;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfWriter;

public class SocialBuzzBenchMarketing  {
	
	private static CategoryDataset createDataset() {   
        
        // row keys...   
        String series1 = "Influence";   
        String series2 = "Sentiment";   
        
   
        // column keys...   
        String category1 = "Ford";   
        String category2 = "TATA";   
        String category3 = "Mahindra";   
      
   
        // create the dataset...   
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();   
   
        dataset.addValue(10, series1, category1);   
        dataset.addValue(25, series1, category2);   
        dataset.addValue(55, series1, category3);   
        
        dataset.addValue(4, series2, category1);   
        dataset.addValue(20, series2, category2);   
        dataset.addValue(60, series2, category3);   
         
   
        
        return dataset;   
           
    }   
	private static JFreeChart createChart() {   
        
        // create the chart...   
        JFreeChart chart = ChartFactory.createBarChart(   
            "Social Buzz Bench Marking",       // chart title   
            "",               // domain axis label   
            "",                  // range axis label   
            createDataset(),                  // data   
         PlotOrientation.VERTICAL, 
           //PlotOrientation.HORIZONTAL,// orientation   
            true,                    // include legend   
            true,                     // tooltips?   
            false                     // URLs?   
        );   
        chart.addSubtitle(new TextTitle("On X-Axis:Competitors"));
        chart.addSubtitle(new TextTitle("On Y-Axis:For Competitors Influence&Sentiment levels"));
        chart.setBackgroundPaint(Color.white);   
   
        // get a reference to the plot for further customisation...   
        CategoryPlot plot = (CategoryPlot) chart.getPlot();   
        plot.setBackgroundPaint(Color.white);   
        plot.setRangeGridlinePaint(Color.white);   
           
        // set the range axis to display integers only...   
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();   
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());   
        rangeAxis.setUpperMargin(0.15);   
           
        CategoryItemRenderer renderer = plot.getRenderer();   
        renderer.setItemLabelGenerator(   
                new StandardCategoryItemLabelGenerator());   
        renderer.setSeriesItemLabelsVisible(0, Boolean.TRUE);   
        renderer.setSeriesItemLabelsVisible(1, Boolean.TRUE);   
         
           
        CategoryAxis domainAxis = plot.getDomainAxis();   
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);   
           
        return chart;   
           
    }   
	public void create(OutputStream outputStream) throws DocumentException, IOException {
        Document document = null;
        PdfWriter writer = null;
         
        try {
            //instantiate document and writer
            document = new Document();
            writer = PdfWriter.getInstance(document, outputStream);
             
            //open document
            document.open();
        
            //add image
            int width = 500;
            int height = 500;
            JFreeChart chart = createChart();
            BufferedImage bufferedImage = chart.createBufferedImage(width, height);
            Image image = Image.getInstance(writer, bufferedImage, 1.0f);
            document.add(image);
             
            //release resources
            document.close();
            document = null;
             
            writer.close();
            writer = null;
        } catch(DocumentException de) {
            throw de;
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            //release resources
            if(null != document) {
                try { document.close(); }
                catch(Exception ex) { }
            }
             
            if(null != writer) {
                try { writer.close(); }
                catch(Exception ex) { }
            }
        }
    }
	
       
	
	public static void main(String[] args) throws FileNotFoundException, DocumentException, IOException {
        (new SocialBuzzBenchMarketing()).create(
                new FileOutputStream(
                        new File("D://Models//SocialBuzzBenchMarketing.pdf")));
      
}
}

