package com.trojasviejas.demo.form;

import com.trojasviejas.component.login.MessageErrorDialog;
import com.trojasviejas.data.dao.DashboardDao;
import com.trojasviejas.models.utility.InvoicesAverageReport;
import com.trojasviejas.swing.chart.Chart;
import com.trojasviejas.swing.chart.ChartModel;
import com.trojasviejas.swing.chart.LineChart;
import com.trojasviejas.swing.scroll.ScrollBar;
import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class FrmHome extends javax.swing.JPanel {

    public FrmHome() {
        initComponents();
        setOpaque(false);
        scroll.setVerticalScrollBar(new ScrollBar());
        scroll.getVerticalScrollBar().setBackground(Color.white);
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        scroll.getViewport().setBackground(Color.white);
        InitGaugeCharts(year);
        init();

        lblChartYearSelected.setText("" + year);
        lblLineChartYearSelected.setText("" + year);
    }
    //mensajes personalizados
    MessageErrorDialog errorMessage = new MessageErrorDialog(new JFrame());

    //obteniendo año actual
    int year = LocalDateTime.now().getYear();
    //obteniendo el mes actual
    int month = LocalDateTime.now().getMonthValue();

    DashboardDao dashboardDao = new DashboardDao();

    private void InitGaugeCharts(int year) {
        lblYear.setText("" + year);

        //primer año
        setReportDataByYearOneToCard(year);
        //segundo año
        setReportDataByYearTwoToCard(year - 1);
        //tercer año
        setReportDataByYearThreeToCard(year - 2);

        //colocando los promedios de los años anteriores al actual
        setAverages(year);

        //Colocando los porcentajes a los graficos si hay un promedio
        //FACTURAS
        setDataToChartOneInCard();
        //ARTICULOS
        setDataToChartTwoInCard();
        //VALOR TOTAL
        setDataToChartThreeInCard();

    }

    private void setReportDataByYearOneToCard(int year) {
        for (var i : dashboardDao.reportPurchases(year)) {
            //total de compras
            lblPurchaseYear1.setText(String.valueOf(year));
            lblAmountPurchaseYear1.setText(String.valueOf(i.getAmountPurchases()));
            //total de items
            lblItemsYear1.setText(String.valueOf(year));
            lblAmountItemsYear1.setText(String.valueOf(i.getAmountItems()));
            //valor total de las compras
            lblValueYear1.setText(String.valueOf(year));
            lblAmountValueYear1.setText("$" + String.valueOf(i.getValue()));
        }
    }

    private void setReportDataByYearTwoToCard(int year) {
        for (var i : dashboardDao.reportPurchases(year)) {
            //total de compras
            lblPurchaseYear2.setText(String.valueOf(year));
            lblAmountPurchaseYear2.setText(String.valueOf(i.getAmountPurchases()));
            //total de items
            lblItemsYear2.setText(String.valueOf(year));
            lblAmountItemsYear2.setText(String.valueOf(i.getAmountItems()));
            //valor total de las compras
            lblValueYear2.setText(String.valueOf(year));
            lblAmountValueYear2.setText("$" + String.valueOf(i.getValue()));
        }
    }

    private void setReportDataByYearThreeToCard(int year) {
        for (var i : dashboardDao.reportPurchases(year)) {
            //total de compras
            lblPurchaseYear3.setText(String.valueOf(year));
            lblAmountPurchaseYear3.setText(String.valueOf(i.getAmountPurchases()));
            //total de items
            lblItemsYear3.setText(String.valueOf(year));
            lblAmountItemsYear3.setText(String.valueOf(i.getAmountItems()));
            //valor total de las compras
            lblValueYear3.setText(String.valueOf(year));
            lblAmountValueYear3.setText("$" + String.valueOf(i.getValue()));
        }
    }

    private void setDataToChartOneInCard() {
        double percentPurchases;
        //si el valor promedio es distinto de 0, entonces hay un promedio en los years anteriores 
        //para obtener el pocentaje
        if (Double.parseDouble(lblAveragePurchases.getText()) > 0) {
            //obteniendo el  porcentaje de las compras del year actual respecto al promedio general por year
            percentPurchases = Double.parseDouble(lblAmountPurchaseYear1.getText()) / Double.parseDouble(lblAveragePurchases.getText());
            //como el porcentaje esta entre (0,1) se multiplica por 100, y se elevan al entero mas proximo porque 
            //en el grafico no acepta porcentajes con decimales
            gaugeChart1.setValueWithAnimation((int) Math.rint(percentPurchases * 100));
            //si las compras superan al promedio (pasan del 100%) obtenemos ese valor que sobrepasa y se muestra
            lblPercentPurchases.setText(overOneHundredPercent(percentPurchases * 100));
        } else {
            gaugeChart1.setValueWithAnimation(0);
        }
    }

    private void setDataToChartTwoInCard() {
        double percentItems;
        if (Double.parseDouble(lblAverageItems.getText()) > 0) {
            //obteniendo el porcentaje de las items del year actual respecto al promedio general por year
            percentItems = Double.parseDouble(lblAmountItemsYear1.getText()) / Double.parseDouble(lblAverageItems.getText());
            //como el porcentaje esta entre (0,1) se multiplica por 100, y se elevan al entero mas proximo porque 
            //en el grafico no acepta porcentajes con decimales
            gaugeChart2.setValueWithAnimation((int) Math.rint(percentItems * 100));
            //si el total de items superan al promedio (pasan del 100%) obtenemos ese valor que sobrepasa y se muestra
            lblPercentItems.setText(overOneHundredPercent(percentItems * 100));
        } else {
            gaugeChart2.setValueWithAnimation(0);
        }
    }

    private void setDataToChartThreeInCard() {
        if (getValueWithOutDollarSymbol(lblAverageValue.getText()) > 0) {
            //obteniendo el porcentaje de las valor total del year actual respecto al promedio general por year
            String percent3 = formatNumber.format(getValueWithOutDollarSymbol(lblAmountValueYear1.getText()) / getValueWithOutDollarSymbol(lblAverageValue.getText()));
            //como el porcentaje esta entre (0,1) se multiplica por 100, y se elevan al entero mas proximo porque 
            //en el grafico no acepta porcentajes con decimales
            gaugeChart3.setValueWithAnimation((int) Math.rint(Double.parseDouble(percent3) * 100));
            //si el valor total del year actual superan al promedio (pasan del 100%) obtenemos ese valor que sobrepasa y se muestra
            lblPercentValues.setText(overOneHundredPercent(Double.parseDouble(percent3) * 100));
        } else {
            gaugeChart3.setValueWithAnimation(0);
        }
    }

    DecimalFormat formatNumber = new DecimalFormat("0.00");
    int purchases = 0;
    int items = 0;
    double value = 0;

    private void setAverages(int year) {
        DashboardDao averageDao = new DashboardDao();

        //getAverage() retorna un array con los years en los que hay registros de facturas
        //getYears() retorna la lista de years menores al year actual en los que hay registros
        ArrayList<InvoicesAverageReport> averages = averageDao.getAverages(averageDao.getYears(year));
        int amountYears = averages.size();

        purchases = 0;
        items = 0;
        value = 0;

        //si amountYears > 0 es porque hay years anteriores al actual con facturas, por lo que 
        //se puede obtener un promedio
        if (amountYears > 0) {
            for (var i : averages) {
                purchases += i.getAmountPurchases();
                items += i.getAmountItems();
                value += i.getValue();
            }

            for (int i = 0; i < 1; i++) {
                lblAveragePurchases.setText(String.valueOf(formatNumber.format(purchases / (double) amountYears)));
                lblAverageItems.setText(String.valueOf(formatNumber.format(items / (double) amountYears)));
                lblAverageValue.setText("$" + String.valueOf(formatNumber.format(value / (double) amountYears)));
            }
        } else {
            //si no hay datos en years anteriores al actual los promedios
            lblAverageItems.setText("0");
            lblAveragePurchases.setText("0");
            lblAverageValue.setText("$0");
            // y de los promedios dependen los graficos de los card, que tambien se vuelven 0
        }

    }

    private String overOneHundredPercent(Double percent) {
        String valuePercent = " ";
        if (percent > 100.0) {
            valuePercent = "+" + String.valueOf(formatNumber.format(percent - 100)) + "%";
        }
        return valuePercent;
    }

    private double getValueWithOutDollarSymbol(String values) {
        return Double.parseDouble(values.substring(1, values.length()));
    }

    private void init() {

        barChart.addLegend("Entradas", new Color(12, 84, 175), new Color(0, 108, 247));
        barChart.addLegend("Artículos de entrada", new Color(54, 4, 143), new Color(104, 49, 200));
        barChart.addLegend("Salidas", new Color(5, 125, 0), new Color(95, 209, 69));
        barChart.addLegend("Artículos de salida", new Color(186, 37, 37), new Color(241, 100, 120));
        setDatatoChartOne();
        barChart.start();
        //txtCantidadEntradas.setBackground();

        lineChart.addLegend("Compras", new Color(12, 84, 175), new Color(0, 108, 247));
        lineChart.addLegend("Artículos", new Color(54, 4, 143), new Color(104, 49, 200));
        lineChart.addLegend("Costo", new Color(5, 125, 0), new Color(95, 209, 69));
        //lineChart.addLegend("Costo", new Color(186, 37, 37), new Color(241, 100, 120));
        setDatatoChartTwo(month, year);
        lineChart.start();
    }

    private void setDatatoChartOne() {
        for (var i : dashboardDao.getDataCharI(month, year)) {
            barChart.addData(new ChartModel(
                    i.getMonth().toString(),
                    new double[]{
                        i.getEntries(),
                        i.getAmountEntries(),
                        i.getOutputs(),
                        i.getAmountOutPuts()}));
        }

    }

    private void setDatatoChartTwo(int _month, int _year) {

        for (var i : dashboardDao.getDataCharII(_month, _year)) {
            lineChart.addData(new ChartModel(
                    i.getMonth().toString(),
                    new double[]{
                        i.getAmountPurchases(),
                        i.getAmountItems(),
                        i.getValue()}));
        }
    }

    public void reloadData() {
        InitGaugeCharts(year);
        updateChart(barChart, year, 0);
        updateLineChart(lineChart, year, 0);
        cbMonthRangeChart1.setSelectedIndex(-1);
        cbMonthRangeChart2.setSelectedIndex(-1);
    }

    private void updateChart(Chart chart, int year, int month) {
        lblChartYearSelected.setText("" + year);
        int _year = LocalDateTime.now().getYear();
        int _month = LocalDateTime.now().getMonthValue();
        if (month == 0) {
            if (year < _year) {
                _month = 12;
            }
        } else {
            _month = month;
        }
        int index = 0;
        for (var i : dashboardDao.getDataCharI(_month, year)) {
            chart.updateChart(index, new ChartModel(
                    i.getMonth().toString(),
                    new double[]{
                        i.getEntries(),
                        i.getAmountEntries(),
                        i.getOutputs(),
                        i.getAmountOutPuts()}));
            index++;
        }
        barChart.start();
    }

    private void updateLineChart(LineChart chart, int year, int month) {
        lblLineChartYearSelected.setText("" + year);
        int _year = LocalDateTime.now().getYear();
        int _month = LocalDateTime.now().getMonthValue();
        if (month == 0) {
            if (year < _year) {
                _month = 12;
            }
        } else {
            _month = month;
        }

        int index = 0;
        for (var i : dashboardDao.getDataCharII(_month, year)) {
            chart.updateLineChart(index, new ChartModel(
                    i.getMonth().toString(),
                    new double[]{
                        i.getAmountPurchases(),
                        i.getAmountItems(),
                        i.getValue()}));
            index++;
        }
        lineChart.start();
    }

    public void filterByStringSearch(String busqueda) {

        try {

            int yearSelected = Integer.parseInt(busqueda);
            //actualizando los datos tomando el year elejido
            //System.out.println(yearSelected);
            year = yearSelected;
            InitGaugeCharts(year);
            updateChart(barChart, year, 0);
            updateLineChart(lineChart, year, 0);
            cbMonthRangeChart1.setSelectedIndex(-1);
            cbMonthRangeChart2.setSelectedIndex(-1);

        } catch (Exception ex) {
            errorMessage.showMessage("Error", "Formato de busqueda no valido" + ex.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll = new javax.swing.JScrollPane();
        pnlBg = new javax.swing.JPanel();
        pnlCard = new com.trojasviejas.swing.panels.PanelShadow();
        gaugeChart1 = new com.trojasviejas.swing.chart.GaugeChart();
        lblAveragePurchases = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblPurchaseYear1 = new javax.swing.JLabel();
        lblAmountPurchaseYear1 = new javax.swing.JLabel();
        lblPurchaseYear2 = new javax.swing.JLabel();
        lblAmountPurchaseYear2 = new javax.swing.JLabel();
        lblPurchaseYear3 = new javax.swing.JLabel();
        lblAmountPurchaseYear3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblPercentPurchases = new javax.swing.JLabel();
        pnlCard1 = new com.trojasviejas.swing.panels.PanelShadow();
        gaugeChart2 = new com.trojasviejas.swing.chart.GaugeChart();
        lblAverageItems = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblItemsYear1 = new javax.swing.JLabel();
        lblAmountItemsYear1 = new javax.swing.JLabel();
        lblItemsYear2 = new javax.swing.JLabel();
        lblAmountItemsYear2 = new javax.swing.JLabel();
        lblItemsYear3 = new javax.swing.JLabel();
        lblAmountItemsYear3 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblPercentItems = new javax.swing.JLabel();
        pnlCard11 = new com.trojasviejas.swing.panels.PanelShadow();
        gaugeChart3 = new com.trojasviejas.swing.chart.GaugeChart();
        lblAverageValue = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        lblValueYear1 = new javax.swing.JLabel();
        lblAmountValueYear1 = new javax.swing.JLabel();
        lblValueYear2 = new javax.swing.JLabel();
        lblAmountValueYear2 = new javax.swing.JLabel();
        lblValueYear3 = new javax.swing.JLabel();
        lblAmountValueYear3 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblPercentValues = new javax.swing.JLabel();
        lblChartOne = new javax.swing.JLabel();
        lblReportYear = new javax.swing.JLabel();
        panelShadow1 = new com.trojasviejas.swing.panels.PanelShadow();
        lineChart = new com.trojasviejas.swing.chart.LineChart();
        lblChartTwo = new javax.swing.JLabel();
        panelShadow2 = new com.trojasviejas.swing.panels.PanelShadow();
        barChart = new com.trojasviejas.swing.chart.Chart();
        lblData3 = new javax.swing.JLabel();
        txtEntradas = new javax.swing.JTextField();
        lblData5 = new javax.swing.JLabel();
        txtCantidadEntradas = new javax.swing.JTextField();
        lblData4 = new javax.swing.JLabel();
        txtSalidas = new javax.swing.JTextField();
        lblData6 = new javax.swing.JLabel();
        txtCantidadSalidas = new javax.swing.JTextField();
        lblData7 = new javax.swing.JLabel();
        txtCompras = new javax.swing.JTextField();
        lblData8 = new javax.swing.JLabel();
        txtCantidadArticulos = new javax.swing.JTextField();
        lblData9 = new javax.swing.JLabel();
        txtCostoTotal = new javax.swing.JTextField();
        lblYear = new javax.swing.JLabel();
        lblChartYearSelected = new javax.swing.JLabel();
        lblLineChartYearSelected = new javax.swing.JLabel();
        cbMonthRangeChart2 = new com.trojasviejas.swing.ComboBox();
        cbMonthRangeChart1 = new com.trojasviejas.swing.ComboBox();

        setBackground(new java.awt.Color(232, 241, 242));

        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlBg.setBackground(new java.awt.Color(232, 241, 242));

        pnlCard.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));

        gaugeChart1.setColor1(new java.awt.Color(255, 255, 255));
        gaugeChart1.setColor2(new java.awt.Color(27, 152, 224));
        gaugeChart1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        gaugeChart1.setValue(50);

        lblAveragePurchases.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblAveragePurchases.setForeground(new java.awt.Color(150, 150, 150));
        lblAveragePurchases.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAveragePurchases.setText("0.0");
        lblAveragePurchases.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        lblAveragePurchases.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gaugeChart1.add(lblAveragePurchases);
        lblAveragePurchases.setBounds(20, 100, 80, 22);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(100, 100, 100));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Compras");

        lblPurchaseYear1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblPurchaseYear1.setForeground(new java.awt.Color(150, 150, 150));
        lblPurchaseYear1.setText("Diciembre");
        lblPurchaseYear1.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        lblAmountPurchaseYear1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblAmountPurchaseYear1.setForeground(new java.awt.Color(27, 152, 224));
        lblAmountPurchaseYear1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAmountPurchaseYear1.setText("$ 150.00");
        lblAmountPurchaseYear1.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        lblPurchaseYear2.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblPurchaseYear2.setForeground(new java.awt.Color(150, 150, 150));
        lblPurchaseYear2.setText("Enero");
        lblPurchaseYear2.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        lblAmountPurchaseYear2.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblAmountPurchaseYear2.setForeground(new java.awt.Color(27, 152, 224));
        lblAmountPurchaseYear2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAmountPurchaseYear2.setText("$ 200.00");
        lblAmountPurchaseYear2.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        lblPurchaseYear3.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblPurchaseYear3.setForeground(new java.awt.Color(150, 150, 150));
        lblPurchaseYear3.setText("Febrero");
        lblPurchaseYear3.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        lblAmountPurchaseYear3.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblAmountPurchaseYear3.setForeground(new java.awt.Color(27, 152, 224));
        lblAmountPurchaseYear3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAmountPurchaseYear3.setText("$ 100.00");
        lblAmountPurchaseYear3.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(100, 100, 100));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Promedio");

        lblPercentPurchases.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblPercentPurchases.setForeground(new java.awt.Color(183, 228, 41));
        lblPercentPurchases.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPercentPurchases.setText(" ");
        lblPercentPurchases.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        lblPercentPurchases.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlCardLayout = new javax.swing.GroupLayout(pnlCard);
        pnlCard.setLayout(pnlCardLayout);
        pnlCardLayout.setHorizontalGroup(
            pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gaugeChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCardLayout.createSequentialGroup()
                        .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPurchaseYear3, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                            .addComponent(lblPurchaseYear2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPurchaseYear1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
                        .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlCardLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lblAmountPurchaseYear1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCardLayout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(lblAmountPurchaseYear2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCardLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(lblAmountPurchaseYear3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(lblPercentPurchases, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCardLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlCardLayout.setVerticalGroup(
            pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel15))
                .addGap(10, 10, 10)
                .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(gaugeChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlCardLayout.createSequentialGroup()
                        .addComponent(lblPercentPurchases)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPurchaseYear1)
                            .addComponent(lblAmountPurchaseYear1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPurchaseYear2)
                            .addComponent(lblAmountPurchaseYear2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPurchaseYear3)
                            .addComponent(lblAmountPurchaseYear3))
                        .addGap(26, 26, 26))))
        );

        pnlCard1.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));

        gaugeChart2.setColor1(new java.awt.Color(255, 255, 255));
        gaugeChart2.setColor2(new java.awt.Color(248, 78, 78));
        gaugeChart2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        gaugeChart2.setValue(89);

        lblAverageItems.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblAverageItems.setForeground(new java.awt.Color(150, 150, 150));
        lblAverageItems.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAverageItems.setText("0.0");
        lblAverageItems.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        lblAverageItems.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gaugeChart2.add(lblAverageItems);
        lblAverageItems.setBounds(20, 100, 80, 22);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(100, 100, 100));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Artículos");

        lblItemsYear1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblItemsYear1.setForeground(new java.awt.Color(150, 150, 150));
        lblItemsYear1.setText("Diciembre");
        lblItemsYear1.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        lblAmountItemsYear1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblAmountItemsYear1.setForeground(new java.awt.Color(248, 78, 78));
        lblAmountItemsYear1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAmountItemsYear1.setText("$ 150.00");
        lblAmountItemsYear1.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        lblItemsYear2.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblItemsYear2.setForeground(new java.awt.Color(150, 150, 150));
        lblItemsYear2.setText("Enero");
        lblItemsYear2.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        lblAmountItemsYear2.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblAmountItemsYear2.setForeground(new java.awt.Color(248, 78, 78));
        lblAmountItemsYear2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAmountItemsYear2.setText("$ 200.00");
        lblAmountItemsYear2.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        lblItemsYear3.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblItemsYear3.setForeground(new java.awt.Color(150, 150, 150));
        lblItemsYear3.setText("Febrero");
        lblItemsYear3.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        lblAmountItemsYear3.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblAmountItemsYear3.setForeground(new java.awt.Color(248, 78, 78));
        lblAmountItemsYear3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAmountItemsYear3.setText("$ 100.00");
        lblAmountItemsYear3.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(100, 100, 100));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Promedio");

        lblPercentItems.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblPercentItems.setForeground(new java.awt.Color(183, 228, 41));
        lblPercentItems.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPercentItems.setText(" ");
        lblPercentItems.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        lblPercentItems.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlCard1Layout = new javax.swing.GroupLayout(pnlCard1);
        pnlCard1.setLayout(pnlCard1Layout);
        pnlCard1Layout.setHorizontalGroup(
            pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gaugeChart2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard1Layout.createSequentialGroup()
                        .addGroup(pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblItemsYear3, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                            .addComponent(lblItemsYear2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblItemsYear1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
                        .addGroup(pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlCard1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lblAmountItemsYear1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard1Layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(lblAmountItemsYear2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(lblAmountItemsYear3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(lblPercentItems, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlCard1Layout.setVerticalGroup(
            pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel16))
                .addGap(12, 12, 12)
                .addGroup(pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(gaugeChart2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlCard1Layout.createSequentialGroup()
                        .addComponent(lblPercentItems)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblItemsYear1)
                            .addComponent(lblAmountItemsYear1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblItemsYear2)
                            .addComponent(lblAmountItemsYear2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblItemsYear3)
                            .addComponent(lblAmountItemsYear3))
                        .addGap(26, 26, 26))))
        );

        pnlCard11.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));

        gaugeChart3.setColor1(new java.awt.Color(255, 255, 255));
        gaugeChart3.setColor2(new java.awt.Color(27, 152, 224));
        gaugeChart3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        gaugeChart3.setValue(15);

        lblAverageValue.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblAverageValue.setForeground(new java.awt.Color(150, 150, 150));
        lblAverageValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAverageValue.setText("0.0");
        lblAverageValue.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        lblAverageValue.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gaugeChart3.add(lblAverageValue);
        lblAverageValue.setBounds(20, 100, 80, 22);

        jLabel78.setBackground(new java.awt.Color(255, 255, 255));
        jLabel78.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(100, 100, 100));
        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel78.setText("Costo Total");

        lblValueYear1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblValueYear1.setForeground(new java.awt.Color(150, 150, 150));
        lblValueYear1.setText("Diciembre");
        lblValueYear1.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        lblAmountValueYear1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblAmountValueYear1.setForeground(new java.awt.Color(27, 152, 224));
        lblAmountValueYear1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAmountValueYear1.setText("$ 150.00");
        lblAmountValueYear1.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        lblValueYear2.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblValueYear2.setForeground(new java.awt.Color(150, 150, 150));
        lblValueYear2.setText("Enero");
        lblValueYear2.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        lblAmountValueYear2.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblAmountValueYear2.setForeground(new java.awt.Color(27, 152, 224));
        lblAmountValueYear2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAmountValueYear2.setText("$ 200.00");
        lblAmountValueYear2.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        lblValueYear3.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblValueYear3.setForeground(new java.awt.Color(150, 150, 150));
        lblValueYear3.setText("Febrero");
        lblValueYear3.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        lblAmountValueYear3.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblAmountValueYear3.setForeground(new java.awt.Color(27, 152, 224));
        lblAmountValueYear3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAmountValueYear3.setText("$ 100.00");
        lblAmountValueYear3.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(100, 100, 100));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Promedio");

        lblPercentValues.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblPercentValues.setForeground(new java.awt.Color(183, 228, 41));
        lblPercentValues.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPercentValues.setText(" ");
        lblPercentValues.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        lblPercentValues.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlCard11Layout = new javax.swing.GroupLayout(pnlCard11);
        pnlCard11.setLayout(pnlCard11Layout);
        pnlCard11Layout.setHorizontalGroup(
            pnlCard11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gaugeChart3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(pnlCard11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard11Layout.createSequentialGroup()
                        .addGroup(pnlCard11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblValueYear3, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                            .addComponent(lblValueYear2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblValueYear1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
                        .addGroup(pnlCard11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCard11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlCard11Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lblAmountValueYear1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard11Layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(lblAmountValueYear2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard11Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(lblAmountValueYear3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(lblPercentValues, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard11Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlCard11Layout.setVerticalGroup(
            pnlCard11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCard11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel78)
                    .addComponent(jLabel17))
                .addGap(10, 10, 10)
                .addGroup(pnlCard11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(gaugeChart3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlCard11Layout.createSequentialGroup()
                        .addComponent(lblPercentValues)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCard11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblValueYear1)
                            .addComponent(lblAmountValueYear1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCard11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblValueYear2)
                            .addComponent(lblAmountValueYear2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCard11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblValueYear3)
                            .addComponent(lblAmountValueYear3))
                        .addGap(26, 26, 26))))
        );

        lblChartOne.setFont(new java.awt.Font("Norwester", 0, 18)); // NOI18N
        lblChartOne.setForeground(new java.awt.Color(27, 152, 224));
        lblChartOne.setText("Grafico de Entradas y Salidas");

        lblReportYear.setFont(new java.awt.Font("Norwester", 0, 18)); // NOI18N
        lblReportYear.setForeground(new java.awt.Color(27, 152, 224));
        lblReportYear.setText("Informe de compras");

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lineChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(lineChart, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        lblChartTwo.setFont(new java.awt.Font("Norwester", 0, 18)); // NOI18N
        lblChartTwo.setForeground(new java.awt.Color(27, 152, 224));
        lblChartTwo.setText("Grafico de Compras");

        panelShadow2.setAutoscrolls(true);

        barChart.setAutoscrolls(true);

        javax.swing.GroupLayout panelShadow2Layout = new javax.swing.GroupLayout(panelShadow2);
        panelShadow2.setLayout(panelShadow2Layout);
        panelShadow2Layout.setHorizontalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(barChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );
        panelShadow2Layout.setVerticalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(barChart, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        lblData3.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblData3.setForeground(new java.awt.Color(0, 100, 148));
        lblData3.setText("Entradas");

        txtEntradas.setEditable(false);
        txtEntradas.setBackground(new java.awt.Color(0, 108, 247));
        txtEntradas.setBorder(null);

        lblData5.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblData5.setForeground(new java.awt.Color(0, 100, 148));
        lblData5.setText("Artículos de entrada");

        txtCantidadEntradas.setEditable(false);
        txtCantidadEntradas.setBackground(new java.awt.Color(104, 49, 200));
        txtCantidadEntradas.setBorder(null);

        lblData4.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblData4.setForeground(new java.awt.Color(0, 100, 148));
        lblData4.setText("Salidas");

        txtSalidas.setEditable(false);
        txtSalidas.setBackground(new java.awt.Color(95, 209, 69));
        txtSalidas.setBorder(null);

        lblData6.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblData6.setForeground(new java.awt.Color(0, 100, 148));
        lblData6.setText("Artículos de salida");

        txtCantidadSalidas.setEditable(false);
        txtCantidadSalidas.setBackground(new java.awt.Color(241, 100, 120));
        txtCantidadSalidas.setBorder(null);

        lblData7.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblData7.setForeground(new java.awt.Color(0, 100, 148));
        lblData7.setText("Compras");

        txtCompras.setEditable(false);
        txtCompras.setBackground(new java.awt.Color(0, 108, 247));
        txtCompras.setBorder(null);

        lblData8.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblData8.setForeground(new java.awt.Color(0, 100, 148));
        lblData8.setText("Cantidad de artículos");

        txtCantidadArticulos.setEditable(false);
        txtCantidadArticulos.setBackground(new java.awt.Color(104, 49, 200));
        txtCantidadArticulos.setBorder(null);

        lblData9.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblData9.setForeground(new java.awt.Color(0, 100, 148));
        lblData9.setText("Costo total");

        txtCostoTotal.setEditable(false);
        txtCostoTotal.setBackground(new java.awt.Color(95, 209, 69));
        txtCostoTotal.setBorder(null);

        lblYear.setFont(new java.awt.Font("Norwester", 0, 18)); // NOI18N
        lblYear.setForeground(new java.awt.Color(27, 152, 224));
        lblYear.setText("0000");

        lblChartYearSelected.setFont(new java.awt.Font("Norwester", 0, 18)); // NOI18N
        lblChartYearSelected.setForeground(new java.awt.Color(27, 152, 224));
        lblChartYearSelected.setText("0000");

        lblLineChartYearSelected.setFont(new java.awt.Font("Norwester", 0, 18)); // NOI18N
        lblLineChartYearSelected.setForeground(new java.awt.Color(27, 152, 224));
        lblLineChartYearSelected.setText("0000");

        cbMonthRangeChart2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero - Junio", "Julio - Diciembre" }));
        cbMonthRangeChart2.setSelectedIndex(-1);
        cbMonthRangeChart2.setToolTipText("Indica el rango de meses en los que se filtrarán los datos");
        cbMonthRangeChart2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cbMonthRangeChart2.setLabeText("Seleccione rango");
        cbMonthRangeChart2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMonthRangeChart2ActionPerformed(evt);
            }
        });

        cbMonthRangeChart1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero - Junio", "Julio - Diciembre" }));
        cbMonthRangeChart1.setSelectedIndex(-1);
        cbMonthRangeChart1.setToolTipText("Indica el rango de meses en los que se filtrarán los datos");
        cbMonthRangeChart1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cbMonthRangeChart1.setLabeText("Seleccione rango");
        cbMonthRangeChart1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMonthRangeChart1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBgLayout = new javax.swing.GroupLayout(pnlBg);
        pnlBg.setLayout(pnlBgLayout);
        pnlBgLayout.setHorizontalGroup(
            pnlBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBgLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBgLayout.createSequentialGroup()
                        .addGroup(pnlBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBgLayout.createSequentialGroup()
                                .addComponent(lblChartTwo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblLineChartYearSelected)
                                .addGap(18, 18, 18)
                                .addComponent(cbMonthRangeChart2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnlBgLayout.createSequentialGroup()
                                .addGroup(pnlBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(panelShadow1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(panelShadow2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(3, 3, 3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBgLayout.createSequentialGroup()
                                .addComponent(pnlCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pnlCard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pnlCard11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34))
                    .addGroup(pnlBgLayout.createSequentialGroup()
                        .addGroup(pnlBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBgLayout.createSequentialGroup()
                                .addComponent(lblData3)
                                .addGap(10, 10, 10)
                                .addComponent(txtEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(lblData5)
                                .addGap(10, 10, 10)
                                .addComponent(txtCantidadEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(lblData4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(lblData6)
                                .addGap(10, 10, 10)
                                .addComponent(txtCantidadSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlBgLayout.createSequentialGroup()
                                .addComponent(lblData7)
                                .addGap(10, 10, 10)
                                .addComponent(txtCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(lblData8)
                                .addGap(10, 10, 10)
                                .addComponent(txtCantidadArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(lblData9)
                                .addGap(10, 10, 10)
                                .addComponent(txtCostoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlBgLayout.createSequentialGroup()
                                .addComponent(lblReportYear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblYear)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlBgLayout.createSequentialGroup()
                        .addComponent(lblChartOne)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblChartYearSelected)
                        .addGap(18, 18, 18)
                        .addComponent(cbMonthRangeChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlBgLayout.setVerticalGroup(
            pnlBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBgLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnlBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblReportYear)
                    .addComponent(lblYear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlCard11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(pnlBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblChartOne)
                    .addComponent(lblChartYearSelected)
                    .addComponent(cbMonthRangeChart1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelShadow2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblData3)
                    .addComponent(lblData4)
                    .addComponent(lblData5)
                    .addComponent(lblData6)
                    .addComponent(txtEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidadEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidadSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(pnlBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblChartTwo)
                    .addComponent(lblLineChartYearSelected)
                    .addComponent(cbMonthRangeChart2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblData7)
                    .addComponent(lblData9)
                    .addComponent(lblData8)
                    .addComponent(txtCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCostoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidadArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        scroll.setViewportView(pnlBg);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 1065, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbMonthRangeChart2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMonthRangeChart2ActionPerformed
        if (cbMonthRangeChart2.getSelectedIndex() != -1) {
            if (cbMonthRangeChart2.getSelectedIndex() == 0) {
                updateLineChart(lineChart, year, 6);
            } else {
                updateLineChart(lineChart, year, 12);
            }
        }
    }//GEN-LAST:event_cbMonthRangeChart2ActionPerformed

    private void cbMonthRangeChart1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMonthRangeChart1ActionPerformed
        if (cbMonthRangeChart1.getSelectedIndex() != -1) {
            if (cbMonthRangeChart1.getSelectedIndex() == 0) {
                updateChart(barChart, year, 6);
            } else {
                updateChart(barChart, year, 12);
            }
        }
    }//GEN-LAST:event_cbMonthRangeChart1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.trojasviejas.swing.chart.Chart barChart;
    private com.trojasviejas.swing.ComboBox cbMonthRangeChart1;
    private com.trojasviejas.swing.ComboBox cbMonthRangeChart2;
    private com.trojasviejas.swing.chart.GaugeChart gaugeChart1;
    private com.trojasviejas.swing.chart.GaugeChart gaugeChart2;
    private com.trojasviejas.swing.chart.GaugeChart gaugeChart3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblAmountItemsYear1;
    private javax.swing.JLabel lblAmountItemsYear2;
    private javax.swing.JLabel lblAmountItemsYear3;
    private javax.swing.JLabel lblAmountPurchaseYear1;
    private javax.swing.JLabel lblAmountPurchaseYear2;
    private javax.swing.JLabel lblAmountPurchaseYear3;
    private javax.swing.JLabel lblAmountValueYear1;
    private javax.swing.JLabel lblAmountValueYear2;
    private javax.swing.JLabel lblAmountValueYear3;
    private javax.swing.JLabel lblAverageItems;
    private javax.swing.JLabel lblAveragePurchases;
    private javax.swing.JLabel lblAverageValue;
    private javax.swing.JLabel lblChartOne;
    private javax.swing.JLabel lblChartTwo;
    private javax.swing.JLabel lblChartYearSelected;
    private javax.swing.JLabel lblData3;
    private javax.swing.JLabel lblData4;
    private javax.swing.JLabel lblData5;
    private javax.swing.JLabel lblData6;
    private javax.swing.JLabel lblData7;
    private javax.swing.JLabel lblData8;
    private javax.swing.JLabel lblData9;
    private javax.swing.JLabel lblItemsYear1;
    private javax.swing.JLabel lblItemsYear2;
    private javax.swing.JLabel lblItemsYear3;
    private javax.swing.JLabel lblLineChartYearSelected;
    private javax.swing.JLabel lblPercentItems;
    private javax.swing.JLabel lblPercentPurchases;
    private javax.swing.JLabel lblPercentValues;
    private javax.swing.JLabel lblPurchaseYear1;
    private javax.swing.JLabel lblPurchaseYear2;
    private javax.swing.JLabel lblPurchaseYear3;
    private javax.swing.JLabel lblReportYear;
    private javax.swing.JLabel lblValueYear1;
    private javax.swing.JLabel lblValueYear2;
    private javax.swing.JLabel lblValueYear3;
    private javax.swing.JLabel lblYear;
    private com.trojasviejas.swing.chart.LineChart lineChart;
    private com.trojasviejas.swing.panels.PanelShadow panelShadow1;
    private com.trojasviejas.swing.panels.PanelShadow panelShadow2;
    private javax.swing.JPanel pnlBg;
    private com.trojasviejas.swing.panels.PanelShadow pnlCard;
    private com.trojasviejas.swing.panels.PanelShadow pnlCard1;
    private com.trojasviejas.swing.panels.PanelShadow pnlCard11;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextField txtCantidadArticulos;
    private javax.swing.JTextField txtCantidadEntradas;
    private javax.swing.JTextField txtCantidadSalidas;
    private javax.swing.JTextField txtCompras;
    private javax.swing.JTextField txtCostoTotal;
    private javax.swing.JTextField txtEntradas;
    private javax.swing.JTextField txtSalidas;
    // End of variables declaration//GEN-END:variables
}
