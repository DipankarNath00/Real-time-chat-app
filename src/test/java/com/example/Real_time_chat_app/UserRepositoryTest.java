package com.example.Real_time_chat_app;

import com.example.Real_time_chat_app.Entity.User;
import com.example.Real_time_chat_app.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat; // Use this for better readability

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    void testSaveUser() {
        // Given: A new user object
        User user = new User();
        user.setUsername("Luffy");
        user.setDisplayName("King of the pirates"); // Corrected typo
        user.setEmail("luffy@pirates.com");
        user.setHashPassword("sfgusfuvbufuvusu");

        // When: Saving the user through the repository
        User savedUser = userRepository.save(user);

        // Then: Verify the user was saved and has an ID
        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getId()).isNotNull();
        assertThat(savedUser.getUsername()).isEqualTo("Luffy");
        // You can add more assertions here, e.g., to verify other fields
        assertThat(savedUser.getDisplayName()).isEqualTo("King of the pirates");
    }

    @Test
    void testFindByUsername() {
        // Given: A user exists in the database
        User user = new User();
        user.setUsername("Zoro");
        user.setDisplayName("Pirate Hunter");
        user.setEmail("zoro@pirates.com");
        user.setHashPassword("secretpass");
        entityManager.persist(user); // Use TestEntityManager to set up data
        entityManager.flush(); // Ensure it's written to DB before finding

        // When: Finding the user by username using the repository
        Optional<User> foundUserOptional = userRepository.findByUsername("Zoro");

        // Then: Verify the user was found and has correct details
        assertThat(foundUserOptional).isPresent(); // Check if Optional contains a value
        User foundUser = foundUserOptional.get(); // Get the user from Optional
        assertThat(foundUser.getUsername()).isEqualTo("Zoro");
        assertThat(foundUser.getDisplayName()).isEqualTo("Pirate Hunter");
    }

    @Test
    void testFindByUsername_NotFound() {
        // When: Trying to find a user that does not exist
        Optional<User> foundUserOptional = userRepository.findByUsername("Sanji");
        // Then: Verify no user was found
        assertThat(foundUserOptional).isEmpty(); // Check if Optional is empty
    }
}