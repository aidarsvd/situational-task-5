package kg.alatoo.weatherwatch.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(
        name = "ww_users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"username"})
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, unique = true)
    String username;
    @Column(nullable = false)
    String name;

    String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "ww_users_authorities",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id")
    )
    List<UserAuthorityEntity> authorities;

    LocalDateTime createdAt;

    @PrePersist
    private void init() {
        this.createdAt = LocalDateTime.now();
    }

}