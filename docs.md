# Задание

Доработать программу из лабораторной работы №3, обновив релизацию объектной модели в соответствии с новой версией описания предметной области

**Программа должна удовлетворять следующим требованиям:**
1. В программе должны быть реализованы 2 собственных класса исключений (checked и unchecked), а также обработка исключений этих классов.
2. В программу необходимо добавить использование локальных, анонимных и вложенных классов (static и non-static).

**Порядок выполнения:**
1. Доработать объектную модель приложения.
2. Перерисовать диаграмму классов в соответствии с внесёнными в модель изменениями.
3. Согласовать с преподавателем изменения, внесённые в модель.
4. Модифицировать программу в соответствии с внесёнными в модель изменениями.


## Текст варианта

```
Окна «Оверлука» разлетелись. В бальном зале колпак, прикрывающий часы на каминной полке, треснул, развалился надвое и слетел на пол. Часы перестали тикать; зубчики, стерженьки, балансир замерли. Раздался то ли вздох, то ли шепот, вылетела большая туча пыли. В двести семнадцатом ванна вдруг раскололась пополам, выпустив немного зеленоватой, едко пахнущей воды. В президентском люксе вдруг вспыхнули обои. Двери бара «Колорадо» неожиданно сорвались с петель и свалились на пол столовой. Огонь попал под арку подвала на большие груды и стопки старых бумаг, и те вспыхнули, фыркая, как бенгальские огни. Кипящая вода извергалась на языки пламени, но не гасила их. Бумаги скручивались и чернели, как осенние листья, горящие под осиным гнездом. Топка взорвалась и разнесла потолочные балки подвала: ломаясь, они осыпались, как кости динозавра. Ничем не сдерживаемая газовая горелка, питавшая топку, взметнулась ревущим огненным столбом сквозь треснувший пол вестибюля. Ковровые дорожки на ступеньках лестницы загорелись и наперегонки погнали пламя к площадке второго этажа, как будто жаждали сообщить чрезвычайно приятное известие. Отель сотрясала канонада взрывов. В столовой с треском и звоном, сбивая столы, рухнула люстра — двухсотфунтовая хрустальная бомба. Пять труб «Оверлука» изрыгнули пламя к промоинам в тучах.

(Нет! Нельзя! Нельзя! НЕЛЬЗЯ!)

Существо визжало; визжало, но голоса уже не было — осталась лишь воющая паника, смерть и проклятия, слышные только ему одному; оно растворялось, лишаясь рассудка и воли; оно рвало паутину и искало, искало и не находило, выбираясь, выбираясь в, удирая, уходя в пустоту, в ничто, оно осыпалось…
```

# Разработанная модель

![Модель](uml-img.png)

# Исходный код программы

[Проект, выложенный на github](https://github.com/B0nBun/ProgrammingLab4)

# Результат программы

<pre>
[Jack Torrance, Creature] are in the room "basement"
Creature feels Fear
Creature feels Panic
Creature speaks as Jack Torrance: "Нельзя! О нет, нельзя!"
[Jack Torrance, Creature] transferred to "hallway"
[Jack Torrance, Creature] transferred to "boiler-room"
Creature speaks as Jack Torrance: "Нет, этого нельзя допустить!"
Creature speaks as Jack Torrance: "Нет! Нельзя! Нельзя! НЕЛЬЗЯ!"
"hotel-room #217" is damaged
The bath broke in two pieces
"basement" is damaged
The firebox exploded
The door flew off it's hinges
"boiler-room" is damaged
"hallway" is damaged
The door flew off it's hinges
"east-roof" is damaged
Overlook pipe #1 spew flames from "east-roof"
Overlook pipe #2 spew flames from "east-roof"
"west-roof" is damaged
Overlook pipe #1 spew flames from "west-roof"
Overlook pipe #2 spew flames from "west-roof"
Overlook pipe #3 spew flames from "west-roof"
Exception in thread "main" lib.exceptions.OverlookExplosionException: Boiler's pressure relieved from being too high!
        at lib.Boiler.relievePressure(Boiler.java:32)
        at lib.Boiler.use(Boiler.java:19)
        at lib.entities.JackTorrance.uses(JackTorrance.java:26)
        at lib.entities.Creature.uses(Creature.java:41)
        at Main.main(Main.java:101)
</pre>

# Выводы

В процессе выполнения этой лабораторной работы я ознакомился с исключениями в Java, способом их обработки и создания, а также их видами и отличиями. Также, я научился использовать и понимать внутренние классы, которые делятся на локальные (включая анонимные) и вложенные (статические и не статические). В дополнение ко всему этому, хоть и не на практике, но я изучил основы работы с рефлексией в Java.