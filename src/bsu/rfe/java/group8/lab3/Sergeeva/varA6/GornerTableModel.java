package bsu.rfe.java.group8.lab3.Sergeeva.varA6;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class GornerTableModel extends AbstractTableModel {

    private Double[] coefficients;
    private Double from;
    private Double to;
    private Double step;

    public GornerTableModel(Double from, Double to, Double step, Double[] coefficients) {
        this.from = from;
        this.to = to;
        this.step = step;
        this.coefficients = coefficients;
    }

    public Double getFrom() {
        return from;
    }
    public Double getTo() {
        return to;
    }
    public Double getStep() {
        return step;
    }
    public int getColumnCount() {
        return 2;
    }
    public int getRowCount() {
        return  (int) Math.ceil((to-from)/step) + 1;
    }

    public Object getValueAt(int row, int col) {            // возвращает содержимое ячейки таблицы
        double x = from + step*row;
        if (col==0) {
            return x;
        } else {
            Double result = coefficients[0];
            for (int i = 1; i < coefficients.length; i++) {   // типо перфый коэффициент мы (допустим) 6 раз умножим на х, 2 - на 5 и тд
                result = result * x + coefficients[i];
            }
            return result;
        }
    }

    public String getColumnName(int col) {
        switch (col) {
            case 0:
                return "Значение X";
            default:
                return "Значение многочлена";
        }
    }

    public Class<?> getColumnClass(int col) {
        return Double.class;
    }
}
