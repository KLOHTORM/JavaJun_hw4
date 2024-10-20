package org;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class Main {
    public static void main(String[] args) {
        // Создаем объект SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .buildSessionFactory();

        // Создаем новую сессию
        Session session = factory.getCurrentSession();

        try {
            // Создаем новый объект Person
            Person person = new Person("Alice", 30);

            // Начинаем транзакцию
            session.beginTransaction();

            // Сохраняем объект
            session.save(person);

            // Завершаем транзакцию
            session.getTransaction().commit();

            System.out.println("Person saved: " + person);
        } finally {
            session.close();
            factory.close();
        }
    }
}
