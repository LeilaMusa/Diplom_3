# Diplom_3

## Стэк:
* Язык: Java 11
* Система сборки: Maven
* Тестирование: JUnit 4, Selenium WebDriver, Rest-Assured
* Генерация отчетов: Allure (Allure JUnit4, Allure Rest-Assured, Allure Maven Plugin)
* Генерация тестовых данных: JavaFaker
* AOP: AspectJ (AspectJ Weaver)

Задание: протестировать веб-приложение Stellar Burgers

## Тестовые сценарии
1. Регистрация:
*  Успешную регистрацию.
*  Ошибку для некорректного пароля. Минимальный пароль — шесть символов.
2. Вход:
* вход по кнопке «Войти в аккаунт» на главной,
* вход через кнопку «Личный кабинет»,
* вход через кнопку в форме регистрации,
* вход через кнопку в форме восстановления пароля. 
3. Переход в личный кабинет по клику на «Личный кабинет».
4. Переход из личного кабинета в конструктор:
* по клику на «Конструктор», 
* по клику на логотип Stellar Burgers.
5. Выход из аккаунта по кнопке «Выйти» в личном кабинете.
6. Раздел «Конструктор», что работают переходы к разделам:
* «Булки»,
* «Соусы»,
* «Начинки».
7. Отчёт Allure

## Запуск тестов
* Чтобы запустить тесты использовать команду:
```
mvn clean test
```
* Чтобы запустить отчет allure:
```
mvn allure:serve
```
 

