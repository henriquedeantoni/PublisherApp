package gui.util;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class OccurrenceData {
	
    private final IntegerProperty qtdOcorrencias;
    private final IntegerProperty num1;
    private final IntegerProperty num2;
    private final IntegerProperty num3;
    private final IntegerProperty num4;

    public OccurrenceData(int qtdOcorrencias, int num1, int num2, int num3) {
        this.qtdOcorrencias = new SimpleIntegerProperty(qtdOcorrencias);
        this.num1 = new SimpleIntegerProperty(num1);
        this.num2 = new SimpleIntegerProperty(num2);
        this.num3 = new SimpleIntegerProperty(num3);
        this.num4 = new SimpleIntegerProperty(0);
    }
    
    public OccurrenceData(int qtdOcorrencias, int num1, int num2, int num3, int num4) {
        this.qtdOcorrencias = new SimpleIntegerProperty(qtdOcorrencias);
        this.num1 = new SimpleIntegerProperty(num1);
        this.num2 = new SimpleIntegerProperty(num2);
        this.num3 = new SimpleIntegerProperty(num3);
        this.num4 = new SimpleIntegerProperty(num4);
    }

    public int getQtdOcorrencias() { return qtdOcorrencias.get(); }
    public IntegerProperty qtdOcorrenciasProperty() { return qtdOcorrencias; }

    public int getNum1() { return num1.get(); }
    public IntegerProperty num1Property() { return num1; }

    public int getNum2() { return num2.get(); }
    public IntegerProperty num2Property() { return num2; }

    public int getNum3() { return num3.get(); }
    public IntegerProperty num3Property() { return num3; }

    public int getNum4() { return num4.get(); }
    public IntegerProperty num4Property() { return num4; }
}
