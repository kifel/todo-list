package br.com.kifel.todolist.user;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.kifel.todolist.task.TaskModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;


@Data
@Entity(name = "tb_users")
public class UserModel {

  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

  @Column(unique = true)
  private String username;

  private String name;
  
  private String password;

  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
  @JsonBackReference
  private List<TaskModel> tasks;

  @CreationTimestamp
  private LocalDateTime createdAt;

}
