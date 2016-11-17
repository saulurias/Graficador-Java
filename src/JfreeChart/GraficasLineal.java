package JfreeChart;

import java.awt.BorderLayout;
import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class GraficasLineal {

    public void Graficar() {
        XYSeries series = new XYSeries("Tipo A");
        XYSeries seriesB = new XYSeries("Tipo B");
        // Introduccion de datos
        
        for (int i = 0; i < 10; i++) {
            series.add(i,(i*i)*3);
            
        }
       
        /*
        series.add(-2, 1);
        series.add(2, -13);
        series.add(3, 20);
        series.add(4, 8);
        series.add(5, -30);
        series.add(6, 15);

        seriesB.add(1, 5);
        seriesB.add(2, -20);
        seriesB.add(3, 12);
        seriesB.add(4, 35);
        seriesB.add(5, 10);
        seriesB.add(6, -40);
*/

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        dataset.addSeries(seriesB);
        // Generamos la grafica     
        JFreeChart chart = ChartFactory.createXYLineChart(
                "GetCode - Gráfica Lineal",// Titulo           
                "Tiempo",// etiqueta coordenada X    
                "Cantidad de ventas",// tiqueta coordenada Y   
                dataset,// los datos guardados     
                PlotOrientation.VERTICAL,// modo de grafica HORIZANTAL o VERTICAL    
                false,// motrar leyenda en la gráfica 
                true,// Use tooltips      
                true // Configurar chart   daniel ipanaque
                );

        //personalización del grafico 
        XYPlot xyplot = (XYPlot) chart.getPlot();
        xyplot.setBackgroundPaint(new Color(255, 255, 255));
        xyplot.setDomainGridlinePaint(new Color(36, 45, 54));
        xyplot.setRangeGridlinePaint(new Color(36, 45, 54));
        chart.setBackgroundPaint(new Color(255, 255, 255));
        chart.getTitle().setPaint(new Color(102, 102, 102));

        //Pinta los puntos guardados
        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) xyplot.getRenderer();
        configurarRendered(renderer); // cambiamos color a las lineas
        renderer.setBaseShapesVisible(true);
        // muestra los valores de cada punto XY
        XYItemLabelGenerator xy = new StandardXYItemLabelGenerator();
        renderer.setBaseItemLabelGenerator(xy);
        renderer.setBaseItemLabelsVisible(true);
        renderer.setBaseLinesVisible(true);

        final ChartPanel barPanel = new ChartPanel(chart);
        // barPanel.setMouseZoomable(false);  // esta linea es para bloquear acnes del mouse en la gráfica

        FormularioChart.PanelGraficar.removeAll();
        FormularioChart.PanelGraficar.add(barPanel, BorderLayout.CENTER);
        FormularioChart.PanelGraficar.validate();

    }

    private void configurarRendered(XYLineAndShapeRenderer renderer) {

        renderer.setSeriesPaint(0, new Color(43, 119, 209));
        renderer.setSeriesPaint(1, new Color(238, 132, 132));

    }
}
