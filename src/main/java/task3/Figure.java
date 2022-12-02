package task3;

public abstract class Figure {
    protected String name = "Фигура";
    protected Color fillColor = Color.BLACK;
    protected Double lineThickness = 1.0;

    public abstract Double getPerimeter();
    public abstract Double getArea();

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public Double getLineThickness() {
        return lineThickness;
    }

    public void setLineThickness(Double lineThickness) {
        this.lineThickness = lineThickness;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
