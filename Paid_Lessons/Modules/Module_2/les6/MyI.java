package Paid_Lessons.Modules.Module_2.les6;

import java.lang.annotation.*;

/*Создание анотации
Указываем куда мы можем прикрепить нашу анотацию с помощью Target
Или не указываем и по умолчанию её можно прикрепить везде*/
@Inherited //Указываем что классы наследники унаследуют нашу анотацию
@Retention(RetentionPolicy.RUNTIME) //Указываем когда будет срабатывать анотация
public @interface MyI {
    int num() default 5; //Поле которое не обязательно указывать при создании анотации, тк. оно имеет значение по умолчанию
    String name();//Поле которое необходимо указать пр создании анотации
    float digit();

    enum Tupes {Basic, Middle, Hard};
    Tupes type();

}
