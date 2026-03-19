# CRC Cards Explanation

TaskManager collaborates with Task because it is responsible for managing and organizing multiple Task objects. It uses Task methods such as getTaskId(), getStatus(), and setStatus() to add, search, and filter tasks.

Task does not collaborate with TaskManager because it represents a single task with its own data and behavior. It does not need to know how tasks are managed globally, which supports separation of concerns and good object-oriented design.