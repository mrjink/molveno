package com.molvenolakeresort.models.restaurant.temp;


import com.molvenolakeresort.repositories.restaurant.RestaurantReservationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class SampleDatabase {

    @Bean
    CommandLineRunner initDatabase(RestaurantReservationRepository repository)
    {
        return args -> {
            //dummy data.
//            User user1 = new User(1, "Pietje van Hout", "06-72387495", "pvanhout@gmail.com");
//            User user2 = new User(1, "Henk van Dijk", "06-04305982", "henkie94@outlook.com");

//            Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
//            Time time = new Time(20000000);
//            repository.save(new RestaurantReservation(user1, date, time, Course.NONE));
//            repository.save(new RestaurantReservation(user2, date, time, Course.FIVE));
        };
    }

}
