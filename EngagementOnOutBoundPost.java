package com.evam.jfreechart;


import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;


import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfWriter;

public class EngagementOnOutBoundPost {
	private static CategoryDataset createDataset1()
    {
        String s = "# Of Instances";
        String s1 = "Avg Engagement";
        String s2 = "All Brand Posts";
        String s3 = "macys";
        String s4 = "Fashion Star";
        String s5 = "Customer Service";
        String s6 = "Store";
        String s7 = "Shopping";
        String s8 = "Shop";
        String s9 = "Free";
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(66, s, s2);
        defaultcategorydataset.addValue(185, s, s3);
        defaultcategorydataset.addValue(43, s, s4);
        defaultcategorydataset.addValue(63, s, s5);
        defaultcategorydataset.addValue(176, s, s6);
        defaultcategorydataset.addValue(82, s, s7);
        defaultcategorydataset.addValue(167, s, s8);
        defaultcategorydataset.addValue(67, s, s9);
        defaultcategorydataset.addValue(null, s1, s2);
        defaultcategorydataset.addValue(null, s1, s3);
        defaultcategorydataset.addValue(null, s1, s4);
        defaultcategorydataset.addValue(null, s1, s5);
        defaultcategorydataset.addValue(null, s1, s6);
        defaultcategorydataset.addValue(null, s1, s7);
        defaultcategorydataset.addValue(null, s1, s8);
        defaultcategorydataset.addValue(null, s1, s9);
        return defaultcategorydataset;
    }

    private static CategoryDataset createDataset2()
    {
        String s = "# Of Instances";
        String s1 = "Avg Engagement";
        String s2 = "All Brand Posts";
        String s3 = "macys";
        String s4 = "Fashion Star";
        String s5 = "Customer Service";
        String s6 = "Store";
        String s7 = "Shopping";
        String s8 = "Shop";
        String s9 = "Free";
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(null, s, s2);
        defaultcategorydataset.addValue(null, s, s3);
        defaultcategorydataset.addValue(null, s, s4);
        defaultcategorydataset.addValue(null, s, s5);
        defaultcategorydataset.addValue(null, s, s6);
        defaultcategorydataset.addValue(null, s, s7);
        defaultcategorydataset.addValue(null, s, s8);
        defaultcategorydataset.addValue(null, s, s9);
        defaultcategorydataset.addValue(1768, s1, s2);
        defaultcategorydataset.addValue(0, s1, s3);
        defaultcategorydataset.addValue(444, s1, s4);
        defaultcategorydataset.addValue(0, s1, s5);
        defaultcategorydataset.addValue(27, s1, s6);
        defaultcategorydataset.addValue(92, s1, s7);
        defaultcategorydataset.addValue(69, s1, s8);
        defaultcategorydataset.addValue(357, s1, s9);
        return defaultcategorydataset;
    }

    private static JFreeChart createChart()
    {
        CategoryAxis categoryaxis = new CategoryAxis("");
        NumberAxis numberaxis = new NumberAxis("# Of Instance");
        BarRenderer  barrenderer = new BarRenderer();
        CategoryDataset categorydataset = null;
		CategoryPlot categoryplot = new CategoryPlot(categorydataset, categoryaxis, numberaxis, barrenderer) {

            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public LegendItemCollection getLegendItems()
            {
                LegendItemCollection legenditemcollection = new LegendItemCollection();
                CategoryDataset categorydataset2 = getDataset();
                if(categorydataset2 != null)
                {
                    CategoryItemRenderer categoryitemrenderer = getRenderer();
                    if(categoryitemrenderer != null)
                    {
                        org.jfree.chart.LegendItem legenditem = categoryitemrenderer.getLegendItem(0, 0);
                        legenditemcollection.add(legenditem);
                    }
                }
                CategoryDataset categorydataset3 = getDataset(1);
                if(categorydataset3 != null)
                {
                    CategoryItemRenderer categoryitemrenderer1 = getRenderer(1);
                    if(categoryitemrenderer1 != null)
                    {
                        org.jfree.chart.LegendItem legenditem1 = categoryitemrenderer1.getLegendItem(1, 1);
                        legenditemcollection.add(legenditem1);
                    }
                }
                return legenditemcollection;
            }

        };
        JFreeChart jfreechart = new JFreeChart("ENGAGEMENT ON OUTBOUND POSTS:KEYWORD ANALYSIS", categoryplot);
        jfreechart.setBackgroundPaint(Color.white);
        categoryplot.setBackgroundPaint(new Color(255, 255, 255));
        categoryplot.setDomainAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);
        categoryplot.setDataset(0, createDataset1());
        categoryplot.mapDatasetToRangeAxis(1, 1);
        CategoryAxis categoryaxis1 = categoryplot.getDomainAxis();
        categoryaxis1.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);
        
        NumberAxis numberaxis1 = new NumberAxis("Avg Engagemnt");
        categoryplot.setDataset(1, createDataset2());
        categoryplot.mapDatasetToRangeAxis(2,2);
        categoryplot.setRangeAxis(1, numberaxis1);
        categoryplot.setRangeAxisLocation(1, AxisLocation.BOTTOM_OR_RIGHT);
        BarRenderer barrenderer1 = new BarRenderer();
        categoryplot.setRenderer(1, barrenderer1);
        CategoryItemRenderer renderer1 = categoryplot.getRenderer();   
        renderer1.setItemLabelGenerator(   
                new StandardCategoryItemLabelGenerator());   
        renderer1.setSeriesItemLabelsVisible(0, Boolean.TRUE);    
        CategoryItemRenderer renderer = categoryplot.getRenderer(1);   
        renderer.setItemLabelGenerator(   
                new StandardCategoryItemLabelGenerator());   
        renderer.setSeriesItemLabelsVisible(1, Boolean.TRUE);    
        
       
     
     
        return jfreechart;
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
            int width = 550;
            int height = 550;
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
                try { writer.close();
                }
                catch(Exception ex) { }
            }
        }
    }
    public static void main(String[] args) throws FileNotFoundException, DocumentException, IOException {
        (new EngagementOnOutBoundPost()).create(
                new FileOutputStream(
                        new File("D://Models//EngagementOnOutBoundPost.pdf")));
      
}	
       
}
