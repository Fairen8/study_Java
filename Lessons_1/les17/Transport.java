package Lessons_1.les17;
public abstract class Transport {
    protected float speed;
    private int weight;
    private String color;
    private byte[] coordinate;
    public Transport(float _speed, int _weight, String _color, byte[] _coordinate) {
        System.out.println("Object created");
        setValues(_speed, _weight, _color, _coordinate);
//        System.out.println(getValues());
    }

    public Transport(int weight , byte[] coordinate) {
        this.weight = weight;
        this.coordinate = coordinate;
//        System.out.println(this.getValues());


    }

    public abstract void moveObject(float speed);
    public abstract boolean stopObject();

    protected void setValues(float speed, int weight,String color, byte[] coordinate) {
        this.speed = speed;
        this.weight = weight;
        this.color = color;
        this.coordinate = coordinate;
    }

    protected String getValues() {
        String info = "Object speed: " + speed + "\nWeight: " + weight + "\nColor: " + color + "\n";
        String infoCordinates = "Coordonates:\n";
        for(int i = 0; i < coordinate.length; i++) {
            infoCordinates += coordinate[i] + "\n";
        }
        return info + infoCordinates;
    }

    class Engine {

        private boolean isReady;
        private int km;

        public void setValues(boolean isReady, int km) {
            this.isReady = isReady;
            this.km = km;
        }

        public void isReady(boolean isReady) {
            this.isReady = isReady;
        }

        public void info() {
            if (isReady)
                System.out.println("Двигатель исправен");
            else
                System.out.println("Нет, он не работает. Он проехал уже " + km + " km");
        }
    }

}
