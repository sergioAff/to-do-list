package com.example.to_do_list.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
  private String title;
  private String description;
  private LocalDateTime createdAt;
  private Boolean isCompleted;
  private List<User> collaborators;
  private User author;
}
