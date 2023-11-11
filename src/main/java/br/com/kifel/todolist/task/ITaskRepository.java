package br.com.kifel.todolist.task;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.kifel.todolist.user.UserModel;

public interface ITaskRepository extends JpaRepository <TaskModel, UUID>{
  List<TaskModel> findByUser(UserModel user);
  TaskModel findByIdAndUser(UUID id, UserModel user);
}
