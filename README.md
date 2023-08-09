# OssCocktail
OssCocktail - отборочное задание **SURF SUMMER SCHOOL 2023**.<br> 
**P.s.** _Да, я осознаю, что протащил опечатку по всему проекту (Coc**K**tail)_

### Preview
<p>
  <img src="data/empty_cocktails_list.gif" width="32%"/>
  <img src="data/cocktails_list.gif" width="32%"/>
</p>

## Feature implementation status (per screen)
* Пустой список коктейлей
  * Дизайн - 100%
  * Функциональность - 0% _(отсутствие перехода на экран "Создания коктейля")_
* Список коктейлей (с данными)
  * Дизайн - 80% _(добавить округления в BottomBar, скорректировать поведение с целью переиспользования View на экране "Пустой список коктейлей")_
  * Функциональность - 0% _(отсутствие перехода на экран "Создания коктейля", перехода на экран "Детали коктейля")_
* Детали коктейля
  * Дизайн - 15% _(задан styling согласно M3 в модулях **:core_ui:theme**, **:core_ui:presentation**)_
  * Функциональность - 40% _(развернут модули **:services:data**, **:services:storage**. Репозитотрий данных и Источники данных( Обёртка над MediaStore, БД для сохранения локального списка коктейлей)_
* Создание коктейля
  * Дизайн - 15% _(задан styling согласно M3 в модулях **:core_ui:theme**, **:core_ui:presentation**)_
  * Функциональность - 40% _(развернут модули **:services:data**, **:services:storage**. Репозитотрий данных и Источники данных( Обёртка над MediaStore, БД для сохранения локального списка коктейлей)_
    
## Libraries
* **DI**
  * [Dagger 2](https://mvnrepository.com/artifact/com.google.dagger/dagger)
  * [Dagger 2 Compiler](https://mvnrepository.com/artifact/com.google.dagger/dagger-compiler)
* **DB** 
  * [Room Runtime](https://mvnrepository.com/artifact/androidx.room/room-runtime)
  * [Room Compiler](https://mvnrepository.com/artifact/androidx.room/room-compiler)
  * [Room Ktx](https://mvnrepository.com/artifact/androidx.room/room-ktx)
* **Navigation**
  * [Cicerone](https://mvnrepository.com/artifact/com.github.terrakok/cicerone)  - _уже горели сроки ;)_
* **Asynchronous**
  * [Coroutines Core](https://mvnrepository.com/artifact/org.jetbrains.kotlinx/kotlinx-coroutines-core)
* **Additional**
  * [Timber](https://mvnrepository.com/artifact/com.jakewharton.timber/timber/4.7.1)
  * [Glide](https://mvnrepository.com/artifact/com.github.bumptech.glide/glide) - _нужно определить политику кэширования_
  * [Fragment Kotlin Extensions](https://mvnrepository.com/artifact/androidx.fragment/fragment-ktx)
  * [Activity Kotlin Extensions](https://mvnrepository.com/artifact/androidx.activity/activity-ktx)
  * [Android Support RecyclerView](https://mvnrepository.com/artifact/androidx.recyclerview/recyclerview)
  * [LifeCycle Runtime](https://mvnrepository.com/artifact/androidx.lifecycle/lifecycle-runtime-ktx)
  * [LifeCycle Viewmodel](https://mvnrepository.com/artifact/androidx.lifecycle/lifecycle-viewmodel-ktx)

## Architecture
// TODO show picture

## Conclusions
1. Концентрируйся на требованиях, не стоит везде пытаться сделать хорошо. _"Удобнее"_, _"надёжнее"_ не всегда правильные слова , когда речь идёт о сжатых сроках.
2. Погружаясь в бэк часть приложения, не забывай поддерживать знания UI части _(немного заскрежетали мозги на BottomBar поведении с целью переиспользования View)_
3. Каждая неудача - урок сделать что-то лучше в будущем ;)
4. Кажется пора купить новый телефон, моя максимальная Android версия для локального тестирования - **Adnroid 9** _(симпатичные анимации в **Andtoid 13**)_
