package Free_Lessons.les12;
//ООП: классы и объекты
//Транспорт
public class Transport {
    public float speed;
    public int weight;
    public String color;
    public byte[] coordinate;

    public void setValues(float _speed, int _weight,String _color, byte[] _coordinate) {
        speed = _speed;
        weight = _weight;
        color = _color;
        coordinate = _coordinate;
    }

    public String getValues() {
        String info = "Object speed: " + speed + "\nWeight: " + weight + "\nColor: " + color + "\n";
        String infoCordinates = "Coordonates:\n";
        for(int i = 0; i < coordinate.length; i++) {
            infoCordinates += coordinate[i] + "\n";
        }
        return info + infoCordinates;
    }

}
