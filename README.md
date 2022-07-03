# Программа сортировки большого текстового файла

## Описание программы
Программа позволяет выполнить построчную сортировку большого текстового файла, не влезающего в оперативную память.
Размер требуемой памяти не зависит от размера файла.

Длина строки разумная, одна строка сильно меньше чем объем памяти.

Для проверки работоспособности используется генератор таких файлов, принимающий в качестве параметров количество строк и их минимальную и максимальную длину.

### Пример работы сортировки файла
Строки в файле до сортировки:
```
bcddd36352a
abcdd33562f
fgyyyz378
fghhhh456
```

После сортировки:
```
abcdd33562f
bcddd36352a
fghhhh456
fgyyyz378
```