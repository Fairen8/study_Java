package Lessons.les16;

public class Car extends Transport {
    public Car(float _speed, int _weight, String _color, byte[] _coordinate) {
        super(_speed, _weight, _color, _coordinate);
    }

    @Override
    public void moveObject(float speed) {
        System.out.println("Наш объект двигается со скоростью: " + speed);
    }
    @Override
    public boolean stopObject() {
        this.speed = 0;
        return true;
    }


}
