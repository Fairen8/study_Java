package Lessons_2.Modules.Module_2.les4;

public class les4_1 {
    public static void main(String[] args) {
        BMW m5 = new BMW(true, "m5", 2500.5f, "Синий", true, (short) 200);

        m5.printAll();
        m5.startEngine();

        Audio ob = new Audio() { //Анонимный класс
            private boolean isWork;
            /*Он служит для реализации небольшого функционала для одного объекта
             и создаётся на основе вложенного класса*/

            public void isDrive() { //Реализация метода
                this.isWork = true;
                System.out.println("Тест анонимного класса");
            }
        };
        ob.isDrive();
    }

    private static class Audio {
        void isDrive() {} //Метод объявляется, но не реализуется
    }
}
