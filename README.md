1. Реализуйте примитивную программу, печатающую строку на экране, таким образом, чтобы декларация выводимой строки находилась в пакете отличном от пакета основного класса программы.
2. «FizzBuzz». Реализовать программу, которая печатает на экране числа от 1 до 100. При этом вместо чисел кратных трем, программы должна выводить слово «Fizz», а вместо чисел, кратных пяти — слово «Buzz». Если число кратно пятнадцати, то программы должна выводить слово «FizzBuzz».
3. Реализовать консольную программу, которой через параметры командной строки передается целое число. Согласно этому числу генерировать  количество фигур и выводить на экран список генерации в формате:


    [Имя фигуры 1]
    <свойства фигуры> 
    ...
    [Имя фигуры N]
    <свойства фигуры>

При решении задачи каждую фигуру представить классом, для работы с генерированным списком использовать базовый полиморфный тип. Количество различных фигур не менее 5, фигуры должны иметь общие свойства (например, цвет, толщина контура и т. п.)
4. Реализовать консольную программу по редактированию каталога товаров со следующими операциями:

   * Добавить товар
   * Удалить товар
   * Вывести список товаров
   * Найти товар по наименованию

Хранить данные каталога в файле. Формат хранения придумать самому. Путь до файла хранения задавать в конфигурационном файле, также в конфигурации предусмотреть статические фильтры запрещенных товаров для добавления в каталог (регулярные выражения).

5. Реализовать свою иерархию исключений (не менее 3 классов глубиной). Написать код иллюстрирующий особенности порядка сопоставления исключений при их обработке. Написать код, который будет печатать stack-trace в консоль и в файл.
6. Реализовать утилитный класс для работы с исключениями. Предусмотреть следующие методы (при реализации использовать generics): 
   * Оборачивание checked исключения в RuntimeException. 
   * Печать stackTrace произвольного исключения в консоль. 
   * Печать stackTrace произвольного исключения в файл. 
   * Оборачивание произвольного количества исключений в RuntimeException c приоритетом следования, т.е. RuntimeException wrapToExChain(mainException, cause1… causeN).
7. Реализовать класс Box<A> (внутри массив заданной длинны, длину передавать через конструктор), предусмотреть следующие методы: 
   * put — положить в коробку элемент 
   * get — получить случайный элемент из коробки 
   * isEmpty — проверить что коробка пуста 
   * size — получить количество элементов в коробке 
   * remove — удалить элемент из коробки
8. Реализовать следующие имплементации интерфейса Stack<E>: 
   * LinkedStack (по аналогии с LinkedList, под капотом реализуемой имплементации LinkedList использовать нельзя) 
   * ArrayStack (по аналогии с ArrayList).
9. Реализовать класс ReflectionInfo<A> который инкапсулирует в себе информацию о Class<A> полученную через reflection, умеет печать в PrintStream форматированную информацию о полях, методах, конструкторах, умеет вызывать у заданного экземпляра класса A, по имени метода и переданным параметрам, указанный метод класса. Дизайн класса (сигнатуры методов) разработать самому.
10.	Реализовать специальный reverse collector, имплементация интерфейса java.util.stream.Collector, который собирает исходную коллекцию в коллекцию с обратным следованием элементов. Сперва сделать такой коллектор для Stack<E> из задания №4 (коллектор переворачивающий стэк), потом попытаться сделать универсальный коллектор, которому передавать в конструктор билдер (lambda-функцией) произвольной результирующей коллекции.