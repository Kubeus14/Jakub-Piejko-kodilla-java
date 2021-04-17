package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/task")
@RequiredArgsConstructor
public class TaskController {

        private final DbService service;
        private final TaskMapper taskMapper;




        @RequestMapping(method = RequestMethod.GET, value = "getTasks")
        public List<TaskDto> getTasks() {
                List<Task> tasks = service.getAllTasks();
                return taskMapper.mapToTaskDtoList(tasks);
        }
        @RequestMapping(method = RequestMethod.GET, value = "getTaskById")
        public TaskDto getTaskById(Long taskId) {
                return new TaskDto((long) 1, "test title", "test content");
        }


        @RequestMapping(method = RequestMethod.POST, value = "createTask", consumes = MediaType.APPLICATION_JSON_VALUE)
        public void createTask(@RequestBody TaskDto taskDto) {
                Task task = taskMapper.mapToTask(taskDto);
                service.saveTask(task);
        }
        @RequestMapping(method = RequestMethod.GET, value = "getTask")
        public TaskDto getTask(@RequestParam Long taskId) throws TaskNotFoundException {
                return taskMapper.mapToTaskDto(
                        service.getTask(taskId).orElseThrow(TaskNotFoundException::new)
                );
        }
        @RequestMapping(method = RequestMethod.PUT, value = "updateTask")
        public TaskDto updateTask(@RequestBody TaskDto taskDto) {
                Task task = taskMapper.mapToTask(taskDto);
                Task savedTask = service.saveTask(task);
                return taskMapper.mapToTaskDto(savedTask);
        }
        @RequestMapping(method = RequestMethod.DELETE, value = "deleteTaskByID")
        public void deleteTaskBYID( @RequestParam Long taskId) throws TaskNotFoundException {

                if (service.getTask(taskId).isPresent())
                        service.deleteTaskByID(taskId);
                else
                        throw new TaskNotFoundException();
        }

}


